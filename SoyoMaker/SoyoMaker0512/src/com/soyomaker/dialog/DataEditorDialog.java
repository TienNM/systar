/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * NewDataEditorDialog.java
 *
 * Created on 2011-9-2, 21:44:37
 */
package com.soyomaker.dialog;

import com.soyomaker.data.ui.ConfigPanel;
import com.soyomaker.data.ui.EnemyPanel;
import com.soyomaker.data.ui.EnemyTroopPanel;
import com.soyomaker.data.ui.ItemPanel;
import com.soyomaker.data.ui.PlayerPanel;
import com.soyomaker.data.ui.SkillPanel;
import com.soyomaker.data.ui.StatusPanel;
import com.soyomaker.data.ui.VocationPanel;

/**
 *
 * @author Administrator
 */
public class DataEditorDialog extends javax.swing.JDialog {

    /** Creates new form NewDataEditorDialog
     * @param parent
     * @param modal
     */
    public DataEditorDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        init();
    }

    /**
     *
     */
    public void refresh() {
        configPanel.refresh();
        skillPanel.refresh();
        enemyPanel.refresh();
        enemyTroopPanel.refresh();
        itemPanel.refresh();
        playerPanel.refresh();
        statusPanel.refresh();
        vocationPanel.refresh();
    }
    private ConfigPanel configPanel;
    private SkillPanel skillPanel;
    private EnemyPanel enemyPanel;
    private EnemyTroopPanel enemyTroopPanel;
    private ItemPanel itemPanel;
    private PlayerPanel playerPanel;
    private StatusPanel statusPanel;
    private VocationPanel vocationPanel;

    private void init() {
        setLocationRelativeTo(null);
        configPanel = new ConfigPanel();
        skillPanel = new SkillPanel();
        enemyPanel = new EnemyPanel();
        enemyTroopPanel = new EnemyTroopPanel();
        itemPanel = new ItemPanel();
        playerPanel = new PlayerPanel();
        statusPanel = new StatusPanel();
        vocationPanel = new VocationPanel();
        dataTabbedPane.add("角色", playerPanel);
        dataTabbedPane.add("职业", vocationPanel);
        dataTabbedPane.add("技能", skillPanel);
        dataTabbedPane.add("物品", itemPanel);
        dataTabbedPane.add("敌人", enemyPanel);
        dataTabbedPane.add("队伍", enemyTroopPanel);
        dataTabbedPane.add("Buff", statusPanel);
        dataTabbedPane.add("配置", configPanel);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dataTabbedPane = new javax.swing.JTabbedPane();
        closeButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();
        applyButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("数据编辑器");

        dataTabbedPane.setName("dataTabbedPane"); // NOI18N

        closeButton.setText("关闭");
        closeButton.setName("closeButton"); // NOI18N
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        okButton.setText("确定");
        okButton.setName("okButton"); // NOI18N
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        applyButton.setText("应用");
        applyButton.setName("applyButton"); // NOI18N
        applyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dataTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 854, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(538, Short.MAX_VALUE)
                .addComponent(okButton)
                .addGap(18, 18, 18)
                .addComponent(applyButton)
                .addGap(18, 18, 18)
                .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {applyButton, closeButton, okButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(dataTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(closeButton)
                    .addComponent(applyButton)
                    .addComponent(okButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_closeButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        // TODO add your handling code here:
        save();
        dispose();
    }//GEN-LAST:event_okButtonActionPerformed

    private void applyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyButtonActionPerformed
        // TODO add your handling code here:
        save();
    }//GEN-LAST:event_applyButtonActionPerformed
    private void save() {
        configPanel.save();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton applyButton;
    private javax.swing.JButton closeButton;
    private javax.swing.JTabbedPane dataTabbedPane;
    private javax.swing.JButton okButton;
    // End of variables declaration//GEN-END:variables
}
