package com.soyomaker.emulator.app;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.soyomaker.AppData;
import com.soyomaker.xml.XMLObject;
import com.soyomaker.xml.XMLParser;

public class Config {

	private static String CONFIG_PATH = "plugin/emulator/config/emulator.xml";

	private static Config instance = new Config();

	public static Config getInstance() {
		return instance;
	}

	private int width = 960;

	private int height = 640;

	private int fps = 20;
	
	private String gamePath=null;


	private Config() {
		try {
			XMLObject emulatorXMLObject = XMLParser.parse(new File(CONFIG_PATH));
			this.width = Integer.parseInt(emulatorXMLObject.getChild(0).getValue());
			this.height = Integer.parseInt(emulatorXMLObject.getChild(1).getValue());
			this.fps = Integer.parseInt(emulatorXMLObject.getChild(2).getValue());
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getFps() {
		return fps;
	}

	protected String getGamePath() {
		return gamePath;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public void setFps(int fps) {
		this.fps = fps;
	}

	protected void setGamePath(String gamePath) {
		this.gamePath = gamePath;
	}

}
