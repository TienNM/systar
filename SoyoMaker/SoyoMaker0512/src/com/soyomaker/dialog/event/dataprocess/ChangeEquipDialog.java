/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ChangeDialog.java
 *
 * Created on 2011-6-13, 16:57:24
 */
package com.soyomaker.dialog.event.dataprocess;

import com.soyomaker.AppData;
import com.soyomaker.data.model.Equip;
import com.soyomaker.data.model.Model;
import com.soyomaker.data.model.Player;
import com.soyomaker.dialog.AbCommandDialog;
import com.soyomaker.dialog.ScriptDialog;
import com.soyomaker.model.map.CommandFactory;

/**
 *
 * @author Administrator
 */
public class ChangeEquipDialog extends AbCommandDialog {

    /** Creates new form ChangeDialog
     * @param parent 
     * @param modal
     * @param typeId
     */
    public ChangeEquipDialog(ScriptDialog parent, boolean modal, int typeId) {
        super(parent, modal, typeId);
        sd = parent;
        initComponents();
        setLocationRelativeTo(null);
        for (int i = 0; i < AppData.getInstance().getCurProject().getDataManager().size(Model.PLAYER); i++) {
            playerComboBox.addItem((Player) AppData.getInstance().getCurProject().getDataManager().getModels(Model.PLAYER)[i]);
        }
        Equip[] equips = (Equip[]) AppData.getInstance().getCurProject().getDataManager().getModels(Model.EQUIP);
        helmComboBox.addItem("无");
        for (int i = 0; i < equips.length; i++) {
            if (equips[i].equipType == Equip.HELM) {
                helmComboBox.addItem(equips[i]);
            }
        }
        jewelryComboBox.addItem("无");
        for (int i = 0; i < equips.length; i++) {
            if (equips[i].equipType == Equip.JEWELRY) {
                jewelryComboBox.addItem(equips[i]);
            }
        }
        weaponComboBox.addItem("无");
        for (int i = 0; i < equips.length; i++) {
            if (equips[i].equipType == Equip.WEAPON) {
                weaponComboBox.addItem(equips[i]);
            }
        }
        shieldComboBox.addItem("无");
        for (int i = 0; i < equips.length; i++) {
            if (equips[i].equipType == Equip.SHIELD) {
                shieldComboBox.addItem(equips[i]);
            }
        }
        armourComboBox.addItem("无");
        for (int i = 0; i < equips.length; i++) {
            if (equips[i].equipType == Equip.ARMOUR) {
                armourComboBox.addItem(equips[i]);
            }
        }
        bootsComboBox.addItem("无");
        for (int i = 0; i < equips.length; i++) {
            if (equips[i].equipType == Equip.BOOTS) {
                bootsComboBox.addItem(equips[i]);
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
        helmComboBox = new javax.swing.JComboBox();
        okButton = new javax.swing.JButton();
        cancleButton = new javax.swing.JButton();
        shieldComboBox = new javax.swing.JComboBox();
        weaponComboBox = new javax.swing.JComboBox();
        armourComboBox = new javax.swing.JComboBox();
        bootsComboBox = new javax.swing.JComboBox();
        jewelryComboBox = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        playerComboBox = new javax.swing.JComboBox();
        helmCheckBox = new javax.swing.JCheckBox();
        shieldCheckBox = new javax.swing.JCheckBox();
        weaponCheckBox = new javax.swing.JCheckBox();
        armourCheckBox = new javax.swing.JCheckBox();
        bootsCheckBox = new javax.swing.JCheckBox();
        jewelryCheckBox = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance().getContext().getResourceMap(ChangeEquipDialog.class);
        setTitle(resourceMap.getString("title")); // NOI18N
        setResizable(false);

        helmComboBox.setEnabled(false);
        helmComboBox.setName("helmComboBox"); // NOI18N

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

        shieldComboBox.setEnabled(false);
        shieldComboBox.setName("shieldComboBox"); // NOI18N

        weaponComboBox.setEnabled(false);
        weaponComboBox.setName("weaponComboBox"); // NOI18N

        armourComboBox.setEnabled(false);
        armourComboBox.setName("armourComboBox"); // NOI18N

        bootsComboBox.setEnabled(false);
        bootsComboBox.setName("bootsComboBox"); // NOI18N

        jewelryComboBox.setEnabled(false);
        jewelryComboBox.setName("jewelryComboBox"); // NOI18N

        jLabel7.setText("针对角色");
        jLabel7.setName("jLabel7"); // NOI18N

        playerComboBox.setName("playerComboBox"); // NOI18N

        helmCheckBox.setText("头盔");
        helmCheckBox.setName("helmCheckBox"); // NOI18N
        helmCheckBox.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                helmCheckBoxStateChanged(evt);
            }
        });

        shieldCheckBox.setText("盾牌");
        shieldCheckBox.setName("shieldCheckBox"); // NOI18N
        shieldCheckBox.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                shieldCheckBoxStateChanged(evt);
            }
        });

        weaponCheckBox.setText("武器");
        weaponCheckBox.setName("weaponCheckBox"); // NOI18N
        weaponCheckBox.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                weaponCheckBoxStateChanged(evt);
            }
        });

        armourCheckBox.setText("铠甲");
        armourCheckBox.setName("armourCheckBox"); // NOI18N
        armourCheckBox.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                armourCheckBoxStateChanged(evt);
            }
        });

        bootsCheckBox.setText("战靴");
        bootsCheckBox.setName("bootsCheckBox"); // NOI18N
        bootsCheckBox.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                bootsCheckBoxStateChanged(evt);
            }
        });

        jewelryCheckBox.setText("饰品");
        jewelryCheckBox.setName("jewelryCheckBox"); // NOI18N
        jewelryCheckBox.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jewelryCheckBoxStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(helmCheckBox)
                    .addComponent(shieldCheckBox)
                    .addComponent(weaponCheckBox)
                    .addComponent(armourCheckBox)
                    .addComponent(bootsCheckBox)
                    .addComponent(jewelryCheckBox)
                    .addComponent(jLabel7)
                    .addComponent(okButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cancleButton)
                    .addComponent(playerComboBox, 0, 159, Short.MAX_VALUE)
                    .addComponent(helmComboBox, 0, 159, Short.MAX_VALUE)
                    .addComponent(shieldComboBox, 0, 159, Short.MAX_VALUE)
                    .addComponent(weaponComboBox, 0, 159, Short.MAX_VALUE)
                    .addComponent(armourComboBox, 0, 159, Short.MAX_VALUE)
                    .addComponent(bootsComboBox, 0, 159, Short.MAX_VALUE)
                    .addComponent(jewelryComboBox, 0, 159, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cancleButton)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(playerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(helmCheckBox)
                            .addComponent(helmComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(shieldCheckBox)
                            .addComponent(shieldComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(weaponCheckBox)
                            .addComponent(weaponComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(armourCheckBox)
                            .addComponent(armourComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bootsCheckBox)
                            .addComponent(bootsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jewelryCheckBox)
                            .addComponent(jewelryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(okButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        // TODO add your handling code here:
        Equip[] equips = new Equip[6];
        if (helmCheckBox.isSelected()) {
            if (!helmComboBox.getSelectedItem().toString().equals("无")) {
                equips[0] = (Equip) helmComboBox.getSelectedItem();
            } else {
                Equip equip = new Equip();
                equip.setIndex(-2);//-2表示删除
                equips[0] = equip;
            }
        }
        if (jewelryCheckBox.isSelected()) {
            if (!jewelryComboBox.getSelectedItem().toString().equals("无")) {
                equips[5] = (Equip) jewelryComboBox.getSelectedItem();
            } else {
                Equip equip = new Equip();
                equip.setIndex(-2);//-2表示删除
                equips[5] = equip;
            }
        }
        if (weaponCheckBox.isSelected()) {
            if (!weaponComboBox.getSelectedItem().toString().equals("无")) {
                equips[2] = (Equip) weaponComboBox.getSelectedItem();
            } else {
                Equip equip = new Equip();
                equip.setIndex(-2);//-2表示删除
                equips[2] = equip;
            }
        }
        if (shieldCheckBox.isSelected()) {
            if (!shieldComboBox.getSelectedItem().toString().equals("无")) {
                equips[1] = (Equip) shieldComboBox.getSelectedItem();
            } else {
                Equip equip = new Equip();
                equip.setIndex(-2);//-2表示删除
                equips[1] = equip;
            }
        }
        if (armourCheckBox.isSelected()) {
            if (!armourComboBox.getSelectedItem().toString().equals("无")) {
                equips[3] = (Equip) armourComboBox.getSelectedItem();
            } else {
                Equip equip = new Equip();
                equip.setIndex(-2);//-2表示删除
                equips[3] = equip;
            }
        }
        if (bootsCheckBox.isSelected()) {
            if (!bootsComboBox.getSelectedItem().toString().equals("无")) {
                equips[4] = (Equip) bootsComboBox.getSelectedItem();
            } else {
                Equip equip = new Equip();
                equip.setIndex(-2);//-2表示删除
                equips[4] = equip;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < equips.length; i++) {
            int id = -1;
            if (equips[i] != null) {
                id = equips[i].getIndex();
            }
            if (i == equips.length - 1) {
                sb.append(id);
            } else {
                sb.append(id).append(",");
            }
        }
        sb.append("}");
        mCommand = CommandFactory.createCommand(mTypeId);
        mCommand.addParameter(sb.toString());
        System.out.println(mCommand);
//        sd.insertScriptData(sd.npcPane.eventTable.getSelectedRow(), "globalData.proxy:operatePlayerEquip(" + sb.toString() + ")");
        dispose();
    }//GEN-LAST:event_okButtonActionPerformed

    private void cancleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancleButtonActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_cancleButtonActionPerformed

    private void helmCheckBoxStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_helmCheckBoxStateChanged
        // TODO add your handling code here:
        if (helmCheckBox.isSelected()) {
            helmComboBox.setEnabled(true);
        } else {
            helmComboBox.setEnabled(false);
        }
    }//GEN-LAST:event_helmCheckBoxStateChanged

    private void shieldCheckBoxStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_shieldCheckBoxStateChanged
        // TODO add your handling code here:
        if (shieldCheckBox.isSelected()) {
            shieldComboBox.setEnabled(true);
        } else {
            shieldComboBox.setEnabled(false);
        }
    }//GEN-LAST:event_shieldCheckBoxStateChanged

    private void weaponCheckBoxStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_weaponCheckBoxStateChanged
        // TODO add your handling code here:
        if (weaponCheckBox.isSelected()) {
            weaponComboBox.setEnabled(true);
        } else {
            weaponComboBox.setEnabled(false);
        }
    }//GEN-LAST:event_weaponCheckBoxStateChanged

    private void armourCheckBoxStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_armourCheckBoxStateChanged
        // TODO add your handling code here:
        if (armourCheckBox.isSelected()) {
            armourComboBox.setEnabled(true);
        } else {
            armourComboBox.setEnabled(false);
        }
    }//GEN-LAST:event_armourCheckBoxStateChanged

    private void bootsCheckBoxStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_bootsCheckBoxStateChanged
        // TODO add your handling code here:
        if (bootsCheckBox.isSelected()) {
            bootsComboBox.setEnabled(true);
        } else {
            bootsComboBox.setEnabled(false);
        }
    }//GEN-LAST:event_bootsCheckBoxStateChanged

    private void jewelryCheckBoxStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jewelryCheckBoxStateChanged
        // TODO add your handling code here:
        if (jewelryCheckBox.isSelected()) {
            jewelryComboBox.setEnabled(true);
        } else {
            jewelryComboBox.setEnabled(false);
        }
    }//GEN-LAST:event_jewelryCheckBoxStateChanged
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox armourCheckBox;
    private javax.swing.JComboBox armourComboBox;
    private javax.swing.JCheckBox bootsCheckBox;
    private javax.swing.JComboBox bootsComboBox;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cancleButton;
    private javax.swing.JCheckBox helmCheckBox;
    private javax.swing.JComboBox helmComboBox;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JCheckBox jewelryCheckBox;
    private javax.swing.JComboBox jewelryComboBox;
    private javax.swing.JButton okButton;
    private javax.swing.JComboBox playerComboBox;
    private javax.swing.JCheckBox shieldCheckBox;
    private javax.swing.JComboBox shieldComboBox;
    private javax.swing.JCheckBox weaponCheckBox;
    private javax.swing.JComboBox weaponComboBox;
    // End of variables declaration//GEN-END:variables
}
