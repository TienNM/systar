package model;

import java.util.Vector;


//��Һ͵������ϱ���һ����Ʒ�����ڱ����ɫ�����˵�ǰ��ӵ�е���Ʒ
public class EquipList extends Vector {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public void addEquip(Equip equip) {
			addElement(equip);
	}

	public void delEquip(int index) {
		//ɾ�������б���ָ�����ܱ�ŵļ���
					removeElementAt(index);
	}

	public Equip getEquip(int index) {
		//���ؼ����б���ָ�����ܱ�ŵļ���
		Equip equip = null;
		if (hasEquip(index)) {
			for (int i = 0; i < size(); i++) {
				equip = (Equip) elementAt(i);
				if (equip.getIndex()==index)
					break;
			}
		}
		return equip;

	}

	public boolean hasEquip(int index) {
		//����Ƿ���ָ����ŵļ���
		boolean judge = false;
		Equip equip = null;
		for (int i = 0; i < size(); i++) {
			equip = (Equip) elementAt(i);
			if (equip.getIndex()==index) {
				judge = true;
				break;
			}
		}
		return judge;
	}

	public Equip equipAt(int num){
		//��ȡ���ܱ���ָ��λ�õļ���
		return (Equip)elementAt(num);
	}

	public int getMaxIndex(){
		int max=0;
		Equip equip=null;
		for(int i=0;i<size();i++){
			equip=equipAt(i);
			if(equip.getIndex()>max)max=equip.getIndex();
		}
		return max;
	}
}
