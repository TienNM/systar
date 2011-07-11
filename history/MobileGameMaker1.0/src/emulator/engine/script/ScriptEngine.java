package emulator.engine.script;

import system.Queue;

/**
 *
 * �ű�����
 */
public final class ScriptEngine implements Runnable {

    /**
     * ����ģʽ
     */
    private static ScriptEngine se = new ScriptEngine();
    /**
     * ��Ϸ���ݴ�����
     */
    private DataHandlerInterface dhi = null;
    /**
     * ѭ���ӳ�ʱ��
     */
    private int delay = 50;
    /**
     * ����״̬��ʶ
     */
    private volatile boolean isRun = false;
    /**
     * �ű�������
     */
    Interpreter interpreter = null;
    /**
     * ����Ľű�����
     */
    private Queue scriptQueue = new Queue();
    /**
     * �ű����洦��ű����ɵ���Ϸ�¼�����
     */
    private Queue eventQueue = new Queue();
    /**
     * ���ʽ������
     */
    private ExpCalc expCalc = null;

    public ExpCalc getExpCalc() {
        return expCalc;
    }
    /**
     * �ű������еı�����
     */
    private VarList varList = null;

    /**
     * ��ȡ�ű�����ı�����
     * @return �ű�����ı�����
     */
    public VarList getVarList() {
        return varList;
    }

    public Queue getEventQueue() {
        return eventQueue;
    }

    public void setEventQueue(Queue eventQueue) {
        this.eventQueue = eventQueue;
    }

    /**
     * ������
     */
    private ScriptEngine() {
        super();
        interpreter = new Interpreter(this);
        expCalc = new ExpCalc(this);
        varList = new VarList(this);
    }

    /**
     * ��ȡ�ű������ʵ��
     * @return �ű������ʵ��
     */
    public static ScriptEngine getInstance() {
        return se;
    }

    /**
     * �ű�������ѭ��
     */
    public void run() {
        while (isRun) {
            if (!scriptQueue.isEmpty()) {
                //����ű����в�Ϊ������ű�
                runScript((Script) scriptQueue.poll());
            } else {
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    /**
     * �����ű�����
     */
    public void start() {
        isRun = true;
        new Thread(this).start();
    }
    /**
     * �����ñ�������ʽ����ʱɾ��
     */
    int scriptNum = 0;

    /**
     * ���нű�����������Ϸ�¼���ŵ����Ӷ�����
     * @param script Ҫ����Ľű�
     */
    private void runScript(Script script) {
        System.out.println("�ű��������нű�");
        interpreter.interpret(script);
    }

    /**
     * Ϊ�ű��������Ҫ����ű�
     * @param script Ҫ����Ľű�
     */
    public void addScript(Script script) {
        scriptQueue.offer(script);
        System.out.println("�ű�������ӽű�");
    }

    /**
     * ���¼��б�����¼�
     * @param event Ҫ������¼�
     */
    public void addEvent(Event event) {
        eventQueue.offer(event);

    }

    public void exit() {
        isRun = false;
    }

    public void setDataHandler(DataHandlerInterface dhi) {
        this.dhi = dhi;
    }

    public DataHandlerInterface getDataHandler() {
        return dhi;
    }
}
