package com.soyomaker.emulator.app;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import com.soyomaker.AppData;
import com.soyomaker.plugin.IPlugin;

public class Emulator extends JDialog implements IPlugin {

	private static final long serialVersionUID = -8809949650600479176L;

	public static final int TYPE_SOFTWARE = 0; // 独立程序

	public static final int TYPE_PLUGIN = 1; // 插件

	public static String DEFAULT_GAME_PATH = "./game";
	
	/**
	 * 独立启动
	 */
	public static void main(String[] args) {
		Emulator emulator = new Emulator();
		emulator.setType(TYPE_SOFTWARE);
		Config.getInstance().setGamePath(DEFAULT_GAME_PATH);
		emulator.startGame();
		emulator.setVisible(true);
	}

	private int type = TYPE_SOFTWARE; // 模拟器的启动类型

	private IGame game = null;

	/**
	 * Create the dialog.
	 */
	public Emulator() {
		// 初始化游戏实例
		initGame();
		// 初始化
		initUI();
	}

	private void initGame() {
		try {
			game = (IGame) Class.forName("com.soyomaker.emulator.app.Game").newInstance();
			UIScreen.getInstance().setGame(game);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void initUI() {
		// 大小不可拖动改变
		setResizable(false);
		// 标题
		setTitle("SoyoMakerEmulator");
		// 菜单
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu mnNewMenu = new JMenu("菜单");
		menuBar.add(mnNewMenu);
		JMenuItem menuItemStop = new JMenuItem("停止");
		menuItemStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stopGame();
			}
		});
		mnNewMenu.add(menuItemStop);
		// 游戏区域
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().add(UIScreen.getInstance());
		// 窗口事件监听
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				stopGame();
			}
		});
		pack();
		// 居中
		setLocationRelativeTo(null);
	}

	private void setType(int type) {
		this.type = type;
	}

	/**
	 * 插件启动
	 */
	@Override
	public void start() {
		if (AppData.getInstance().getCurProject() == null) {
			JOptionPane.showMessageDialog(this, "请先打开工程");
		} else {
			this.setType(TYPE_PLUGIN);
			Config.getInstance().setGamePath(AppData.getInstance().getCurProject().getPath());
			this.setModal(true);
			this.startGame();
			this.setVisible(true);
		}
	}

	/**
	 * 启动游戏
	 */
	private void startGame() {
		game.start();
	}

	/**
	 * 停止游戏
	 */
	private void stopGame() {
		game.stop();
		this.setVisible(false);
		if (type == TYPE_SOFTWARE) {
			System.exit(0);
		}
	}

}
