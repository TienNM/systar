-- ����װ���࣬�����ڵ����������ڲ�ʹ��
clsEnemyEquip = {}
clsEnemyEquip.__index = clsEnemyEquip
-- ������
function clsEnemyEquip:new()
  local self = {}
  setmetatable(self,clsEnemyEquip)
  self.equipIndex = -1
  self.kind = -1
  self.rate = 0
  return self
end
