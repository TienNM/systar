package model;

//��Ʒ��
public class Goods extends BasicItem {

	public static final int RECOVER = 2;// ��������

	public static final int SATK = 0;// ���幥��

	public static final int AATK = 1;// ȫ�幥��

	public static final int OTHER = 3;// ����

	private int num = 0;// ��Ʒ����

	private int price = 0;// ��Ʒ�۸�


	private int exp = 0;// ʹ����Ʒ�õ��ľ���ֵ

	public int getExp() {
		return exp;
	}

	public int getNum() {
		return num;
	}

	public int getPrice() {
		return price;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
