package  frame.event.ui_event;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

import  frame.event.ui_event.dialog_game.*;
import  frame.event.ui_event.dialog_player.*;
import  frame.event.ui_event.dialog_process.*;

/**
 * 
 * @author Administrator
 */
public class UI_Event_Manager {

	public static final byte PROCESS = 0;// ���̿���

	public static final byte GAME = 1;// ��Ϸ����

	public static final byte PLAYER = 2;// ��ҿ���

	private Hashtable[] list = new Hashtable[3]; // ���̿�����Ի������� //��Ϸ������Ի�������
													// //��ɫ������Ի�������

	private Dialog_Main dialog_Main = null;

	public UI_Event_Manager(Dialog_Main dialog_Main) {
		this.dialog_Main = dialog_Main;
		initList_Process();
		initList_Game();
		initList_Player();
	}

	public Event_Dialog getEvent_Dialog(String text) {
		Event_Dialog event_Dialog = null;
		event_Dialog = (Event_Dialog) list[0].get(text);
		if (event_Dialog == null) {
			event_Dialog = (Event_Dialog) list[1].get(text);
		}
		if (event_Dialog == null) {
			event_Dialog = (Event_Dialog) list[2].get(text);
		}
		return event_Dialog;
	}

	protected String[] getTexts(byte type) {
		Enumeration e = list[type].keys();
		Vector v = new Vector();
		while (e.hasMoreElements()) {
			v.add(e.nextElement());
		}
		String[] t = new String[v.size()];
		for (int i = 0; i < t.length; i++) {
			t[i] = (String) v.elementAt(i);
		}
		v = null;
		e = null;
		return t;
	}

	private void initList_Game() {
		list[1] = new Hashtable();
		list[1].put("��������", new Dialog_Var(dialog_Main));
		list[1].put("���ز���", new Dialog_Switch(dialog_Main));
		list[1].put("��ʾ�Ի�", new Dialog_Dialog(dialog_Main));
		list[1].put("��������", new Dialog_Music(dialog_Main));
		list[1].put("ǿ�Ƶȴ�", new Dialog_Wait(dialog_Main));
		list[1].put("ǿ���ƶ�", new Dialog_Move(dialog_Main));
		list[1].put("�л���ͼ", new Dialog_Map  (dialog_Main));
		list[1].put("�ı�����", new Dialog_Face(dialog_Main));
		list[1].put("��Ʒ�̵�", new Dialog_ItemShop(dialog_Main));
		list[1].put("װ���̵�", new Dialog_EquipShop(dialog_Main));
		list[1].put("����ս��", new Dialog_Fight(dialog_Main));
		list[1].put("������Ϸ", new Dialog_ExitGame(dialog_Main));

	}

	private void initList_Player() {
		list[2] = new Hashtable();
		list[2].put("�ȼ�", new Dialog_Level(dialog_Main));
		list[2].put("����", new Dialog_Exp(dialog_Main));
		list[2].put("Ѫ��", new Dialog_Hp(dialog_Main));
		list[2].put("ħ��", new Dialog_Sp(dialog_Main));
		list[2].put("��Ǯ", new Dialog_Money(dialog_Main));
		list[2].put("��Ʒ", new Dialog_Item(dialog_Main));
		list[2].put("װ��", new Dialog_Equip(dialog_Main));
		list[2].put("����", new Dialog_Skill(dialog_Main));
		list[2].put("����", new Dialog_Attribute(dialog_Main));
	}

	private void initList_Process() {
		list[0] = new Hashtable();
		list[0].put("ѭ���ṹ", new Dialog_While(dialog_Main));
		list[0].put("�����ṹ", new Dialog_If(dialog_Main));
		list[0].put("����ѭ��", new Dialog_Break(dialog_Main));
		list[0].put("�´�ѭ��", new Dialog_Continue(dialog_Main));
		list[0].put("�����ű�", new Dialog_ExitScript(dialog_Main));
		list[0].put("�ű�ע��", new Dialog_Note(dialog_Main));
	}
}
