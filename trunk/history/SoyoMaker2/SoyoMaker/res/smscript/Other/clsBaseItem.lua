-- ���ܡ���Ʒ�������ͷ��ߵĳ���
clsBaseItem = {}
clsBaseItem.__index = clsBaseItem
-- ������
function clsBaseItem:new()
  local self = {}
  setmetatable(self,clsBaseItem)
  self.index = 0
  self.name = ""
  self.icon = 0
  self.intro = ""
  self.lev = 0
  return self
end
