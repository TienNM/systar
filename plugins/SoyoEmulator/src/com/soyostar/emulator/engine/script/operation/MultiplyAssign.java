package com.soyostar.emulator.engine.script.operation;


/**
 *
 * 赋值 *=
 */
public class MultiplyAssign implements OperationInterface {

    public String operate(String operand1, String operand2) {
        String result = Integer.parseInt(se.getVarList().getValue(operand1)) * Integer.parseInt(se.getVarList().getValue(operand2)) + "";
        se.getVarList().setValue(operand1, result);
        return result;
    }
}