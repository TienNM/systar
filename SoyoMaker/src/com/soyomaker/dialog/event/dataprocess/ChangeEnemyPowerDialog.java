/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ChangeEnemySpDialog.java
 *
 * Created on 2011-6-13, 17:00:59
 */
package com.soyomaker.dialog.event.dataprocess;

import com.soyomaker.AppData;
import com.soyomaker.data.model.Enemy;
import com.soyomaker.data.model.Model;
import com.soyomaker.dialog.AbCommandDialog;
import com.soyomaker.dialog.ScriptDialog;
import com.soyomaker.model.map.Command;
import com.soyomaker.model.map.CommandFactory;

/**
 *
 * @author Administrator
 */
public class ChangeEnemyPowerDialog extends AbCommandDialog {

    /** Creates new form ChangeEnemySpDialog
     * @param parent 
     * @param modal
     * @param typeId
     */
    public ChangeEnemyPowerDialog(ScriptDialog parent, boolean modal, int typeId) {
        super(parent, modal, typeId);
        sd = parent;
        initComponents();
        setLocationRelativeTo(null);
        for (int i = 0; i < AppData.getInstance().getCurProject().getDataManager().size(Model.ENEMY); i++) {
            enemyNameComboBox.addItem((Enemy) AppData.getInstance().getCurProject().getDataManager().getModels(Model.ENEMY)[i]);
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
        buttonGroup2 = new javax.swing.ButtonGroup();
        okButton = new javax.swing.JButton();
        cancleButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        constRadioButton = new javax.swing.JRadioButton();
        varRadioButton = new javax.swing.JRadioButton();
        constTextField = new javax.swing.JTextField();
        varComboBox = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        addRadioButton = new javax.swing.JRadioButton();
        removeRadioButton = new javax.swing.JRadioButton();
        enemyNameComboBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        powerComboBox = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance().getContext().getResourceMap(ChangeEnemyPowerDialog.class);
        setTitle(resourceMap.getString("title")); // NOI18N
        setResizable(false);

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

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("操作数"));
        jPanel2.setName("jPanel2"); // NOI18N

        buttonGroup2.add(constRadioButton);
        constRadioButton.setSelected(true);
        constRadioButton.setText("常量");
        constRadioButton.setName("constRadioButton"); // NOI18N
        constRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                constRadioButtonActionPerformed(evt);
            }
        });

        buttonGroup2.add(varRadioButton);
        varRadioButton.setText("变量");
        varRadioButton.setName("varRadioButton"); // NOI18N
        varRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                varRadioButtonActionPerformed(evt);
            }
        });

        constTextField.setText("0");
        constTextField.setName("constTextField"); // NOI18N

        varComboBox.setEnabled(false);
        varComboBox.setName("varComboBox"); // NOI18N
        for(int i =0;i<100;i++){
            varComboBox.addItem(i);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(constRadioButton)
                        .addGap(18, 18, 18)
                        .addComponent(constTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(varRadioButton)
                        .addGap(18, 18, 18)
                        .addComponent(varComboBox, 0, 153, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(constRadioButton)
                    .addComponent(constTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(varRadioButton)
                    .addComponent(varComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("操作"));
        jPanel1.setName("jPanel1"); // NOI18N

        buttonGroup1.add(addRadioButton);
        addRadioButton.setSelected(true);
        addRadioButton.setText("增加");
        addRadioButton.setName("addRadioButton"); // NOI18N

        buttonGroup1.add(removeRadioButton);
        removeRadioButton.setText("减少");
        removeRadioButton.setName("removeRadioButton"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                .addComponent(removeRadioButton)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addRadioButton)
                    .addComponent(removeRadioButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        enemyNameComboBox.setName("enemyNameComboBox"); // NOI18N

        jLabel1.setText("针对敌人");
        jLabel1.setName("jLabel1"); // NOI18N

        powerComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "力量", "敏捷", "智力", "速度", "MaxHp", "MaxSp", "Hp", "Sp", "等级", "经验值" }));
        powerComboBox.setName("powerComboBox"); // NOI18N

        jLabel2.setText("属性类型");
        jLabel2.setName("jLabel2"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(enemyNameComboBox, 0, 187, Short.MAX_VALUE)
                            .addComponent(powerComboBox, 0, 187, Short.MAX_VALUE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(okButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                        .addComponent(cancleButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(enemyNameComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(powerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okButton)
                    .addComponent(cancleButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        // TODO add your handling code here:
        mCommand = CommandFactory.createCommand(mTypeId);
        mCommand.addParameter("" + ((Enemy) enemyNameComboBox.getSelectedItem()).getIndex());
        mCommand.addParameter("" + powerComboBox.getSelectedIndex());
        if (addRadioButton.isSelected()) {
            if (constRadioButton.isSelected()) {
                mCommand.addParameter("1");
                mCommand.addParameter("0");
                mCommand.addParameter(constTextField.getText());
//                sd.insertScriptData(sd.npcPane.eventTable.getSelectedRow(), "globalData.proxy:operatePlayerProperty("
//                        + ((Player) playerComboBox.getSelectedItem()).getIndex() + ","
//                        + powerComboBox.getSelectedIndex() + ",1,0,"
//                        + constTextField.getText() + ")");
            } else {
                mCommand.addParameter("1");
                mCommand.addParameter("1");
                mCommand.addParameter("Interpreter:doCommand(" + Command.GET_VAR_STATE + "," + varComboBox.getSelectedIndex() + ")");
//                sd.insertScriptData(sd.npcPane.eventTable.getSelectedRow(), "globalData.proxy:operatePlayerProperty("
//                        + ((Player) playerComboBox.getSelectedItem()).getIndex() + ","
//                        + powerComboBox.getSelectedIndex() + ",1,1,globalData.proxy:getVariable("
//                        + varComboBox.getSelectedIndex() + "))");
            }
        } else {
            if (constRadioButton.isSelected()) {
                mCommand.addParameter("2");
                mCommand.addParameter("0");
                mCommand.addParameter(constTextField.getText());
//                sd.insertScriptData(sd.npcPane.eventTable.getSelectedRow(), "globalData.proxy:operatePlayerProperty("
//                        + ((Player) playerComboBox.getSelectedItem()).getIndex() + ","
//                        + powerComboBox.getSelectedIndex() + ",2,0,"
//                        + constTextField.getText() + ")");
            } else {
                mCommand.addParameter("2");
                mCommand.addParameter("1");
                mCommand.addParameter("Interpreter:doCommand(" + Command.GET_VAR_STATE + "," + varComboBox.getSelectedIndex() + ")");
//                sd.insertScriptData(sd.npcPane.eventTable.getSelectedRow(), "globalData.proxy:operatePlayerProperty("
//                        + ((Player) playerComboBox.getSelectedItem()).getIndex() + ","
//                        + powerComboBox.getSelectedIndex() + ",2,1,globalData.proxy:getVariable("
//                        + varComboBox.getSelectedIndex() + "))");
            }
        }
        System.out.println(mCommand);
        this.dispose();
}//GEN-LAST:event_okButtonActionPerformed

    private void cancleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancleButtonActionPerformed
        // TODO add your handling code here:
        dispose();
}//GEN-LAST:event_cancleButtonActionPerformed

    private void varRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_varRadioButtonActionPerformed
        // TODO add your handling code here:
        constTextField.setEnabled(false);
        varComboBox.setEnabled(true);
    }//GEN-LAST:event_varRadioButtonActionPerformed

    private void constRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_constRadioButtonActionPerformed
        // TODO add your handling code here:
        constTextField.setEnabled(true);
        varComboBox.setEnabled(false);
    }//GEN-LAST:event_constRadioButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton addRadioButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton cancleButton;
    private javax.swing.JRadioButton constRadioButton;
    private javax.swing.JTextField constTextField;
    private javax.swing.JComboBox enemyNameComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton okButton;
    private javax.swing.JComboBox powerComboBox;
    private javax.swing.JRadioButton removeRadioButton;
    private javax.swing.JComboBox varComboBox;
    private javax.swing.JRadioButton varRadioButton;
    // End of variables declaration//GEN-END:variables
}
