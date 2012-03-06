--[[
  description:NPC类
  author:wp_g4
  date:2012/02/09
--]]

--结构定义
clsNPC = {}
setmetatable(clsNPC,clsCharacter)
clsNPC.__index = clsNPC


--重定向需要覆盖的父类方法
clsNPC.updateFF=clsNPC.update

--字段定义
clsNPC.moveType=0            --移动规则                       0 固定	1 随机	2 接近
clsNPC.speedLevel=1          --移动速度级别                1 慢	    2 中    	3 快
clsNPC.penetrable=true       --是否可穿透
clsNPC.penetrable=true       --是否可穿透    

--构造器
function clsNPC:new()
  local self = clsCharacter:new()
  setmetatable(self,clsNPC)
  return self
end

--更新[NPC更新] 
function clsNPC:update()
  --调用父类的update方法
  self:updateFF()
  --自动行走
  if self.moveType~=0 then
    --NPC类型非固定
    if self.curMoveDirection==nil then
      --当前没有行走
      if smRandom:nextInt(20/self.speedLevel)==0 then
        --TODO  此处应该判断是否可以行走
        self.moveSequence:offer(smRandom:nextInt(4))
      end
    end
  end
  --TODO 其它更新
  
end

