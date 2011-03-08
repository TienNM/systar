package emulator.model.manager;

import emulator.model.Item;
import emulator.model.Map;
import emulator.model.Skill;
import emulator.model.Enemy;
import emulator.model.Bag;
import emulator.model.Equip;
import emulator.model.EnemyTroop;
import emulator.model.BaseItem;
import emulator.model.Config;
import emulator.model.Player;
import emulator.engine.animation.Animation;
import java.util.Hashtable;
//import model.*;
//import test.TestData;

/**
 *
 * ��Ϸ���������
 */
public class GameObjectManager {

    private Config config = null;
    private Animation[] animationList = null;
    private Enemy[] enemyList = null;
    private EnemyTroop[] enemyTroopList = null;
    private Item[] itemList = null;
    private Equip[] equipList = null;
    private Skill[] skillList = null;
    private Player player = null;
    private Hashtable mapList = new Hashtable();
    public void initConfig(){
        config = GameObjectFactory.createConfig();
        System.out.println("config��ʼ�����");
    }
    public void init() {
        System.out.println("init��ʼ");
        animationList = GameObjectFactory.createAnimationList();
        System.out.println("animation��ʼ�����");
        enemyList = GameObjectFactory.createEnemyList();
        System.out.println("enemy��ʼ�����");
        enemyTroopList = GameObjectFactory.createEnemyTroopList();
        System.out.println("enemyTroop��ʼ�����");
        itemList = GameObjectFactory.createItemList();
//        itemList = TestData.getItemList();//����
        System.out.println("item��ʼ�����");
        equipList = GameObjectFactory.createEquipList();
//        equipList = TestData.getEquipList();//����
        System.out.println("equip��ʼ�����");
        skillList = GameObjectFactory.createSkillList();
//        skillList = TestData.getSkillList();//����
        System.out.println("skill��ʼ�����");
        player = GameObjectFactory.createPlayer();
        System.out.println("player��ʼ�����");
    }

    public BaseItem getBaseItem(byte type, int index) {
        BaseItem bi = null;
        switch (type) {
            case Bag.ITEM:
                bi = itemList[index];
                break;
            case Bag.EQUIP:
                bi = equipList[index];
                break;
            case Bag.SKILL:
                bi = skillList[index];
                break;
        }
        return bi;
    }

    public Config getConfig() {
        return config;
    }

    public Animation getAnimation(int index) {
        return animationList[index];
    }

    public Enemy getEnemy(int index) {
        return enemyList[index];
    }

    public EnemyTroop getEnemyTroop(int index) {
        return enemyTroopList[index];
    }

    public Item getItem(int index) {
        return itemList[index];
    }

    public Equip getEquip(int index) {
        return equipList[index];
    }

    public Skill getSkill(int index) {
        return skillList[index];
    }

    public Player getPlayer() {
        return player;
    }

    public Map getMap(int index) {
        if (mapList.get(new Integer(index)) == null) {
            Map map = GameObjectFactory.createMap(index);
            mapList.put(new Integer(map.index), map);
        }
        return (Map) mapList.get(new Integer(index));
    }
}
