package model;

//������
public class Skill extends BasicItem {

    public static final int RECOVER = 2;// ��������
    public static final int SATK = 0;// ���幥��
    public static final int AATK = 1;// ȫ�幥��
    private int dpy = 0;// �˺���ɢ��
    private int aniIndex = 0;//���ܶ���id
    private int price = 0;//

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAniIndex() {
        return aniIndex;
    }

    public void setAniIndex(int aniIndex) {
        this.aniIndex = aniIndex;
    }

    public int getDpy() {
        return dpy;
    }

    public void setDpy(int dpy) {
        this.dpy = dpy;
    }
}
