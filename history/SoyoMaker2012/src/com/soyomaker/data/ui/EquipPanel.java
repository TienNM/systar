/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * EquipPanel.java
 *
 * Created on 2011-9-3, 23:40:47
 */
package com.soyomaker.data.ui;

import com.soyomaker.AppData;
import com.soyomaker.data.DataManager;
import com.soyomaker.data.listener.DataChangeListener;
import com.soyomaker.data.listener.DataChangedEvent;
import com.soyomaker.data.model.Config;
import com.soyomaker.data.model.Enemy;
import com.soyomaker.data.model.EnemyTroop;
import com.soyomaker.data.model.Equip;
import com.soyomaker.data.model.EquipTableModel;
import com.soyomaker.data.model.Item;
import com.soyomaker.data.model.Model;
import com.soyomaker.data.model.Player;
import com.soyomaker.data.model.Skill;
import com.soyomaker.data.model.Status;
import com.soyomaker.data.model.Vocation;
import com.soyomaker.widget.JTabelComboBoxRender;
import com.soyomaker.widget.JTableComboBoxEditor;
import javax.swing.ImageIcon;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Administrator
 */
public class EquipPanel extends javax.swing.JPanel implements DataChangeListener {

    /** Creates new form EquipPanel */
    public EquipPanel() {
        initComponents();
        AppData.getInstance().getCurProject().getDataManager().addDataChangeListener(this);
        TableColumnModel tcm = equipTable.getColumnModel();
//        ImageIcon[] itemIcons = DataManager.listEquipIconName();
//        TableColumn iconC = tcm.getColumn(3);
//        JTabelComboBoxRender strI = new JTabelComboBoxRender(itemIcons);
//        JTableComboBoxEditor steI = new JTableComboBoxEditor(itemIcons);
//        iconC.setCellRenderer(strI);
//        iconC.setCellEditor(steI);

        TableColumn targetC = tcm.getColumn(5);
        JTabelComboBoxRender strT = new JTabelComboBoxRender(Equip.kinds);
        JTableComboBoxEditor steT = new JTableComboBoxEditor(Equip.kinds);
        targetC.setCellRenderer(strT);
        targetC.setCellEditor(steT);
    }
    private EquipTableModel etm = new EquipTableModel();

    /**
     *
     */
    public void refresh() {
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        addEquipButton = new javax.swing.JButton();
        editEquipButton = new javax.swing.JButton();
        removeEquipButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        equipTable = new javax.swing.JTable();

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.setName("jToolBar1"); // NOI18N

        addEquipButton.setText("添加装备");
        addEquipButton.setFocusable(false);
        addEquipButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addEquipButton.setName("addEquipButton"); // NOI18N
        addEquipButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        addEquipButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEquipButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(addEquipButton);

        editEquipButton.setText("编辑装备");
        editEquipButton.setFocusable(false);
        editEquipButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        editEquipButton.setName("editEquipButton"); // NOI18N
        editEquipButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        editEquipButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editEquipButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(editEquipButton);

        removeEquipButton.setText("删除装备");
        removeEquipButton.setFocusable(false);
        removeEquipButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        removeEquipButton.setName("removeEquipButton"); // NOI18N
        removeEquipButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        removeEquipButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeEquipButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(removeEquipButton);

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        equipTable.setModel(etm);
        equipTable.setName("equipTable"); // NOI18N
        jScrollPane1.setViewportView(equipTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 791, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 791, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addEquipButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEquipButtonActionPerformed
        // TODO add your handling code here:
        Equip equip = new Equip();
        equip.addDefault();
        equip.setIndex(AppData.getInstance().getCurProject().getDataManager().allocateIndex(Model.EQUIP));
        AppData.getInstance().getCurProject().getDataManager().saveModel(Model.EQUIP, equip);
        EditEquipDialog eid = new EditEquipDialog(this, true, equip);
        eid.setVisible(true);
    }//GEN-LAST:event_addEquipButtonActionPerformed

    private void editEquipButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editEquipButtonActionPerformed
        // TODO add your handling code here:
        int id = equipTable.getSelectedRow();
        if (id < 0 || id >= AppData.getInstance().getCurProject().getDataManager().size(Model.EQUIP)) {
            return;
        }
        Equip equip = (Equip) AppData.getInstance().getCurProject().getDataManager().getModels(Model.EQUIP)[id];
        EditEquipDialog eid = new EditEquipDialog(this, true, equip);
        eid.setVisible(true);
    }//GEN-LAST:event_editEquipButtonActionPerformed

    private void removeEquipButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeEquipButtonActionPerformed
        // TODO add your handling code here:
        int id = equipTable.getSelectedRow();
        if (id < 0 || id >= AppData.getInstance().getCurProject().getDataManager().size(Model.EQUIP)) {
            return;
        }
        AppData.getInstance().getCurProject().getDataManager().removeModel(Model.EQUIP, AppData.getInstance().getCurProject().getDataManager().getModels(Model.EQUIP)[id].getIndex());
    }//GEN-LAST:event_removeEquipButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addEquipButton;
    private javax.swing.JButton editEquipButton;
    private javax.swing.JTable equipTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton removeEquipButton;
    // End of variables declaration//GEN-END:variables

    public void configChanged(DataChangedEvent sce, Config config) {
    }

    public void playerAdded(DataChangedEvent sce, Player player) {
    }

    public void playerRemoved(DataChangedEvent sce, int id) {
    }

    public void vocationAdded(DataChangedEvent sce, Vocation vocation) {
    }

    public void vocationRemoved(DataChangedEvent sce, int id) {
    }

    public void statusAdded(DataChangedEvent sce, Status status) {
    }

    public void statusRemoved(DataChangedEvent sce, int id) {
    }

    public void skillAdded(DataChangedEvent sce, Skill skill) {
    }

    public void skillRemoved(DataChangedEvent sce, int id) {
    }

    public void enemyAdded(DataChangedEvent sce, Enemy enemy) {
    }

    public void enemyRemoved(DataChangedEvent sce, int id) {
    }

    public void enemyTroopAdded(DataChangedEvent sce, EnemyTroop enemytroop) {
    }

    public void enemyTroopRemoved(DataChangedEvent sce, int id) {
    }

    public void equipAdded(DataChangedEvent sce, Equip equip) {
        equipTable.updateUI();
    }

    public void equipRemoved(DataChangedEvent sce, int id) {
        equipTable.updateUI();
    }

    public void itemAdded(DataChangedEvent sce, Item item) {
    }

    public void itemRemoved(DataChangedEvent sce, int id) {
    }
}
