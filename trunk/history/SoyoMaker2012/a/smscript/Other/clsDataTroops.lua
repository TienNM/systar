-- ���ڷ�װ���˶����ϣ��Ϊֻ�������
clsDataTroops = {}
clsDataTroops.__index = clsDataTroops
clsDataTroops.__newindex = function (t,k,v) end
-- ������
function clsDataTroops:new(t)
	for k,v in pairs(t) do
		clsDataTroops[k] = v
	end
	local self = {}
	setmetatable(self,clsDataTroops)
	return self
end