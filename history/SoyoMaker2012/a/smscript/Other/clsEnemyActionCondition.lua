-- ���˶��������࣬�����ڵ��˶������ڲ�ʹ��
clsEnemyActionCondition = {}
clsEnemyActionCondition.__index = clsEnemyActionCondition
-- ������
function clsEnemyActionCondition:new()
  local self = {}
  setmetatable(self,clsEnemyActionCondition)
  self.conditionType = -1
  self.paramList = {} -- ID����
  return self
end
