package model;

import java.awt.Image;
import model.*;

public class Map extends BasicMap{

    private int index = 0;
    private int[][][] data = null;// ��ͼ�������
    private int[][] way = null;// ͨ�ж�����
//    private int row = 0;// ��ͼ����
//    private int col = 0;// ��ͼ����
//    private int cellWidth = 0;// ��Ԫ����
//    private int cellHeight = 0;// ��Ԫ��߶�
    private String name = "";// ��ͼ����
    private String imageName = "";// ԴͼƬ����
    private String musicName = "";
    private Image image = null;// ԴͼƬ
    private int imageWidth = 0;// ͼƬ���
    private int imageRow = 0;// ͼƬ����
    private int imageCol = 0;// ͼƬ����
    private int imageHeight = 0;// ͼƬ�߶�
    private int layerNum = 1;// ��ͼͼ����
    private Script[][] scriptList;
    private byte[][] scriptType;
    private CommandSet[][] commandSet;

//    /**
//     * @return ���������ش˶����һ��������
//     * @throws CloneNotSupportedException
//     */
//    @Override
//    public Map clone() {
//        //ֱ�ӵ��ø����clone()����,���ؿ�¡����
//        try {
//            return (Map)super.clone();
//        } catch (CloneNotSupportedException e) {
//            return null;
//        }
//
//    }

    public CommandSet[][] getCommandSet() {
        return commandSet;
    }

    public void setCommandSet(CommandSet[][] commandSet) {
        this.commandSet = commandSet;
    }

    public void setCommandSet(CommandSet commandSet) {
        if (commandSet.row < this.getRow() && commandSet.col < this.getCol()) {
            this.commandSet[commandSet.row][commandSet.col] = commandSet;
        }
    }
    // ������

    public Map(String mapName, String imageName, int row, int col,
        int cellWidth, int cellHeight, int layerNum) {
        this.name = mapName;
        this.imageName = imageName;
        setRow(row);
        setCol(col);
//        this.row = row;
//        this.col = col;
        setCellWidth(cellWidth);
        setCellHeight(cellHeight);
//        this.cellWidth = cellWidth;
//        this.cellHeight = cellHeight;
        this.layerNum = layerNum;
        data = new int[layerNum][row][col];
        way = new int[row][col];
        scriptList = new Script[row][col];
        scriptType = new byte[row][col];
        commandSet = new CommandSet[row][col];
    }

    public byte[][] getScriptType() {
        return scriptType;
    }

    public void setScriptType(byte[][] scriptType) {
        this.scriptType = scriptType;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public Script[][] getScriptList() {
        return scriptList;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setImage(String imageName) {
        this.imageName = imageName;
    }

//    public void setCol(int col) {
//        this.col = col;
//    }
//
//    public void setRow(int row) {
//        this.row = row;
//    }
//
//    public void setCellWidth(int cellWidth) {
//        this.cellWidth = cellWidth;
//    }
//
//    public void setCellHeight(int cellHeight) {
//        this.cellHeight = cellHeight;
//    }
    public void setLayerNum(int layerNum) {
        this.layerNum = layerNum;
    }

//    public int getCellHeight() {
//        return cellHeight;
//    }
//
//    public int getCellWidth() {
//        return cellWidth;
//    }
//
//    public int getCol() {
//        return col;
//    }
    public Image getImage() {
        return image;
    }

    public int getImageCol() {
        return imageCol;
    }

    public int getImageHeight() {
        return imageHeight;
    }

    public String getImageName() {
        return imageName;
    }

    public int getImageRow() {
        return imageRow;
    }

    public int getImageWidth() {
        return imageWidth;
    }

    public int getLayerNum() {
        return layerNum;
    }

    public int[][][] getMap() {
        return data;
    }

    public String getName() {
        return name;
    }

    public void setName(String mapName) {
        this.name = mapName;
    }

//    public int getRow() {
//        return row;
//    }
    public int[][] getWay() {
        return way;
    }

    public void printData() {
        for (int i = 0; i < layerNum; i++) {
            for (int j = 0; j < this.getCol(); j++) {
                for (int k = 0; k < this.getRow(); k++) {
                    System.out.print(data[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println("\n\n\n");
        }
    }

    public void printWay() {
        for (int i = 0; i < this.getRow(); i++) {
            for (int j = 0; j < this.getCol(); j++) {
                System.out.print(way[i][j] + " ");
            }
            System.out.println("\n\n\n");
        }
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void setImageHeight(int imageHeight) {
        this.imageHeight = imageHeight;
        imageRow = imageHeight / this.getCellHeight();
    }

    public void setImageWidth(int imageWidth) {
        this.imageWidth = imageWidth;
        imageCol = imageWidth / this.getCellWidth();
    }

    public void setMap(int layerNum, int row, int col, int num) {
        if (row < this.getRow() && col < this.getCol()) {
            data[layerNum][row][col] = num;
        }
    }

    public void update(int[][][] ma, int[][] wa) {
        data = null;
        data = new int[ma.length][ma[0].length][ma[0][0].length];
        way = null;
        way = new int[ma[0].length][ma[0][0].length];
        data = ma;
        way = wa;
    }

    public void setWay(int row, int col, int num) {
        if (row < this.getRow() && col < this.getCol()) {
            way[row][col] = num;
        }
    }

    public void setScriptType(int row, int col, byte num) {
        if (row < this.getRow() && col < this.getCol()) {
            scriptType[row][col] = num;
        }
    }

    public void setScript(int row, int col, Script s) {
        if (row < this.getRow() && col < this.getCol()) {
            scriptList[row][col] = s;
        }
    }

    public void setWay(int[][] wa) {
        way = wa;
    }

    public void setScriptList(Script[][] sl) {
        scriptList = sl;
    }

    public void setImageCol(int imageCol) {
        this.imageCol = imageCol;
    }

    public void setImageRow(int imageRow) {
        this.imageRow = imageRow;
    }
}
