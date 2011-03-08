package system;

import java.util.Vector;

/**
 * ����
 */
public class Queue extends Vector {

    /**
     * ��ָ����Ԫ�����
     * @param o Ҫ��ӵ�Ԫ��
     */
    public synchronized void offer(Object o) {
        addElement(o);
    }

    /**
     * ��ָ����Ԫ�������������
     * @param o Ҫ��ӵ�Ԫ������
     */
    public synchronized void offer(Object[] o) {
        for (int i = 0; i < o.length; i++) {
            addElement(o);
        }
    }

    /**
     * ��ȡ���Ƴ��˶��е�ͷ������˶���Ϊ�գ��򷵻� null��
     * @return ���е�ͷ������˶���Ϊ�գ��򷵻� null
     */
    public synchronized Object poll() {
        Object o = null;
        if (size() > 0) {
            o = elementAt(0);
            removeElementAt(0);
        }
        return o;
    }

    /**
     * ��ȡ�����Ƴ��˶��е�ͷ������˶���Ϊ�գ��򷵻� null��
     * @return �˶��е�ͷ������˶���Ϊ�գ��򷵻� null
     */
    public synchronized Object peck() {
        Object o = null;
        if (size() > 0) {
            o = elementAt(0);
        }
        return o;
    }

    /**
     * �������е�Ԫ�ذ����ӵ�˳�򱣴浽������
     * @return ������в�Ϊ���򷵻�һ��Ԫ�����飬���򷵻�null
     */
    public synchronized Object[] peckAll() {
        Object[] o = null;
        int size = size();
        if (size > 0) {
            o = new Object[size];
            for (int i = 0; i < size; i++) {
                o[i] = peck();
            }

        }
        return o;
    }
}
