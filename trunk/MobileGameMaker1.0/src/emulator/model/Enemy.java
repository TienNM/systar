package emulator.model;

import emulator.EmulatorImage;
import system.Tools;

/**
 * ����
 */
public class Enemy extends Character {

    public int index = 0;//���
//    private String Property; //�������� Ԫ����� ��ľˮ����
    private boolean isDead = false;//����״̬
    public EmulatorImage BattImg = null;//ս��ͼ
    public int[] skillList;
    /**********************************************/
    public int BattX, BattY;//ս��ʱ����
    public int changeHp;

    /**********************************************/
    public Enemy() {
    }

    public int AI() {
        //����ai������ ��������Ӱ��ai
//        int cur = -1;//��ǰ����
        if ((this.sp <= 0) || (this.skillList.length == 0)) {
            return -1;
        }
        int temp = Tools.GetRandom(100);
        temp += this.inte / 10;//�����ߵ� �ż��ܵĸ��ʼӳɣ�100�����ӳ�10%
        if (temp < 90) {// ���� ���������� ������Ӱ��
            return -1;
        } else {
            return -2;
        }

        /**
         * -1 ��ͨ����
         * -2 ħ������
         * û��ħ������ħ��ֵΪ0ֱ�ӷ���-1
         */
    }
    //ʵ�ֶ����¡

    public Enemy getClone() {
        Enemy enemy = new Enemy();
        enemy.BattImg = this.BattImg;
        enemy.BattX = this.BattX;
        enemy.BattY = this.BattY;
        enemy.agil = this.agil;
        enemy.atk = this.atk;
        enemy.def = this.def;
        enemy.exp = this.exp;
        enemy.flee = this.flee;
        enemy.headImg = this.headImg;
        enemy.hp = this.hp;
        enemy.index = this.index;
        enemy.inte = this.inte;
        enemy.intro = this.intro;
        enemy.isDead = this.isDead;
        enemy.lev = this.lev;
        enemy.maxHp = this.maxHp;
        enemy.maxSp = this.maxSp;
        enemy.money = this.money;
        enemy.name = this.name;
        enemy.sp = this.sp;
        enemy.stre = this.sp;
        enemy.waitTime = this.waitTime;
        enemy.skillList = this.skillList;
        return enemy;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setIsDead(boolean isDead) {
        this.isDead = isDead;
    }
}
