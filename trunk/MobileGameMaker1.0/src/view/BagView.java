package view;

import control.BagControl;
import emulator.EmulatorGraphics;
import emulator.engine.BaseView;
import emulator.engine.GameEngine;
import java.awt.Color;
import emulator.model.Bag;
import emulator.model.Const;
import emulator.model.GameData;
import system.Painter;

/**
 *
 * @author Administrator
 */
public class BagView extends BaseView {

    private GameData gd = GameData.getGameData();
    private GameEngine ge = GameEngine.getInstance();
    private String[] tabItems = {"��Ʒ", "װ��"};
    public static final byte PAGE_MAIN = 0;
    public static final byte PAGE_CONFIRM = 1;
    public static final byte PAGE_TIP = 2;

    public void init() {
        BagControl bc = new BagControl();
        setControl(bc);
        gd.buildItems();
    }

    public void paint(EmulatorGraphics g) {
        switch (gd.bag_pageIndex) {
            case PAGE_MAIN:
                paint_Main(g);
                break;
            case PAGE_CONFIRM:
                paint_Main(g);
                paint_Confirm(g);
                break;
            case PAGE_TIP:
                paint_Main(g);
                paint_Tip(g);
                break;
        }
    }

    public void release() {
        gd.bag_curIndex = 0;//��0
    }

    private void paint_Main(EmulatorGraphics g) {

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
        g.drawString("�� ��", gd.screenWidth / 2, (th - g.getEmulatorFont().getHeight()) / 2, Const.Anchor.HT);
        /**
         * �б�
         */
        //�׿�
        Painter.drawDialog(g, 0, th, gd.screenWidth, ch, Painter.DIALOG_DEEP);
        //ѡ�
        Painter.drawTab(g, 0, th, gd.screenWidth, ch, Painter.DIALOG_LIGHT, gd.bag_tabIndex, tabItems);
        //�б�
        gd.bag_showNum = (ch - 5 * gap) / cellH;//����ʾ��������
        int space = ch - 3 * gap - gd.bag_showNum * cellH;//�ܵ�����ʣ��ռ�
        space = space / (gd.bag_showNum + 1);//���
        g.setColor(Color.BLACK);
        g.setEmulatorFont(Const.Font.FONTSMALL_PLAIN);
        Painter.drawTable(g, (gd.screenWidth - cellW) / 2 - gap / 2, th + 3 * gap, cellW, cellH, gd.bag_showNum, space, gd.bag_tabIndex == 0 ? gd.items : gd.equips, Color.BLACK, gd.bag_topIndex, gd.bag_curIndex, Const.Anchor.HV, Painter.NODIALOG, Painter.CELL_DEEP);

        /**
         * ����
         */
        Painter.drawDialog(g, 0, th + ch, gd.screenWidth, ih, Painter.DIALOG_DEEP);
        if (gd.player.bag.getList(gd.bag_tabIndex == 0 ? Bag.ITEM : Bag.EQUIP).length > 0 && gd.player.bag.get(gd.bag_tabIndex == 0 ? Bag.ITEM : Bag.EQUIP, gd.player.bag.getList(gd.bag_tabIndex == 0 ? Bag.ITEM : Bag.EQUIP)[gd.bag_curIndex]) != null) {
            Painter.drawWordWrapString(g, gd.player.bag.get(gd.bag_tabIndex == 0 ? Bag.ITEM : Bag.EQUIP, gd.player.bag.getList(gd.bag_tabIndex == 0 ? Bag.ITEM : Bag.EQUIP)[gd.bag_curIndex]).intro, gap / 2, th + ch + gap / 2, gd.screenWidth - gap, ih - gap, Color.WHITE);

        }
        /**
         * ������
         */
        Painter.drawScrollbar(g, Painter.SCROLLBAR_VERTICAL, (gd.screenWidth - cellW) / 2 + cellW + gap / 2, th + 3 * gap + space, th + ch - space, gd.bag_topIndex, gd.bag_showNum, gd.player.bag.getList(gd.bag_tabIndex == 0 ? Bag.ITEM : Bag.EQUIP).length);

    }

    private void paint_Confirm(EmulatorGraphics g) {
        int h = 50;
        Painter.drawDialog(g, 0, gd.screenHeight - h, gd.screenWidth, h, Painter.DIALOG_DEEP);
        g.setColor(Color.black);
        if (gd.player.bag.get(gd.bag_tabIndex == 0 ? Bag.ITEM : Bag.EQUIP, gd.player.bag.getList(gd.bag_tabIndex == 0 ? Bag.ITEM : Bag.EQUIP)[gd.bag_curIndex]) != null) {
            if (gd.bag_tabIndex == 0) {
                g.drawString("�Ƿ�Ҫʹ����Ʒ\"" + (gd.gameObjectManager.getItem(gd.player.bag.getList(Bag.ITEM)[gd.bag_curIndex]).name) + "\"", gd.screenWidth / 2, gd.screenHeight - h + (h - g.getEmulatorFont().getHeight()) / 2, EmulatorGraphics.HT);

            } else {
                g.drawString("�Ƿ�Ҫ��װ��\"" + (gd.gameObjectManager.getEquip(gd.player.bag.getList(Bag.EQUIP)[gd.bag_curIndex]).name) + "\"����", gd.screenWidth / 2, gd.screenHeight - h + (h - g.getEmulatorFont().getHeight()) / 2, EmulatorGraphics.HT);

            }
        }


    }

    private void paint_Tip(EmulatorGraphics g) {
        int h = 50;
        Painter.drawDialog(g, 0, gd.screenHeight - h, gd.screenWidth, h, Painter.DIALOG_DEEP);
        g.setColor(Color.black);
        if (gd.bag_tabIndex == 0) {
            g.drawString("ʹ�óɹ�", gd.screenWidth / 2, gd.screenHeight - h + (h - g.getEmulatorFont().getHeight()) / 2, EmulatorGraphics.HT);

        } else {
            g.drawString("װ���ɹ�", gd.screenWidth / 2, gd.screenHeight - h + (h - g.getEmulatorFont().getHeight()) / 2, EmulatorGraphics.HT);

        }

    }
}
