package emulator.engine;

import emulator.engine.script.DataHandlerInterface;
import emulator.engine.script.Script;
import emulator.engine.script.ScriptEngine;

public abstract class Game implements GameInterface {

    /**
     * ��Ϸ�ĵ�ǰ��ͼ
     */
    private BaseView curView = null;
    /**
     * ��Ϸ������
     */
    private GameEngine ge = GameEngine.getInstance();
    /**
     * �ű�����
     */
    private ScriptEngine se = ScriptEngine.getInstance();
    /**
     *�¼������ʶ
     */
    private volatile boolean isDealEvent = false;

    public boolean isDealEvent() {
        return isDealEvent;
    }

    /**
     * ��ʼ�¼�����
     */
    public void startEvent() {
        System.out.println("start deal event");
        isDealEvent = true;
    }

    /**
     * ����¼�����
     */
    public void finishEvent() {
        System.out.println("end del event");
        isDealEvent = false;
    }

    /**
     * ��ȡ��Ϸ�ĵ�ǰ��ͼ
     * @return ��Ϸ�ĵ�ǰ��ͼ������������򷵻�null
     */
    public final BaseView getCurView() {
        return curView;
    }

    /**
     * ������Ϸ�ĵ�ǰ��ͼ
     * @param curView Ҫ����Ϊ��ǰ��ͼ����ͼ
     */
    public final void setCurView(BaseView curView) {
        this.curView = curView;
    }

    /**
     * �˳���Ϸ
     */
    public final void exit() {
        ge.exit();
    }

    /**
     * ��ű������ύ�ű�
     * @param script �ű�
     */
    public final void referScript(Script script) {
        se.addScript(script);
        System.out.println("referScript �ύ�ű�");
    }

    public final void setDataHandler(DataHandlerInterface dhi) {
        se.setDataHandler(dhi);
    }
}
