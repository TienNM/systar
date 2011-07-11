package engine;

import model.Map;

public class Data {

    private int startRow = 0;// ���ݿ����Ͻ������к�
    private int startCol = 0;// ���ݿ����Ͻ������к�
    private int endCol = 0;// ���ݿ����½������к�
    private int endRow = 0;// ���ݿ����½������к�
    private int startX = 0;// ���ݿ����Ͻǵ�X����
    private int startY = 0;// ���ݿ����Ͻǵ�Y����
    private int endX = 0;// ���ݿ����½ǵ�X����
    private int endY = 0;// ���ݿ����½ǵ�Y����
    private int a_X = 0;// ��갴��ʱ��X����
    private int a_Y = 0;// ��갴��ʱ��Y����
    private int b_X = 0;// ��굯��ʱ��X����
    private int b_Y = 0;// ��굯��ʱ��Y����

    public int getEndCol() {
        return endCol;
    }

    public int getEndRow() {
        return endRow;
    }

    public int getEndX() {
        return endX;
    }

    public int getEndY() {
        return endY;
    }

    public int getStartCol() {
        return startCol;
    }

    public int getStartRow() {
        return startRow;
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public void setA_X(int a_x) {
        a_X = a_x;
    }

    public void setA_Y(int a_y) {
        a_Y = a_y;
    }

    public void setB_X(int b_x) {
        b_X = b_x;
    }

    public void setB_Y(int b_y) {
        b_Y = b_y;
    }

    public void update(Map map) {

        startX = Math.min(a_X, b_X);// ȷ�����ݿ����Ͻ�ԭʼX����
        startY = Math.min(a_Y, b_Y);// ȷ�����ݿ����Ͻ�ԭʼY����
        endX = Math.max(a_X, b_X);// ȷ�����ݿ����½�ԭʼX����
        endY = Math.max(a_Y, b_Y);// ȷ�����ݿ����½�ԭʼY����

        startRow = startY / map.getCellHeight();// ȷ�����ݿ����Ͻ������к�
        startCol = startX / map.getCellWidth();// ȷ�����ݿ����Ͻ������к�
        endRow = endY / map.getCellHeight();// ȷ�����ݿ����½������к�
        endCol = endX / map.getCellWidth();// ȷ�����ݿ����½������к�

        startX = startCol * map.getCellWidth(); // ȷ�����ݿ����Ͻ�����X����
        startY = startRow * map.getCellHeight(); // ȷ�����ݿ����Ͻ�����Y����
        endX = (endCol + 1) * map.getCellWidth();// ȷ�����ݿ����½�����X����
        endY = (endRow + 1) * map.getCellHeight();// ȷ�����ݿ����½�����Y����
    }
}
