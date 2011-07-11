package view;

import control.EquipControl;
import emulator.EmulatorGraphics;
import emulator.engine.BaseView;
import java.awt.Color;
import emulator.model.Const;
import emulator.model.GameData;
import system.Painter;

/**
 *
 * װ����ͼ
 */
public class EquipView extends BaseView {

    private GameData gd = GameData.getGameData();
    public static final byte PAGE_MAIN = 0;
    public static final byte PAGE_CONFIRM = 1;
    public static final byte PAGE_TIP = 2;

    public void init() {
        EquipControl ec = new EquipControl();
        setControl(ec);
        gd.equip_pageIndex = PAGE_MAIN;
        gd.equip_selectIndex = 0;
        gd.equip_curEquip = gd.player.equipHelm;
    }

    public void paint(EmulatorGraphics g) {
        switch (gd.equip_pageIndex) {
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

        Painter.drawDialog(g, 0, 0, gd.screenWidth, gd.screenHeight, Painter.DIALOG_LIGHT);

        String[] items = {
            Const.Str.KINDS[0] + ": " + ((gd.player.equipHelm == -1) ? "��" : gd.gameObjectManager.getEquip(gd.player.equipHelm).name),
            Const.Str.KINDS[1] + ": " + ((gd.player.equipJewelry == -1) ? "��" : gd.gameObjectManager.getEquip(gd.player.equipJewelry).name),
            Const.Str.KINDS[2] + ": " + ((gd.player.equipWeapon == -1) ? "��" : gd.gameObjectManager.getEquip(gd.player.equipWeapon).name),
            Const.Str.KINDS[3] + ": " + ((gd.player.equipShield == -1) ? "��" : gd.gameObjectManager.getEquip(gd.player.equipShield).name),
            Const.Str.KINDS[4] + ": " + ((gd.player.equipArmour == -1) ? "��" : gd.gameObjectManager.getEquip(gd.player.equipArmour).name),
            Const.Str.KINDS[5] + ": " + ((gd.player.equipBoots == -1) ? "��" : gd.gameObjectManager.getEquip(gd.player.equipBoots).name)
        };
        Painter.drawTable(g, 22, 40, 175, 30, 6, 10, items, Color.black, 0, gd.equip_selectIndex, Const.Anchor.LV, Painter.NODIALOG, Painter.CELL_DEEP);

    }

    private void paint_Confirm(EmulatorGraphics g) {
        int h = 50;
        Painter.drawDialog(g, 0, gd.screenHeight - h, gd.screenWidth, h, Painter.DIALOG_DEEP);
        g.setColor(Color.black);
        g.drawString("�Ƿ�Ҫ��װ��\"" + (gd.gameObjectManager.getEquip(gd.equip_curEquip).name) + "\"����", gd.screenWidth / 2, gd.screenHeight - h + (h - g.getEmulatorFont().getHeight()) / 2, EmulatorGraphics.HT);

    }

    private void paint_Tip(EmulatorGraphics g) {
        int h = 50;
        Painter.drawDialog(g, 0, gd.screenHeight - h, gd.screenWidth, h, Painter.DIALOG_DEEP);
        g.setColor(Color.black);
        g.drawString("װ���ɹ�����", gd.screenWidth / 2, gd.screenHeight - h + (h - g.getEmulatorFont().getHeight()) / 2, EmulatorGraphics.HT);

    }
}
