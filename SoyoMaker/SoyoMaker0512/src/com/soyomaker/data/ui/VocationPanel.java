/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * VocationPanel.java
 *
 * Created on 2011-9-3, 23:40:15
 */
package com.soyomaker.data.ui;

import com.soyomaker.AppData;
import com.soyomaker.data.listener.DataChangeListener;
import com.soyomaker.data.listener.DataChangedEvent;
import com.soyomaker.data.model.Config;
import com.soyomaker.data.model.Enemy;
import com.soyomaker.data.model.EnemyTroop;
import com.soyomaker.data.model.Item;
import com.soyomaker.data.model.Model;
import com.soyomaker.data.model.Player;
import com.soyomaker.data.model.Skill;
import com.soyomaker.data.model.Buff;
import com.soyomaker.data.model.Vocation;
import com.soyomaker.data.model.VocationTableModel;

/**
 *
 * @author Administrator
 */
public class VocationPanel extends javax.swing.JPanel implements DataChangeListener {

    /** Creates new form VocationPanel */
    public VocationPanel() {
        initComponents();
        AppData.getInstance().getCurProject().getDataManager().addDataChangeListener(this);
    }
    private VocationTableModel vtm = new VocationTableModel();

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
        addVocationButton = new javax.swing.JButton();
        editVocationButton = new javax.swing.JButton();
        removeVocationButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        vocationTable = new javax.swing.JTable();

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.setName("jToolBar1"); // NOI18N

        addVocationButton.setText("添加职业");
        addVocationButton.setFocusable(false);
        addVocationButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addVocationButton.setName("addVocationButton"); // NOI18N
        addVocationButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        addVocationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addVocationButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(addVocationButton);

        editVocationButton.setText("编辑职业");
        editVocationButton.setFocusable(false);
        editVocationButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        editVocationButton.setName("editVocationButton"); // NOI18N
        editVocationButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        editVocationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editVocationButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(editVocationButton);

        removeVocationButton.setText("删除职业");
        removeVocationButton.setFocusable(false);
        removeVocationButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        removeVocationButton.setName("removeVocationButton"); // NOI18N
        removeVocationButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        removeVocationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeVocationButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(removeVocationButton);

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        vocationTable.setModel(vtm);
        vocationTable.setName("vocationTable"); // NOI18N
        vocationTable.setRowHeight(20);
        jScrollPane1.setViewportView(vocationTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 829, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 829, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addVocationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addVocationButtonActionPerformed
        // TODO add your handling code here:
        Vocation vocation = new Vocation();
        vocation.setIndex(AppData.getInstance().getCurProject().getDataManager().allocateIndex(Model.VOCATION));
        AppData.getInstance().getCurProject().getDataManager().saveModel(Model.VOCATION, vocation);
        EditVocationDialog eid = new EditVocationDialog(this, true, vocation);
        eid.setVisible(true);
        vocationTable.updateUI();
    }//GEN-LAST:event_addVocationButtonActionPerformed

    private void editVocationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editVocationButtonActionPerformed
        // TODO add your handling code here:
        int id = vocationTable.getSelectedRow();
        if (id < 0 || id >= AppData.getInstance().getCurProject().getDataManager().size(Model.VOCATION)) {
            return;
        }
        Vocation vocation = (Vocation) AppData.getInstance().getCurProject().getDataManager().getModels(Model.VOCATION)[id];
        EditVocationDialog eid = new EditVocationDialog(this, true, vocation);
        eid.setVisible(true);
        vocationTable.updateUI();
    }//GEN-LAST:event_editVocationButtonActionPerformed

    private void removeVocationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeVocationButtonActionPerformed
        // TODO add your handling code here:
        int id = vocationTable.getSelectedRow();
        if (id < 0 || id >= AppData.getInstance().getCurProject().getDataManager().size(Model.VOCATION)) {
            return;
        }
        AppData.getInstance().getCurProject().getDataManager().removeModel(Model.VOCATION, AppData.getInstance().getCurProject().getDataManager().getModels(Model.VOCATION)[id].getIndex());
    }//GEN-LAST:event_removeVocationButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addVocationButton;
    private javax.swing.JButton editVocationButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton removeVocationButton;
    private javax.swing.JTable vocationTable;
    // End of variables declaration//GEN-END:variables

    public void configChanged(DataChangedEvent sce, Config config) {
    }

    public void playerAdded(DataChangedEvent sce, Player player) {
    }

    public void playerRemoved(DataChangedEvent sce, int id) {
    }

    public void vocationAdded(DataChangedEvent sce, Vocation vocation) {
        vocationTable.updateUI();
    }

    public void vocationRemoved(DataChangedEvent sce, int id) {
        vocationTable.updateUI();
    }

    public void statusAdded(DataChangedEvent sce, Buff status) {
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

    public void itemAdded(DataChangedEvent sce, Item item) {
    }

    public void itemRemoved(DataChangedEvent sce, int id) {
    }
}
