/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PlayerPanel.java
 *
 * Created on 2011-9-3, 23:39:44
 */
package com.soyomaker.data.ui;

import com.soyomaker.AppData;
import com.soyomaker.data.model.PlayerTableModel;
import com.soyomaker.data.listener.DataChangeListener;
import com.soyomaker.data.listener.DataChangedEvent;
import com.soyomaker.data.model.Config;
import com.soyomaker.data.model.Enemy;
import com.soyomaker.data.model.EnemyTroop;
import com.soyomaker.data.model.Equip;
import com.soyomaker.data.model.Item;
import com.soyomaker.data.model.Model;
import com.soyomaker.data.model.Player;
import com.soyomaker.data.model.Skill;
import com.soyomaker.data.model.Status;
import com.soyomaker.data.model.Vocation;

/**
 *
 * @author Administrator
 */
public class PlayerPanel extends javax.swing.JPanel implements DataChangeListener {

    /** Creates new form PlayerPanel */
    public PlayerPanel() {
        initComponents();
        AppData.getInstance().getCurProject().getDataManager().addDataChangeListener(this);
    }
    private PlayerTableModel ptm = new PlayerTableModel();

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
        addPlayerButton = new javax.swing.JButton();
        editPlayerButton = new javax.swing.JButton();
        removePlayerButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        playerTable = new javax.swing.JTable();

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.setName("jToolBar1"); // NOI18N

        addPlayerButton.setText("添加角色");
        addPlayerButton.setFocusable(false);
        addPlayerButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addPlayerButton.setName("addPlayerButton"); // NOI18N
        addPlayerButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        addPlayerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPlayerButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(addPlayerButton);

        editPlayerButton.setText("编辑角色");
        editPlayerButton.setFocusable(false);
        editPlayerButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        editPlayerButton.setName("editPlayerButton"); // NOI18N
        editPlayerButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        editPlayerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editPlayerButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(editPlayerButton);

        removePlayerButton.setText("删除角色");
        removePlayerButton.setFocusable(false);
        removePlayerButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        removePlayerButton.setName("removePlayerButton"); // NOI18N
        removePlayerButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        removePlayerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removePlayerButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(removePlayerButton);

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        playerTable.setModel(ptm);
        playerTable.setName("playerTable"); // NOI18N
        jScrollPane1.setViewportView(playerTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addPlayerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPlayerButtonActionPerformed
        // TODO add your handling code here:
        Player player = new Player();
        player.setIndex(AppData.getInstance().getCurProject().getDataManager().allocateIndex(Model.PLAYER));
        AppData.getInstance().getCurProject().getDataManager().saveModel(Model.PLAYER, player);
        EditPlayerDialog eid = new EditPlayerDialog(this, true, player);
        eid.setVisible(true);
    }//GEN-LAST:event_addPlayerButtonActionPerformed

    private void editPlayerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editPlayerButtonActionPerformed
        // TODO add your handling code here:
        int id = playerTable.getSelectedRow();
        if (id < 0 || id >= AppData.getInstance().getCurProject().getDataManager().size(Model.PLAYER)) {
            return;
        }
        Player player = (Player) AppData.getInstance().getCurProject().getDataManager().getModels(Model.PLAYER)[id];
//        //测试
//        for (int i = 0; i < player.maxLev; i++) {
//            player.maxHps.add(i, i);
//        }
//        for (int i = 0; i < player.maxLev; i++) {
//            player.maxSps.add(i, i);
//        }

        EditPlayerDialog eid = new EditPlayerDialog(this, true, player);
        eid.setVisible(true);
    }//GEN-LAST:event_editPlayerButtonActionPerformed

    private void removePlayerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removePlayerButtonActionPerformed
        // TODO add your handling code here:
        int id = playerTable.getSelectedRow();
        if (id < 0 || id >= AppData.getInstance().getCurProject().getDataManager().size(Model.PLAYER)) {
            return;
        }
        AppData.getInstance().getCurProject().getDataManager().removeModel(Model.PLAYER, AppData.getInstance().getCurProject().getDataManager().getModels(Model.PLAYER)[id].getIndex());
    }//GEN-LAST:event_removePlayerButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addPlayerButton;
    private javax.swing.JButton editPlayerButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable playerTable;
    private javax.swing.JButton removePlayerButton;
    // End of variables declaration//GEN-END:variables

    public void configChanged(DataChangedEvent sce, Config config) {
    }

    public void playerAdded(DataChangedEvent sce, Player player) {
        playerTable.updateUI();
    }

    public void playerRemoved(DataChangedEvent sce, int id) {
        playerTable.updateUI();
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
    }

    public void equipRemoved(DataChangedEvent sce, int id) {
    }

    public void itemAdded(DataChangedEvent sce, Item item) {
    }

    public void itemRemoved(DataChangedEvent sce, int id) {
    }
}
