-- ���˶����еĵ����࣬������clsEnemyTroop���ڲ�ʹ��
clsTroopEnemy = {}
clsTroopEnemy.__index = clsTroopEnemy
-- ������
function clsTroopEnemy:new()
  local self = {}
  setmetatable(self,clsTroopEnemy)
  self.EnemyIndex = -1 -- ���˱��
  self.x = -1 -- ���x����
  self.y = -1 -- ���y����
  return self
end
