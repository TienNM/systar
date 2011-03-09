package system;

import emulator.EmulatorGraphics;
import emulator.EmulatorImage;
import java.awt.Color;
import java.util.Vector;
import emulator.model.Const;
import emulator.model.GameData;
import emulator.model.manager.ImageManager;
/*
 * ���ܣ�
 * 1 drawString
 * 2 fillRect
 * 3 drawRect
 * 4 drawRoundRect
 * 5 fillRoundRect
 * 6 ������
 * 7 ���ƶԻ���
 * 8 ���ƹ�����
 * 9 �ָ��ַ���
 * 10 ��͸��ͼƬ
 * 11 ����ͼƬ��С
 * 12 ����ͼƬ����
 * 13 ���Ʊ��
 * 14 ��������
 */

/**
 *
 * ��ͼ���߰�
 */
public class Painter {

    public static final byte DIALOG_DEEP = 0;
    public static final byte DIALOG_LIGHT = 1;
    public static final byte NODIALOG = 2;
    public static final byte SCROLLBAR_VERTICAL = 0;
    public static final byte SCROLLBAR_HORIZONTAL = 1;
    public static final byte CELL_DEEP = 0;
    public static final byte CELL_LIGHT = 1;

    public static void drawString(EmulatorGraphics g, String str, int x, int y, Color color) {
        g.setColor(color);
        g.drawString(str, x, y, EmulatorGraphics.LT);
    }

    public static void fillRect(EmulatorGraphics g, int x, int y, int width, int height, Color color) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }

    public static void drawRect(EmulatorGraphics g, int x, int y, int width, int height, Color color) {
        g.setColor(color);
        g.drawRect(x, y, width, height);
    }

    public static void drawRoundRect(EmulatorGraphics g, int x, int y, int width, int height, int anchor, Color color) {
        g.setColor(color);
        g.drawRoundRect(x, y, width, height, 5, anchor);
    }

    public static void fillRoundRect(EmulatorGraphics g, int x, int y, int width, int height, int anchor, Color color) {
        g.setColor(color);
        g.fillRoundRect(x, y, width, height, 5, anchor);
    }

    public static void drawTriangle(EmulatorGraphics g, int x1, int y1, int x2, int y2, int x3, int y3, Color color) {
        g.setColor(color);
        g.drawLine(x1, y1, x2, y2);
        g.drawLine(x2, y2, x3, y3);
        g.drawLine(x3, y3, x1, y1);
    }

    /**
     * ��ָ��λ�û���ָ����С�ĶԻ���
     * @param g ����
     * @param x x����
     * @param y y����
     * @param w ���
     * @param h �߶�
     * @param type ���ͣ�ΪPainter.DIALOG_DEEPʱ����ɫ�� ������ǳɫ��
     */
    public static void drawDialog(EmulatorGraphics g, int x, int y, int w, int h, byte type) {
        if (type == Painter.DIALOG_DEEP || type == Painter.DIALOG_LIGHT) {
            EmulatorImage img = ImageManager.getInstance().getImage(type == Painter.DIALOG_DEEP ? Const.ImagePath.DIALOG_DEEP : Const.ImagePath.DIALOG_LIGHT);
            drawRectFrame(g, img, x, y, w, h);
        } else {
            System.out.println("����type���ԣ�ֻ��Ϊ0��1");
        }
    }

    /**
     * ���ƹ�����
     * @param g ����
     * @param style ��� ��ȡ  Painter.SCROLLBAR_HORIZONTAL ˮƽ  Painter.SCROLLBAR_VERTICAL ��ֱ
     * @param a �����ˮƽ������ǹ�����y���꣬��ֱ�������x����
     * @param b1 �����ˮƽ������ǹ�������ʼx���꣬��ֱ���������ʼy����
     * @param b2 �����ˮƽ������ǹ�������ֹx���꣬��ֱ���������ֹy���� ע��b2>b1
     * @param topIndex ��ʾ�ĵ�һ����Ŀ������
     * @param showNum һ��������ʾ����Ŀ����
     * @param maxNum �ܹ�Ҫ��ʾ����Ŀ����
     */
    public static void drawScrollbar(EmulatorGraphics g, byte style, int a, int b1, int b2, int topIndex, int showNum, int maxNum) {
        if (b2 <= b1 || maxNum <= showNum) {
            return;
        }
        ImageManager im = ImageManager.getInstance();
        EmulatorImage trench = im.getImage(Const.ImagePath.TRENCH);
        trench = EmulatorImage.createImage(trench, trench.getWidth() / 2, 0, trench.getWidth() / 2, trench.getHeight(), 6);
        EmulatorImage triangle = im.getImage(Const.ImagePath.SMALLTRIANGLE);
        EmulatorImage ball = im.getImage(Const.ImagePath.BALL);
        switch (style) {
            case Painter.SCROLLBAR_VERTICAL: {

                int hei = b2 - b1;
                int wid = triangle.getWidth();

                //1��������״��ɫ
                g.setClip(a, b1 + triangle.getHeight(), wid, hei - 2 * triangle.getHeight());
                int num = hei / trench.getHeight() + 1;
                for (int i = 0; i < num; i++) {
                    g.drawImage(trench, a + wid / 2, b1 + i * trench.getHeight(), EmulatorGraphics.HT);
                }
                g.setClip(a, b1, wid, hei);
                //2��������������
                g.drawImage(triangle, a, b1, 0);
                g.drawRegion(triangle, 0, 0, triangle.getWidth(), triangle.getHeight(), 1, a, b1 + hei - triangle.getHeight(), 0);

                //3������С��
                if (maxNum > showNum) {
                    if (topIndex == 0) {
                        g.drawImage(ball, a + wid / 2, b1 + triangle.getHeight(), Const.Anchor.HT);
                    } else if (topIndex == maxNum - showNum) {
                        g.drawImage(ball, a + wid / 2, b1 + hei - triangle.getHeight() - ball.getHeight(), Const.Anchor.HT);
                    } else {
                        g.drawImage(ball, a + wid / 2, b1 + triangle.getHeight() + (hei - 2 * triangle.getHeight()) / (maxNum - showNum) * topIndex, Const.Anchor.HT);
                    }
                }
            }
            break;
            case Painter.SCROLLBAR_HORIZONTAL: {

                int wid = b2 - b1;
                int hei = triangle.getWidth();

                //1��������״��ɫ
                g.setClip(b1 + triangle.getHeight(), a, wid - 2 * triangle.getHeight(), hei);
                int num = wid / trench.getHeight() + 1;
                for (int i = 0; i < num; i++) {
                    g.drawRegion(trench, 0, 0, trench.getWidth(), trench.getHeight(), 5, b1 + i * trench.getHeight(), a + hei / 2, Const.Anchor.LV);
                }
                g.setClip(b1, a, wid, hei);
                //2��������������
                g.drawRegion(triangle, 0, 0, triangle.getWidth(), triangle.getHeight(), 4, b1, a, 0);
                g.drawRegion(triangle, 0, 0, triangle.getWidth(), triangle.getHeight(), 5, b1 + wid - triangle.getHeight(), a, 0);

                //3������С��
                if (maxNum > showNum) {
                    if (topIndex == 0) {
                        g.drawImage(ball, b1 + triangle.getHeight(), a + hei / 2, Const.Anchor.LV);
                    } else if (topIndex == maxNum - showNum) {
                        g.drawImage(ball, b1 + wid - triangle.getHeight() - ball.getWidth(), a + hei / 2, Const.Anchor.LV);
                    } else {
                        g.drawImage(ball, b1 + triangle.getHeight() + (wid - 2 * triangle.getHeight()) / (maxNum - showNum) * topIndex, a + hei / 2, Const.Anchor.LV);
                    }
                }
            }
            break;
        }
        g.setClip(0, 0, GameData.getGameData().screenWidth, GameData.getGameData().screenHeight);

    }

    /**
     *
     * �ָ��ַ�����ԭ������ַ����еķָ��ַ�����Ȼ��ȡ�Ӵ�
     *
     * @param original
     *            ��Ҫ�ָ���ַ���
     *
     * @paran regex �ָ��ַ���
     *
     * @return �ָ�����ɵ��ַ�������
     *
     */
    public static String[] split(String original, String regex) {
        // ȡ�Ӵ�����ʼλ��
        int startIndex = 0;
        // ����������ȷ���Vector��
        Vector v = new Vector();
        // ���صĽ���ַ�������
        String[] str = null;
        // �洢ȡ�Ӵ�ʱ��ʼλ��
        int index = 0;
        // ���ƥ���Ӵ���λ��
        startIndex = original.indexOf(regex);
        // �����ʼ�ַ�����λ��С���ַ����ĳ��ȣ���֤��û��ȡ���ַ���ĩβ��
        // -1����ȡ����ĩβ
        while (startIndex < original.length() && startIndex != -1) {
            String temp = original.substring(index, startIndex);
            // ȡ�Ӵ�
            v.addElement(temp);
            // ����ȡ�Ӵ�����ʼλ��
            index = startIndex + regex.length();
            // ���ƥ���Ӵ���λ��
            startIndex = original.indexOf(regex, startIndex + regex.length());
        }

        // ȡ�������Ӵ�

        v.addElement(original.substring(index + 1 - regex.length()));
        // ��Vector����ת��������
        str = new String[v.size()];
        for (int i = 0; i < v.size(); i++) {
            str[i] = (String) v.elementAt(i);
        }
        // �������ɵ�����
        return str;

    }

    /**
     * ��ָ��λ�û���ָ����С�ĵ�Ԫ��
     * @param g ����
     * @param x x����
     * @param y y����
     * @param w ���
     * @param h �߶�
     * @param type ���ͣ�ΪPainter.CELL_DEEPʱ����ɫ�� ������ǳɫ��
     */
    public static void drawCell(EmulatorGraphics g, int x, int y, int w, int h, byte type) {
        EmulatorImage img = ImageManager.getInstance().getImage(type == Painter.CELL_DEEP ? Const.ImagePath.CELL_DEEP : Const.ImagePath.CELL_LIGHT);
        drawRectFrame(g, img, x, y, w, h);
    }

    public static void drawStringOnCell(EmulatorGraphics g, String text, Color color, int x, int y, int w, int h, int anchor, byte type) {
        drawCell(g, x, y, w, h, type);
        if (text == null || text.equals("")) {
            return;
        }
        g.setColor(color);
        int gap = 3;//������߿�ļ��
        switch (anchor) {
            case Const.Anchor.LT:
                g.drawString(text, x + gap, y, anchor);
                break;
            case Const.Anchor.LV:
                g.drawString(text, x + gap, y + (h - g.getEmulatorFont().getHeight()) / 2, Const.Anchor.LT);
                break;
            case Const.Anchor.LB:
                g.drawString(text, x + gap, y + h, anchor);
                break;
            case Const.Anchor.HT:
                g.drawString(text, x + w / 2, y, anchor);
                break;
            case Const.Anchor.HV:
                g.drawString(text, x + w / 2, y + (h - g.getEmulatorFont().getHeight()) / 2, Const.Anchor.HT);
                break;
            case Const.Anchor.HB:
                g.drawString(text, x + w / 2, y + h, anchor);
                break;
            case Const.Anchor.RT:
                g.drawString(text, x + w - gap, y, anchor);
                break;
            case Const.Anchor.RV:
                g.drawString(text, x + w - gap, y + (h - g.getEmulatorFont().getHeight()) / 2, Const.Anchor.RT);
                break;
            case Const.Anchor.RB:
                g.drawString(text, x + w - gap, y + h, anchor);
                break;
        }

    }

    /**
     * ���Ʊ��
     * @param g ����
     * @param x ��ʼx����
     * @param y ��ʼy����
     * @param cellWidth ��Ԫ����
     * @param cellHeight ��Ԫ��߶�
     * @param cellNum ��Ԫ������
     * @param gap ��Ԫ����
     * @param texts ����
     * @param color �ı���ɫ
     * @param topIndex ��һ��Ҫ��ʾ����Ϣ������
     * @param curIndex ��ǰѡ�е���Ϣ������
     * @param anchor ê��
     * @param type ���ͣ�ΪPainter.CELL_DEEPʱѡ�п�Ϊ��ɫ�� ������ǳɫ��
     */
    public static void drawTable(EmulatorGraphics g, int x, int y, int cellWidth, int cellHeight, int cellNum, int gap, String[] texts, Color color, int topIndex, int curIndex, int anchor, byte style, byte type) {
        if (style != NODIALOG) {//��Ϊ0,1ʱ�����Ի���
            drawDialog(g, x, y, cellWidth + 2 * gap, cellNum * (cellHeight + gap) + gap, style);
        }

        for (int i = 0; i < cellNum; i++) {
            drawStringOnCell(g, i + topIndex < texts.length ? texts[i + topIndex] : null, color, x + gap, y + (cellHeight + gap) * i + gap, cellWidth, cellHeight, anchor, i + topIndex == curIndex ? (type == Painter.CELL_DEEP ? Painter.CELL_DEEP : Painter.CELL_LIGHT) : (type == Painter.CELL_DEEP ? Painter.CELL_LIGHT : Painter.CELL_DEEP));
        }
    }

    public static void drawTab(EmulatorGraphics g, int x, int y, int w, int h, byte type, int curIndex, String[] titles) {
        //�������ж���
        int wid = 48, hei = 24;
        for (int i = 0; i < titles.length; i++) {
            drawDialog(g, x + i * wid, y, wid, hei, type == DIALOG_DEEP ? DIALOG_LIGHT : DIALOG_DEEP);
        }
        //����ѡ�еĶ���
        drawDialog(g, x + curIndex * wid, y, wid, hei, type == DIALOG_DEEP ? DIALOG_DEEP : DIALOG_LIGHT);
        //�������ݿ�
        drawDialog(g, x, y + hei, w, h - hei, type == DIALOG_DEEP ? DIALOG_DEEP : DIALOG_LIGHT);
        //���Ʊ���
        g.setEmulatorFont(Const.Font.FONTSMALL_PLAIN);
        for (int i = 0; i < titles.length; i++) {
            g.drawString(titles[i], x + i * wid + wid / 2, y + (hei - g.getEmulatorFont().getHeight()) / 2, Const.Anchor.HT);
        }
    }

    public static void drawRectFrame(EmulatorGraphics g, EmulatorImage img, int x, int y, int w, int h) {
        g.setClip(x, y, w, h);
        int rowNum = h / (img.getHeight() / 2) + 1;
        int colNum = w / (img.getWidth() / 2) + 1;
        //���Ƶ�ɫ
        for (int i = 0; i < colNum; i++) {
            for (int j = 0; j < rowNum; j++) {
                g.drawRegion(img, img.getWidth() / 2, img.getHeight() / 2, img.getWidth() / 2, img.getHeight() / 2, 0, x + img.getWidth() / 2 * i, y + img.getHeight() / 2 * j, 0);
            }
        }
        //���Ʊ߿� [��ˮƽ������ֱ]
        for (int i = 0; i < colNum; i++) {
            g.drawRegion(img, img.getWidth() / 2, 0, img.getWidth() / 2, img.getHeight() / 2, 0, x + img.getWidth() / 2 * i, y, 0);
            g.drawRegion(img, img.getWidth() / 2, 0, img.getWidth() / 2, img.getHeight() / 2, 1, x + img.getWidth() / 2 * i, y + h - img.getHeight() / 2, 0);
        }
        for (int i = 0; i < rowNum; i++) {
            g.drawRegion(img, 0, img.getHeight() / 2, img.getWidth() / 2, img.getHeight() / 2, 0, x, y + img.getHeight() / 2 * i, 0);
            g.drawRegion(img, 0, img.getHeight() / 2, img.getWidth() / 2, img.getHeight() / 2, 3, x + w - img.getWidth() / 2, y + img.getHeight() / 2 * i, 0);

        }
        //�ĸ���
        g.drawRegion(img, 0, 0, img.getWidth() / 2, img.getHeight() / 2, 0, x, y, 0);
        g.drawRegion(img, 0, 0, img.getWidth() / 2, img.getHeight() / 2, 2, x + w - img.getWidth() / 2, y, 0);
        g.drawRegion(img, 0, 0, img.getWidth() / 2, img.getHeight() / 2, 1, x, y + h - img.getHeight() / 2, 0);
        g.drawRegion(img, 0, 0, img.getWidth() / 2, img.getHeight() / 2, 3, x + w - img.getWidth() / 2, y + h - img.getHeight() / 2, 0);


        g.setClip(0, 0, GameData.getGameData().screenWidth, GameData.getGameData().screenHeight);
    }
    /*
     * ͼƬ������Ч
     */

    public static EmulatorImage effect_mirror(EmulatorImage src) {
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

    /*******************************�����Ǹ���ͼƬ������***********************************/

    /*
     * ��ȡͼƬRGB���ݣ������ش�СΪwidth*height��С��һά����
     */
    public static int[] getPixels(EmulatorImage src) {
        int w = src.getWidth();
        int h = src.getHeight();
        int[] pixels = new int[w * h];
        src.getRGB(pixels, 0, w, 0, 0, w, h);
        return pixels;
    }
    /*
     *��pixels[]������ݣ�����һ��ͼƬ��ͼƬ��Ϊw����Ϊh
     */

    public static EmulatorImage drawPixels(int[] pixels, int w, int h) {
        EmulatorImage image = EmulatorImage.createRGBImage(pixels, w, h, true);
        pixels = null;
        return image;
    }
    /*
     *����ͼƬ��С
     *destW ������Ŀ�destH������ĸ�
     */

    public static EmulatorImage effect_resizeImage(EmulatorImage src, int destW, int destH) {
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
     *            ԭʼͼƬ
     * @param transparent
     *            ͸���� 0-255֮��
     * Խ��Խ��͸����ֻ��͸����͸���Ĳ���
     * @return ����͸���Ⱥ��ͼƬ
     */
    public static EmulatorImage effect_transparent_Other(EmulatorImage img, int transparent) {
        if (transparent < 0 || transparent > 255) {
            return img;
        }
        int srcW = img.getWidth();
        int srcH = img.getHeight();
        int[] srcPixels = getPixels(img); //�������� ��ͼƬ���ݴ���ָ������
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
        return drawPixels(srcPixels, srcW, srcH); //������ת��ΪͼƬ
    }
    public static int tipStringPos = 240 / 2;   //��ǰ�ַ�����ߵ�λ�� �����Ϊ��Ļ�м�λ��
    private static int tipStringSpeed = 3;         //�ַ����ƶ��ٶ�
//    private static final int FONT_HEIGHT = 11;      //����߶� font.getHeight() ��׼ȷ

    public static void resetTipStringPos() {
        tipStringPos = 240 / 2;
    }

    /**		��������Ч��
     * @param Graphics g - ��ˢ
     * @param String str - �����ַ���
     * @param int height - �ַ����߶�
     * @param int rectX - ����������X����
     * @param int rectY - ����������Y����
     * @param int rectWidth - ���������
     * @param int rectHeight - �������߶�
     * TIPSTR_LEFT //�����ʧ��������
     * TIPSTR_RIGHT //�ұ߳��ֻ�������
     */
    public static void drawTipString(EmulatorGraphics g, String str, int height, int TIPSTR_LEFT, int TIPSTR_RIGHT, int rectX, int rectY, int rectWidth, int rectHeight, Color color) {
        g.setColor(color);
        int strWidth = g.getEmulatorFont().stringWidth(str);
        int strHeight = g.getEmulatorFont().getHeight();
        if (strWidth < rectWidth) {
            g.drawString(str, rectX, height - strHeight / 2, EmulatorGraphics.LT);
            return;
        }
        tipStringPos -= tipStringSpeed;
        if (tipStringPos + strWidth < TIPSTR_LEFT) {
            tipStringPos = TIPSTR_RIGHT;
        }
        //�ü���
        int oldClipX = g.getClipX();
        int oldClipY = g.getClipY();
        int oldClipWidth = g.getClipWidth();
        int oldClipHeight = g.getClipHeight();
        g.setClip(rectX, rectY, rectWidth, rectHeight);
        g.drawString(str, tipStringPos, height - strHeight / 2, EmulatorGraphics.LT);
        g.setClip(oldClipX, oldClipY, oldClipWidth, oldClipHeight);

    }

    public static void drawImage(EmulatorImage src, int x_src, int y_src, int width, int height, int x_dest, int y_dest, int anchor, EmulatorGraphics g) {
        g.drawRegion(src, x_src, y_src, width, height, 0, x_dest, y_dest, anchor);
    }
    private static int width;
    private static int height;
    private static char cha;
    public static int REDNUM = 0;
    public static int GREENNUM = 1;

    /**
     * ������ͼƬ
     *
     * @param imgNumber
     * @param number
     * @param x
     * @param y
     * @param g
     * @param type
     * @param atype 0 ��ɫͼƬ 1 ��ɫͼƬ
     */
    public static void drawNumber(EmulatorGraphics g, int number, int x, int y, int w, int type, int atype) {
        ImageManager im = ImageManager.getInstance();
        EmulatorImage imgNumber = im.getImage(Const.ImagePath.NUMS);
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
                        g);
                    break;
                case '1':
                    drawImage(imgNumber, 1 * width, atype * height, width, height, x, y,
                        0, g);
                    break;
                case '2':
                    drawImage(imgNumber, 2 * width, atype * height, width, height, x, y,
                        0, g);
                    break;
                case '3':
                    drawImage(imgNumber, 3 * width, atype * height, width, height, x, y,
                        0, g);
                    break;
                case '4':
                    drawImage(imgNumber, 4 * width, atype * height, width, height, x, y,
                        0, g);
                    break;
                case '5':
                    drawImage(imgNumber, 5 * width, atype * height, width, height, x, y,
                        0, g);
                    break;
                case '6':
                    drawImage(imgNumber, 6 * width, atype * height, width, height, x, y,
                        0, g);
                    break;
                case '7':
                    drawImage(imgNumber, 7 * width, atype * height, width, height, x, y,
                        0, g);
                    break;
                case '8':
                    drawImage(imgNumber, 8 * width, atype * height, width, height, x, y,
                        0, g);
                    break;
                case '9':
                    drawImage(imgNumber, 9 * width, atype * height, width, height, x, y,
                        0, g);
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
     * ��һ�����Ű�
     */
    public final static int NUMBER_LEFT = 1;
    public final static int NUMBER_RIGHT = 2;
    public final static int NUMBER_UP = 3;
    public final static int NUMBER_DOWN = 4;

    /**
     * ��ָ����������Զ����е��ı�
     * @param g ����
     * @param str Ҫ���Ƶ��ַ���
     * @param x  ��ʼx����
     * @param y  ��ʼy����
     * @param wid ������
     * @param hei ����߶�
     * @param color �ı���ɫ
     */
    public static void drawWordWrapString(EmulatorGraphics g, String str, int x, int y, int wid, int hei, Color color) {
        g.setClip(x, y, wid, hei);
        g.setColor(color);
        char[] txt = str.toCharArray();
        for (int i = 0, col = 0, line = 0; i < txt.length; i++) {
            g.drawChar(txt[i], x + col * (g.getEmulatorFont().charWidth(txt[0]) + 1), y + line * (g.getEmulatorFont().getHeight()), EmulatorGraphics.LT);
            if ((col + 1) * (g.getEmulatorFont().charWidth(txt[0]) + 1) >= wid) {
                col = 0;
                line++;
            } else {
                col++;
            }

        }
        g.setClip(0, 0, GameData.getGameData().screenWidth, GameData.getGameData().screenHeight);

    }

}
