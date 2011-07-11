/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * EquipDialog.java
 *
 * Created on 2011-5-14, 18:37:21
 */
package com.soyostar.dialog.event.dataprocess;

import com.soyostar.dialog.ScriptDialog;

/**
 *
 * @author Administrator
 */
public class EquipDialog extends javax.swing.JDialog {

    /** Creates new form EquipDialog
     * @param parent 
     * @param modal 
     */
    public EquipDialog(ScriptDialog parent, boolean modal) {
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        equipComboBox = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        removeRadioButton = new javax.swing.JRadioButton();
        addRadioButton = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        constRadioButton = new javax.swing.JRadioButton();
        varRadioButton = new javax.swing.JRadioButton();
        constTextField = new javax.swing.JTextField();
        varComboBox = new javax.swing.JComboBox();
        okButton = new javax.swing.JButton();
        cancleButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance().getContext().getResourceMap(EquipDialog.class);
        setTitle(resourceMap.getString("title")); // NOI18N
        setResizable(false);

        jLabel1.setText("装备名称");
        jLabel1.setName("jLabel1"); // NOI18N

        equipComboBox.setName("equipComboBox"); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("操作"));
        jPanel2.setName("jPanel2"); // NOI18N

        buttonGroup1.add(removeRadioButton);
        removeRadioButton.setText("减少");
        removeRadioButton.setName("removeRadioButton"); // NOI18N

        buttonGroup1.add(addRadioButton);
        addRadioButton.setSelected(true);
        addRadioButton.setText("增加");
        addRadioButton.setName("addRadioButton"); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(addRadioButton)
                .addGap(62, 62, 62)
                .addComponent(removeRadioButton)
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(removeRadioButton)
                    .addComponent(addRadioButton))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("操作数"));
        jPanel1.setName("jPanel1"); // NOI18N

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(constRadioButton)
                        .addGap(18, 18, 18)
                        .addComponent(constTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(varRadioButton)
                        .addGap(18, 18, 18)
                        .addComponent(varComboBox, 0, 167, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(constRadioButton)
                    .addComponent(constTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(varRadioButton)
                    .addComponent(varComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

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
                        .addComponent(equipComboBox, 0, 196, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(okButton)
                        .addGap(10, 10, 10)
                        .addComponent(cancleButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(equipComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okButton)
                    .addComponent(cancleButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void constRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_constRadioButtonActionPerformed
        // TODO add your handling code here:
        constTextField.setEnabled(true);
        varComboBox.setEnabled(false);
}//GEN-LAST:event_constRadioButtonActionPerformed

    private void varRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_varRadioButtonActionPerformed
        // TODO add your handling code here:
        constTextField.setEnabled(false);
        varComboBox.setEnabled(true);
}//GEN-LAST:event_varRadioButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        // TODO add your handling code here:
        if (addRadioButton.isSelected()) {
            if (constRadioButton.isSelected()) {
                sd.insertScriptData(sd.npcPane.eventTable.getSelectedRow(), "setEquipNum(" + equipComboBox.getSelectedIndex() + "," + "getEquipNum(" + equipComboBox.getSelectedIndex() + ")+" + constTextField.getText() + ");");
            } else {
                sd.insertScriptData(sd.npcPane.eventTable.getSelectedRow(), "setEquipNum(" + equipComboBox.getSelectedIndex() + "," + "getEquipNum(" + equipComboBox.getSelectedIndex() + ")+" + "getVar(" + varComboBox.getSelectedIndex() + ")" + ");");
            }
        } else {
            if (constRadioButton.isSelected()) {
                sd.insertScriptData(sd.npcPane.eventTable.getSelectedRow(), "setEquipNum(" + equipComboBox.getSelectedIndex() + "," + "getEquipNum(" + equipComboBox.getSelectedIndex() + ")-" + constTextField.getText() + ");");
            } else {
                sd.insertScriptData(sd.npcPane.eventTable.getSelectedRow(), "setEquipNum(" + equipComboBox.getSelectedIndex() + "," + "getEquipNum(" + equipComboBox.getSelectedIndex() + ")-" + "getVar(" + varComboBox.getSelectedIndex() + ")" + ");");
            }
        }

        this.dispose();
}//GEN-LAST:event_okButtonActionPerformed

    private void cancleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancleButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
}//GEN-LAST:event_cancleButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                EquipDialog dialog = new EquipDialog(null, true);
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
    private javax.swing.JRadioButton addRadioButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton cancleButton;
    private javax.swing.JRadioButton constRadioButton;
    private javax.swing.JTextField constTextField;
    private javax.swing.JComboBox equipComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton okButton;
    private javax.swing.JRadioButton removeRadioButton;
    private javax.swing.JComboBox varComboBox;
    private javax.swing.JRadioButton varRadioButton;
    // End of variables declaration//GEN-END:variables
}
