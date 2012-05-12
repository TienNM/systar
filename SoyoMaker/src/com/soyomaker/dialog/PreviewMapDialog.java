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
import com.soyomaker.render.PreviewRender;
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
        PreviewRender pr = AppData.getInstance().getCurrentMap().getPreviewRender();
//        pr.setShowScreen(true);
        pr.setShowCollide(false);
        pr.setShowSprite(true);
        pr.setShowTile(true);
        pr.setShowPressPoint(false);
        initComponents();
        initialize();
    }

    private void initialize() {
        setLocationRelativeTo(null);
        AppData.getInstance().getCurrentMap().getPreviewRender().updateUI();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        previewScrollPane = new javax.swing.JScrollPane();
        savePreviewButton = new javax.swing.JButton();
        closePreviewButton = new javax.swing.JButton();
        showSpriteCheckBox = new javax.swing.JCheckBox();
        showCollideCheckBox = new javax.swing.JCheckBox();
        showTileCheckBox = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance().getContext().getResourceMap(PreviewMapDialog.class);
        setTitle(resourceMap.getString("title")); // NOI18N

        previewScrollPane.setName("previewScrollPane"); // NOI18N
        previewScrollPane.setViewportView(AppData.getInstance().getCurrentMap().getPreviewRender());

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

        showSpriteCheckBox.setSelected(true);
        showSpriteCheckBox.setText("显示精灵");
        showSpriteCheckBox.setName("showSpriteCheckBox"); // NOI18N
        showSpriteCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showSpriteCheckBoxActionPerformed(evt);
            }
        });
        showSpriteCheckBox.setSelected(AppData.getInstance().getCurrentMap().getPreviewRender().isShowSprite());

        showCollideCheckBox.setText("显示碰撞");
        showCollideCheckBox.setName("showCollideCheckBox"); // NOI18N
        showCollideCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showCollideCheckBoxActionPerformed(evt);
            }
        });
        showCollideCheckBox.setSelected(AppData.getInstance().getCurrentMap().getPreviewRender().isShowCollide());

        showTileCheckBox.setText("显示瓷砖");
        showTileCheckBox.setName("showTileCheckBox"); // NOI18N
        showTileCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showTileCheckBoxActionPerformed(evt);
            }
        });
        showTileCheckBox.setSelected(AppData.getInstance().getCurrentMap().getPreviewRender().isShowTile());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(previewScrollPane, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 872, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(savePreviewButton)
                        .addGap(18, 18, 18)
                        .addComponent(showTileCheckBox)
                        .addGap(48, 48, 48)
                        .addComponent(showCollideCheckBox)
                        .addGap(57, 57, 57)
                        .addComponent(showSpriteCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 392, Short.MAX_VALUE)
                        .addComponent(closePreviewButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(previewScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(closePreviewButton)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(savePreviewButton)
                        .addComponent(showTileCheckBox)
                        .addComponent(showCollideCheckBox)
                        .addComponent(showSpriteCheckBox)))
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

    private void showTileCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showTileCheckBoxActionPerformed
        // TODO add your handling code here:
        AppData.getInstance().getCurrentMap().getPreviewRender().setShowTile(showTileCheckBox.isSelected());
        AppData.getInstance().getCurrentMap().getPreviewRender().repaint();
    }//GEN-LAST:event_showTileCheckBoxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closePreviewButton;
    private javax.swing.JScrollPane previewScrollPane;
    private javax.swing.JButton savePreviewButton;
    private javax.swing.JCheckBox showCollideCheckBox;
    private javax.swing.JCheckBox showSpriteCheckBox;
    private javax.swing.JCheckBox showTileCheckBox;
    // End of variables declaration//GEN-END:variables
}
