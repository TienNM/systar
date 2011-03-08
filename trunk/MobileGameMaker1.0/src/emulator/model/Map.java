package emulator.model;

import emulator.EmulatorGraphics;
import emulator.EmulatorImage;
import emulator.engine.script.Script;
import java.awt.Graphics;

/**
 * ��ͼ
 */
public class Map {

    public int index;//���
    public String name;//����
    public String musicName;
    public EmulatorImage image;//��ͼȫͼ
    public int layerNum;//ͼ����
    public int rowNum;//����
    public int colNum;//����
    public int cellWidth;//��Ԫ����
    public int cellHeight;//��Ԫ��߶�
    public int scriptNum;//�ű���
    public int[][][] data;//��ͼ�������
    public int[][] way;//ͨ�ж�
    public byte[][] scriptType;//�ű�����
    public Script[] script;//�ű�
    public int x, y;//Ҫ���Ƶĵ�ͼregion��x,y����
    private GameData gd = GameData.getGameData();

    public void setImage(EmulatorImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        int maxRow = height / cellHeight;
        int maxCol = width / cellWidth;
        System.out.println("############################################");
        System.out.println("width:" + width);
        System.out.println("height:" + height);
        System.out.println("maxRow:" + maxRow);
        System.out.println("maxCol:" + maxCol);
        //�����޸�
        this.image = EmulatorImage.createImage(cellWidth * colNum, cellHeight * rowNum);
        EmulatorGraphics g = new EmulatorGraphics(this.image.getGraphics());
        for (int i = 0; i < layerNum; i++) {
            for (int j = 0; j < rowNum; j++) {
                for (int k = 0; k < colNum; k++) {
//                    System.out.println("***********************");
                    int num = data[i][j][k];
                    int row = (num - 1) / maxCol;
                    int col = (num - 1) % maxCol;
//                    System.out.println("num:" + num);
//                    System.out.println("row:" + row);
//                    System.out.println("col" + col);
                    if (num != 0) {
                        EmulatorImage tempImg = EmulatorImage.createImage(image, col * cellWidth, row * cellHeight, cellWidth, cellHeight, 0);
                        g.drawImage(tempImg, k * cellWidth, j * cellHeight, 0);
                    }
                }
            }
        }
    }

    /**
     * ����ָ����Ԫ���ϵĽű�
     * @param row ��Ԫ���к�
     * @param col ��Ԫ���к�
     * @return ָ����Ԫ���ϵĽű�������������򷵻�null
     */
    public Script getScript(int row, int col) {

        int num = script.length;
        Script tempScript = null;
        for (int i = 0; i < num; i++) {
            if (script[i].row == row && script[i].col == col) {
                tempScript = script[i];
                break;
            }
        }

        return tempScript;
    }

    public void init() {
    }

    public void resetRegion(Player player) {
//        System.out.println("Map.resetRegion");
        x = player.x - GameData.getGameData().screenWidth / 2;
        y = player.y - GameData.getGameData().screenHeight / 2;
        if (x < 0) {
            x = 0;
        }
        if (y < 0) {
            y = 0;
        }
        if (x + GameData.getGameData().screenWidth > cellWidth * colNum) {
            x = cellWidth * colNum - GameData.getGameData().screenWidth;
        }
        if (y + GameData.getGameData().screenHeight > cellHeight * rowNum) {
            y = cellHeight * rowNum - GameData.getGameData().screenHeight;
        }
        if (image.getWidth() <= GameData.getGameData().screenWidth) {
            x = 0;
        }

        if (image.getHeight() <= GameData.getGameData().screenHeight) {
            y = 0;
        }
    }
//    public Map initMap(int index) {
//        Map map = new Map();
//        try {
//
//            InputStream is = getClass().getResourceAsStream("/data/map/map" + index + ".gat");
//            DataInputStream dis = new DataInputStream(is);
//            map.index = dis.readInt();
//            map.name = dis.readUTF();
//            String imageName = dis.readUTF();
//
//            map.musicName = dis.readUTF();
//            map.rowNum = dis.readByte();
//            System.out.println("row " + map.rowNum);
//            map.colNum = dis.readByte();
//            System.out.println("col " + map.colNum);
//            map.cellWidth = dis.readByte();
//            map.cellHeight = dis.readByte();
//            map.layerNum = dis.readByte();
//
//            map.data = new int[map.layerNum][map.rowNum][map.colNum];
//            for (int i = 0; i < map.layerNum; i++) {
//                for (int j = 0; j < map.rowNum; j++) {
//                    for (int k = 0; k < map.colNum; k++) {
//                        map.data[i][j][k] = dis.readInt();
//                    }
//                }
//            }
//            map.way = new int[map.rowNum][map.colNum];
//            for (int j = 0; j < map.rowNum; j++) {
//                for (int k = 0; k < map.colNum; k++) {
//                    map.way[j][k] = dis.readByte();
//                }
//            }
//
//            map.scriptType = new byte[map.rowNum][map.colNum];
//            for (int j = 0; j < map.rowNum; j++) {
//                for (int k = 0; k < map.colNum; k++) {
//                    map.scriptType[j][k] = dis.readByte();
//                }
//            }
//            int sum = dis.readInt();
//            map.script = new Script[sum];
//            for (int i = 0; i < sum; i++) {
//                map.script[i] = new Script();
//                map.script[i].type = dis.readByte();
//                map.script[i].row = dis.readInt();
//                map.script[i].col = dis.readInt();
//                map.script[i].command = new Command[dis.readInt()];
//                for (int j = 0; j < map.script[i].command.length; j++) {
//                    map.script[i].command[j] = new Command();
//                    map.script[i].command[j].type = dis.readByte();
//                    switch (map.script[i].command[j].type) {
//                        case Command.ENDIF:
//                        case Command.ENDWHILE:
//                        case Command.BREAK:
//                        case Command.CONTINUE:
//                        case Command.EXIT:
//                        case Command.GAMEOVER:
//                            continue;
//                        default:
//                            System.out.println("hava param");
//                            map.script[i].command[j].param = dis.readUTF();
//                            map.script[i].command[j].nextIndex = dis.readInt();
//                            break;
//                    }
//
//                }
//            }
//            map.setImage(Image.createImage("/image/tileset/" + imageName));
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (Error er) {
//            er.printStackTrace();
//        }
//        return map;
//    }
}
