/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.soyostar.game.view;

import com.soyostar.emulator.engine.BaseView;
import com.soyostar.emulator.engine.Control;
import com.soyostar.emulator.engine.GameEngine;
import com.soyostar.game.control.ShopControl;
import com.soyostar.game.model.Const;
import com.soyostar.game.model.GameData;
import com.soyostar.game.tools.Tools;
import com.soyostar.ui.Painter;
import java.awt.Color;



/**
 * @2011.4.7 byVV
 * @author Administrator
 */
public class ShopView extends BaseView {

    public static final int PAGE_MAIN = 0;
    public static final int PAGE_TIP = 1;
    private GameData gd = GameData.getGameData();
    private GameEngine ge = GameEngine.getInstance();
    private String[] tabItems = {"买进", "卖出"};
    private String[] names = null;

    public void init() {
        ShopControl sc = new ShopControl();
        setControl((Control) sc);
        gd.shop_pageIndex = PAGE_MAIN;
        gd.shop_tabIndex = 0;
        gd.shop_curIndex = gd.shop_topIndex = 0;
        gd.buildList_buy();
        gd.buildList_sell();
        buildNames();
        System.out.println("商店初始化完成");
    }

    public void paint(Painter painter) {
        if (gd.shop_needRebuild) {
            buildNames();
        }
        int th = 50;//标题栏高度
        int ih = 80;//介绍栏高度
        int ch = gd.screenHeight - th - ih;//中间列表区域高度
        int gap = 10;//间距
        int cellW = 160, cellH = 30;
        /**
         * 标题
         */
        Tools.drawDialog(painter, 0, 0, gd.screenWidth, th, Painter.DIALOG_DEEP);

        painter.setFontStyle(Painter.STYLE_BOLD);
        painter.setColor(Color.GREEN);
        painter.drawString(gd.shop_type == 0 ? "商店—物品" : "商店—装备", gd.screenWidth / 2, (th - painter.getClipHeight()) / 2, Const.Anchor.HT);
        /**
         * 列表
         */
        //底框
        Tools.drawDialog(painter, 0, th, gd.screenWidth, ch, Painter.DIALOG_DEEP);
        //选项卡
        Tools.drawTab(painter, 0, th, gd.screenWidth, ch, Painter.DIALOG_LIGHT, gd.shop_tabIndex, tabItems);
        painter.drawString("现有金钱：" + gd.player.money, 48 * 2 + 2 * gap, th + (24 - painter.getClipHeight()) / 2, Painter.LT);
        //列表
        gd.shop_showNum = (ch - 5 * gap) / cellH;//可显示技能数量
        int space = ch - 3 * gap - gd.shop_showNum * cellH;//总的竖向剩余空间
        space = space / (gd.shop_showNum + 1);//间距
        painter.setColor(Color.BLACK);

        painter.setFontStyle(Painter.STYLE_PLAIN);
        Tools.drawTable(painter, (gd.screenWidth - cellW) / 2 - gap / 2, th + 3 * gap, cellW, cellH, gd.shop_showNum, space, names, Color.BLACK, gd.shop_topIndex, gd.shop_curIndex, Const.Anchor.HV, Painter.NODIALOG, Painter.CELL_DEEP);

        /**
         * 介绍
         */
        Tools.drawDialog(painter, 0, th + ch, gd.screenWidth, ih, Painter.DIALOG_DEEP);
        //
        //FIX ME
        //若角色背包物品为0,或者装备为0
        //会出现越界异常
        //
        if (names.length > 0) {
            Tools.drawWordWrapString(painter, gd.shop_tabIndex == 0 ? gd.shop_items_buy[gd.shop_curIndex].intro : gd.shop_items_sell[gd.shop_curIndex].intro, gap / 2, th + ch + gap / 2, gd.screenWidth - gap, ih - gap, Color.WHITE);

        }
        /**
         * 滚动条
         */
        Tools.drawScrollbar(painter, Painter.SCROLLBAR_VERTICAL, (gd.screenWidth - cellW) / 2 + cellW + gap / 2, th + 3 * gap + space, th + ch - space, gd.shop_topIndex, gd.shop_showNum, names.length);

        if (gd.shop_pageIndex == PAGE_TIP) {
            Tools.drawDialog(painter, 0, (gd.screenHeight - ih) / 2, gd.screenWidth, ih, Painter.DIALOG_LIGHT);
            Tools.drawWordWrapString(painter, gd.shop_message, 0 + gap / 2, (gd.screenHeight - ih) / 2 + gap / 2, gd.screenWidth - gap, ih - gap, Color.BLACK);
        }
    }

    public void release() {
    }

    private void buildNames() {
        names = new String[gd.shop_tabIndex == 0 ? gd.shop_items_buy.length : gd.shop_items_sell.length];
        for (int i = 0; i < names.length; i++) {
            names[i] = gd.shop_tabIndex == 0 ? (gd.shop_items_buy[i].name + "   价格：" + gd.shop_items_buy[i].price) : (gd.shop_items_sell[i].name + "   价格：" + gd.shop_items_sell[i].price / 2 + "   数量：" + gd.shop_items_sell[i].num);
        }
        gd.shop_itemMaxNum = gd.shop_tabIndex == 0 ? gd.shop_items_buy.length : gd.shop_items_sell.length;
        gd.shop_needRebuild = false;
    }
}
