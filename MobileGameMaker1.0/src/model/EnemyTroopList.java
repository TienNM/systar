package model;

import java.util.Vector;

//
public class EnemyTroopList extends Vector {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public void addEnemyTroop(EnemyTroop EnemyTroop) {
        addElement(EnemyTroop);
    }

    public void delEnemyTroop(int index) {
        //ɾ�������б���ָ�����ܱ�ŵļ���
        removeElementAt(index);
    }

    public EnemyTroop EnemyTroopAt(int num) {
        //��ȡ���ܱ���ָ��λ�õļ���
        return (EnemyTroop) elementAt(num);
    }

    public EnemyTroop getEnemyTroop(int index) {
        //���ؼ����б���ָ�����ܱ�ŵļ���
        EnemyTroop EnemyTroop = null;
        if (hasEnemyTroop(index)) {
            for (int i = 0; i < size(); i++) {
                EnemyTroop = (EnemyTroop) elementAt(i);
                if (EnemyTroop.index == index) {
                    break;
                }
            }
        }
        return EnemyTroop;

    }

    public int getMaxIndex() {
        int max = 0;
        EnemyTroop EnemyTroop = null;
        for (int i = 0; i < size(); i++) {
            EnemyTroop = EnemyTroopAt(i);
            if (EnemyTroop.index > max) {
                max = EnemyTroop.index;
            }
        }
        return max;
    }

    public boolean hasEnemyTroop(int index) {
        //����Ƿ���ָ����ŵļ���
        boolean judge = false;
        EnemyTroop EnemyTroop = null;
        for (int i = 0; i < size(); i++) {
            EnemyTroop = (EnemyTroop) elementAt(i);
            if (EnemyTroop.index == index) {
                judge = true;
                break;
            }
        }
        return judge;
    }
}
