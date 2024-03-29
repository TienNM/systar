/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TileSetMangerDialog.java
 *
 * Created on 2011-3-20, 16:49:09
 */
package com.soyostar.dialog;

import com.soyostar.proxy.Proxy;
import com.soyostar.model.TileSetTableModel;
import com.soyostar.model.map.TileSet;
import com.soyostar.util.Log;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class TileSetManagerDialog extends javax.swing.JDialog {

    /** Creates new form TileSetMangerDialog */
    public TileSetManagerDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        initialize();
    }

    private void initialize() {
        setLocationRelativeTo(null);
    }
    private TileSetTableModel tstm = new TileSetTableModel();

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tileSetTable = new javax.swing.JTable();
        removeButton = new javax.swing.JButton();
        resaveButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance().getContext().getResourceMap(TileSetManagerDialog.class);
        setTitle(resourceMap.getString("title")); // NOI18N
        setResizable(false);

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        tileSetTable.setModel(tstm);
        tileSetTable.setName("tileSetTable"); // NOI18N
        jScrollPane1.setViewportView(tileSetTable);

        removeButton.setText("删除");
        removeButton.setName("removeButton"); // NOI18N
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        resaveButton.setText("另存");
        resaveButton.setName("resaveButton"); // NOI18N
        resaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resaveButtonActionPerformed(evt);
            }
        });

        closeButton.setText("关闭");
        closeButton.setName("closeButton"); // NOI18N
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(removeButton)
                    .addComponent(closeButton)
                    .addComponent(resaveButton))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(removeButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                        .addComponent(resaveButton)
                        .addGap(80, 80, 80)
                        .addComponent(closeButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_closeButtonActionPerformed
    private Proxy data = Proxy.getInstance();
    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        // TODO add your handling code here:
        int choose = JOptionPane.showConfirmDialog(this, "图集可能正在使用，你确定要删除吗？", "警告", JOptionPane.OK_CANCEL_OPTION);
        if (choose == JOptionPane.OK_OPTION) {
//            System.out.println("OK");
            if (tileSetTable.getSelectedRow() != -1) {
                TileSet tileset = data.getCurrentMap().getTileSets().get(tileSetTable.getSelectedRow());
                try {
                    data.getCurrentMap().removeTileset(tileset);
                } catch (Exception ex) {
//                    ex.printStackTrace();
                    Log.getLogger(this.getClass()).error("removeTileSet: " + tileSetTable.getSelectedRow(), ex);
                }
            }

        }
    }//GEN-LAST:event_removeButtonActionPerformed

    private void resaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resaveButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_resaveButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                TileSetManagerDialog dialog = new TileSetManagerDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton closeButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton removeButton;
    private javax.swing.JButton resaveButton;
    private javax.swing.JTable tileSetTable;
    // End of variables declaration//GEN-END:variables
}
