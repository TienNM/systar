package model;

//װ����
public class Equip extends BasicItem {

	public static final int HELM = 0;// ͷ��

	public static final int WEAPON = 2;// ����

	public static final int SHIELD = 3;// ����

	public static final int ARMOUR = 4;// ����

	public static final int TRINKET = 1;// ��Ʒ

	public static final int CALIGA = 5;// սѥ

	private int num = 0;// װ������

	private int price = 0;// װ���۸�

	public int getNum() {
		return num;
	}

	public int getPrice() {
		return price;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
