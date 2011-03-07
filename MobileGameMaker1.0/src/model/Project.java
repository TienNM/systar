package model;

public class Project {

    private static String projectPath = ".";// ������ϷĿ¼
    private static String projectName = "";//��Ŀ����
    private static String projectDirName = "";//�ļ�������
//    private static MapList maplist = new MapList();
    private static SkillList skillList = new SkillList();
    private static GoodsList itemList = new GoodsList();
    private static EquipList equipList = new EquipList();
    private static Player player = new Player();
    private static String name = "��Ϸ����";//��Ϸ����
    private static String stre = "����";//
    private static String hp = "hp";//
    private static String sp = "sp";//
    private static String agil = "����";//
    private static String inte = "����";//
    private static String atk = "������";//
    private static String def = "������";//
    private static String money = "��Ǯ";//
    private static String helm = "ͷ��";//ͷ��
    private static String weapon = "����";//����
    private static String shield = "����";//����
    private static String armour = "����";//����
    private static String trinket = "��Ʒ";//��Ʒ
    private static String caliga = "սѥ";//սѥ
    private static String help = "��Ϸ����";//��Ϸ����
    private static String introduction = "��Ϸ˵��";//��Ϸ˵��
    private static String flee = "����";//����
    private static EnemyList enemyList = new EnemyList();
    private static EnemyTroopList enemyTroopList = new EnemyTroopList();

    public static EnemyTroopList getEnemyTroopList() {
        return enemyTroopList;
    }

    public static void setEnemyTroopList(EnemyTroopList enemyTroopList) {
        Project.enemyTroopList = enemyTroopList;
    }

    public static String getFlee() {
        return flee;
    }

    public static void setFlee(String flee) {
        Project.flee = flee;
    }

    public static String getAgil() {
        return agil;
    }

    public static void setAgil(String agil) {
        Project.agil = agil;
    }

    public static String getArmour() {
        return armour;
    }

    public static void setArmour(String armour) {
        Project.armour = armour;
    }

    public static String getAtk() {
        return atk;
    }

    public static void setAtk(String atk) {
        Project.atk = atk;
    }

    public static String getCaliga() {
        return caliga;
    }

    public static void setCaliga(String caliga) {
        Project.caliga = caliga;
    }

    public static String getDef() {
        return def;
    }

    public static void setDef(String def) {
        Project.def = def;
    }

    public static String getHelm() {
        return helm;
    }

    public static void setHelm(String helm) {
        Project.helm = helm;
    }

    public static String getInte() {
        return inte;
    }

    public static void setInte(String inte) {
        Project.inte = inte;
    }

    public static String getMoney() {
        return money;
    }

    public static void setMoney(String money) {
        Project.money = money;
    }

    public static String getShield() {
        return shield;
    }

    public static void setShield(String shield) {
        Project.shield = shield;
    }

    public static String getTrinket() {
        return trinket;
    }

    public static void setTrinket(String trinket) {
        Project.trinket = trinket;
    }

    public static String getWeapon() {
        return weapon;
    }

    public static void setWeapon(String weapon) {
        Project.weapon = weapon;
    }

    public static EnemyList getEnemyList() {
        return enemyList;
    }

    public static String getProjectName() {
        return projectName;
    }

    public static String getProjectDirName() {
        return projectDirName;
    }

    public static void setProjectDirName(String projectDirName) {
        Project.projectDirName = projectDirName;
    }

    public static void setProjectName(String projectName) {
        Project.projectName = projectName;
    }

    public static void setEnemyList(EnemyList enemyList) {
        Project.enemyList = enemyList;
    }

    public static GoodsList getItemList() {
        return itemList;
    }

    public static void setItemList(GoodsList itemList) {
        Project.itemList = itemList;
    }

    public static String getProjectPath() {
        return projectPath;
    }

    public static void setProjectPath(String projectPath) {
        Project.projectPath = projectPath;
    }

    public static SkillList getSkillList() {
        return skillList;
    }

    public static void setSkillList(SkillList skillList) {
        Project.skillList = skillList;
    }

    public static EquipList getEquipList() {
        return equipList;
    }

    public static void setEquipList(EquipList equipList) {
        Project.equipList = equipList;
    }

    public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        Project.player = player;
    }

    public static String getHp() {
        return hp;
    }

    public static void setHp(String acknowledgement) {
        Project.hp = acknowledgement;
    }

    public static String getStre() {
        return stre;
    }

    public static void setStre(String author) {
        Project.stre = author;
    }

    public static String getHelp() {
        return help;
    }

    public static void setHelp(String help) {
        Project.help = help;
    }

    public static String getIntroduction() {
        return introduction;
    }

    public static void setIntroduction(String introduction) {
        Project.introduction = introduction;
    }

    public static String getGameName() {
        return name;
    }

    public static void setName(String name) {
        Project.name = name;
    }

    public static String getSp() {
        return sp;
    }

    public static void setSp(String remark) {
        Project.sp = remark;
    }
}
