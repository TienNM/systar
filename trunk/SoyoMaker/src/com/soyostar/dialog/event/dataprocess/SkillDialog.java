/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SkillDialog.java
 *
 * Created on 2011-5-14, 18:36:20
 */
package com.soyostar.dialog.event.dataprocess;

import com.soyostar.dialog.ScriptDialog;

/**
 *
 * @author Administrator
 */
public class SkillDialog extends javax.swing.JDialog {

    /** Creates new form SkillDialog
     * @param parent
     * @param modal  
     */
    public SkillDialog(ScriptDialog parent, boolean modal) {
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
        jLabel1 = new javax.swing.JLabel();
        skillComboBox = new javax.swing.JComboBox();
        cancleButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        forgetRadioButton = new javax.swing.JRadioButton();
        studyRadioButton = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance().getContext().getResourceMap(SkillDialog.class);
        setTitle(resourceMap.getString("title")); // NOI18N
        setResizable(false);

        jLabel1.setText("技能名称");
        jLabel1.setName("jLabel1"); // NOI18N

        skillComboBox.setName("skillComboBox"); // NOI18N

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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("操作"));
        jPanel1.setName("jPanel1"); // NOI18N

        buttonGroup1.add(forgetRadioButton);
        forgetRadioButton.setText("遗忘");
        forgetRadioButton.setName("forgetRadioButton"); // NOI18N

        buttonGroup1.add(studyRadioButton);
        studyRadioButton.setSelected(true);
        studyRadioButton.setText("领悟");
        studyRadioButton.setName("studyRadioButton"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(forgetRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(studyRadioButton)
                .addGap(55, 55, 55))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studyRadioButton)
                    .addComponent(forgetRadioButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addComponent(skillComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(okButton)
                        .addGap(18, 18, 18)
                        .addComponent(cancleButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(skillComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        if (forgetRadioButton.isSelected()) {
            sd.insertScriptData(sd.npcPane.eventTable.getSelectedRow(), "setSkillState(" + skillComboBox.getSelectedIndex() + ",false);");
        } else {
            sd.insertScriptData(sd.npcPane.eventTable.getSelectedRow(), "setSkillState(" + skillComboBox.getSelectedIndex() + ",true);");
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
                SkillDialog dialog = new SkillDialog(null, true);
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
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cancleButton;
    private javax.swing.JRadioButton forgetRadioButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton okButton;
    private javax.swing.JComboBox skillComboBox;
    private javax.swing.JRadioButton studyRadioButton;
    // End of variables declaration//GEN-END:variables
}
