-- ���ڷ�װ��Ʒ��ϣ��Ϊֻ�������
clsDataItems = {}
clsDataItems.__index = clsDataItems
clsDataItems.__newindex = function (t,k,v) end
-- ������
function clsDataItems:new(t)
	for k,v in pairs(t) do
		clsDataItems[k] = v
	end
	local self = {}
	setmetatable(self,clsDataItems)
	return self
end