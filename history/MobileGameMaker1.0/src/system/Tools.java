package system;

import emulator.EmulatorGraphics;
import java.awt.Color;
import java.util.Random;
import emulator.model.GameData;

/**
 *
 * @author Administrator
 */
public class Tools {

    public static int GetRandom(int data) {
        int rand = new Random().nextInt();
        return Math.abs(rand % data);
    }

    public static int GetRandom(int rs, int re)//��ȡ�����
    {
        int tmp = rs + Math.abs(new Random().nextInt() % (re - rs + 1));
        return tmp;
    }
    //��ɫ����

    public static void cleanScreen(EmulatorGraphics g) {
        g.setClip(0, 0, GameData.getGameData().screenWidth, GameData.getGameData().screenHeight);
        g.setColor(Color.black);
        g.fillRect(0, 0, GameData.getGameData().screenWidth, GameData.getGameData().screenHeight);
    }

    public static int[] sort(int[] arraylist) {//ð������
        int len = arraylist.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (arraylist[j] < arraylist[i]) {
                    int temp = 0;
                    temp = arraylist[j];
                    arraylist[j] = arraylist[i];
                    arraylist[i] = temp;
                }
            }
        }
        return arraylist;
    }
}
