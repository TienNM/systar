--[[
  description:数据加载工具
  author:wp_g4
  date:2011/12/8
--]]

smDataLoader={}

--初始化数据字典
globalDictionary={maps={},npcs={}}

--定义文件路径
smDataLoader.vocationPath=".\\game\\data\\vocation.gat";
smDataLoader.playerPath=".\\game\\data\\player.gat";
smDataLoader.skillPath=".\\game\\data\\skill.gat";
smDataLoader.itemPath=".\\game\\data\\item.gat";
smDataLoader.equipPath=".\\game\\data\\equip.gat";
smDataLoader.enemyPath=".\\game\\data\\enemy.gat";
smDataLoader.enemyTroopPath=".\\game\\data\\enemyTroop.gat";
smDataLoader.statusPath=".\\game\\data\\status.gat";
smDataLoader.mapPath=".\\game\\data\\map\\map{index}.gat";
smDataLoader.npcPath=".\\game\\data\\npc{index}.gat";
smDataLoader.animationPath=".\\game\\data\\animation.gat";
smDataLoader.configPath=".\\game\\data\\config.gat";

--初始化
function smDataLoader:init()
  --(1)加载Config信息
  self:loadConfig()
  --(2)加载Vocation信息
  self:loadVocation()
  --(3)加载Player信息
  self:loadPlayer()
  --(4)加载Skill信息
  self:loadSkill()
  --(5)加载Item信息
  self:loadItem()
  --(6)加载Equip信息
  self:loadEquip()
  --(7)加载Enemy信息
  self:loadEnemy()
  --(8)加载EnemyTroop信息
  self:loadEnemyTroop()
  --(9)加载Status信息
  self:loadStatus()
  --(10)加载Animation信息
  self:loadAnimation()
  --(11)初始化皮肤
  smSkin:init(globalGame.PATH..globalDictionary.config.skin)
end

--加载Config数据
function smDataLoader:loadConfig()
  dofile(self.configPath)
end

--加载Vocation数据
function smDataLoader:loadVocation()
  dofile(self.vocationPath)
end

--加载Player数据
function smDataLoader:loadPlayer()
  dofile(self.playerPath)
end

--加载Skill数据
function smDataLoader:loadSkill()
  dofile(self.skillPath)
end

--加载Item数据
function smDataLoader:loadItem()
  dofile(self.itemPath)
end

--加载Equip数据
function smDataLoader:loadEquip()
  dofile(self.equipPath)
end

--加载Enemy数据
function smDataLoader:loadEnemy()
  dofile(self.enemyPath)
end

--加载EnemyTroop数据
function smDataLoader:loadEnemyTroop()
  dofile(self.enemyTroopPath)
end

--加载Status数据
function smDataLoader:loadStatus()
  dofile(self.statusPath)
end

--加载Animation数据
function smDataLoader:loadAnimation()
  dofile(self.animationPath)
end

--加载Map数据
function smDataLoader:loadMap(id)
  local t=os.time()
  local path=string.gsub(self.mapPath,"{index}",id)
  dofile(path)
  t=os.time()-t
  smLog:info("加载地图["..id.."]耗时:"..t.."ms")
end

function smDataLoader:loadNPC(id)
  local t=os.time()
  local path=string.gsub(self.npcPath,"{index}",id)
  dofile(path)
  t=os.time()-t
  smLog:info("加载NPC["..id.."]耗时:"..t.."ms")
end

function globalDictionary:getMap(id)
  if self.maps[id]==nil then
    smDataLoader:loadMap(id)
  end
  return self.maps[id]
end

function globalDictionary:getNPC(id)
  if self.npcs[id]==nil then
    smDataLoader:loadNPC(id)
  end
  return self.npcs[id]
end