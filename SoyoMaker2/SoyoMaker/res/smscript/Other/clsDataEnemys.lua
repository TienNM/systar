-- ���ڷ�װ���˹�ϣ��Ϊֻ�������
clsDataEnemys = {}
clsDataEnemys.__index = clsDataEnemys
clsDataEnemys.__newindex = function (t,k,v) end
-- ������
function clsDataEnemys:new(t)
	for k,v in pairs(t) do
		clsDataEnemys[k] = v
	end
	local self = {}
	setmetatable(self,clsDataEnemys)
	return self
end