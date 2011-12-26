/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * EnemyTroopDialog.java
 *
 * Created on 2011-5-14, 19:15:18
 */
package com.soyomaker.dialog.event.gameperformance;

import com.soyomaker.dialog.ScriptDialog;

/**
 *
 * @author Administrator
 */
public class BattleDialog extends javax.swing.JDialog {

    /** Creates new form EnemyTroopDialog
     * @param parent 
     * @param modal 
     */
    public BattleDialog(ScriptDialog parent, boolean modal) {
        super(parent, modal);
        sd = parent;
        initComponents();
        setLocationRelativeTo(null);
    }
    private ScriptDialog sd;

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        enemyComboBox = new javax.swing.JComboBox();
        cancleButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();
        deathCheckBox = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance().getContext().getResourceMap(BattleDialog.class);
        setTitle(resourceMap.getString("title")); // NOI18N
        setResizable(false);

        jLabel1.setText("敌人队伍");
        jLabel1.setName("jLabel1"); // NOI18N

        enemyComboBox.setName("enemyComboBox"); // NOI18N

        cancleButton.setText("取消");
        cancleButton.setName("cancleButton"); // NOI18N
        cancleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancleButtonActionPerformed(evt);
            }
        });

        okButton.setText("确定");
        okButton.setName("okButton"); // NOI18N
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        deathCheckBox.setText("允许死亡");
        deathCheckBox.setName("deathCheckBox"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(enemyComboBox, 0, 197, Short.MAX_VALUE))
                    .addComponent(deathCheckBox)
                    .addComponent(cancleButton, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(okButton))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(enemyComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(deathCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                        .addComponent(okButton))
                    .addComponent(cancleButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        // TODO add your handling code here:
        sd.insertScriptData(sd.npcPane.eventTable.getSelectedRow(),
            "enterBattle(" + enemyComboBox.getSelectedIndex() + "," + !deathCheckBox.isSelected() + ");");
        this.dispose();
    }//GEN-LAST:event_okButtonActionPerformed

    private void cancleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancleButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_cancleButtonActionPerformed

    /**
     * 
     * @param args
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                BattleDialog dialog = new BattleDialog(null, true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancleButton;
    private javax.swing.JCheckBox deathCheckBox;
    private javax.swing.JComboBox enemyComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton okButton;
    // End of variables declaration//GEN-END:variables
}