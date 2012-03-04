--[[
  description:列表
  author:wp_g4
  date:2011/12/16
--]]

--TODO 尚有BUG，没有检测相同元素和nil

--结构定义
clsList = {}
clsList.__index = clsList


--构造器
function clsList:new()
	local self = {}
	setmetatable(self,clsList)
	return self
end

--add方法
function clsList:add(value)
  table.insert(self,value)
end

--insert方法
function clsList:insert(index,value)
  table.insert(self,index,value)
end

--get方法
function clsList:get(index)
  return self[index]
end

--remove方法
function clsList:remove(index)
  table.remove(self,index)
end

--remove方法
function clsList:removeObject(obj)
  local index=0
  for i,v in ipairs(self) do
    if v==obj then
      index=i
      break
    end
  end
  if index>0 and index<=self:size() then
    self:remove(index)
  end
end

--clear方法
function clsList:clear()
  for i=1,self:size() do
    table.remove(self)
  end
end

--has方法
function clsList:has(obj)
  local status=false;
  for _,v in ipairs(self) do
    if v==obj then
      status = true
      break
    end
  end
  return status
end

--size方法
function clsList:size()
  return table.getn(self)
end


--单元测试
local debug=false
if debug then
  local l1=clsList:new()
  print(l1:size())  --0
  l1:add("one")
  l1:add({})
  l1:add("three")
  print(l1:size())  --3
  print(l1:get(1))  --one
  l1:remove(2)
  print(l1:get(2))  --three
  l1:insert(2,"two")
  print(l1:get(2))  --two
  print("------------------")
  l1:removeObject("one")
  local t={123,28,name="good"}
  l1:add(t)
  l1:add(t)
  print(l1:size())  --4
  print(l1:get(3))  --table
  print(l1:get(4))  --table
  l1:removeObject(t)
  print(l1:get(3))  --table
  print(l1:size())  --3
  l1:clear()
  print(l1:size())  --0
  l1:add(1)
  l1:add("")
  print(l1:size())  --2
end

if debug then
local l=clsList:new()
l:add({id=12})
l:add({id=1})
l:add({id=2})
l:add({id=8})
l:add({id=-1})
for i=1,l:size() do
  print(l:get(i).id)
end
print("----------------------")
table.sort(l,function(a,b) return a.id<b.id end)

for i=1,l:size() do
  print(l:get(i).id)
end
end

