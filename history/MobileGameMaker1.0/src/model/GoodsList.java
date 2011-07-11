package model;

import java.util.Vector;


//��Һ͵������ϱ���һ����Ʒ�����ڱ����ɫ�����˵�ǰ��ӵ�е���Ʒ
public class GoodsList extends Vector {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void addItem(Goods item) {
			addElement(item);
	}

	public void delItem(int index) {
		//ɾ�������б���ָ�����ܱ�ŵļ���
					removeElementAt(index);
	}

	public Goods getItem(int index) {
		//���ؼ����б���ָ�����ܱ�ŵļ���
		Goods item = null;
		if (hasItem(index)) {
			for (int i = 0; i < size(); i++) {
				item = (Goods) elementAt(i);
				if (item.getIndex()==index)
					break;
			}
		}
		return item;

	}

	public boolean hasItem(int index) {
		//����Ƿ���ָ����ŵļ���
		boolean judge = false;
		Goods item = null;
		for (int i = 0; i < size(); i++) {
			item = (Goods) elementAt(i);
			if (item.getIndex()==index) {
				judge = true;
				break;
			}
		}
		return judge;
	}
	
	public Goods itemAt(int num){
		//��ȡ���ܱ���ָ��λ�õļ���
		return (Goods)elementAt(num);
	}
	
	public int getMaxIndex(){
		int max=0;
		Goods item=null;
		for(int i=0;i<size();i++){
			item=itemAt(i);
			if(item.getIndex()>max)max=item.getIndex();
		}
		return max;
	}
}
