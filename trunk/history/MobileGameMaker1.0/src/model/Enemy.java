package model;

public class Enemy extends Role implements Cloneable {

    private int dpy = 0;// ��ɢ��
    public Skill[] skillList;
    private String description = "";//����

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDpy() {
        return dpy;
    }

    public void setDpy(int dpy) {
        this.dpy = dpy;
    }

    public void hit(Role c) {
        //ʹ����Ʒ�������������ܹ�����AI���������
    }

    @Override
    public Enemy clone() {
        try {
            return (Enemy) super.clone();
        } catch (Exception e) {
        }
        return null;
    }
}
