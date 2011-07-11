package frame.event.ui_event.dialog_game;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.*;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import frame.event.ui_event.Dialog_Main;
import frame.event.ui_event.Event_Dialog;
import javax.swing.JButton;
import java.awt.Rectangle;
import java.awt.Toolkit;
import javax.swing.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Dialog_Move extends Event_Dialog implements MouseListener {

    private JPanel jContentPane = null;
    private ButtonGroup buttonGroup_type = null;  //  @jve:decl-index=0:
    private JButton jButton_up = null;
    private JButton jButton_down = null;
    private JButton jButton_left = null;
    private JButton jButton_right = null;
    private JScrollPane jScrollPane = null;
    private JTable jTable_path = null;
    private Dialog_Main p;

    public Dialog_Move(Dialog_Main parent) {
        super(parent);
        p = parent;

        initialize();
    }

    /**
     * This method initializes this
     *
     */
    private void initialize() {
        buttonGroup_type = new ButtonGroup();
        this.setSize(new Dimension(347, 291));
         this.setTitle("ǿ���ƶ�");
        this.setContentPane(getJContentPane());
        this.getContentPane().setLayout(null);
        addDefaultButton();
        Dimension screenSize =
            Toolkit.getDefaultToolkit().getScreenSize();
        Dimension labelSize = this.getSize();
        this.setLocation(screenSize.width / 2 - (labelSize.width / 2),
            screenSize.height / 2 - (labelSize.height / 2));//����λ����Ļ�в�
    }

    public boolean confirm() {
        // TODO �Զ����ɷ������
        StringBuilder sc = new StringBuilder();
        sc.append("MOVE");
        for (int i = 0; i < jTable_path.getRowCount(); i++) {
            sc.append(" ").append(jTable_path.getValueAt(i, 0).toString());
        }
        p.insertEventTM(p.getEventDialog().curRow, sc.toString());
        return false;
    }

    /**
     * This method initializes jContentPane
     *
     * @return javax.swing.JPanel
     */
    private JPanel getJContentPane() {
        if (jContentPane == null) {
            jContentPane = new JPanel();
            jContentPane.setLayout(null);
            jContentPane.add(getJButton_up(), null);
            jContentPane.add(getJButton_down(), null);
            jContentPane.add(getJButton_left(), null);
            jContentPane.add(getJButton_right(), null);
            jContentPane.add(getJScrollPane(), null);
        }
        return jContentPane;
    }
    private int curRow = 0;

    /**
     * This method initializes jButton_up
     *
     * @return javax.swing.JButton
     */
    private JButton getJButton_up() {
        if (jButton_up == null) {
            jButton_up = new JButton();
            jButton_up.setText("�����ƶ�");
            jButton_up.setLocation(new Point(15, 15));
            jButton_up.setSize(new Dimension(90, 30));
            jButton_up.addActionListener(new java.awt.event.ActionListener() {

                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    String[] s = {"0"};
                    dtm.insertRow(curRow, s);
                    curRow += 1;
                }
            });
        }
        return jButton_up;
    }

    /**
     * This method initializes jButton_down
     *
     * @return javax.swing.JButton
     */
    private JButton getJButton_down() {
        if (jButton_down == null) {
            jButton_down = new JButton();
            jButton_down.setText("�����ƶ�");
            jButton_down.setSize(new Dimension(90, 30));
            jButton_down.setLocation(new Point(15, 60));
            jButton_down.addActionListener(new java.awt.event.ActionListener() {

                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    String[] s = {"1"};
                    dtm.insertRow(curRow, s);
                    curRow += 1;
                }
            });
        }
        return jButton_down;
    }

    /**
     * This method initializes jButton_left
     *
     * @return javax.swing.JButton
     */
    private JButton getJButton_left() {
        if (jButton_left == null) {
            jButton_left = new JButton();
            jButton_left.setText("�����ƶ�");
            jButton_left.setSize(new Dimension(90, 30));
            jButton_left.setLocation(new Point(15, 105));
            jButton_left.addActionListener(new java.awt.event.ActionListener() {

                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    String[] s = {"2"};
                    dtm.insertRow(curRow, s);
                    curRow += 1;
                }
            });
        }
        return jButton_left;
    }

    /**
     * This method initializes jButton_right
     *
     * @return javax.swing.JButton
     */
    private JButton getJButton_right() {
        if (jButton_right == null) {
            jButton_right = new JButton();
            jButton_right.setText("�����ƶ�");
            jButton_right.setSize(new Dimension(90, 30));
            jButton_right.setLocation(new Point(15, 150));
            jButton_right.addActionListener(new java.awt.event.ActionListener() {

                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    String[] s = {"3"};
                    dtm.insertRow(curRow, s);
                    curRow += 1;
                }
            });
        }
        return jButton_right;
    }

    /**
     * This method initializes jScrollPane
     *
     * @return javax.swing.JScrollPane
     */
    private JScrollPane getJScrollPane() {
        if (jScrollPane == null) {
            jScrollPane = new JScrollPane();
            jScrollPane.setSize(new Dimension(200, 180));
            jScrollPane.setViewportView(getJTable_path());
            jScrollPane.setLocation(new Point(120, 15));
        }
        return jScrollPane;
    }

    private JMenuItem getJMenuItem2() {
        if (jMenuItem2 == null) {
            jMenuItem2 = new JMenuItem();
            jMenuItem2.setText("����");
            jMenuItem2.addActionListener(new java.awt.event.ActionListener() {

                public void actionPerformed(java.awt.event.ActionEvent e) {
                    insertRow();
                }
            });
        }
        return jMenuItem2;
    }
    private JMenuItem jMenuItem1 = null, jMenuItem2 = null;
    private JPopupMenu jPopupMenu = null; // @jve:decl-index=0:visual-constraint="633,166"

    public void mouseClicked(MouseEvent e) {
        // TODO �����˵����л���Ʒ
        if (jTable_path.getSelectedRow() != -1) {
            curRow = jTable_path.getSelectedRow();
        }
    }

    public void mousePressed(MouseEvent e) {
        // TODO �Զ����ɷ������
        if (jTable_path.getSelectedRow() != -1) {
            curRow = jTable_path.getSelectedRow();
        }
        if (e.getButton() == MouseEvent.BUTTON3) {
            // �Ҽ������˵�
            getJPopupMenu();
            jPopupMenu.show(e.getComponent(), e.getX(), e.getY());
        }
    }

    public void mouseReleased(MouseEvent e) {
        // TODO �Զ����ɷ������
        if (jTable_path.getSelectedRow() != -1) {
            curRow = jTable_path.getSelectedRow();
        }

    }

    public void mouseEntered(MouseEvent e) {
        // TODO �Զ����ɷ������
    }

    public void mouseExited(MouseEvent e) {
        // TODO �Զ����ɷ������
    }

    private JMenuItem getJMenuItem1() {
        if (jMenuItem1 == null) {
            jMenuItem1 = new JMenuItem();
            jMenuItem1.setText("ɾ��");
            jMenuItem1.addActionListener(new java.awt.event.ActionListener() {

                public void actionPerformed(java.awt.event.ActionEvent e) {
                    delRow();
                }
            });
        }
        return jMenuItem1;
    }
    private String[] col = {"·��"};
    private DefaultTableModel dtm = new DefaultTableModel(col, 0);

    private void insertRow() {
        String[] s = {""};
        dtm.insertRow(curRow, s);
    }

    private void delRow() {
//        System.out.println("del");
        int num = jTable_path.getSelectedRow();
        System.out.println("select: " + num);
        if (num != -1) {
            dtm.removeRow(num);
        }
        curRow = 0;
    }

    private JPopupMenu getJPopupMenu() {
        if (jPopupMenu == null) {
            jPopupMenu = new JPopupMenu();
            jPopupMenu.setSize(new Dimension(61, 100));
            jPopupMenu.add(getJMenuItem2());
//            jPopupMenu.add(getJMenuItem());
            jPopupMenu.add(getJMenuItem1());

        }
        return jPopupMenu;
    }

    /**
     * This method initializes jTable_path
     *
     * @return javax.swing.JTable
     */
    private JTable getJTable_path() {
        if (jTable_path == null) {
            jTable_path = new JTable();
            dtm = new javax.swing.table.DefaultTableModel(col, 0) {

                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            jTable_path.setModel(dtm);
            jTable_path.addMouseListener(this);
        }
        return jTable_path;
    }
}  //  @jve:decl-index=0:visual-constraint="10,10"

