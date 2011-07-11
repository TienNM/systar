package control;

import emulator.model.Const;
import emulator.model.GameData;
import emulator.model.Player;
import view.MapView;
import emulator.engine.Control;
import emulator.engine.GameEngine;
import emulator.engine.View;
import emulator.engine.script.Event;
import emulator.engine.script.ScriptEngine;
import game.RpgGame;
import system.DataBase;
//import model.*;
//import test.TestData;

/**
 *
 * ��ͼ������
 */
public class MapControl implements Control {

    private GameData gd = GameData.getGameData();
    private GameEngine ge = GameEngine.getInstance();
    private ScriptEngine se = ScriptEngine.getInstance();
    private RpgGame game = (RpgGame) ge.getGame();
    private DataBase db = new DataBase();

    public void keyPressed(View view, int key) {
        if (view instanceof MapView) {
            switch (gd.pageIndex) {
                case MapView.PAGE_MAP:
                    keyPressed_map(view, key);
                    break;
                case MapView.PAGE_MENU:
                    keyPressed_menu(view, key);
                    break;
                case MapView.PAGE_DIALOG:
                    keyPressed_dialog(view, key);
                    break;
            }
        }
    }

    public void dealEvent(View view, Event event) {
        if (view instanceof MapView) {
            game.startEvent();
            switch (event.type) {
                case Event.DIALOG:
                    gd.setDialog(event.data[0], event.data[1]);
                    gd.pageIndex = MapView.PAGE_DIALOG;
                    break;
                case Event.SOUND:
                    break;
                case Event.WAIT:
                    gd.pageIndex = MapView.PAGE_WAIT;
                    gd.waitIndex = 0;
                    gd.waitTime = Integer.parseInt(event.data[0]);
                    sleep(view);
                    break;
                case Event.ITEMSHOP:
                    gd.shop_type = 0;
                    gd.shop_list = new int[event.data.length];
                    for (int i = 0; i < gd.shop_list.length; i++) {
                        gd.shop_list[i] = Integer.parseInt(event.data[i]);
                    }
                    game.setCurView(Const.ViewId.VIEW_SHOP);
                    break;
                case Event.EQUIPSHOP:
                    gd.shop_type = 1;
                    gd.shop_list = new int[event.data.length];
                    for (int i = 0; i < gd.shop_list.length; i++) {
                        gd.shop_list[i] = Integer.parseInt(event.data[i]);
                    }
                    game.setCurView(Const.ViewId.VIEW_SHOP);
                    break;
                case Event.GAMEOVER:
                    game.exit();
                    game.finishEvent();
                    break;
                case Event.MAP:
                    changeMap(Integer.parseInt(event.data[0]), Integer.parseInt(event.data[1]), Integer.parseInt(event.data[2]));
                    game.finishEvent();
                    break;
                case Event.FACE:
                    gd.player.changeToward(Byte.parseByte(event.data[0]));
                    view.repaint();
                    game.finishEvent();
                    break;
                case Event.MOVE:
                    gd.moveIndex = 0;
                    gd.moveOrder = new byte[event.data.length];
                    for (int i = 0; i < gd.moveOrder.length; i++) {
                        gd.moveOrder[i] = Byte.parseByte(event.data[i]);
                    }
                    move(view);
                    break;
                case Event.FIGHT:
                    gd.enemyTroopID = Integer.parseInt(event.data[0]);
                    game.setCurView(Const.ViewId.VIEW_BATTLE);
                    break;
            }
        }
    }

    private void keyPressed_map(View view, int key) {
        System.out.println("key:" + key);
        if (key == Const.Key.KEY_UP) {
            for (int i = 0; i < 4; i++) {
                gd.player.move(Player.UP);
                view.repaint();
                gd.player.dwell();
            }
        } else if (key == Const.Key.KEY_DOWN) {
            for (int i = 0; i < 4; i++) {
                gd.player.move(Player.DOWN);
                view.repaint();
                gd.player.dwell();
            }
        } else if (key == Const.Key.KEY_LEFT) {
            for (int i = 0; i < 4; i++) {
                gd.player.move(Player.LEFT);
                view.repaint();
                gd.player.dwell();
            }
        } else if (key == Const.Key.KEY_RIGHT) {
            for (int i = 0; i < 4; i++) {
                gd.player.move(Player.RIGHT);
                view.repaint();
                gd.player.dwell();
            }
        } else if (key == Const.Key.KEY_LS) {
            gd.pageIndex = MapView.PAGE_MENU;
            ge.clearKey();
        } else if (key == Const.Key.KEY_5 || key == Const.Key.KEY_FIRE) {
            //gd.pageIndex = MapView.PAGE_DIALOG;  //����dialog������
            //���ű�ǰһ���Ƿ��а����ű�
            //������
//            System.out.println("��Ӳ��Խű�");
//            se.addScript(TestData.getScript());
            checkKeyScript();
            ge.clearKey();
        }
    }

    private void keyPressed_menu(View view, int key) {
        switch (key) {
            case Const.Key.KEY_LS:
            case Const.Key.KEY_FIRE:
                switch (gd.map_menuIndex) {
                    case MapView.MENU_STATE:
                        System.out.println("�ҵ�״̬");
                        game.setCurView(Const.ViewId.VIEW_STATE);
                        break;
                    case MapView.MENU_BAG:
                        System.out.println("�ҵı���");
                        game.setCurView(Const.ViewId.VIEW_BAG);
                        break;
                    case MapView.MENU_EQUIP:
                        System.out.println("�ҵ�װ��");
                        game.setCurView(Const.ViewId.VIEW_EQUIP);
                        break;
                    case MapView.MENU_SKILL:
                        System.out.println("�ҵļ���");
                        game.setCurView(Const.ViewId.VIEW_SKILL);
                        break;
                    case MapView.MENU_SAVE:
                        System.out.println("�������");
                        db.saveDB();
                        gd.pageIndex = MapView.PAGE_MAP;
                        break;
                    case MapView.MENU_RETURN:
                        System.out.println("�����˵�");
                        game.setCurView(Const.ViewId.VIEW_MENU);
                        break;
                }
                break;
            case Const.Key.KEY_UP:
                gd.map_menuIndex = (gd.map_menuIndex + Const.Str.MENU_MAP.length - 1) % Const.Str.MENU_MAP.length;
                break;
            case Const.Key.KEY_DOWN:
                gd.map_menuIndex = (gd.map_menuIndex + 1) % Const.Str.MENU_MAP.length;
                break;
            case Const.Key.KEY_RS:
                gd.pageIndex = MapView.PAGE_MAP;
                break;

        }
        ge.clearKey();
    }

    private void keyPressed_dialog(View view, int key) {
        if (key == Const.Key.KEY_5 || key == Const.Key.KEY_FIRE) {
            gd.dialog_index += 2;
            if (gd.dialog_index >= gd.dialog_content.length) {
                gd.dialog_index = 0;
                gd.pageIndex = MapView.PAGE_MAP;
                game.finishEvent();
            }
        }
        ge.clearKey();
    }

    private void sleep(View view) {
        while (gd.waitIndex < gd.waitTime) {
            try {
                view.repaint();
                Thread.sleep(1000);
                gd.waitIndex++;
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        gd.pageIndex = MapView.PAGE_MAP;
        game.finishEvent();
    }

    private void move(View view) {
        while (gd.moveIndex < gd.moveOrder.length) {
            for (int i = 0; i < 4; i++) {
                view.repaint();
                gd.player.move(gd.moveOrder[gd.moveIndex]);
                gd.player.dwell();
            }
            gd.moveIndex++;
        }
        game.finishEvent();
    }

    private void changeMap(int index, int row, int col) {
        gd.curMap = gd.gameObjectManager.getMap(index);
        gd.player.row = row;
        gd.player.col = col;
        gd.player.curMapIndex = index;
        gd.player.setLocation();
        gd.curMap.resetRegion(gd.player);
    }

    private void checkKeyScript() {
        int row = 0, col = 0;
        switch (gd.player.face) {
            case Player.UP:
                row = gd.player.row - 1;
                col = gd.player.col;
                break;
            case Player.DOWN:
                row = gd.player.row + 1;
                col = gd.player.col;
                break;
            case Player.LEFT:
                row = gd.player.row;
                col = gd.player.col - 1;
                break;
            case Player.RIGHT:
                row = gd.player.row;
                col = gd.player.col + 1;
                break;
        }
        if (row >= 0 && row < gd.curMap.rowNum && col >= 0 && col < gd.curMap.colNum) {
            if (gd.curMap.scriptType[row][col] == 3 || gd.curMap.scriptType[row][col] == 4) {
                se.addScript(gd.curMap.getScript(row, col));
            }
        }
    }
}
