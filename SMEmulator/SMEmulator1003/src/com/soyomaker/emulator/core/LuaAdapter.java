package com.soyomaker.emulator.core;

import java.util.Random;

import org.keplerproject.luajava.LuaException;
import org.keplerproject.luajava.LuaObject;
import org.keplerproject.luajava.LuaState;
import org.keplerproject.luajava.LuaStateFactory;

import com.soyomaker.emulator.utils.ImageFactory;
import com.soyomaker.emulator.utils.SMLog;

/**
 * Lua适配器，功能：<br>
 * 1、向lua环境注册java 接口 <br>
 * 2、提供转换lua实现的接口供java调用
 * 
 * @author wp_g4
 * 
 */
public class LuaAdapter {

	public static LuaAdapter newInstance(String luaFilePath, String globalGame) {
		return new LuaAdapter(luaFilePath, globalGame);
	}

	private LuaState luaState = null;

	private LuaObject luaFunctionOnStart = null;

	private LuaObject luaFunctionOnTouch = null;

	private LuaObject luaFunctionUpdate = null;

	private LuaObject luaFunctionPaint = null;

	private LuaObject luaFunctionOnStop = null;

	private LuaAdapter(String luaFilePath, String globalGame) {
		try {
			// 设置LuaState
			luaState = LuaStateFactory.newLuaState();
			luaState.openLibs();
			luaState.LdoFile(luaFilePath);
			// 1、注册JAVA提供给lua的API
			// --注册GameEngine
			luaState.pushObjectValue(GameEngine.getInstance());
			luaState.setGlobal("smGameEngine");
			// --注册Random
			luaState.pushObjectValue(new Random());
			luaState.setGlobal("smRandom");
			// --注册SMLog
			luaState.pushObjectValue(new SMLog());
			luaState.setGlobal("smLog");
			// --注册ImageFactory
			luaState.pushObjectValue(new ImageFactory());
			luaState.setGlobal("smImageFactory");
			// 2、转换lua实现的接口
			LuaObject lo = luaState.getLuaObject("globalGame");
			luaFunctionOnStart = lo.getField("onStart");
			luaFunctionOnTouch = lo.getField("onTouch");
			luaFunctionUpdate = lo.getField("update");
			luaFunctionPaint = lo.getField("paint");
			luaFunctionOnStop = lo.getField("onStop");
		} catch (LuaException e) {
			e.printStackTrace();
		}
	}

	/**
	 * onStart方法的转换
	 */
	public void onStart() {
		try {
			luaFunctionOnStart.call(null);
		} catch (LuaException e) {
			e.printStackTrace();
		}
	}

	/**
	 * onTouch方法的转换
	 */
	public void onTouch(int keyX, int keyY, int type) {
		try {
			luaFunctionOnTouch.call(new Object[] { luaFunctionOnTouch, keyX,
					keyY, type });
		} catch (LuaException e) {
			e.printStackTrace();
		}
	}

	/**
	 * update方法的转换
	 */
	public void update() {
		try {
			luaFunctionUpdate.call(null);
		} catch (LuaException e) {
			e.printStackTrace();
		}
	}

	/**
	 * paint方法的转换
	 */
	public void paint(Painter painter) {
		try {
			luaFunctionPaint.call(new Object[] { luaFunctionPaint, painter });
		} catch (LuaException e) {
			e.printStackTrace();
		}
	}

	/**
	 * onStop方法的转换
	 */
	public void onStop() {
		try {
			luaFunctionOnStop.call(null);
		} catch (LuaException e) {
			e.printStackTrace();
		}
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

}
