/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emulator.engine.engine.animation;

import emulator.EmulatorImage;
import emulator.model.Frame;

/**
 *
 * ����
 */
public class Animation {

    public int index = 0;// ���
    public String name = "";// ����
    public String soundName = "";// ��Ч����
    public String imageName = "";// ����ԴͼƬ����
    public EmulatorImage image = null;
    public int frameWidth = 0;// ֡��
    public int frameHeight = 0;// ֡��
    public int frameNum = 0;// ֡��
    public Frame[] frames = null;// ֡
    public int curIndex = 0;// ��ǰ֡��
    //���������ڲ���ʱȷ��
    public int x = 0;//������׼��x����
    public int y = 0;//������׼��y����

    public Frame getCurFrame() {
        Frame frame = null;
        if (curIndex >= 0 && curIndex < frameNum) {
            frame = frames[curIndex];
        }
        return frame;
    }

    public Animation getClone() {
        Animation ani = new Animation();
//        ani.frameHeight = this.frameHeight;
//        ani.frameNum = this.frameWidth;
//        ani.frames = this.frames;
//        ani.image = this.image;
//        ani.imageName = this.imageName;
//        ani.index = this.index;
//        ani.name = this.name;
//        ani.soundName = this.soundName;
        ani.index = this.index;
        ani.name = this.name;
        ani.imageName = this.imageName;
        ani.soundName = this.soundName;
        ani.image = this.image;
        ani.frameWidth = this.frameWidth;
        ani.frameHeight = this.frameHeight;
        ani.frameNum = this.frameNum;
        ani.frames = this.frames;

        return ani;

    }

//    public void paint(Graphics g, int x, int y) {
//        int picw = image.getWidth() / this.frameWidth;
//
//        if (getCurFrame() != null) {
//            g.drawRegion(image, (getCurFrame().num - 1) % picw * frameWidth,
//                (getCurFrame().num - 1) / picw * frameHeight,
//                frameWidth, frameHeight, 0, x + getCurFrame().offsetX, y + getCurFrame().offsetY, 0);
//        }
//        update();
//
//    }
//
//    public void paint(Graphics g, int x, int y, int miaodian) {
//        int picw = image.getWidth() / this.frameWidth;
//
//        if (getCurFrame() != null) {
//            g.drawRegion(image, (getCurFrame().num - 1) % picw * frameWidth,
//                (getCurFrame().num - 1) / picw * frameHeight,
//                frameWidth, frameHeight, 0, x + getCurFrame().offsetX, y + getCurFrame().offsetY, miaodian);
//        }
//        update();
//
//    }
//
//    public void update() {
//        this.curIndex++;
//        if (curIndex >= frameNum) {
//            curIndex = 0;
//        }
//    }
    public Frame getFrame(int index) {
        Frame frame = null;
        if (index >= 0 && index < frameNum) {
            frame = frames[index];
        }
        return frame;
    }

    public void setCurIndex(int curIndex) {
        this.curIndex = curIndex;
    }

    public int getCurIndex() {
        return curIndex;
    }
}
