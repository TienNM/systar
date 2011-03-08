package emulator.engine.script;

import system.Painter;

/**
 * �ű�������
 */
public class Interpreter {

    private ScriptEngine se = null;
    private Script script = null;
    private int curIndex = 0;
    private int length = 0;

    Interpreter(ScriptEngine se) {
        this.se = se;
    }

    /**
     * ����ָ���ű�
     * @param script Ҫ�����Ľű�
     */
    public void interpret(Script script) {
        if (script.command == null) {
            return;
        }
        this.script = script;
        curIndex = 0;//��ʼ�����������
        length = script.command.length;
        Command command = null;
        while (curIndex < length) {
            command = script.command[curIndex];
            analyse(command);
        }
    }

    private void analyse(Command command) {
        // ��ȡ����ָ����з���
        switch (command.type) {
            case Command.EXPRESSION:
                doExpression(command);
                break;
            case Command.IF:
                doIf(command);
                break;
            case Command.ENDIF:
                doEndIf(command);
                break;
            case Command.WHILE:
                doWhile(command);
                break;
            case Command.ENDWHILE:
                doEndWhile(command);
                break;
            case Command.BREAK:
                doBreak(command);
                break;
            case Command.CONTINUE:
                doContinue(command);
                break;
            case Command.EXIT:
                doExit(command);
                break;
            case Command.DIALOG:
                doDialog(command);
                break;
            case Command.SOUND:
                doSound(command);
                break;
            case Command.WAIT:
                doWait(command);
                break;
            case Command.ITEMSHOP:
                doItemShop(command);
                break;
            case Command.EQUIPSHOP:
                doEquipShop(command);
                break;
            case Command.GAMEOVER:
                doGameOver(command);
                break;
            case Command.MAP:
                doMap(command);
                break;
            case Command.FACE:
                doFace(command);
                break;
            case Command.MOVE:
                doMove(command);
                break;
            case Command.FIGHT:
                doFight(command);
                break;
        }
    }

    private void doExpression(Command command) {
        se.getExpCalc().calculate(command.param);
        curIndex++;
    }

    private void doIf(Command command) {
        String result = se.getExpCalc().calculate(command.param);
        if (result.equals("true")) {
            curIndex++;

        } else if (result.equals("false")) {
            curIndex = command.nextIndex;

        }

    }

    private void doEndIf(Command command) {
        curIndex++;
    }

    private void doWhile(Command command) {
        String result = se.getExpCalc().calculate(command.param);
        if (result.equals("true")) {
            curIndex++;

        } else if (result.equals("false")) {
            curIndex = command.nextIndex;

        }
    }

    private void doEndWhile(Command command) {
        curIndex = command.nextIndex;
    }

    private void doBreak(Command command) {
        curIndex = command.nextIndex;
    }

    private void doContinue(Command command) {
        curIndex = command.nextIndex;
    }

    private void doExit(Command command) {
        curIndex = length;
    }

    private void doDialog(Command command) {
        se.addEvent(new Event(Event.DIALOG, script.row, script.col, Painter.split(command.param, " ")));
        curIndex++;

    }

    private void doSound(Command command) {
        se.addEvent(new Event(Event.SOUND, script.row, script.col, Painter.split(command.param, " ")));
        curIndex++;
    }

    private void doWait(Command command) {
        se.addEvent(new Event(Event.WAIT, script.row, script.col, Painter.split(command.param, " ")));
        curIndex++;
    }

    private void doItemShop(Command command) {
        se.addEvent(new Event(Event.ITEMSHOP, script.row, script.col, Painter.split(command.param, " ")));
        curIndex++;
    }

    private void doEquipShop(Command command) {
        se.addEvent(new Event(Event.EQUIPSHOP, script.row, script.col, Painter.split(command.param, " ")));
        curIndex++;
    }

    private void doGameOver(Command command) {
        se.addEvent(new Event(Event.GAMEOVER, script.row, script.col, null));
        curIndex++;
    }

    private void doMap(Command command) {
        se.addEvent(new Event(Event.MAP, script.row, script.col, Painter.split(command.param, " ")));
        curIndex++;
    }

    private void doFace(Command command) {
        se.addEvent(new Event(Event.FACE, script.row, script.col, Painter.split(command.param, " ")));
        curIndex++;
    }

    private void doMove(Command command) {
        se.addEvent(new Event(Event.MOVE, script.row, script.col, Painter.split(command.param, " ")));
        curIndex++;
    }

    private void doFight(Command command) {

        se.addEvent(new Event(Event.FIGHT, script.row, script.col, Painter.split(command.param, " ")));
        curIndex++;
    }
}
