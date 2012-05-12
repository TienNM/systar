/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DirectSetPositionDialog.java
 *
 * Created on 2012-4-14, 17:56:07
 */
package com.soyomaker.dialog.event.gameperformance;

import com.soyomaker.AppData;
import com.soyomaker.model.map.Map;
import com.soyomaker.render.PreviewRender;
import com.soyomaker.render.PreviewRenderFactory;
import com.soyomaker.render.RenderListener;
import java.awt.Point;
import java.awt.event.ItemEvent;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class DirectSetPositionDialog extends javax.swing.JDialog implements RenderListener {

    /** Creates new form DirectSetPositionDialog
     * @param parent
     * @param modal 
     */
    public DirectSetPositionDialog(JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);

        java.util.Iterator it3 = AppData.getInstance().getCurProject().getMaps().entrySet().iterator();
        while (it3.hasNext()) {
            java.util.Map.Entry entry = (java.util.Map.Entry) it3.next();
            mapComboBox.addItem(((Map) entry.getValue()));
        }
    }

    /**
     *
     * @param p
     */
    public void focusPointChanged(Point p) {
        jLabel1.setText(
                "鼠标: " + p.y + "行," + p.x + "列");
    }

    /**
     *
     * @param p
     */
    public void pressPointChanged(Point p) {
        pr.repaint();
        pressPoint.x = p.x;
        pressPoint.y = p.y;
        jLabel4.setText("选中： " + pressPoint.y + "行，" + pressPoint.x + "列");
    }
    private PreviewRender pr = null;
    private Point pressPoint = new Point();

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mapComboBox = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        mapScrollPane = new javax.swing.JScrollPane();
        jLabel3 = new javax.swing.JLabel();
        faceComboBox = new javax.swing.JComboBox();
        okButton = new javax.swing.JButton();
        cancleButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        mapComboBox.setName("mapComboBox"); // NOI18N
        mapComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                mapComboBoxItemStateChanged(evt);
            }
        });

        jLabel2.setText("地图");
        jLabel2.setName("jLabel2"); // NOI18N

        jLabel1.setText("鼠标： 0行，0列");
        jLabel1.setName("jLabel1"); // NOI18N

        jLabel4.setText("选中： 0行，0列");
        jLabel4.setName("jLabel4"); // NOI18N

        mapScrollPane.setName("mapScrollPane"); // NOI18N

        jLabel3.setText("面向");
        jLabel3.setName("jLabel3"); // NOI18N

        faceComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "保持不变", "上", "下", "左", "右" }));
        faceComboBox.setName("faceComboBox"); // NOI18N

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
            .addGap(0, 753, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(mapScrollPane, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 733, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 189, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(faceComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(okButton)
                        .addGap(18, 18, 18)
                        .addComponent(cancleButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(mapComboBox, 0, 691, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 475, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(mapComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mapScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancleButton)
                    .addComponent(okButton)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(faceComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mapComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_mapComboBoxItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            Map map = (Map) mapComboBox.getSelectedItem();
            if (map != null) {
                pr = map.getPreviewRender();
                if (pr == null) {
                    pr = PreviewRenderFactory.createPreviewRender(map);
                }
                pr.addRenderListener(this);
//                pr.setShowScreen(false);
                pr.setShowCollide(false);
                pr.setShowSprite(true);
                pr.setShowTile(true);
                pr.setShowPressPoint(true);
                mapScrollPane.setViewportView(pr);
                pr.repaint();
            } else {
                mapScrollPane.setViewportView(null);
            }
        }
}//GEN-LAST:event_mapComboBoxItemStateChanged
    /**
     *
     */
    public class Position {

        /**
         *
         */
        public Map map = null;
        /**
         *
         */
        public int col = 0;
        /**
         *
         */
        public int row = 0;
        /**
         *
         */
        public int face = 0;
    }
    private Position position = null;

    /**
     *
     * @return
     */
    public Position getPosition() {
        return position;
    }
    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        // TODO add your handling code here:
        Map map = (Map) mapComboBox.getSelectedItem();
        if (map != null) {
            position = new Position();
            position.map = map;
            position.col = pressPoint.x;
            position.row = pressPoint.y;
            position.face = faceComboBox.getSelectedIndex();
//            System.out.println("map:" + map.getIndex());
//            System.out.println("col:" + pressPoint.x);
//            System.out.println("row:" + pressPoint.y);
//            System.out.println("face:" + faceComboBox.getSelectedIndex());
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "选择的地图不能为空", "警告", JOptionPane.WARNING_MESSAGE);
        }
}//GEN-LAST:event_okButtonActionPerformed

    private void cancleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancleButtonActionPerformed
        // TODO add your handling code here:
        dispose();
}//GEN-LAST:event_cancleButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancleButton;
    private javax.swing.JComboBox faceComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JComboBox mapComboBox;
    private javax.swing.JScrollPane mapScrollPane;
    private javax.swing.JButton okButton;
    // End of variables declaration//GEN-END:variables
}
