-- ���ݿ�ϵͳѡ��ҳ�������࣬������clsSystem���ڲ�ʹ��
clsSystemAttribute = {}
clsSystemAttribute.__index = clsSystemAttribute
-- ������
function clsSystemAttribute:new()
  local self = {}
  setmetatable(self,clsSystemAttribute)
  self.index = 0
  self.name = ""
  self.desc = ""
  return self
end
