package emulator.engine;

import emulator.engine.script.Event;

/**
 *
 * �൱��MVC�еĿ�������C��
 */
public interface Control {

//    public static final int KEY_UP = -1;// �ϼ�
//    public static final int KEY_DOWN = -2;// �¼�
//    public static final int KEY_LEFT = -3;// ���
//    public static final int KEY_RIGHT = -4;// �Ҽ�
//    public static final int KEY_FIRE = -5;// �м�
//    public static final int KEY_LS = -6;// �����
//    public static final int KEY_RS = -7;// �����
//    public static final int KEY_0 = 48;// 0��
//    public static final int KEY_1 = 49;// 1��
//    public static final int KEY_2 = 50;// 2��
//    public static final int KEY_3 = 51;// 3��
//    public static final int KEY_4 = 52;// 4��
//    public static final int KEY_5 = 53;// 5��
//    public static final int KEY_6 = 54;// 6��
//    public static final int KEY_7 = 55;// 7��
//    public static final int KEY_8 = 56;// 8��
//    public static final int KEY_9 = 57;// 9��
//    public static final int KEY_STAR = 42;// *��
//    public static final int KEY_POUND = 35;// #��

    public void keyPressed(View view, int key);

    public void dealEvent(View view, Event event);
}
