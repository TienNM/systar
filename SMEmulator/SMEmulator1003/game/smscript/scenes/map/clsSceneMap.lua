--[[
  description:地图场景
  author:wp_g4
  date:2011/12/18
--]]

--结构定义
clsSceneMap = {}
setmetatable(clsSceneMap,clsScene)
clsSceneMap.__index = clsSceneMap

--常量
clsSceneMap.Tag={}
clsSceneMap.Tag.BUTTON_HEAD=100  --头像按钮
clsSceneMap.Tag.BAR_HP=101       --HP条
clsSceneMap.Tag.BAR_SP=102       --SP条

--字段
clsSceneMap.curPlayer=nil      --当前player
clsSceneMap.mapBgLayer=nil     --背景
clsSceneMap.mapFgLayer=nil     --前景
clsSceneMap.spriteLayer=nil    --精灵层
clsSceneMap.layerHead=nil      --头像层
clsSceneMap.aStar=nil          --A*寻路工具

--构造器
function clsSceneMap:new()
	local self = clsScene:new()
	setmetatable(self,clsSceneMap)
	--背景实例化
	self.mapBgLayer=clsTiledMapLayer:new(0,0,smGameEngine:getWidth(),smGameEngine:getHeight())
    self.mapBgLayer.delegate=self
    globalGame.rootLayer:addChild(self.mapBgLayer)
    --精灵层实例化
    self.spriteLayer=clsUILayer:new(0,0,smGameEngine:getWidth(),smGameEngine:getHeight())
    self.spriteLayer.enabled=false
    globalGame.rootLayer:addChild(self.spriteLayer)
    --前景实例化
    self.mapFgLayer=clsTiledMapLayer:new(0,0,smGameEngine:getWidth(),smGameEngine:getHeight())
    self.mapFgLayer.enabled=false
    globalGame.rootLayer:addChild(self.mapFgLayer)
    --头像层实例化
    self.layerHead=clsUILayer:new(0,0,64,80)
      --头像按钮
      local buttonHead=clsUIButton:new(0,0,64,64)
      buttonHead.tag=self.Tag.BUTTON_HEAD
      self.layerHead:addChild(buttonHead)
      --HP背景
      local layerHPbg=clsUILayer:new(0,64,64,8)
      layerHPbg.backgroundColor=globalSkin:getTextColor(1,3)
      self.layerHead:addChild(layerHPbg)
      --HP
      local layerHP=clsUILayer:new(0,64,48,8)
      layerHP.backgroundColor=globalSkin:getTextColor(2,3)
      layerHP.tag=self.Tag.BAR_HP
      self.layerHead:addChild(layerHP)
      --SP背景
      local layerSPbg=clsUILayer:new(0,72,64,8)
      layerSPbg.backgroundColor=globalSkin:getTextColor(1,2)
      self.layerHead:addChild(layerSPbg)
      --SP
      local layerSP=clsUILayer:new(0,72,58,8)
      layerSP.backgroundColor=globalSkin:getTextColor(2,2)
      layerSP.tag=self.Tag.BAR_SP
      self.layerHead:addChild(layerSP)
      globalGame.rootLayer:addChild(self.layerHead)
	return self
end

-- 开始
function clsSceneMap:onStart()
  smLog:info("地图场景启动")
  --注册接收通知
  globalNotifier:addObserver(globalConst.NotifyCMD.Character.MOVED,self,self.characterMoved)
  self.curPlayer=globalData.playerTroop:curDisplayPlayer()
  local curMap=globalDictionary:getMap(self.curPlayer.mapId)
  if globalData.curMap~=curMap then
    --切换地图
    self:changeMap(curMap)
  end
  local buttonHead=self.layerHead:childWithTag(self.Tag.BUTTON_HEAD)
  buttonHead.normalImage=self.curPlayer.headImage
  buttonHead.highlightImage=self.curPlayer.headImage:tone(1,1,0)
end

-- 更新
function clsSceneMap:update()
  
end

-- 退出
function clsSceneMap:onStop()
  smLog:info("地图场景退出")
  smAudioPlayer:stop()
end

--切换地图
function clsSceneMap:changeMap(map)
  globalData.curMap=map
  self.aStar=clsAStar:new(map.areas)
  --加载地图图集
  for _,v in pairs(globalData.curMap.tilesets) do
    if globalData.imageSets[v.id]==nil then
      globalData.imageSets[v.id]=smImageFactory:createImage(smGameEngine:getGamePath()..v.path)
    end
  end
  --加载背景
  local bgLayers=clsList:new()
  for i=1,table.getn(globalData.curMap.layers) do
    local layer=globalData.curMap.layers[i]
    if layer.deepth<0 then
      bgLayers:add(layer)
    end
  end
  local viewport=self:checkViewport()
  local params={layers=bgLayers,colNum=globalData.curMap.colNum,rowNum=globalData.curMap.rowNum,
     cellWidth=globalData.curMap.cellWidth,cellHeight=globalData.curMap.cellHeight,viewport=viewport}
  self.mapBgLayer:init(params)
  --精灵层移除所有sprite
  self.spriteLayer:clear()
    --玩家
    local playerSprite=clsUISprite:new(self.curPlayer.charImage,
       self.curPlayer.charImage:getWidth()/4,self.curPlayer.charImage:getHeight()/4)
    playerSprite.tag=self.curPlayer.id
    playerSprite.z=self.curPlayer.row
    local px,py=self:calculateCharacterLocation(self.curPlayer)
    px=px-self.curPlayer.charImage:getWidth()/4/2
    py=py+globalData.curMap.cellHeight/2-self.curPlayer.charImage:getHeight()/4
    playerSprite.x,playerSprite.y=px-viewport.x,py-viewport.y
    self.spriteLayer:addChild(playerSprite)
    --NPC
    for k,v in pairs(globalData.curMap.npcs) do
      local npc=globalData:getNPC(v)
      local npcSprite=clsUISprite:new(npc.charImage,
        npc.charImage:getWidth()/4,npc.charImage:getHeight()/4)
      npcSprite.tag=npc.id
      npcSprite.z=npc.row
      local nx,ny=self:calculateCharacterLocation(npc)
      nx=nx-npc.charImage:getWidth()/4/2
      ny=ny+globalData.curMap.cellHeight/2-npc.charImage:getHeight()/4
      npcSprite.x,npcSprite.y=nx-viewport.x,ny-viewport.y
      self.spriteLayer:addChild(npcSprite)
    end
  --加载前景
  local fgLayers=clsList:new()
  for i=1,table.getn(globalData.curMap.layers) do
    local layer=globalData.curMap.layers[i]
    if layer.deepth>0 then
      fgLayers:add(layer)
    end
  end
  if fgLayers:size()>0 then
    self.mapFgLayer.visibility=true
    local params={layers=fgLayers,colNum=globalData.curMap.colNum,rowNum=globalData.curMap.rowNum,
       cellWidth=globalData.curMap.cellWidth,cellHeight=globalData.curMap.cellHeight,viewport=viewport}
    self.mapFgLayer:init(params)
  else
    self.mapFgLayer.visibility=false
  end
end

--地图点击事件
function clsSceneMap:mapTapped(target,row,col)
  smLog:info("逻辑坐标: row="..row.." col="..col)
  --向player发送移动命令
  --(1)清除原有的行走命令
  self.curPlayer.moveSequence:clear()
  --(2)获取寻路起点
  local curRow=self.curPlayer.row
  local curCol=self.curPlayer.col
  --(3)起点修正
  if self.curPlayer.step~=0 then
    --player行走中
    if self.curPlayer.face==0 then
      --上
      curRow=curRow-1
    elseif self.curPlayer.face==1 then
      --下
      curRow=curRow+1
    elseif self.curPlayer.face==2 then
      --左
      curCol=curCol-1
    elseif self.curPlayer.face==3 then
      --右
      curCol=curCol+1
    end
  end
  --(4)寻路
  local directions=self.aStar:searchDirection(curRow+1,curCol+1,row,col)
  --(5)发送行走命令(TODO 可优化)
  while directions:size()>0 do
    local direction=directions:poll()
    self.curPlayer.moveSequence:offer(direction)
  end
end

--计算viewport
function clsSceneMap:checkViewport()
  local px,py=self:calculateCharacterLocation(self.curPlayer)
  local width=smGameEngine:getWidth()
  local height=smGameEngine:getHeight()
  local vx=px-width/2
  local vy=py-height/2
  if vx<0 then
    vx=0
  end
  if vx>globalData.curMap.colNum*globalData.curMap.cellWidth-width then
    vx=globalData.curMap.colNum*globalData.curMap.cellWidth-width
  end
  if vy<0 then
    vy=0
  end
  if vy>globalData.curMap.rowNum*globalData.curMap.cellHeight-height then
    vy=globalData.curMap.rowNum*globalData.curMap.cellHeight-height
  end
  return {x=vx,y=vy,width=width,height=height}
end

--计算characher当前物理坐标(characher所在单元格正中心坐标+行走修正)
function clsSceneMap:calculateCharacterLocation(character)
  local px=character.col*globalData.curMap.cellWidth+globalData.curMap.cellWidth/2
  local py=character.row*globalData.curMap.cellHeight+globalData.curMap.cellHeight/2
  --根据player当前面向和行走状态进行位置修正
  if character.face==0 then
    --上
    py=py-globalData.curMap.cellHeight/4*character.step
  elseif character.face==1 then
    --下
    py=py+globalData.curMap.cellHeight/4*character.step
  elseif character.face==2 then
    --左
    px=px-globalData.curMap.cellWidth/4*character.step
  elseif character.face==3 then
    --右
    px=px+globalData.curMap.cellWidth/4*character.step
  end
  return px,py
end

--============处理通知============
--character移动
function clsSceneMap:characterMoved(param)
  --如果character的行有变化需要修改对应sprite的z值
  if param.rowChanged then
    local sprite=self.spriteLayer:childWithTag(param.character.id)
    sprite:changeZ(param.character.row)
  end
  if param.character==self.curPlayer then
    --玩家移动(检测viewport是否改变)
    local viewport=self:checkViewport()
    local offsetX=viewport.x-self.mapBgLayer.viewport.x
    local offsetY=viewport.y-self.mapBgLayer.viewport.y
    if offsetX~=0 or offsetY~=0 then
      --viewport有变化
      --背景移动
      self.mapBgLayer:trackViewport(viewport)
      --前景移动
      if self.mapFgLayer.visibility then
        self.mapFgLayer:trackViewport(viewport)
      end
      --修正character位置
      if offsetX~=0 then
        --地图水平滚动
        for k,sprite in pairs(self.spriteLayer.children) do
          sprite.x=sprite.x-offsetX
        end
      elseif offsetY~=0 then
        --地图垂直滚动
        for k,sprite in pairs(self.spriteLayer.children) do
          sprite.y=sprite.y-offsetY
        end
      end
    end
  end
  --character移动
  local npcSprite=self.spriteLayer:childWithTag(param.character.id)   if param.direction==0 then
    --上
    npcSprite.y=npcSprite.y-globalData.curMap.cellHeight/4
  elseif param.direction==1 then
    --下
    npcSprite.y=npcSprite.y+globalData.curMap.cellHeight/4
  elseif param.direction==2 then
    --左
    npcSprite.x=npcSprite.x-globalData.curMap.cellWidth/4
  elseif param.direction==3 then
    --右
    npcSprite.x=npcSprite.x+globalData.curMap.cellWidth/4
  end
  npcSprite.frameIndex=param.character:getCurFrameIndex()
end
