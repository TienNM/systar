/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soyomaker.data.model;

import com.soyomaker.AppData;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Administrator
 */
public class VocationItemTableModel extends AbstractTableModel {

    private Vocation vocation;

    /**
     *
     * @param vocation
     */
    public VocationItemTableModel(Vocation vocation) {
        this.vocation = vocation;
    }
    private static final String COLUMN_NAME[] = {
        "可用", "物品名称"
    };
    private static final Class COLUMN_CLASS[] = {
        Boolean.class, String.class
    };

    public int getRowCount() {
        return AppData.getInstance().getCurProject().getDataManager().size(Model.ITEM);
    }

    @Override
    public String getColumnName(int c) {
        return COLUMN_NAME[c];
    }

    @Override
    public Class<?> getColumnClass(int c) {
        return COLUMN_CLASS[c];
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        if (col == 0) {
            return true;
        }
        return false;
    }

    @Override
    public void setValueAt(Object v, int r, int c) {
        Item attr = (Item) AppData.getInstance().getCurProject().getDataManager().getModels(Model.ITEM)[r];
        if (attr != null) {
            switch (c) {
                case 0:
                    if (!vocation.items.contains(attr)) {
                        vocation.items.add(attr);
                    } else {
                        vocation.items.remove(attr);
                    }
                    break;
                case 1:
                    attr.name = v.toString();
                    break;
            }
        }
        this.fireTableCellUpdated(r, c);
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Item attr = (Item) AppData.getInstance().getCurProject().getDataManager().getModels(Model.ITEM)[rowIndex];
        if (attr != null) {
            switch (columnIndex) {
                case 0:
                    return vocation.items.contains(attr);
                case 1:
                    return attr.name;
            }
        }
        return null;
    }

    public int getColumnCount() {
        return COLUMN_NAME.length;
    }
}
