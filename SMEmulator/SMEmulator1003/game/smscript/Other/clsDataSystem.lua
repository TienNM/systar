-- ���ڷ�װϵͳΪֻ�������
clsDataSystem = {}
clsDataSystem.__index = clsDataSystem
clsDataSystem.__newindex = function (t,k,v) end
-- ������
function clsDataSystem:new(t)
	for k,v in pairs(t) do
		clsDataSystem[k] = v
	end
	local self = {}
	setmetatable(self,clsDataSystem)
	return self
end