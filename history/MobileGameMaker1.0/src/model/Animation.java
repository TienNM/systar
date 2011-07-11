/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Image;

/**
 *
 * ����
 */
public class Animation {

    public int index = 0;// ���
    public String name = "";// ����
    public String soundName = "";// ��Ч����
    public String imageName = "";// ����ԴͼƬ����
    public Image image = null;
    public int frameWidth = 0;// ֡��
    public int frameHeight = 0;// ֡��
    public int frameNum = 0;// ֡��
    public Frame[] frames = null;// ֡
    private int curIndex = 0;// ��ǰ֡��

    public Frame getCurFrame() {
        Frame frame = null;
        if (curIndex >= 0 && curIndex < frameNum) {
            frame = frames[curIndex];
        }
        return frame;
    }

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
