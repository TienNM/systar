package emulator.engine.script.operation;

import emulator.engine.script.ScriptEngine;

/**
 *
 * ����ӿڣ������������Ҫʵ��
 */
public interface OperationInterface {

    public static final ScriptEngine se = ScriptEngine.getInstance();

    /**
     * ˫Ŀ�����
     * @param operand1 ������1
     * @param operand2 ������2
     * @return ����������
     */
    public String operate(String operand1, String operand2);
}
