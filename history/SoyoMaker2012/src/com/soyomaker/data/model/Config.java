/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soyomaker.data.model;

import java.util.ArrayList;

/**
 * 配置
 * @author Administrator
 */
public class Config extends Model {
    // 系统

    /**
     *
     */
    public System system = new System();

    /**
     *
     */
    public class System {

        /**
         *
         */
        public ArrayList<Player> initPlayers = new ArrayList<Player>();//初始的角色列表
        /**
         *
         */
        public int curMapIndex;//初始地图
        /**
         *
         */
        public int row;//初始行号
        /**
         *
         */
        public int col;//初始列号
        /**
         *
         */
        public byte face;//初始面向
        /**
         *
         */
        public ArrayList<Attribute> attributes = new ArrayList<Attribute>();//属性列表
        /**
         *
         */
        public String skin = "";//皮肤
        /**
         *
         */
        public String titleBackground = "";//标题界面背景
        /**
         *
         */
        public int startAniIndex = -1;//开场动画
        /**
         *
         */
        public int endAniIndex = -1;//游戏结束动画
        /**
         *
         */
        public String startBattleSound = "";//开始战斗音效
        /**
         *
         */
        public String titleMusic = "";//标题界面音乐
        /**
         *
         */
        public String battleMusic = "";//战斗音乐
        /**
         *
         */
        public String winBattleSound = "";//战斗胜利音效
        /**
         *
         */
        public String escapeSound = "";//逃跑音效
        /**
         *
         */
        public String selectedSound = "";//选中音效
        /**
         *
         */
        public String confirmSound = "";//确认音效
        /**
         *
         */
        public String cancelSound = "";//取消音效
        /**
         *
         */
        public String warnSound = "";//警告音效
        /**
         *
         */
        public String equipSound = "";//装备音效
        /**
         *
         */
        public String shopSound = "";//商店音效
        /**
         *
         */
        public String readSound = "";//读档音效
        /**
         *
         */
        public String saveSound = "";//存档音效
    }
    // 用语
    /**
     *
     */
    public Term term = new Term();

    /**
     *
     */
    public class Term {

        /**
         * 物品
         */
        public String item = "物品";
        /**
         * 装备
         */
        public String equip = "装备";
        /**
         * 技能
         */
        public String skill = "技能";
        /**
         * 游戏名称
         */
        public String name = "游戏名称";
        /**
         * 游戏帮助
         */
        public String help = "游戏帮助";
        /**
         * 游戏关于
         */
        public String about = "游戏关于";
        /**
         * 血
         */
        public String hp = "HP";
        /**
         * 魔
         */
        public String sp = "SP";
        /**
         *
         */
        public String stre = "力量";
        /**
         *
         */
        public String inte = "智力";
        /**
         *
         */
        public String agil = "敏捷";
        /**
         *
         */
        public String dext = "灵巧";
        /**
         *
         */
        public String body = "体力";
        /**
         *
         */
        public String luck = "幸运";
        /**
         *
         */
        public String atk = "物理攻击";
        /**
         *
         */
        public String def = "物理防御";
        /**
         *
         */
        public String magicAtk = "魔法攻击";
        /**
         *
         */
        public String magicDef = "魔法防御";
        /**
         *
         */
        public String flee = "闪避";
        /**
         *
         */
        public String money = "金币";
        /**
         *
         */
        public String helm = "头盔";
        /**
         *
         */
        public String armour = "铠甲";
        /**
         *
         */
        public String weapon = "武器";
        /**
         *
         */
        public String shield = "盾牌";
        /**
         *
         */
        public String boots = "战靴";
        /**
         *
         */
        public String jewelry = "饰品";
    }
}
