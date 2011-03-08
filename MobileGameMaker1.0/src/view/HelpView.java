package view;

import emulator.engine.BaseView;
import emulator.model.GameData;
import control.HelpControl;
import emulator.EmulatorFont;
import emulator.EmulatorGraphics;
import java.awt.Color;
import system.Painter;

/**
 *
 * ��Ϸ������ͼ
 */
public class HelpView extends BaseView {

    private GameData gd = GameData.getGameData();
    private EmulatorFont font = EmulatorFont.getEmulatorFont(EmulatorFont.FACE_SYSTEM, EmulatorFont.STYLE_PLAIN, EmulatorFont.SIZE_LARGE);
    private String text = "";
    private int itemWidth = 0;
    private int x, y;

    public void init() {
        setControl(new HelpControl());
        text = "����ȴ�ʵ����";
        itemWidth = font.stringWidth(text);
        x = (gd.screenWidth - itemWidth) / 2;
        y = (gd.screenHeight - font.getHeight()) / 2;
    }

    public void paint(EmulatorGraphics g) {
        g.setEmulatorFont(font);
        Painter.fillRect(g, 0, 0, gd.screenWidth, gd.screenHeight, Color.black);
        Painter.drawString(g, text, x, y, Color.white);

        //���ư�ť
        Painter.drawString(g, "ȷ��", 5, gd.screenHeight - font.getHeight(), Color.white);

    }

    public void release() {
//        gd.xIndex = 0;
//        gd.yIndex = 0;
        gd = null;
        font = null;
        setControl(null);
    }
}
