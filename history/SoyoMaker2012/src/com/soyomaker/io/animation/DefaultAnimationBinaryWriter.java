/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soyomaker.io.animation;

import com.soyomaker.model.animation.Action;
import com.soyomaker.model.animation.Animation;
import com.soyomaker.model.animation.Picture;
import com.soyomaker.model.animation.Clip;
import com.soyomaker.model.animation.Frame;
import com.soyomaker.AppData;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;

/**
 *
 * @author Administrator
 */
public class DefaultAnimationBinaryWriter implements IAnimationWriter {

    private AppData data = AppData.getInstance();

    public void writeAnimation(String filename) throws Exception {
        FileOutputStream fos = null;
        DataOutputStream dos = null;

        fos = new FileOutputStream(filename);
        dos = new DataOutputStream(fos);

//        System.out.println("图片总数：" + data.getCurProject().getPictures().size());
        dos.writeInt(data.getCurProject().getPictures().size());
        //int allClipsNum = 0;//计算当期总共有多少个Clip
        for (int i = 0; i < data.getCurProject().getPictures().size(); i++) {
            Picture pic = data.getCurProject().getPictures().get(i);
            dos.writeUTF(data.getCurProject().getPath()
                    + File.separator + "image" + File.separator + "animation" + File.separator + pic.getSourceImageFile());
            dos.writeInt(pic.getTiles().size());
            for (int j = 0; j < pic.getTiles().size(); j++) {
                Clip t = pic.getTile(j);
                dos.writeInt(data.getCurProject().getClips().indexOf(t));
                //dos.writeInt(allClipsNum + j);//写入全局唯一的Index
//                System.out.println("源图 切块ID:" + data.getCurProject().getClips().indexOf(t));
                dos.writeInt(t.getSourcePoint().x);
                dos.writeInt(t.getSourcePoint().y);
                dos.writeInt(t.getW());
                dos.writeInt(t.getH());
            }
            //allClipsNum += pic.getTiles().size();
        }
        dos.writeInt(data.getCurProject().getAnimationCounts());
//        System.out.println("动画总数：" + data.getCurProject().getAnimationCounts());
        int allFramsNum = 0;//计算当期总共有多少个Frame
        Iterator it = data.getCurProject().getAnimations().keySet().iterator();
        while (it.hasNext()) {
            Integer key = (Integer) it.next();
            Animation ani = data.getCurProject().getAnimations().get(key);
            if (ani != null) {
                dos.writeInt(ani.getIndex());
//                System.out.println("动画ID:" + ani.getIndex());
                dos.writeUTF(ani.getName());
                int framesSize = ani.getFrames().size();
//                System.out.println("帧总数:" + framesSize);
                dos.writeInt(framesSize);
                for (int i = 0; i < framesSize; i++) {
                    Frame frame = ani.getFrame(i);
                    dos.writeInt(allFramsNum + i);
//                    System.out.println("帧ID:" + (allFramsNum + i));
                    dos.writeInt(frame.getDelay());
                    dos.writeInt(frame.getW());
                    dos.writeInt(frame.getH());
                    dos.writeInt(frame.getTiles().size());
                    for (int j = 0; j < frame.getTiles().size(); j++) {
                        Clip t = frame.getTiles().get(j);
                        dos.writeInt(data.getCurProject().getClips().indexOf(t));
//                        System.out.println("帧 切块ID:" + data.getCurProject().getClips().indexOf(t));
                        dos.writeInt(t.getFramePoint().x);
                        dos.writeInt(t.getFramePoint().y);
                        dos.writeInt(t.getTransparency());
                        dos.writeBoolean(t.isMirror());
                        dos.writeInt(t.getRotation());
                        dos.writeFloat(t.getZoom());
                        dos.writeInt(t.getRenderType());
                    }
                }
                allFramsNum += framesSize;
                int actionsSize = ani.getActions().size();
//                System.out.println("特效总数:" + actionsSize);
                dos.writeInt(actionsSize);
                for (int i = 0; i < actionsSize; i++) {
                    Action act = ani.getActions().get(i);
                    dos.writeInt(act.getFrameId());
                    dos.writeUTF(data.getCurProject().getPath() + File.separator
                            + "audio" + File.separator + "sound" + File.separator + act.getMusicFile());
                    dos.writeInt(act.getType());
                    dos.writeInt(act.getRed());
                    dos.writeInt(act.getGreen());
                    dos.writeInt(act.getBlue());
                    dos.writeInt(act.getAlpha());
                    dos.writeInt(act.getDuration());
                }
            }
        }
        dos.close();
        fos.close();
    }
}
