-- �����ص��ࡣ�����ʵ����ο�globalGameSwitches
clsGameSwitches = {}
clsGameSwitches.__index = clsGameSwitches
-- ������
function clsGameSwitches:new()
	local self = {}
	setmetatable(self,clsGameSwitches)
	self.reader = {data = {}}
	for i = 1,5000 do
		self.reader.data[i] = false
	end
	return self
end
-- ���ÿ��أ����뿪�ش��ڲ�������ֵΪ������
function clsGameSwitches:set(switchIndex,value)
	if self.reader.data[switchIndex] ~= nil and type(value) == "boolean" then
		self.reader.data[switchIndex] = value
	end
end
-- ��ÿ���ֵ
function clsGameSwitches:get(switchIndex)
	return self.reader.data[switchIndex]
end