package com.soyomaker.emulator.app;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import com.soyomaker.emulator.app.InputDialog.InputListener;
import com.soyomaker.emulator.ui.Painter;
import com.soyomaker.emulator.utils.ColorFactory;

public class UIScreen extends JPanel implements InputListener {

	private static final long serialVersionUID = 7608812515686704871L;

	private static UIScreen instance = new UIScreen();

	public static UIScreen getInstance() {
		return instance;
	}

	private IGame game = null;

	private JPanel gamePanel = null;

	private InputDialog inputDialog = null;

	private UIScreen() {
		this.setLayout(null);
		this.setPreferredSize(new Dimension(GameInfo.getInstance().getWidth(),
				GameInfo.getInstance().getHeight()));
		// 游戏渲染层
		gamePanel = new JPanel() {

			private static final long serialVersionUID = 645901037817876536L;

			private Graphics graphics = null;

			private Painter painter = null;

			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				if (this.painter == null || this.graphics != g) {
					this.painter = new Painter(g);
				}
				// 清屏
				this.painter.setColor(ColorFactory.getInstance().BLACK);
				this.painter.fillRect(0, 0, getWidth(), getHeight());
				// 绘制游戏
				game.onPaint(this.painter);
			}
		};
		// 鼠标事件监听
		MouseAdapter mouseAdapter = new MouseAdapter() {

			public void mouseDragged(MouseEvent e) {
				if (inputDialog.isVisible()) {
					return;
				}
				game.onEvent(new Event(e.getX(), e.getY(),
						Event.EVENT_TYPE_MOVE));
			}

			public void mousePressed(MouseEvent e) {
				if (inputDialog.isVisible()) {
					return;
				}
				game.onEvent(new Event(e.getX(), e.getY(),
						Event.EVENT_TYPE_DOWN));
			}

			public void mouseReleased(MouseEvent e) {
				if (inputDialog.isVisible()) {
					return;
				}
				game.onEvent(new Event(e.getX(), e.getY(), Event.EVENT_TYPE_UP));
			}
		};
		gamePanel.addMouseMotionListener(mouseAdapter);
		gamePanel.addMouseListener(mouseAdapter);
		gamePanel.setSize(new Dimension(GameInfo.getInstance().getWidth(),
				GameInfo.getInstance().getHeight()));
		gamePanel.setLocation(0, 0);
		gamePanel.setLayout(null);
		this.add(gamePanel);

		inputDialog = new InputDialog(GameInfo.getInstance().getWidth(), 100);
		inputDialog.setLocation(0,
				gamePanel.getHeight() - inputDialog.getHeight());
		inputDialog.setVisible(false);
		inputDialog.setInputListener(this);
		gamePanel.add(inputDialog);
	}

	@Override
	public void onInput(String value) {
		this.showInputDialog(false);
		this.game.onInput(value);
	}

	public void requestRepaint() {
		gamePanel.paintImmediately(0, 0, gamePanel.getWidth(),
				gamePanel.getHeight());
	}

	public void setGame(IGame game) {
		this.game = game;
	}

	public void showInputDialog(boolean visible) {
		inputDialog.setVisible(visible);
	}
}
