-- ���˶���������
clsTroop = {}
clsTroop.__index = clsTroop
-- ������
function clsTroop:new()
  local self = {}
  setmetatable(self,clsTroop)
  self.index = 0
  self.name = ""
  self.enemys = {}  -- ����λ��->�����ڲ���
  self.events = {}
  return self
end
