package model;

import java.util.Vector;

//��Һ͵������ϱ���һ����Ʒ�����ڱ����ɫ�����˵�ǰ��ӵ�е���Ʒ
public class EnemyList extends Vector {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public void addEnemy(Enemy enemy) {
        addElement(enemy);
    }

    public void delEnemy(int index) {
        //ɾ�������б���ָ�����ܱ�ŵļ���
        removeElementAt(index);
    }

    public Enemy enemyAt(int num) {
        //��ȡ���ܱ���ָ��λ�õļ���
        return (Enemy) elementAt(num);
    }

    public Enemy getEnemy(int index) {
        //���ؼ����б���ָ�����ܱ�ŵļ���
        Enemy enemy = null;
        if (hasEnemy(index)) {
            for (int i = 0; i < size(); i++) {
                enemy = (Enemy) elementAt(i);
                if (enemy.getIndex() == index) {
                    break;
                }
            }
        }
        return enemy;

    }

    public int getMaxIndex() {
        int max = 0;
        Enemy enemy = null;
        for (int i = 0; i < size(); i++) {
            enemy = enemyAt(i);
            if (enemy.getIndex() > max) {
                max = enemy.getIndex();
            }
        }
        return max;
    }

    public boolean hasEnemy(int index) {
        //����Ƿ���ָ����ŵļ���
        boolean judge = false;
        Enemy enemy = null;
        for (int i = 0; i < size(); i++) {
            enemy = (Enemy) elementAt(i);
            if (enemy.getIndex() == index) {
                judge = true;
                break;
            }
        }
        return judge;
    }
}
