/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package engine.util;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GarbagePanel extends JPanel implements MouseListener {

    private JProgressBar pb;

    public GarbagePanel() {
        pb = new JProgressBar();
        pb.setPreferredSize(new Dimension(150, 20));
        pb.setToolTipText("��������ڴ�");
        pb.addMouseListener(this);
        // ���ö�ʱ�����������ƽ������Ĵ���
        javax.swing.Timer time = new javax.swing.Timer(1000, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                int total = (int) Runtime.getRuntime().totalMemory();
                int used = (int) (total - Runtime.getRuntime().freeMemory());
                pb.setMaximum(total);
                pb.setValue(used);
                pb.setString(used / 1024 + " KB / " + total / 1024 + " KB");

            }
        });
        time.start();

        pb.setStringPainted(true);
        this.setLayout(new BorderLayout());
        this.add(pb, BorderLayout.EAST);
    }

    /**
     * ���ý�����������ģ��
     */
    public void setProcessBar(BoundedRangeModel rangeModel) {
        pb.setModel(rangeModel);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO �Զ����ɷ������
//        System.gc();
//        System.out.println("gc");
    }

    public void mouseEntered(MouseEvent e) {
        // TODO �Զ����ɷ������
    }

    public void mouseExited(MouseEvent e) {
        // TODO �Զ����ɷ������
    }

    public void mousePressed(MouseEvent e) {
//            // �����Ҽ������˵�,���ѡ�е�ͼ
        System.gc();
//        System.out.println("gc");
    }

    public void mouseReleased(MouseEvent e) {
        // TODO �Զ����ɷ������
    }
}
