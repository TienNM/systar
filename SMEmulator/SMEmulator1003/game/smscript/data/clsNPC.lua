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
  if self.curMoveDirection==nil then
    --当前没有行走
    if smRandom:nextInt(20/self.speedLevel)==0 then
      if self.moveType ==1 then
        --随机
        self.moveSequence:offer(smRandom:nextInt(4))
      elseif self.moveType ==2 then
      --靠近
        if self.moveDelegate then
          local row,col=self.moveDelegate:curPlayerLocation()
          local offsetRow,offsetCol=row-self.row,col-self.col
          if offsetRow<0 then
            --上
            self.moveSequence:offer(0)
          elseif offsetRow>0 then
            --下
            self.moveSequence:offer(1)
          else
            if offsetCol<0 then
              --左
              self.moveSequence:offer(2)
            elseif offsetCol>0 then
              --右
              self.moveSequence:offer(3)
            end
          end
        end
      end
    end
  end
  --TODO 其它更新
  
end

