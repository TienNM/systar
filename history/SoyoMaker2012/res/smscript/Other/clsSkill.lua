-- ���ܵ�������
clsSkill = {}
setmetatable(clsSkill,clsUsableItem)
clsSkill.__index = clsSkill
-- ������
function clsSkill:new()
  local self = {}
  self = clsUsableItem:new()
  self.setupf = self.setup
  setmetatable(self,clsSkill)
  self.target = 3
  return self
end
-- ��һЩĬ�ϵ����Ը�ֵ
function clsSkill:setup()
  self:setupf()
  self.spCost = self.costs[const.SKILL_COST_SP]
  self.hit = self.factors[const.SKILL_FACTOR_HIT]
end
