package engine;

import com.soyostar.app.KeyEvent;
import com.soyostar.app.TouchEvent;
import com.soyostar.xml.XMLObject;
import com.soyostar.xml.XMLParser;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 游戏主引擎
 *
 */
public final class GameEngine implements Runnable {

    /**
     * 游戏引擎单例模式
     */
    private static GameEngine ge = new GameEngine();

    /**
     * 获取游戏引擎运行时实例
     * @return 游戏引擎运行时实例
     */
    public static GameEngine getInstance() {
        return ge;
    }
    /**
     * 视图渲染层
     */
    private RenderLayer renderLayer = null;
    /**
     * 游戏管理器
     */
    private GameManager gameManager = null;
    /**
     * 循环计数器
     */
    private int ticker = 0;
    /**
     * 按键事件
     */
    private KeyEvent ke = null;
    /**
     * 当前触屏事件
     */
    private TouchEvent te = null;
    /**
     * 循环等待时间
     */
//    private int delay = 80;
    /**
     * fps
     */
    private int fps = 12;
    /**
     * 游戏引擎运行状态标识
     */
    private volatile boolean isRun = false;
    /**
     * 程序入口的引用
     */
    private Main main = null;
    /**
     * 游戏实例
     */
    private Game game = null;

    /**
     * 构造器
     *
     */
    private GameEngine() {
        renderLayer = new RenderLayer(this);
        gameManager = new GameManager();
    }

    /**
     * 退出游戏引擎
     *
     */
    public void exit() {
        isRun = false;
    }

    /**
     * 获取正在游戏引擎中运行的游戏实例
     * @return 正在游戏引擎中运行的游戏实例
     */
    public Game getGame() {
        return game;
    }

    /**
     * 游戏引擎初始化
     */
    private void init() {
        System.out.println("初始化游戏实例");
        isRun = true;
        game = gameManager.getCurGame();

    }

    /**
     * 检测游戏引擎的运行状态
     *
     * @return 游戏引擎的运行状态
     */
    protected boolean isRun() {
        return isRun;
    }

    /**
     * 游戏引擎主循环
     */
    public void run() {
        try {
            while (isRun) {
                long time = System.currentTimeMillis();
                //更新游戏
                game.update();

                //触屏处理
                if (te != null) {
                    game.onTouchEvent(te);
                }
                // 处理按键
                if (ke != null) {
                    game.onKeyEvent(ke);
                }

                // 渲染视图
                game.render(renderLayer.getPainter());
                renderLayer.repaint();
                time = System.currentTimeMillis() - time;

                // 循环等待

                if (time < 1000 / fps) {
                    Thread.sleep(1000 / fps - time);//保证fps维持一个定值
                }

                // 循环计数器自增
                ticker++;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        main.stop();
    }

    protected void setKey(KeyEvent ke) {
        this.ke = ke;
    }

    protected void setTouchEvent(TouchEvent te) {
        this.te = te;
    }

    public void clearTouchEvent() {
        te = null;
    }

    public void clearKeyEvent() {
        ke = null;
    }

    /**
     * 设置程序入口
     *
     * @param main
     *            程序入口
     */
    public void setMain(Main main) {
        this.main = main;
        System.out.println("设置Canvas");
        main.setContentPanel(renderLayer);
    }

    public int getScreenWidth() {
        return renderLayer.getWidth();
    }

    public int getScreenHeight() {
        return renderLayer.getHeight();
    }

    /**
     * 启动游戏引擎
     *
     */
    public void start() {
        System.out.println("启动游戏引擎");
        init();
        if (game != null) {
            game.start();
            new Thread(this).start();
        } else {
            main.stop();
        }
    }

    /**
     * 游戏管理器
     */
    private class GameManager {

        private String configFile = "config.xml";
        private Map<Integer, GameNode> games = null;
        private int curGameIndex = -1;

        public Game getCurGame() {
            if (games == null) {
                loadConfig();
            }
            return games.get(curGameIndex).game;

        }

        public void setCurGame(int index) {
            if (games.containsKey(index)) {
                curGameIndex = index;
            } else {
                try {
                    throw new Exception("不存在编号为" + index + "的游戏实例");
                } catch (Exception ex) {
                    Logger.getLogger(GameEngine.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }

        public void setCurGame(String fullName) {
            boolean hasGame = false;
            for (GameNode gn : games.values()) {
                if (gn.fullName.equals(fullName)) {
                    curGameIndex = gn.id;
                    hasGame = true;
                    break;
                }
            }
            if (!hasGame) {
                try {
                    throw new Exception("不存在名为" + fullName + "的游戏实例");
                } catch (Exception ex) {
                    Logger.getLogger(GameEngine.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        private void loadConfig() {
            try {
                // 加载配置文件
                games = new HashMap<Integer, GameNode>();
                XMLObject engine = XMLParser.parse(new File(configFile));
                curGameIndex = Integer.parseInt(engine.getFirstXMLObject("CurrentGameID").getValue());
                XMLObject[] gamesObject = engine.getXMLObjectArray("Game");
                for (XMLObject gameObject : gamesObject) {
                    int id = Integer.parseInt(gameObject.getFirstXMLObject("ID").getValue());
                    String fullName = gameObject.getFirstXMLObject("FullName").getValue();
                    Game game = (Game) Class.forName(fullName).newInstance();
                    games.put(id, new GameNode(id, fullName, game));
                }
            } catch (Exception ex) {
                Logger.getLogger(GameEngine.class.getName()).log(Level.SEVERE, null, ex);
            }


        }

        private class GameNode {

            public GameNode(int id, String fullName, Game game) {
                this.id = id;
                this.fullName = fullName;
                this.game = game;
            }
            /**
             * 游戏ID
             */
            public int id = -1;
            /**
             * 游戏入口类全名
             */
            public String fullName = null;
            /**
             * 游戏实例
             */
            public Game game = null;
        }
    }
}