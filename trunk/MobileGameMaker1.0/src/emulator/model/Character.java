package emulator.model;

import emulator.EmulatorImage;


/**
 *
 * ��ɫ��  ��Ϸ�����Ǻ͵��˵ĸ���
 */
public abstract class Character {

    public String name;//����
    public String intro;//����
    public EmulatorImage headImg;//ͷ��
    public int stre;//����
    public int agil;//����
    public int inte;//����
    public int hp;//Ѫ��
    public int sp;//ħ��ֵ
    public int maxHp;//���Ѫ��
    public int maxSp;//���ħ��ֵ
    public int lev;//�ȼ�
    public int atk;//����
    public int def;//����
    public int flee;//����
    public int exp;//����ֵ
    public int money;//��Ǯ
    public int waitTime;//�뼴ʱ���ٶȽ���
}
