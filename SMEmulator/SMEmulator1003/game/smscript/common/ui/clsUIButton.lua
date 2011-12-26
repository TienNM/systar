--[[
  description:按钮。
  author:wp_g4
  date:2011/12/18
--]]

--类结构定义
clsUIButton={}
setmetatable(clsUIButton,clsUILayer)
clsUIButton.__index=clsUIButton

--重定向父类paintLayer(painter)方法
clsUIButton.paintLayerF=clsUIButton.paintLayer

--字段
clsUIButton.STATE_NORMAL=0                       --普通状态
clsUIButton.STATE_HIGHLIGHT=1                    --高亮状态

clsUIButton.text=nil                             --按钮文字
clsUIButton.highlightImage=nil                   --高亮时图片
clsUIButton.normalImage=nil                      --普通时图片
clsUIButton.textColor="0xffffffff"               --文字颜色
clsUIButton.textSize=-1                          --文字大小
clsUIButton.buttonState=clsUIButton.STATE_NORMAL   --按钮状态
clsUIButton.highlightBoundTimes=1.5              --按钮高亮范围倍数

--构造器
function clsUIButton:new(x,y,width,height)
  local self = clsUILayer:new(x,y,width,height)
  setmetatable(self,clsUIButton)
  return self
end

--绘制自身
function clsUIButton:paintLayer(painter)
  --调用父类的paintLayer方法
  self:paintLayerF(painter)
  --绘制图片
  if self.buttonState==clsUIButton.STATE_NORMAL then
    if self.normalImage then
      painter:drawImage(self.normalImage,0,0,smUIConst.anchor.LT)
    end
  elseif self.buttonState==clsUIButton.STATE_HIGHLIGHT then
    if self.highlightImage then
      painter:drawImage(self.highlightImage,0,0,smUIConst.anchor.LT)
    end
  end
  --绘制文字
  painter:setColor(self.textColor)
  if self.textSize > 0 then
    painter:setTextSize(self.textSize)
  end
  if self.text then
    painter:drawString(self.text, self.width/2, self.height/2, smUIConst.anchor.HV)
  end
end

--处理触屏事件（lua层不应该调用此方法）
function clsUIButton:onTouch(x,y,type)
  if type==smUIConst.touchEventType.DOWN then
    self.buttonState=clsUIButton.STATE_HIGHLIGHT
  elseif type==smUIConst.touchEventType.MOVE then
    local offsetWidth=(self.highlightBoundTimes-1)*self.width
    local offsetHeight=(self.highlightBoundTimes-1)*self.height
    if isPointInRect(x,y,-offsetWidth,-offsetHeight,self.width+2*offsetWidth,self.height+2*offsetHeight) then
      self.buttonState=clsUIButton.STATE_HIGHLIGHT
    else
      self.buttonState=clsUIButton.STATE_NORMAL
    end
  elseif type==smUIConst.touchEventType.UP then
    if self.delegate and self.buttonState==clsUIButton.STATE_HIGHLIGHT then
      self.buttonState=clsUIButton.STATE_NORMAL
      self.delegate:buttonTapped(self)
    end
  end
end

function clsUIButton:toString()
  local str="clsUIButton:["
  str=str.."x="..self.x.." y="..self.y.." w="..self.width.." h="..self.height
  str=str.."]"
  return str
end