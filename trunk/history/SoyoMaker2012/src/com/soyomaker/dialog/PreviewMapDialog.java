/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PreviewMapDialog.java
 *
 * Created on 2011-6-5, 22:30:19
 */
package com.soyomaker.dialog;

import com.soyomaker.AppData;
import com.soyomaker.render.PreviewRenderFactory;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class PreviewMapDialog extends javax.swing.JDialog {

    /** Creates new form PreviewMapDialog
     * @param parent 
     * @param modal 
     */
    public PreviewMapDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        if (AppData.getInstance().getCurrentMap().getPreviewRender() == null) {
            PreviewRenderFactory.createPreviewRender(AppData.getInstance().getCurrentMap());
        }
        initComponents();
        initialize();
    }

    private void initialize() {
        setLocationRelativeTo(null);
        previewScrollPane.setViewportView(AppData.getInstance().getCurrentMap().getPreviewRender());
        AppData.getInstance().getCurrentMap().getPreviewRender().repaint();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        ScreenWTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ScreenHTextField = new javax.swing.JTextField();
        setScreenButton = new javax.swing.JButton();
        previewScrollPane = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        showCollideCheckBox = new javax.swing.JCheckBox();
        showSpriteCheckBox = new javax.swing.JCheckBox();
        showScreenCheckBox = new javax.swing.JCheckBox();
        showTileCheckBox = new javax.swing.JCheckBox();
        savePreviewButton = new javax.swing.JButton();
        closePreviewButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance().getContext().getResourceMap(PreviewMapDialog.class);
        setTitle(resourceMap.getString("title")); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("屏幕大小"));
        jPanel1.setName("jPanel1"); // NOI18N

        ScreenWTextField.setText("320");
        ScreenWTextField.setName("ScreenWTextField"); // NOI18N

        jLabel1.setText("宽");
        jLabel1.setName("jLabel1"); // NOI18N

        jLabel2.setText("高");
        jLabel2.setName("jLabel2"); // NOI18N

        ScreenHTextField.setText("480");
        ScreenHTextField.setName("ScreenHTextField"); // NOI18N

        setScreenButton.setText("确定设置");
        setScreenButton.setName("setScreenButton"); // NOI18N
        setScreenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setScreenButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ScreenWTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ScreenHTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(setScreenButton)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ScreenHTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(ScreenWTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(setScreenButton))
                .addContainerGap(6, Short.MAX_VALUE))
        );

        previewScrollPane.setName("previewScrollPane"); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("显示设置"));
        jPanel2.setName("jPanel2"); // NOI18N

        showCollideCheckBox.setText("显示碰撞");
        showCollideCheckBox.setName("showCollideCheckBox"); // NOI18N
        showCollideCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showCollideCheckBoxActionPerformed(evt);
            }
        });
        showCollideCheckBox.setSelected(AppData.getInstance().getCurrentMap().getPreviewRender().isShowCollide());

        showSpriteCheckBox.setSelected(true);
        showSpriteCheckBox.setText("显示精灵");
        showSpriteCheckBox.setName("showSpriteCheckBox"); // NOI18N
        showSpriteCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showSpriteCheckBoxActionPerformed(evt);
            }
        });
        showSpriteCheckBox.setSelected(AppData.getInstance().getCurrentMap().getPreviewRender().isShowSprite());

        showScreenCheckBox.setSelected(true);
        showScreenCheckBox.setText("显示屏幕");
        showScreenCheckBox.setName("showScreenCheckBox"); // NOI18N
        showScreenCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showScreenCheckBoxActionPerformed(evt);
            }
        });
        showScreenCheckBox.setSelected(AppData.getInstance().getCurrentMap().getPreviewRender().isShowScreen());

        showTileCheckBox.setText("显示瓷砖");
        showTileCheckBox.setName("showTileCheckBox"); // NOI18N
        showTileCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showTileCheckBoxActionPerformed(evt);
            }
        });
        showTileCheckBox.setSelected(AppData.getInstance().getCurrentMap().getPreviewRender().isShowTile());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(showTileCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(showCollideCheckBox)
                .addGap(50, 50, 50)
                .addComponent(showSpriteCheckBox)
                .addGap(50, 50, 50)
                .addComponent(showScreenCheckBox)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(showScreenCheckBox)
                    .addComponent(showCollideCheckBox)
                    .addComponent(showSpriteCheckBox)
                    .addComponent(showTileCheckBox))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        savePreviewButton.setText("保存快照");
        savePreviewButton.setName("savePreviewButton"); // NOI18N
        savePreviewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savePreviewButtonActionPerformed(evt);
            }
        });

        closePreviewButton.setText("关闭");
        closePreviewButton.setName("closePreviewButton"); // NOI18N
        closePreviewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closePreviewButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(previewScrollPane, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(savePreviewButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 630, Short.MAX_VALUE)
                        .addComponent(closePreviewButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, 0, 55, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(previewScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(closePreviewButton)
                    .addComponent(savePreviewButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closePreviewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closePreviewButtonActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_closePreviewButtonActionPerformed

    private void showCollideCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showCollideCheckBoxActionPerformed
        // TODO add your handling code here:
        AppData.getInstance().getCurrentMap().getPreviewRender().setShowCollide(showCollideCheckBox.isSelected());
        AppData.getInstance().getCurrentMap().getPreviewRender().repaint();
    }//GEN-LAST:event_showCollideCheckBoxActionPerformed

    private void showSpriteCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showSpriteCheckBoxActionPerformed
        // TODO add your handling code here:
        AppData.getInstance().getCurrentMap().getPreviewRender().setShowSprite(showSpriteCheckBox.isSelected());
        AppData.getInstance().getCurrentMap().getPreviewRender().repaint();
    }//GEN-LAST:event_showSpriteCheckBoxActionPerformed

    private void savePreviewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savePreviewButtonActionPerformed
        // TODO add your handling code here:
        File f = new File(AppData.getInstance().getCurProject().getPath() + File.separator + "softdata" + File.separator + "snapshot");
        if (!f.exists()) {
            f.mkdirs();
        }
        SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String datetime = tempDate.format(new java.util.Date());
        File file = new File(f.getPath()
                + File.separator
                + AppData.getInstance().getCurrentMap().getName()
                + "_"
                + AppData.getInstance().getCurrentMap().getTileWidth() * AppData.getInstance().getCurrentMap().getWidth()
                + "x"
                + AppData.getInstance().getCurrentMap().getTileHeight() * AppData.getInstance().getCurrentMap().getHeight()
                + "_"
                + datetime
                + ".png");
        try {
            ImageIO.write(AppData.getInstance().getCurrentMap().getPreviewRender().getBufferedImage(), "png", file);
            JOptionPane.showMessageDialog(this, "生成快照成功！位置:" + f.getPath());
        } catch (IOException ex) {
//            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "生成快照失败！");
        }
    }//GEN-LAST:event_savePreviewButtonActionPerformed

    private void setScreenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setScreenButtonActionPerformed
        // TODO add your handling code here:
        try {
            Integer.parseInt(ScreenWTextField.getText());
            Integer.parseInt(ScreenHTextField.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "无效的屏幕大小！");
            return;
        }
        AppData.getInstance().getCurrentMap().getPreviewRender().setBound(Integer.parseInt(ScreenWTextField.getText()), Integer.parseInt(ScreenHTextField.getText()));
    }//GEN-LAST:event_setScreenButtonActionPerformed

    private void showScreenCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showScreenCheckBoxActionPerformed
        // TODO add your handling code here:
        AppData.getInstance().getCurrentMap().getPreviewRender().setShowScreen(showScreenCheckBox.isSelected());
        AppData.getInstance().getCurrentMap().getPreviewRender().repaint();
    }//GEN-LAST:event_showScreenCheckBoxActionPerformed

    private void showTileCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showTileCheckBoxActionPerformed
        // TODO add your handling code here:
        AppData.getInstance().getCurrentMap().getPreviewRender().setShowTile(showTileCheckBox.isSelected());
        AppData.getInstance().getCurrentMap().getPreviewRender().repaint();
    }//GEN-LAST:event_showTileCheckBoxActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                PreviewMapDialog dialog = new PreviewMapDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JTextField ScreenHTextField;
    private javax.swing.JTextField ScreenWTextField;
    private javax.swing.JButton closePreviewButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane previewScrollPane;
    private javax.swing.JButton savePreviewButton;
    private javax.swing.JButton setScreenButton;
    private javax.swing.JCheckBox showCollideCheckBox;
    private javax.swing.JCheckBox showScreenCheckBox;
    private javax.swing.JCheckBox showSpriteCheckBox;
    private javax.swing.JCheckBox showTileCheckBox;
    // End of variables declaration//GEN-END:variables
}