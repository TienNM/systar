package com.soyomaker.emulator.ui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.ComponentColorModel;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Hashtable;

import javax.imageio.ImageIO;

import org.lwjgl.opengl.EXTTextureMirrorClamp;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLContext;

public class Texture {

	/** The colour model including alpha for the GL image */
	private static final ColorModel glAlphaColorModel = new ComponentColorModel(
			ColorSpace.getInstance(ColorSpace.CS_sRGB), new int[] { 8, 8, 8, 8 }, true, false,
			ComponentColorModel.TRANSLUCENT, DataBuffer.TYPE_BYTE);

	/** The colour model for the GL image */
	private static final ColorModel glColorModel = new ComponentColorModel(ColorSpace.getInstance(ColorSpace.CS_sRGB),
			new int[] { 8, 8, 8, 0 }, false, false, ComponentColorModel.OPAQUE, DataBuffer.TYPE_BYTE);

	/**
	 * 将图像转换为ByteBuffer
	 * 
	 * @param image
	 *            图像
	 * @return 图像数据的ByteBuffer
	 */
	@SuppressWarnings("rawtypes")
	public static ByteBuffer imageToByteBuffer(BufferedImage image) {
		ByteBuffer imageBuffer = null;
		WritableRaster raster = null;
		BufferedImage texImage = null;
		int width = image.getWidth();
		int height = image.getHeight();
		int textureWidth = 2;
		int textureHeight = 2;
		while (textureWidth < width) {
			textureWidth *= 2;
		}
		while (textureHeight < height) {
			textureHeight *= 2;
		}
		// 创建一个raster作为数据源
		boolean hasAlpha = image.getColorModel().hasAlpha();
		if (hasAlpha) {
			raster = Raster.createInterleavedRaster(DataBuffer.TYPE_BYTE, textureWidth, textureHeight, 4, null);
			texImage = new BufferedImage(glAlphaColorModel, raster, false, new Hashtable());
		} else {
			raster = Raster.createInterleavedRaster(DataBuffer.TYPE_BYTE, textureWidth, textureHeight, 3, null);
			texImage = new BufferedImage(glColorModel, raster, false, new Hashtable());
		}
		// 复制数据
		Graphics2D g = (Graphics2D) texImage.getGraphics();

		if (hasAlpha) {
			// 兼容mac系统需要进行下面操作
			g.setColor(new java.awt.Color(0f, 0f, 0f, 0f));
			g.fillRect(0, 0, textureWidth, textureHeight);
		}
		g.drawImage(image, 0, 0, null);
		// 创建ByteBuffer
		byte[] data = ((DataBufferByte) texImage.getRaster().getDataBuffer()).getData();
		imageBuffer = ByteBuffer.allocateDirect(data.length);
		imageBuffer.order(ByteOrder.nativeOrder());
		imageBuffer.put(data, 0, data.length);
		imageBuffer.flip();
		g.dispose();

		return imageBuffer;

	}

	private int textureID = 0;

	private int width = 0;

	private int height = 0;

	private int textureWidth = 0;

	private int textureHeight = 0;

	/**
	 * 创建空白纹理
	 * 
	 * @param width
	 *            纹理宽度
	 * @param height
	 *            纹理高度
	 */
	public Texture(int width, int height) {
		initWithBufferedImage(new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB));
	}

	/**
	 * 从文件中创建纹理
	 * 
	 * @param file
	 *            纹理文件
	 */
	public Texture(String file) {
		try {
			BufferedImage image = ImageIO.read(new File(file));
			BufferedImage texImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
			Graphics g = texImage.getGraphics();
			g.drawImage(image, 0, 0, null);
			g.dispose();
			initWithBufferedImage(texImage);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取纹理有效高度
	 * 
	 * @return 纹理有效高度
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * 获取纹理高度
	 * 
	 * @return 纹理高度
	 */
	protected int getTextureHeight() {
		return textureHeight;
	}

	/**
	 * 获取纹理的ID
	 * 
	 * @return 纹理的ID
	 */
	protected int getTextureID() {
		return textureID;
	}

	/**
	 * 获取纹理宽度
	 * 
	 * @return 纹理宽度
	 */
	protected int getTextureWidth() {
		return textureWidth;
	}

	/**
	 * 获取纹理有效宽度
	 * 
	 * @return 获取纹理有效宽度
	 */
	public int getWidth() {
		return width;
	}

	private void initWithBufferedImage(BufferedImage image) {
		// 纹理有效高度
		this.width = image.getWidth();
		this.height = image.getHeight();
		// TODO 计算纹理尺寸，算法可改进
		this.textureWidth = 2;
		this.textureHeight = 2;
		while (this.textureWidth < this.width) {
			this.textureWidth *= 2;
		}
		while (this.textureHeight < this.height) {
			this.textureHeight *= 2;
		}
		// 创建纹理
		this.textureID = GL11.glGenTextures();
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, this.textureID);
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_LINEAR);
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_LINEAR);
		if (GLContext.getCapabilities().GL_EXT_texture_mirror_clamp) {
			GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S,
					EXTTextureMirrorClamp.GL_MIRROR_CLAMP_TO_EDGE_EXT);
			GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_T,
					EXTTextureMirrorClamp.GL_MIRROR_CLAMP_TO_EDGE_EXT);
		} else {
			GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S, GL11.GL_CLAMP);
			GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_T, GL11.GL_CLAMP);
		}
		GL11.glTexImage2D(GL11.GL_TEXTURE_2D, 0, GL11.GL_RGBA8, this.textureWidth, this.textureHeight, 0, GL11.GL_RGBA,
				GL11.GL_UNSIGNED_BYTE, Texture.imageToByteBuffer(image));
	}

	/**
	 * 设置纹理上的数据
	 * 
	 * @param byteBuffer
	 *            数据
	 * @param x
	 *            替换区域的x坐标
	 * @param y
	 *            替换区域的y坐标
	 * @param width
	 *            替换区域的宽度
	 * @param height
	 *            替换区域的高度
	 */
	public void setData(ByteBuffer byteBuffer, int x, int y, int width, int height) {
		int textureWidth = 2;
		int textureHeight = 2;
		while (textureWidth < width) {
			textureWidth *= 2;
		}
		while (textureHeight < height) {
			textureHeight *= 2;
		}
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, this.textureID);
		GL11.glTexSubImage2D(GL11.GL_TEXTURE_2D, 0, x, y, textureWidth, textureHeight, GL11.GL_RGBA,
				GL11.GL_UNSIGNED_BYTE, byteBuffer);
	}
}
