-- ְҵ��������
clsVocation = {}
clsVocation.__index = clsVocation
-- ������
function clsVocation:new()
  local self = {}
  setmetatable(self,clsVocation)
  self.index = 0
  self.name = ""
  self.equipList = {}
  self.itemList = {}
  self.skillList = {}
  self.attributes = {}
  self.buffs = {}
  return self
end
-- ��һЩĬ��ֵ��ֵ
function clsVocation:setup()
  self.twoSwordsStyle = (self.attributes[const.TWO_SWORDS_STYLE] ~= nil)
  self.fixEquipment = (self.attributes[const.FIX_EQUIPMENT] ~= nil)
  self.autoBattle = (self.attributes[const.AUTO_BATTLE] ~= nil)
  self.superGuard = (self.attributes[const.SUPER_GUARD] ~= nil)
  self.pharmacology = (self.attributes[const.PHARMACOLOGY] ~= nil)
  self.criticalBonus = (self.attributes[const.CRITICAL_BONUS] ~= nil)
end
