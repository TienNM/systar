/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * EnemyActionDialog.java
 *
 * Created on 2011-10-8, 23:55:35
 */
package com.soyomaker.data.ui;

import com.soyomaker.AppData;
import com.soyomaker.data.model.Action;
import com.soyomaker.data.model.Condition;
import com.soyomaker.data.model.Item;
import com.soyomaker.data.model.Model;
import com.soyomaker.data.model.Skill;

/**
 *
 * @author Administrator
 */
public class AddModelActionDialog extends javax.swing.JDialog {

    /** Creates new form EnemyActionDialog
     * @param parent
     * @param modal
     */
    public AddModelActionDialog(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
    }
    private Action action;

    /**
     *
     * @return
     */
    public Action getSelectAction() {
        if (!isOk) {
            return null;
        }
        return action;
    }
    private boolean isOk;

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        okButton = new javax.swing.JButton();
        cancleButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        boutCheckBox = new javax.swing.JCheckBox();
        hpCheckBox = new javax.swing.JCheckBox();
        levelCheckBox = new javax.swing.JCheckBox();
        switchCheckBox = new javax.swing.JCheckBox();
        varCheckBox = new javax.swing.JCheckBox();
        boutFromTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        boutToTextField = new javax.swing.JTextField();
        hpFromTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        hpToTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        levelTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        switchComboBox = new javax.swing.JComboBox();
        varComboBox = new javax.swing.JComboBox();
        varOperateComboBox = new javax.swing.JComboBox();
        varTextField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        actionTypeComboBox = new javax.swing.JComboBox();
        actionParaComboBox = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        rateSlider = new javax.swing.JSlider();
        rateLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance().getContext().getResourceMap(AddModelActionDialog.class);
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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("执行条件"));
        jPanel1.setName("jPanel1"); // NOI18N

        boutCheckBox.setText("回合");
        boutCheckBox.setName("boutCheckBox"); // NOI18N

        hpCheckBox.setText("HP");
        hpCheckBox.setName("hpCheckBox"); // NOI18N

        levelCheckBox.setText("等级");
        levelCheckBox.setName("levelCheckBox"); // NOI18N

        switchCheckBox.setText("开关");
        switchCheckBox.setName("switchCheckBox"); // NOI18N

        varCheckBox.setText("变量");
        varCheckBox.setName("varCheckBox"); // NOI18N

        boutFromTextField.setText("0");
        boutFromTextField.setName("boutFromTextField"); // NOI18N

        jLabel4.setText("~");
        jLabel4.setName("jLabel4"); // NOI18N

        boutToTextField.setText("0");
        boutToTextField.setName("boutToTextField"); // NOI18N

        hpFromTextField.setText("0");
        hpFromTextField.setName("hpFromTextField"); // NOI18N

        jLabel5.setText("% ~");
        jLabel5.setName("jLabel5"); // NOI18N

        hpToTextField.setText("0");
        hpToTextField.setName("hpToTextField"); // NOI18N

        jLabel6.setText("%");
        jLabel6.setName("jLabel6"); // NOI18N

        levelTextField.setText("0");
        levelTextField.setName("levelTextField"); // NOI18N

        jLabel7.setText("以上");
        jLabel7.setName("jLabel7"); // NOI18N

        jLabel8.setText("为ON时");
        jLabel8.setName("jLabel8"); // NOI18N

        for(int i = 0;i<100;i++){
            switchComboBox.addItem(i);
        }
        switchComboBox.setName("switchComboBox"); // NOI18N

        for(int i = 0;i<100;i++){
            varComboBox.addItem(i);
        }
        varComboBox.setName("varComboBox"); // NOI18N

        for(int i = 0;i<Condition.actionOperateTypes.length;i++){
            varOperateComboBox.addItem(Condition.actionOperateTypes[i]);
        }
        varOperateComboBox.setName("varOperateComboBox"); // NOI18N

        varTextField.setText("0");
        varTextField.setName("varTextField"); // NOI18N

        jLabel9.setText("时");
        jLabel9.setName("jLabel9"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(varCheckBox)
                        .addGap(18, 18, 18)
                        .addComponent(varComboBox, 0, 84, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(switchCheckBox)
                        .addGap(18, 18, 18)
                        .addComponent(switchComboBox, 0, 84, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(levelCheckBox)
                                .addGap(18, 18, 18)
                                .addComponent(levelTextField))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(boutCheckBox)
                                    .addComponent(hpCheckBox))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(hpFromTextField)
                                    .addComponent(boutFromTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(boutToTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(varOperateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(varTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel9)))
                        .addGap(191, 191, 191))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(hpToTextField, 0, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(272, 272, 272))))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {boutFromTextField, boutToTextField, hpFromTextField, hpToTextField, levelTextField});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(boutCheckBox)
                            .addComponent(boutFromTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(hpCheckBox)
                            .addComponent(hpFromTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(hpToTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(levelCheckBox)
                            .addComponent(levelTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addComponent(boutToTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(switchCheckBox)
                    .addComponent(switchComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(varCheckBox)
                    .addComponent(varComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(varOperateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(varTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {boutFromTextField, boutToTextField, hpFromTextField, hpToTextField, levelTextField});

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("指令"));
        jPanel2.setName("jPanel2"); // NOI18N

        jLabel3.setText("动作类型");
        jLabel3.setName("jLabel3"); // NOI18N

        for(int i = 0;i<Action.types.length;i++){
            actionTypeComboBox.addItem(Action.types[i]);
        }
        actionTypeComboBox.setName("actionTypeComboBox"); // NOI18N
        actionTypeComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                actionTypeComboBoxItemStateChanged(evt);
            }
        });

        actionParaComboBox.setEnabled(false);
        actionParaComboBox.setName("actionParaComboBox"); // NOI18N

        jLabel10.setText("动作参数");
        jLabel10.setName("jLabel10"); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(actionParaComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, 276, Short.MAX_VALUE)
                    .addComponent(actionTypeComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, 276, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(actionTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(actionParaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jLabel1.setText("触发概率");
        jLabel1.setName("jLabel1"); // NOI18N

        rateSlider.setMajorTickSpacing(10);
        rateSlider.setMinorTickSpacing(5);
        rateSlider.setPaintTicks(true);
        rateSlider.setValue(5);
        rateSlider.setName("rateSlider"); // NOI18N
        rateSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rateSliderStateChanged(evt);
            }
        });

        rateLabel.setText("5%");
        rateLabel.setName("rateLabel"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(okButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cancleButton))
                            .addComponent(rateSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPanel1, jPanel2});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(rateSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(okButton)
                            .addComponent(cancleButton)))
                    .addComponent(rateLabel))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        // TODO add your handling code here:
        action = new Action();
        if (boutCheckBox.isSelected()) {
            Condition con = new Condition();
            con.paras.add(Integer.parseInt(boutFromTextField.getText()));
            con.paras.add(Integer.parseInt(boutToTextField.getText()));
            action.conds.add(con);
        }
        if (hpCheckBox.isSelected()) {
            Condition con = new Condition();
            con.paras.add(Integer.parseInt(hpFromTextField.getText()));
            con.paras.add(Integer.parseInt(hpToTextField.getText()));
            action.conds.add(con);
        }
        if (levelCheckBox.isSelected()) {
            Condition con = new Condition();
            con.paras.add(Integer.parseInt(levelTextField.getText()));
            action.conds.add(con);
        }
        if (switchCheckBox.isSelected()) {
            Condition con = new Condition();
            con.paras.add(switchComboBox.getSelectedIndex());
            action.conds.add(con);
        }
        if (varCheckBox.isSelected()) {
            Condition con = new Condition();
            con.paras.add(varComboBox.getSelectedIndex());
            con.paras.add(varOperateComboBox.getSelectedIndex());
            con.paras.add(Integer.parseInt(varTextField.getText()));
            action.conds.add(con);
        }
        action.actionType = actionTypeComboBox.getSelectedIndex();
        switch (action.actionType) {
            case Action.USE_ITEM://使用物品
                action.paras.add(actionParaComboBox.getSelectedIndex());
                break;
            case Action.USE_SKILL://使用技能
                action.paras.add(actionParaComboBox.getSelectedIndex());
                break;
        }
        action.rate = rateSlider.getValue();
        isOk = true;
        dispose();
    }//GEN-LAST:event_okButtonActionPerformed

    private void cancleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancleButtonActionPerformed
        // TODO add your handling code here:
        isOk = false;
        dispose();
    }//GEN-LAST:event_cancleButtonActionPerformed

    private void rateSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rateSliderStateChanged
        // TODO add your handling code here:
        rateLabel.setText(rateSlider.getValue() + "%");
    }//GEN-LAST:event_rateSliderStateChanged

    private void actionTypeComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_actionTypeComboBoxItemStateChanged
        // TODO add your handling code here:
        actionParaComboBox.removeAllItems();
        switch (actionTypeComboBox.getSelectedIndex()) {
            case Action.USE_ITEM:
                actionParaComboBox.setEnabled(true);
                for (int i = 0; i < AppData.getInstance().getCurProject().getDataManager().size(Model.ITEM); i++) {
                    actionParaComboBox.addItem((Item) AppData.getInstance().getCurProject().getDataManager().getModels(Model.ITEM)[i]);
                }
                break;
            case Action.USE_SKILL:
                actionParaComboBox.setEnabled(true);
                for (int i = 0; i < AppData.getInstance().getCurProject().getDataManager().size(Model.SKILL); i++) {
                    actionParaComboBox.addItem((Skill) AppData.getInstance().getCurProject().getDataManager().getModels(Model.SKILL)[i]);
                }
                break;
            default:
                actionParaComboBox.setEnabled(false);
                break;
        }
    }//GEN-LAST:event_actionTypeComboBoxItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox actionParaComboBox;
    private javax.swing.JComboBox actionTypeComboBox;
    private javax.swing.JCheckBox boutCheckBox;
    private javax.swing.JTextField boutFromTextField;
    private javax.swing.JTextField boutToTextField;
    private javax.swing.JButton cancleButton;
    private javax.swing.JCheckBox hpCheckBox;
    private javax.swing.JTextField hpFromTextField;
    private javax.swing.JTextField hpToTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JCheckBox levelCheckBox;
    private javax.swing.JTextField levelTextField;
    private javax.swing.JButton okButton;
    private javax.swing.JLabel rateLabel;
    private javax.swing.JSlider rateSlider;
    private javax.swing.JCheckBox switchCheckBox;
    private javax.swing.JComboBox switchComboBox;
    private javax.swing.JCheckBox varCheckBox;
    private javax.swing.JComboBox varComboBox;
    private javax.swing.JComboBox varOperateComboBox;
    private javax.swing.JTextField varTextField;
    // End of variables declaration//GEN-END:variables
}
