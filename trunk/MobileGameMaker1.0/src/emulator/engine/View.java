package emulator.engine;

import emulator.EmulatorGraphics;


/**
 *
 * ��ͼ�ӿڣ��൱��MVC�е�V
 */
public interface View {

    /**
     * ��ʼ����ͼ
     *
     */
    public void init();

    /**
     * ������ͼ
     *
     * @param g
     *            ����
     */
    public void paint(EmulatorGraphics eg);

    /**
     * �ͷ���ͼ��Դ
     *
     */
    public void release();

    /**
     * �ػ���ͼ
     */
    public void repaint();
//    public void logic();
}
