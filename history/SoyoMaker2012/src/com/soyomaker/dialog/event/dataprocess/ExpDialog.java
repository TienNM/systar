/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ExpDialog.java
 *
 * Created on 2011-5-14, 16:25:59
 */
package com.soyomaker.dialog.event.dataprocess;

import com.soyomaker.dialog.ScriptDialog;

/**
 *
 * @author Administrator
 */
public class ExpDialog extends javax.swing.JDialog {

    /** Creates new form ExpDialog
     * @param parent 
     * @param modal 
     */
    public ExpDialog(ScriptDialog parent, boolean modal) {
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
        okButton = new javax.swing.JButton();
        cancleButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        constRadioButton = new javax.swing.JRadioButton();
        constTextField = new javax.swing.JTextField();
        varRadioButton = new javax.swing.JRadioButton();
        varComboBox = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        addRadioButton = new javax.swing.JRadioButton();
        removeRadioButton = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance().getContext().getResourceMap(ExpDialog.class);
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

        constTextField.setText("0");
        constTextField.setName("constTextField"); // NOI18N

        buttonGroup2.add(varRadioButton);
        varRadioButton.setText("变量");
        varRadioButton.setName("varRadioButton"); // NOI18N
        varRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                varRadioButtonActionPerformed(evt);
            }
        });

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
                .addContainerGap(22, Short.MAX_VALUE))
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(okButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancleButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancleButton)
                    .addComponent(okButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        // TODO add your handling code here:
        if (addRadioButton.isSelected()) {
            if (constRadioButton.isSelected()) {
                sd.insertScriptData(sd.npcPane.eventTable.getSelectedRow(), "setExp(" + "getExp()+" + constTextField.getText() + ");");
            } else {
                sd.insertScriptData(sd.npcPane.eventTable.getSelectedRow(), "setExp(" + "getExp()+" + "getVar(" + varComboBox.getSelectedIndex() + ")" + ");");
            }
        } else {
            if (constRadioButton.isSelected()) {
                sd.insertScriptData(sd.npcPane.eventTable.getSelectedRow(), "setExp(" + "getExp()-" + constTextField.getText() + ");");
            } else {
                sd.insertScriptData(sd.npcPane.eventTable.getSelectedRow(), "setExp(" + "getExp()-" + "getVar(" + varComboBox.getSelectedIndex() + ")" + ");");
            }
        }
        this.dispose();
}//GEN-LAST:event_okButtonActionPerformed

    private void cancleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancleButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
}//GEN-LAST:event_cancleButtonActionPerformed

    private void constRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_constRadioButtonActionPerformed
        // TODO add your handling code here:
        varComboBox.setEnabled(false);
        constTextField.setEnabled(true);
}//GEN-LAST:event_constRadioButtonActionPerformed

    private void varRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_varRadioButtonActionPerformed
        // TODO add your handling code here:

        varComboBox.setEnabled(true);
        constTextField.setEnabled(false);
}//GEN-LAST:event_varRadioButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                ExpDialog dialog = new ExpDialog(null, true);
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton okButton;
    private javax.swing.JRadioButton removeRadioButton;
    private javax.swing.JComboBox varComboBox;
    private javax.swing.JRadioButton varRadioButton;
    // End of variables declaration//GEN-END:variables
}
