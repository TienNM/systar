-- ���˻�������Ʒ�������ڵ����������ڲ�ʹ��
clsEnemyTreasure = {}
clsEnemyTreasure.__index = clsEnemyTreasure
-- ������
function clsEnemyTreasure:new()
  local self = {}
  setmetatable(self,clsEnemyTreasure)
  self.index = -1
  self.type = -1
  self.rate = 0
  return self
end
