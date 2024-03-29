/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * chooseCharacterImageJDialog.java
 *
 * Created on 2011-3-25, 23:50:33
 */
package com.soyostar.dialog;

import com.soyostar.model.script.Npc;
import com.soyostar.project.Project;
import com.soyostar.util.Log;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;

/**
 *
 * @author Administrator
 */
public class CharacterImageDialog extends javax.swing.JDialog {

    /** Creates new form chooseCharacterImageJDialog */
    public CharacterImageDialog(EventManagerDialog parent, boolean modal) {
        super(parent, modal);
        emd = parent;
        init();
        initComponents();
        initialize();
    }
    private EventManagerDialog emd;
    private DefaultListModel listModel;

    private void init() {

        File file = new File(Project.getInstance().getPath() + File.separatorChar + "image" + File.separatorChar + "character");
        listModel = new DefaultListModel();
        if (file != null) {
            File[] files = file.listFiles();
            try {
                for (int i = 0, n = files.length; i < n; i++) {
                    if (files[i].getName().toLowerCase().endsWith(".png")) {
                        listModel.addElement(files[i].getName());
                        images.add(ImageIO.read(new File(files[i].getPath())));
                    }
                }
            } catch (IOException ex) {
                Log.getLogger(CharacterImageDialog.class).error("character img load error", ex);
            }
        }

    }

    private void initialize() {
        setLocationRelativeTo(null);
    }
    ArrayList<Image> images = new ArrayList<Image>();

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        imgPane = new javax.swing.JPanel(){
            public void paint(Graphics g){
                g.clearRect(0, 0, getWidth(),getHeight());
                if(imgList.getSelectedIndex()!=-1){

                    g.drawImage(images.get(imgList.getSelectedIndex()), 0, 0, null);
                }
            }
        }
        ;
        jScrollPane1 = new javax.swing.JScrollPane();
        imgList = new javax.swing.JList();
        okButton = new javax.swing.JButton();
        cancleButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance().getContext().getResourceMap(CharacterImageDialog.class);
        setTitle(resourceMap.getString("title")); // NOI18N
        setResizable(false);

        jSplitPane1.setName("jSplitPane1"); // NOI18N

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        imgPane.setName("imgPane"); // NOI18N

        javax.swing.GroupLayout imgPaneLayout = new javax.swing.GroupLayout(imgPane);
        imgPane.setLayout(imgPaneLayout);
        imgPaneLayout.setHorizontalGroup(
            imgPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 175, Short.MAX_VALUE)
        );
        imgPaneLayout.setVerticalGroup(
            imgPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 392, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(imgPane);

        jSplitPane1.setRightComponent(jScrollPane2);

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        imgList.setModel(listModel);
        imgList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        imgList.setName("imgList"); // NOI18N
        imgList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                imgListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(imgList);

        jSplitPane1.setLeftComponent(jScrollPane1);

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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cancleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okButton)
                    .addComponent(cancleButton))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        // TODO add your handling code here:
        Npc npc = emd.getNpc();
        if (imgList.getSelectedIndex() != -1) {
            try {
                npc.setImgPath((String) listModel.get(imgList.getSelectedIndex()));
                emd.playerImgPane.repaint();
            } catch (IOException ex) {
                Log.getLogger(this.getClass()).error("npc image loader:" + (String) listModel.get(imgList.getSelectedIndex()), ex);
            }
        }
        
        dispose();
    }//GEN-LAST:event_okButtonActionPerformed

    private void cancleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancleButtonActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_cancleButtonActionPerformed

    private void imgListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_imgListValueChanged
        // TODO add your handling code here:
        //System.out.println(imgList.getSelectedIndex());
        imgPane.repaint();
    }//GEN-LAST:event_imgListValueChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                CharacterImageDialog dialog = new CharacterImageDialog(null, true);
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
    private javax.swing.JList imgList;
    private javax.swing.JPanel imgPane;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JButton okButton;
    // End of variables declaration//GEN-END:variables
}
