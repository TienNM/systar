package model;

import java.util.Vector;

//��Һ͵������ϱ���һ����Ʒ�����ڱ����ɫ�����˵�ǰ��ӵ�е���Ʒ
public class SkillList extends Vector {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public void addSkill(Skill skill) {
        addElement(skill);
    }

    public void delskill(int index) {
        //ɾ�������б���ָ�����ܱ�ŵļ���
        removeElementAt(index);
    }

    public Skill getSkill(int index) {
        //���ؼ����б���ָ�����ܱ�ŵļ���
        Skill skill = null;
        if (hasSkill(index)) {
            for (int i = 0; i < size(); i++) {
                skill = (Skill) elementAt(i);
                if (skill.getIndex() == index) {
                    break;
                }
            }
        }
        return skill;

    }

    public boolean hasSkill(int index) {
        //����Ƿ���ָ����ŵļ���
        boolean judge = false;
        Skill skill = null;
        for (int i = 0; i < size(); i++) {
            skill = (Skill) elementAt(i);
            if (skill.getIndex() == index) {
                judge = true;
                break;
            }
        }
        return judge;
    }

    public Skill skillAt(int num) {
        //��ȡ���ܱ���ָ��λ�õļ���
        return (Skill) elementAt(num);
    }

    public int getMaxIndex() {
        int max = 0;
        Skill skill = null;
        for (int i = 0; i < size(); i++) {
            skill = skillAt(i);
            if (skill.getIndex() > max) {
                max = skill.getIndex();
            }
        }
        return max;
    }
}
