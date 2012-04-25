package com.soyomaker.emulator.app;

import java.util.Random;

import org.keplerproject.luajava.LuaException;
import org.keplerproject.luajava.LuaObject;
import org.keplerproject.luajava.LuaState;
import org.keplerproject.luajava.LuaStateFactory;

import com.soyomaker.emulator.ui.Painter;
import com.soyomaker.emulator.utils.ColorFactory;
import com.soyomaker.emulator.utils.ImageFactory;
import com.soyomaker.emulator.utils.SMAudioPlayer;
import com.soyomaker.emulator.utils.SMLog;
import com.soyomaker.emulator.utils.SMString;

/**
 * Lua适配器，功能：<br>
 * 1、向lua环境注册java 接口 <br>
 * 2、提供转换lua实现的接口供java调用
 * 
 * @author wp_g4
 * 
 */
public class LuaAdapter {

	private LuaState luaState = null;

	private LuaObject luaGame = null;

	private LuaObject luaFunctionOnStart = null;

	private LuaObject luaFunctionOnTouch = null;

	private LuaObject luaFunctionUpdate = null;

	private LuaObject luaFunctionPaint = null;

	private LuaObject luaFunctionOnStop = null;

	private static String MAIN_FILE = "/smscript/game.smlua";

	private static String GAME_NAME = "Game";

	public LuaAdapter(IGame game) {
		try {
			// 设置LuaState
			luaState = LuaStateFactory.newLuaState();
			luaState.openLibs();
			luaState.LdoFile(GameInfo.getInstance().getGamePath() + MAIN_FILE);
			// 1、注册JAVA提供给lua的API
			// --注册GameEngine
			luaState.pushObjectValue(game);
			luaState.setGlobal("smGame");
			// --注册SMLog
			luaState.pushObjectValue(SMLog.getInstance());
			luaState.setGlobal("smLog");
			// --注册Random
			luaState.pushObjectValue(new Random());
			luaState.setGlobal("smRandom");
			// --注册ImageFactory
			luaState.pushObjectValue(ImageFactory.getInstance());
			luaState.setGlobal("smImageFactory");
			// --注册SMAudioPlayer
			luaState.pushObjectValue(SMAudioPlayer.getInstance());
			luaState.setGlobal("smAudioPlayer");
			// --注册ColorFactory
			luaState.pushObjectValue(ColorFactory.getInstance());
			luaState.setGlobal("smColorFactory");
			// --注册SMString
			luaState.pushObjectValue(SMString.getInstance());
			luaState.setGlobal("smString");
			// 2、转换lua实现的接口
			luaGame = luaState.getLuaObject(GAME_NAME);
			luaFunctionOnStart = luaGame.getField("onStart");
			luaFunctionOnTouch = luaGame.getField("onTouch");
			luaFunctionUpdate = luaGame.getField("update");
			luaFunctionPaint = luaGame.getField("paint");
			luaFunctionOnStop = luaGame.getField("onStop");
		} catch (LuaException e) {
			e.printStackTrace();
		}
	}

	public void callLuaGC() {
		luaState.getGlobal("collectgarbage");
		try {
			luaState.pushObjectValue("collect");
		} catch (LuaException e) {
			e.printStackTrace();
		}
		luaState.call(1, 0);
	}

	public float getLuaMemory() {
		luaState.getGlobal("collectgarbage");
		try {
			luaState.pushObjectValue("count");
		} catch (LuaException e) {
			e.printStackTrace();
		}
		luaState.call(1, 1);
		luaState.setField(LuaState.LUA_GLOBALSINDEX, "result");
		LuaObject lobj = luaState.getLuaObject("result");
		return (float) (lobj.getNumber() * 1024);
	}

	/**
	 * onStart方法的转换
	 */
	public void onStart() {
		try {
			luaFunctionOnStart.call(new Object[] { luaGame });
		} catch (LuaException e) {
			e.printStackTrace();
		}
	}

	/**
	 * onStop方法的转换
	 */
	public void onStop() {
		try {
			luaFunctionOnStop.call(new Object[] { luaGame });
		} catch (LuaException e) {
			e.printStackTrace();
		}
	}

	/**
	 * onTouch方法的转换
	 */
	public void onTouch(int keyX, int keyY, int type) {
		try {
			luaFunctionOnTouch.call(new Object[] { luaGame, keyX, keyY, type });
		} catch (LuaException e) {
			e.printStackTrace();
		}
	}

	/**
	 * paint方法的转换
	 */
	public void paint(Painter painter) {
		try {
			luaFunctionPaint.call(new Object[] { luaGame, painter });
		} catch (LuaException e) {
			e.printStackTrace();
		}
	}

	/**
	 * update方法的转换
	 */
	public void update() {
		try {
			luaFunctionUpdate.call(new Object[] { luaGame });
		} catch (LuaException e) {
			e.printStackTrace();
		}
	}
}
