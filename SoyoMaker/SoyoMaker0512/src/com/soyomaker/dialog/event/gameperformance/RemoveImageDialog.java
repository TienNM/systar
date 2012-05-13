/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * RemoveImageDialog.java
 *
 * Created on 2011-6-20, 14:15:37
 */
package com.soyomaker.dialog.event.gameperformance;

import com.soyomaker.data.DataManager;
import com.soyomaker.dialog.AbCommandDialog;
import com.soyomaker.dialog.ScriptDialog;
import com.soyomaker.model.map.CommandFactory;

/**
 *
 * @author Administrator
 */
public class RemoveImageDialog extends AbCommandDialog {

    /** Creates new form RemoveImageDialog
     * @param parent 
     * @param modal
     * @param typeId
     */
    public RemoveImageDialog(ScriptDialog parent, boolean modal, int typeId) {
        super(parent, modal, typeId);
        sd = parent;
        initComponents();
        setLocationRelativeTo(null);
        for (int i = 0; i < DataManager.listPictureImageName().length; i++) {
            imageComboBox.addItem(DataManager.listPictureImageName()[i]);
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

        jLabel1 = new javax.swing.JLabel();
        imageComboBox = new javax.swing.JComboBox();
        okButton = new javax.swing.JButton();
        cancleButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance().getContext().getResourceMap(RemoveImageDialog.class);
        setTitle(resourceMap.getString("title")); // NOI18N
        setResizable(false);

        jLabel1.setText("图片名称");
        jLabel1.setName("jLabel1"); // NOI18N

        imageComboBox.setName("imageComboBox"); // NOI18N

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
                        .addComponent(imageComboBox, 0, 181, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(okButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 133, Short.MAX_VALUE)
                        .addComponent(cancleButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(imageComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okButton)
                    .addComponent(cancleButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        // TODO add your handling code here:
        if (imageComboBox.getSelectedIndex() != -1) {
            mCommand = CommandFactory.createCommand(mTypeId);
            mCommand.addParameter("\"/image/picture/" + imageComboBox.getSelectedItem() + "\"");
            System.out.println(mCommand);
//            sd.insertScriptData(sd.npcPane.eventTable.getSelectedRow(),
//                    "globalData.proxy:removeImage(" + "\"/image/picture/" + imageComboBox.getSelectedItem() + "\"" + ")");
            dispose();
        }
    }//GEN-LAST:event_okButtonActionPerformed

    private void cancleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancleButtonActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_cancleButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancleButton;
    private javax.swing.JComboBox imageComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton okButton;
    // End of variables declaration//GEN-END:variables
}