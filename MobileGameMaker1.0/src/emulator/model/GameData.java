package emulator.model;

import emulator.EmulatorFont;
import java.util.Vector;
import emulator.model.manager.GameObjectManager;

/**
 *
 * �൱��MVC�е�ģ�ͣ�M��
 */
public class GameData {

    private static GameData gd = new GameData();
    public GameObjectManager gameObjectManager = new GameObjectManager();
    /**
     * ���0-99��100������
     */
    public boolean[] switchs = new boolean[100];
    /**
     * ���0-99��100������
     */
    public int[] vars = new int[100];
    private EmulatorFont font = EmulatorFont.getEmulatorFont(EmulatorFont.FACE_SYSTEM, EmulatorFont.STYLE_PLAIN, EmulatorFont.SIZE_LARGE);
    //������Դ
    public int screenWidth = 240;
    public int screenHeight = 320;
    public int pageIndex = 0;//ҳ���ǩ
    public int xIndex = 0;//ˮƽѡ������
    public int yIndex = 0;//����ѡ������
    public Player player = null;//���
    //��Ϸ������Դ
    public boolean musicOn = false;//���ֿ���
    public boolean soundOn = false;//��Ч����
    //��ͼ��ͼ��Դ
    public Map curMap = null;//��ǰ��ͼ
    public int map_menuIndex = 0;//ϵͳ�˵�������
    //������ͼ��Դ
    public int skill_topIndex = 0;
    public int skill_curIndex = 0;
    public int skill_showNum = 0;
    //װ����ͼ��Դ
    public int equip_pageIndex = 0;
    public int equip_curEquip = 0;
    public int equip_selectIndex = 0;
    //������ͼ��Դ
    public int bag_topIndex = 0;
    public int bag_tabIndex = 0;
    public int bag_curIndex = 0;
    public int bag_showNum = 0;
    public int bag_pageIndex = 0;
    public String[] items = null;
    public String[] equips = null;
    //�̵���ͼ��Դ
    public byte shop_type = 0;//0 ��Ʒ����   1 װ���̵�
    public int[] shop_list = null;//�̵���Ʒ�б�
    public int shop_pageIndex = 0;
    public int shop_tabIndex = 0;
    public int shop_topIndex = 0;
    public int shop_curIndex = 0;
    public int shop_showNum = 0;
    public int shop_itemMaxNum = 0;
    public int shop_itemNum = 0;
    public boolean shop_needRebuild = false;
    public String shop_message = "";
    public BaseItem[] shop_items_buy = null;
    public BaseItem[] shop_items_sell = null;
    //�����������
    public StringBuffer stringBuffer = new StringBuffer();
    //�Ի����¼�
    public String dialog_name;//�Ի�����
    public String[] dialog_content;//�Ի�����
    public int dialog_index = 0;//��ǰҪҪ��ʾ�Ի����ݵĵ�һ�еı��
    //�ȴ��¼�
    public int waitTime = 0;//�ȴ�����ʱ��
    public int waitIndex = 0;//��ǰ�Ѿ��ȴ���ʱ��
    //�ƶ��¼�
    public byte[] moveOrder = null;//�ƶ�ָ������
    public int moveIndex = 0;//��ǰҪ�ƶ���ָ���±�
    //ս����ͼ��Դ
    public int enemyTroopID = 0;//��ս���˶���ID
    /************************************************/
    //ս��������Ʊ��� 11.2
    public int select = 0,//������ѡ����
            Select_Eny = 0,//��ͨ��������ѡ����
            Select_Good = 0,//��Ʒѡ����
            Top_Good = 0,//��Ʒѡ����
            Select_Magic = 0,//����ѡ����
            Top_Magic = 0;//��Ʒѡ����
//            Select_Equip = 0;//װ��ѡ����
    public int Select_Magic_Eny = 0,//����ѡ����˽�����
            Select_Magic_Main = 0;//����ѡ����������
    public int Select_Item_Eny = 0,//��Ʒѡ����˽�����
            Select_Item_Main = 0;//��Ʒѡ����������
    public int attackType = 0; //��������
//    public int enemySum = 0;//��������
    public Enemy[] enemy = new Enemy[4];//���4������
    public int enemyShould;//�ֵ��ĵ���id
    public boolean isNotHitEnemy = false;//Ӣ��δ���е���
    public boolean isChangeHp = false;//ƮѪ����
    public int upDecreaseHP = 0, upMiss = 0;//ƮѪ��Ʈmiss����
    public boolean isWin = false;//ս��ʤ������
    public boolean isFail = false;//ս��ʧ�ܿ���
    public boolean isMiss = false;
    public volatile boolean isRuning = false;
    public int allExp = 0;//���еĲμ�ս���ĵ��˼������ľ���
    public int allMoney = 0;//ͬ��
    /* -2����ħ������
     * -1����������
     * 1 ��ͨ����
     * 2 ����ָ��Է���
     * 3 ���幥���Է���
     * 4 ȫ�幥���Է���
     * 5 ���幥������Ʒ
     * 6 ȫ�幥������Ʒ
     * 7 ����ָ�����Ʒ
     */
    /******************��ͼ����˵�����***********************/
    public int menuIndex = -1;
    public int itemMainSelect = 0;
    public int Item_Select_Good = 0,//��Ʒѡ����
            Item_Top_Good = 0,//��Ʒѡ����
            Item_Select_Equip = 0,//����ѡ����
            Item_Top_Equip = 0;//��Ʒѡ����
    public int equipSelect = 0;
    public int skillSelect = 0;
    public int Skill_Top_Magic = 0;
    public int winSelect = 0;

    public void setDialog(String name, String content) {
        //���㷨������ʧ�ܵģ���Ҫ��д
        this.dialog_name = name;
        int num = GameData.getGameData().screenWidth / font.stringWidth("��");//ÿ������ʾ������
        int row = content.length() / num + 1;//Ҫ��ʾ������
        Vector v = new Vector();
        int p = 0, q = 0;
        EmulatorFont f = Const.Font.FONTSMALL_PLAIN;
        String temp = null;
        while (p < content.length()) {
            if (q == content.length()) {
                v.addElement(content.substring(p, q));
                p = q;
            }else{
                temp=content.substring(p, q);
                if(f.stringWidth(temp)>screenWidth-20){
                    v.addElement(content.substring(p, q-1));
                    p=q-1;
                }else{
                    q++;
                }
            }

        }
        dialog_content = new String[v.size()];
        for (int i = 0; i < dialog_content.length; i++) {
            dialog_content[i]=(String) v.elementAt(i);
        }
        v.removeAllElements();
        v=null;
    }

    private GameData() {
        super();
    }

    public static GameData getGameData() {
        return gd;
    }

    public void buildItems() {
        items = new String[gd.player.bag.getList(Bag.ITEM).length];
        for (int i = 0; i < items.length; i++) {
            Item tempItem = (Item) gd.player.bag.get(Bag.ITEM, gd.player.bag.getList(Bag.ITEM)[i]);
            items[i] = tempItem.name + "  ������" + tempItem.num;
        }

        equips = new String[gd.player.bag.getList(Bag.EQUIP).length];
        for (int i = 0; i < equips.length; i++) {
            Equip tempEquip = (Equip) gd.player.bag.get(Bag.EQUIP, gd.player.bag.getList(Bag.EQUIP)[i]);
            equips[i] = Const.Str.KINDS[tempEquip.kind] + "  " + tempEquip.name + "  ������" + tempEquip.num;
        }
    }

    public void buildList_buy() {
        gd.shop_items_buy = new BaseItem[gd.shop_list.length];
        for (int i = 0; i < gd.shop_items_buy.length; i++) {
            gd.shop_items_buy[i] = gd.gameObjectManager.getBaseItem(gd.shop_type == 0 ? Bag.ITEM : Bag.EQUIP, gd.shop_list[i]);
        }
    }

    public void buildList_sell() {
        gd.shop_items_sell = new BaseItem[gd.player.bag.getList(gd.shop_type == 0 ? Bag.ITEM : Bag.EQUIP).length];
        for (int i = 0; i < gd.shop_items_sell.length; i++) {
            gd.shop_items_sell[i] = gd.player.bag.get(gd.shop_type == 0 ? Bag.ITEM : Bag.EQUIP, gd.player.bag.getList(gd.shop_type == 0 ? Bag.ITEM : Bag.EQUIP)[i]);
        }
    }
}
