package emulator.model;

import emulator.EmulatorFont;

/**
 * ���������еĳ���
 */
public final class Const {

    public static final class ImagePath {

        public static final String DIALOG_DEEP = "product/image/skin/dialog.png";
        public static final String DIALOG_LIGHT = "product/image/skin/dialog2.png";
        public static final String CELL_LIGHT = "product/image/skin/dialog3.png";
        public static final String CELL_DEEP = "product/image/skin/dialog4.png";
        public static final String TRENCH = "product/image/skin/trench.png";
        public static final String SMALLTRIANGLE = "product/image/skin/sja.png";
        public static final String BALL = "product/image/skin/ball.png";
        public static final String NUMS = "product/image/skin/nums.png";
        public static final String MAPMENU = "product/image/skin/mapmenu.png";
        public static final String SELECT = "product/image/skin/select.png";
    }

    /**
     * ê��
     */
    public static final class Anchor {

        public static final int LT = 0;
        public static final int LV = 1;
        public static final int LB = 2;
        public static final int HT = 3;
        public static final int HV = 4;
        public static final int HB = 5;
        public static final int RT = 6;
        public static final int RV = 7;
        public static final int RB = 8;
    }

    /**
     * ����
     */
    public static final class Font {

        public static final EmulatorFont FONTSMALL_PLAIN = EmulatorFont.getEmulatorFont(EmulatorFont.FACE_SYSTEM, EmulatorFont.STYLE_PLAIN, EmulatorFont.SIZE_SMALL);
        public static final EmulatorFont FONTMEDIUM_PLAIN = EmulatorFont.getEmulatorFont(EmulatorFont.FACE_SYSTEM, EmulatorFont.STYLE_PLAIN, EmulatorFont.SIZE_MEDIUM);
        public static final EmulatorFont FONTLARGE_PLAIN = EmulatorFont.getEmulatorFont(EmulatorFont.FACE_SYSTEM, EmulatorFont.STYLE_PLAIN, EmulatorFont.SIZE_LARGE);
        public static final EmulatorFont FONTSMALL_BOLD = EmulatorFont.getEmulatorFont(EmulatorFont.FACE_SYSTEM, EmulatorFont.STYLE_BOLD, EmulatorFont.SIZE_SMALL);
        public static final EmulatorFont FONTMEDIUM_BOLD = EmulatorFont.getEmulatorFont(EmulatorFont.FACE_SYSTEM, EmulatorFont.STYLE_BOLD, EmulatorFont.SIZE_MEDIUM);
        public static final EmulatorFont FONTLARGE_BOLD = EmulatorFont.getEmulatorFont(EmulatorFont.FACE_SYSTEM, EmulatorFont.STYLE_BOLD, EmulatorFont.SIZE_LARGE);
    }

    /**
     *  ��ֵ
     */
    public static final class Key {

        public static final byte KEY_UP = -1;//�ϼ�
        public static final byte KEY_DOWN = -2;//�¼�
        public static final byte KEY_LEFT = -3;//���
        public static final byte KEY_RIGHT = -4;//�Ҽ�
        public static final byte KEY_FIRE = -5;//�м�
        public static final byte KEY_LS = -6;//�����
        public static final byte KEY_RS = -7;//�����
        public static final byte KEY_0 = 48;//0��
        public static final byte KEY_1 = 49;//1��
        public static final byte KEY_2 = 50;//2��
        public static final byte KEY_3 = 51;//3��
        public static final byte KEY_4 = 52;//4��
        public static final byte KEY_5 = 53;//5��
        public static final byte KEY_6 = 54;//6��
        public static final byte KEY_7 = 55;//7��
        public static final byte KEY_8 = 56;//8��
        public static final byte KEY_9 = 57;//9��
        public static final byte KEY_STAR = 42;//*��
        public static final byte KEY_POUND = 35;//#��
    }

    /**
     * ��ɫ
     */
    public static final class Color {

        public static final int black = 0xff000000;// ��ɫ
        public static final int BLACK = 0xff000000;// ��ɫ
        public static final int blue = 0xff0000ff;// ��ɫ
        public static final int BLUE = 0xff0000ff;// ��ɫ
        public static final int cyan = 0xff00ffff;// ��ɫ
        public static final int CYAN = 0xff00ffff;// ��ɫ
        public static final int DARK_GRAY = 0xff404040;// ���ɫ
        public static final int darkGray = 0xff404040;// ���ɫ
        public static final int gray = 0xff808080;// ��ɫ
        public static final int GRAY = 0xff808080;// ��ɫ
        public static final int green = 0xff00ff00;// ��ɫ
        public static final int GREEN = 0xff00ff00;// ��ɫ
        public static final int LIGHT_GRAY = 0xffc0c0c0;// ǳ��ɫ
        public static final int lightGray = 0xffc0c0c0;// ǳ��ɫ
        public static final int magenta = 0xffff00ff;// ���ɫ
        public static final int MAGENTA = 0xffff00ff;// ���ɫ
        public static final int orange = 0xffffc800;// �ۻ�ɫ
        public static final int ORANGE = 0xffffc800;// �ۻ�ɫ
        public static final int pink = 0xffffafaf;// �ۺ�ɫ
        public static final int PINK = 0xffffafaf;// �ۺ�ɫ
        public static final int red = 0xffff0000;// ��ɫ
        public static final int RED = 0xffff0000;// ��ɫ
        public static final int white = 0xffffffff;// ��ɫ
        public static final int WHITE = 0xffffffff;// ��ɫ
        public static final int yellow = 0xffffff00;// ��ɫ
        public static final int YELLOW = 0xffffff00;// ��ɫ
    }

    /**
     * �ַ���
     */
    public static final class Str {

        /**
         * �˵�
         */
        public static final String[] MENU_MENU = {"��ʼ��Ϸ", "������Ϸ", "��Ϸ����", "��Ϸ����", "������Ϸ", "�˳���Ϸ"};
        public static final String[] MENU_MAP = {"�ҵ�״̬", "�ҵı���", "�ҵ�װ��", "�ҵļ���", "�������", "�����˵�"};
        public static final String[] KINDS = {"ͷ��", "��Ʒ", "����", "����", "����", "սѥ"};
    }

    /**
     * ��־
     */
    public static final class ViewId {

        /**
         * ��ͼ
         */
        public static final byte VIEW_MENU = 0;//�˵�
        public static final byte VIEW_MAP = 1;//��ͼ
        public static final byte VIEW_SETTING = 2;//����
        public static final byte VIEW_HELP = 3;//����
        public static final byte VIEW_ABOUT = 4;//��Ϸ
        public static final byte VIEW_BATTLE = 5;//ս��
        public static final byte VIEW_SKILL = 6;//����
        public static final byte VIEW_BAG = 7;//����
        public static final byte VIEW_STATE = 8;//״̬
        public static final byte VIEW_EQUIP = 9;//װ��
        public static final byte VIEW_SHOP = 10;//�̵�
    }
}
