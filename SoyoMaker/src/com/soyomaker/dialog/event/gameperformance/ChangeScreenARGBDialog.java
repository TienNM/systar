/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ChangeScreenARGBDialog.java
 *
 * Created on 2011-6-13, 1:31:25
 */
package com.soyomaker.dialog.event.gameperformance;

import com.soyomaker.dialog.AbCommandDialog;
import com.soyomaker.dialog.ScriptDialog;
import com.soyomaker.model.map.CommandFactory;

/**
 *
 * @author Administrator
 */
public class ChangeScreenARGBDialog extends AbCommandDialog {

    /** Creates new form ChangeScreenARGBDialog
     * @param parent
     * @param modal
     * @param typeId
     */
    public ChangeScreenARGBDialog(ScriptDialog parent, boolean modal, int typeId) {
        super(parent, modal, typeId);
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

        alphaSlider = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        redSlider = new javax.swing.JSlider();
        jLabel3 = new javax.swing.JLabel();
        greenSlider = new javax.swing.JSlider();
        jLabel4 = new javax.swing.JLabel();
        blueSlider = new javax.swing.JSlider();
        okButton = new javax.swing.JButton();
        cancleButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        frameTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance().getContext().getResourceMap(ChangeScreenARGBDialog.class);
        setTitle(resourceMap.getString("title")); // NOI18N
        setResizable(false);

        alphaSlider.setMajorTickSpacing(64);
        alphaSlider.setMaximum(255);
        alphaSlider.setMinorTickSpacing(8);
        alphaSlider.setPaintTicks(true);
        alphaSlider.setSnapToTicks(true);
        alphaSlider.setValue(0);
        alphaSlider.setName("alphaSlider"); // NOI18N
        alphaSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                alphaSliderStateChanged(evt);
            }
        });

        jLabel1.setText("透明0");
        jLabel1.setName("jLabel1"); // NOI18N

        jLabel2.setText("红0");
        jLabel2.setName("jLabel2"); // NOI18N

        redSlider.setMajorTickSpacing(64);
        redSlider.setMaximum(255);
        redSlider.setMinorTickSpacing(8);
        redSlider.setPaintTicks(true);
        redSlider.setSnapToTicks(true);
        redSlider.setValue(0);
        redSlider.setName("redSlider"); // NOI18N
        redSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                redSliderStateChanged(evt);
            }
        });

        jLabel3.setText("绿0");
        jLabel3.setName("jLabel3"); // NOI18N

        greenSlider.setMajorTickSpacing(64);
        greenSlider.setMaximum(255);
        greenSlider.setMinorTickSpacing(8);
        greenSlider.setPaintTicks(true);
        greenSlider.setSnapToTicks(true);
        greenSlider.setValue(0);
        greenSlider.setName("greenSlider"); // NOI18N
        greenSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                greenSliderStateChanged(evt);
            }
        });

        jLabel4.setText("蓝0");
        jLabel4.setName("jLabel4"); // NOI18N

        blueSlider.setMajorTickSpacing(64);
        blueSlider.setMaximum(255);
        blueSlider.setMinorTickSpacing(8);
        blueSlider.setPaintTicks(true);
        blueSlider.setSnapToTicks(true);
        blueSlider.setValue(0);
        blueSlider.setName("blueSlider"); // NOI18N
        blueSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                blueSliderStateChanged(evt);
            }
        });

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

        jLabel5.setText("持续");
        jLabel5.setName("jLabel5"); // NOI18N

        frameTextField.setText("20");
        frameTextField.setName("frameTextField"); // NOI18N

        jLabel6.setText("ms");
        jLabel6.setName("jLabel6"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(blueSlider, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                            .addComponent(greenSlider, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                            .addComponent(redSlider, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                            .addComponent(alphaSlider, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(frameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(okButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 135, Short.MAX_VALUE)
                        .addComponent(cancleButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(alphaSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(redSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(greenSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(blueSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(frameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(okButton)
                    .addComponent(cancleButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        // TODO add your handling code here:
        mCommand = CommandFactory.createCommand(mTypeId);
        mCommand.addParameter("" + alphaSlider.getValue());
        mCommand.addParameter("" + redSlider.getValue());
        mCommand.addParameter("" + greenSlider.getValue());
        mCommand.addParameter("" + blueSlider.getValue());
        mCommand.addParameter(frameTextField.getText());
        System.out.println(mCommand);
//        sd.insertScriptData(sd.npcPane.eventTable.getSelectedRow(),
//            "globalData.proxy:toneScene(" + alphaSlider.getValue() + "," + redSlider.getValue() + "," + greenSlider.getValue() + "," + blueSlider.getValue() + "," + frameTextField.getText() + ")");
        dispose();
    }//GEN-LAST:event_okButtonActionPerformed

    private void cancleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancleButtonActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_cancleButtonActionPerformed

    private void alphaSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_alphaSliderStateChanged
        // TODO add your handling code here:
        jLabel1.setText("透明" + alphaSlider.getValue());
    }//GEN-LAST:event_alphaSliderStateChanged

    private void redSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_redSliderStateChanged
        // TODO add your handling code here:
        jLabel2.setText("红" + redSlider.getValue());
    }//GEN-LAST:event_redSliderStateChanged

    private void greenSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_greenSliderStateChanged
        // TODO add your handling code here:
        jLabel3.setText("绿" + greenSlider.getValue());
    }//GEN-LAST:event_greenSliderStateChanged

    private void blueSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_blueSliderStateChanged
        // TODO add your handling code here:
        jLabel4.setText("蓝" + blueSlider.getValue());
    }//GEN-LAST:event_blueSliderStateChanged
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSlider alphaSlider;
    private javax.swing.JSlider blueSlider;
    private javax.swing.JButton cancleButton;
    private javax.swing.JTextField frameTextField;
    private javax.swing.JSlider greenSlider;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton okButton;
    private javax.swing.JSlider redSlider;
    // End of variables declaration//GEN-END:variables
}
