/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ShowAniDialog.java
 *
 * Created on 2011-6-13, 1:28:31
 */
package com.soyomaker.dialog.event.gameperformance;

import com.soyomaker.AppData;
import com.soyomaker.data.model.Enemy;
import com.soyomaker.data.model.Model;
import com.soyomaker.data.model.Player;
import com.soyomaker.dialog.AbCommandDialog;
import com.soyomaker.dialog.ScriptDialog;
import com.soyomaker.model.animation.Animation;
import com.soyomaker.model.map.Command;
import com.soyomaker.model.map.Npc;
import java.util.Iterator;

/**
 *
 * @author Administrator
 */
public class ShowAnimationDialog extends AbCommandDialog {

    /** Creates new form ShowAniDialog
     * @param parent
     * @param modal  
     */
    public ShowAnimationDialog(ScriptDialog parent, boolean modal) {
        super(parent, modal);
        sd = parent;
        initComponents();
        setLocationRelativeTo(null);
        java.util.Iterator it = AppData.getInstance().getCurProject().getAnimations().entrySet().iterator();
        while (it.hasNext()) {
            java.util.Map.Entry entry = (java.util.Map.Entry) it.next();
            aniNameComboBox.addItem(((Animation) entry.getValue()));
        }
        Enemy[] enemys = (Enemy[]) AppData.getInstance().getCurProject().getDataManager().getModels(Model.ENEMY);
        for (int i = 0; i < enemys.length; i++) {
            enemyComboBox.addItem(enemys[i]);
        }
        Player[] players = (Player[]) AppData.getInstance().getCurProject().getDataManager().getModels(Model.PLAYER);
        for (int i = 0; i < players.length; i++) {
            playerComboBox.addItem(players[i]);
        }
        Iterator it2 = AppData.getInstance().getCurProject().getNpcs().keySet().iterator();
        while (it2.hasNext()) {
            Integer key = (Integer) it2.next();
            Npc npc = AppData.getInstance().getCurProject().getNpcs().get(key);
            if (npc != null) {
                npcComboBox.addItem(npc);
            }
        }

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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        aniNameComboBox = new javax.swing.JComboBox();
        okButton = new javax.swing.JButton();
        cancleButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        timeTextField = new javax.swing.JTextField();
        playCheckBox = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        enemyRadioButton = new javax.swing.JRadioButton();
        playerRadioButton = new javax.swing.JRadioButton();
        npcRadioButton = new javax.swing.JRadioButton();
        enemyComboBox = new javax.swing.JComboBox();
        playerComboBox = new javax.swing.JComboBox();
        npcComboBox = new javax.swing.JComboBox();
        xyRadioButton = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        xTextField = new javax.swing.JTextField();
        yTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance().getContext().getResourceMap(ShowAnimationDialog.class);
        setTitle(resourceMap.getString("title")); // NOI18N
        setResizable(false);

        jLabel1.setText("动画名称");
        jLabel1.setName("jLabel1"); // NOI18N

        aniNameComboBox.setName("aniNameComboBox"); // NOI18N

        okButton.setText("确定");
        okButton.setName("okButton"); // NOI18N
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        cancleButton.setText("取消");
        cancleButton.setName("cancleButton"); // NOI18N
        cancleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancleButtonActionPerformed(evt);
            }
        });

        jLabel4.setText("播放次数");
        jLabel4.setName("jLabel4"); // NOI18N

        timeTextField.setText("1");
        timeTextField.setName("timeTextField"); // NOI18N

        playCheckBox.setText("持续播放");
        playCheckBox.setName("playCheckBox"); // NOI18N
        playCheckBox.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                playCheckBoxStateChanged(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("指定位置"));
        jPanel2.setName("jPanel2"); // NOI18N

        buttonGroup1.add(enemyRadioButton);
        enemyRadioButton.setSelected(true);
        enemyRadioButton.setText("敌人");
        enemyRadioButton.setName("enemyRadioButton"); // NOI18N
        enemyRadioButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                enemyRadioButtonStateChanged(evt);
            }
        });

        buttonGroup1.add(playerRadioButton);
        playerRadioButton.setText("角色");
        playerRadioButton.setName("playerRadioButton"); // NOI18N
        playerRadioButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                playerRadioButtonStateChanged(evt);
            }
        });

        buttonGroup1.add(npcRadioButton);
        npcRadioButton.setText("NPC");
        npcRadioButton.setName("npcRadioButton"); // NOI18N
        npcRadioButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                npcRadioButtonStateChanged(evt);
            }
        });

        enemyComboBox.setName("enemyComboBox"); // NOI18N

        playerComboBox.setEnabled(false);
        playerComboBox.setName("playerComboBox"); // NOI18N

        npcComboBox.setEnabled(false);
        npcComboBox.setName("npcComboBox"); // NOI18N

        buttonGroup1.add(xyRadioButton);
        xyRadioButton.setText("坐标");
        xyRadioButton.setName("xyRadioButton"); // NOI18N
        xyRadioButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                xyRadioButtonStateChanged(evt);
            }
        });

        jLabel2.setText("X");
        jLabel2.setName("jLabel2"); // NOI18N

        xTextField.setText("0");
        xTextField.setEnabled(false);
        xTextField.setName("xTextField"); // NOI18N

        yTextField.setText("0");
        yTextField.setEnabled(false);
        yTextField.setName("yTextField"); // NOI18N

        jLabel3.setText("Y");
        jLabel3.setName("jLabel3"); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(enemyRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(enemyComboBox, 0, 159, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(playerRadioButton)
                            .addComponent(npcRadioButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(npcComboBox, 0, 159, Short.MAX_VALUE)
                            .addComponent(playerComboBox, 0, 159, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(xyRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(yTextField)
                            .addComponent(xTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(enemyRadioButton)
                    .addComponent(enemyComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(playerRadioButton)
                    .addComponent(playerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(npcRadioButton)
                    .addComponent(npcComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xyRadioButton)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(xTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(yTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(aniNameComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(playCheckBox)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(timeTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(okButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                        .addComponent(cancleButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(aniNameComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(timeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(playCheckBox)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okButton)
                    .addComponent(cancleButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        // TODO add your handling code here:
        if (aniNameComboBox.getSelectedIndex() != -1) {
            mCommand.addParameter("" + ((Animation) aniNameComboBox.getSelectedItem()).getIndex());
            if (enemyRadioButton.isSelected()) {
                mCommand.setScriptId(Command.SHOW_ANIMATION_BY_TARGET);
                mCommand.addParameter("" + 1);
                mCommand.addParameter("" + ((Enemy) enemyComboBox.getSelectedItem()).getIndex());
//                    sd.insertScriptData(sd.npcPane.eventTable.getSelectedRow(),
//                            "globalData.proxy:playAnimationInFight(" + ((Animation) aniNameComboBox.getSelectedItem()).getIndex() + ",1," + ((Enemy) enemyComboBox.getSelectedItem()).getIndex() + ",-1)");
            } else if (playerRadioButton.isSelected()) {
                mCommand.setScriptId(Command.SHOW_ANIMATION_BY_TARGET);
                mCommand.addParameter("" + 0);
                mCommand.addParameter("" + ((Player) playerComboBox.getSelectedItem()).getIndex());
//                    sd.insertScriptData(sd.npcPane.eventTable.getSelectedRow(),
//                            "globalData.proxy:playAnimationInFight(" + ((Animation) aniNameComboBox.getSelectedItem()).getIndex() + ",0," + ((Player) playerComboBox.getSelectedItem()).getIndex() + ",-1)");
            } else if (npcRadioButton.isSelected()) {
                mCommand.setScriptId(Command.SHOW_ANIMATION_BY_TARGET);
                mCommand.addParameter("" + 2);
                mCommand.addParameter("" + ((Npc) npcComboBox.getSelectedItem()).getIndex());
//                    sd.insertScriptData(sd.npcPane.eventTable.getSelectedRow(),
//                            "globalData.proxy:playAnimationInFight(" + ((Animation) aniNameComboBox.getSelectedItem()).getIndex() + ",2," + ((Npc) npcComboBox.getSelectedItem()).getIndex() + ",-1)");
            } else {
                mCommand.setScriptId(Command.SHOW_ANIMATION_BY_LOCATION);
                mCommand.addParameter(xTextField.getText());
                mCommand.addParameter(yTextField.getText());
//                    sd.insertScriptData(sd.npcPane.eventTable.getSelectedRow(),
//                            "globalData.proxy:playAnimation(" + ((Animation) aniNameComboBox.getSelectedItem()).getIndex() + "," + xTextField.getText() + "," + yTextField.getText() + ",-1)");
            }
            if (playCheckBox.isSelected()) {
                mCommand.addParameter("" + -1);
            } else {
                mCommand.addParameter(timeTextField.getText());
            }
            System.out.println(mCommand);
            dispose();
        }
    }//GEN-LAST:event_okButtonActionPerformed

    private void cancleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancleButtonActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_cancleButtonActionPerformed

    private void playCheckBoxStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_playCheckBoxStateChanged
        // TODO add your handling code here:
        if (playCheckBox.isSelected()) {
            timeTextField.setEnabled(false);
        } else {
            timeTextField.setEnabled(true);
        }
    }//GEN-LAST:event_playCheckBoxStateChanged

    private void enemyRadioButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_enemyRadioButtonStateChanged
        // TODO add your handling code here:
        enemyComboBox.setEnabled(enemyRadioButton.isSelected());
    }//GEN-LAST:event_enemyRadioButtonStateChanged

    private void playerRadioButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_playerRadioButtonStateChanged
        // TODO add your handling code here:
        playerComboBox.setEnabled(playerRadioButton.isSelected());
    }//GEN-LAST:event_playerRadioButtonStateChanged

    private void npcRadioButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_npcRadioButtonStateChanged
        // TODO add your handling code here:
        npcComboBox.setEnabled(npcRadioButton.isSelected());
    }//GEN-LAST:event_npcRadioButtonStateChanged

    private void xyRadioButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_xyRadioButtonStateChanged
        // TODO add your handling code here:
        xTextField.setEnabled(xyRadioButton.isSelected());
        yTextField.setEnabled(xyRadioButton.isSelected());
    }//GEN-LAST:event_xyRadioButtonStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox aniNameComboBox;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cancleButton;
    private javax.swing.JComboBox enemyComboBox;
    private javax.swing.JRadioButton enemyRadioButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JComboBox npcComboBox;
    private javax.swing.JRadioButton npcRadioButton;
    private javax.swing.JButton okButton;
    private javax.swing.JCheckBox playCheckBox;
    private javax.swing.JComboBox playerComboBox;
    private javax.swing.JRadioButton playerRadioButton;
    private javax.swing.JTextField timeTextField;
    private javax.swing.JTextField xTextField;
    private javax.swing.JRadioButton xyRadioButton;
    private javax.swing.JTextField yTextField;
    // End of variables declaration//GEN-END:variables
}
