-- ���ڷ�װ��ɫ��ϣ��Ϊֻ�����õ���
clsDataActors = {}
clsDataActors.__index = clsDataActors
clsDataActors.__newindex = function (t,k,v) end
-- ������
function clsDataActors:new(t)
	for k,v in pairs(t) do
		clsGameActors[k] = v
	end
	local self = {}
	setmetatable(self,clsDataActors)
	return self
end