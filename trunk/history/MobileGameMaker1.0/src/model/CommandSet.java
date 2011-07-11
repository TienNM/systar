package model;

/**
 *
 * �ű�ת���󿪳ɵ�ָ���һ���ű���Ӧһ��ָ���һ��ָ��п����кܶ���ָ��
 */
public class CommandSet {

    public static final byte TOUCH_PAIALLEL = 1;//�Ӵ�����
    public static final byte TOUCH_SERIAL = 2;//�Ӵ�����
    public static final byte KEY_PAIALLEL = 3;//��������
    public static final byte KEY_SERIAL = 4;//��������
    public byte type = -1;//ָ�����
    public int row = -1;//ָ����ڵ���
    public int col = -1;//ָ����ڵ���
    public Command[] command = null;//ָ��е���䣬һ���ű�����Ӧһ��ָ��

    @Override
    public String toString() {
        String text = "";
        switch (type) {
            case TOUCH_PAIALLEL:
                text += "���ͣ��Ӵ�����\n";
                break;
            case TOUCH_SERIAL:
                text += "���ͣ��Ӵ�����\n";
                break;
            case KEY_PAIALLEL:
                text += "���ͣ���������\n";
                break;
            case KEY_SERIAL:
                text += "���ͣ���������\n";
                break;
            default:
                text += "���ͣ����ʹ���\n";
                break;
        }
        text += "�����кţ�" + row + " �����кţ�" + col + "\n";
        if (command != null) {
            int length = command.length;
            for (int i = 0; i < length; i++) {
                switch (command[i].type) {
                    case Command.EXPRESSION:
                        text += i + ":" + command[i].param + "\n";
                        break;
                    case Command.IF:
                        text += i + ":IF " + command[i].param + " " + command[i].nextIndex + "\n";
                        break;
                    case Command.ENDIF:
                        text += i + ":ENDIF\n";
                        break;
                    case Command.WHILE:
                        text += i + ":WHILE " + command[i].param + " " + command[i].nextIndex + "\n";
                        break;
                    case Command.ENDWHILE:
                        text += i + ":ENDWHILE " + command[i].nextIndex + "\n";
                        break;
                    case Command.BREAK:
                        text += i + ":BREAK " + command[i].nextIndex + "\n";
                        break;
                    case Command.CONTINUE:
                        text += i + ":CONTINUE " + command[i].nextIndex + "\n";
                        break;
                    case Command.EXIT:
                        text += i + ":EXIT\n";
                        break;
                    case Command.DIALOG:
                        text += i + ":DIALOG " + command[i].param + "\n";
                        break;
                    case Command.SOUND:
                        text += i + ":SOUND " + command[i].param + "\n";
                        break;
                    case Command.WAIT:
                        text += i + ":WAIT " + command[i].param + "\n";
                        break;
                    case Command.ITEMSHOP:
                        text += i + ":ITEMSHOP " + command[i].param + "\n";
                        break;
                    case Command.EQUIPSHOP:
                        text += i + ":EQUIPSHOP " + command[i].param + "\n";
                        break;
                    case Command.GAMEOVER:
                        text += i + ":GAMEOVER\n";
                        break;
                    case Command.MAP:
                        text += i + ":MAP " + command[i].param + "\n";
                        break;
                    case Command.FACE:
                        text += i + ":FACE " + command[i].param + "\n";
                        break;
                    case Command.MOVE:
                        text += i + ":MOVE " + command[i].param + "\n";
                        break;
                    case Command.FIGHT:
                        text += i + ":FIGHT " + command[i].param + "\n";
                        break;
                }
            }
        }
        return text;
    }
}
