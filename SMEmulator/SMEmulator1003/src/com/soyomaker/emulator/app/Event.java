package com.soyomaker.emulator.app;

public class Event {

	public static final int EVENT_TYPE_DOWN = 0;

	public static final int EVENT_TYPE_MOVE = 1;

	public static final int EVENT_TYPE_UP = 2;

	private int x = -1;

	private int y = -1;

	private int type = -1;

	public Event(int x, int y, int type) {
		this.x = x;
		this.y = y;
		this.type = type;
	}

	public int getType() {
		return type;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public String toString() {
		return "Event{x=" + getX() + " y=" + getY() + " type=" + getType()
				+ "}";
	}
}