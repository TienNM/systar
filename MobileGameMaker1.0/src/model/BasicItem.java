package model;

import java.awt.Image;

/*
 * �����ࡢ��Ʒ�ࡢװ����ĸ���
 */
public class BasicItem {

	private int index = 0;// ���

	private String name = null;// ����

	private int kind = 0;

	private String imgName = null;// ͼ������

	private Image img = null;// ͼ��

	private int lev = 0;// ʹ��Щ��Ŀ��Ҫ�ĵȼ�

	/*
	 * ��Ʒ������ָ����Ʒ�ܸ�ʹ���߸��Ӷ������Ի�Ե�����ɶ��������˺�
	 */

	private int hp = 0;// Ѫ��

	private int sp = 0;// ħ��ֵ

	private int maxhp = 0;// ���Ѫ��

	private int maxsp = 0;// ���ħ��ֵ

	private int stre = 0;// ����

	private int agil = 0;// ����

	private int inte = 0;// ����

	private int atk = 0;// ������

	private int def = 0;// �������

	private int matk = 0;// ħ������

	private int mdef = 0;// ħ������

	private int aspeed = 0;// �����ٶ�

	private int mspeed = 0;// �ƶ��ٶ�

	private int hit = 0;// ������

	private int flee = 0;// ������

	private String remark = null;

	public int getAgil() {
		return agil;
	}

	public int getAspeed() {
		return aspeed;
	}

	public int getAtk() {
		return atk;
	}

	public int getDef() {
		return def;
	}

	public int getFlee() {
		return flee;
	}

	public int getHit() {
		return hit;
	}

	public int getHp() {
		return hp;
	}

	public Image getImg() {
		return img;
	}

	public String getImgName() {
		return imgName;
	}

	public int getIndex() {
		return index;
	}

	public int getInte() {
		return inte;
	}

	public int getKind() {
		return kind;
	}

	public int getLev() {
		return lev;
	}

	public int getMatk() {
		return matk;
	}

	public int getMaxhp() {
		return maxhp;
	}

	public int getMaxsp() {
		return maxsp;
	}

	public int getMdef() {
		return mdef;
	}

	public int getMspeed() {
		return mspeed;
	}

	public String getName() {
		return name;
	}

	public String getRemark() {
		return remark;
	}

	public int getSp() {
		return sp;
	}

	public int getStre() {
		return stre;
	}

	public void setAgil(int agil) {
		this.agil = agil;
	}

	public void setAspeed(int aspeed) {
		this.aspeed = aspeed;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public void setFlee(int flee) {
		this.flee = flee;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public void setImg(Image img) {
		this.img = img;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public void setInte(int inte) {
		this.inte = inte;
	}

	public void setKind(int kind) {
		this.kind = kind;
	}

	public void setLev(int lev) {
		this.lev = lev;
	}

	public void setMatk(int matk) {
		this.matk = matk;
	}

	public void setMaxhp(int maxhp) {
		this.maxhp = maxhp;
	}

	public void setMaxsp(int maxsp) {
		this.maxsp = maxsp;
	}

	public void setMdef(int mdef) {
		this.mdef = mdef;
	}

	public void setMspeed(int mspeed) {
		this.mspeed = mspeed;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void setSp(int sp) {
		this.sp = sp;
	}

	public void setStre(int stre) {
		this.stre = stre;
	}

}
