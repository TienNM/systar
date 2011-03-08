package view;

import control.SettingControl;
import emulator.engine.BaseView;
import emulator.engine.Game;
import emulator.engine.GameEngine;
import game.RpgGame;

import emulator.model.GameData;
import control.SettingControl;
import emulator.EmulatorFont;
import emulator.EmulatorGraphics;
import java.awt.Color;
import system.Painter;

/**
 *
 * ��Ϸ����
 */
public class SettingView extends BaseView {

    private GameData gd = GameData.getGameData();
//    private GameEngine ge = GameEngine.getInstance();
    private int itemWidth = 0;
    private String text = "";
//    private int space = 5;//�м��
//    private int num = 2;
    private int x, y;
    private EmulatorFont font = EmulatorFont.getEmulatorFont(EmulatorFont.FACE_SYSTEM, EmulatorFont.STYLE_PLAIN, EmulatorFont.SIZE_LARGE);

    public void init() {
        setControl(new SettingControl());
        text = "����ȴ�ʵ����";
        itemWidth = font.stringWidth(text);
        x = (gd.screenWidth - itemWidth) / 2;
        y = (gd.screenHeight - font.getHeight()) / 2;
    }

    public void paint(EmulatorGraphics g) {
        g.setEmulatorFont(font);
        Painter.fillRect(g, 0, 0, gd.screenWidth, gd.screenHeight, Color.black);

        Painter.drawString(g, text, x, y, Color.white);
        Painter.drawString(g, "ȷ��", 5, gd.screenHeight - font.getHeight(), Color.white);
        

    }

    public void release() {
//        gd.xIndex = 0;
//        gd.yIndex = 0;
        gd = null;
//        ge = null;
        font = null;
        setControl(null);
    }
}
