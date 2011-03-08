package emulator.model;

import emulator.EmulatorImage;

/**
 *
 * ��Ʒ�����ܡ�װ���ĸ���
 */
public abstract class BaseItem {

    /**
     * ���幥������
     */
    public static final byte SKILL_SINGLE = 0;
    /**
     * ȫ�幥������
     */
    public static final byte SKILL_ALL = 1;
    /**
     * �����Լ���
     */
    public static final byte SKILL_ASSIST = 2;
    /**
     * ���幥����Ʒ
     */
    public static final byte ITEM_SINGLE = 0;
    /**
     * ȫ�幥����Ʒ
     */
    public static final byte ITEM_ALL = 1;
    /**
     * ��������Ʒ
     */
    public static final byte ITEM_ASSIST = 2;
    /**
     * ������Ʒ
     */
    public static final byte ITEM_OTHER = 3;
    /**
     * ͷ��
     */
    public static final byte EQUIP_HELM = 0;
    /**
     * ��Ʒ
     */
    public static final byte EQUIP_JEWELRY = 1;
    /**
     * ����
     */
    public static final byte EQUIP_WEAPON = 2;
    /**
     * ����
     */
    public static final byte EQUIP_SHIELD = 3;
    /**
     * ����
     */
    public static final byte EQUIP_ARMOUR = 4;
    /**
     * սѥ
     */
    public static final byte EQUIP_BOOTS = 5;
    public int index;//���
    public String name;//����
    public String intro;//����
    public EmulatorImage icon;//ͼ��
    public int kind;//����
    public int num;
    public int price;//����۸�
}
