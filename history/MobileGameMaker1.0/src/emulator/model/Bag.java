package emulator.model;

import system.ArrayList;

/**
 *
 * ����
 */
public class Bag {

    public static final byte ITEM = 0;
    public static final byte EQUIP = 1;
    public static final byte SKILL = 2;
    GameData gd = GameData.getGameData();
    /**
     * �������Է����ֶ�������ͨ��Ʒ��װ���ͼ���
     * list[0] ��ͨ��Ʒ
     * list[1] װ��
     * list[2] ����
     */
    private ArrayList[] list = new ArrayList[3];

    public Bag() {
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList();
        }
    }
/**
 * ��ȡ�����е���Ʒ
 * @param type ��Ʒ���� ��ȡBag.ITEM Bag.EQUIP Bag.SKILL
 * @param index ��Ʒ�ı��
 * @return ����������д���Ʒ�򷵻ش���Ʒ�����򷵻�null
 */
    public BaseItem get(byte type, int index) {
        if (list[type].has(index)) {
            return gd.gameObjectManager.getBaseItem(type, index);
        } else {
            return null;
        }
    }
/**
 * ��ȡ�����е���Ʒ����
 * @param type ��Ʒ���� ��ȡBag.ITEM Bag.EQUIP Bag.SKILL
 * @param index ��Ʒ�ı��
 * @return ����������д���Ʒ�򷵻ش���Ʒ�����򷵻�0
 */
    public int getNum(byte type, int index) {
        return gd.gameObjectManager.getBaseItem(type, index).num;
    }
/**
 * ��鱳�����Ƿ���ָ������ָ����ŵ���Ʒ
 * @param type ��Ʒ���� ��ȡBag.ITEM Bag.EQUIP Bag.SKILL
 * @param index ��Ʒ�ı��
 * @return ����������д���Ʒ�򷵻�true�����򷵻�false
 */
    public boolean has(byte type, int index) {
        return list[type].has(index);
    }
/**
 * �򱳰������num������Ϊtype���Ϊindex����Ʒ
 * @param type ��Ʒ���� ��ȡBag.ITEM Bag.EQUIP Bag.SKILL
 * @param index ��Ʒ�ı��
 * @param num Ҫ��ӵ�����
 */
    public void add(byte type, int index, int num) {
        if (!has(type, index)) {
            list[type].add(index);
        }
        gd.gameObjectManager.getBaseItem(type, index).num += num;
    }

    public void del(byte type, int index, int num) {
        if (has(type, index)) {
            gd.gameObjectManager.getBaseItem(type, index).num -= num;
            if (gd.gameObjectManager.getBaseItem(type, index).num <= 0) {
                gd.gameObjectManager.getBaseItem(type, index).num = 0;
                list[type].remove(index);
            }
        }
    }

    public int[] getList(int type){
        return list[type].toArray();
    }


}
