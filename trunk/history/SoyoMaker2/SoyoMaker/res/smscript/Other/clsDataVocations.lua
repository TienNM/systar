-- ���ڷ�װְҵ��ϣ��Ϊֻ�������
clsDataVocations = {}
clsDataVocations.__index = clsDataVocations
clsDataVocations.__newindex = function (t,k,v) end
-- ������
function clsDataVocations:new(t)
	for k,v in pairs(t) do
		clsDataVocations[k] = v
	end
	local self = {}
	setmetatable(self,clsDataVocations)
	return self
end