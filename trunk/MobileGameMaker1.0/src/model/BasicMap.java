/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;
import java.awt.Image;
/**
 *
 * @author Administrator
 */
public class BasicMap {
//    private int[][] data;
    private int row = 0;// ��ͼ����
    private int col = 0;// ��ͼ����
    private int cellWidth = 0;// ��Ԫ����
    private int cellHeight = 0;// ��Ԫ��߶�

    public int getCellHeight() {
        return cellHeight;
    }

    public void setCellHeight(int cellHeight) {
        this.cellHeight = cellHeight;
    }

    public int getCellWidth() {
        return cellWidth;
    }

    public void setCellWidth(int cellWidth) {
        this.cellWidth = cellWidth;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
//
//    public int[][] getData() {
//        return data;
//    }
//
//    public void setData(int[][] data) {
//        this.data = data;
//    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }
}
