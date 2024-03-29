/*
 * Copyright 2010-2011 Soyostar Software, Inc. All rights reserved.
 */
package com.soyostar.dialog;

import com.soyostar.infomation.SoftInformation;
import com.soyostar.infomation.SystemInformation;
import com.soyostar.util.Log;
import java.awt.*;
import java.net.URL;

/**
 *
 * @author Administrator
 */
public class AboutDialog extends javax.swing.JDialog {

    /** Creates new form AboutDialog
     * @param parent
     * @param modal
     */
    public AboutDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        initialize();

    }

    private void initialize() {
        setLocationRelativeTo(null);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        //setUndecorated(true);
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        aboutArea = new javax.swing.JTextArea();
        aboutButton = new javax.swing.JButton();
        aboutLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance().getContext().getResourceMap(AboutDialog.class);
        setTitle(resourceMap.getString("title")); // NOI18N
        setResizable(false);

        jPanel1.setName("jPanel1"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        aboutArea.setColumns(20);
        aboutArea.setEditable(false);
        aboutArea.setRows(5);
        aboutArea.setText("版本："+SoftInformation.majorVersion+"."+
            SoftInformation.minorVersion+"."+
            SoftInformation.modifiedVersion+"\n"+
            "系统："+SystemInformation.osName+
            " 版本 "+SystemInformation.osVersion+
            " 运行于 "+SystemInformation.osArch+" 上"+"\n"+
            "Java："+SystemInformation.javaVersion+
            " VM "+SystemInformation.javaVmVersion);
        aboutArea.setName("aboutArea"); // NOI18N
        jScrollPane1.setViewportView(aboutArea);

        aboutButton.setText("关闭");
        aboutButton.setName("aboutButton"); // NOI18N
        aboutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutButtonActionPerformed(evt);
            }
        });

        aboutLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/soyostar/resources/logo.png"))); // NOI18N
        aboutLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        aboutLabel.setName("aboutLabel"); // NOI18N
        aboutLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                aboutLabelMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                            .addComponent(aboutLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(aboutButton)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(aboutLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(aboutButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aboutLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutLabelMousePressed
        // TODO add your handling code here:
        try {
            Desktop.getDesktop().browse(new URL("http://www.soyostar.com").toURI());
        } catch (Exception e) {
            Log.getLogger(this.getClass()).error("打开软件首页异常！", e);
        }
    }//GEN-LAST:event_aboutLabelMousePressed

    private void aboutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutButtonActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_aboutButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                AboutDialog dialog = new AboutDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea aboutArea;
    private javax.swing.JButton aboutButton;
    private javax.swing.JLabel aboutLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
