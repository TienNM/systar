--[[
  description:层。所有组件的父类
  author:wp_g4
  date:2011/12/16
--]]

--类结构定义
clsUILayer={}
clsUILayer.__index=clsUILayer

--字段
clsUILayer.x=0                               --x坐标
clsUILayer.y=0                               --y坐标
clsUILayer.z=0                               --z坐标
clsUILayer.width=0                           --宽度
clsUILayer.height=0                          --高度
clsUILayer.tag=0                             --标志（可选）
clsUILayer.arg=nil                           --参数（可选）
clsUILayer.backgroundColor=nil               --背景色
clsUILayer.backgroundImage = null;           --背景图
clsUILayer.visibility = true;                --是否可见
clsUILayer.enabled = true;                   --是否接收事件
clsUILayer.clipBounds=true;                  --是否裁剪区域
clsUILayer.delegate=nil                      --事件委托
clsUILayer.parent=nil                        --父layer
clsUILayer.children=nil                      --子layer
clsUILayer.focusLayer=nil                    --当前事件焦点子layer
clsUILayer.bufferedMode=false                --是否开启缓冲 TODO 功能尚未实现

--构造器
function clsUILayer:new(x,y,width,height)
  local self = {}
  setmetatable(self,clsUILayer)
  self.x=x
  self.y=y
  self.width=width
  self.height=height
  self.children=clsList:new()
  return self
end

--添加子Layer
function clsUILayer:addChild(layer)
  self.children:add(layer)
  layer.parent=self
  self:sortChildren()
end

--子Layer排序
function clsUILayer:sortChildren()
  table.sort(self.children,function(a,b) return a.z<b.z end)
end

--根据序号获取子layer
function clsUILayer:getChild(index)
  return self.children:get(index)
end

--根据tag获取子layer
function clsUILayer:childWithTag(tag)
  local child=nil;
  for _,v in ipairs(self.children) do
    if v.tag==tag then
      child=v
    end
  end
  return child
end


--移除子Layer
function clsUILayer:remove(index)
  self:getChild(index).parent=nil
  self.children:remove(index)
end

--移除子Layer
function clsUILayer:removeChild(layer)
  layer.parent=nil
  self.children:removeObject(layer)
end

--移除所有子Layer
function clsUILayer:clear()
  for i=1,self.children:size() do
    self:getChild(i).parent=nil
  end
  self.children:clear()
end

--改变z值
function clsUILayer:changeZ(z)
  self.z=z
  self.parent:sortChildren()
end

--绘制Layer（lua层不应该调用此方法）
function clsUILayer:paint(painter)
  --绘制自身
  self:paintLayer(painter)
  --绘制子Layer
  self:paintChildren(painter)
end

--绘制自身（lua层不应该调用此方法）
function clsUILayer:paintLayer(painter)
  if self.backgroundColor then
    painter:setColor(self.backgroundColor);
    painter:fillRect(0, 0, self.width, self.height);
  end
  if self.backgroundImage then
    painter:drawImage(self.backgroundImage, 0, 0, 0);
  end
end

--绘制子Layer（lua层不应该调用此方法）
function clsUILayer:paintChildren(painter)
  for _,layer in ipairs(self.children) do
    --smLog:info(layer:toString())
    if layer.visibility then
      --设置坐标系
      painter:setBasePoint(layer.x,layer.y)
      --设置裁剪区
      local clip=nil;
      if layer.clipBounds then
        clip=painter:getClip()
        painter:clipRect(0,0,layer.width,layer.height)
      end
      --绘制子Layer
      layer:paint(painter)
      --还原裁剪区
      if layer.clipBounds then
        painter:forceClip(clip)
      end
      --还原坐标系
      painter:setBasePoint(-layer.x,-layer.y)
    end
  end
      
end

--处理触屏事件（lua层不应该调用此方法）
function clsUILayer:onTouch(x,y,type)
  if self.delegate then
    self.delegate:layerTapped(self,x,y,type)
    return true   --为简化delegate的编写，此处永远返回true，即只要有delegate处理事件则认为事件处理完成
  else
    return false
  end
end

--事件分发（lua层不应该调用此方法）
function clsUILayer:dispatchEvent(x,y,type)
  local status=false
  if type==globalUIConst.touchEventType.DOWN then
    --如果是DOWN事件，则从子组件中寻找焦点组件
    self.focusLayer = self:searchFocusLayer(x,y)
  end
  if self.focusLayer then
    --找到焦点组件或者焦点被清除
    status=self.focusLayer:dispatchEvent(x-self.focusLayer.x,y-self.focusLayer.y,type)
    if not status then
      --如果事件未完全处理
      self.focusLayer = nil
      status=self:onTouch(x,y,type)
    end
  else
    --未找到焦点组件或者焦点已清除
    status=self:onTouch(x,y,type)
  end
  if type==globalUIConst.touchEventType.UP then
    --如果是UP事件，则清除焦点
    self.focusLayer = nil
  end
  return status
end

--通知更新界面。在缓冲模式下此方法用于通知Layer更新显示内容
function clsUILayer:notifyRefresh()
  --TODO 尚未实现
end

--toString
function clsUILayer:toString()
  local str="clsUILayer:["
  str=str.."x="..self.x.." y="..self.y.." w="..self.width.." h="..self.height
  str=str.."]"
  return str
end

--搜索焦点子组件，没有则返回nil（lua层不应该调用此方法）
function clsUILayer:searchFocusLayer(x,y)
  local focus = nil;
  --从上到下依次探查
  for i=self.children:size(),1,-1 do
    local layer=self.children:get(i)
    if layer.visibility and layer.enabled then
      --子Layer可见并且可以接收事件
      if x >= layer.x and x <= layer.x + layer.width and y >= layer.y and y <= layer.y + layer.height then
        --命中
        focus = layer;
        break;
      end
    end
  end
  return focus
end
