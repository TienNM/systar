package emulator.engine.engine.animation;

import emulator.EmulatorGraphics;

/**
 *
 * ����������
 */
public class AnimationPlayer {

    private static AnimationPlayer animationPlayer = new AnimationPlayer();
    private AnimationPool animationPool = AnimationPool.getInstance();
    private boolean isRun = false;//�������������б�ʶ

    private AnimationPlayer() {
    }

    public static AnimationPlayer getInstance() {
        return animationPlayer;
    }

    public void removeAllAnimations() {
        animationPool.removeAllAnimations();
    }

    /**
     * ��ʼ����ָ���Ķ���
     * @param animation Ҫ���ŵĶ���
     * @param x ����λ�õ�x����
     * @param y ����λ�õ�y����
     * @param anchor ê��
     */
    public void playAnimation(Animation animation, int x, int y) {
        if (animation == null) {
            return;
        }
        Animation ani = null;
        ani = animation.getClone();
        ani.x = x;
        ani.y = y;
        animationPool.addAnimation(ani);
    }

    /**
     * ��ָ����ͼ���豸�ϲ��Ŷ������˷���ֻӦ������������ѭ���е���
     * @param eg ����
     */
    public void playNoClear(EmulatorGraphics eg) {
//        System.out.println(animationPool.size());
        /**
         * 1.˳�򲥷Ŷ������еĶ���
         * 2.��������
         */
        if (!isRun) {
            return;
        }
        Animation ani = null;
//        Frame frame = null;
//        Image img = null;
        for (int i = 0; i < animationPool.size(); i++) {
            /**
             * 1.�������ж����ĵ�ǰ֡
             * 2.���ж����ĵ�ǰ֡����
             */
            ani = animationPool.getAnimation(i);
//            frame = ani.frames[ani.curIndex];
            int picw = ani.image.getWidth() / ani.frameWidth;

            if (ani.getCurFrame() != null) {
                eg.drawRegion(ani.image, (ani.getCurFrame().num - 1) % picw * ani.frameWidth,
                        (ani.getCurFrame().num - 1) / picw * ani.frameHeight,
                        ani.frameWidth, ani.frameHeight, 0, ani.x + ani.getCurFrame().offsetX, ani.y + ani.getCurFrame().offsetY, EmulatorGraphics.HV);
            }
//            img = frame.image;
//            g.drawImage(img, ani.x + frame.offsetX, ani.y + frame.offsetY, Graphics.HCENTER | Graphics.VCENTER);
            ani.curIndex++;
            if (ani.curIndex >= ani.frameNum) {
                ani.curIndex = 0;
            }
        }
//        animationPool.clear();//���������Ӱ���˶����Ĳ����ٶȣ����Կ�������һ�߳�ר����������
    }

    /**
     * ��ָ����ͼ���豸�ϲ��Ŷ������˷���ֻӦ������������ѭ���е���
     * @param eg ����
     */
    public void play(EmulatorGraphics eg) {
//        System.out.println(animationPool.size());
        /**
         * 1.˳�򲥷Ŷ������еĶ���
         * 2.��������
         */
        if (!isRun) {
            return;
        }
        Animation ani = null;
//        Frame frame = null;
//        Image img = null;
        for (int i = 0; i < animationPool.size(); i++) {
            /**
             * 1.�������ж����ĵ�ǰ֡
             * 2.���ж����ĵ�ǰ֡����
             */
            ani = animationPool.getAnimation(i);
//            frame = ani.frames[ani.curIndex];
            int picw = ani.image.getWidth() / ani.frameWidth;

            if (ani.getCurFrame() != null) {
                eg.drawRegion(ani.image, (ani.getCurFrame().num - 1) % picw * ani.frameWidth,
                        (ani.getCurFrame().num - 1) / picw * ani.frameHeight,
                        ani.frameWidth, ani.frameHeight, 0, ani.x + ani.getCurFrame().offsetX, ani.y + ani.getCurFrame().offsetY, EmulatorGraphics.HV);
            }
//            img = frame.image;
//            g.drawImage(img, ani.x + frame.offsetX, ani.y + frame.offsetY, Graphics.HCENTER | Graphics.VCENTER);
            ani.curIndex++;
            if (ani.curIndex >= ani.frameNum) {

                animationPool.clear();//���������Ӱ���˶����Ĳ����ٶȣ����Կ�������һ�߳�ר����������
                ani.curIndex = 0;
            }
        }

    }

    /**
     * ��������������
     */
    public void start() {
        isRun = true;
    }

    /**
     * ����ֹͣ�������������������δ������Ķ���
     */
    public void stop() {
        isRun = false;
        animationPool.removeAllAnimations();
    }
}
