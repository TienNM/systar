-- ���ڷ�װ���ܹ�ϣ��Ϊֻ�������
clsDataSkills = {}
clsDataSkills.__index = clsDataSkills
clsDataSkills.__newindex = function (t,k,v) end
-- ������
function clsDataSkills:new(t)
	for k,v in pairs(t) do
		clsDataSkills[k] = v
	end
	local self = {}
	setmetatable(self,clsDataSkills)
	return self
end