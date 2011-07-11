package emulator.model;

import emulator.EmulatorImage;
import emulator.engine.script.ScriptEngine;
import system.*;

/**
 * ���� cokey2
 */
public final class Player extends Character {

    private ScriptEngine se = ScriptEngine.getInstance();
    public static final int UP = 0;// ������
    public static final int DOWN = 1;// ������
    public static final int LEFT = 2;// ������
    public static final int RIGHT = 3;// ������
    public static final int STEP1 = 1;// ��һ��
    public static final int STEP2 = 2;// �ڶ���
    public static final int STEP3 = 3;// ������
    public static final int STEP4 = 0;// ���Ĳ�
    public int step = 0;// ��ɫ���ߵĲ���
    public int[] levList = null;//�����
    public int maxLev = 0;//�ⶥ�ȼ�
    public int streByLev;// �����ɳ�
    public int agilByLev;// ���ݳɳ�
    public int inteByLev;// �����ɳ�
    public int curMapIndex;// ��ɫ��ǰ���ڵ�ͼ���
    public int row = 10;// ��ɫ�����к�
    public int col = 4;// ��ɫ��ǰ�����к�
    public int face = DOWN;// ����
    private EmulatorImage curCharImg = null;
    public int width = 16;// ��ɫ���
    public int height = 24;// ��ɫ�߶�
    private GameData gd = GameData.getGameData();
    public int x, y;// ��ɫ��ǰ�ڵ�ͼ�ϵ�����
    public int startTime = 0;// ��ɫ��ʼ�ƶ���ʱ��
    /********************************************************/
    public int heroBattX = 150, heroBattY = 180;//ս��ʱ����
    public int changeHp;
    /********************************************************/
//    public ArrayList skillList;
//    public int[] itemList;
//    public int[] equipList;
    public Bag bag = new Bag();
    /**
     * ͷ��
     */
    public int equipHelm = -1;
    /**
     * ����
     */
    public int equipArmour = -1;
    /**
     * ����
     */
    public int equipWeapon = -1;
    /**
     * ����
     */
    public int equipShield = -1;
    /**
     * սѥ
     */
    public int equipBoots = -1;
    /**
     * ��Ʒ
     */
    public int equipJewelry = -1;

    public Player() {
        super();
        bag = new Bag();
    }
    //      ��ʼ������

    public void init() {
//        bag.add(Bag.SKILL, 0, 1);
//        bag.add(Bag.SKILL, 1, 1);
//        bag.add(Bag.SKILL, 2, 1);
//        bag.add(Bag.ITEM, 0, 5);
//        bag.add(Bag.ITEM, 1, 2);
//        bag.add(Bag.ITEM, 2, 1);
//        bag.add(Bag.EQUIP, 0, 1);
//        bag.add(Bag.EQUIP, 1, 1);
//        addEquip(0);
        updateProperties();
    }

    public void addExp(int exp) {
        this.exp += exp;
        checkLevelUp();
    }

    private void checkLevelUp() {
        if (exp >= this.levList[lev]) {
            levelUp();
            checkLevelUp();//�ݹ�
        }
    }

    public void useItem(int index) {

        if (bag.getList(Bag.ITEM).length > 0) {
            Item item = gd.gameObjectManager.getItem(index);
            if (item.kind == Item.ITEM_ASSIST) {//����Ʒ����Ϊ������Ʒ�����޷�ʳ��
                stre += item.stre;//����/��������
                agil += item.agil;//����/��������
                inte += item.inte;//����/��������
                hp += item.hp;//����/����Ѫ��
                sp += item.sp;//����/����ħ��ֵ
                maxHp += item.maxHp;//����/�������Ѫ��
                maxSp += item.maxSp;//����/�������ħ��ֵ
                lev += item.lev;//���ӵȼ�
                atk += item.atk;//����/���ٹ���
                def += item.def;//����/���ٷ���
                flee += item.flee;//����/��������
                exp += item.exp;//���Ӿ���ֵ
                if (hp > maxHp) {
                    hp = maxHp;
                }
                if (sp > maxSp) {
                    sp = maxSp;
                }
                bag.del(Bag.ITEM, index, 1);
            }
        }
    }

    public void levelUp() {
        exp -= this.levList[lev];
        this.lev++;
        updateProperties();
    }
    //��װ�����еı��Ϊindex��װ�� װ����Ӣ������

    public void takeOnEquip(int index) {
        if (bag.has(Bag.EQUIP, index)) {
            bag.del(Bag.EQUIP, index, 1);
            switch (gd.gameObjectManager.getEquip(index).kind) {
                case BaseItem.EQUIP_ARMOUR:
                    if (equipArmour != -1) {
                        bag.add(Bag.EQUIP, equipArmour, 1);
                    }
                    equipArmour = index;
                    break;
                case BaseItem.EQUIP_BOOTS:
                    if (equipBoots != -1) {
                        bag.add(Bag.EQUIP, equipBoots, 1);
                    }
                    equipBoots = index;
                    break;
                case BaseItem.EQUIP_HELM:
                    if (equipHelm != -1) {
                        bag.add(Bag.EQUIP, equipHelm, 1);
                    }
                    equipHelm = index;
                    break;
                case BaseItem.EQUIP_JEWELRY:
                    if (equipJewelry != -1) {
                        bag.add(Bag.EQUIP, equipJewelry, 1);
                    }
                    equipJewelry = index;
                    break;
                case BaseItem.EQUIP_SHIELD:
                    if (equipShield != -1) {
                        bag.add(Bag.EQUIP, equipShield, 1);
                    }
                    equipShield = index;
                    break;
                case BaseItem.EQUIP_WEAPON:
                    if (equipWeapon != -1) {
                        bag.add(Bag.EQUIP, equipWeapon, 1);
                    }
                    equipWeapon = index;
                    break;
            }
        }
        updateState();
    }

    //��Ӣ�����ϵ�װ�����·ŵ�װ������
    public void takeOffEquip(int index) {
        switch (gd.gameObjectManager.getEquip(index).kind) {
            case BaseItem.EQUIP_ARMOUR:
                if (equipArmour != -1) {
                    bag.add(Bag.EQUIP, index, 1);
                    equipArmour = -1;
                }
                break;
            case BaseItem.EQUIP_BOOTS:
                if (equipBoots != -1) {
                    bag.add(Bag.EQUIP, index, 1);
                    equipBoots = -1;
                }
                break;
            case BaseItem.EQUIP_HELM:
                if (equipHelm != -1) {
                    bag.add(Bag.EQUIP, index, 1);
                    equipHelm = -1;
                }
                break;
            case BaseItem.EQUIP_JEWELRY:
                if (equipJewelry != -1) {
                    bag.add(Bag.EQUIP, index, 1);
                    equipJewelry = -1;
                }
                break;
            case BaseItem.EQUIP_SHIELD:
                if (equipShield != -1) {
                    bag.add(Bag.EQUIP, index, 1);
                    equipShield = -1;
                }
                break;
            case BaseItem.EQUIP_WEAPON:
                if (equipWeapon != -1) {
                    bag.add(Bag.EQUIP, index, 1);
                    equipWeapon = -1;
                }
                break;
        }

        updateState();
    }

    /*
     * ��ع�ʽ
     * stre=stre(������ֵ)+streByLev*lev	//����
     * agil=agil(���ݳ�ֵ)+agilByLev*lev	//����
     * inte=inte(������ֵ)+inteByLev*lev    //����
     * maxHp=stre*19			//����ֵ
     * maxSp=inte*17			//ħ��ֵ
     * atk=stre*3			//������
     * def=agil/3		//������
     * flee=agil/10		//����ֵ
     *
     */
    //���Ը���
    public void updateProperties() {
        updateState();
        hp = maxHp;
        sp = maxSp;

    }

    public Player getClone() {
        Player player = new Player();
        player.name = this.name;
        player.intro = this.intro;
        player.curMapIndex = this.curMapIndex;
        player.row = this.row;
        player.col = this.col;
        player.face = this.face;
        player.headImg = this.headImg;
        player.setCharImg(this.chaImage);
        player.streByLev = this.streByLev;
        player.inteByLev = this.inteByLev;
        player.agilByLev = this.agilByLev;
        player.maxLev = this.maxLev;
        player.levList = this.levList;
        player.agil = this.agil;
        player.atk = this.atk;
        player.def = this.def;
        player.flee = this.flee;
        player.stre = this.stre;
        player.inte = this.inte;
        player.hp = this.hp;
        player.sp = this.sp;
        player.money = this.money;

//        TestData.initPlayer(player);
        return player;
    }
    //װ��Ӱ�����Ժ���

    public void updateState() {
        stre = gd.gameObjectManager.getPlayer().stre + streByLev * lev + 1;//��ʼֵΪ
        agil = gd.gameObjectManager.getPlayer().agil + agilByLev * lev + 1;//��ʼֵΪ
        inte = gd.gameObjectManager.getPlayer().inte + inteByLev * lev + 1;//��ʼֵΪ
        maxHp = gd.gameObjectManager.getPlayer().hp + stre * 20;//��ʼֵΪ
        maxSp = gd.gameObjectManager.getPlayer().sp + inte * 15;//��ʼֵΪ
        atk = stre * 3 + gd.gameObjectManager.getPlayer().atk;//��ʼֵΪ
        def = agil / 3 + gd.gameObjectManager.getPlayer().def;//��ʼֵΪ
        flee = agil / 10 + gd.gameObjectManager.getPlayer().flee;//��ʼֵΪ
        int equipList[] = new int[6];
        equipList[0] = equipHelm;
        equipList[1] = equipArmour;
        equipList[2] = equipWeapon;
        equipList[3] = equipShield;
        equipList[4] = equipBoots;
        equipList[5] = equipJewelry;
        for (int i = 0; i < 6; i++) {
            if (equipList[i] == -1) {
                continue;
            }
            this.maxHp += gd.gameObjectManager.getEquip(equipList[i]).maxHp;
            this.agil += gd.gameObjectManager.getEquip(equipList[i]).agil;
            this.def += gd.gameObjectManager.getEquip(equipList[i]).def;
            this.atk += gd.gameObjectManager.getEquip(equipList[i]).atk;
            this.flee += gd.gameObjectManager.getEquip(equipList[i]).flee;
            this.inte += gd.gameObjectManager.getEquip(equipList[i]).inte;
            this.stre += gd.gameObjectManager.getEquip(equipList[i]).stre;
            this.maxSp += gd.gameObjectManager.getEquip(equipList[i]).maxSp;
            this.maxHp += gd.gameObjectManager.getEquip(equipList[i]).maxHp;
        }
    }

    /**
     * �ж�Ӣ���Ƿ�����
     *
     * @return
     */
    public boolean isDead() {
        if (hp <= 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * �Ƿ�����
     *
     * @return
     */
    public boolean isMiss() {
        int random = Tools.GetRandom(100);
        if (random > -1 && random < flee) {
            return true;
        } else {
            return false;
        }
    }

    public EmulatorImage getCurCharImg() {
        return curCharImg;
    }
    /**
     * �� 00���� 01��� 02�ҽ� �� 10���� 11��� 12�ҽ� �� 20���� 21��� 22�ҽ� �� 30���� 31��� 32�ҽ�
     */
    private EmulatorImage[][] steps = new EmulatorImage[4][3];

    public void setCharImg(EmulatorImage img) {
        chaImage = img;
        width = img.getWidth() / 7;
        height = img.getHeight();
        steps[0][0] = EmulatorImage.createImage(img, 0, 0, width, height, 0);// ������
        steps[0][1] = EmulatorImage.createImage(img, width, 0, width, height, 2);// �����
        steps[0][2] = EmulatorImage.createImage(img, width, 0, width, height, 0);// ���ҽ�

        steps[1][0] = EmulatorImage.createImage(img, width * 2, 0, width, height, 0);// ������
        steps[1][1] = EmulatorImage.createImage(img, width * 3, 0, width, height, 2);// �����
        steps[1][2] = EmulatorImage.createImage(img, width * 3, 0, width, height, 0);// ���ҽ�

        steps[2][0] = EmulatorImage.createImage(img, width * 4, 0, width, height, 0);// ������
        steps[2][1] = EmulatorImage.createImage(img, width * 6, 0, width, height, 0);// �����
        steps[2][2] = EmulatorImage.createImage(img, width * 5, 0, width, height, 0);// ���ҽ�

        steps[3][0] = EmulatorImage.createImage(img, width * 4, 0, width, height, 2);// ������
        steps[3][1] = EmulatorImage.createImage(img, width * 6, 0, width, height, 2);// �����
        steps[3][2] = EmulatorImage.createImage(img, width * 5, 0, width, height, 2);// ���ҽ�

        curCharImg = steps[face][0];
    }
    public EmulatorImage chaImage = null;

    /**
     * ��������
     */
    public void moveUp() {
        if (row == 0 || gd.curMap.way[row - 1][col] == 1) {
            // �����ɫ�Ѿ��ڵ�ͼ������������������
            return;
        }
        step++;
        switch (step % 4) {
            case STEP1:
                y -= gd.curMap.cellHeight / 4;
                curCharImg = steps[UP][1];
                break;
            case STEP2:
                y -= gd.curMap.cellHeight / 4;
                curCharImg = steps[UP][0];
                break;
            case STEP3:
                y -= gd.curMap.cellHeight / 4;
                curCharImg = steps[UP][2];
                break;
            case STEP4:
                y -= gd.curMap.cellHeight / 4;
                curCharImg = steps[UP][0];
                row--;
                checkTouchScript();
                break;
        }
    }

    /**
     * ��������
     */
    public void moveDown() {
        if (row == gd.curMap.rowNum - 1 || gd.curMap.way[row + 1][col] == 1) {
            // �����ɫ�Ѿ��ڵ�ͼ������������������
            return;
        }
        step++;
        switch (step % 4) {
            case STEP1:
                y += gd.curMap.cellHeight / 4;
                curCharImg = steps[DOWN][1];
                break;
            case STEP2:
                y += gd.curMap.cellHeight / 4;
                curCharImg = steps[DOWN][0];
                break;
            case STEP3:
                y += gd.curMap.cellHeight / 4;
                curCharImg = steps[DOWN][2];
                break;
            case STEP4:
                y += gd.curMap.cellHeight / 4;
                curCharImg = steps[DOWN][0];
                row++;
                checkTouchScript();
                break;
        }
    }

    /**
     * ��������
     */
    public void moveLeft() {
        if (col == 0 || gd.curMap.way[row][col - 1] == 1) {
            // �����ɫ�Ѿ��ڵ�ͼ������������������
            return;
        }
        step++;
        switch (step % 4) {
            case STEP1:
                x -= gd.curMap.cellWidth / 4;
                curCharImg = steps[LEFT][1];
                break;
            case STEP2:
                x -= gd.curMap.cellWidth / 4;
                curCharImg = steps[LEFT][0];
                break;
            case STEP3:
                x -= gd.curMap.cellWidth / 4;
                curCharImg = steps[LEFT][2];
                break;
            case STEP4:
                x -= gd.curMap.cellWidth / 4;
                curCharImg = steps[LEFT][0];
                col--;
                checkTouchScript();
                break;
        }
    }

    /**
     * ��������
     */
    public void moveRight() {
        if (col == gd.curMap.colNum - 1 || gd.curMap.way[row][col + 1] == 1) {
            // �����ɫ�Ѿ��ڵ�ͼ������������������
            return;
        }
        step++;
        switch (step % 4) {
            case STEP1:
                x += gd.curMap.cellWidth / 4;
                curCharImg = steps[RIGHT][1];
                break;
            case STEP2:
                x += gd.curMap.cellWidth / 4;
                curCharImg = steps[RIGHT][0];
                break;
            case STEP3:
                x += gd.curMap.cellWidth / 4;
                curCharImg = steps[RIGHT][2];
                break;
            case STEP4:
                x += gd.curMap.cellWidth / 4;
                curCharImg = steps[RIGHT][0];
                col++;
                checkTouchScript();
                break;
        }
    }

    public void move(int face) {
        this.face = face;
        curCharImg = steps[face][0];
        switch (face) {
            case UP:
                moveUp();
                break;
            case DOWN:
                moveDown();
                break;
            case LEFT:
                moveLeft();
                break;
            case RIGHT:
                moveRight();
                break;

        }
        gd.curMap.resetRegion(this);
    }

    public void setLocation() {
//        this.row = row;
//        this.col = col;
        x = col * gd.curMap.cellWidth + (gd.curMap.cellWidth - width) / 2;
        y = row * gd.curMap.cellHeight - (height - gd.curMap.cellHeight);
    }

    /**
     * ͣЪ����ɫ������ʱ����֮���ͣЪ
     */
    public void dwell() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public void changeToward(byte toward) {
        switch (toward) {
            case UP:
                curCharImg = steps[UP][0];
                break;
            case DOWN:
                curCharImg = steps[DOWN][0];
                break;
            case LEFT:
                curCharImg = steps[LEFT][0];
                break;
            case RIGHT:
                curCharImg = steps[RIGHT][0];
                break;
        }

    }

    private void checkTouchScript() {
        if (gd.curMap.scriptType[gd.player.row][gd.player.col] == 1 || gd.curMap.scriptType[gd.player.row][gd.player.col] == 2) {
            se.addScript(gd.curMap.getScript(gd.player.row, gd.player.col));
        }
    }
}
