package emulator.engine;

import emulator.Canvas;
import emulator.Emulator;
import emulator.engine.script.Event;
import emulator.engine.script.ScriptEngine;
import emulator.model.GameData;

/**
 * ��Ϸ������
 *
 */
public final class GameEngine implements Runnable {

    /**
     * ��Ϸ���浥��ģʽ
     */
    private static GameEngine ge = new GameEngine();
    /**
     * �ű�����
     */
    private static ScriptEngine se = ScriptEngine.getInstance();

    /**
     * ��ȡ��Ϸ��������ʱʵ��
     * @return ��Ϸ��������ʱʵ��
     */
    public static GameEngine getInstance() {
        return ge;
    }
    /**
     * ��ͼ��Ⱦ��
     */
    private RenderLayer renderLayer = null;
    /**
     * ��Ϸ��ǰ��ͼ
     */
    private BaseView curView = null;
    /**
     * ��Ϸ��ǰ��ͼ�Ŀ�����
     */
    private Control control = null;
    /**
     * ѭ��������
     */
    private int ticker = 0;
    /**
     * ����ֵ
     */
    private int key = 0;
    /**
     * ѭ���ȴ�ʱ��
     */
//    private int delay = 80;
    /**
     * fps
     */
    private int fps = 12;
    /**
     * ��Ϸ��������״̬��ʶ
     */
    private volatile boolean isRun = false;
    /**
     * ������ڵ�����
     */
    private Emulator emulator = null;
    /**
     * ��Ϸʵ��
     */
    private Game game = null;
    private GameData gd = GameData.getGameData();

    /**
     * ������
     *
     */
    private GameEngine() {
        super();
        renderLayer = new RenderLayer(this);
        gd.gameObjectManager.initConfig();
    }

    /**
     * �ػ�
     *
     */
    protected void repaintRenderLayer() {
        renderLayer.repaint();
    }

    /**
     * �˳���Ϸ����
     *
     */
    public void exit() {
        isRun = false;
    }

    /**
     * ��ȡ������Ϸ���������е���Ϸʵ��
     * @return ������Ϸ���������е���Ϸʵ��
     */
    public Game getGame() {
        return game;
    }

    /**
     * ��ȡ����ֵ
     * @return
     */
    public int getKey() {
        return key;
    }

    /**
     * ��Ϸ�����ʼ��
     *
     */
    private void init() {
        System.out.println("��ʼ����Ϸʵ��");
        isRun = true;
        try {
            game = (Game) Class.forName("game.RpgGame").newInstance();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }


    }

    /**
     * �����Ϸ���������״̬
     *
     * @return ��Ϸ���������״̬
     */
    protected boolean isRun() {
        return isRun;
    }

    /**
     * ��Ϸ������ѭ��
     */
    public void run() {
        try {
            while (isRun) {
                long time = System.currentTimeMillis();
                //������Ϸ�¼�
                if (!game.isDealEvent() && !se.getEventQueue().isEmpty()) {
                    curView = game.getCurView();
                    if (curView != null) {
                        control = curView.getControl();
                        if (control != null) {
                            control.dealEvent(curView, (Event) se.getEventQueue().poll());
                        }

                    }
                }
                // ������
                if (key != 0) {
                    curView = game.getCurView();
                    if (curView != null) {
                        control = curView.getControl();
                        if (control != null) {
                            control.keyPressed(curView, key);
                        }
                    }
                }

                // ��Ⱦ��ͼ
                repaintRenderLayer();
                time = System.currentTimeMillis() - time;

                // ѭ���ȴ�

                if (time < 1000 / fps) {
                    Thread.sleep(1000 / fps - time);//��֤fpsά��һ����ֵ
                }

                // ѭ������������
                ticker++;
            }
        } catch (InterruptedException e) {
//            e.printStackTrace();
        }
        emulator.exit();
    }

    protected void setKey(int key) {
        this.key = key;
    }

    public void clearKey() {
        key = 0;
    }

    /**
     * ���ó������
     *
     * @param main
     *            �������
     */
    public void setEmulator(Emulator emulator) {
        this.emulator = emulator;
        emulator.setCanvas(renderLayer);
    }

    /**
     * ������Ϸ����
     *
     */
    public void start() {
        System.out.println("������Ϸ����");
        init();
        if (game != null) {
            se.start();
            game.start();
            new Thread(this).start();
        } else {
            emulator.exit();
        }
    }

    /**
     * ��ȡѭ��������
     * @return ѭ��������
     */
    public int getTicker() {
        return ticker;
    }


    public void switchToRenderLayer() {
        emulator.setCanvas(renderLayer);
    }

    public void changeCanvas(Canvas c) {
        emulator.setCanvas(c);
    }
}
