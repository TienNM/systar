--[[
  description:地图场景
  author:wp_g4
  date:2011/12/18
--]]

--结构定义
clsSceneMap = {}
setmetatable(clsSceneMap,clsScene)
clsSceneMap.__index = clsSceneMap

--字段
clsSceneMap.curMap=nil         --当前地图
clsSceneMap.curPlayer=nil      --当前player
clsSceneMap.characterList=nil  --精灵列表
clsSceneMap.mapBgLayer=nil     --背景
clsSceneMap.mapFgLayer=nil     --前景
clsSceneMap.spriteLayer=nil    --精灵层

--test
clsSceneMap.playerSprite=nil;

--构造器
function clsSceneMap:new()
	local self = clsScene:new()
	setmetatable(self,clsSceneMap)
	self.characterList=clsList:new()
	return self
end

-- 开始
function clsSceneMap:onStart()
  smLog:info("地图场景启动")
  smAudioPlayer:play("game/audio/music/my_love.mp3")
  self.curPlayer=globalData.playerTroop:curDisplayPlayer()
  local curMap=globalDictionary:getMap(self.curPlayer.mapId)
  if self.curMap~=curMap then
    --切换地图
    self:changeMap(curMap)
  end
end

-- 更新
function clsSceneMap:update()
  --smLog:info("地图场景更新")
  local viewport=self:checkViewport()
  self.mapBgLayer:trackViewport(viewport)
  self.mapFgLayer:trackViewport(viewport)
  local px,py=self:calculatePlayerLocation()
  self.playerSprite.x,self.playerSprite.y=px-viewport.x,py-viewport.y
end

-- 退出
function clsSceneMap:onStop()
  smLog:info("地图场景退出")
  smAudioPlayer:stop()
end

function clsSceneMap:changeMap(map)
  self.curMap=map
  --清除所有layer
  globalGame.rootLayer:removeAll()
  --加载地图图集
  for _,v in pairs(self.curMap.tilesets) do
    if globalData.map.imageSets[v.id]==nil then
      globalData.map.imageSets[v.id]=smImageFactory:createImage(globalGame.PATH..v.path)
    end
  end
  --加载背景
  local bgLayers=clsList:new()
  for i=1,table.getn(self.curMap.layers) do
    local layer=self.curMap.layers[i]
    if layer.deepth<0 then
      bgLayers:add(layer)
    end
  end
  self.mapBgLayer=clsTiledMapLayer:new(0,0,smGameEngine:getWidth(),smGameEngine:getHeight())
  local viewport=self:checkViewport()
  local params={layers=bgLayers,colNum=self.curMap.colNum,rowNum=self.curMap.rowNum,
     cellWidth=self.curMap.cellWidth,cellHeight=self.curMap.cellHeight,viewport=viewport}
  self.mapBgLayer:init(params)
  globalGame.rootLayer:addChild(self.mapBgLayer)
  --加载精灵层
  self.spriteLayer=clsUILayer:new(0,0,smGameEngine:getWidth(),smGameEngine:getHeight())
  self.playerSprite=clsUISprite:new(self.curPlayer.headImage)
  local px,py=self:calculatePlayerLocation()
  self.playerSprite.x,self.playerSprite.y=px-viewport.x,py-viewport.y
  self.spriteLayer:addChild(self.playerSprite)
  globalGame.rootLayer:addChild(self.spriteLayer)
  --加载前景
  local fgLayers=clsList:new()
  for i=1,table.getn(self.curMap.layers) do
    local layer=self.curMap.layers[i]
    if layer.deepth>0 then
      fgLayers:add(layer)
    end
  end
  self.mapFgLayer=clsTiledMapLayer:new(0,0,smGameEngine:getWidth(),smGameEngine:getHeight())
  local params={layers=fgLayers,colNum=self.curMap.colNum,rowNum=self.curMap.rowNum,
     cellWidth=self.curMap.cellWidth,cellHeight=self.curMap.cellHeight,viewport=viewport}
  self.mapFgLayer:init(params)
  globalGame.rootLayer:addChild(self.mapFgLayer)
end

--计算viewport
function clsSceneMap:checkViewport()
  local px,py=self:calculatePlayerLocation()
  local width=smGameEngine:getWidth()
  local height=smGameEngine:getHeight()
  local vx=px-width/2
  local vy=py-height/2
  if vx<0 then
    vx=0
  end
  if vx>self.curMap.colNum*self.curMap.cellWidth-width then
    vx=self.curMap.colNum*self.curMap.cellWidth-width
  end
  if vy<0 then
    vy=0
  end
  if vy>self.curMap.rowNum*self.curMap.cellHeight-height then
    vy=self.curMap.rowNum*self.curMap.cellHeight-height
  end
  return {x=vx,y=vy,width=width,height=height}
end

--计算player当前物理坐标(player所在单元格正中心坐标)
function clsSceneMap:calculatePlayerLocation()
  local px=self.curPlayer.col*self.curMap.cellWidth+self.curMap.cellWidth/2
  local py=self.curPlayer.row*self.curMap.cellHeight+self.curMap.cellHeight/2
  --根据player当前面向和行走状态进行位置修正
  if self.curPlayer.face==0 then
    --上
    py=py-self.curMap.cellHeight/4*self.curPlayer.step
  elseif self.curPlayer.face==1 then
    --下
    py=py+self.curMap.cellHeight/4*self.curPlayer.step
  elseif self.curPlayer.face==2 then
    --左
    py=py-self.curMap.cellWidth/4*self.curPlayer.step
  elseif self.curPlayer.face==3 then
    --右
    py=py+self.curMap.cellWidth/4*self.curPlayer.step
  end
  return px,py
end