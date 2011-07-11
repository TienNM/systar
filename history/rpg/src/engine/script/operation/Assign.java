package engine.script.operation;

import engine.script.VarList;

/**
 *
 * 赋值 =
 */
public class Assign implements OperationInterface {

    public String operate(String operand1, String operand2) {
        se.getVarList().setValue(operand1, se.getVarList().getValue(operand2));
        return se.getVarList().getValue(operand2);
    }
}
