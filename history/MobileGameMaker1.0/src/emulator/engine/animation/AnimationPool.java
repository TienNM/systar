package emulator.engine.animation;

import java.util.Vector;

/**
 *
 * ������
 */
public class AnimationPool extends Vector {

    private static AnimationPool animationPool = new AnimationPool();

    public static AnimationPool getInstance() {
        return animationPool;
    }

    private AnimationPool() {
    }

    /**
     * ��Ӷ���
     * @param animation Ҫ��ӵĶ���
     */
    public void addAnimation(Animation animation) {
        System.out.println("addAnimation");
        addElement(animation);
    }

    /**
     * ����������е����ж���
     */
    public void removeAllAnimations() {
        removeAllElements();
    }

    /**
     * �������أ��Ƴ����в�����Ķ���
     */
    public void clear() {

        int len = size();
        Animation temp = null;
        for (int i = 0; i < len; i++) {
            temp = (Animation) elementAt(i);
            if (temp.curIndex == temp.frameNum) {
                System.out.println("clear");
                this.removeElementAt(i);
                i--;
                len--;
            }
        }
    }

    /**
     * ��ȡ��������ָ��λ�õĶ���
     * @param i ָ����λ��
     * @return ָ��λ�õĶ���
     */
    public Animation getAnimation(int i) {
        return (Animation) elementAt(i);
    }
}
