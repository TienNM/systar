package view;

import control.ShopControl;
import emulator.engine.BaseView;
import emulator.engine.GameEngine;
import emulator.model.Bag;
import emulator.model.BaseItem;
import emulator.model.Const;
import emulator.model.GameData;
import control.ShopControl;
import emulator.EmulatorGraphics;
import java.awt.Color;
import system.Painter;

/**
 *
 * @author Administrator
 */
public class ShopView extends BaseView {

    public static final int PAGE_MAIN = 0;
    public static final int PAGE_TIP = 1;
    private GameData gd = GameData.getGameData();
    private GameEngine ge = GameEngine.getInstance();
    private String[] tabItems = {"���", "����"};
    private String[] names = null;

    public void init() {
        ShopControl sc = new ShopControl();
        setControl(sc);
        gd.shop_pageIndex = PAGE_MAIN;
        gd.shop_tabIndex = 0;
        gd.shop_curIndex = gd.shop_topIndex = 0;
        gd.buildList_buy();
        gd.buildList_sell();
        buildNames();
        System.out.println("�̵��ʼ�����");
    }

    public void paint(EmulatorGraphics g) {
        if (gd.shop_needRebuild) {
            buildNames();
        }
        int th = 50;//�������߶�
        int ih = 80;//�������߶�
        int ch = gd.screenHeight - th - ih;//�м��б�����߶�
        int gap = 10;//���
        int cellW = 160, cellH = 30;
        /**
         * ����
         */
        Painter.drawDialog(g, 0, 0, gd.screenWidth, th, Painter.DIALOG_DEEP);
        g.setEmulatorFont(Const.Font.FONTLARGE_BOLD);
        g.setColor(Color.GREEN);
        g.drawString(gd.shop_type == 0 ? "�̵ꡪ��Ʒ" : "�̵ꡪװ��", gd.screenWidth / 2, (th - g.getEmulatorFont().getHeight()) / 2, Const.Anchor.HT);
        /**
         * �б�
         */
        //�׿�
        Painter.drawDialog(g, 0, th, gd.screenWidth, ch, Painter.DIALOG_DEEP);
        //ѡ�
        Painter.drawTab(g, 0, th, gd.screenWidth, ch, Painter.DIALOG_LIGHT, gd.shop_tabIndex, tabItems);
        g.drawString("���н�Ǯ��" + gd.player.money, 48 * 2 + 2 * gap, th + (24 - g.getEmulatorFont().getHeight()) / 2, EmulatorGraphics.LT);
        //�б�
        gd.shop_showNum = (ch - 5 * gap) / cellH;//����ʾ��������
        int space = ch - 3 * gap - gd.shop_showNum * cellH;//�ܵ�����ʣ��ռ�
        space = space / (gd.shop_showNum + 1);//���
        g.setColor(Color.BLACK);
        g.setEmulatorFont(Const.Font.FONTSMALL_PLAIN);
        Painter.drawTable(g, (gd.screenWidth - cellW) / 2 - gap / 2, th + 3 * gap, cellW, cellH, gd.shop_showNum, space, names, Color.BLACK, gd.shop_topIndex, gd.shop_curIndex, Const.Anchor.HV, Painter.NODIALOG, Painter.CELL_DEEP);

        /**
         * ����
         */
        Painter.drawDialog(g, 0, th + ch, gd.screenWidth, ih, Painter.DIALOG_DEEP);
        //
        //FIX ME
        //����ɫ������ƷΪ0,����װ��Ϊ0
        //�����Խ���쳣
        //
        if (names.length > 0) {
            Painter.drawWordWrapString(g, gd.shop_tabIndex == 0 ? gd.shop_items_buy[gd.shop_curIndex].intro : gd.shop_items_sell[gd.shop_curIndex].intro, gap / 2, th + ch + gap / 2, gd.screenWidth - gap, ih - gap, Color.WHITE);

        }
        /**
         * ������
         */
        Painter.drawScrollbar(g, Painter.SCROLLBAR_VERTICAL, (gd.screenWidth - cellW) / 2 + cellW + gap / 2, th + 3 * gap + space, th + ch - space, gd.shop_topIndex, gd.shop_showNum, names.length);

        if (gd.shop_pageIndex == PAGE_TIP) {
            Painter.drawDialog(g, 0, (gd.screenHeight - ih) / 2, gd.screenWidth, ih, Painter.DIALOG_LIGHT);
            Painter.drawWordWrapString(g, gd.shop_message, 0 + gap / 2, (gd.screenHeight - ih) / 2 + gap / 2, gd.screenWidth - gap, ih - gap, Color.BLACK);
        }
    }

    public void release() {
    }

    private void buildNames() {
        names = new String[gd.shop_tabIndex == 0 ? gd.shop_items_buy.length : gd.shop_items_sell.length];
        for (int i = 0; i < names.length; i++) {
            names[i] = gd.shop_tabIndex == 0 ? (gd.shop_items_buy[i].name + "   �۸�" + gd.shop_items_buy[i].price) : (gd.shop_items_sell[i].name + "   �۸�" + gd.shop_items_sell[i].price / 2 + "   ������" + gd.shop_items_sell[i].num);
        }
        gd.shop_itemMaxNum = gd.shop_tabIndex == 0 ? gd.shop_items_buy.length : gd.shop_items_sell.length;
        gd.shop_needRebuild = false;
    }
}
