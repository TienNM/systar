/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * EventManagerDialog.java
 *
 * Created on 2011-3-25, 22:44:42
 */
package com.soyostar.dialog;

import com.soyostar.data.GlobalData;
import com.soyostar.model.map.SpriteLayer;
import com.soyostar.model.script.Npc;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Administrator
 */
public class EventManagerDialog extends javax.swing.JDialog {

    /** Creates new form EventManagerDialog */
    public EventManagerDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        initialize();
    }

    public EventManagerDialog() {
        initComponents();
        initialize();
    }

    private void initialize() {
        setModal(true);
        setLocationRelativeTo(null);
    }
    private Npc npc = new Npc();

    public Npc getNpc() {
        return npc;
    }

    public void setNpc(Npc npc) {
        this.npc = npc;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        eventPopupMenu = new javax.swing.JPopupMenu();
        insertMenuItem = new javax.swing.JMenuItem();
        removeMenuItem = new javax.swing.JMenuItem();
        okButton = new javax.swing.JButton();
        cancleButton = new javax.swing.JButton();
        applyButton = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        switchCheckBox = new javax.swing.JCheckBox();
        varCheckBox = new javax.swing.JCheckBox();
        switchComboBox = new javax.swing.JComboBox();
        varComboBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        upVarTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        playerImgPane = new javax.swing.JPanel(){
            public void paint(Graphics g){
                g.setColor(new Color(255,153,153));
                g.fillRect(0, 0, this.getWidth(), this.getHeight());
                if(npc.getImg()!=null){
                    g.drawImage(npc.getImg(), this.getWidth()/2-npc.getImg().getWidth(null)/2,
                        this.getHeight()/2-npc.getImg().getHeight(null)/2, null);
                }
            }
        }
        ;
        jPanel3 = new javax.swing.JPanel();
        upRadioButton = new javax.swing.JRadioButton();
        downRadioButton = new javax.swing.JRadioButton();
        leftRadioButton = new javax.swing.JRadioButton();
        rightRadioButton = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        typeComboBox = new javax.swing.JComboBox();
        speedComboBox = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        eventTable = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jcRadioButton = new javax.swing.JRadioButton();
        acRadioButton = new javax.swing.JRadioButton();
        jbRadioButton = new javax.swing.JRadioButton();
        abRadioButton = new javax.swing.JRadioButton();

        eventPopupMenu.setName("eventPopupMenu"); // NOI18N

        insertMenuItem.setText("插入");
        insertMenuItem.setName("insertMenuItem"); // NOI18N
        insertMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertMenuItemActionPerformed(evt);
            }
        });
        eventPopupMenu.add(insertMenuItem);

        removeMenuItem.setText("删除");
        removeMenuItem.setName("removeMenuItem"); // NOI18N
        eventPopupMenu.add(removeMenuItem);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance().getContext().getResourceMap(EventManagerDialog.class);
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

        applyButton.setText("应用");
        applyButton.setName("applyButton"); // NOI18N
        applyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyButtonActionPerformed(evt);
            }
        });

        jTabbedPane1.setName("jTabbedPane1"); // NOI18N

        jPanel4.setName("jPanel4"); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("事件出现条件"));
        jPanel1.setName("jPanel1"); // NOI18N

        switchCheckBox.setText("开关");
        switchCheckBox.setName("switchCheckBox"); // NOI18N
        switchCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                switchCheckBoxActionPerformed(evt);
            }
        });

        varCheckBox.setText("变量");
        varCheckBox.setName("varCheckBox"); // NOI18N
        varCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                varCheckBoxActionPerformed(evt);
            }
        });

        switchComboBox.setEnabled(false);
        switchComboBox.setFocusTraversalPolicyProvider(true);
        switchComboBox.setName("switchComboBox"); // NOI18N

        varComboBox.setEnabled(false);
        varComboBox.setName("varComboBox"); // NOI18N

        jLabel1.setText("值为");
        jLabel1.setName("jLabel1"); // NOI18N

        jLabel2.setText("为ON时");
        jLabel2.setName("jLabel2"); // NOI18N

        upVarTextField.setEnabled(false);
        upVarTextField.setName("upVarTextField"); // NOI18N

        jLabel3.setText("以上");
        jLabel3.setName("jLabel3"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(switchCheckBox)
                        .addGap(18, 18, 18)
                        .addComponent(switchComboBox, 0, 150, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(varCheckBox)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(upVarTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(varComboBox, 0, 150, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(switchCheckBox)
                    .addComponent(switchComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(varCheckBox)
                    .addComponent(varComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(upVarTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setText("角色图片：");
        jLabel4.setName("jLabel4"); // NOI18N

        playerImgPane.setBackground(new java.awt.Color(255, 153, 153));
        playerImgPane.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        playerImgPane.setName("playerImgPane"); // NOI18N
        playerImgPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                playerImgPaneMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout playerImgPaneLayout = new javax.swing.GroupLayout(playerImgPane);
        playerImgPane.setLayout(playerImgPaneLayout);
        playerImgPaneLayout.setHorizontalGroup(
            playerImgPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 286, Short.MAX_VALUE)
        );
        playerImgPaneLayout.setVerticalGroup(
            playerImgPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 93, Short.MAX_VALUE)
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("角色面向"));
        jPanel3.setName("jPanel3"); // NOI18N

        buttonGroup.add(upRadioButton);
        upRadioButton.setSelected(true);
        upRadioButton.setText("向上");
        upRadioButton.setName("upRadioButton"); // NOI18N
        upRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upRadioButtonActionPerformed(evt);
            }
        });

        buttonGroup.add(downRadioButton);
        downRadioButton.setText("向下");
        downRadioButton.setName("downRadioButton"); // NOI18N
        downRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downRadioButtonActionPerformed(evt);
            }
        });

        buttonGroup.add(leftRadioButton);
        leftRadioButton.setText("向左");
        leftRadioButton.setName("leftRadioButton"); // NOI18N
        leftRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leftRadioButtonActionPerformed(evt);
            }
        });

        buttonGroup.add(rightRadioButton);
        rightRadioButton.setText("向右");
        rightRadioButton.setName("rightRadioButton"); // NOI18N
        rightRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightRadioButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(upRadioButton)
                .addGap(18, 18, 18)
                .addComponent(downRadioButton)
                .addGap(18, 18, 18)
                .addComponent(leftRadioButton)
                .addGap(18, 18, 18)
                .addComponent(rightRadioButton)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(upRadioButton)
                    .addComponent(downRadioButton)
                    .addComponent(leftRadioButton)
                    .addComponent(rightRadioButton))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("移动规则"));
        jPanel2.setName("jPanel2"); // NOI18N

        jLabel5.setText("类型:");
        jLabel5.setName("jLabel5"); // NOI18N

        jLabel6.setText("速度:");
        jLabel6.setName("jLabel6"); // NOI18N

        typeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "固定", "随机", "接近" }));
        typeComboBox.setName("typeComboBox"); // NOI18N

        speedComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "快", "中", "慢" }));
        speedComboBox.setName("speedComboBox"); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(speedComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(typeComboBox, 0, 97, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(speedComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(typeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        eventTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "执行内容"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        eventTable.setComponentPopupMenu(eventPopupMenu);
        eventTable.setName("eventTable"); // NOI18N
        jScrollPane1.setViewportView(eventTable);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("事件开始条件"));
        jPanel5.setName("jPanel5"); // NOI18N

        buttonGroup1.add(jcRadioButton);
        jcRadioButton.setSelected(true);
        jcRadioButton.setText("接触串行");
        jcRadioButton.setName("jcRadioButton"); // NOI18N
        jcRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcRadioButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(acRadioButton);
        acRadioButton.setText("按键串行");
        acRadioButton.setName("acRadioButton"); // NOI18N
        acRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acRadioButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(jbRadioButton);
        jbRadioButton.setText("接触并行");
        jbRadioButton.setName("jbRadioButton"); // NOI18N
        jbRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRadioButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(abRadioButton);
        abRadioButton.setText("按键并行");
        abRadioButton.setName("abRadioButton"); // NOI18N
        abRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abRadioButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbRadioButton)
                    .addComponent(jcRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(acRadioButton, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(abRadioButton, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(33, 33, 33))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(acRadioButton)
                    .addComponent(jcRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(abRadioButton)
                    .addComponent(jbRadioButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(playerImgPane, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(playerImgPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(58, 58, 58))
        );

        jTabbedPane1.addTab("事件", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cancleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(applyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancleButton)
                    .addComponent(okButton)
                    .addComponent(applyButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private GlobalData data = GlobalData.getInstance();
    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        // TODO add your handling code here:

        if (data.getCurrentLayer() instanceof SpriteLayer) {
            SpriteLayer layer = (SpriteLayer) data.getCurrentLayer();
            layer.setNpcAt(data.getCurrentMap().getMapRender().mousePressLocation.x, data.getCurrentMap().getMapRender().mousePressLocation.y, npc);
        }
        dispose();
    }//GEN-LAST:event_okButtonActionPerformed

    private void cancleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancleButtonActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_cancleButtonActionPerformed

    private void applyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_applyButtonActionPerformed

    private void playerImgPaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playerImgPaneMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() >= 2) {
            CharacterImageDialog cid = new CharacterImageDialog(this, true);
            cid.setVisible(true);
        }

    }//GEN-LAST:event_playerImgPaneMouseClicked

    private void switchCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_switchCheckBoxActionPerformed
        // TODO add your handling code here:
        if (switchCheckBox.isSelected()) {
            switchComboBox.setEnabled(true);
        } else {
            switchComboBox.setEnabled(false);
        }

    }//GEN-LAST:event_switchCheckBoxActionPerformed

    private void varCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_varCheckBoxActionPerformed
        // TODO add your handling code here:
        if (varCheckBox.isSelected()) {
            varComboBox.setEnabled(true);
            upVarTextField.setEnabled(true);
        } else {
            varComboBox.setEnabled(false);
            upVarTextField.setEnabled(false);
        }

    }//GEN-LAST:event_varCheckBoxActionPerformed

    private void upRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upRadioButtonActionPerformed
        // TODO add your handling code here:
        npc.setFace(Npc.UP);
    }//GEN-LAST:event_upRadioButtonActionPerformed

    private void downRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downRadioButtonActionPerformed
        // TODO add your handling code here:
        npc.setFace(Npc.DOWN);
    }//GEN-LAST:event_downRadioButtonActionPerformed

    private void leftRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leftRadioButtonActionPerformed
        // TODO add your handling code here:
        npc.setFace(Npc.LEFT);
    }//GEN-LAST:event_leftRadioButtonActionPerformed

    private void rightRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rightRadioButtonActionPerformed
        // TODO add your handling code here:
        npc.setFace(Npc.RIGHT);
    }//GEN-LAST:event_rightRadioButtonActionPerformed

    private void jcRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcRadioButtonActionPerformed
        // TODO add your handling code here:
        npc.setType(Npc.CONTACTPARALLEL);
    }//GEN-LAST:event_jcRadioButtonActionPerformed

    private void acRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acRadioButtonActionPerformed
        // TODO add your handling code here:
        npc.setType(Npc.SERIALACCESS);
    }//GEN-LAST:event_acRadioButtonActionPerformed

    private void jbRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRadioButtonActionPerformed
        // TODO add your handling code here:
        npc.setType(Npc.PARALLELlKEY);
    }//GEN-LAST:event_jbRadioButtonActionPerformed

    private void abRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abRadioButtonActionPerformed
        // TODO add your handling code here:
        npc.setType(Npc.SERIALKEY);
    }//GEN-LAST:event_abRadioButtonActionPerformed
    private ScriptDialog sd;
    private void insertMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertMenuItemActionPerformed
        // TODO add your handling code here:
        if (sd == null) {
            sd = new ScriptDialog(this, true);
        }
        sd.setVisible(true);
    }//GEN-LAST:event_insertMenuItemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                EventManagerDialog dialog = new EventManagerDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JRadioButton abRadioButton;
    private javax.swing.JRadioButton acRadioButton;
    private javax.swing.JButton applyButton;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cancleButton;
    private javax.swing.JRadioButton downRadioButton;
    private javax.swing.JPopupMenu eventPopupMenu;
    private javax.swing.JTable eventTable;
    private javax.swing.JMenuItem insertMenuItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton jbRadioButton;
    private javax.swing.JRadioButton jcRadioButton;
    private javax.swing.JRadioButton leftRadioButton;
    private javax.swing.JButton okButton;
    public javax.swing.JPanel playerImgPane;
    private javax.swing.JMenuItem removeMenuItem;
    private javax.swing.JRadioButton rightRadioButton;
    private javax.swing.JComboBox speedComboBox;
    private javax.swing.JCheckBox switchCheckBox;
    private javax.swing.JComboBox switchComboBox;
    private javax.swing.JComboBox typeComboBox;
    private javax.swing.JRadioButton upRadioButton;
    private javax.swing.JTextField upVarTextField;
    private javax.swing.JCheckBox varCheckBox;
    private javax.swing.JComboBox varComboBox;
    // End of variables declaration//GEN-END:variables
}
