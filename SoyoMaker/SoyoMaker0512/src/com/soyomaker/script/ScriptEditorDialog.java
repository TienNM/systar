/*
 * Copyright 2010-2011 Soyostar Software, Inc. All rights reserved.
 */
package com.soyomaker.script;

import com.soyomaker.AppData;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.swing.undo.UndoManager;

/**
 *
 * @author Administrator
 */
public class ScriptEditorDialog extends javax.swing.JDialog {

    /** Creates new form ScriptManagerDialog
     * @param modal
     */
    public ScriptEditorDialog(boolean modal) {
        setModal(modal);
        initComponents();
        initialize();
    }

    private void addScripts(File file) {
        fileList.add(file);
        if (file.isDirectory()) {
            //先加入文件
            for (int i = 0; i < file.listFiles().length; i++) {
                if (file.listFiles()[i].isFile()) {
                    //只加载以.smlua结尾的文件
                    if (file.listFiles()[i].getName().endsWith(".smlua")) {
                        addScripts(file.listFiles()[i]);
                    }
                }
            }
            //再加入文件夹
            for (int i = 0; i < file.listFiles().length; i++) {
                //不加载.svn结尾的文件夹及其中文件
                if (file.listFiles()[i].isDirectory() && !file.listFiles()[i].getName().endsWith(".svn")) {
                    addScripts(file.listFiles()[i]);
                }
            }
        }
    }
    private ArrayList<File> fileList = new ArrayList<File>();
    private HashMap<File, String> scriptFiles = new HashMap<File, String>();

    private void initialize() {
        setLocationRelativeTo(null);
//        try {
//            KeyWord.KEYWORDS = config.getValue("KeyWord").split(",");
//            KeyWord.COMMENT = config.getValue("Comment");
//        } catch (Exception e) {
//            System.out.println("启用默认配置");
//            KeyWord.KEYWORDS = KeyWord.JAVAKEYWORDS;//默认采用java关键字
        KeyWord.KEYWORDS = KeyWord.LUAKEYWORDS;//默认采用lua关键字
        KeyWord.COMMENT = KeyWord.LUACOMMENT;
//        }
        mainTextPanel.getDocument().addDocumentListener(new DocumentListener() {

            public void removeUpdate(DocumentEvent arg0) {
                if (scriptList.getSelectedIndex() >= 0 && scriptList.getSelectedIndex() < fileList.size() - 1) {
                    scriptFiles.put(fileList.get(scriptList.getSelectedIndex()), mainTextPanel.getText());
                }
            }

            public void insertUpdate(DocumentEvent arg0) {
                if (scriptList.getSelectedIndex() >= 0 && scriptList.getSelectedIndex() < fileList.size() - 1) {
                    scriptFiles.put(fileList.get(scriptList.getSelectedIndex()), mainTextPanel.getText());
                }
            }

            public void changedUpdate(DocumentEvent arg0) {
            }
        });
        File sdir = new File(AppData.getInstance().getCurProject().getPath() + File.separator + "smscript");
        if (!sdir.exists()) {
            sdir.mkdirs();
        }
        addScripts(sdir);
        scriptList.setModel(new javax.swing.AbstractListModel() {

            public int getSize() {
                return fileList.size();
            }

            public Object getElementAt(int i) {
                if (fileList.get(i).isDirectory()) {
                    return "▼" + fileList.get(i).getName();
                } else {
                    return fileList.get(i).getName();
                }
            }
        });
    }
    /**
     *
     * @return
     */
    public String getContent() {
        return mainTextPanel.getText();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainTextPanelPop = new javax.swing.JPopupMenu();
        undoPopItem = new javax.swing.JMenuItem();
        redoPopItem = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        cutPopItem = new javax.swing.JMenuItem();
        copyPopItem = new javax.swing.JMenuItem();
        pastePopItem = new javax.swing.JMenuItem();
        removePopItem = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        allPopItem = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        commentPopItem = new javax.swing.JMenuItem();
        uncommentPopItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        findPopMenuItem = new javax.swing.JMenuItem();
        dirPopupMenu = new javax.swing.JPopupMenu();
        addScriptMenuItem = new javax.swing.JMenuItem();
        filePopupMenu = new javax.swing.JPopupMenu();
        removeScriptMenuItem = new javax.swing.JMenuItem();
        posLabel = new javax.swing.JLabel();
        cancleButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();
        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        lineNumberLabel = new javax.swing.JLabel(){
            public void paint(Graphics g){
                Graphics2D g2d = (Graphics2D)g;
                g2d.setColor(this.getBackground());
                g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
                Element map = mainTextPanel.getDocument().getDefaultRootElement();
                g2d.setFont(new Font("DialogInput", Font.PLAIN, 16));
                g2d.setColor(Color.BLACK);
                for(int i = 0,n = map.getElementCount();i<n;i++){
                    String s = "" + (i+1);
                    g.drawString(s, 20 - s.length() * 6, 22 + i * 25);
                }
            }
        }
        ;
        mainTextPanel = new javax.swing.JTextPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        scriptList = new javax.swing.JList();

        mainTextPanelPop.setName("mainTextPanelPop"); // NOI18N

        undoPopItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        undoPopItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/soyomaker/resources/menu_undo.png"))); // NOI18N
        undoPopItem.setText("撤销");
        undoPopItem.setName("undoPopItem"); // NOI18N
        undoPopItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undoPopItemActionPerformed(evt);
            }
        });
        mainTextPanelPop.add(undoPopItem);

        redoPopItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_MASK));
        redoPopItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/soyomaker/resources/menu_redo.png"))); // NOI18N
        redoPopItem.setText("重做");
        redoPopItem.setName("redoPopItem"); // NOI18N
        redoPopItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redoPopItemActionPerformed(evt);
            }
        });
        mainTextPanelPop.add(redoPopItem);

        jSeparator2.setName("jSeparator2"); // NOI18N
        mainTextPanelPop.add(jSeparator2);

        cutPopItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        cutPopItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/soyomaker/resources/menu_cut.png"))); // NOI18N
        cutPopItem.setText("剪切");
        cutPopItem.setName("cutPopItem"); // NOI18N
        cutPopItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cutPopItemActionPerformed(evt);
            }
        });
        mainTextPanelPop.add(cutPopItem);

        copyPopItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        copyPopItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/soyomaker/resources/menu_copy.png"))); // NOI18N
        copyPopItem.setText("复制");
        copyPopItem.setName("copyPopItem"); // NOI18N
        copyPopItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyPopItemActionPerformed(evt);
            }
        });
        mainTextPanelPop.add(copyPopItem);

        pastePopItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        pastePopItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/soyomaker/resources/menu_paste.png"))); // NOI18N
        pastePopItem.setText("粘贴");
        pastePopItem.setName("pastePopItem"); // NOI18N
        pastePopItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pastePopItemActionPerformed(evt);
            }
        });
        mainTextPanelPop.add(pastePopItem);

        removePopItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/soyomaker/resources/menu_remove.png"))); // NOI18N
        removePopItem.setText("删除");
        removePopItem.setName("removePopItem"); // NOI18N
        removePopItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removePopItemActionPerformed(evt);
            }
        });
        mainTextPanelPop.add(removePopItem);

        jSeparator4.setName("jSeparator4"); // NOI18N
        mainTextPanelPop.add(jSeparator4);

        allPopItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        allPopItem.setText("全选");
        allPopItem.setName("allPopItem"); // NOI18N
        allPopItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allPopItemActionPerformed(evt);
            }
        });
        mainTextPanelPop.add(allPopItem);

        jSeparator7.setName("jSeparator7"); // NOI18N
        mainTextPanelPop.add(jSeparator7);

        commentPopItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/soyomaker/resources/menu_comment.png"))); // NOI18N
        commentPopItem.setText("注释");
        commentPopItem.setName("commentPopItem"); // NOI18N
        commentPopItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commentPopItemActionPerformed(evt);
            }
        });
        mainTextPanelPop.add(commentPopItem);

        uncommentPopItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/soyomaker/resources/menu_uncomment.png"))); // NOI18N
        uncommentPopItem.setText("取消注释");
        uncommentPopItem.setName("uncommentPopItem"); // NOI18N
        uncommentPopItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uncommentPopItemActionPerformed(evt);
            }
        });
        mainTextPanelPop.add(uncommentPopItem);

        jSeparator1.setName("jSeparator1"); // NOI18N
        mainTextPanelPop.add(jSeparator1);

        findPopMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        findPopMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/soyomaker/resources/menu_find.png"))); // NOI18N
        findPopMenuItem.setText("查找");
        findPopMenuItem.setName("findPopMenuItem"); // NOI18N
        findPopMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findPopMenuItemActionPerformed(evt);
            }
        });
        mainTextPanelPop.add(findPopMenuItem);

        dirPopupMenu.setName("dirPopupMenu"); // NOI18N

        addScriptMenuItem.setText("新建脚本");
        addScriptMenuItem.setName("addScriptMenuItem"); // NOI18N
        addScriptMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addScriptMenuItemActionPerformed(evt);
            }
        });
        dirPopupMenu.add(addScriptMenuItem);

        filePopupMenu.setName("filePopupMenu"); // NOI18N

        removeScriptMenuItem.setText("删除脚本");
        removeScriptMenuItem.setName("removeScriptMenuItem"); // NOI18N
        removeScriptMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeScriptMenuItemActionPerformed(evt);
            }
        });
        filePopupMenu.add(removeScriptMenuItem);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance().getContext().getResourceMap(ScriptEditorDialog.class);
        setTitle(resourceMap.getString("title")); // NOI18N

        posLabel.setText("行：1 列：1");
        posLabel.setName("posLabel"); // NOI18N

        cancleButton.setText("取消");
        cancleButton.setName("cancleButton"); // NOI18N
        cancleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancleButtonActionPerformed(evt);
            }
        });

        okButton.setText("保存");
        okButton.setName("okButton"); // NOI18N
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        jSplitPane1.setResizeWeight(0.15);
        jSplitPane1.setName("jSplitPane1"); // NOI18N
        jSplitPane1.setOneTouchExpandable(true);

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        jPanel2.setName("jPanel2"); // NOI18N

        lineNumberLabel.setName("lineNumberLabel"); // NOI18N
        lineNumberLabel.setOpaque(true);

        mainTextPanel.setComponentPopupMenu(mainTextPanelPop);
        mainTextPanel.setName("mainTextPanel"); // NOI18N
        hlw.setHightLight(mainTextPanel);
        mainTextPanel.getStyledDocument().addUndoableEditListener(um);
        mainTextPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mainTextPanelMouseClicked(evt);
            }
        });
        mainTextPanel.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                mainTextPanelCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(lineNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainTextPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainTextPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
            .addComponent(lineNumberLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(jPanel2);

        jSplitPane1.setRightComponent(jScrollPane2);

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        scriptList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        scriptList.setName("scriptList"); // NOI18N
        scriptList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                scriptListMouseReleased(evt);
            }
        });
        scriptList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                scriptListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(scriptList);

        jSplitPane1.setLeftComponent(jScrollPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(posLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 646, Short.MAX_VALUE)
                .addComponent(okButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cancleButton)
                .addContainerGap())
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 846, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancleButton)
                    .addComponent(okButton)
                    .addComponent(posLabel))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mainTextPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mainTextPanelMouseClicked
        // TODO add your handling code here:
        HighLightCurrentLine.install(mainTextPanel);
    }//GEN-LAST:event_mainTextPanelMouseClicked
    private void cut() {
        try {
            editor.cut(mainTextPanel, mainTextPanel.getStyledDocument());
        } catch (BadLocationException ex) {
            ex.printStackTrace();
        }
    }

    private void copy() {
        try {
            editor.copy(mainTextPanel, mainTextPanel.getStyledDocument());
        } catch (BadLocationException ex) {
            ex.printStackTrace();
        }
    }

    private void paste() {
        try {
            editor.paste(mainTextPanel, mainTextPanel.getStyledDocument());
        } catch (BadLocationException ex) {
            ex.printStackTrace();
        }
    }

    private int getLineOfOffset(int offset) throws BadLocationException {
        Document doc = mainTextPanel.getDocument();
        if (offset < 0) {
            throw new BadLocationException("Can 't   translate   offset   to   line ", -1);
        } else if (offset > doc.getLength()) {
            throw new BadLocationException("Can 't   translate   offset   to   line ", doc.getLength() + 1);
        } else {
            Element map = mainTextPanel.getDocument().getDefaultRootElement();
            return map.getElementIndex(offset);
        }
    }

    private int getLineStartOffset(int line) throws BadLocationException {
        Element map = mainTextPanel.getDocument().getDefaultRootElement();
        if (line < 0) {
            throw new BadLocationException("Negative   line ", -1);
        } else if (line >= map.getElementCount()) {
            throw new BadLocationException("No   such   line ", mainTextPanel.getDocument().getLength() + 1);
        } else {
            Element lineElem = map.getElement(line);
            return lineElem.getStartOffset();
        }
    }

    private int getLineEndOffset(int line) throws BadLocationException {
        Element map = mainTextPanel.getDocument().getDefaultRootElement();
        if (line < 0) {
            throw new BadLocationException("Negative   line ", -1);
        } else if (line >= map.getElementCount()) {
            throw new BadLocationException("No   such   line ", mainTextPanel.getDocument().getLength() + 1);
        } else {
            Element lineElem = map.getElement(line);
            return lineElem.getEndOffset();
        }
    }

    private void undoPopItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undoPopItemActionPerformed
        // TODO add your handling code here:
        undoredo.undo();
    }//GEN-LAST:event_undoPopItemActionPerformed

    private void redoPopItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redoPopItemActionPerformed
        // TODO add your handling code here:
        undoredo.redo();
    }//GEN-LAST:event_redoPopItemActionPerformed

    private void cutPopItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cutPopItemActionPerformed
        // TODO add your handling code here:
        cut();
    }//GEN-LAST:event_cutPopItemActionPerformed

    private void copyPopItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyPopItemActionPerformed
        // TODO add your handling code here:
        copy();
    }//GEN-LAST:event_copyPopItemActionPerformed

    private void pastePopItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pastePopItemActionPerformed
        // TODO add your handling code here:
        paste();
    }//GEN-LAST:event_pastePopItemActionPerformed

    private void removePopItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removePopItemActionPerformed
        // TODO add your handling code here:
        remove();

    }//GEN-LAST:event_removePopItemActionPerformed

    private void allPopItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allPopItemActionPerformed
        // TODO add your handling code here:
        try {
            editor.selectAll(mainTextPanel, mainTextPanel.getStyledDocument());
        } catch (BadLocationException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_allPopItemActionPerformed
    private int curLine = 0;
    private int row = 0, col = 0;
    private void mainTextPanelCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_mainTextPanelCaretUpdate
        int dot = evt.getDot();
        lineNumberLabel.repaint();
        try {
            row = getLineOfOffset(dot);
            col = dot - getLineStartOffset(row);
            curLine = getLineStartOffset(row);
            posLabel.setText("行：" + (row + 1) + " 列：" + (col + 1) + "");
        } catch (BadLocationException Ex) {
            Ex.printStackTrace();
        }
    }//GEN-LAST:event_mainTextPanelCaretUpdate
    SearchDialog sd;
    private void commentPopItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commentPopItemActionPerformed
        // TODO add your handling code here:
        comment();
    }//GEN-LAST:event_commentPopItemActionPerformed

    private void uncommentPopItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uncommentPopItemActionPerformed
        // TODO add your handling code here:
        uncomment();
    }//GEN-LAST:event_uncommentPopItemActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        // TODO add your handling code here:
        java.util.Iterator it = scriptFiles.entrySet().iterator();
        while (it.hasNext()) {
            PrintWriter pw = null;
            try {
                java.util.Map.Entry entry = (java.util.Map.Entry) it.next();
                File f = (File) entry.getKey();
                if (f.isFile() && f.canWrite()) {
                    pw = new PrintWriter((File) entry.getKey(), "UTF-8");
                    pw.write(entry.getValue().toString());
                    pw.flush();
                }
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (UnsupportedEncodingException ex) {
                ex.printStackTrace();
            } finally {
                if (pw != null) {
                    pw.close();
                }
            }
        }
        dispose();
    }//GEN-LAST:event_okButtonActionPerformed

    private void cancleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancleButtonActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_cancleButtonActionPerformed
    private SearchDialog sdd;
    private void findPopMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findPopMenuItemActionPerformed
        // TODO add your handling code here:
        if (sdd == null) {
            sdd = new SearchDialog(this);
        }
        sdd.setVisible(true);
    }//GEN-LAST:event_findPopMenuItemActionPerformed

    private void scriptListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_scriptListValueChanged
        // TODO add your handling code here:
        if (scriptList.getSelectedIndex() >= 0 && scriptList.getSelectedIndex() < fileList.size() - 1) {
            File selFile = fileList.get(scriptList.getSelectedIndex());
            if (selFile.isFile()) {
                if (scriptFiles.containsKey(selFile)) {
                    mainTextPanel.setText(scriptFiles.get(selFile));
                    mainTextPanel.setCaretPosition(0);
                } else {
                    try {
                        InputStream is = new FileInputStream(selFile);
                        String line;
                        BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                        StringBuilder buffer = new StringBuilder();
                        line = reader.readLine();
                        while (line != null) {
                            buffer.append(line);
                            buffer.append("\r\n");
                            line = reader.readLine();
                        }
                        reader.close();
                        is.close();
                        scriptFiles.put(selFile, buffer.toString());
                        mainTextPanel.setText(buffer.toString());
                        mainTextPanel.setCaretPosition(0);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            } else {
                mainTextPanel.setText("");
            }
        }
    }//GEN-LAST:event_scriptListValueChanged

    private void removeScriptMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeScriptMenuItemActionPerformed
        // TODO add your handling code here:
        if (scriptList.getSelectedIndex() >= 0 && scriptList.getSelectedIndex() < fileList.size() - 1) {
            File r = fileList.get(scriptList.getSelectedIndex());
            scriptFiles.remove(r);
            fileList.remove(scriptList.getSelectedIndex());
            r.delete();
            scriptList.updateUI();
        }
    }//GEN-LAST:event_removeScriptMenuItemActionPerformed

    private void addScriptMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addScriptMenuItemActionPerformed
        // TODO add your handling code here:
        if (scriptList.getSelectedIndex() >= 0 && scriptList.getSelectedIndex() < fileList.size() - 1) {
            AddScriptDialog asd = new AddScriptDialog(this, true);
            asd.setVisible(true);
            File r = fileList.get(scriptList.getSelectedIndex());
            if (r.isDirectory() && !asd.getScriptName().equals("")) {
                File f = new File(r.getAbsolutePath() + File.separator + asd.getScriptName() + ".smlua");
                try {
                    f.createNewFile();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                fileList.add(scriptList.getSelectedIndex() + 1, f);
                scriptFiles.put(f, "");
                scriptList.updateUI();
            }
        }
    }//GEN-LAST:event_addScriptMenuItemActionPerformed

    private void scriptListMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scriptListMouseReleased
        // TODO add your handling code here:
        if (evt.isPopupTrigger()) {
            if (scriptList.getSelectedIndex() >= 0 && scriptList.getSelectedIndex() < fileList.size() - 1) {
                File selected = fileList.get(scriptList.getSelectedIndex());
                if (selected.isDirectory()) {
                    dirPopupMenu.show(evt.getComponent(), evt.getX(), evt.getY());
                } else {
                    filePopupMenu.show(evt.getComponent(), evt.getX(), evt.getY());
                }
            }
        }
    }//GEN-LAST:event_scriptListMouseReleased
    private void uncomment() {
        try {
            if (mainTextPanel.getStyledDocument().getText(curLine, 2).equals(KeyWord.COMMENT)) {
                mainTextPanel.getStyledDocument().remove(curLine, 2);
            }
        } catch (BadLocationException ex) {
            ex.printStackTrace();
        }
    }

    private void comment() {
        try {
            mainTextPanel.getStyledDocument().insertString(curLine, KeyWord.COMMENT, null);
        } catch (BadLocationException ex) {
            ex.printStackTrace();
        }
    }

    private void remove() {
        try {
            editor.delete(mainTextPanel, mainTextPanel.getStyledDocument());
        } catch (BadLocationException ex) {
            ex.printStackTrace();
        }
    }
    private UndoManager um = new UndoManager();
    private UndoRedo undoredo = new UndoRedo(um);
    private HighLightWord hlw = new HighLightWord();
    private Editor editor = Editor.getInstance();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem addScriptMenuItem;
    private javax.swing.JMenuItem allPopItem;
    private javax.swing.JButton cancleButton;
    private javax.swing.JMenuItem commentPopItem;
    private javax.swing.JMenuItem copyPopItem;
    private javax.swing.JMenuItem cutPopItem;
    private javax.swing.JPopupMenu dirPopupMenu;
    private javax.swing.JPopupMenu filePopupMenu;
    private javax.swing.JMenuItem findPopMenuItem;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JLabel lineNumberLabel;
    public javax.swing.JTextPane mainTextPanel;
    private javax.swing.JPopupMenu mainTextPanelPop;
    private javax.swing.JButton okButton;
    private javax.swing.JMenuItem pastePopItem;
    private javax.swing.JLabel posLabel;
    private javax.swing.JMenuItem redoPopItem;
    private javax.swing.JMenuItem removePopItem;
    private javax.swing.JMenuItem removeScriptMenuItem;
    private javax.swing.JList scriptList;
    private javax.swing.JMenuItem uncommentPopItem;
    private javax.swing.JMenuItem undoPopItem;
    // End of variables declaration//GEN-END:variables
}
