/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * NewProjectDialog.java
 *
 * Created on 2011-3-17, 20:03:18
 */
package com.soyostar.dialog;

import com.soyostar.proxy.SoftProxy;
import com.soyostar.project.Project;
import com.soyostar.project.ProjectManager;
import com.soyostar.util.FileUtil;
import java.io.File;
import com.soyostar.infomation.SoftInformation;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class NewProjectDialog extends javax.swing.JDialog {

    /** Creates new form NewProjectDialog
     * @param parent
     * @param modal  
     */
    public NewProjectDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        initialize();
    }

    private void initialize() {
        setLocationRelativeTo(null);
        getRootPane().setDefaultButton(okButton);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        projectFileChooser = new javax.swing.JFileChooser();
        okButton = new javax.swing.JButton();
        cancleButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        projectNameTextField = new javax.swing.JTextField();
        pathTextField = new javax.swing.JTextField();
        pathButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        projectFileChooser.setName("projectFileChooser"); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance().getContext().getResourceMap(NewProjectDialog.class);
        setTitle(resourceMap.getString("title")); // NOI18N
        setResizable(false);

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

        jLabel1.setText("项目名称");
        jLabel1.setName("jLabel1"); // NOI18N

        projectNameTextField.setName("projectNameTextField"); // NOI18N

        pathTextField.setName("pathTextField"); // NOI18N

        pathButton.setText("...");
        pathButton.setName("pathButton"); // NOI18N
        pathButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pathButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("项目路径");
        jLabel2.setName("jLabel2"); // NOI18N

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
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(pathTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(pathButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(projectNameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
                        .addComponent(cancleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(projectNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pathTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(pathButton))
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

        if (projectNameTextField.getText().equals("")) {
            JOptionPane.showMessageDialog(this,
                "项目名不能为空！");
            return;
        }
        if (pathTextField.getText().equals("")) {
            JOptionPane.showMessageDialog(this,
                "项目路径不能为空！");
            return;
        }
        if (SoftProxy.getInstance().getCurProject() != null) {
            data.getMainFrame().closeProject();
        }
        File f = new java.io.File(pathTextField.getText() + File.separatorChar + projectNameTextField.getText());// 根据输入的路径新建一个文件
        if (!f.exists()) {
            f.mkdirs();// 如果此文件夹不存在则创建此文件夹
        }
        Project project = new Project();
        project.addProjectChangeListener(data.getMainFrame());
        project.setName(projectNameTextField.getText());
        System.out.println(f.getPath());
        project.setPath(f.getPath());
        project.setSoftVersion(SoftInformation.majorVersion + "." + SoftInformation.minorVersion);
        FileUtil.copyDirectiory("res", project.getPath());
//        project.removeAllMap();
        SoftProxy.getInstance().setCurProject(project);
//        DataManager.getInstance().init(f.getPath());

        if (ProjectManager.create()) {
            data.getMainFrame().tscd = new TileSetCrossDialog(data.getMainFrame(), true);
            data.getMainFrame().ded = new DataEditorDialog(data.getMainFrame(), true);
            data.getMainFrame().updateRecent(project.getPath());
            data.getMainFrame().setTitle(SoftInformation.chineseName + " - " + project.getName());
            data.getMainFrame().stateLabel.setText("");

        } else {
            JOptionPane.showMessageDialog(data.getMainFrame(), "项目文件生成异常，请检查路径！", "警告", JOptionPane.WARNING_MESSAGE);//弹出提示
        }
        dispose();
    }//GEN-LAST:event_okButtonActionPerformed

    private void cancleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancleButtonActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_cancleButtonActionPerformed

    private void pathButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pathButtonActionPerformed
        // TODO add your handling code here:
        projectFileChooser.setCurrentDirectory(new java.io.File("."));// 设置当前目录
        projectFileChooser.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);// 设置只能选择文件夹
        projectFileChooser.showOpenDialog(this);// 显示“打开”文件对话框
        java.io.File file = projectFileChooser.getSelectedFile();
        if (file != null) {
            pathTextField.setText(file.getPath());
        }
    }//GEN-LAST:event_pathButtonActionPerformed
    private SoftProxy data = SoftProxy.getInstance();

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                NewProjectDialog dialog = new NewProjectDialog(new java.awt.Frame(), true);
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
    private javax.swing.JButton okButton;
    private javax.swing.JButton pathButton;
    private javax.swing.JTextField pathTextField;
    private javax.swing.JFileChooser projectFileChooser;
    private javax.swing.JTextField projectNameTextField;
    // End of variables declaration//GEN-END:variables
}
