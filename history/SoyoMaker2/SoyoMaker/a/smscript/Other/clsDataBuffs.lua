-- ���ڷ�װ״̬��ϣ��Ϊֻ�������
clsDataBuffs = {}
clsDataBuffs.__index = clsDataBuffs
clsDataBuffs.__newindex = function (t,k,v) end
-- ������
function clsDataBuffs:new(t)
	for k,v in pairs(t) do
		clsDataBuffs[k] = v
	end
	local self = {}
	setmetatable(self,clsDataBuffs)
	return self
end