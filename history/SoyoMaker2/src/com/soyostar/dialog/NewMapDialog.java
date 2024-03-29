/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * NewMapDialog.java
 *
 * Created on 2011-3-19, 23:55:04
 */
package com.soyostar.dialog;

import com.soyostar.proxy.SoftProxy;
import com.soyostar.model.map.CollideLayer;
import com.soyostar.model.map.Map;
import com.soyostar.model.map.SpriteLayer;
import com.soyostar.model.map.TileLayer;
import com.soyostar.project.Project;
import com.soyostar.render.MapRenderFactory;
//import com.soyostar.render.PreviewRenderFactory;
import com.soyostar.render.PreviewRenderFactory;
import java.io.File;
import java.util.Enumeration;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

/**
 *
 * @author Administrator
 */
public class NewMapDialog extends javax.swing.JDialog {

    /** Creates new form NewMapDialog
     * @param parent 
     * @param modal 
     */
    public NewMapDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        initialize();
    }

    private void init() {
        File file = new File(SoftProxy.getInstance().getCurProject().getPath() + File.separatorChar + "audio" + File.separatorChar + "music");
        if (file != null) {
            File[] files = file.listFiles();
            for (int i = 0, n = files.length; i < n; i++) {
                musicComboBox.addItem(files[i].getName());
            }
        }
    }

    private void initialize() {
        setLocationRelativeTo(null);
        getRootPane().setDefaultButton(okButton);
        init();
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
        mapNameTextField = new javax.swing.JTextField();
        mapHeightTextField = new javax.swing.JTextField();
        tileHeightTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        mapWidthTextField = new javax.swing.JTextField();
        tileWidthTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        mapTypeComboBox = new javax.swing.JComboBox();
        okButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        musicComboBox = new javax.swing.JComboBox();
        cancleButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance().getContext().getResourceMap(NewMapDialog.class);
        setTitle(resourceMap.getString("title")); // NOI18N
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setName("jPanel1"); // NOI18N

        mapNameTextField.setName("mapNameTextField"); // NOI18N

        mapHeightTextField.setText("32");
        mapHeightTextField.setName("mapHeightTextField"); // NOI18N

        tileHeightTextField.setText("32");
        tileHeightTextField.setName("tileHeightTextField"); // NOI18N

        jLabel1.setText("名称");
        jLabel1.setName("jLabel1"); // NOI18N

        jLabel4.setText("Map高");
        jLabel4.setName("jLabel4"); // NOI18N

        jLabel5.setText("Tile高");
        jLabel5.setName("jLabel5"); // NOI18N

        mapWidthTextField.setText("32");
        mapWidthTextField.setName("mapWidthTextField"); // NOI18N

        tileWidthTextField.setText("32");
        tileWidthTextField.setName("tileWidthTextField"); // NOI18N

        jLabel2.setText("Map宽");
        jLabel2.setName("jLabel2"); // NOI18N

        jLabel3.setText("Tile宽");
        jLabel3.setName("jLabel3"); // NOI18N

        mapTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "正视角地图" }));
        mapTypeComboBox.setName("mapTypeComboBox"); // NOI18N

        okButton.setText("确定");
        okButton.setName("okButton"); // NOI18N
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        jLabel6.setText("视角");
        jLabel6.setName("jLabel6"); // NOI18N

        jLabel7.setText("背景音乐");
        jLabel7.setName("jLabel7"); // NOI18N

        musicComboBox.setName("musicComboBox"); // NOI18N

        cancleButton.setText("取消");
        cancleButton.setName("cancleButton"); // NOI18N
        cancleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancleButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(mapTypeComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(musicComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(mapNameTextField)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tileWidthTextField)
                                    .addComponent(mapWidthTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(mapHeightTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tileHeightTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(okButton)
                        .addGap(37, 37, 37)
                        .addComponent(cancleButton)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(mapNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(mapWidthTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mapHeightTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tileWidthTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tileHeightTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(musicComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mapTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okButton)
                    .addComponent(cancleButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        // TODO add your handling code here:

        if (mapNameTextField.getText().equals("")) {
            JOptionPane.showMessageDialog(this,
                "地图名不能为空！");
            return;
        }
        String mapName = mapNameTextField.getText();
        if (mapWidthTextField.getText().equals("")) {
            JOptionPane.showMessageDialog(this,
                "地图宽度不能为空！");
            return;
        }
        int mapW = Integer.parseInt(mapWidthTextField.getText());

        if (mapHeightTextField.getText().equals("")) {
            JOptionPane.showMessageDialog(this,
                "地图高度不能为空！");
            return;
        }
        int mapH = Integer.parseInt(mapHeightTextField.getText());

        if (tileWidthTextField.getText().equals("")) {
            JOptionPane.showMessageDialog(this,
                "单元格宽度不能为空！");
            return;
        }
        int tileW = Integer.parseInt(tileWidthTextField.getText());

        if (tileHeightTextField.getText().equals("")) {
            JOptionPane.showMessageDialog(this,
                "单元格高度不能为空！");
            return;
        }
        int tileH = Integer.parseInt(tileHeightTextField.getText());
        String mapTypeString = (String) mapTypeComboBox.getSelectedItem();
        String musicName = (String) musicComboBox.getSelectedItem() == null ? "" : (String) musicComboBox.getSelectedItem();
        Map map = new Map();
        map.setName(mapName);
        map.setMusicName(musicName);
        map.setWidth(mapW);
        map.setHeight(mapH);
        map.setTileWidth(tileW);
        map.setTileHeight(tileH);
        map.setMapType(mapTypeString);
        map.addMapChangeListener(data.getMainFrame());
        MapRenderFactory.createMapRender(map);
        PreviewRenderFactory.createPreviewRender(map);
        //图层数至少为一层
        TileLayer tLayer = new TileLayer(map, mapW, mapH);
        tLayer.addLayerChangeListener(data.getMainFrame());
        tLayer.setName("瓷砖层0");
        SpriteLayer sLayer = new SpriteLayer(map, mapW, mapH);
        sLayer.addLayerChangeListener(data.getMainFrame());
        sLayer.setName("精灵层");
        CollideLayer cLayer = new CollideLayer(map, mapW, mapH);
        cLayer.addLayerChangeListener(data.getMainFrame());
        cLayer.setName("碰撞层");
        map.addLayer(tLayer);
        map.addLayer(cLayer);
        map.addLayer(sLayer);

        SoftProxy.getInstance().getCurProject().addMap(map);

        DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(map);
        //将新节点插入到指定位置
        if (data.getMainFrame().mapTree.getSelectNode() == null) {
            ((DefaultMutableTreeNode) data.getMainFrame().mapTree.getModel().getRoot()).add(newNode);
            ((DefaultTreeModel) data.getMainFrame().mapTree.getModel()).reload((DefaultMutableTreeNode) data.getMainFrame().mapTree.getModel().getRoot());
        } else {
            data.getMainFrame().mapTree.getSelectNode().add(newNode);
            ((DefaultTreeModel) data.getMainFrame().mapTree.getModel()).reload(data.getMainFrame().mapTree.getSelectNode());
        }
        data.getMainFrame().mapTree.expandPath(data.getMainFrame().mapTree.getSelectionPath());
        data.getMainFrame().mapTree.setSelectionPath(new TreePath(((DefaultTreeModel) data.getMainFrame().mapTree.getModel()).getPathToRoot(newNode)));
        //设置维持当前的选择路径
        data.getMainFrame().mapTree.setExpandsSelectedPaths(true);
        dispose();
    }//GEN-LAST:event_okButtonActionPerformed

    private void cancleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancleButtonActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_cancleButtonActionPerformed
    private SoftProxy data = SoftProxy.getInstance();

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                NewMapDialog dialog = new NewMapDialog(new java.awt.Frame(), true);
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
    private javax.swing.JButton cancleButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField mapHeightTextField;
    private javax.swing.JTextField mapNameTextField;
    private javax.swing.JComboBox mapTypeComboBox;
    private javax.swing.JTextField mapWidthTextField;
    private javax.swing.JComboBox musicComboBox;
    private javax.swing.JButton okButton;
    private javax.swing.JTextField tileHeightTextField;
    private javax.swing.JTextField tileWidthTextField;
    // End of variables declaration//GEN-END:variables
}
