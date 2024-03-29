/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TileSetMangerDialog.java
 *
 * Created on 2011-3-20, 16:49:09
 */
package com.soyomaker.dialog;

import com.soyomaker.AppData;
import com.soyomaker.tablemodel.TileSetTableModel;
import com.soyomaker.model.map.TileSet;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import org.apache.log4j.Logger;

/**
 *
 * @author Administrator
 */
public class TileSetManagerDialog extends javax.swing.JDialog {

    /** Creates new form TileSetMangerDialog
     * @param parent
     * @param modal  
     */
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
        closeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance().getContext().getResourceMap(TileSetManagerDialog.class);
        setTitle(resourceMap.getString("title")); // NOI18N
        setResizable(false);

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        tileSetTable.setModel(tstm);
        tileSetTable.setName("tileSetTable"); // NOI18N
        DefaultTableCellRenderer tilesetRender = new DefaultTableCellRenderer();
        tilesetRender.setHorizontalAlignment(SwingConstants.CENTER);
        for(int i = 0;i < tileSetTable.getColumnCount();i++) {
            tileSetTable.getColumn(tileSetTable.getModel().getColumnName(i)).setCellRenderer(tilesetRender);
        }
        jScrollPane1.setViewportView(tileSetTable);

        removeButton.setText("删除");
        removeButton.setName("removeButton"); // NOI18N
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(removeButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 472, Short.MAX_VALUE)
                        .addComponent(closeButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(closeButton)
                    .addComponent(removeButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_closeButtonActionPerformed
    private AppData data = AppData.getInstance();
    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        // TODO add your handling code here:
        int choose = JOptionPane.showConfirmDialog(this, "图集可能正在使用，你确定要删除吗？", "警告", JOptionPane.OK_CANCEL_OPTION);
        if (choose == JOptionPane.OK_OPTION) {
//            System.out.println("OK");
            if (tileSetTable.getSelectedRow() != -1) {
                TileSet tileset = (TileSet) data.getCurrentMap().getTileSets().get(tileSetTable.getSelectedRow());
                try {
                    data.getCurrentMap().removeTileset(tileset);
                } catch (Exception ex) {
//                    ex.printStackTrace();
                    Logger.getLogger(this.getClass().getName()).error("removeTileSet: " + tileSetTable.getSelectedRow(), ex);
//                    Log.getLogger(this.getClass()).error("removeTileSet: " + tileSetTable.getSelectedRow(), ex);
                }
            }
        }
    }//GEN-LAST:event_removeButtonActionPerformed

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
    private javax.swing.JTable tileSetTable;
    // End of variables declaration//GEN-END:variables
}
