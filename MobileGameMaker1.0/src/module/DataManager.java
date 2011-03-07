package module;

import frame.dm.EnemyTab;
import frame.dm.ItemTab;
import frame.dm.SystemTab;
import frame.dm.EquipTab;
import frame.dm.PlayerTab;
import frame.dm.SkillTab;
import frame.dm.GroupTab;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import frame.*;
import model.*;

//���ݹ�����ģ��
public class DataManager extends JDialog implements ChangeListener {

    public static final int SYSTEM = 0;
    public static final int PLAYER = 1;
    public static final int ENEMY = 2;
    public static final int GROUP = 3;
    public static final int ITEM = 4;
    public static final int EQUIP = 5;
    public static final int SKILL = 6;
    private static final long serialVersionUID = 1L;
    private JPanel jContentPane = null;
    private JTabbedPane jTabbedPane = null;
    private SystemTab systemTab = null;
    private PlayerTab playerTab = null;
    private EnemyTab enemyTab = null;
    private GroupTab groupTab = null;
    private ItemTab itemTab = null;
    private SkillTab skillTab = null;
    private EquipTab equipTab = null;
    private JButton jButton = null;
    private JButton jButton1 = null;
    private JButton jButton2 = null;

    /**
     * @param owner
     */
    public DataManager(JFrame owner) {
        super(owner);
        initialize();
    }

    public void stateChanged(ChangeEvent ce) {
        int num = jTabbedPane.getSelectedIndex();
        switch (num) {
            case SYSTEM:

                break;
            case PLAYER:

                break;
            case ENEMY:
                enemyTab.updateList();
                break;
            case GROUP:
                groupTab.updateList();
                break;
            case ITEM:

                break;
            case EQUIP:

                break;
            case SKILL:

                break;
        }
    }

    private void cancel() {
        // ȡ��
        this.setVisible(false);
    }

    /**
     * This method initializes enemyTab
     *
     * @return frame.dm.EnemyTab
     */
    private EnemyTab getEnemyTab() {
        if (enemyTab == null) {
            enemyTab = new EnemyTab();
        }
        return enemyTab;
    }

    /**
     * This method initializes equipTab
     *
     * @return frame.dm.EquipTab
     */
    private EquipTab getEquipTab() {
        if (equipTab == null) {
            equipTab = new EquipTab();
        }
        return equipTab;
    }

    /**
     * This method initializes groupTab
     *
     * @return frame.dm.GroupTab
     */
    private GroupTab getGroupTab() {
        if (groupTab == null) {
            groupTab = new GroupTab();
        }
        return groupTab;
    }

    /**
     * This method initializes itemTab
     *
     * @return frame.dm.ItemTab
     */
    private ItemTab getItemTab() {
        if (itemTab == null) {
            itemTab = new ItemTab();
        }
        return itemTab;
    }

    /**
     * This method initializes jButton
     *
     * @return javax.swing.JButton
     */
    private JButton getJButton() {
        if (jButton == null) {
            jButton = new JButton();
            jButton.setLocation(new Point(320, 370));
            jButton.setText("ȷ��");
            jButton.setSize(new Dimension(60, 20));
            jButton.addActionListener(new java.awt.event.ActionListener() {

                public void actionPerformed(java.awt.event.ActionEvent e) {
                    save(true);
                }
            });
        }
        return jButton;
    }

    /**
     * This method initializes jButton1
     *
     * @return javax.swing.JButton
     */
    private JButton getJButton1() {
        if (jButton1 == null) {
            jButton1 = new JButton();
            jButton1.setLocation(new Point(400, 370));
            jButton1.setText("ȡ��");
            jButton1.setSize(new Dimension(60, 20));
            jButton1.addActionListener(new java.awt.event.ActionListener() {

                public void actionPerformed(java.awt.event.ActionEvent e) {
                    cancel();
                }
            });
        }
        return jButton1;
    }

    /**
     * This method initializes jButton2
     *
     * @return javax.swing.JButton
     */
    private JButton getJButton2() {
        if (jButton2 == null) {
            jButton2 = new JButton();
            jButton2.setLocation(new Point(480, 370));
            jButton2.setText("Ӧ��");
            jButton2.setSize(new Dimension(60, 20));
            jButton2.addActionListener(new java.awt.event.ActionListener() {

                public void actionPerformed(java.awt.event.ActionEvent e) {
                    save(false);
                }
            });
        }
        return jButton2;
    }

    /**
     * This method initializes jContentPane
     *
     * @return javax.swing.JPanel
     */
    private JPanel getJContentPane() {
        if (jContentPane == null) {
            jContentPane = new JPanel();
            jContentPane.setLayout(null);
            jContentPane.add(getJTabbedPane(), null);
            jContentPane.add(getJButton(), null);
            jContentPane.add(getJButton1(), null);
            jContentPane.add(getJButton2(), null);
        }
        return jContentPane;
    }

    /**
     * This method initializes jTabbedPane
     *
     * @return javax.swing.JTabbedPane
     */
    private JTabbedPane getJTabbedPane() {
        if (jTabbedPane == null) {
            jTabbedPane = new JTabbedPane();
            jTabbedPane.setBounds(new Rectangle(4, 3, 567, 352));
            jTabbedPane.addTab("ϵͳ", null, getSystemTab(), null);
            jTabbedPane.addTab("��ɫ", null, getPlayerTab(), null);
            jTabbedPane.addTab("����", null, getEnemyTab(), null);
            jTabbedPane.addTab("����", null, getGroupTab(), null);
            jTabbedPane.addTab("��Ʒ", null, getItemTab(), null);
            jTabbedPane.addTab("װ��", null, getEquipTab(), null);
            jTabbedPane.addTab("����", null, getSkillTab(), null);
            jTabbedPane.addChangeListener(this);
        }
        return jTabbedPane;
    }

    /**
     * This method initializes playerTab
     *
     * @return frame.dm.PlayerTab
     */
    private PlayerTab getPlayerTab() {
        if (playerTab == null) {
            playerTab = new PlayerTab();
        }
        return playerTab;
    }

    /**
     * This method initializes skillTab
     *
     * @return frame.dm.SkillTab
     */
    private SkillTab getSkillTab() {
        if (skillTab == null) {
            skillTab = new SkillTab();
        }
        return skillTab;
    }

    /**
     * This method initializes systemTab
     *
     * @return frame.dm.SystemTab
     */
    private SystemTab getSystemTab() {
        if (systemTab == null) {
            systemTab = new SystemTab();
        }
        return systemTab;
    }

    /**
     * This method initializes this
     *
     * @return void
     */
    private void initialize() {
        this.setSize(580, 431);
        Dimension screenSize =
            Toolkit.getDefaultToolkit().getScreenSize();
        Dimension labelSize = this.getSize();
        this.setLocation(screenSize.width / 2 - (labelSize.width / 2),
            screenSize.height / 2 - (labelSize.height / 2));//����λ����Ļ�в�
        this.setTitle("���ݹ�����");
        Image image = this.getToolkit().getImage("icon/icon.png");
        this.setIconImage(image);
        this.setResizable(false);
        this.setContentPane(getJContentPane());
//        load();
    }

    public void load() {
        loadSystem();
        loadSkill();
        loadItem();
        loadEquip();
        loadEnemy();
        loadPlayer();
        loadGroup();
    }

    public void loadGroup() {
        try {
            FileInputStream fis = new FileInputStream(Project.getProjectPath() + "\\" + "data/enemytroop.gat");
            DataInputStream dis = new DataInputStream(fis);
            int num = dis.readInt();
            EnemyTroop[] enemyTroop = new EnemyTroop[num];
            for (int i = 0; i < enemyTroop.length; i++) {
                enemyTroop[i] = new EnemyTroop();
                enemyTroop[i].index = dis.readInt();
                enemyTroop[i].name = dis.readUTF();
                enemyTroop[i].siteA = dis.readInt();
                enemyTroop[i].siteB = dis.readInt();
                enemyTroop[i].siteC = dis.readInt();
                enemyTroop[i].siteD = dis.readInt();
                int n = dis.readInt();
                if (n != 0) {
                    enemyTroop[i].itemList = new Goods[n];
                    for (int j = 0; j < enemyTroop[i].itemList.length; j++) {
                        enemyTroop[i].itemList[j] = Project.getItemList().getItem(dis.readInt());
                    }
                }

                Project.getEnemyTroopList().addElement(enemyTroop[i]);
            }
            dis.close();
            fis.close();
        } catch (IOException e) {
            System.out.println("�Ҳ���enemytroop.gat�ļ�");
        } finally {
            groupTab.updateList();
        }

    }

    public void loadPlayer() {
        try {
            FileInputStream fis = new FileInputStream(Project.getProjectPath() + "\\" + "data/player.gat");
            DataInputStream dis = new DataInputStream(fis);
            Project.getPlayer().setName(dis.readUTF());
            Project.getPlayer().setDescription(dis.readUTF());
            Project.getPlayer().setBImgName(dis.readUTF());
            Project.getPlayer().setCImgName(dis.readUTF());
            Project.getPlayer().setStre(dis.readInt());
            Project.getPlayer().setAgil(dis.readInt());
            Project.getPlayer().setInte(dis.readInt());
            Project.getPlayer().setHp(dis.readInt());
            Project.getPlayer().setSp(dis.readInt());
            Project.getPlayer().setMaxlev(dis.readInt());
            Project.getPlayer().setAtk(dis.readInt());
            Project.getPlayer().setDef(dis.readInt());
            Project.getPlayer().setFlee(dis.readInt());
            Project.getPlayer().setStrebylev(dis.readInt());
            Project.getPlayer().setAgilbylev(dis.readInt());
            Project.getPlayer().setIntebylev(dis.readInt());
            int[] levList = new int[Project.getPlayer().getMaxlev()];
            for (int i = 0; i < Project.getPlayer().getMaxlev(); i++) {
                levList[i] = dis.readInt();
            }
            Project.getPlayer().setLevList(levList);
            Project.getPlayer().setMoney(dis.readInt());
            Project.getPlayer().setMapIndex(dis.readInt());
            Project.getPlayer().setStartY(dis.readInt());
            Project.getPlayer().setStartX(dis.readInt());

            Project.getPlayer().setDir(dis.readInt());

            dis.close();
            fis.close();
        } catch (IOException e) {
//            e.printStackTrace();
            System.out.println("�Ҳ���player.gat�ļ�");
        } finally {
            playerTab.updateList();
        }
    }

    public void loadEnemy() {
        try {
            FileInputStream fis = new FileInputStream(Project.getProjectPath() + "\\" + "data/enemy.gat");
            DataInputStream dis = new DataInputStream(fis);
            int num = dis.readInt();
            Enemy[] enemy = new Enemy[num];
            for (int i = 0; i < enemy.length; i++) {
                enemy[i] = new Enemy();
                enemy[i].setIndex(dis.readInt());
                enemy[i].setName(dis.readUTF());
                enemy[i].setDescription(dis.readUTF());
                enemy[i].setBImgName(dis.readUTF());
                enemy[i].setStre(dis.readInt());
                enemy[i].setAgil(dis.readInt());
                enemy[i].setInte(dis.readInt());
                enemy[i].setMaxhp(dis.readInt());
                enemy[i].setMaxsp(dis.readInt());
                enemy[i].setLev(dis.readInt());
                enemy[i].setAtk(dis.readInt());
                enemy[i].setDef(dis.readInt());
                enemy[i].setExp(dis.readInt());
                enemy[i].setMoney(dis.readInt());
                int n = dis.readInt();
                if (n != 0) {
                    enemy[i].skillList = new Skill[n];
                    for (int j = 0; j < enemy[i].skillList.length; j++) {
                        enemy[i].skillList[j] = Project.getSkillList().getSkill(dis.readInt());
                    }
                }
                Project.getEnemyList().addElement(enemy[i]);
            }
            dis.close();
            fis.close();
        } catch (IOException e) {
            System.out.println("�Ҳ���enemy.gat�ļ�");
        } finally {
            enemyTab.updateList();
        }
    }

    public void loadSystem() {
        try {
            FileInputStream fis = new FileInputStream(Project.getProjectPath() + "\\" + "data/system.gat");
            DataInputStream dis = new DataInputStream(fis);
            Project.setName(dis.readUTF());
            Project.setHelp(dis.readUTF());
            Project.setIntroduction(dis.readUTF());
            Project.setHp(dis.readUTF());
            Project.setSp(dis.readUTF());
            Project.setStre(dis.readUTF());
            Project.setInte(dis.readUTF());
            Project.setAgil(dis.readUTF());
            Project.setAtk(dis.readUTF());
            Project.setDef(dis.readUTF());
            Project.setFlee(dis.readUTF());
            Project.setMoney(dis.readUTF());
            Project.setHelm(dis.readUTF());
            Project.setArmour(dis.readUTF());
            Project.setWeapon(dis.readUTF());
            Project.setShield(dis.readUTF());
            Project.setCaliga(dis.readUTF());
            Project.setTrinket(dis.readUTF());
            dis.close();
            fis.close();
        } catch (IOException e) {
            System.out.println("�Ҳ���system.gat�ļ�");
        } finally {
            systemTab.updateData();
        }
    }

    private void loadItem() {
        try {
            FileInputStream fis = new FileInputStream(Project.getProjectPath() + "\\" + "data/item.gat");
            DataInputStream dis = new DataInputStream(fis);
            int num = dis.readInt();
            Goods[] item = new Goods[num];
            for (int i = 0; i < item.length; i++) {
                item[i] = new Goods();
                item[i].setKind(dis.readInt());
                item[i].setIndex(dis.readInt());
                item[i].setName(dis.readUTF());
                item[i].setRemark(dis.readUTF());

                item[i].setImgName(dis.readUTF());
                item[i].setStre(dis.readInt());
                item[i].setAgil(dis.readInt());
                item[i].setInte(dis.readInt());

                item[i].setHp(dis.readInt());
                item[i].setSp(dis.readInt());
                item[i].setMaxhp(dis.readInt());
                item[i].setMaxhp(dis.readInt());
                item[i].setLev(dis.readInt());
                item[i].setAtk(dis.readInt());
                item[i].setDef(dis.readInt());
//                item[i].setMatk(dis.readInt());
//                item[i].setMdef(dis.readInt());
//                item[i].setAspeed(dis.readInt());
//                item[i].setHit(dis.readInt());
                item[i].setFlee(dis.readInt());
                item[i].setExp(dis.readInt());
                item[i].setPrice(dis.readInt());
                Project.getItemList().addItem(item[i]);
            }
            dis.close();
            fis.close();
        } catch (IOException e) {
            System.out.println("�Ҳ���item.gat�ļ�");
        } finally {
            itemTab.updateList();
        }
    }

    private void loadEquip() {
        try {
            FileInputStream fis = new FileInputStream(Project.getProjectPath() + "\\" + "data/equip.gat");
            DataInputStream dis = new DataInputStream(fis);
            int num = dis.readInt();
            Equip[] equip = new Equip[num];
            for (int i = 0; i < equip.length; i++) {
                equip[i] = new Equip();
                equip[i].setKind(dis.readInt());

                equip[i].setIndex(dis.readInt());
                equip[i].setName(dis.readUTF());
                equip[i].setRemark(dis.readUTF());
                equip[i].setImgName(dis.readUTF());
                equip[i].setStre(dis.readInt());
                equip[i].setAgil(dis.readInt());
                equip[i].setInte(dis.readInt());
                equip[i].setHp(dis.readInt());
                equip[i].setSp(dis.readInt());
                equip[i].setLev(dis.readInt());
                equip[i].setAtk(dis.readInt());
                equip[i].setDef(dis.readInt());
//                equip[i].setMatk(dis.readInt());
//                equip[i].setMdef(dis.readInt());
//                equip[i].setAspeed(dis.readInt());
//                equip[i].setHit(dis.readInt());
                equip[i].setFlee(dis.readInt());
                equip[i].setPrice(dis.readInt());
                Project.getEquipList().addElement(equip[i]);
            }
            dis.close();
            fis.close();
        } catch (IOException e) {
            System.out.println("�Ҳ���equip.gat�ļ�");
        } finally {
            equipTab.updateList();
        }

    }

    private void loadSkill() {
        try {
            FileInputStream fis = new FileInputStream(Project.getProjectPath() + "\\" + "data/skill.gat");
            DataInputStream dis = new DataInputStream(fis);
            int num = dis.readInt();
            Skill[] skill = new Skill[num];
            for (int i = 0; i < skill.length; i++) {
                skill[i] = new Skill();
                skill[i].setIndex(dis.readInt());
                skill[i].setKind(dis.readInt());
                skill[i].setName(dis.readUTF());
                skill[i].setRemark(dis.readUTF());
                skill[i].setImgName(dis.readUTF());
                skill[i].setHp(dis.readInt());
                skill[i].setSp(dis.readInt());
                skill[i].setLev(dis.readInt());
                skill[i].setDef(dis.readInt());
                skill[i].setPrice(dis.readInt());
                skill[i].setDpy(dis.readInt());
                skill[i].setAspeed(dis.readInt());
                skill[i].setAniIndex(dis.readInt());
                Project.getSkillList().addSkill(skill[i]);
            }
            dis.close();
            fis.close();
        } catch (IOException e) {
            System.out.println("�Ҳ���skill.gat�ļ�");
        } finally {
            skillTab.updateList();
        }

    }

    private void save(boolean judge) {
        // ����ȷ������ʱ����Ϊsave(true),��ʱ�����رչ�����
        // ����Ӧ�á���ʱ����Ϊsave(false),��ʱֻ���治�رչ�����
        int num = jTabbedPane.getSelectedIndex();
        switch (num) {
            case SYSTEM:
                saveSystem();
                break;
            case PLAYER:
                savePlayer();
                break;
            case ENEMY:
                saveEnemy();
                break;
            case GROUP:
                saveGroup();
                break;
            case ITEM:
                saveItem();
                break;
            case EQUIP:
                saveEquip();
                break;
            case SKILL:
                saveSkill();
                break;
        }
        if (judge) {
            cancel();
        }
    }

    private void saveEnemy() {
        // TODO �Զ����ɷ������

        enemyTab.saveEnemy(enemyTab.curIndex);
        saveEnemyIO();

    }

    private void saveGroup() {
        // TODO �Զ����ɷ������
        groupTab.saveEnemyTroop(groupTab.curIndex);
        saveGroupIO();
    }

    private void saveItem() {
        itemTab.saveItem(itemTab.curIndex);
        saveItemIO();
    }

    private void saveEquip() {
        equipTab.saveEquip(equipTab.curIndex);
        saveEquipIO();
    }

    private void saveEnemyIO() {
        try {
            FileOutputStream fos = new FileOutputStream(Project.getProjectPath() + "\\" + "data/enemy.gat");
            DataOutputStream dos = new DataOutputStream(fos);
            int num = Project.getEnemyList().size();
            Enemy enemy = null;
            dos.writeInt(num);// д����Ʒ����
            for (int i = 0; i < num; i++) {
                enemy = Project.getEnemyList().enemyAt(i);
                try {
                    dos.writeInt(enemy.getIndex());// д����
                    dos.writeUTF(enemy.getName());// д������
                    dos.writeUTF(enemy.getDescription());//
                    dos.writeUTF(enemy.getBImgName());//
                    dos.writeInt(enemy.getAgil());//
                    dos.writeInt(enemy.getStre());//
                    dos.writeInt(enemy.getInte());//
                    dos.writeInt(enemy.getMaxhp());//
                    dos.writeInt(enemy.getMaxsp());//
                    dos.writeInt(enemy.getLev());//
                    dos.writeInt(enemy.getAtk());//
                    dos.writeInt(enemy.getDef());//
                    dos.writeInt(enemy.getExp());//
                    dos.writeInt(enemy.getMoney());//
                    if (enemy.skillList == null || enemy.skillList.length == 0) {
                        dos.writeInt(0);
                    } else {
                        dos.writeInt(enemy.skillList.length);//
                        for (int j = 0; j < enemy.skillList.length; j++) {
                            dos.writeInt(enemy.skillList[j].getIndex());//
                        }
                    }
                } catch (Exception ee) {
//                    ee.printStackTrace();
                    continue;
                }
            }

            dos.close();
            fos.close();
        } catch (IOException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "�����ļ������쳣��");
//            System.out.println("Enemy�쳣��");
        }
    }

    private void saveGroupIO() {
        try {
            FileOutputStream fos = new FileOutputStream(Project.getProjectPath() + "\\" + "data/enemytroop.gat");
            DataOutputStream dos = new DataOutputStream(fos);
            int num = Project.getEnemyTroopList().size();
            EnemyTroop enemyTroop = null;
            dos.writeInt(num);// д����Ʒ����
            for (int i = 0; i < num; i++) {
                enemyTroop = Project.getEnemyTroopList().EnemyTroopAt(i);
                try {
                    dos.writeInt(enemyTroop.index);// д����
                    dos.writeUTF(enemyTroop.name);// д������
                    dos.writeInt(enemyTroop.siteA);//
                    dos.writeInt(enemyTroop.siteB);//
                    dos.writeInt(enemyTroop.siteC);//
                    dos.writeInt(enemyTroop.siteD);//
                    if (enemyTroop.itemList == null || enemyTroop.itemList.length == 0) {
                        dos.writeInt(0);
                    } else {
                        dos.writeInt(enemyTroop.itemList.length);//
                        for (int j = 0; j < enemyTroop.itemList.length; j++) {
                            dos.writeInt(enemyTroop.itemList[j].getIndex());//
                        }
                    }
                } catch (Exception ee) {
                    continue;
                }

            }

            dos.close();
            fos.close();
        } catch (IOException e) {
//            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "�����ļ������쳣��");
//            System.out.println("EnemyGroup�쳣��");
        }
    }

    private void saveItemIO() {
        try {


            int num = Project.getItemList().size();
            Goods item = null;
            FileOutputStream fos = new FileOutputStream(Project.getProjectPath() + "\\" + "data/item.gat");
            DataOutputStream dos = new DataOutputStream(fos);
            dos.writeInt(num);// д����Ʒ����
            for (int i = 0; i < num; i++) {
                item = Project.getItemList().itemAt(i);
                try {
                    dos.writeInt(item.getKind());// д����Ʒ���� 2�ظ� 0���幥�� 1Ⱥ�幥�� 3����
                    dos.writeInt(item.getIndex());// д����Ʒ���
                    dos.writeUTF(item.getName());// д����Ʒ����
                    dos.writeUTF(item.getRemark());// д�����Ʒ˵��
                    dos.writeUTF(item.getImgName());// д����Ʒͼ������
                    dos.writeInt(item.getStre());// д�����Ʒ�Ե��˵�stre��ɵ��˺�
                    dos.writeInt(item.getAgil());// д�����Ʒ�Ե��˵�agil��ɵ��˺�
                    dos.writeInt(item.getInte());// д�����Ʒ�Ե��˵�inte��ɵ��˺�
                    dos.writeInt(item.getHp());// д�����Ʒ�ظ���hp��Ե�����ɵĻ����˺�
                    dos.writeInt(item.getSp());// д�����Ʒ��Ҫ��sp
                    dos.writeInt(item.getMaxhp());// д�����Ʒ�ظ���hp��Ե�����ɵĻ����˺�
                    dos.writeInt(item.getMaxsp());// д�����Ʒ��Ҫ��sp
                    dos.writeInt(item.getLev());// д��ʹ�ô���Ʒ��Ҫ�ĵȼ�
                    dos.writeInt(item.getAtk());// д�����Ʒ�Ե��˵�atk��ɵ��˺�
                    dos.writeInt(item.getDef());// д�����Ʒ�Ե��˵�def��ɵ��˺�
                    dos.writeInt(item.getFlee());// д�����Ʒ�Ե��˵�flee��ɵ��˺�
                    dos.writeInt(item.getExp());// д�����Ʒ
                    dos.writeInt(item.getPrice());// д�����Ʒ�۸�
                } catch (Exception ee) {
                    continue;//�����쳣���ж�������������������
                }

            }

            dos.close();
            fos.close();
        } catch (IOException e) {
//            System.out.println("Item�쳣��");
            javax.swing.JOptionPane.showMessageDialog(this, "��Ʒ�ļ������쳣��");

        }
    }

    private void saveEquipIO() {
        try {
            FileOutputStream fos = new FileOutputStream(Project.getProjectPath() + "\\" + "data/equip.gat");
            DataOutputStream dos = new DataOutputStream(fos);
            int num = Project.getEquipList().size();
            Equip equip = null;
            dos.writeInt(num);// д��װ������
            for (int i = 0; i < num; i++) {
                equip = Project.getEquipList().equipAt(i);
                try {
                    dos.writeInt(equip.getKind());// д��װ������
                    dos.writeInt(equip.getIndex());// д��װ�����
                    dos.writeUTF(equip.getName());// д��װ������
                    dos.writeUTF(equip.getRemark());// д���װ��˵��
                    dos.writeUTF(equip.getImgName());// д��װ��ͼ������
                    dos.writeInt(equip.getStre());// д���װ���Ե��˵�stre��ɵ��˺�
                    dos.writeInt(equip.getAgil());// д���װ���Ե��˵�agil��ɵ��˺�
                    dos.writeInt(equip.getInte());// д���װ���Ե��˵�inte��ɵ��˺�
                    dos.writeInt(equip.getHp());// д���װ���ظ���hp��Ե�����ɵĻ����˺�
                    dos.writeInt(equip.getSp());// д���װ����Ҫ��sp

                    dos.writeInt(equip.getLev());// д��ʹ�ô�װ����Ҫ�ĵȼ�


                    dos.writeInt(equip.getAtk());// д���װ���Ե��˵�atk��ɵ��˺�
                    dos.writeInt(equip.getDef());// д���װ���Ե��˵�def��ɵ��˺�
//                dos.writeInt(equip.getMatk());// д���װ���Ե��˵�matk��ɵ��˺�
//                dos.writeInt(equip.getMdef());// д���װ���Ե��˵�mdef��ɵ��˺�
//                dos.writeInt(equip.getAspeed());// д���װ���Ե��˵�aspeed��ɵ��˺�
                    dos.writeInt(equip.getFlee());// д���װ���Ե��˵�flee��ɵ��˺�
//                dos.writeInt(equip.getHit());// д���װ���Ե��˵�hit��ɵ��˺�
                    dos.writeInt(equip.getPrice());// д���װ���۸�
                } catch (Exception ee) {
                    continue;
                }
            }

            dos.close();
            fos.close();
        } catch (IOException e) {
//            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "װ���ļ������쳣��");
//            System.out.println("Equip�쳣��");
        }
    }

    private void savePlayerIO() {
        try {
            FileOutputStream fos = new FileOutputStream(Project.getProjectPath() + "\\" + "data/player.gat");
            DataOutputStream dos = new DataOutputStream(fos);

            dos.writeUTF(Project.getPlayer().getName());
            dos.writeUTF(Project.getPlayer().getDescription());
            dos.writeUTF(Project.getPlayer().getBImgName());
            dos.writeUTF(Project.getPlayer().getCImgName());

            dos.writeInt(Project.getPlayer().getStre());
            dos.writeInt(Project.getPlayer().getAgil());
            dos.writeInt(Project.getPlayer().getInte());
            dos.writeInt(Project.getPlayer().getHp());
            dos.writeInt(Project.getPlayer().getSp());
            dos.writeInt(Project.getPlayer().getMaxlev());
            dos.writeInt(Project.getPlayer().getAtk());
            dos.writeInt(Project.getPlayer().getDef());
            dos.writeInt(Project.getPlayer().getFlee());
            dos.writeInt(Project.getPlayer().getStrebylev());
            dos.writeInt(Project.getPlayer().getAgilbylev());
            dos.writeInt(Project.getPlayer().getIntebylev());
            for (int i = 0; i < Project.getPlayer().getMaxlev(); i++) {
                dos.writeInt(Project.getPlayer().getLevList()[i]);
            }
            dos.writeInt(Project.getPlayer().getMoney());
            dos.writeInt(Project.getPlayer().getMapIndex());
            dos.writeInt(Project.getPlayer().getStartY());
            dos.writeInt(Project.getPlayer().getStartX());
            dos.writeInt(Project.getPlayer().getDir());


            dos.close();
            fos.close();
        } catch (IOException e) {
//            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "��ɫ�ļ������쳣��");
        }
    }

    private void saveSkillIO() {
        try {

            int num = Project.getSkillList().size();
            Skill skill = null;
            FileOutputStream fos = new FileOutputStream(Project.getProjectPath() + "\\" + "data/skill.gat");
            DataOutputStream dos = new DataOutputStream(fos);
            dos.writeInt(num);// д�뼼������
            for (int i = 0; i < num; i++) {
                skill = Project.getSkillList().skillAt(i);
                try {
                    dos.writeInt(skill.getIndex());// д�뼼�ܱ��
                    dos.writeInt(skill.getKind());// д�뼼������ 2�ظ� 0���幥�� 1Ⱥ�幥��
                    dos.writeUTF(skill.getName());// д�뼼������
                    dos.writeUTF(skill.getRemark());// д��˼���˵��
                    dos.writeUTF(skill.getImgName());// д�뼼��ͼ������
                    dos.writeInt(skill.getHp());// д��˼��ܻظ���hp��Ե�����ɵĻ����˺�
                    dos.writeInt(skill.getSp());// д��˼�����Ҫ��sp
                    dos.writeInt(skill.getLev());// д��ʹ�ô˼�����Ҫ�ĵȼ�
                    dos.writeInt(skill.getDef());// д��˼��ܶԵ��˵�def��ɵ��˺�
                    dos.writeInt(skill.getPrice());// д��˼��ܷ�ɢ��
                    dos.writeInt(skill.getDpy());// д��˼��ܷ�ɢ��
                    dos.writeInt(skill.getAspeed());// д��˼��ܶԵ��˵�aspeed��ɵ��˺�
                    dos.writeInt(skill.getAniIndex());// д��˼��ܶ���id
                } catch (Exception ee) {
                    continue;
                }
            }
            dos.close();
            fos.close();
        } catch (IOException e) {
//            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "�����ļ������쳣��");
//            System.out.println("skill�쳣��");
        }
    }

    private void saveSystemIO() {
        try {
            FileOutputStream fos = new FileOutputStream(Project.getProjectPath() + "\\" + "data/system.gat");
            DataOutputStream dos = new DataOutputStream(fos);
            dos.writeUTF(Project.getGameName());
            dos.writeUTF(Project.getHelp());
            dos.writeUTF(Project.getIntroduction());

            dos.writeUTF(Project.getHp());
            dos.writeUTF(Project.getSp());
            dos.writeUTF(Project.getStre());
            dos.writeUTF(Project.getInte());
            dos.writeUTF(Project.getAgil());
            dos.writeUTF(Project.getAtk());
            dos.writeUTF(Project.getDef());
            dos.writeUTF(Project.getFlee());
            dos.writeUTF(Project.getMoney());
            dos.writeUTF(Project.getHelm());
            dos.writeUTF(Project.getArmour());
            dos.writeUTF(Project.getWeapon());
            dos.writeUTF(Project.getShield());
            dos.writeUTF(Project.getCaliga());
            dos.writeUTF(Project.getTrinket());
            dos.close();
            fos.close();
        } catch (IOException e) {
//            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "ϵͳ�ļ������쳣��");
//            System.out.println("system�쳣��");
        }
    }
//
//    public void saveIO() {
//        saveEnemyIO();
//        saveGroupIO();
//        saveItemIO();
//        saveEquipIO();
//        savePlayerIO();
//        saveSkillIO();
//        saveSystemIO();
//
//    }

    public void savePlayer() {
        // TODO �Զ����ɷ������
        playerTab.save();
        savePlayerIO();
    }

    private void saveSkill() {
        skillTab.saveSkill(skillTab.curIndex);
        saveSkillIO();
    }

    private void saveSystem() {

        systemTab.save();
        //���浽�ļ�
        saveSystemIO();

    }
} // @jve:decl-index=0:visual-constraint="70,22"

