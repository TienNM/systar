-- ���ڷ�װװ����ϣ��Ϊֻ�������
clsDataEquips = {}
clsDataEquips.__index = clsDataEquips
clsDataEquips.__newindex = function (t,k,v) end
-- ������
function clsDataEquips:new(t)
	for k,v in pairs(t) do
		clsDataEquips[k] = v
	end
	local self = {}
	setmetatable(self,clsDataEquips)
	return self
end