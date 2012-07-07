package com.soyomaker.emulator.ui;

import java.awt.image.BufferedImage;
import java.io.IOException;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.BufferedImageUtil;
import org.newdawn.slick.util.ResourceLoader;

public class Texture2D {

	private Texture texture = null;

	public Texture2D(String file) {
		try {
			texture = TextureLoader.getTexture(file.substring(file.lastIndexOf(".") + 1),
					ResourceLoader.getResourceAsStream(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Texture2D(BufferedImage image, String name) {
		try {
			texture = BufferedImageUtil.getTexture(name, image);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void bind() {
		texture.bind();
	}

	public int getContentHeight() {
		return texture.getImageHeight();
	}

	public int getContentWidth() {
		return texture.getImageWidth();
	}

	public int getTextureHeight() {
		return texture.getTextureHeight();
	}

	public int getTextureWidth() {
		return texture.getTextureWidth();
	}

}
