-- ���˻�ʹ�õĶ����������ڵ�����������ʹ��
clsEnemyAction = {}
clsEnemyAction.__index = clsEnemyAction
-- ������
function clsEnemyAction:new()
  local self = {}
  setmetatable(self,clsEnemyAction)
  self.conditions = {}
  self.actionType = -1
  self.paramList = {}
  self.rate = 0
  return self
end
