package emulator.model;

import emulator.engine.script.DataHandlerInterface;

/**
 *
 * ���ݴ�����
 */
public class DataHandler implements DataHandlerInterface {

    GameData gd = GameData.getGameData();

    public int getVar(int index) {
        return gd.vars[index];
    }

    public void setVar(int index, int value) {
        gd.vars[index] = value;
    }

    public boolean getSwitch(int index) {
        return gd.switchs[index];
    }

    public void setSwitch(int index, boolean value) {
        gd.switchs[index] = value;
    }

    public int getExp() {
        return gd.player.exp;
    }
    //bug������ ��Ӧ�õ����޸ľ���ֵ�����Ӿ���ֵʱ��һ������ֵ����������Ҫ���飬������ 2.26

    public void setExp(int value) {
//        gd.player.exp = value;
        gd.player.addExp(value - gd.player.exp);
    }

    public int getMoney() {
        return gd.player.money;
    }

    public void setMoney(int value) {
        gd.player.money = value;
    }

    public int getLevel() {
        return gd.player.lev;
    }

    public void setLevel(int value) {
        gd.player.lev = value;
        gd.player.updateProperties();
    }

    public int getMaxHp() {
        return gd.player.maxHp;
    }

    public void setMaxHp(int value) {
        gd.player.maxHp = value;
    }

    public int getHp() {
        return gd.player.hp;
    }

    public void setHp(int value) {
        gd.player.hp = value;
    }

    public int getMaxSp() {
        return gd.player.maxSp;
    }

    public void setMaxSp(int value) {
        gd.player.maxSp = value;
    }

    public int getSp() {
        return gd.player.sp;
    }

    public void setSp(int value) {
        gd.player.sp = value;
    }

    public int getStre() {
        return gd.player.stre;
    }

    public void setStre(int value) {
        gd.player.stre = value;
    }

    public int getAgil() {
        return gd.player.agil;
    }

    public void setAgil(int value) {
        gd.player.agil = value;
        gd.player.maxHp = gd.gameObjectManager.getPlayer().hp + gd.player.stre * 20;//��ʼֵΪ
    }

    public int getInte() {
        return gd.player.inte;
    }

    public void setInte(int value) {
        gd.player.inte = value;
        gd.player.maxSp = gd.gameObjectManager.getPlayer().sp + gd.player.inte * 15;//��ʼֵΪ
    }

    public int getItemNum(int index) {
        return gd.player.bag.getNum(Bag.ITEM, index);
    }

    public void setItemNum(int index, int value) {
        int num = gd.player.bag.getNum(Bag.ITEM, index);
        if (num > value) {
            //����
            gd.player.bag.del(Bag.ITEM, index, num - value);
        } else if (num < value) {
            //����
            gd.player.bag.add(Bag.ITEM, index, value - num);
        }
    }

    public int getEquipNum(int index) {
        return gd.player.bag.getNum(Bag.EQUIP, index);
    }

    public void setEquipNum(int index, int value) {
        int num = gd.player.bag.getNum(Bag.EQUIP, index);
        if (num > value) {
            //����
            gd.player.bag.del(Bag.EQUIP, index, num - value);
        } else if (num < value) {
            //����
            gd.player.bag.add(Bag.EQUIP, index, value - num);
        }
    }

    public boolean getSkillStatus(int index) {
        return gd.player.bag.has(Bag.SKILL, index);
    }

    public void setSkillStatus(int index, boolean value) {
        if (value) {
            //��Ӽ���
            gd.player.bag.add(Bag.SKILL, index, 1);
        } else {
            //ɾ������
            gd.player.bag.del(Bag.SKILL, index, 1);
        }
    }
}
