/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soyostar.game.tools;

import com.soyostar.emulator.engine.GameEngine;
import com.soyostar.game.db.ImageManager;
import com.soyostar.game.model.Const;
import com.soyostar.game.model.GameData;

import com.soyostar.ui.Image;
import com.soyostar.ui.Painter;
import java.awt.Color;
import java.util.Random;
import java.util.Vector;


/*
 * 功能：
 * 1 drawString
 * 2 fillRect
 * 3 drawRect
 * 4 drawRoundRect
 * 5 fillRoundRect
 * 6 画三角
 * 7 绘制对话框
 * 8 绘制滚动条
 * 9 分割字符串
 * 10 半透明图片
 * 11 调整图片大小
 * 12 绘制图片数字
 * 13 绘制表格
 * 14 滚动文字
 */
/**
 *
 * 工具包
 */
public class Tools {

    public static final byte DIALOG_DEEP = 0;
    public static final byte DIALOG_LIGHT = 1;
    public static final byte NODIALOG = 2;
    public static final byte SCROLLBAR_VERTICAL = 0;
    public static final byte SCROLLBAR_HORIZONTAL = 1;
    public static final byte CELL_DEEP = 0;
    public static final byte CELL_LIGHT = 1;
    private static GameEngine ge = GameEngine.getInstance();

    public static int GetRandom(int data) {
        int rand = new Random().nextInt();
        return Math.abs(rand % data);
    }

    public static int GetRandom(int rs, int re)//获取随机数
    {
        int tmp = rs + Math.abs(new Random().nextInt() % (re - rs + 1));
        return tmp;
    }
    //黑色清屏

    public static void cleanScreen(Painter painter) {
        painter.setClip(0, 0, GameData.getGameData().screenWidth, GameData.getGameData().screenHeight);
        painter.setColor(Color.black);
        painter.fillRect(0, 0, GameData.getGameData().screenWidth, GameData.getGameData().screenHeight);
    }

    public static int[] sort(int[] arraylist) {//冒泡排序
        int len = arraylist.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (arraylist[j] < arraylist[i]) {
                    int temp = 0;
                    temp = arraylist[j];
                    arraylist[j] = arraylist[i];
                    arraylist[i] = temp;
                }
            }
        }
        return arraylist;
    }

    /**
     * 三角形
     * @param painter
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @param x3
     * @param y3
     * @param color
     */
    public static void drawTriangle(Painter painter, int x1, int y1, int x2, int y2, int x3, int y3, Color color) {
        painter.setColor(color);
        painter.drawLine(x1, y1, x2, y2);
        painter.drawLine(x2, y2, x3, y3);
        painter.drawLine(x3, y3, x1, y1);
    }

    /**
     * 在指定位置绘制指定大小的对话框
     * @param g 画笔
     * @param x x坐标
     * @param y y坐标
     * @param w 宽度
     * @param h 高度
     * @param type 类型，为Painter.DIALOG_DEEP时画深色框 其它则画浅色框
     */
    public static void drawDialog(Painter painter, int x, int y, int w, int h, byte type) {
        if (type == Painter.DIALOG_DEEP || type == Painter.DIALOG_LIGHT) {
            Image img = ge.getImageManager().getImage(type == Painter.DIALOG_DEEP ? Const.ImagePath.DIALOG_DEEP : Const.ImagePath.DIALOG_LIGHT);
            drawRectFrame(painter, img, x, y, w, h);
        } else {
            System.out.println("参数type不对，只能为0或1");
        }
    }

    /**
     * 绘制滚动条
     * @param painter 画笔
     * @param style 风格 可取  Painter.SCROLLBAR_HORIZONTAL 水平  Painter.SCROLLBAR_VERTICAL 竖直
     * @param a 如果是水平风格则是滚动条y坐标，竖直风格则是x坐标
     * @param b1 如果是水平风格则是滚动条起始x坐标，竖直风格则是起始y坐标
     * @param b2 如果是水平风格则是滚动条终止x坐标，竖直风格则是终止y坐标 注：b2>b1
     * @param topIndex 显示的第一个条目的索引
     * @param showNum 一屏可以显示的条目数量
     * @param maxNum 总共要显示的条目数量
     */
    public static void drawScrollbar(Painter painter, byte style, int a, int b1, int b2, int topIndex, int showNum, int maxNum) {
        if (b2 <= b1 || maxNum <= showNum) {
            return;
        }
        ImageManager im = ge.getImageManager();
        Image trench = im.getImage(Const.ImagePath.TRENCH);
        trench = Image.createImage(trench, trench.getWidth() / 2, 0, trench.getWidth() / 2, trench.getHeight(), 6);
        Image triangle = im.getImage(Const.ImagePath.SMALLTRIANGLE);
        Image ball = im.getImage(Const.ImagePath.BALL);
        switch (style) {
            case Painter.SCROLLBAR_VERTICAL: {

                int hei = b2 - b1;
                int wid = triangle.getWidth();

                //1、绘制条状底色
                painter.setClip(a, b1 + triangle.getHeight(), wid, hei - 2 * triangle.getHeight());
                int num = hei / trench.getHeight() + 1;
                for (int i = 0; i < num; i++) {
                    painter.drawImage(trench, a + wid / 2, b1 + i * trench.getHeight(), Painter.HT);
                }
                painter.setClip(a, b1, wid, hei);
                //2、绘制两个三角
                painter.drawImage(triangle, a, b1, 0);
                painter.drawRegion(triangle, 0, 0, triangle.getWidth(), triangle.getHeight(), 1, a, b1 + hei - triangle.getHeight(), 0);

                //3、绘制小球
                if (maxNum > showNum) {
                    if (topIndex == 0) {
                        painter.drawImage(ball, a + wid / 2, b1 + triangle.getHeight(), Const.Anchor.HT);
                    } else if (topIndex == maxNum - showNum) {
                        painter.drawImage(ball, a + wid / 2, b1 + hei - triangle.getHeight() - ball.getHeight(), Const.Anchor.HT);
                    } else {
                        painter.drawImage(ball, a + wid / 2, b1 + triangle.getHeight() + (hei - 2 * triangle.getHeight()) / (maxNum - showNum) * topIndex, Const.Anchor.HT);
                    }
                }
            }
            break;
            case Painter.SCROLLBAR_HORIZONTAL: {

                int wid = b2 - b1;
                int hei = triangle.getWidth();

                //1、绘制条状底色
                painter.setClip(b1 + triangle.getHeight(), a, wid - 2 * triangle.getHeight(), hei);
                int num = wid / trench.getHeight() + 1;
                for (int i = 0; i < num; i++) {
                    painter.drawRegion(trench, 0, 0, trench.getWidth(), trench.getHeight(), 5, b1 + i * trench.getHeight(), a + hei / 2, Const.Anchor.LV);
                }
                painter.setClip(b1, a, wid, hei);
                //2、绘制两个三角
                painter.drawRegion(triangle, 0, 0, triangle.getWidth(), triangle.getHeight(), 4, b1, a, 0);
                painter.drawRegion(triangle, 0, 0, triangle.getWidth(), triangle.getHeight(), 5, b1 + wid - triangle.getHeight(), a, 0);

                //3、绘制小球
                if (maxNum > showNum) {
                    if (topIndex == 0) {
                        painter.drawImage(ball, b1 + triangle.getHeight(), a + hei / 2, Const.Anchor.LV);
                    } else if (topIndex == maxNum - showNum) {
                        painter.drawImage(ball, b1 + wid - triangle.getHeight() - ball.getWidth(), a + hei / 2, Const.Anchor.LV);
                    } else {
                        painter.drawImage(ball, b1 + triangle.getHeight() + (wid - 2 * triangle.getHeight()) / (maxNum - showNum) * topIndex, a + hei / 2, Const.Anchor.LV);
                    }
                }
            }
            break;
        }
        painter.setClip(0, 0, GameData.getGameData().screenWidth, GameData.getGameData().screenHeight);

    }

    /**
     *
     * 分割字符串，原理：检测字符串中的分割字符串，然后取子串
     *
     * @param original
     *            需要分割的字符串
     *
     * @paran regex 分割字符串
     *
     * @return 分割后生成的字符串数组
     *
     */
    public static String[] split(String original, String regex) {
        // 取子串的起始位置
        int startIndex = 0;
        // 将结果数据先放入Vector中
        Vector v = new Vector();
        // 返回的结果字符串数组
        String[] str = null;
        // 存储取子串时起始位置
        int index = 0;
        // 获得匹配子串的位置
        startIndex = original.indexOf(regex);
        // 如果起始字符串的位置小于字符串的长度，则证明没有取到字符串末尾。
        // -1代表取到了末尾
        while (startIndex < original.length() && startIndex != -1) {
            String temp = original.substring(index, startIndex);
            // 取子串
            v.addElement(temp);
            // 设置取子串的起始位置
            index = startIndex + regex.length();
            // 获得匹配子串的位置
            startIndex = original.indexOf(regex, startIndex + regex.length());
        }

        // 取结束的子串

        v.addElement(original.substring(index + 1 - regex.length()));
        // 将Vector对象转换成数组
        str = new String[v.size()];
        for (int i = 0; i < v.size(); i++) {
            str[i] = (String) v.elementAt(i);
        }
        // 返回生成的数组
        return str;

    }

    /**
     * 在指定位置绘制指定大小的单元格
     * @param painter 画笔
     * @param x x坐标
     * @param y y坐标
     * @param w 宽度
     * @param h 高度
     * @param type 类型，为Painter.CELL_DEEP时画深色框 其它则画浅色框
     */
    public static void drawCell(Painter painter, int x, int y, int w, int h, byte type) {
        Image img = ge.getImageManager().getImage(type == Painter.CELL_DEEP ? Const.ImagePath.CELL_DEEP : Const.ImagePath.CELL_LIGHT);
        drawRectFrame(painter, img, x, y, w, h);
    }

    public static void drawStringOnCell(Painter painter, String text, Color color, int x, int y, int w, int h, int anchor, byte type) {
        drawCell(painter, x, y, w, h, type);
        if (text == null || text.equals("")) {
            return;
        }
        painter.setColor(color);
        int gap = 3;//文字与边框的间距
        switch (anchor) {
            case Const.Anchor.LT:
                painter.drawString(text, x + gap, y, anchor);
                break;
            case Const.Anchor.LV:
                painter.drawString(text, x + gap, y + (h - painter.getFontHeight()) / 2, Const.Anchor.LT);
                break;
            case Const.Anchor.LB:
                painter.drawString(text, x + gap, y + h, anchor);
                break;
            case Const.Anchor.HT:
                painter.drawString(text, x + w / 2, y, anchor);
                break;
            case Const.Anchor.HV:
                painter.drawString(text, x + w / 2, y + (h - painter.getFontHeight()) / 2, Const.Anchor.HT);
                break;
            case Const.Anchor.HB:
                painter.drawString(text, x + w / 2, y + h, anchor);
                break;
            case Const.Anchor.RT:
                painter.drawString(text, x + w - gap, y, anchor);
                break;
            case Const.Anchor.RV:
                painter.drawString(text, x + w - gap, y + (h - painter.getFontHeight()) / 2, Const.Anchor.RT);
                break;
            case Const.Anchor.RB:
                painter.drawString(text, x + w - gap, y + h, anchor);
                break;
        }

    }

    /**
     * 绘制表格
     * @param painter 画笔
     * @param x 起始x坐标
     * @param y 起始y坐标
     * @param cellWidth 单元格宽度
     * @param cellHeight 单元格高度
     * @param cellNum 单元格数量
     * @param gap 单元格间距
     * @param texts 内容
     * @param color 文本颜色
     * @param topIndex 第一条要显示的信息的索引
     * @param curIndex 当前选中的信息的索引
     * @param anchor 锚点
     * @param type 类型，为Painter.CELL_DEEP时选中框为深色框 其它则画浅色框
     */
    public static void drawTable(Painter painter, int x, int y, int cellWidth, int cellHeight, int cellNum, int gap, String[] texts, Color color, int topIndex, int curIndex, int anchor, byte style, byte type) {
        if (style != NODIALOG) {//不为0,1时不画对话框
            drawDialog(painter, x, y, cellWidth + 2 * gap, cellNum * (cellHeight + gap) + gap, style);
        }

        for (int i = 0; i < cellNum; i++) {
            drawStringOnCell(painter, i + topIndex < texts.length ? texts[i + topIndex] : null, color, x + gap, y + (cellHeight + gap) * i + gap, cellWidth, cellHeight, anchor, i + topIndex == curIndex ? (type == Painter.CELL_DEEP ? Painter.CELL_DEEP : Painter.CELL_LIGHT) : (type == Painter.CELL_DEEP ? Painter.CELL_LIGHT : Painter.CELL_DEEP));
        }
    }

    public static void drawTab(Painter painter, int x, int y, int w, int h, byte type, int curIndex, String[] titles) {
        //绘制所有耳朵
        int wid = 48, hei = 24;
        for (int i = 0; i < titles.length; i++) {
            drawDialog(painter, x + i * wid, y, wid, hei, type == DIALOG_DEEP ? DIALOG_LIGHT : DIALOG_DEEP);
        }
        //绘制选中的耳朵
        drawDialog(painter, x + curIndex * wid, y, wid, hei, type == DIALOG_DEEP ? DIALOG_DEEP : DIALOG_LIGHT);
        //绘制内容框
        drawDialog(painter, x, y + hei, w, h - hei, type == DIALOG_DEEP ? DIALOG_DEEP : DIALOG_LIGHT);
        //绘制标题
        painter.setFontStyle(Painter.STYLE_PLAIN);
        for (int i = 0; i < titles.length; i++) {
            painter.drawString(titles[i], x + i * wid + wid >> 1, y + (hei - painter.getFontHeight()) >> 1, Const.Anchor.HT);
        }
    }

    public static void drawRectFrame(Painter painter, Image img, int x, int y, int w, int h) {
        painter.setClip(x, y, w, h);
        int rowNum = h / (img.getHeight() >> 1) + 1;
        int colNum = w / (img.getWidth() >> 1) + 1;
        //绘制底色
        for (int i = 0; i < colNum; i++) {
            for (int j = 0; j < rowNum; j++) {
                painter.drawRegion(img, img.getWidth() >> 1, img.getHeight() >> 1, img.getWidth() >> 1, img.getHeight() >> 1, 0, x + img.getWidth() / 2 * i, y + img.getHeight() / 2 * j, 0);
            }
        }
        //绘制边框 [先水平，后竖直]
        for (int i = 0; i < colNum; i++) {
            painter.drawRegion(img, img.getWidth() / 2, 0, img.getWidth() / 2, img.getHeight() / 2, 0, x + img.getWidth() / 2 * i, y, 0);
            painter.drawRegion(img, img.getWidth() / 2, 0, img.getWidth() / 2, img.getHeight() / 2, 1, x + img.getWidth() / 2 * i, y + h - img.getHeight() / 2, 0);
        }
        for (int i = 0; i < rowNum; i++) {
            painter.drawRegion(img, 0, img.getHeight() / 2, img.getWidth() / 2, img.getHeight() / 2, 0, x, y + img.getHeight() / 2 * i, 0);
            painter.drawRegion(img, 0, img.getHeight() / 2, img.getWidth() / 2, img.getHeight() / 2, 3, x + w - img.getWidth() / 2, y + img.getHeight() / 2 * i, 0);

        }
        //四个角
        painter.drawRegion(img, 0, 0, img.getWidth() / 2, img.getHeight() / 2, 0, x, y, 0);
        painter.drawRegion(img, 0, 0, img.getWidth() / 2, img.getHeight() / 2, 2, x + w - img.getWidth() / 2, y, 0);
        painter.drawRegion(img, 0, 0, img.getWidth() / 2, img.getHeight() / 2, 1, x, y + h - img.getHeight() / 2, 0);
        painter.drawRegion(img, 0, 0, img.getWidth() / 2, img.getHeight() / 2, 3, x + w - img.getWidth() / 2, y + h - img.getHeight() / 2, 0);


        painter.setClip(0, 0, GameData.getGameData().screenWidth, GameData.getGameData().screenHeight);
    }
    /*
     * 图片镜像特效
     */

    public static Image effect_mirror(Image src) {
        int srcW = src.getWidth();
        int srcH = src.getHeight();
        int[] srcPixels = getPixels(src);
        int len;
        int temp;
        for (int i = 0; i < srcH; i++) {
            len = (i + 1) * srcW;
            for (int ii = 0; ii < srcW / 2; ii++) {
                temp = srcPixels[i * srcW + ii];
                srcPixels[i * srcW + ii] = srcPixels[len - 1 - ii];
                srcPixels[len - 1 - ii] = temp;
            }
        }
        return drawPixels(srcPixels, srcW, srcH);
    }

    /*******************************下面是各个图片处理函数***********************************/

    /*
     * 获取图片RGB数据，并返回大小为width*height大小的一维数组
     */
    public static int[] getPixels(Image src) {
        int w = src.getWidth();
        int h = src.getHeight();
        int[] pixels = new int[w * h];
        src.getRGB(pixels, 0, w, 0, 0, w, h);
        return pixels;
    }
    /*
     *将pixels[]里的数据，生成一张图片，图片宽为w，高为h
     */

    public static Image drawPixels(int[] pixels, int w, int h) {
        Image image =Image.createRGBImage(pixels, w, h);
        pixels = null;
        return image;
    }
    /*
     *调整图片大小
     *destW 调整后的宽，destH调整后的高
     */

    public static Image effect_resizeImage(Image src, int destW, int destH) {
        int srcW = src.getWidth();
        int srcH = src.getHeight();
        int[] destPixels = new int[destW * destH];
        int[] srcPixels = getPixels(src);
        for (int destY = 0; destY < destH; ++destY) {
            for (int destX = 0; destX < destW; ++destX) {
                int srcX = (destX * srcW) / destW;
                int srcY = (destY * srcH) / destH;
                destPixels[destX + destY * destW] = srcPixels[srcX + srcY * srcW];
            }
        }
        return drawPixels(destPixels, destW, destH);
    }

    /**
     *
     * @param img
     *            原始图片
     * @param transparent
     *            透明度 0-255之间
     * 越大越不透明，只半透明不透明的部分
     * @return 处理透明度后的图片
     */
    public static Image effect_transparent_Other(Image img, int transparent) {
        if (transparent < 0 || transparent > 255) {
            return img;
        }
        int srcW = img.getWidth();
        int srcH = img.getHeight();
        int[] srcPixels = getPixels(img); //函数功能 讲图片数据存入指定数组
        int r = 0;
        int g = 0;
        int b = 0;
        int a = 0;
        int argb;
        for (int i = 0; i < srcH; i++) {
            for (int ii = 0; ii < srcW; ii++) {
                argb = srcPixels[i * srcW + ii];
                a = ((argb & 0xff000000) >> 24); // alpha channel
                r = ((argb & 0x00ff0000) >> 16); // red channel
                g = ((argb & 0x0000ff00) >> 8); // green channel
                b = (argb & 0x000000ff); // blue channel
                if (a != 0) {
                    srcPixels[i * srcW + ii] = ((transparent << 24) | (r << 16) | (g << 8) | b);
                } else {
                    srcPixels[i * srcW + ii] = 0x00ffffff;
                }
            }
        }
        return drawPixels(srcPixels, srcW, srcH); //将数组转化为图片
    }
    public static int tipStringPos = 240 / 2;   //当前字符串左边的位置 这里改为屏幕中间位子
    private static int tipStringSpeed = 3;         //字符串移动速度
//    private static final int FONT_HEIGHT = 11;      //字体高度 font.getHeight() 不准确

    public static void resetTipStringPos() {
        tipStringPos = 240 / 2;
    }

    /**		滚动文字效果
     * @param Graphics g - 画刷
     * @param String str - 所画字符串
     * @param int height - 字符串高度
     * @param int rectX - 剪裁区顶点X坐标
     * @param int rectY - 剪裁区顶点Y坐标
     * @param int rectWidth - 剪裁区宽度
     * @param int rectHeight - 剪裁区高度
     * TIPSTR_LEFT //左边消失绘制坐标
     * TIPSTR_RIGHT //右边出现绘制坐标
     */
    public static void drawTipString(Painter painter, String str, int height, int TIPSTR_LEFT, int TIPSTR_RIGHT, int rectX, int rectY, int rectWidth, int rectHeight, Color color) {
        painter.setColor(color);
        int strWidth = painter.stringWidth(str);
        int strHeight = painter.getFontHeight();
        if (strWidth < rectWidth) {
            painter.drawString(str, rectX, height - strHeight / 2, Painter.LT);
            return;
        }
        tipStringPos -= tipStringSpeed;
        if (tipStringPos + strWidth < TIPSTR_LEFT) {
            tipStringPos = TIPSTR_RIGHT;
        }
        //裁减区
        int oldClipX = painter.getClipX();
        int oldClipY = painter.getClipY();
        int oldClipWidth = painter.getClipWidth();
        int oldClipHeight = painter.getClipHeight();
        painter.setClip(rectX, rectY, rectWidth, rectHeight);
        painter.drawString(str, tipStringPos, height - strHeight / 2, Painter.LT);
        painter.setClip(oldClipX, oldClipY, oldClipWidth, oldClipHeight);

    }

    public static void drawImage(Image src, int x_src, int y_src, int width, int height, int x_dest, int y_dest, int anchor, Painter painter) {
        painter.drawRegion(src, x_src, y_src, width, height, 0, x_dest, y_dest, anchor);
    }
    private static int width;
    private static int height;
    private static char cha;
    public static int REDNUM = 0;
    public static int GREENNUM = 1;

    /**
     * 画数字图片
     *
     * @param imgNumber
     * @param number
     * @param x
     * @param y
     * @param painter
     * @param type
     * @param atype 0 红色图片 1 绿色图片
     */
    public static void drawNumber(Painter painter, int number, int x, int y, int w, int type, int atype) {
        ImageManager im = ge.getImageManager();
        Image imgNumber = im.getImage(Const.ImagePath.NUMS);
        width = imgNumber.getWidth() / w;
        height = imgNumber.getHeight() / 2;
        String strNmber = Integer.toString(number);
        char[] chrNumr = strNmber.toCharArray();
        cha = 0;
        if (type == NUMBER_LEFT) {
            x -= (chrNumr.length - 1) * width;
        } else if (type == NUMBER_UP) {
            y -= chrNumr.length * height;
        }
        for (int i = 0; i < chrNumr.length; i++) {
            cha = chrNumr[i];
            switch (cha) {
                case '0':
                    drawImage(imgNumber, 0 * width, atype * height, width, height, x, y, 0,
                            painter);
                    break;
                case '1':
                    drawImage(imgNumber, 1 * width, atype * height, width, height, x, y,
                            0, painter);
                    break;
                case '2':
                    drawImage(imgNumber, 2 * width, atype * height, width, height, x, y,
                            0, painter);
                    break;
                case '3':
                    drawImage(imgNumber, 3 * width, atype * height, width, height, x, y,
                            0, painter);
                    break;
                case '4':
                    drawImage(imgNumber, 4 * width, atype * height, width, height, x, y,
                            0, painter);
                    break;
                case '5':
                    drawImage(imgNumber, 5 * width, atype * height, width, height, x, y,
                            0, painter);
                    break;
                case '6':
                    drawImage(imgNumber, 6 * width, atype * height, width, height, x, y,
                            0, painter);
                    break;
                case '7':
                    drawImage(imgNumber, 7 * width, atype * height, width, height, x, y,
                            0, painter);
                    break;
                case '8':
                    drawImage(imgNumber, 8 * width, atype * height, width, height, x, y,
                            0, painter);
                    break;
                case '9':
                    drawImage(imgNumber, 9 * width, atype * height, width, height, x, y,
                            0, painter);
                    break;
            }
            switch (type) {
                case NUMBER_LEFT:
                case NUMBER_RIGHT:
                    x += width;
                    break;
                case NUMBER_UP:
                case NUMBER_DOWN:
                    y += height;
                    break;
            }

        }
        strNmber = null;
        chrNumr = null;
//        System.gc();
    }
    /**
     * 第一文字排版
     */
    public final static int NUMBER_LEFT = 1;
    public final static int NUMBER_RIGHT = 2;
    public final static int NUMBER_UP = 3;
    public final static int NUMBER_DOWN = 4;

    /**
     * 在指定区域绘制自动换行的文本
     * @param painter 画笔
     * @param str 要绘制的字符串
     * @param x  起始x坐标
     * @param y  起始y坐标
     * @param wid 区域宽度
     * @param hei 区域高度
     * @param color 文本颜色
     */
    public static void drawWordWrapString(Painter painter, String str, int x, int y, int wid, int hei, Color color) {
        painter.setClip(x, y, wid, hei);
        painter.setColor(color);
        char[] txt = str.toCharArray();
        for (int i = 0, col = 0, line = 0; i < txt.length; i++) {
            painter.drawChar(txt[i], x + col * (painter.charWidth(txt[0]) + 1), y + line * (painter.getFontHeight()), Painter.LT);
            if ((col + 1) * (painter.charWidth(txt[0]) + 1) >= wid) {
                col = 0;
                line++;
            } else {
                col++;
            }

        }
        painter.setClip(0, 0, GameData.getGameData().screenWidth, GameData.getGameData().screenHeight);

    }
}
