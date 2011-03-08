package emulator.engine;

/**
 *
 * ������ͼ�ĸ���
 */
public abstract class BaseView implements View {

    /**
     * ��ͼ�¼�������
     */
    private Control control = null;

    /**
     * ��ȡ��ͼ������
     *
     * @return ��ͼ���ƣ����û���򷵻�null
     */
    public final Control getControl() {
        return control;
    }

    /**
     * ������ͼ����
     *
     * @param control
     *            ��ͼ������
     */
    public final void setControl(Control control) {
        this.control = control;
    }

    public final void repaint() {
        GameEngine.getInstance().repaintRenderLayer();
    }
}
