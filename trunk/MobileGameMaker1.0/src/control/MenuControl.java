package control;

import view.MenuView;
import emulator.engine.Control;
import emulator.engine.GameEngine;
import emulator.engine.View;
import emulator.engine.script.Event;
import game.RpgGame;
import emulator.model.Const;
import emulator.model.GameData;
import system.DataBase;
//import view.*;

/**
 * ��Ϸ�˵���ͼ�Ŀ�����
 */
public class MenuControl implements Control {

    private GameData gd = GameData.getGameData();
    private GameEngine ge = GameEngine.getInstance();
    private RpgGame game = (RpgGame) ge.getGame();
    private DataBase db = new DataBase();

    public void keyPressed(View view, int key) {
        if (view instanceof MenuView) {
            if (key == Const.Key.KEY_LEFT) {
                gd.xIndex--;
                if (gd.xIndex < 0) {
                    gd.xIndex = Const.Str.MENU_MENU.length - 1;
                }
            } else if (key == Const.Key.KEY_RIGHT) {
                gd.xIndex++;
                if (gd.xIndex > Const.Str.MENU_MENU.length - 1) {
                    gd.xIndex = 0;
                }
            } else if (key == Const.Key.KEY_FIRE || key == Const.Key.KEY_5) {
                switch (gd.xIndex) {
                    case MenuView.START:
                        //����Ϸ
                        newGame();
//                        System.out.println("ok");
                        game.setCurView(Const.ViewId.VIEW_MAP);
//                        game.setCurView(Const.Tag.VIEW_BATTLE);//����ս��
                        break;
                    case MenuView.CONTINUE:
                        //������Ϸ
                        if (loadGame()) {
                            game.setCurView(Const.ViewId.VIEW_MAP);
                        }
                        break;
                    case MenuView.SETTING:
                        //��Ϸ����
                        game.setCurView(Const.ViewId.VIEW_SETTING);
                        break;
                    case MenuView.HELP:
                        //��Ϸ����
                        game.setCurView(Const.ViewId.VIEW_HELP);
                        break;
                    case MenuView.ABOUT:
                        //������Ϸ
                        game.setCurView(Const.ViewId.VIEW_ABOUT);
                        break;
                    case MenuView.EXIT:
                        //�˳���Ϸ
                        game.exit();
                        break;
                }
            }
            ge.clearKey();
        }
    }

    public void dealEvent(View view, Event event) {
    }

    private void newGame() {
        long time = System.currentTimeMillis();
        System.out.println("newGame");
        gd.gameObjectManager.init();
        System.out.println("init���");
        gd.player = gd.gameObjectManager.getPlayer().getClone();
        System.out.println("getPlayer���");
        gd.curMap = gd.gameObjectManager.getMap(gd.player.curMapIndex);
        System.out.println("getMap���");
        gd.player.setLocation();
        gd.player.init();
        gd.curMap.resetRegion(gd.player);
        time = System.currentTimeMillis() - time;
        System.out.println("time: " + time);
    }

    private boolean loadGame() {
        return db.loadDB();
    }
}
