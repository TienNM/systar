package converter;

import java.util.Stack;
import java.util.Vector;

//������ʽ����
public final class ExpParser {

    private static String backString = "";
    private static Stack<String> stack = new Stack<String>();
    private static String expression = " ";
    private static Vector<String> expVector = new Vector<String>();
    private static boolean judge = false;
    private static String[] singleSign = new String[]{"|", "&", "!", ">", "<", "=", "+",
        "-", "*", "/", "(", ")", "%"};
    private static String[] doubleSign = new String[]{"||", "!=", "==", "&&", ">=", "<=",
        "+=", "-=", "*=", "/=", "%="};
    private static Vector<String> tempVector = new Vector<String>();
    private static int start = 0, end = 1;

    private ExpParser() {
    }

    private static void getBackExp() {
        // ͨ�������õ����ʽ�ĺ������У���ȥ�������ţ���˳�򱣴���expVector�У�
        expVector.removeAllElements();
        String temp1 = "";// �����tempVector�ж�����Ԫ��
        String temp2 = "";// ����ջ��Ԫ��
        for (int i = 0; i < tempVector.size(); i++) {
            temp1 = (String) tempVector.get(i);
            if (!isSingleSign(temp1) && !isDoubleSign(temp1)) { // ���������Ԫ�ز��ǲ�������ֱ�Ӵ���expVector
                expVector.add(temp1);
            } else if (temp1.equals("(")) { // "(" ֱ�ӽ�ջ
                stack.push(temp1);
            } else { // ���������Ԫ���ǲ�����
                if (stack.empty()) // ���ջΪ����ֱ�ӽ�Ԫ�ؽ�ջ
                {
                    stack.push(temp1);
                } else if (temp1.equals(")")) { // ���������Ԫ����")"
                    temp2 = stack.pop();
                    while (!temp2.equals("(")) {
                        expVector.add(temp2);
                        temp2 = stack.pop();
                    }
                } else { // ��������Ĳ�Ԫ����")"
                    while (!stack.empty()) {
                        temp2 = stack.peek();
                        if (getSignLev(temp1) > getSignLev(temp2)) {
                            // �����ǰ��������������ȼ�����ջ������������ȼ�
                            stack.push(temp1);
                            break;
                        } else {
                            expVector.add(stack.pop());
                        }
                    }
                    if (stack.empty()) {
                        stack.push(temp1);
                    }
                }
            }
        }
        while (!stack.empty()) {
            expVector.add(stack.pop());
        }
    }

    public static String getBackExp(String exp) {
        expression = exp;
        getTokens();
        getBackExp();
        getBackString();
        return backString;

    }

    private static void getBackString() {
        backString = "";
        for (int i = 0; i < expVector.size(); i++) {
            backString += (expVector.get(i) + " ");
        }
        backString = backString.trim();
    }

    private static int getSignLev(String str) {
        // �������������ȼ�
        int lev = 0;
        if (str.equals("!")) {
            lev = 10;
        } else if (str.equals("*") || str.equals("/") || str.equals("%")) {
            lev = 9;
        } else if (str.equals("+") || str.equals("-")) {
            lev = 8;
        } else if (str.equals(">") || str.equals(">=") || str.equals("<")
                || str.equals("<=")) {
            lev = 7;
        } else if (str.equals("!=") || str.equals("==")) {
            lev = 6;
        } else if (str.equals("&&")) {
            lev = 5;
        } else if (str.equals("||")) {
            lev = 4;
        } else if (str.equals("=") || str.equals("+=") || str.equals("-=")
                || str.equals("*=") || str.equals("/=") || str.equals("%=")) {
            lev = 3;
        } else if (str.equals("(") || str.equals(")")) // ���ڡ�����ֱ�ӽ�ջ������������ջ��Ϊ�˺������������ȷ��ջ���������ȼ�����Ϊ0
        {
            lev = 0;
        }
        return lev;

    }

    private static void getTokens() {
        // ���ܣ�1�������ʽ�ַ����ֽ�Ϊ�������Ͳ�������˳������tempVector��
        // ���ܣ�2�������ʽ�еĸ��ź����Ŵ���ɼӺźͼ��ţ���������ǰ���0��

        // ��һ��
        start = 0;
        end = 1;
        tempVector.removeAllElements();
        String temp = "";
        while (start < expression.length() && end <= expression.length()) {
            temp = expression.substring(end - 1, end);
            if (!isSingleSign(temp)) {
                end++;
            } else {

                if (start != end - 1) {
                    temp = expression.substring(start, end - 1);
                    tempVector.add(temp);
                }
                if (end < expression.length()) {
                    temp = expression.substring(end - 1, end + 1);
                }
                if (isDoubleSign(temp)) {// �����˫��ĸ�����
                    temp = expression.substring(end - 1, ++end);
                    tempVector.add(temp);
                    start = end;
                    end++;
                } else {// ����ǵ���ĸ�����
                    temp = expression.substring(end - 1, end);
                    tempVector.add(temp);
                    start = end;
                    end++;
                }
            }
        }
        if (!isSingleSign(expression.substring(expression.length() - 1))) {
            tempVector.add(expression.substring(start, end - 1));
        }

        // �ڶ���
        for (int i = 0; i < tempVector.size(); i++) {
            String str = tempVector.get(i);
            if (str.equals("+") || str.equals("-")) {
                // �����⵽�ķ�����+��-
                // ����˷���ǰû���κζ�������������
                // ����˷���֮ǰ��һ������( ")" ���� )��Ҳ��������
                if (i == 0) {
                    tempVector.add(i + 2, ")");
                    tempVector.add(i, "0");
                    tempVector.add(i, "(");
                } else if (!tempVector.get(i - 1).equals(")")
                        && (isSingleSign(tempVector.get(i - 1)) || isDoubleSign(tempVector.get(i - 1)))) {
                    tempVector.add(i + 2, ")");
                    tempVector.add(i, "0");
                    tempVector.add(i, "(");
                }
            }
        }
    }

    private static boolean isDoubleSign(String s) {
        // ��s��˫��ĸ������򷵻�true�����򷵻�false
        judge = false;
        for (int i = 0; i < doubleSign.length; i++) {
            if (s.equals(doubleSign[i])) {
                judge = true;
                break;
            }
        }
        return judge;

    }

    private static boolean isSingleSign(String s) {
        // ��s�ǵ���ĸ������򷵻�true�����򷵻�false
        judge = false;
        for (int i = 0; i < singleSign.length; i++) {
            if (s.equals(singleSign[i])) {
                judge = true;
                break;
            }
        }
        return judge;
    }
}
