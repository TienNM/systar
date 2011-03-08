package engine;

import java.util.logging.Level;
import java.util.logging.Logger;
import module.*;
//import engine.util.GarbagePanel;
import model.Map;
//import model.MapList;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.event.*;
import javax.swing.*;
//import javax.swing.plaf.basic.*;
import java.util.*;
import engine.util.*;
//import java.util.logging.Level;
import model.*;
import converter.*;
import java.net.URI;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;
import emulator.*;

public class MapEditor extends JFrame implements ActionListener, ChangeListener {

    private BufferedImage bf;
    // ���ڻ��Ƶ�ͼ��Label

    class MapCanvas extends JLabel implements
        MouseMotionListener, MouseListener {

        private static final long serialVersionUID = 1L;
        public BufferedImage mapImg = null;

        MapCanvas() {
            super();
            addMouseListener(this);
            addMouseMotionListener(this);
            this.add(getPm());
            this.add(getPm2());
        }
        public Graphics2D bfg = null;

        private void initOffImg() {
            // ʵ����offImg�������������
//            System.out.println("useMemory:" + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024);
//            System.out.println("freeMemory:" + Runtime.getRuntime().freeMemory());
            mapImg = bfg.getDeviceConfiguration().createCompatibleImage(map.getCellWidth() * map.getCol(), map.getCellHeight() * map.getRow(),
                Transparency.TRANSLUCENT);//����offImg����Ϊ͸��
            // ���ݵ�ͼ�����齫��ͼ���Ƴ���,����Ƚϸ��ӣ���ҪС�ķ���
            bfg.dispose();
            bfg = mapImg.createGraphics();
            switch (type) {
                case 0:
                default:
                    for (int i = map.getRow() - 1; i >= 0; i--) {
                        for (int j = map.getCol() - 1; j >= 0; j--) {
                            for (int m = 0; m < map.getLayerNum(); m++) {
                                int x = (map.getMap()[m][i][j] - 1)
                                    % (map.getImageWidth() / map.getCellWidth());
                                int y = (map.getMap()[m][i][j] - 1)
                                    / (map.getImageWidth() / map.getCellWidth());
                                bfg.drawImage(map.getImage(), j * map.getCellWidth(), i
                                    * map.getCellHeight(), (j + 1)
                                    * map.getCellWidth(), (i + 1)
                                    * map.getCellHeight(), x * map.getCellWidth(),
                                    y * map.getCellHeight(), (x + 1)
                                    * map.getCellWidth(), (y + 1)
                                    * map.getCellHeight(), null);
                            }
                        }
                    }

                    break;
                case 1:
                    for (int i = map.getRow() - 1; i >= 0; i--) {
                        for (int j = map.getCol() - 1; j >= 0; j--) {
                            for (int m = 0; m < map.getLayerNum(); m++) {
                                int x = (map.getMap()[m][i][j] - 1)
                                    % (map.getImageWidth() / map.getCellWidth());
                                int y = (map.getMap()[m][i][j] - 1)
                                    / (map.getImageWidth() / map.getCellWidth());
                                if (currentLayer != 0) {
                                    if (m == currentLayer || m == currentLayer - 1) {
                                        bfg.drawImage(map.getImage(), j * map.getCellWidth(), i
                                            * map.getCellHeight(), (j + 1)
                                            * map.getCellWidth(), (i + 1)
                                            * map.getCellHeight(), x * map.getCellWidth(),
                                            y * map.getCellHeight(), (x + 1)
                                            * map.getCellWidth(), (y + 1)
                                            * map.getCellHeight(), null);
                                    }
                                } else {
                                    if (m == currentLayer) {
                                        bfg.drawImage(map.getImage(), j * map.getCellWidth(), i
                                            * map.getCellHeight(), (j + 1)
                                            * map.getCellWidth(), (i + 1)
                                            * map.getCellHeight(), x * map.getCellWidth(),
                                            y * map.getCellHeight(), (x + 1)
                                            * map.getCellWidth(), (y + 1)
                                            * map.getCellHeight(), null);
                                    }
                                }
                            }
                        }
                    }

                    break;
                case 2:
                    for (int i = map.getRow() - 1; i >= 0; i--) {
                        for (int j = map.getCol() - 1; j >= 0; j--) {
                            for (int m = 0; m < map.getLayerNum(); m++) {
                                int x = (map.getMap()[m][i][j] - 1)
                                    % (map.getImageWidth() / map.getCellWidth());
                                int y = (map.getMap()[m][i][j] - 1)
                                    / (map.getImageWidth() / map.getCellWidth());
                                if (m == currentLayer) {
                                    bfg.drawImage(map.getImage(), j * map.getCellWidth(), i
                                        * map.getCellHeight(), (j + 1)
                                        * map.getCellWidth(), (i + 1)
                                        * map.getCellHeight(), x * map.getCellWidth(),
                                        y * map.getCellHeight(), (x + 1)
                                        * map.getCellWidth(), (y + 1)
                                        * map.getCellHeight(), null);
                                }
                            }
                        }
                    }

                    break;
            }

            //ͼ���������ŵ�
            if (isPreview) {
                bf = mapImg;
                bf = ImageUtil.rotateImage(mapImg, getJSliderPreview2().getValue());
                bf = ImageUtil.resizeImageScale(bf, getJSliderPreview().getValue());//Ĭ������50%
            }

            /*
             * ������
             */
            if (isMapGrid) {
                bfg.setColor(Color.BLACK);
                for (int j = 0; j < map.getRow(); j++) {
                    bfg.drawLine(0, j * map.getCellHeight(), map.getCol() * map.getCellWidth(), j * map.getCellHeight());
                }
                for (int k = 0; k < map.getCol(); k++) {
                    bfg.drawLine(k * map.getCellWidth(), 0, k * map.getCellWidth(), map.getRow() * map.getCellHeight());
                }
            }

            if (isCollide) {
//                bfg.setStroke(new BasicStroke(2.0F, BasicStroke.CAP_BUTT,
//                    BasicStroke.JOIN_MITER));
                bfg.setStroke(new BasicStroke(2.0F, BasicStroke.CAP_BUTT,
                    BasicStroke.JOIN_MITER));
                for (int i = 0; i < map.getRow(); i++) {
                    for (int j = 0; j < map.getCol(); j++) {
                        if (map.getWay()[i][j] == 1) {
                            bfg.setColor(Color.red);
                            bfg.drawRect(j * map.getCellWidth(), i * map.getCellHeight(), map.getCellWidth(), map.getCellHeight());
                            bfg.setColor(Color.BLACK);
                            bfg.drawString("1", j * map.getCellWidth() + 4, i * map.getCellHeight() + map.getCellHeight() - 4);
                        }
                    }
                }
            }

            if (isEvent) {
                bfg.setStroke(new BasicStroke(2.0F, BasicStroke.CAP_BUTT,
                    BasicStroke.JOIN_MITER));
                if (Project.getPlayer().getMapIndex() == currentMapIndex) {

                    bfg.setColor(new Color(240, 240, 240));
                    bfg.drawRect(Project.getPlayer().getStartX() * map.getCellWidth(), Project.getPlayer().getStartY() * map.getCellHeight(), map.getCellWidth(), map.getCellHeight());
                    bfg.drawString("S", Project.getPlayer().getStartX() * map.getCellWidth() + 4, Project.getPlayer().getStartY() * map.getCellHeight() + map.getCellHeight() - 4);
                }

                bfg.setColor(Color.ORANGE);
                for (int i = 0; i < map.getScriptList().length; i++) {
                    for (int j = 0; j < map.getScriptList()[0].length; j++) {
                        Script temp = map.getScriptList()[i][j];
                        if (temp != null) {
                            bfg.drawRect(temp.getCol() * map.getCellWidth() + 2, temp.getRow() * map.getCellHeight() + 2, map.getCellWidth() - 4, map.getCellHeight() - 4);
                        }
                    }
                }
            }
            if (isChoose) {
                // ���ֿ�

                bfg.setStroke(new BasicStroke(2.0F, BasicStroke.CAP_BUTT,
                    BasicStroke.JOIN_MITER));
                bfg.setColor(new Color(GetRandom(0, 255), GetRandom(0, 255), GetRandom(0, 255)));
                bfg.drawRect(mData.getStartX(), mData.getStartY(), mData.getEndX() - mData.getStartX(), mData.getEndY() - mData.getStartY());
            }
            if (!isChoose
                && !isEvent && !isCollide
                && getJSliderSet().getValue() != 0) {
                bfg.setStroke(new BasicStroke(2.0F, BasicStroke.CAP_BUTT,
                    BasicStroke.JOIN_MITER));
                bfg.drawImage(tileCanvas.getTileImg(), nowX * map.getCellWidth(), nowY * map.getCellHeight(),
                    nowX * map.getCellWidth() + data.getEndX() - data.getStartX(), nowY * map.getCellHeight() + data.getEndY() - data.getStartY(),
                    data.getStartX(), data.getStartY(), data.getEndX(), data.getEndY(), null);
                bfg.setColor(Color.WHITE);
                bfg.drawRect(nowX * map.getCellWidth(), nowY * map.getCellHeight(), data.getEndX() - data.getStartX(), data.getEndY() - data.getStartY());
            } else if (isEvent || isCollide) {
                bfg.setStroke(new BasicStroke(2.0F, BasicStroke.CAP_BUTT,
                    BasicStroke.JOIN_MITER));
                bfg.setColor(Color.WHITE);
                bfg.drawRect(nowX * map.getCellWidth(), nowY * map.getCellHeight(), map.getCellWidth(), map.getCellHeight());
            }
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            // ���������ʱ�¼�
//            if (map.getVisible() == false) {
//                return;
//            }
            if (isEvent) {
                if (eventType == 1) {

                    if (e.getModifiers() == InputEvent.BUTTON1_MASK) {
                        if (e.getClickCount() >= 2) {//˫���򿪱༭�¼��Ի���
                            eventX = e.getX() / map.getCellWidth();
                            eventY = e.getY() / map.getCellHeight();
                            if (eventX < map.getCol() && eventY < map.getRow()) {
                                editNewEvent();
                            }

                        }
                    }
                }
            }
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            // ��������϶�ʱ�¼�
//            if (map.getVisible() == false) {
//                return;
//            }
            if (isChoose) {
                if (e.getModifiers() == InputEvent.BUTTON1_MASK) {
                    if (map != null) {
                        int x = e.getX();
                        int y = e.getY();
                        mData.setB_X(x);
                        mData.setB_Y(y);
                        mData.update(map);
                        repaint();
                    }
                }
                if (e.getModifiers() == InputEvent.BUTTON3_MASK) {
                }
            } else if (!isEvent) {
                if (e.getModifiers() == InputEvent.BUTTON1_MASK) {
                    if (map != null) {
                        int x = e.getX() / map.getCellWidth();
                        int y = e.getY() / map.getCellHeight();
                        if (x < 0) {
                            x = 0;
                        }
                        if (y < 0) {
                            y = 0;
                        }
                        nowX = x;
                        nowY = y;
                        if (!isCollide) {
                            for (int i = 0; i <= data.getEndRow() - data.getStartRow(); i++) {
                                for (int j = 0; j <= data.getEndCol() - data.getStartCol(); j++) {
                                    int num = (data.getStartRow() + i) * map.getImageCol()
                                        + data.getStartCol() + j + 1;// ͼ���Ŵ�1��ʼ
                                    map.setMap(currentLayer, y + i, x + j, num);
                                }
                            }

                        } else {
                            //1��ʾ����ͨ��
                            map.setWay(y, x, 1);
                        }
//                        for (int i = 0; i <= data.getEndRow() - data.getStartRow(); i++) {
//                            for (int j = 0; j <= data.getEndCol() - data.getStartCol(); j++) {
//                                int num = (data.getStartRow() + i) * map.getImageCol()
//                                    + data.getStartCol() + j + 1;// ͼ���Ŵ�1��ʼ
//                                if (!isCollide) {
//                                    map.setMap(currentLayer, y + i, x + j, num);
//                                } else {
//                                    //1��ʾ����ͨ��
//                                    map.setWay(y, x, 1);
//                                }
//                            }
//                        }
                    }
                }
                if (e.getModifiers() == InputEvent.BUTTON3_MASK) {
                    if (map != null) {
                        int x = e.getX() / map.getCellWidth();
                        int y = e.getY() / map.getCellHeight();
                        if (x < 0) {
                            x = 0;
                        }
                        if (y < 0) {
                            y = 0;
                        }
                        nowX = x;
                        nowY = y;
                        for (int i = 0; i <= data.getEndRow() - data.getStartRow(); i++) {
                            for (int j = 0; j <= data.getEndCol() - data.getStartCol(); j++) {
                                if (!isCollide) {
                                    map.setMap(currentLayer, y + i, x + j, 0);
                                } else {
                                    //1��ʾ����ͨ��
                                    map.setWay(y, x, 0);
                                }
                            }
                        }
                    }
                }
                repaint();
            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            // TODO �Զ����ɷ������
        }

        @Override
        public void mouseExited(MouseEvent e) {
            // TODO �Զ����ɷ������
        }
        private int nowX = 0, nowY = 0;//�������

        @Override
        public void mouseMoved(MouseEvent e) {
            // TODO �Զ����ɷ������
            if (map == null) {
                return;
            }
            int xm = e.getX() / map.getCellWidth();
            int ym = e.getY() / map.getCellHeight();
            if (xm < 0) {
                xm = 0;
            }
            if (ym < 0) {
                ym = 0;
            }
            if (!isPa) {
                nowX = xm;
                nowY = ym;
            }
            if (!isChoose) {
                repaint();
            }
            if (xm < map.getCol() && ym < map.getRow()) {
                this.setToolTipText("(" + ym + "," + xm + ")" + map.getMap()[currentLayer][ym][xm]);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
//            if (map.getVisible() == false) {
//                return;
//            }
            isPa = false;//false ��ʾ���������� ture��ʾ��겻����
            copyUndo();
            // ������갴��ʱ�¼�

            if (isChoose) {
                if (e.getModifiers() == InputEvent.BUTTON1_MASK) {
                    if (map != null) {
                        int x = e.getX();
                        int y = e.getY();
                        mData.setA_X(x);
                        mData.setA_Y(y);
                    }
                }
                if (e.getModifiers() == InputEvent.BUTTON3_MASK) {
                }
            }
            if (!isChoose && !isEvent) {
                if (isFill) {
                    if (map != null) {
                        if (e.getModifiers() == InputEvent.BUTTON1_MASK) {
                            for (int i = 0; i <= data.getEndRow() - data.getStartRow(); i++) {
                                for (int j = 0; j <= data.getEndCol() - data.getStartCol(); j++) {

                                    if (!isCollide) {
                                        int num = (data.getStartRow() + i) * map.getImageCol()
                                            + data.getStartCol() + j + 1;// ͼ���Ŵ�1��ʼ
                                        int teX, teY;
                                        teX = Math.max(1, data.getEndRow() - data.getStartRow());
                                        teY = Math.max(1, data.getEndCol() - data.getStartCol());//��by0
                                        for (int m = 0; m < map.getRow() / teX; m++) {
                                            for (int n = 0; n < map.getCol() / teY; n++) {
                                                map.setMap(currentLayer, i + m * (data.getEndCol() - data.getStartCol() + 1),
                                                    j + n * (data.getEndRow() - data.getStartRow() + 1), num);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (e.getModifiers() == InputEvent.BUTTON3_MASK) {
                        }
                    }
                    repaint();
                } else {
                    if (e.getModifiers() == InputEvent.BUTTON1_MASK) {
                        if (map != null) {
                            int x = e.getX() / map.getCellWidth();
                            int y = e.getY() / map.getCellHeight();
                            if (x < 0) {
                                x = 0;
                            }
                            if (y < 0) {
                                y = 0;
                            }
                            if (!isCollide) {
                                for (int i = 0; i <= data.getEndRow() - data.getStartRow(); i++) {
                                    for (int j = 0; j <= data.getEndCol() - data.getStartCol(); j++) {
                                        int num = (data.getStartRow() + i) * map.getImageCol()
                                            + data.getStartCol() + j + 1;// ͼ���Ŵ�1��ʼ
                                        map.setMap(currentLayer, y + i, x + j, num);
                                    }
                                }

                            } else {
                                //1��ʾ����ͨ��
                                map.setWay(y, x, 1);
                            }
//                            for (int i = 0; i <= data.getEndRow() - data.getStartRow(); i++) {
//                                for (int j = 0; j <= data.getEndCol() - data.getStartCol(); j++) {
//                                    int num = (data.getStartRow() + i) * map.getImageCol()
//                                        + data.getStartCol() + j + 1;// ͼ���Ŵ�1��ʼ
//                                    if (!isCollide) {
//                                        map.setMap(currentLayer, y + i, x + j, num);
//                                    } else {
//                                        //1��ʾ����ͨ��
//                                        map.setWay(y, x, 1);
//                                    }
//                                }
//                            }
                        }
//                        repaint(nowX * map.getCellWidth(), nowY * map.getCellHeight(), data.getEndX() - data.getStartX(), data.getEndY() - data.getStartY());
                    }
                    if (e.getModifiers() == InputEvent.BUTTON3_MASK) {
                        if (map != null) {
                            int x = e.getX() / map.getCellWidth();
                            int y = e.getY() / map.getCellHeight();
                            if (x < 0) {
                                x = 0;
                            }
                            if (y < 0) {
                                y = 0;
                            }
                            if (!isCollide) {
                                for (int i = 0; i <= data.getEndRow() - data.getStartRow(); i++) {
                                    for (int j = 0; j <= data.getEndCol() - data.getStartCol(); j++) {
                                        map.setMap(currentLayer, y + i, x + j, 0);
                                    }
                                }

                            } else {
                                //1��ʾ����ͨ��
                                map.setWay(y, x, 0);
                            }


                        }
//                        repaint(nowX * map.getCellWidth(), nowY * map.getCellHeight(), data.getEndX() - data.getStartX(), data.getEndY() - data.getStartY());
                    }
                }
            }
            repaint();

            copyRedo();
            nIndex++;
            if (nIndex > 9) {
                nIndex = 0;
            }
        }
        private JPopupMenu pm2;
        private JMenuItem jmi5 = null;
        private JMenuItem jmi6 = null;
        private JMenuItem jmi7 = null;
        private JMenuItem jmi8 = null;
        private JMenuItem jmi9 = null;
        private JMenuItem jmi10 = null;

        private JPopupMenu getPm2() {
            if (pm2 == null) {
                pm2 = new JPopupMenu();
                pm2.add(getJmi5());
                pm2.addSeparator();
                pm2.add(getJmi6());
                pm2.add(getJmi7());
                pm2.add(getJmi8());
                pm2.add(getJmi9());
                pm2.addSeparator();
                pm2.add(getJmi10());
            }
            return pm2;
        }

        private JMenuItem getJmi5() {
            if (jmi5 == null) {
                jmi5 = new JMenuItem();
                jmi5.setText("�༭�¼�");
//                jmi1.addActionListener(this);
                jmi5.addActionListener(new java.awt.event.ActionListener() {

                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        editNewEvent();
                    }
                });
            }
            return jmi5;
        }

        private void editNewEvent() {
            System.out.println("�½��¼�");
            eventDia = new EventManager(mapEditor);
//            eventDia.updateList();
            eventDia.setVisible(true);
        }
        private EventManager eventDia;

        private JMenuItem getJmi6() {
            if (jmi6 == null) {
                jmi6 = new JMenuItem();
                jmi6.setText("����");
//                jmi1.addActionListener(this);
                jmi6.addActionListener(new java.awt.event.ActionListener() {

                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        System.out.println("����");
                        isPa = false;
//                        int tempEventX = eventX;
//                        int tempEventY = eventY;
                        cutScript = map.getScriptList()[eventY][eventX];
                        cutType = map.getScriptType()[eventY][eventX];
                        delScript();
                    }
                });
            }
            return jmi6;
        }
        private Script cutScript;

        private void delScript() {
            Script s = map.getScriptList()[eventY][eventX];
            if (s != null) {
                map.getScriptList()[eventY][eventX] = null;
                System.out.println("del");

            }
            map.getScriptType()[eventY][eventX] = cutType;
            mapCanvas.updateCanvas();
        }

        private JMenuItem getJmi7() {
            if (jmi7 == null) {
                jmi7 = new JMenuItem();
                jmi7.setText("����");
//                jmi1.addActionListener(this);
                jmi7.addActionListener(new java.awt.event.ActionListener() {

                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        System.out.println("����");
                        isPa = false;
                        cutScript = map.getScriptList()[eventY][eventX];
                        cutType = map.getScriptType()[eventY][eventX];
                    }
                });
            }
            return jmi7;
        }
        private byte cutType = 0;

        private JMenuItem getJmi8() {
            if (jmi8 == null) {
                jmi8 = new JMenuItem();
                jmi8.setText("ճ��");
//                jmi1.addActionListener(this);
                jmi8.addActionListener(new java.awt.event.ActionListener() {

                    public void actionPerformed(java.awt.event.ActionEvent e) {

                        isPa = false;
                        if (cutScript != null) {
                            Script s = new Script(nowX, nowY);
                            for (int i = 0; i < cutScript.size(); i++) {
                                s.addString(cutScript.getString(i));
                            }
                            map.getScriptList()[nowY][nowX] = s;
                            map.getScriptType()[eventY][eventX] = cutType;
                            mapCanvas.updateCanvas();
                            System.out.println("ճ��");

                        }

                    }
                });
            }
            return jmi8;
        }

        private JMenuItem getJmi9() {
            if (jmi9 == null) {
                jmi9 = new JMenuItem();
                jmi9.setText("ɾ��");
//                jmi1.addActionListener(this);
                jmi9.addActionListener(new java.awt.event.ActionListener() {

                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        System.out.println("ɾ��");
                        isPa = false;
                        delScript();

                    }
                });
            }
            return jmi9;
        }

        private JMenuItem getJmi10() {
            if (jmi10 == null) {
                jmi10 = new JMenuItem();
                jmi10.setText("�������ǳ���λ��");
//                jmi1.addActionListener(this);
                jmi10.addActionListener(new java.awt.event.ActionListener() {

                    public void actionPerformed(java.awt.event.ActionEvent e) {
//                        System.out.println("�������ǳ���λ��");
                        getSetHeroDialog();
                        initHeroDir();
                        setHeroDialog.setVisible(true);
                    }
                });
            }
            return jmi10;
        }

        private void initHeroDir() {
            switch (Project.getPlayer().getDir()) {
                case 0:
                    jrb1.setSelected(true);
                    break;
                case 1:
                    jrb2.setSelected(true);
                    break;
                case 2:
                    jrb3.setSelected(true);
                    break;
                case 3:
                    jrb4.setSelected(true);
                    break;
            }
        }
        private JDialog setHeroDialog;

        private JDialog getSetHeroDialog() {
            if (setHeroDialog == null) {
                setHeroDialog = new JDialog();
                setHeroDialog.setSize(170, 200);
                Dimension screenSize =
                    Toolkit.getDefaultToolkit().getScreenSize();
                Dimension labelSize = setHeroDialog.getSize();
                setHeroDialog.setLocation(screenSize.width / 2 - (labelSize.width / 2),
                    screenSize.height / 2 - (labelSize.height / 2));//����λ����Ļ�в�
                setHeroDialog.setTitle("������������");
                setHeroDialog.setModal(true);
                setHeroDialog.setContentPane(getSetHeroPanel());
            }
            return setHeroDialog;
        }
        private JPanel setHeroPanel;
        private JPanel jp4;
        private JRadioButton jrb1, jrb2, jrb3, jrb4;
        private ButtonGroup jbg = new ButtonGroup();
        private int heroDir = 0;

        private JPanel getJpanel4() {
            if (jp4 == null) {
                jp4 = new JPanel();
                jp4.setLayout(null);
                jp4.setBounds(10, 10, 140, 110);
                jrb1 = new JRadioButton("����");
                jrb1.setBounds(20, 20, 60, 20);
//                jrb1.setSelected(true);
                jrb1.addActionListener(new java.awt.event.ActionListener() {

                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        heroDir = 0;
                    }
                });
                jrb2 = new JRadioButton("����");
                jrb2.setBounds(20, 40, 60, 20);
                jrb2.addActionListener(new java.awt.event.ActionListener() {

                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        heroDir = 1;
                    }
                });
                jrb3 = new JRadioButton("����");
                jrb3.setBounds(20, 60, 60, 20);
                jrb3.addActionListener(new java.awt.event.ActionListener() {

                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        heroDir = 2;
                    }
                });
                jrb4 = new JRadioButton("����");
                jrb4.setBounds(20, 80, 60, 20);
                jrb4.addActionListener(new java.awt.event.ActionListener() {

                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        heroDir = 3;
                    }
                });
                jbg.add(jrb1);
                jbg.add(jrb2);
                jbg.add(jrb3);
                jbg.add(jrb4);
                jp4.add(jrb1, null);
                jp4.add(jrb2, null);
                jp4.add(jrb3, null);
                jp4.add(jrb4, null);
                jp4.setBorder(BorderFactory.createTitledBorder("����"));
            }
            return jp4;
        }

        private JPanel getSetHeroPanel() {
            if (setHeroPanel == null) {
                setHeroPanel = new JPanel();
                setHeroPanel.setLayout(null);
                setHeroPanel.add(getJpanel4());
                setHeroPanel.add(getJbOk());
                setHeroPanel.add(getJbCancle());
            }
            return setHeroPanel;
        }
        private JButton ok2, cancle2;

        private JButton getJbOk() {
            if (ok2 == null) {
                ok2 = new JButton("ȷ��");
                ok2.setBounds(10, 140, 60, 20);
                ok2.addActionListener(new java.awt.event.ActionListener() {

                    public void actionPerformed(java.awt.event.ActionEvent e) {

//                        System.out.println("currentMapIndex " + currentMapIndex);
//                        System.out.println("heroDir " + heroDir);
                        System.out.println(eventX + "," + eventY);
                        Project.getPlayer().setStartX(eventX);
                        Project.getPlayer().setStartY(eventY);
                        Project.getPlayer().setDir(heroDir);
                        Project.getPlayer().setMapIndex(currentMapIndex);
                        dm.savePlayer();
                        setHeroDialog.setVisible(false);
                    }
                });
            }
            return ok2;
        }

        private JButton getJbCancle() {
            if (cancle2 == null) {
                cancle2 = new JButton("ȡ��");
                cancle2.setBounds(90, 140, 60, 20);
                cancle2.addActionListener(new java.awt.event.ActionListener() {

                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        setHeroDialog.setVisible(false);
                    }
                });
            }
            return cancle2;
        }
        private JPopupMenu pm;
        private JMenuItem jmi1 = null;
        private JMenuItem jmi2 = null;
        private JMenuItem jmi3 = null;
        private JMenuItem jmi4 = null;

        private JPopupMenu getPm() {
            if (pm == null) {
                pm = new JPopupMenu();
                pm.add(getJmi1());
                pm.add(getJmi2());
                pm.add(getJmi3());
                pm.add(getJmi4());
            }
            return pm;
        }
        int[][] copyMap;
        int[][] copyWay;

        private JMenuItem getJmi1() {
            if (jmi1 == null) {
                jmi1 = new JMenuItem();
                jmi1.setText("����");
//                jmi1.addActionListener(this);
                jmi1.addActionListener(new java.awt.event.ActionListener() {

                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        isPa = false;
                        copyMap = new int[mData.getEndRow() - mData.getStartRow() + 1][mData.getEndCol() - mData.getStartCol() + 1];
                        copyWay = new int[mData.getEndRow() - mData.getStartRow() + 1][mData.getEndCol() - mData.getStartCol() + 1];
                        for (int i = 0; i < mData.getEndRow() - mData.getStartRow() + 1; i++) {
                            for (int j = 0; j < mData.getEndCol() - mData.getStartCol() + 1; j++) {
                                copyMap[i][j] = map.getMap()[currentLayer][i + mData.getStartRow()][j + mData.getStartCol()];
                                if (isAll) {
                                    copyWay[i][j] = map.getWay()[i + mData.getStartRow()][j + mData.getStartCol()];
                                }
                            }
                        }
                    }
                });
            }
            return jmi1;
        }

        private JMenuItem getJmi2() {
            if (jmi2 == null) {
                jmi2 = new JMenuItem();
                jmi2.setText("ճ��");
                jmi2.addActionListener(new java.awt.event.ActionListener() {

                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        isPa = false;
                        if (copyMap != null) {

                            for (int j = 0; j < mData.getEndCol() - mData.getStartCol() + 1; j++) {
                                for (int i = 0; i < mData.getEndRow() - mData.getStartRow() + 1; i++) {
                                    map.setMap(currentLayer, nowY + i,
                                        nowX + j, copyMap[i][j]);
                                    if (isAll) {
                                        map.setWay(nowY + i,
                                            nowX + j, copyWay[i][j]);
                                    }
                                }
                            }
                        }
                        mapCanvas.updateCanvas();
                    }
                });
            }
            return jmi2;
        }

        private JMenuItem getJmi3() {
            if (jmi3 == null) {
                jmi3 = new JMenuItem();
                jmi3.setText("����");
                jmi3.addActionListener(new java.awt.event.ActionListener() {

                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        isPa = false;
                        copyMap = new int[mData.getEndRow() - mData.getStartRow() + 1][mData.getEndCol() - mData.getStartCol() + 1];
                        for (int i = 0; i < mData.getEndRow() - mData.getStartRow() + 1; i++) {
                            for (int j = 0; j < mData.getEndCol() - mData.getStartCol() + 1; j++) {
                                copyMap[i][j] = map.getMap()[currentLayer][i + mData.getStartRow()][j + mData.getStartCol()];
                                map.setMap(currentLayer, i + mData.getStartRow(), j + mData.getStartCol(), 0);
                                if (isAll) {
                                    map.setWay(i + mData.getStartRow(), j + mData.getStartCol(), 0);
                                }
                            }
                        }
                        mapCanvas.updateCanvas();
                    }
                });
            }
            return jmi3;
        }

        private JMenuItem getJmi4() {
            if (jmi4 == null) {
                jmi4 = new JMenuItem();
                jmi4.setText("���");
                jmi4.addActionListener(new java.awt.event.ActionListener() {

                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        isPa = false;
                        for (int i = 0; i < mData.getEndRow() - mData.getStartRow() + 1; i++) {
                            for (int j = 0; j < mData.getEndCol() - mData.getStartCol() + 1; j++) {
                                map.setMap(currentLayer, i + mData.getStartRow(), j + mData.getStartCol(), 0);
                                if (isAll) {
                                    map.setWay(i + mData.getStartRow(), j + mData.getStartCol(), 0);
                                }
                            }
                        }
                        mapCanvas.updateCanvas();
                    }
                });
            }
            return jmi4;
        }
        private boolean isPa;

        @Override
        public void mouseReleased(MouseEvent e) {
            // ������굯��ʱ�¼�
//            if (map.getVisible() == false) {
//                return;
//            }
            if (isChoose) {
                if (e.getModifiers() == InputEvent.BUTTON1_MASK) {
                    if (map != null) {
                        int x = e.getX();
                        int y = e.getY();
                        mData.setB_X(x);
                        mData.setB_Y(y);
                        mData.update(map);
                        repaint();
                    }
                }
                if (e.getModifiers() == InputEvent.BUTTON3_MASK) {
                    pm.show(this, e.getX(), e.getY());
                    isPa = true;
                }
            }
            if (isEvent) {
                if (eventType == 0) {
//                    System.out.println("event");
                    if (eventType == 0) {
                        if (e.getModifiers() == InputEvent.BUTTON1_MASK) {
                            eventX = e.getX() / map.getCellWidth();
                            eventY = e.getY() / map.getCellHeight();
                            if (eventX < map.getCol() && eventY < map.getRow()) {
                                getEventDialog();
                                jtxEvent.setText("");
                                if (map.getScriptList()[eventY][eventX] != null) {
                                    for (int i = 0, n = map.getScriptList()[eventY][eventX].size(); i < n; i++) {
                                        jtxEvent.append(map.getScriptList()[eventY][eventX].getString(i) + "\n");
                                    }
                                }
                                jdEvent.setVisible(true);
                            }
                        }
                    }
                }
                if (eventType == 1) {
                    if (e.getModifiers() == InputEvent.BUTTON3_MASK) {
                        eventX = e.getX() / map.getCellWidth();
                        eventY = e.getY() / map.getCellHeight();
                        if (eventX < map.getCol() && eventY < map.getRow()) {
                            pm2.show(this, e.getX(), e.getY());
                            isPa = true;
                        }

                    }
                }

            }
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            if (map != null) {
                initOffImg();
                g.drawImage(mapImg, 0, 0, Color.white, null);
            }
            if (isPreview) {
                getPreviewLabel().updateCanvas();
            }
        }

        public void updateCanvas() {
            // Ϊ����ʾ��������
            ImageIcon temp = null;
            mapImg = new BufferedImage(map.getCellWidth() * map.getCol(), map.getCellHeight() * map.getRow(), BufferedImage.TYPE_INT_RGB);
            bfg = mapImg.createGraphics();
            temp = new ImageIcon(mapImg);
            setIcon(temp);
            repaint();
        }
    }

    public int GetRandom(int rs, int re)//��ȡ�����
    {
        int tmp = rs + Math.abs(new Random().nextInt() % (re - rs + 1));
        return tmp;
    }
    // ������ʾ��ͼͼ���Label

    class TileCanvas extends JLabel implements MouseListener,
        MouseMotionListener {

        /**
         *
         */
        private static final long serialVersionUID = 1L;
        public Image TileImg = null;

        TileCanvas() {
            super();
            addMouseListener(this);
            addMouseMotionListener(this);

        }

        @Override
        public void mouseClicked(MouseEvent e) {
            // ���������ʱ�¼�
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            // ��������϶�ʱ�¼�

            if (map != null) {
                int x = e.getX();
                int y = e.getY();
                if (x < map.getImageWidth() && y < map.getImageHeight()) {
                    data.setB_X(x);
                    data.setB_Y(y);
                    data.update(map);
                }
                repaint();
            }

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            // ����������ʱ�¼�
        }

        @Override
        public void mouseExited(MouseEvent e) {
            // ��������˳�ʱ�¼�
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            // TODO �Զ����ɷ������
            if (map != null) {
                int xtm = e.getX() / map.getCellWidth();
                int ytm = e.getY() / map.getCellHeight();
                if (xtm < map.getImageCol() && ytm < map.getImageRow()) {
                    this.setToolTipText("(" + ytm + "," + xtm + ")" + (xtm + map.getImageCol() * ytm + 1));
                }
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            // ������갴��ʱ�¼�

            if (map != null) {
                int x = e.getX();
                int y = e.getY();
                if (x < map.getImageWidth() && y < map.getImageHeight()) {
                    data.setA_X(x);
                    data.setA_Y(y);
                }

            }

        }

        @Override
        public void mouseReleased(MouseEvent e) {
            // ������굯��ʱ�¼�
            if (map != null) {
                int x = e.getX();
                int y = e.getY();
                if (x < map.getImageWidth() && y < map.getImageHeight()) {
                    data.setB_X(x);
                    data.setB_Y(y);
                    data.update(map);
                }

                repaint();
            }
            System.gc();
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            if (map != null) {
                g.drawImage(TileImg, 0, 0, Color.white, null);
                /*
                 * ������
                 */
                if (isTileGrid) {
                    g.setColor(Color.BLACK);
                    for (int j = 0; j < map.getImageRow(); j++) {
                        g.drawLine(0, j * map.getCellHeight(), map.getImageCol() * map.getCellWidth(), j * map.getCellHeight());
                    }
                    for (int k = 0; k < map.getImageCol(); k++) {
                        g.drawLine(k * map.getCellWidth(), 0, k * map.getCellWidth(), map.getImageRow() * map.getCellHeight());
                    }
                }
                // ���ֿ�
                Graphics2D gg = (Graphics2D) g;
                gg.setStroke(new BasicStroke(2.0F, BasicStroke.CAP_BUTT,
                    BasicStroke.JOIN_MITER));
                // 2.0F�ǱʵĴ�ϸ
                // CAP_ROUND�������˵�
                // JOIN_ROUND�ǵ㻮��ģʽ

                gg.setColor(new Color(GetRandom(0, 255), GetRandom(0, 255), GetRandom(0, 255)));
                gg.drawRect(data.getStartX(), data.getStartY(), data.getEndX() - data.getStartX(), data.getEndY() - data.getStartY());
            }
        }
        /**
         * ȡ�û��Ƶ�ͼ��Ԫ�� ����ͼԪ�����趨�ĵ�Ԫ���С�ü� ���ü���ĵ�ͼԪ����ʾ����
         *
         */
        BufferedImage tempImg;

        public BufferedImage getTileImg() {
            return ImageUtil.effect_transparent(bmpImg, getJSliderSet().getValue());
        }
        BufferedImage bmpImg;

        public void dealPic(int typp) {//��ĳ����ɫ����Ϊ͸��
            if (typp == 0) {
                bmpImg = tempImg;
                return;
            }
            int h = tempImg.getHeight();
            int w = tempImg.getWidth();
            int argb, r = 0, g = 0, b = 0, a = 0;
            bmpImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
            Graphics2D bg = bmpImg.createGraphics();
            bg.getDeviceConfiguration().createCompatibleImage(w, h,
                Transparency.TRANSLUCENT);//����offImg����Ϊ͸��
            bg.dispose();
            for (int i = h - 1; i >= 0; i--) {
                for (int j = w - 1; j >= 0; j--) {
                    argb = tempImg.getRGB(j, i);

                    a = ((argb & 0xff000000) >> 24); // alpha channel
                    r = ((argb & 0x00ff0000) >> 16); // red channel
                    g = ((argb & 0x0000ff00) >> 8); // green channel
                    b = (argb & 0x000000ff); // blue channel
//                    if (typp == 1) {
                    //���㷨Ĭ��ͼƬ���½ǵ�Ϊ����ɫ
                    if (argb == tempImg.getRGB(w - 1, h - 1)) {
                        bmpImg.setRGB(j, i, 0x00000000);
                    } else {
                        bmpImg.setRGB(j, i, (a << 24) | (r << 16) | (g << 8) | b);
                    }
//                    }
                }
            }
        }

//        public Image CreateRGBImage(int[] pixs, int w, int h, boolean flag) {
//            BufferedImage buffImg = null;
//            if(flag){
//                buffImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
//            }else{
//                buffImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
//            }
//            buffImg.setRGB(0, 0, w, h, pixs, 0, pixs.length);
//            return buffImg;
//        }
        public void updateCanvas() {
            // ȡ��ԭͼƬ
//            if (map == null && map.getVisible() == false) {
//                return;
//
//            }
            File file = new File(Project.getProjectPath() + "\\image\\tileset\\" + map.getImageName());
            try {
                tempImg = ImageIO.read(file);
            } catch (Exception ee) {
            }

//            if (isRotate) {
//                tempImg = ImageUtil.rotateImage(tempImg);
//            }
            ImageIcon temp;
            int typ = 0;
            if (file.getName().endsWith(".bmp")) {
                typ = 1;
            }
            if (file.getName().endsWith(".jpg")) {
                typ = 2;
            }
            dealPic(typ);
            temp = new ImageIcon(bmpImg);
            // ����ʵ��Ӧ����ʾ��ͼƬ��С
            int xSize = temp.getIconWidth() / map.getCellWidth()
                * map.getCellWidth();
            int ySize = temp.getIconHeight() / map.getCellHeight()
                * map.getCellHeight();

            // �õ�Ӧ����ʾ��ͼƬ
            CropImageFilter cropFilter = new CropImageFilter(0, 0, xSize, ySize);
            TileImg = createImage(new FilteredImageSource(bmpImg.getSource(),
                cropFilter));
//             ���ݲü����ͼƬ������Icon
            temp = new ImageIcon(TileImg);
            setIcon(temp);
            map.setImage(TileImg);
            map.setImageWidth(xSize);
            map.setImageHeight(ySize);
            repaint();
        }
    }

    private JSplitPane getJSplitPane1() {
        if (jSplitPane1 == null) {
            jSplitPane1 = new JSplitPane();
            jSplitPane1.setDividerSize(8);
            jSplitPane1.setOneTouchExpandable(true);
            jSplitPane1.setPreferredSize(new Dimension(260, 395));
            jSplitPane1.setTopComponent(getJScrollPane());
            jSplitPane1.setBottomComponent(getJScrollPane3());
            jSplitPane1.setOrientation(JSplitPane.VERTICAL_SPLIT);
        }
        return jSplitPane1;
    }
    private JScrollPane jScrollPane3 = null;

    private JScrollPane getJScrollPane3() {
        if (jScrollPane3 == null) {
            jScrollPane3 = new JScrollPane();
        }
        jScrollPane3.setPreferredSize(new Dimension(260, 0));
        jScrollPane3.setViewportView(getJTable());

        return jScrollPane3;
    }
    private MapTable jTable = null;

    private JTable getJTable() {
        if (jTable == null) {
            jTable = new MapTable();
//            jTable.setRowSelectionInterval(0, 0);
        }
        return jTable;
    }
    public int currentMapIndex = 0;

// ������ʾ��ͼ��Table
    class MapTable extends JTable implements MouseListener {

        /**
         *
         */
        private static final long serialVersionUID = 1L;
        private DefaultTableModel mapModel = null;

        MapTable() {
            super();
            String[] col = {"���", "��ͼ"};
//            mapModel = new DefaultTableModel(col, 0);
            mapModel = new javax.swing.table.DefaultTableModel(col, 0) {

                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            setModel(mapModel);
            String[] temp = {"", ""};
            mapModel.addRow(temp);
            addMouseListener(this);
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            // TODO �Զ����ɷ������

            currentMapIndex = jTable.getSelectedRow();
//            System.out.println("currentMapIndex = " + currentMapIndex);
            System.out.println(mapVector.isEmpty());
            if (map != null && (!mapVector.isEmpty())) {
                if (getJTable().getSelectedRow() != -1) {
                    map = (Map) mapVector.get(currentMapIndex);
                    undoMap = null;
                    redoMap = null;
                    undoMap = new int[10][map.getLayerNum()][map.getRow()][map.getCol()];
                    redoMap = new int[10][map.getLayerNum()][map.getRow()][map.getCol()];
                    currentLayer = 0;
                    layerNum = map.getLayerNum();
                    getJMenu1().repaint();
                    initMapCanvas();
                }
            }
            if (e.getClickCount() >= 2) {
                setMapNews();
            }
        }

        public void mouseEntered(MouseEvent e) {
            // TODO �Զ����ɷ������
        }

        public void mouseExited(MouseEvent e) {
            // TODO �Զ����ɷ������
        }

        public void mousePressed(MouseEvent e) {
//            // �����Ҽ������˵�,���ѡ�е�ͼ
            if ((e.getModifiers() & InputEvent.BUTTON3_MASK) != 0) {
                getJPopupMenu();

                jPopupMenu.show(e.getComponent(), e.getX(), e.getY());
            }
        }

        public void mouseReleased(MouseEvent e) {
            // TODO �Զ����ɷ������
//            if (jTable.getSelectedRow() == -1) {
//                jMenuItem26.setEnabled(false);
//            } else {
//                jMenuItem26.setEnabled(true);
//            }
        }

        public void updateTable() {
            // TODO �Զ����ɷ������
            int mapNum = mapModel.getRowCount();
            for (int i = 0; i < mapNum; i++) {
                mapModel.removeRow(0);
            }
            for (int i = 0, n = mapVector.size(); i < n; i++) {
                String[] temp = {"" + i, ((Map) mapVector.get(i)).getName()};
                mapModel.addRow(temp);
            }
            if (mapVector.isEmpty()) {
                String[] temp = {"", ""};
                mapModel.addRow(temp);
            }
        }
    }

    public void TableUpdateCanvas() {
        if (jTable != null) {
            jTable.updateTable();
        }
    }
    private JPopupMenu jPopupMenu;

    private JPopupMenu getJPopupMenu() {
        if (jPopupMenu == null) {
            jPopupMenu = new JPopupMenu();
            jPopupMenu.setSize(new Dimension(139, 61));

            jPopupMenu.add(getMapItem());
            jPopupMenu.add(getJMenuItem());
            jPopupMenu.add(getJMenuItem3());
            try {
                JMenu[] menu = null;
                if (pl.getMenuItem() != null) {
                    menu = pl.getPopMenu();
                }
                if (menu != null) {
                    int ii = menu.length;
                    for (int i = 0; i
                        < ii; i++) {
                        if (menu[i] != null) {
                            jPopupMenu.add(menu[i]);
                        }
                    }
                }
            } catch (Exception e) {
                // TODO �Զ����� catch ��
            }
            jPopupMenu.add(getJMenuItem26());
//            jPopupMenu.add(getJMenuItem27());
//            jPopupMenu.add(getJMenuItem28());
//            jPopupMenu.add(getJMenuItem29());
        }
        return jPopupMenu;
    }

    private JMenuItem getJMenuItem27() {
        if (jMenuItem27 == null) {
            jMenuItem27 = new JMenuItem();
            jMenuItem27.setText("����");
        }
        return jMenuItem27;
    }

    /**
     * This method initializes jMenuItem28
     *
     * @return javax.swing.JMenuItem
     */
    private JMenuItem getJMenuItem28() {
        if (jMenuItem28 == null) {
            jMenuItem28 = new JMenuItem();
            jMenuItem28.setText("ճ��");
        }
        return jMenuItem28;
    }
    private JMenuItem jMenuItem26, jMenuItem29, jMenuItem28, jMenuItem27;

//    private JMenuItem getJMenuItem25() {
//        if (jMenuItem25 == null) {
//            jMenuItem25 = new JMenuItem();
//            jMenuItem25.setText("����");
//        }
//        return jMenuItem25;
//    }
    private JMenuItem getJMenuItem26() {
        if (jMenuItem26 == null) {
            jMenuItem26 = new JMenuItem();
            jMenuItem26.setText("ɾ����ͼ");
            jMenuItem26.addActionListener(new java.awt.event.ActionListener() {

                public void actionPerformed(java.awt.event.ActionEvent e) {
                    if (!mapVector.isEmpty()) {
                        mapVector.remove(currentMapIndex);
                        System.out.println("mapsize:" + mapVector.size());
                        jTable.updateTable();
                        currentMapIndex = 0;
                        if (mapVector.isEmpty()) {
//                            jTable.updateTable();
                            mapCanvas.setVisible(false);
                            tileCanvas.setVisible(false);
                        } else {
                            map = mapVector.mapAt(0);
                            undoMap = new int[10][map.getLayerNum()][map.getRow()][map.getCol()];
                            redoMap = new int[10][map.getLayerNum()][map.getRow()][map.getCol()];
                            layerNum = map.getLayerNum();
                            currentLayer = 0;
                            getJMenu1().repaint();
                            initMapCanvas();
                        }
                    }
                }
            });
        }
        return jMenuItem26;
    }

    private JMenuItem getJMenuItem29() {
        if (jMenuItem29 == null) {
            jMenuItem29 = new JMenuItem();
            jMenuItem29.setText("�ƶ�");
        }
        return jMenuItem29;
    }
    private static final long serialVersionUID = 1L;

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO �Զ����ɷ������
        JDialog.setDefaultLookAndFeelDecorated(true);
        JFrame.setDefaultLookAndFeelDecorated(true);
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                MapEditor thisClass = new MapEditor();
                thisClass.setLAF(substance);
                thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                thisClass.setVisible(true);
            }
        });
    }
    //������۷��ķ���

    public void setLAF(String s) {
        try {
            UIManager.setLookAndFeel(s);
            SwingUtilities.updateComponentTreeUI(this);//���¿ؼ������
        } catch (Exception e) {
        }
    }
//    private static String substance = "org.jvnet.substance.skin.SubstanceBusinessBlackSteelLookAndFeel";//�����޸�Ĭ��Ƥ��
    private static String substance = "org.pushingpixels.substance.api.skin.SubstanceBusinessBlackSteelLookAndFeel";//�����޸�Ĭ��Ƥ��
    private JPanel jContentPane = null;
    private JMenuBar jJMenuBar = null;
    private JMenu jMenu_File = null;
    private JMenu jMenu_Lay = null;
    private JMenu jMenu_Set = null;
    private JMenu jMenu_Plugin = null;
    private JMenu jMenu_pic = null;
    private JMenu jMenu_help = null;
    private JMenu jMenu_edit = null;
    private JMenuItem jMenuItem = null;
    private JMenuItem jUndoItem = null;
    private JMenuItem jRedoItem = null;
    private JRadioButtonMenuItem jMenuPicItem1 = null;
    private JRadioButtonMenuItem jMenuPicItem2 = null;
    private JRadioButtonMenuItem jMenuPicItem3 = null;
    private JRadioButtonMenuItem[] menuItem = new JRadioButtonMenuItem[0];
    private ButtonGroup buttonGroup = new ButtonGroup();
    private ButtonGroup buttonGroup2 = new ButtonGroup();
    private ButtonGroup buttonGroup3 = new ButtonGroup();
    private ButtonGroup buttonGroup4 = new ButtonGroup();
    private JSplitPane jSplitPane = null, jSplitPane1 = null;
    private Map map = null;  //  @jve:decl-index=0:
    private JDialog jDialog = null; // @jve:decl-index=0:visual-constraint="868,16"
    private JPanel jContentPane1 = null;
    private JPanel jContentPane2 = null;
    private JLabel jLabelcolor = null;
    private JLabel jLmapName = null;
    private JLabel jLcellW = null;
    private JLabel jLcellH = null;
    private JLabel jLmapImg = null;
    private JLabel jLLayNum = null;//ͼ����
    private JTextField jTmapName = null;
    private JTextField jTcellW = null;
    private JTextField jTcellH = null;
    private JTextField jTLayNum = null;//ͼ����
    private JComboBox jComboBox = null, jComboBox2 = null;
    private JButton jButton = null;
    private JButton jButton1 = null;
    private JScrollPane jScrollPane = null;
    private JPanel jPanel = null;
    private JScrollPane jScrollPane1 = null;
    private JPanel jPanel1 = null;
    private MapEditor.TileCanvas tileCanvas = null;
    private JLabel jLabel4 = null;
    private JLabel jLabel5 = null;
    private JTextField jTmapCol = null;
    private JTextField jTmapRow = null;
    private Data data = null; // @jve:decl-index=0:
    private Data mData = null;
    private int currentLayer = 0;
    public static MapEditor.MapCanvas mapCanvas = null;
    private JMenuItem jMenuItem3 = null;
    private PluginLoader pl = null; // @jve:decl-index=0:
    private JButton slButton = null;
    private JButton scButton = null;
    private JButton mapGridButton = null;
    private JButton TileGridButton = null;
    private JButton newButton = null;
    private JButton saveButton = null;
    private JButton undoButton = null;
    private JButton redoButton = null;
    private JCheckBox PrevCheck = null;
//    private JMenuItem ImgItem = null;
    private JRadioButton editCheck = null;
    private JRadioButton fillCheck = null;
    private JToolBar toolBar = null;
    private JToolBar tileToolBar = null;
    private JSlider jpb = null;
    private JSlider jpb2 = null;
    private JSlider jpb3 = null;
    private boolean isMapGrid = false;
    private boolean isTileGrid = false;
    private boolean isCollide = false;
    private boolean isPreview = false;
    private boolean isChoose = false;
    private boolean isFill = false;
    private boolean isAll = false;
    private int type = 0;
    private JDialog PreviewDialog = null;
    private JPanel PreviewPane = null;
    private JPanel PreviewPane2 = null;
    private JScrollPane jScrollPane2 = null;
    private Preview PreviewLabel = null;
    private JRadioButton jLayItemOption = null;
    private JMenuItem jItemExit = null;
    private JMenuItem jItemSet = null;
    private JMenuItem jItemHelp = null;
    private JMenuItem jItemAbout = null;
    private JButton jbColor = null;
    private JDialog jdSet = null;
    private JDialog jdHelp = null;
    private JDialog jdAbout = null;
    private JLabel jlbAbout = null;
    private JLabel jlbAbout2 = null;
    private JTextArea jtxHelp = null;
    private JPanel jpHelp = null;
    private JPanel jpAbout = null;
    private JScrollPane jtxSp = null;
//    private ImageManager im = null; // @jve:decl-index=0:visual-constraint="852,149"
    private int eventType = 1;
    private static MapEditor mapEditor = null;

    public static MapEditor getInstance() {
        if (mapEditor == null) {
            mapEditor = new MapEditor();
        }
        return mapEditor;
    }

    /**
     * This is the default constructor
     */
    public MapEditor() {
        super();
        mapEditor = this;
        try {
            enableEvents(AWTEvent.WINDOW_EVENT_MASK);
        } catch (Exception e) {
        }
        pl = new PluginLoader(this);
        initialize();
    }

    @Override
    protected void processWindowEvent(WindowEvent e) {
        boolean enable = false;
        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
//����Jframe�ر��¼�
            int option = JOptionPane.showConfirmDialog(this, "ȷ��Ҫ�˳���", "�ر�ǰ��ע�Ᵽ��", JOptionPane.YES_NO_OPTION);
            enable = (option == 1);
//            if (option == 1) {
//                super.processWindowEvent(e);
//            }
//            if(option == 3){
//                super.processWindowEvent(e);
//            }
        }


        if (!enable) {
//���������¼�������JFrame����
            super.processWindowEvent(e);
        }
    }

    public void copyUndo() {
        if (map == null) {
            return;
        }
        for (int k = map.getLayerNum() - 1; k
            >= 0; k--) {
            for (int i = map.getRow() - 1; i
                >= 0; i--) {
                for (int j = map.getCol() - 1; j
                    >= 0; j--) {
                    undoMap[nIndex][k][i][j] = map.getMap()[k][i][j];
                }
            }
        }
    }

    public void copyRedo() {
        if (map == null) {
            return;
        }
        for (int k = map.getLayerNum() - 1; k
            >= 0; k--) {
            for (int i = map.getRow() - 1; i
                >= 0; i--) {
                for (int j = map.getCol() - 1; j
                    >= 0; j--) {
                    redoMap[nIndex][k][i][j] = map.getMap()[k][i][j];


                }
            }
        }
    }
    // ��ʼ��ͼ�������
//
//    private void creatIM() {
//        if (im == null) {
//            im = new ImageManager(this);
//        }
//    }
//    private JMenuItem imageItem;
//
//    private JMenuItem getJMenuItem15() {
//        if (imageItem == null) {
//            imageItem = new JMenuItem();
//            imageItem.setText("ͼƬ����");
//            imageItem.addActionListener(new java.awt.event.ActionListener() {
//
//                public void actionPerformed(java.awt.event.ActionEvent e) {
//                    if (!isHasProject) {
//                        JOptionPane.showMessageDialog(getJContentPane(), "�����½���Ŀ");
//                        return;
//                    }
////                    creatIM();
//                    im.setVisible(true);
//                }
//            });
//        }
//        return imageItem;
//    }

    private JDialog getHelpDialog() {
        if (jdHelp == null) {
            jdHelp = new JDialog(this);
            jdHelp.setSize(334, 352);
            Dimension screenSize =
                Toolkit.getDefaultToolkit().getScreenSize();
            Dimension labelSize = jdHelp.getSize();
            jdHelp.setLocation(screenSize.width / 2 - (labelSize.width / 2),
                screenSize.height / 2 - (labelSize.height / 2));//����λ����Ļ�в�
            jdHelp.setTitle("����");
            jdHelp.setModal(true);
            jdHelp.setContentPane(getHelpPanel());
        }
        return jdHelp;
    }
    private EventManager jdEvent;

    private JDialog getEventDialog() {
        if (jdEvent == null) {
            jdEvent = new EventManager(this);
            jdEvent.setSize(340, 360);
            Dimension screenSize =
                Toolkit.getDefaultToolkit().getScreenSize();
            Dimension labelSize = jdEvent.getSize();
            jdEvent.setLocation(screenSize.width / 2 - (labelSize.width / 2),
                screenSize.height / 2 - (labelSize.height / 2));//����λ����Ļ�в�
            jdEvent.setTitle("��д�ű�:");
            jdEvent.setModal(true);
            jdEvent.setContentPane(getEventPanel());
        }
        return jdEvent;
    }
    private JPanel jpEvent;
    private JTextArea jtxEvent;
    private JScrollPane jtxEventSp;
    private JButton jbEventOk;
    private JButton jbEventCancle;

    private JPanel getEventPanel() {
        if (jpEvent == null) {
            jpEvent = new JPanel();
            jpEvent.setLayout(null);
            jtxEvent = new JTextArea();
            jtxEventSp = new JScrollPane(jtxEvent);
            jtxEventSp.setBounds(10, 10, 310, 270);
            jpEvent.add(jtxEventSp, null);
            jpEvent.add(getEventOk(), null);
            jpEvent.add(getEventCancle(), null);
        }
        return jpEvent;
    }
    public int eventX = 0, eventY = 0;

    private JButton getEventOk() {
        if (jbEventOk == null) {
            jbEventOk = new JButton();
            jbEventOk.setText("ȷ��");
            jbEventOk.setBounds(27, 295, 50, 20);
//            jItemExit.addActionListener(this);
            jbEventOk.addActionListener(new java.awt.event.ActionListener() {

                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
//map.getScriptList().addScript(eventX, eventY);
                    if (!jtxEvent.getText().equals("")) {

//                        map.getScriptList()[eventY][eventX].setIsNull(false);
                        String[] ss = jtxEvent.getText().split("\n");
                        int n = ss.length;

                        int t = 0;
                        for (int i = 0; i < n; i++) {
                            if (!ss[i].equals("")) {
                                t++;
                            }
                        }
                        if (t == 0) {
                            map.getScriptList()[eventY][eventX] = null;
                            jdEvent.setVisible(false);
                            mapCanvas.repaint();
                            return;
                        }
                        Script s = new Script(eventX, eventY);
                        for (int i = 0; i < n; i++) {
                            s.addString(ss[i]);
                        }

                        map.getScriptList()[eventY][eventX] = s;

//                        map.getScriptList()[eventY][eventX].addString(jtxEvent.getText());
                    } else {
                        map.getScriptList()[eventY][eventX] = null;
                    }
                    jdEvent.setVisible(false);
                    mapCanvas.repaint();
                }
            });
        }
        return jbEventOk;
    }
//    public ScriptList sl = new ScriptList();

    private JButton getEventCancle() {
        if (jbEventCancle == null) {
            jbEventCancle = new JButton();
            jbEventCancle.setText("ȡ��");
            jbEventCancle.setBounds(254, 295, 50, 20);
//            jItemExit.addActionListener(this);
            jbEventCancle.addActionListener(new java.awt.event.ActionListener() {

                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    jdEvent.setVisible(false);
                }
            });

        }
        return jbEventCancle;
    }

    private JPanel getHelpPanel() {
        if (jpHelp == null) {
            jpHelp = new JPanel();
            jpHelp.setLayout(new BorderLayout());
            jtxHelp = new JTextArea();
            jtxHelp.append(
                "���ѽ��:\n"
                + "�����ռ��У�����bug������̳��������\n"
                + "Email��397093109@qq.com\n"
                + "����������ע����֮����\n"
                + "��ַ��www.soyostar.com\n"
                + "qqȺ 56126581��ӭ��ļ���\n"
                + "������\n"
                + "�½�����->�½���ͼ->���Ƶ�ͼ->������ײ->��������λ��->�༭�¼�->�༭��Ϸ����->�༭��Ϸ����->����\n"
                + "����Ŀ�ļ��� Game.jar��Ϊ���ɵ���Ϸ��,enjoy it!");
            jtxSp = new JScrollPane(jtxHelp);
            jpHelp.add(jtxSp, BorderLayout.CENTER);

        }
        return jpHelp;
    }

    private JPanel getAboutPanel() {
        if (jpAbout == null) {
            jpAbout = new JPanel();
            jlbAbout = new JLabel();
            jlbAbout2 = new JLabel();
            jlbAbout.setText(
                "������������֮����̳");
            jlbAbout.addMouseListener(new MouseListener() {

                @Override
                public void mousePressed(MouseEvent e) {
                }

                @Override
                public void mouseClicked(MouseEvent e) {
                    try {
                        java.awt.Desktop.getDesktop().browse(new URI("http://www.soyostar.com"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
//                        Logger.getLogger(MapEditor.class.getName()).log(Level.SEVERE, null, ex);
                    }
//                    try {
//                        Runtime.getRuntime().exec("cmd /c start www.soyostar.com");
//                    } catch (Exception ee) {
//                        // TODO Auto-generated catch block
//                        System.out.println("Error");
//                    }
                    // ���������ʱ�¼�
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    // ����������ʱ�¼�
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    // ��������˳�ʱ�¼�
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                }
            });
            jlbAbout2.setText(version);
            jpAbout.add(jlbAbout2);
            jpAbout.add(jlbAbout);

        }
        return jpAbout;
    }

    private JDialog getAboutDialog() {
        if (jdAbout == null) {
            jdAbout = new JDialog(this);
            jdAbout.setSize(234, 122);
            Dimension screenSize =
                Toolkit.getDefaultToolkit().getScreenSize();
            Dimension labelSize = jdAbout.getSize();
            jdAbout.setLocation(screenSize.width / 2 - (labelSize.width / 2),
                screenSize.height / 2 - (labelSize.height / 2));//����λ����Ļ�в�
            jdAbout.setTitle("����");
            jdAbout.setResizable(false);
            jdAbout.setModal(true);
            jdAbout.setContentPane(getAboutPanel());
        }
        return jdAbout;
    }

    private JMenuItem getJMenuItemExit() {
        if (jItemExit == null) {
            jItemExit = new JMenuItem();
            jItemExit.setText("�˳�");
//            jItemExit.addActionListener(this);
            jItemExit.addActionListener(new java.awt.event.ActionListener() {

                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    System.exit(0);
                }
            });
        }
        return jItemExit;
    }

    private JMenu getJMenuHelp() {
        if (jMenu_help == null) {
            jMenu_help = new JMenu();
            jMenu_help.setText("����(H)");
            jMenu_help.setMnemonic('H');

            jItemHelp = new JMenuItem();
            jItemHelp.setText("����");
            jItemHelp.setAccelerator(KeyStroke.getKeyStroke("F1"));
//            jItemHelp.addActionListener(this);
            jItemHelp.addActionListener(new java.awt.event.ActionListener() {

                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    getHelpDialog().setVisible(true);
//                    try {
//                        Runtime.getRuntime().exec("hh "+"Help.chm");
//                    } catch (IOException ee) {
//                        System.out.println("�����ļ���ʧ");
//                    }

                }
            });
            jMenu_help.add(jItemHelp);
            jItemAbout = new JMenuItem();
            jItemAbout.setText("����");
//            jItemAbout.addActionListener(this);
            jItemAbout.addActionListener(new java.awt.event.ActionListener() {

                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    getAboutDialog().setVisible(true);
                }
            });
            jMenu_help.add(jItemAbout);
        }
        return jMenu_help;
    }

    private JRadioButton getJMenuLayOption() {
        if (jLayItemOption == null) {
            jLayItemOption = new JRadioButton();
            jLayItemOption.setText("��ײ");
            jLayItemOption.setToolTipText("�л���ײ�༭");
            jLayItemOption.setFocusable(false);
//            jLayItemOption.addActionListener(this);
            jLayItemOption.addActionListener(new java.awt.event.ActionListener() {

                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    slButton.setText("״̬��������ײ");
                    isCollide = true;
                    isChoose = false;
                    isFill = false;
//                    isNumShow = true;
                    isMapGrid = true;
                    isEvent = false;
                    if (map != null) {
                        mapCanvas.repaint();

                    }
                }
            });

        }
        return jLayItemOption;
    }

    private JToolBar getSbToolBar() {
        if (toolBar == null) {
            toolBar = new JToolBar("״̬��");
            GarbagePanel garbagePanel = new GarbagePanel();
            toolBar.add(getLeftButton());
            toolBar.add(getCenterButton());
            toolBar.addSeparator(new Dimension(52, 20));
            toolBar.add(garbagePanel);
            toolBar.setRollover(false);
            toolBar.setFloatable(false);
        }
        return toolBar;
    }

    private JToolBar getToolBar2() {
        if (tileToolBar == null) {
            tileToolBar = new JToolBar("������");
            tileToolBar.add(getNewButton());
            tileToolBar.add(getOpenButton());
            tileToolBar.add(getSaveButton());
            tileToolBar.add(getUndoButton());
            tileToolBar.add(getRedoButton());
            tileToolBar.add(getTileGridButton());
//            tileToolBar.add(getRotateButton());
            tileToolBar.add(getMapGridButton());
            tileToolBar.addSeparator();
            tileToolBar.add(getPreviewButton());
            buttonGroup3.add(getEditButton());
            buttonGroup3.add(getFillButton());
            buttonGroup3.add(getPenButton());
            buttonGroup3.add(getEventButton());
            buttonGroup3.add(getJMenuLayOption());
            tileToolBar.add(getPenButton());
            tileToolBar.add(getFillButton());
            tileToolBar.add(getEditButton());
            tileToolBar.add(getEventButton());
            tileToolBar.add(getJMenuLayOption());
            try {
                JButton[] toolButton = null;
                if (pl.getMenuItem() != null) {
                    toolButton = pl.getButton();
                }
                if (toolButton != null) {
                    int ii = toolButton.length;
                    for (int i = 0; i
                        < ii; i++) {
                        if (toolButton[i] != null) {
                            tileToolBar.add(toolButton[i]);

                        }
                    }
                }
            } catch (Exception e) {
                // TODO �Զ����� catch ��
            }
        }
        return tileToolBar;

    }

    public JButton getLeftButton() {
        if (slButton == null) {
            slButton = new JButton();
            slButton.setText("״̬������");
            slButton.setEnabled(false);

        }
        return slButton;

    }

    public JButton getCenterButton() {
        if (scButton == null) {
            scButton = new JButton();
            scButton.setText("��ǰͼ�㣺δ��ʼ");
            scButton.setEnabled(false);

        }
        return scButton;

    }

    public JButton getMapGridButton() {
        if (mapGridButton == null) {
            //sbRightButton = new JButton("�л�������ʾ");
            ImageIcon img = new ImageIcon("icon/grid2.png");
            mapGridButton = new JButton(img);
            mapGridButton.setToolTipText("�л�map������ʾ");
            mapGridButton.setFocusable(false);
//            mapGridButton.setEnabled(false);
//            mapGridButton.addActionListener(this);
            mapGridButton.addActionListener(new java.awt.event.ActionListener() {

                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    isMapGrid = !isMapGrid;

                    if (map != null) {
                        mapCanvas.repaint();
                    }
                }
            });
        }
        return mapGridButton;
    }

    public JButton getTileGridButton() {
        if (TileGridButton == null) {
            //sbRightButton = new JButton("�л�������ʾ");
            ImageIcon img = new ImageIcon("icon/grid.png");
            TileGridButton = new JButton(img);
            TileGridButton.setToolTipText("�л�tile������ʾ");
            TileGridButton.setFocusable(false);
//            TileGridButton.setEnabled(false);
//            TileGridButton.addActionListener(this);
            TileGridButton.addActionListener(new java.awt.event.ActionListener() {

                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    isTileGrid = !isTileGrid;
                    if (map != null) {
                        tileCanvas.repaint();
                    }
                }
            });
        }
        return TileGridButton;
    }

    private JButton getNewButton() {
        if (newButton == null) {
            //sbRightButton = new JButton("�л�������ʾ");
            ImageIcon img = new ImageIcon("icon/new.png");
            newButton = new JButton(img);
            newButton.setToolTipText("�½�����");
            newButton.setFocusable(false);
//            newButton.addActionListener(this);
            newButton.addActionListener(new java.awt.event.ActionListener() {

                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
//                    getJDialog();
//                    initJComboBox();
//                    jDialog.setVisible(true);
                    getJDialogNewPro();
                    jDialogNewPro.setVisible(true);
                }
            });
        }
        return newButton;

    }

    public MapList getMapVector() {
        return mapVector;
    }
    private JButton openButton = null;

    private JButton getOpenButton() {
        if (openButton == null) {
            //sbRightButton = new JButton("�л�������ʾ");
            ImageIcon img = new ImageIcon("icon/open.png");
            openButton = new JButton(img);
            openButton.setToolTipText("�򿪹���");
            openButton.setFocusable(false);
            openButton.addActionListener(this);
            openButton.addActionListener(new java.awt.event.ActionListener() {

                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    openProject();
                }
            });
        }
        return openButton;
    }

    private void openProject() {
        JFileChooser jf = new JFileChooser(new File("."));
        jf.setFileFilter(new MEFileFilter());
        jf.showOpenDialog(getJContentPane());
        File f = jf.getSelectedFile();
        if (f != null && f.getName().endsWith(".project")) {
            System.out.println("open " + f.getParent());
            if (loadProject(f)) {
                Project.setProjectPath(f.getParent());
                changeTitle();
                initMapVector();
                File file = new File(f.getParent() + "\\data\\map");
                int sum = file.listFiles().length;
//                System.out.println("sum " + sum);
                File[] fi = file.listFiles();
//                tempMapV = new MapList();
                for (int i = 0; i
                    < sum; i++) {
                    if (fi[i].getName().endsWith(".gat")) {
                        loadMapVector(fi[i]);
                    }
                }
////                System.out.println(tempMapV.size());
//                for (int i = 0; i < tempMapV.size(); i++) {
//                    mapVector.addMap(tempMapV.mapAt(i));
//                }
////                mapVector = tempMapV;

//                System.out.println("mapVectorIsEmpty " + mapVector.isEmpty());
                if (!mapVector.isEmpty()) {
                    map = mapVector.mapAt(0);
//                    System.out.println(map.getLayerNum());
                    undoMap = new int[10][map.getLayerNum()][map.getRow()][map.getCol()];
                    redoMap = new int[10][map.getLayerNum()][map.getRow()][map.getCol()];
                    layerNum = map.getLayerNum();
                    currentLayer = 0;
                    getJMenu1().repaint();
                    initMapCanvas();
                }
                creatAM();
//                creatIM();
                creatDM();
//                creatMM();

                jTable.updateTable();
                JOptionPane.showMessageDialog(getJContentPane(),
                    "�򿪳ɹ�");
            } else {
                // ����ʧ��
                JOptionPane.showMessageDialog(getJContentPane(),
                    "��ʧ��");
            }
        }
    }

    private JButton getSaveButton() {
        if (saveButton == null) {
            //sbRightButton = new JButton("�л�������ʾ");
            ImageIcon img = new ImageIcon("icon/save.png");
            saveButton = new JButton(img);
            saveButton.setToolTipText("���湤��");
            saveButton.setFocusable(false);
            saveButton.addActionListener(this);
            saveButton.addActionListener(new java.awt.event.ActionListener() {

                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    if (!isHasProject) {
                        JOptionPane.showMessageDialog(getJContentPane(), "�����½���Ŀ");
                        return;
                    }
                    savePro();
                }
            });
        }
        return saveButton;
    }

    private void savePro() {
        if (saveProject()) {
            JOptionPane.showMessageDialog(getJContentPane(), "����ɹ�");
        } else {
            JOptionPane.showMessageDialog(getJContentPane(), "����ʧ��");
        }
    }

    public JButton getUndoButton() {
        if (undoButton == null) {
            ImageIcon img = new ImageIcon("icon/undo.png");
            undoButton = new JButton(img);
            undoButton.setToolTipText("����");
            undoButton.setFocusable(false);
//            undoButton.addActionListener(this);
            undoButton.addActionListener(new java.awt.event.ActionListener() {

                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    if (map != null) {
                        nIndex--;
                        if (nIndex < 0) {
                            nIndex = 0;

                        }
                        for (int k = 0; k
                            < map.getLayerNum(); k++) {
                            for (int i = 0; i
                                < map.getRow(); i++) {
                                System.arraycopy(undoMap[nIndex][k][i], 0, map.getMap()[k][i], 0, map.getCol());
                            }
                        }
                        if (map != null) {
                            mapCanvas.updateCanvas();
                        }
                    }
                }
            });
        }
        return undoButton;
    }

    public JButton getRedoButton() {
        if (redoButton == null) {
            ImageIcon img = new ImageIcon("icon/redo.png");
            redoButton = new JButton(img);
            redoButton.setToolTipText("�ָ�");
            redoButton.setFocusable(false);
//            redoButton.addActionListener(this);
            redoButton.addActionListener(new java.awt.event.ActionListener() {

                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    if (map != null) {
                        for (int k = 0; k
                            < map.getLayerNum(); k++) {
                            for (int i = 0; i
                                < map.getRow(); i++) {
                                System.arraycopy(redoMap[nIndex][k][i], 0, map.getMap()[k][i], 0, map.getCol());
                            }
                        }
                        nIndex++;

                        if (nIndex > 9) {
                            nIndex = 9;
                        }
                        if (map != null) {
                            mapCanvas.updateCanvas();
                        }
                    }
                }
            });

        }
        return redoButton;

    }
    private JRadioButton eventButton;

    public JRadioButton getEventButton() {
        if (eventButton == null) {
            eventButton = new JRadioButton("�¼�");
            eventButton.setToolTipText("�л��¼��༭");
            eventButton.setFocusable(false);
//            editCheck.addActionListener(this);
            eventButton.addActionListener(new java.awt.event.ActionListener() {

                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    slButton.setText("״̬�������¼�");
                    isEvent = true;
                    isMapGrid = true;
                    isChoose = false;
                    isFill = false;
                    isCollide = false;

                    if (map != null) {
                        mapCanvas.updateCanvas();
                    }
                }
            });

        }
        return eventButton;

    }
    private boolean isEvent;

    public JRadioButton getEditButton() {
        if (editCheck == null) {
            editCheck = new JRadioButton("ѡ��");
            editCheck.setToolTipText("�л�ѡ��༭");
            editCheck.setFocusable(false);
//            editCheck.addActionListener(this);
            editCheck.addActionListener(new java.awt.event.ActionListener() {

                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    slButton.setText("״̬��ѡ��ģʽ");
                    isChoose = true;
                    isFill = false;
                    isCollide = false;
                    isEvent = false;
                    if (map != null) {
                        mapCanvas.updateCanvas();

                    }
                }
            });

        }
        return editCheck;

    }
    private JRadioButton penCheck;

    public JRadioButton getPenButton() {
        if (penCheck == null) {
            penCheck = new JRadioButton("��ͼ");
            penCheck.setToolTipText("�л���ͼ�༭");
            penCheck.setFocusable(false);
            penCheck.setSelected(true);
            penCheck.addActionListener(new java.awt.event.ActionListener() {

                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    slButton.setText("״̬����ͼģʽ");
                    isChoose = false;
                    isFill = false;
                    isCollide = false;
                    isEvent = false;

                    if (map != null) {
                        mapCanvas.updateCanvas();
                    }
                }
            });

        }
        return penCheck;

    }

    public JRadioButton getFillButton() {
        if (fillCheck == null) {
            fillCheck = new JRadioButton("���");
            fillCheck.setToolTipText("�л����༭");
            fillCheck.setFocusable(false);
//            fillCheck.addActionListener(this);
            fillCheck.addActionListener(new java.awt.event.ActionListener() {

                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    slButton.setText("״̬�����ģʽ");
                    isFill = true;
                    isChoose = false;
                    isCollide = false;
                    isEvent = false;
                    if (map != null) {
                        mapCanvas.updateCanvas();
                    }
                }
            });
        }
        return fillCheck;

    }

    public JCheckBox getPreviewButton() {
        if (PrevCheck == null) {
            PrevCheck = new JCheckBox("Ԥ��");
            PrevCheck.setToolTipText("�л�Ԥ����ʾ");
            PrevCheck.setFocusable(false);
//            PrevCheck.addActionListener(this);
            PrevCheck.addActionListener(new java.awt.event.ActionListener() {

                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    if (!isHasProject) {
                        JOptionPane.showMessageDialog(getJContentPane(), "�����½���Ŀ");
                        PrevCheck.setSelected(false);
                        return;
                    }
                    if (PrevCheck.isSelected()) {
                        isPreview = true;
                    } else {
                        isPreview = false;
                    }

                    getPreviewDialog();
                    PreviewDialog.setVisible(isPreview);
                }
            });
        }
        return PrevCheck;

    }
    private JMenuItem jMusicMenuItem;
//    private MusicManager mum;
//
//    private void creatMM() {
//        mum = new MusicManager(this);
//    }

//    private JMenuItem getMusicMenuItem() {
//        if (jMusicMenuItem == null) {
//            jMusicMenuItem = new JMenuItem();
//            jMusicMenuItem.setText("���ֹ���");
//            jMusicMenuItem.addActionListener(new java.awt.event.ActionListener() {
//
//                @Override
//                public void actionPerformed(java.awt.event.ActionEvent e) {
//                    if (!isHasProject) {
//                        JOptionPane.showMessageDialog(getJContentPane(), "�����½���Ŀ");
//                        return;
//                    }
//                    creatMM();
//                    mum.setVisible(true);
//
//                }
//            });
//        }
//        return jMusicMenuItem;
//
//    } //    public JMenuItem getRotateButton() {
    //        if (rotateButton == null) {
    //            rotateButton = new JMenuItem("ԭͼ��ת");
    ////            rotateButton.setFocusable(false);
    ////            rotateButton.setEnabled(false);
    ////            rotateButton.addActionListener(this);
    //            rotateButton.addActionListener(new java.awt.event.ActionListener() {
    //
    //                @Override
    //                public void actionPerformed(java.awt.event.ActionEvent e) {
    //                    isRotate = !isRotate;
    //
    //
    //                    if (map != null) {
    //                        tileCanvas.updateCanvas();
    //
    //
    //                    }
    //                }
    //            });
    //
    //
    //        }
    //        return rotateButton;
    //
    //
    //    }
    private JDialog getPreviewDialog() {
        if (PreviewDialog == null) {
            PreviewDialog = new JDialog(this);
            PreviewDialog.setBounds(900, 120, 334, 384);
        }

        PreviewDialog.addWindowListener(new WindowAdapter() {                  //���ڹر��¼�������ʵ��

            @Override
            public void windowClosing(WindowEvent evt) {
                PrevCheck.setSelected(false);
            }
        });
        if (map != null) {
            initPreTitle();
            PreviewDialog.setContentPane(getPreviewPanel());
        }
        return PreviewDialog;
    }

    private void initPreTitle() {
        PreviewDialog.setTitle("Ԥ�� ��ͼ��" + map.getName());
    }

    private JPanel getPreviewPanel() {
        if (PreviewPane == null) {
            PreviewPane = new JPanel();
            PreviewPane.setLayout(new BorderLayout());
            PreviewPane.add(getJScrollPane2(), BorderLayout.CENTER);
            PreviewPane.add(getJSliderPreview(), BorderLayout.NORTH);
            PreviewPane.add(getJSliderPreview2(), BorderLayout.SOUTH);
        }
        return PreviewPane;

    }

    private JSlider getJSliderPreview2() {
        if (jpb2 == null) {
            jpb2 = new JSlider(0, 360);
            jpb2.setValue(0);
            jpb2.setPaintTicks(true);
            jpb2.setPaintLabels(true);
            jpb2.setMajorTickSpacing(60);
            jpb2.addChangeListener(this);
        }
        return jpb2;
    }

    private JPanel getPreview() {
        if (PreviewPane2 == null) {
            PreviewPane2 = new JPanel();
            PreviewPane2.add(getPreviewLabel());
        }
        return PreviewPane2;

    }

    private JSlider getJSliderPreview() {
        if (jpb == null) {
            jpb = new JSlider(-90, 90);
            jpb.setValue(-50);
            jpb.setPaintTicks(true);
            jpb.setPaintLabels(true);
            jpb.setMajorTickSpacing(30);
            jpb.addChangeListener(this);

        }
        return jpb;
    }

    private JSlider getJSliderSet() {
        if (jpb3 == null) {
            jpb3 = new JSlider(0, 250);
            jpb3.setValue(125);
            jpb3.setBounds(60, 50, 200, 40);
            jpb3.setPaintTicks(true);
            jpb3.setPaintLabels(true);
            jpb3.setMajorTickSpacing(50);
            jpb3.addChangeListener(this);

        }
        return jpb3;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (map != null) {
            mapCanvas.updateCanvas();
        }
        getJSliderSet().setToolTipText("��ǰ͸����Ϊ��" + jpb3.getValue());
        getJSliderPreview().setToolTipText("Ԥ�����ű�����ǰΪ��" + jpb.getValue());
        getJSliderPreview2().setToolTipText("��ת�ǵ�ǰΪ��" + jpb2.getValue());
//        getPreviewDialog().repaint();

    }

    private Preview getPreviewLabel() {
        if (PreviewLabel == null) {
            PreviewLabel = new Preview();

        }
        return PreviewLabel;

    }
    //Ԥ��

    private JScrollPane getJScrollPane2() {
        if (jScrollPane2 == null) {
            jScrollPane2 = new JScrollPane(getPreview());
            jScrollPane2.setPreferredSize(new Dimension(250, 250));

        }
        return jScrollPane2;


    }

    class Preview extends JLabel {

        private static final long serialVersionUID = 1L;

        public Preview() {
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            if (map != null) {
//                for (int i = 0; i < map.getLayerNum(); i++) {
                g.drawImage(bf, 0, 0, Color.WHITE, null);
//                }
            }
        }

        public void updateCanvas() {
            if (map == null) {
                return;
            }
            ImageIcon temp = null;
            temp = new ImageIcon(bf);
            setIcon(temp);
            repaint();
        }
    }
    /**
     * This method initializes jButton
     *
     * @return javax.swing.JButton
     */
    public int layerNum = 1;//Ĭ��Ϊ1��
    public int[][][][] undoMap;//�����õĻ�������
    public int[][][][] redoMap;//�����õĻ�������
    public int nIndex = 0;

    private JButton getJButton() {
        if (jButton == null) {
            jButton = new JButton();
            jButton.setText("ȷ��");
            jButton.setLocation(new Point(255, 40));
            jButton.setSize(new Dimension(60, 20));
//            jButton.addActionListener(this);
            jButton.addActionListener(new java.awt.event.ActionListener() {

                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    String mapName = jTmapName.getText();
                    boolean temb = true;
                    File[] f = new File(Project.getProjectPath() + "\\" + "data\\map").listFiles();
                    int ii = f.length;
                    for (int i = 0; i
                        < ii; i++) {
                        if (f[i].getName().equals(mapName + ".gat")) {
                            JOptionPane.showMessageDialog(getJContentPane(), "���иõ�ͼ����������");
                            temb = false;

                            break;
                        }
                    }
                    if (jTLayNum.getText().equals("") || jTLayNum.getText().equals("0") || jTmapRow.getText().equals("") || jTmapRow.getText().equals("0")
                        || jTmapCol.getText().equals("") || jTmapCol.getText().equals("0") || jTcellW.getText().equals("") || jTcellW.getText().equals("0")
                        || jTcellH.getText().equals("") || jTcellH.getText().equals("0")) {
                        JOptionPane.showMessageDialog(getJContentPane(), "��ͼ������Ч������������");
                        temb = false;
                    }
                    if (temb) {

                        String imageName = (String) jComboBox.getSelectedItem();
                        String musicName = (String) jComboBox3.getSelectedItem();
                        if (musicName == null) {
                            musicName = "";
                        }
                        int row = Integer.parseInt(jTmapRow.getText());
                        int col = Integer.parseInt(jTmapCol.getText());
                        int cellWidth = Integer.parseInt(jTcellW.getText());
                        int cellHeight = Integer.parseInt(jTcellH.getText());
                        layerNum = Integer.parseInt(jTLayNum.getText());
                        map = new Map(mapName, imageName, row, col, cellWidth,
                            cellHeight, layerNum);
                        map.setMusicName(musicName);
                        map.setIndex(mapVector.size());
                        mapVector.addMap(map);
                        jTable.updateTable();
                        mapCanvas.setVisible(true);
                        tileCanvas.setVisible(true);
                        undoMap = new int[10][layerNum][row][col];
                        redoMap = new int[10][layerNum][row][col];
//                        sl = new ScriptList();
//                        map.setScriptList(sl);
                        getEventDialog();
                        jtxEvent.setText("");
                        getJMenu1().repaint();
                        getPicJMenu().repaint();
                        currentLayer = 0;
                        slButton.setText("״̬����ͼģʽ");
                        scButton.setText("��ǰͼ�㣺ͼ��" + (currentLayer + 1));
                        initMapCanvas();
                        isFill = false;
                        isCollide = false;
                        isEvent = false;
                        isChoose = false;
                        isMapGrid = false;
                        penCheck.setSelected(true);
//                        ImgItem.setEnabled(true);
                        jDialog.setVisible(false);
                    }
                }
            });
        }
        return jButton;
    }

    /**
     * This method initializes jButton1
     *
     * @return javax.swing.JButton
     */
    private JButton getJButton1() {
        if (jButton1 == null) {
            jButton1 = new JButton();
            jButton1.setText("ȡ��");
            jButton1.setSize(new Dimension(60, 20));
            jButton1.setLocation(new Point(255, 100));
//            jButton1.addActionListener(this);
            jButton1.addActionListener(new java.awt.event.ActionListener() {

                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    jDialog.setVisible(false);
                }
            });
        }
        return jButton1;

    }

    /**
     * This method initializes jContentPane
     *
     * @return javax.swing.JPanel
     */
    private JPanel getJContentPane() {
        if (jContentPane == null) {
            jContentPane = new JPanel();
            jContentPane.setLayout(new BorderLayout());
            jContentPane.add(getJSplitPane(), BorderLayout.CENTER);

        }
        return jContentPane;

    }

    /**
     * This method initializes jContentPane1
     *
     * @return javax.swing.JPanel
     */
    private JPanel getJContentPane1() {
        if (jContentPane1 == null) {
            jLabel5 = new JLabel();
            jLabel5.setText("��ͼ�߶�(��Ԫ����):");
            jLabel5.setBounds(10, 100, 120, 20);
            jLabel4 = new JLabel();
            jLabel4.setText("��ͼ���(��Ԫ����):");
            jLabel4.setBounds(10, 70, 120, 20);
            jLmapImg = new JLabel();
            jLmapImg.setText("��ͼͼ��:");
            jLmapImg.setBounds(10, 160, 60, 20);
            jLcellH = new JLabel();
            jLcellH.setText("��Ԫ��߶�:");
            jLcellH.setBounds(130, 40, 80, 20);
            jLcellW = new JLabel();
            jLcellW.setText("��Ԫ����:");
            jLcellW.setBounds(10, 40, 75, 20);
            jLmapName = new JLabel();
            jLmapName.setText("��ͼ����:");
            jLmapName.setBounds(10, 10, 60, 20);
            jLLayNum = new JLabel();
            jLLayNum.setText("ͼ����:");
            jLLayNum.setBounds(10, 130, 60, 20);
            JLabel jMapMusic = new JLabel();
            jMapMusic.setText("��������:");
            jMapMusic.setBounds(10, 190, 60, 20);
            jContentPane1 = new JPanel();
            jContentPane1.setLayout(null);
            jContentPane1.add(jLmapName, null);
            jContentPane1.add(jLcellW, null);
            jContentPane1.add(jLcellH, null);
            jContentPane1.add(jLmapImg, null);
            jContentPane1.add(jMapMusic, null);
            jTmapName = new JTextField();
            jTmapName.setBounds(80, 10, 160, 20);
            jContentPane1.add(jTmapName, null);
            jTcellW = new JTextField();
            jTcellW.setBounds(80, 40, 40, 20);
            jContentPane1.add(jTcellW, null);
            jTcellH = new JTextField();
            jTcellH.setBounds(200, 40, 40, 20);
            jContentPane1.add(jTcellH, null);
            jComboBox = new JComboBox();
            jComboBox.setBounds(80, 160, 160, 20);
            jComboBox3 = new JComboBox();
            jComboBox3.setBounds(80, 190, 160, 20);
            jContentPane1.add(jComboBox, null);
            jContentPane1.add(jComboBox3, null);
            jContentPane1.add(getJButton(), null);
            jContentPane1.add(getJButton1(), null);
            jContentPane1.add(jLabel4, null);
            jContentPane1.add(jLabel5, null);
            jTmapCol = new JTextField();
            jTmapCol.setBounds(130, 70, 110, 20);
            jContentPane1.add(jTmapCol, null);
            jTmapRow = new JTextField();
            jTmapRow.setBounds(130, 100, 110, 20);
            jContentPane1.add(jTmapRow, null);
            jContentPane1.add(jLLayNum, null);
            jTLayNum = new JTextField();
            jTLayNum.setBounds(80, 130, 40, 20);
            jContentPane1.add(jTLayNum, null);
        }
        return jContentPane1;
    }
    private JTextField jTmapName2, jTcellW2, jTcellH2, jTmapCol2, jTmapRow2, jTLayNum2;
    private JLabel jLmapImg2;

    private JPanel getJContentPane3() {
        if (jContentPane3 == null) {
            jContentPane3 = new JPanel();
            jContentPane3.setLayout(null);
            jLabel5 = new JLabel();
            jLabel5.setText("��ͼ�߶�(��Ԫ����):");
            jLabel5.setBounds(10, 100, 120, 20);
            jLabel4 = new JLabel();
            jLabel4.setText("��ͼ���(��Ԫ����):");
            jLabel4.setBounds(10, 70, 120, 20);
            jLcellH = new JLabel();
            jLcellH.setText("��Ԫ��߶�:");
            jLcellH.setBounds(130, 40, 80, 20);
            jLcellW = new JLabel();
            jLcellW.setText("��Ԫ����:");
            jLcellW.setBounds(10, 40, 75, 20);
//            initTextFiled();
            jTmapCol2 = new JTextField();
            jTmapCol2.setBounds(130, 70, 110, 20);
//            jTmapCol2.setText("" + map.getCol());

            jTmapRow2 = new JTextField();
//            jTmapRow2.setText("" + map.getRow());
            jTmapRow2.setBounds(130, 100, 110, 20);

            jTmapName2 = new JTextField();
//            jTmapName2.setText(map.getName());
            jTmapName2.setBounds(80, 10, 160, 20);
            jTcellW2 = new JTextField();
//            jTcellW2.setText("" + map.getCellWidth());
            jTcellW2.setBounds(80, 40, 40, 20);

            jTcellH2 = new JTextField();
//            jTcellH2.setText("" + map.getCellHeight());
            jTcellH2.setBounds(200, 40, 40, 20);

            jComboBox2 = new JComboBox();
            jComboBox2.setBounds(80, 160, 160, 20);
            jComboBox4 = new JComboBox();
            jComboBox4.setBounds(80, 190, 160, 20);
            jTLayNum2 = new JTextField();
//            jTLayNum2.setText("" + map.getLayerNum());
            jTLayNum2.setBounds(80, 130, 40, 20);
            jContentPane3.add(jTmapCol2, null);

            jContentPane3.add(jTmapRow2, null);
            jLmapName = new JLabel();
            jLmapName.setText("��ͼ����:");
            jLmapName.setBounds(10, 10, 60, 20);

            jContentPane3.add(jTmapName2, null);

            jContentPane3.add(jTcellW2, null);

            jContentPane3.add(jTcellH2, null);
            jLLayNum = new JLabel();
            jLLayNum.setText("ͼ����:");
            jLLayNum.setBounds(10, 130, 60, 20);
            jLmapImg2 = new JLabel();
            jLmapImg2.setText("��ͼͼ��:");
            jLmapImg2.setBounds(10, 160, 60, 20);
            JLabel jMapMusic = new JLabel();
            jMapMusic.setText("��������:");
            jMapMusic.setBounds(10, 190, 60, 20);
            jContentPane3.add(jMapMusic, null);
            jContentPane3.add(jComboBox2, null);
            jContentPane3.add(jComboBox4, null);
            jContentPane3.add(jLmapImg2, null);
            jContentPane3.add(jLmapName, null);
            jContentPane3.add(jLcellW, null);
            jContentPane3.add(jLcellH, null);
            jContentPane3.add(getJButton2(), null);
            jContentPane3.add(getJButton3(), null);
            jContentPane3.add(jLabel4, null);
            jContentPane3.add(jLabel5, null);
            jContentPane3.add(jLLayNum, null);

            jContentPane3.add(jTLayNum2, null);

        }

        return jContentPane3;
    }

    private void initTextFiled() {
        if (mapVector.isEmpty()) {//��ͼΪ��ʱ��Ӧ��ʼ��
            return;
        }
        System.out.println(map.getName());
        jTmapCol2.setText("" + map.getCol());
        jTmapRow2.setText("" + map.getRow());
        jTmapName2.setText(map.getName());
        jTcellW2.setText("" + map.getCellWidth());
        jTcellH2.setText("" + map.getCellHeight());
        jTLayNum2.setText("" + map.getLayerNum());
    }
    private JButton jButton2;

    private JButton getJButton2() {
        if (jButton2 == null) {
            jButton2 = new JButton();
            jButton2.setText("ȷ��");
            jButton2.setLocation(new Point(255, 40));
            jButton2.setSize(new Dimension(60, 20));
//            jButton.addActionListener(this);
            jButton2.addActionListener(new java.awt.event.ActionListener() {

                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    boolean temb = true;
                    if (jTLayNum2.getText().equals("") || jTLayNum2.getText().equals("0") || jTcellW2.getText().equals("") || jTcellW2.getText().equals("0")
                        || jTcellH2.getText().equals("") || jTcellH2.getText().equals("0")) {
                        JOptionPane.showMessageDialog(getJContentPane(), "��ͼ������Ч������������");
                        temb = false;
                    }
                    if (temb) {
                        String imageName = (String) jComboBox2.getSelectedItem();
                        String musicName = (String) jComboBox4.getSelectedItem();
                        map.setImage(imageName);
                        map.setMusicName(musicName);
                        String mapName = jTmapName2.getText();
                        map.setName(mapName);
                        int cellWidth = Integer.parseInt(jTcellW2.getText());
                        map.setCellWidth(cellWidth);
                        int cellHeight = Integer.parseInt(jTcellH2.getText());
                        map.setCellHeight(cellHeight);
                        upDateMap();
                        getJMenu1().repaint();
                        getPicJMenu().repaint();

                        getPreviewDialog();
                        initPreTitle();
                        initMapCanvas();
                        jDialog1.setVisible(false);
                    }
                }
            });
        }
        return jButton2;

    }
    private int newMap[][][], newWay[][];

    public void upDateMap() {
        newMap = new int[Integer.parseInt(jTLayNum2.getText())][Integer.parseInt(jTmapRow2.getText())][Integer.parseInt(jTmapCol2.getText())];
        newWay = new int[Integer.parseInt(jTmapRow2.getText())][Integer.parseInt(jTmapCol2.getText())];

        for (int ii = 0; ii
            < ((map.getMap().length < newMap.length) ? map.getMap().length : newMap.length); ii++) {
            for (int jj = 0; jj
                < ((map.getMap()[0].length < newMap[0].length) ? map.getMap()[0].length : newMap[0].length); jj++) {
                System.arraycopy(map.getMap()[ii][jj], 0, newMap[ii][jj], 0, ((map.getMap()[0][0].length < newMap[0][0].length) ? map.getMap()[0][0].length : newMap[0][0].length));
            }
        }
        for (int ii = 0; ii
            < ((map.getWay().length < newWay.length) ? map.getWay().length : newWay.length); ii++) {
            System.arraycopy(map.getWay()[ii], 0, newWay[ii], 0, ((map.getWay()[0].length < newWay[0].length) ? map.getWay()[0].length : newWay[0].length));

        }
        map.setCol(newMap[0][0].length);
        map.setRow(newMap[0].length);
        map.setLayerNum(newMap.length);
        layerNum = map.getLayerNum();
        upDateArray(
            newMap);
        map.update(newMap, newWay);

    }

    private void upDateArray(int[][][] ma) {
        undoMap = null;
        redoMap = null;
        undoMap = new int[10][ma.length][ma[0].length][ma[0][0].length];
        redoMap = new int[10][ma.length][ma[0].length][ma[0][0].length];
    }
    private JButton jButton3;

    private JButton getJButton3() {
        if (jButton3 == null) {
            jButton3 = new JButton();
            jButton3.setText("ȡ��");
            jButton3.setSize(new Dimension(60, 20));
            jButton3.setLocation(new Point(255, 100));
//            jButton.addActionListener(this);
            jButton3.addActionListener(new java.awt.event.ActionListener() {

                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    jDialog1.setVisible(false);
                }
            });

        }
        return jButton3;
    }
    private JPanel jContentPane3;
    private JDialog jDialog1;

    private JDialog getJDialog1() {
        if (jDialog1 == null) {
            jDialog1 = new JDialog(this);
            jDialog1.setSize(334, 262);
            Dimension screenSize =
                Toolkit.getDefaultToolkit().getScreenSize();
            Dimension labelSize = jDialog1.getSize();
            jDialog1.setLocation(screenSize.width / 2 - (labelSize.width / 2),
                screenSize.height / 2 - (labelSize.height / 2));//����λ����Ļ�в�
            jDialog1.setTitle("��ͼ�����޸�");
            jDialog1.setResizable(false);
            jDialog1.setModal(true);
            jDialog1.setContentPane(getJContentPane3());

        }
        return jDialog1;

    }

    /**
     * This method initializes jDialog
     *
     * @return javax.swing.JDialog
     */
    private JDialog getJDialog() {
        if (jDialog == null) {
            jDialog = new JDialog(this);
            jDialog.setSize(334, 262);
            Dimension screenSize =
                Toolkit.getDefaultToolkit().getScreenSize();
            Dimension labelSize = jDialog.getSize();
            jDialog.setLocation(screenSize.width / 2 - (labelSize.width / 2),
                screenSize.height / 2 - (labelSize.height / 2));//����λ����Ļ�в�
            jDialog.setTitle("�½���ͼ");
            jDialog.setResizable(false);
            jDialog.setModal(true);
            jDialog.setContentPane(getJContentPane1());

        }
        return jDialog;
    }
    private JLabel jT = null;
    private JRadioButton jcl1 = null;
    private JRadioButton jcl2 = null;

    private JRadioButton getjcl2Button() {
        if (jcl2 == null) {
            jcl2 = new JRadioButton("������ͼ��");
            jcl2.setToolTipText("ѡ�����ݽ�����ͼ��");
            jcl2.setFocusable(false);
            jcl2.setSelected(true);
            jcl2.setBounds(10, 55, 120, 20);
            jcl2.addActionListener(new java.awt.event.ActionListener() {

                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {

                    isAll = false;
                    if (map != null) {
                        mapCanvas.updateCanvas();
                    }
                }
            });
        }
        return jcl2;

    }

    private JRadioButton getjcl1Button() {
        if (jcl1 == null) {
            jcl1 = new JRadioButton("����ͼ�����ײ");
            jcl1.setToolTipText("ѡ�����ݰ���ͼ�����ײ");
            jcl1.setFocusable(false);
//            penCheck.addActionListener(this);
            jcl1.setBounds(10, 30, 120, 20);
            jcl1.addActionListener(new java.awt.event.ActionListener() {

                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    isAll = true;
                    if (map != null) {
                        mapCanvas.updateCanvas();
                    }
                }
            });

        }
        return jcl1;
    }

    private JPanel getJContentPane2() {
        if (jContentPane2 == null) {
            jContentPane2 = new JPanel();
            jLabelcolor = new JLabel("����ɫ");
            jLabelcolor.setBounds(10, 10, 50, 20);
            jbColor = new JButton("����");
            jbColor.setBounds(70, 10, 60, 20);
            jT = new JLabel("͸����");
            jT.setBounds(10, 50, 50, 20);
//            jChoseLabel = new JLabel("ѡ��ģʽ");
//            jChoseLabel.setBounds(10, 100, 65, 20);
//            jbColor.addActionListener(this);
            jbColor.addActionListener(new java.awt.event.ActionListener() {

                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    Color c = JColorChooser.showDialog(getJContentPane(), "ѡ�񱳾�ɫ", Color.GRAY);
                    jPanel.setBackground(c);
                    jPanel1.setBackground(c);
                }
            });
            jContentPane2.setLayout(null);
            jContentPane2.add(jLabelcolor, null);
            jContentPane2.add(jbColor, null);
            jContentPane2.add(jT, null);
//            jContentPane2.add(jChoseLabel, null);
            jContentPane2.add(getJSliderSet(), null);
            jContentPane2.add(getRadioButtonJpanel(), null);
            jContentPane2.add(getRadioButtonJpanel2(), null);
//            jContentPane2.add(getjcl2Button(), null);
        }
        return jContentPane2;
    }
    private JPanel radioButtonJpanel;
    private JPanel radioButtonJpanel2;

    private JPanel getRadioButtonJpanel2() {
        if (radioButtonJpanel2 == null) {
            radioButtonJpanel2 = new JPanel();
            radioButtonJpanel2.setLayout(null);
            radioButtonJpanel2.setBounds(165, 100, 140, 95);
            buttonGroup5.add(getjcl3Button());
            buttonGroup5.add(getjcl4Button());
            radioButtonJpanel2.add(getjcl3Button(), null);
            radioButtonJpanel2.add(getjcl4Button(), null);
            radioButtonJpanel2.setBorder(BorderFactory.createTitledBorder("�¼�ģʽ"));

        }
        return radioButtonJpanel2;
    }

    private JRadioButton getjcl3Button() {
        if (jcl3 == null) {
            jcl3 = new JRadioButton("����ģʽ");
            jcl3.setToolTipText("����ģʽ");
            jcl3.setFocusable(false);
//            penCheck.addActionListener(this);
            jcl3.setBounds(10, 30, 120, 20);
            jcl3.setSelected(true);
            jcl3.addActionListener(new java.awt.event.ActionListener() {

                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    eventType = 1;
                }
            });

        }
        return jcl3;
    }
    private JRadioButton jcl3, jcl4;

    private JRadioButton getjcl4Button() {
        if (jcl4 == null) {
            jcl4 = new JRadioButton("�ű�ģʽ");
            jcl4.setToolTipText("�ű�ģʽ");
            jcl4.setFocusable(false);
//            penCheck.addActionListener(this);
            jcl4.setBounds(10, 55, 120, 20);
            jcl4.addActionListener(new java.awt.event.ActionListener() {

                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    eventType = 0;
                }
            });

        }
        return jcl4;
    }
    private ButtonGroup buttonGroup5 = new ButtonGroup();

    private JPanel getRadioButtonJpanel() {
        if (radioButtonJpanel == null) {
            radioButtonJpanel = new JPanel();
            radioButtonJpanel.setLayout(null);
            radioButtonJpanel.setBounds(10, 100, 140, 95);
            buttonGroup4.add(getjcl1Button());
            buttonGroup4.add(getjcl2Button());
            radioButtonJpanel.add(getjcl1Button(), null);
            radioButtonJpanel.add(getjcl2Button(), null);
            radioButtonJpanel.setBorder(BorderFactory.createTitledBorder("ѡ��ģʽ"));
        }
        return radioButtonJpanel;
    }
//    private JLabel jChoseLabel;

    private JDialog getJDialogSet() {
        if (jdSet == null) {
            jdSet = new JDialog(this);
            jdSet.setSize(324, 232);
            Dimension screenSize =
                Toolkit.getDefaultToolkit().getScreenSize();
            Dimension labelSize = jdSet.getSize();
            jdSet.setLocation(screenSize.width / 2 - (labelSize.width / 2),
                screenSize.height / 2 - (labelSize.height / 2));//����λ����Ļ�в�
            jdSet.setTitle("����");
            jdSet.setResizable(false);
            jdSet.setModal(true);
            jdSet.setContentPane(getJContentPane2());
        }
        return jdSet;

    }

    /**
     * This method initializes jJMenuBar
     *
     * @return javax.swing.JMenuBar
     */
    private JMenuBar getJJMenuBar() {
        if (jJMenuBar == null) {
            jJMenuBar = new JMenuBar();
            jJMenuBar.add(getJMenu());
            jJMenuBar.add(getEditJMenu());
            jJMenuBar.add(getPicJMenu());
            jJMenuBar.add(getJMenu1());
            jJMenuBar.add(getSetJMenu());
            jJMenuBar.add(getPluginJMenu());
            jJMenuBar.add(getGameMenu());
            try {
                JMenu[] menus = null;
                if (pl.getMenu() != null) {
                    menus = pl.getMenu();
                }

                if (menus != null) {
                    int ii = menus.length;
                    for (int i = 0; i
                        < ii; i++) {
                        if (menus[i] != null) {
                            jJMenuBar.add(menus[i]);
                        }
                    }
                }
            } catch (Exception e) {
                // TODO �Զ����� catch ��
            }
            jJMenuBar.add(getJMenuHelp());
        }
        return jJMenuBar;
    }
    private JMenu gameMenu;

    private JMenu getGameMenu() {
        if (gameMenu == null) {
            gameMenu = new JMenu("��Ϸ(G)");
            gameMenu.setMnemonic('G');
            gameMenu.add(getJMenuItem17());
            gameMenu.add(getGameItem());
            gameMenu.add(getJMenuItem18());

            gameMenu.add(getJMenuItem1());
        }
        return gameMenu;
    }
//    private Process openG;
    private JMenuItem jMenuItem17 = null;
    private JMenuItem jMenuItem1 = null;
//    Process gameP;

    private void copyGameFiles(File file) {
        File[] files = file.listFiles();
        for (int i = 0; i
            < files.length; i++) {
            if (files[i].getName().equals("���ɵ���Ϸ")) {
                continue;
            }
            if (files[i].isFile()) {
                try {
                    FileInputStream input = new FileInputStream(files[i]);
                    FileOutputStream output = new FileOutputStream("product"
                        + file.getPath().substring(Project.getProjectPath().length()) + "\\"
                        + (files[i].getName()).toString());
                    byte[] b = new byte[1024 * 5];
                    int len;
                    while ((len = input.read(b)) != -1) {
                        output.write(b, 0, len);
                    }
                    output.flush();
                    output.close();
                    input.close();
                } catch (IOException e) {
                }
            } else {
                File tempFile = new File("product"
                    + files[i].getPath().substring(Project.getProjectPath().length()));
                tempFile.mkdirs();
                copyGameFiles(
                    files[i]);
            }
        }
    }
    //���������Լ��

//    private boolean checkFile(File file, String check) {
//        if (file.getName().equals(check)) {
//            return true;
//        }
//        return false;
//    }
    private String checkData() {
        File f = new File(Project.getProjectPath() + "\\data");
        File[] ff = f.listFiles();
        int n[] = new int[9];
        for (int i = 0; i < ff.length; i++) {
            if (ff[i].getName().equals("ani.gat")) {
                n[0] = 1;
                continue;
            }
            if (ff[i].getName().equals("enemy.gat")) {
                n[1] = 1;
                continue;
            }
            if (ff[i].getName().equals("enemytroop.gat")) {
                n[2] = 1;
                continue;
            }
            if (ff[i].getName().equals("equip.gat")) {
                n[3] = 1;
                continue;
            }
            if (ff[i].getName().equals("item.gat")) {
                n[4] = 1;
                continue;
            }
            if (ff[i].getName().equals("map")) {
                n[5] = 1;
                continue;
            }
            if (ff[i].getName().equals("player.gat")) {
                n[6] = 1;
                continue;
            }
            if (ff[i].getName().equals("system.gat")) {
                n[7] = 1;
                continue;
            }
            if (ff[i].getName().equals("skill.gat")) {
                n[8] = 1;
                continue;
            }
        }
        if (n[0] != 1) {
            return "�����ļ�ȱʧ�����ö����༭���༭";
        }
        if (n[1] != 1) {
            return "�����ļ�ȱʧ���������ݱ༭���༭";
        }
        if (n[2] != 1) {
            return "�����ļ�ȱʧ���������ݱ༭���༭";
        }
        if (n[3] != 1) {
            return "װ���ļ�ȱʧ���������ݱ༭���༭";
        }
        if (n[4] != 1) {
            return "��Ʒ�ļ�ȱʧ���������ݱ༭���༭";
        }
        if (n[5] != 1) {
            return "��ͼ�ļ�ȱʧ���������ݱ༭���༭";
        }
        if (n[6] != 1) {
            return "��ɫ�ļ�ȱʧ���������ݱ༭���༭";
        }
        if (n[7] != 1) {
            return "ϵͳ�ļ�ȱʧ���������ݱ༭���༭";
        }
        if (n[8] != 1) {
            return "�����ļ�ȱʧ���������ݱ༭���༭";
        }



//        //����ļ���
//        if (!checkFile(ff[0], "ani.gat")
//            || !checkFile(ff[1], "enemy.gat")
//            || !checkFile(ff[2], "enemytroop.gat")
//            || !checkFile(ff[3], "equip.gat")
//            || !checkFile(ff[4], "item.gat")
//            || !checkFile(ff[5], "map")
//            || !checkFile(ff[6], "player.gat")
//            || !checkFile(ff[7], "skill.gat")
//            || !checkFile(ff[8], "system.gat")) {
//            return false;
//        }
        File mf = new File(Project.getProjectPath() + "\\data\\map");
        File[] mff = mf.listFiles();
        if (mff.length < 1) {
            return "��ͼ�ļ�ȱʧ!���½��������ͼ";//����û�е�ͼ������false
        }
        return "���ɳɹ���";
    }
    //�ű�ת������

    private void converterScript() {
//        FinalScript fs = new FinalScript();
        File f = new File(Project.getProjectPath() + "\\data\\map");
        File[] ff = f.listFiles();
        if (mapFinalVector != null) {
            mapFinalVector.delAllMap();
        }
        mapFinalVector = new MapList();
        for (int i = 0; i
            < ff.length; i++) {
            if (ff[i].getName().endsWith(".gat")) {
                loadFinalMapVector(ff[i]);
            }
        }
        int sum = mapFinalVector.size();
        System.out.println("mapFinalVector length: " + sum);
//        int[] n = new int[sum];
        for (int i = 0; i < sum; i++) {
            Map mapF = mapFinalVector.mapAt(i);
            int row = mapF.getRow();
            int col = mapF.getCol();
            for (int j = 0; j < row; j++) {
                for (int k = 0; k < col; k++) {
                    if (mapF.getScriptType()[j][k] != 0) {
//                        n[i]++;
                        CommandSet cs = Converter.convert(mapFinalVector.mapAt(i), j, k);
                        mapF.setCommandSet(cs);
                        System.out.println(cs);
                    }
                }
            }
            mapFinalVector.setMap(mapF, i);
        }


//        for (int i = 0; i < sum; i++) {
//            System.out.println("n[i]: " + n[i]);
//        }
    }
    private MapList mapFinalVector;

    private void loadFinalMapVector(File file) {
        mapFinalVector.addMap(loadMap(file));
    }

    private void saveFinalMap(Map myMap) {
        FileOutputStream fos = null;
        DataOutputStream dos = null;
        try {
            File f = new File("product" + "\\" + "data\\map");
            String path = f.getAbsolutePath();
            fos = new FileOutputStream(path + "/" + "map" + myMap.getIndex() + ".gat");
            dos = new DataOutputStream(fos);
            dos.writeInt(myMap.getIndex());
            dos.writeUTF(myMap.getName());// д���ͼ����
            dos.writeUTF(myMap.getImageName());// д��ԴͼƬ����
            dos.writeUTF(myMap.getMusicName());// 
            dos.writeByte(myMap.getRow());// д���ͼ����
            dos.writeByte(myMap.getCol());// д���ͼ����
            dos.writeByte(myMap.getCellWidth());// д�뵥Ԫ����
            dos.writeByte(myMap.getCellHeight());// д�뵥Ԫ��߶�
            dos.writeByte(myMap.getLayerNum());// д��ͼ����
            // д���ͼͼ��������
            for (int i = 0; i
                < myMap.getLayerNum(); i++) {
                for (int j = 0; j
                    < myMap.getRow(); j++) {
                    for (int k = 0; k
                        < myMap.getCol(); k++) {
                        dos.writeInt(myMap.getMap()[i][j][k]);
                    }
                }
            }
            // д���ͼͨ�ж�����
            for (int j = 0; j
                < myMap.getRow(); j++) {
                for (int k = 0; k
                    < myMap.getCol(); k++) {
                    dos.writeByte(myMap.getWay()[j][k]);
                }
            }
            int sum = 0;
            for (int j = 0; j
                < myMap.getRow(); j++) {
                for (int k = 0; k
                    < myMap.getCol(); k++) {
                    byte t = myMap.getScriptType()[j][k];
                    if (t != 0) {
                        sum++;
                    }
                    dos.writeByte(t);
                }
            }
            dos.writeInt(sum);//�ű������
            //д��commandset
            for (int j = 0; j
                < myMap.getRow(); j++) {
                for (int k = 0; k
                    < myMap.getCol(); k++) {
                    byte t = myMap.getScriptType()[j][k];
                    if ((t != 0) && (myMap.getScriptList()[j][k] != null)) {
                        CommandSet sc = myMap.getCommandSet()[j][k];
                        int si = sc.command.length;
                        dos.writeByte(t);
                        dos.writeInt(j);
                        dos.writeInt(k);
                        dos.writeInt(si);
                        System.out.println("si " + si);
                        for (int i = 0; i
                            < si; i++) {
                            Command co = sc.command[i];
                            Byte b = co.type;
                            System.out.println(b);
                            dos.writeByte(b);
                            switch (b) {
                                case Command.ENDWHILE:
                                case Command.BREAK:
                                case Command.CONTINUE:
                                    dos.writeUTF("");
                                    dos.writeInt(co.nextIndex);
                                    continue;
                                case Command.ENDIF:
                                case Command.EXIT:
                                case Command.GAMEOVER:
                                    dos.writeUTF("");
                                    dos.writeInt(-1);
                                    continue;
                                default:
                                    System.out.println("hava param");
                                    dos.writeUTF(co.param);
                                    dos.writeInt(co.nextIndex);
                                    break;
                            }
                        }
                    }
                }
            }
            fos.close();
            dos.close();
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println("saveFinalMapVector Error");
        }
    }
//    private Emulator emulator = null;
//
//    private Emulator getEmulator() {
//        if (emulator == null) {
//            emulator = new Emulator(this);
//        }
//        return emulator;
//    }
    private JMenuItem createGameItem = null;

    private JMenuItem getGameItem() {
        if (createGameItem == null) {
            createGameItem = new JMenuItem();
            createGameItem.setText("������Ϸ");
            createGameItem.addActionListener(new java.awt.event.ActionListener() {

                public void actionPerformed(java.awt.event.ActionEvent e) {
                    if (!checkData().equals("���ɳɹ���")) {
                        JOptionPane.showMessageDialog(mapEditor, checkData());
                        return;
                    }
                    FileUtil.createDir(Project.getProjectPath() + "\\���ɵ���Ϸ");
                    FileUtil.delAllFile(Project.getProjectPath() + "\\���ɵ���Ϸ");
                    FileUtil.delAllFile("product\\image");
                    FileUtil.delAllFile("product\\data");
                    FileUtil.delAllFile("product\\audio");


                    copyGameFiles(new File(Project.getProjectPath()));//��Դ���ݿ�����product�ļ�����
                    converterScript();//��ԭʼת��Ϊ���սű�
                    for (int i = 0, n = mapFinalVector.size(); i
                        < n; i++) {
                        saveFinalMap(mapFinalVector.mapAt(i));//���´����ͼ
                    }
                    if (new File("product\\Game.jar").exists()) {
                        FileUtil.copy(new File("product\\Game.jar"), new File(Project.getProjectPath() + "\\���ɵ���Ϸ"));
                        if (new File(Project.getProjectPath() + "\\���ɵ���Ϸ\\Game.jar").exists()) {
                            JOptionPane.showMessageDialog(mapEditor, "���ɳɹ���");
                        } else {
                            JOptionPane.showMessageDialog(mapEditor, "����ʧ�ܣ�");
                        }
                    } else {
                        System.out.println("Game.jar������");
                    }
                }
            });
        }
        return createGameItem;
    }

    private JMenuItem getJMenuItem17() {
        if (jMenuItem17 == null) {
            jMenuItem17 = new JMenuItem();
            jMenuItem17.setText("����");
            jMenuItem17.addActionListener(new java.awt.event.ActionListener() {

                public void actionPerformed(java.awt.event.ActionEvent e) {


                    if (!getIsHasProject() || Project.getProjectName().equals("")) {
                        JOptionPane.showMessageDialog(mapEditor, "�����½���Ŀ");
                        return;
                    }

                    if (!checkData().equals("���ɳɹ���")) {
                        JOptionPane.showMessageDialog(mapEditor, checkData());
                        return;
                    }
                    FileUtil.createDir(Project.getProjectPath() + "\\���ɵ���Ϸ");
                    FileUtil.delAllFile(Project.getProjectPath() + "\\���ɵ���Ϸ");
                    FileUtil.delAllFile("product\\image");
                    FileUtil.delAllFile("product\\data");
                    FileUtil.delAllFile("product\\audio");


                    copyGameFiles(new File(Project.getProjectPath()));//��Դ���ݿ�����product�ļ�����
                    converterScript();//��ԭʼת��Ϊ���սű�
                    for (int i = 0, n = mapFinalVector.size(); i
                        < n; i++) {
                        saveFinalMap(mapFinalVector.mapAt(i));//���´����ͼ
                    }
                    Emulator emulator = new Emulator(mapEditor);
                    emulator.setVisible(true);
                    emulator.start();
//                    try {
//                        java.awt.Desktop.getDesktop().open(new File("command\\game.vbs"));
//                    } catch (IOException ex) {
//                        ex.printStackTrace();
//                    }
//                    try {
//                        Thread.sleep(2000);//�ӳ������ٸ��ƣ��ȴ�����
//                    } catch (InterruptedException ex) {
//                        Logger.getLogger(MapEditor.class.getName()).log(Level.SEVERE, null, ex);
//                    }

//                    try {
//                    FileUtil.copy(new File("product\\Game.jar"), new File(Project.getProjectPath()));
//
//                    } catch (Exception ex) {
//                        ex.printStackTrace();
////                        Logger.getLogger(MapEditor.class.getName()).log(Level.SEVERE, null, ex);
//                    }

                }
            });
        }
        return jMenuItem17;
    }

    private JMenuItem getJMenuItem1() {
        if (jMenuItem1 == null) {
            jMenuItem1 = new JMenuItem();
            jMenuItem1.setText("����Ϸ�ļ���");
            jMenuItem1.addActionListener(new java.awt.event.ActionListener() {

                public void actionPerformed(java.awt.event.ActionEvent e) {
//                    System.out.println("open");
//                    String command = "command\\open.bat";

                    if (!getIsHasProject() || Project.getProjectName().equals("")) {
                        JOptionPane.showMessageDialog(mapEditor, "�����½���Ŀ");
                        return;
                    }
//                    if (openG != null) {
//                        openG.destroy();
//                    }
                    try {
                        java.awt.Desktop.getDesktop().open(new File(Project.getProjectPath() + "\\���ɵ���Ϸ"));
                    } catch (IOException ex) {
                        Logger.getLogger(MapEditor.class.getName()).log(Level.SEVERE, null, ex);
                    }
//                    try {
//                        String[] cmd = new String[5];
//                        cmd[0] = "cmd";
//                        cmd[1] = "/c";
//                        cmd[2] = "start";
//                        cmd[3] = " ";
//                        cmd[4] = Project.getProjectPath() + "\\product ";
////                        cmd[4] = Project.getProjectDirName() + "\\product";
//                        Runtime.getRuntime().exec(cmd);
//                    } catch (IOException ee) {
//                        ee.printStackTrace();
//                    }

//                    try {
//                        openG = Runtime.getRuntime().exec(command);
//
//                    } catch (Exception ee) {
//                        // TODO Auto-generated catch block
//                        System.out.println("open Error");
//                    }

                }
            });
        }
        return jMenuItem1;
    }
    private JMenuItem jMenuItem18;

    /**
     * This method initializes jMenuItem18
     *
     * @return javax.swing.JMenuItem
     */
    private JMenuItem getJMenuItem18() {
        if (jMenuItem18 == null) {
            jMenuItem18 = new JMenuItem();
            jMenuItem18.setText("���ı���");
            jMenuItem18.addActionListener(new java.awt.event.ActionListener() {

                public void actionPerformed(java.awt.event.ActionEvent e) {
//                    System.out.println("open");
                    if (!getIsHasProject()) {
                        JOptionPane.showMessageDialog(mapEditor, "�����½���Ŀ");
                        return;
                    }
                    getChangeNameDialog();
                    changeDialog.setVisible(true);
                }
            });
        }
        return jMenuItem18;
    }
    private JDialog changeDialog;

    private JDialog getChangeNameDialog() {
        if (changeDialog == null) {
            changeDialog = new JDialog();
            changeDialog.setSize(280, 121);
//        this.setSize(240, 160);
            Dimension screenSize =
                Toolkit.getDefaultToolkit().getScreenSize();
            Dimension labelSize = changeDialog.getSize();
            changeDialog.setLocation(screenSize.width / 2 - (labelSize.width / 2),
                screenSize.height / 2 - (labelSize.height / 2));//����λ����Ļ�в�
            changeDialog.setTitle("���ı���");
            changeDialog.setModal(true);
            changeDialog.setResizable(false);
            changeDialog.setContentPane(getNamePanel());
        }
        return changeDialog;
    }
    private JPanel changePanel;
    private JTextField jt;

    private JPanel getNamePanel() {
        if (changePanel == null) {
            changePanel = new JPanel();
            changePanel.setLayout(null);
            JLabel jtb = new JLabel("���⣺");
            jtb.setBounds(10, 5, 60, 20);
            jt = new JTextField();
            jt.setBounds(10, 30, 250, 20);
            jt.setText(Project.getProjectName());
            changePanel.add(jt, null);
            changePanel.add(jtb, null);
            changePanel.add(getOK(), null);
            changePanel.add(getCancle(), null);
        }
        return changePanel;
    }
    private JButton ok, cancle;

    private JButton getOK() {
        if (ok == null) {
            ok = new JButton("ȷ��");
            ok.setBounds(130, 60, 60, 20);
            ok.addActionListener(new java.awt.event.ActionListener() {

                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    changeName();
                    changeDialog.setVisible(false);

                }
            });
        }
        return ok;
    }

    private JButton getCancle() {
        if (cancle == null) {
            cancle = new JButton("ȡ��");
            cancle.setBounds(200, 60, 60, 20);
            cancle.addActionListener(new java.awt.event.ActionListener() {

                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    changeDialog.setVisible(false);
                }
            });
        }
        return cancle;
    }

    private void changeName() {
        FileOutputStream fos = null;
        DataOutputStream dos = null;
        try {
//                System.out.println("save: " + newFile.getParent());
////                            ImageUtil.writeImage(newImg, newFile, "png");
            Project.setProjectName(jt.getText());
            File newFile = new File(Project.getProjectPath() + "\\" + "Game.project");
//                String path = newFile.getAbsolutePath();
            fos = new FileOutputStream(newFile);
            dos = new DataOutputStream(fos);
            dos.writeUTF(Project.getProjectName());

            fos.close();
            dos.close();
        } catch (Exception ee) {
            System.out.println("new Error");
        }
        changeTitle();
    }

    /**
     * This method initializes jMenu
     *
     * @return javax.swing.JMenu
     */
    private JMenu getJMenu() {
        if (jMenu_File == null) {
            jMenu_File = new JMenu();
            jMenu_File.setText("�ļ�(F)");
            jMenu_File.setMnemonic('F');
            jMenu_File.add(getNewPro());
            jMenu_File.add(getOpenPro());
            jMenu_File.add(getSavePro());
//            jMenu_File.add(getClosePro());
//            jMenu_File.add(getJMenuItem());
//            jMenu_File.add(getJMenuItem3());
            jMenu_File.add(getJMenuItemExit());
        }
        return jMenu_File;
    }

    private JMenu getSetJMenu() {
        if (jMenu_Set == null) {
            jMenu_Set = new JMenu();
        }
        jMenu_Set.setText("����(T)");
        jMenu_Set.setMnemonic('T');
        jMenu_Set.add(getdataItem());
        jMenu_Set.add(getAnimationItem());
//        jMenu_Set.add(getJMenuItem15());
//        jMenu_Set.add(getMusicMenuItem());
//        jMenu_Set.add(getMapItem());
//        jMenu_Set.add(getPicSaveItem());
//        jMenu_Set.add(getRotateButton());
//        jMenu_Set.add(getRepaintItem());
        jMenu_Set.add(getSetItem());
        return jMenu_Set;
    }

    private JMenu getPluginJMenu() {
        if (jMenu_Plugin == null) {
            jMenu_Plugin = new JMenu();
        }
        jMenu_Plugin.setText("���(P)");
        jMenu_Plugin.setMnemonic('P');
        try {
            JMenuItem[] menuItems = null;
            if (pl.getMenuItem() != null) {
                menuItems = pl.getMenuItem();
            }
            if (menuItems != null) {
                int ii = menuItems.length;
                for (int i = 0; i
                    < ii; i++) {
                    if (menuItems[i] != null) {
                        jMenu_Plugin.add(menuItems[i]);
                    }
                }
            }
        } catch (Exception e) {
            // TODO �Զ����� catch ��
        }
        return jMenu_Plugin;
    }

    private JMenu getPicJMenu() {
        if (jMenu_pic == null) {
            jMenu_pic = new JMenu();
        }
        jMenu_pic.setText("��ͼ(V)");
        jMenu_pic.setMnemonic('V');
        buttonGroup2.add(getJMenuPicItem1());
        buttonGroup2.add(getJMenuPicItem2());
        buttonGroup2.add(getJMenuPicItem3());
        jMenu_pic.add(getJMenuPicItem1());
        jMenu_pic.add(getJMenuPicItem2());
        jMenu_pic.add(getJMenuPicItem3());
        return jMenu_pic;

    }

    private JMenuItem getUndoItem() {
        if (jUndoItem == null) {
            jUndoItem = new JMenuItem();
        }
        jUndoItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,
            InputEvent.CTRL_MASK));
        jUndoItem.setText("����");
        jUndoItem.addActionListener(this);
        jUndoItem.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                if (map != null) {
                    nIndex--;
                    if (nIndex < 0) {
                        nIndex = 0;
                    }
                    for (int k = 0; k
                        < map.getLayerNum(); k++) {
                        for (int i = 0; i
                            < map.getRow(); i++) {
                            System.arraycopy(undoMap[nIndex][k][i], 0, map.getMap()[k][i], 0, map.getCol());
                        }
                    }
                    mapCanvas.updateCanvas();
                }
            }
        });
        return jUndoItem;

    }

    private JMenuItem getRedoItem() {
        if (jRedoItem == null) {
            jRedoItem = new JMenuItem();
        }
        jRedoItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y,
            InputEvent.CTRL_MASK));
        jRedoItem.setText("�ָ�");
//        jRedoItem.addActionListener(this);
        jRedoItem.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                if (map != null) {
                    for (int k = 0; k
                        < map.getLayerNum(); k++) {
                        for (int i = 0; i
                            < map.getRow(); i++) {
                            System.arraycopy(redoMap[nIndex][k][i], 0, map.getMap()[k][i], 0, map.getCol());
                        }
                    }
                    mapCanvas.updateCanvas();
                    nIndex++;

                    if (nIndex > 9) {
                        nIndex = 9;
                    }
                }
            }
        });
        return jRedoItem;
    }

    private JMenu getEditJMenu() {
        if (jMenu_edit == null) {
            jMenu_edit = new JMenu();
        }
        jMenu_edit.add(getUndoItem());
        jMenu_edit.add(getRedoItem());
        jMenu_edit.setMnemonic('E');
        jMenu_edit.setText("�༭(E)");

        return jMenu_edit;
    }

    private JRadioButtonMenuItem getJMenuPicItem1() {
        if (jMenuPicItem1 == null) {
            jMenuPicItem1 = new JRadioButtonMenuItem();
        }
        jMenuPicItem1.setText("��ǰ����һ��");
        jMenuPicItem1.setAccelerator(KeyStroke.getKeyStroke("F2"));
//        jMenuPicItem1.addActionListener(this);
        jMenuPicItem1.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                type = 1;

                if (map != null) {
                    mapCanvas.updateCanvas();
                }
            }
        });
        return jMenuPicItem1;

    }

    private JRadioButtonMenuItem getJMenuPicItem2() {
        if (jMenuPicItem2 == null) {
            jMenuPicItem2 = new JRadioButtonMenuItem();
        }
        jMenuPicItem2.setText("ȫ����");
        jMenuPicItem2.setAccelerator(KeyStroke.getKeyStroke("F3"));
        jMenuPicItem2.setSelected(true);
//        jMenuPicItem2.addActionListener(this);
        jMenuPicItem2.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                type = 0;
                if (map != null) {
                    mapCanvas.updateCanvas();
                }
            }
        });
        return jMenuPicItem2;
    }

    private JRadioButtonMenuItem getJMenuPicItem3() {
        if (jMenuPicItem3 == null) {
            jMenuPicItem3 = new JRadioButtonMenuItem();
        }
        jMenuPicItem3.setText("��ǰ��");
        jMenuPicItem3.setAccelerator(KeyStroke.getKeyStroke("F4"));
//        jMenuPicItem3.addActionListener(this);
        jMenuPicItem3.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                type = 2;
                if (map != null) {
                    mapCanvas.updateCanvas();
                }
            }
        });
        return jMenuPicItem3;

    }

    /**
     * This method initializes jMenu1
     *
     * @return javax.swing.JMenu
     */
    public JMenu getJMenu1() {
        if (jMenu_Lay == null) {
            jMenu_Lay = new JMenu();
        }
        jMenu_Lay.removeAll();
        jMenu_Lay.setText("ͼ��(L)");
        jMenu_Lay.setMnemonic('L');
        menuItem = new JRadioButtonMenuItem[layerNum];
        int ii = menuItem.length;
        for (int i = 0; i
            < ii; i++) {
            JRadioButtonMenuItem tempItem = new JRadioButtonMenuItem();
            tempItem.setText("ͼ��" + (i + 1));
            tempItem.setAccelerator(KeyStroke.getKeyStroke("F" + (i + 5)));
            tempItem.addActionListener(this);
            menuItem[i] = tempItem;
        }
        for (int i = 0; i
            < ii; i++) {
            buttonGroup.add(menuItem[i]);
        }
        for (int i = 0; i
            < ii; i++) {
            jMenu_Lay.add(menuItem[i]);
        }
        menuItem[0].setSelected(true);
        return jMenu_Lay;
    }
    private DataManager dm = null;
    // ��ʼ�����ݹ�����

    private void creatDM() {
        if (dm == null) {
            dm = new DataManager(this);
            dm.load();
        }

    }

    public void actionPerformed(ActionEvent e) {
        System.gc();
        int ii = menuItem.length;
        for (int i = 0; i
            < ii; i++) {
            if (e.getSource() == menuItem[i]) {
                currentLayer = i;
                break;
            }
        }
//        isCollide = false;
//        isFill = false;
        if (map != null) {
            mapCanvas.updateCanvas();
        }
        slButton.setText("״̬����ͼģʽ");
        scButton.setText("��ǰͼ�㣺ͼ��" + (currentLayer + 1));

    }

    /**
     * This method initializes jMenuItem
     *
     * @return javax.swing.JMenuItem
     */
    private JMenuItem getJMenuItem() {
        if (jMenuItem == null) {
            jMenuItem = new JMenuItem();
            jMenuItem.setText("�½���ͼ");
//            jMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
//                InputEvent.CTRL_MASK));
//            jMenuItem.addActionListener(this);
            jMenuItem.addActionListener(new java.awt.event.ActionListener() {

                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    if (!isHasProject) {
                        JOptionPane.showMessageDialog(getJContentPane(), "�����½���Ŀ");
                        return;
                    }

                    getJDialog();
                    initJComboBox();
                    initJComboBox3();
                    jDialog.setVisible(true);

                }
            });

        }
        return jMenuItem;
    }
    private JMenuItem newProjectItem;

    private JMenuItem getNewPro() {
        if (newProjectItem == null) {
            newProjectItem = new JMenuItem();
            newProjectItem.setText("�½�����");
            newProjectItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
                InputEvent.CTRL_MASK));
//            jMenuItem.addActionListener(this);
            newProjectItem.addActionListener(new java.awt.event.ActionListener() {

                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
//                    System.out.println("new");
                    getJDialogNewPro();
                    jDialogNewPro.setVisible(true);

                }
            });
        }
        return newProjectItem;
    }

    private JButton getJButtonOpe() {
        if (jButtonOpe == null) {
            jButtonOpe = new JButton();
            jButtonOpe.setText("...");
            jButtonOpe.setSize(new Dimension(25, 20));
            jButtonOpe.setLocation(new Point(305, 40));
            jButtonOpe.addActionListener(new java.awt.event.ActionListener() {

                public void actionPerformed(java.awt.event.ActionEvent e) {
                    JFileChooser jf = new JFileChooser();// ����һ���ļ��Ի���
                    jf.setCurrentDirectory(new File("."));// ���õ�ǰĿ¼
                    jf.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);// ����ֻ��ѡ���ļ���
                    jf.showOpenDialog(jContentPane);// ��ʾ���򿪡��ļ��Ի���
                    File file = jf.getSelectedFile();
                    if (file != null) {
                        jTextField1.setText(file.getPath());
                    }
                }
            });
        }
        return jButtonOpe;
    }

    private JButton getJButtonOk() {
        if (OkButton == null) {
            OkButton = new JButton();
            OkButton.setText("ȷ��");
            OkButton.setSize(new Dimension(60, 20));
            OkButton.setLocation(new Point(195, 70));
            OkButton.addActionListener(new java.awt.event.ActionListener() {

                public void actionPerformed(java.awt.event.ActionEvent e) {
                    if (jTextField.getText().equals("") || jTextField1.getText().equals("") || jTextField2.getText().equals("")) {
                        JOptionPane.showMessageDialog(getJContentPane(), "���벻��Ϊ�գ����������룡");
                        return;
                    }
                    File f = new File(jTextField1.getText() + "\\"
                        + jTextField2.getText());// ���������·���½�һ���ļ�
                    if (!f.exists()) {
                        f.mkdirs();// ������ļ��в������򴴽����ļ���
                    }

//                    projectPath = f.getPath();
                    Project.setProjectDirName(jTextField2.getText());
                    Project.setProjectName(jTextField.getText());
                    Project.setProjectPath(f.getPath());
                    System.out.println(Project.getProjectPath());
                    changeTitle();
                    copyFiles(
                        new File("res"));
                    FileOutputStream fos = null;
                    DataOutputStream dos = null;
                    try {
//                System.out.println("save: " + newFile.getParent());
////                            ImageUtil.writeImage(newImg, newFile, "png");
                        File newFile = new File(Project.getProjectPath() + "\\" + "Game.project");
//                String path = newFile.getAbsolutePath();
                        fos = new FileOutputStream(newFile);
                        dos = new DataOutputStream(fos);
                        dos.writeUTF(Project.getProjectName());
                        isHasProject = true;

                        fos.close();
                        dos.close();
                    } catch (Exception ee) {
                        System.out.println("new Error");
                    }
                    initMapVector();
                    creatAM();
//                    creatIM();
                    creatDM();
//                    creatMM();

                    jDialogNewPro.setVisible(false);
                }
            });
        }
        return OkButton;
    }
    private boolean isHasProject = false;

    public boolean getIsHasProject() {
        return isHasProject;
    }

    private void initMapVector() {
//        for (int i = 0, n = mapVector.size(); i
//            < n; i++) {
//            mapVector.delMap(i);
//
//        }
        if (mapVector != null) {
            mapVector.delAllMap();
        }
//        if (mapFinalVector != null) {
//            mapFinalVector.delAllMap();
//        }
        mapVector = new MapList();
//        mapFinalVector = new MapList();
        currentMapIndex = 0;
//        currentLayer = 0;
        jTable.updateTable();

    } //    private static String projectPath = ".";// ������ϷĿ¼  //  @jve:decl-index=0:
    // ���ļ��и��Ƶ���Ϸ����Ŀ¼��

    private void copyFiles(File file) {
        File[] files = file.listFiles();
        for (int i = 0; i
            < files.length; i++) {
            if (files[i].isFile()) {
                try {
                    FileInputStream input = new FileInputStream(files[i]);
                    FileOutputStream output = new FileOutputStream(Project.getProjectPath()
                        + file.getPath().substring(3) + "\\"
                        + (files[i].getName()).toString());
                    byte[] b = new byte[1024 * 5];
                    int len;
                    while ((len = input.read(b)) != -1) {
                        output.write(b, 0, len);
                    }
                    output.flush();
                    output.close();
                    input.close();
                } catch (IOException e) {
                }
            } else {
                File tempFile = new File(Project.getProjectPath()
                    + files[i].getPath().substring(3));
                tempFile.mkdirs();
                copyFiles(
                    files[i]);
            }
        }
    }
    /**
     * This method initializes jButton2
     *
     * @return javax.swing.JButton
     */
    private JButton calcleButton, OkButton;

    private JButton getJButtonCal() {
        if (calcleButton == null) {
            calcleButton = new JButton();
            calcleButton.setText("ȡ��");
            calcleButton.setSize(new Dimension(60, 20));
            calcleButton.setLocation(new Point(270, 70));
            calcleButton.addActionListener(new java.awt.event.ActionListener() {

                public void actionPerformed(java.awt.event.ActionEvent e) {
                    jDialogNewPro.setVisible(false);
                }
            });
        }
        return calcleButton;

    }
    private JButton jButtonOpe;
    private JTextField jTextField1 = null;
    private JDialog jDialogNewPro;

    private JDialog getJDialogNewPro() {
        if (jDialogNewPro == null) {
            jDialogNewPro = new JDialog(this);
            jDialogNewPro.setSize(new Dimension(355, 133));
            Dimension screenSize =
                Toolkit.getDefaultToolkit().getScreenSize();
            Dimension labelSize = jDialogNewPro.getSize();
            jDialogNewPro.setLocation(screenSize.width / 2 - (labelSize.width / 2),
                screenSize.height / 2 - (labelSize.height / 2));//����λ����Ļ�в�
            jDialogNewPro.setTitle("�½�����");
            jDialogNewPro.setModal(true);
            jDialogNewPro.setResizable(false);
            jDialogNewPro.setContentPane(getJContentPane4());
        }
        return jDialogNewPro;
    }
    /**
     * This method initializes jContentPane1
     *
     * @return javax.swing.JPanel
     */
    private JLabel jLabel2;

    private JPanel getJContentPane4() {
        if (jContentPane4 == null) {
            jLabel1 = new JLabel();
            jLabel1.setText("λ�ã�");
            jLabel1.setSize(new Dimension(40, 20));
//            jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
//            jLabel1.setHorizontalTextPosition(SwingConstants.CENTER);
            jLabel1.setLocation(new Point(5, 40));
            jLabel2 = new JLabel();
            jLabel2.setText("�ļ�������");
            jLabel2.setLocation(new Point(5, 10));
//            jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
//            jLabel2.setHorizontalTextPosition(SwingConstants.CENTER);
            jLabel2.setSize(new Dimension(80, 20));
            jLabel = new JLabel();
            jLabel.setText("���⣺");
            jLabel.setLocation(new Point(190, 10));
//            jLabel.setHorizontalAlignment(SwingConstants.CENTER);
//            jLabel.setHorizontalTextPosition(SwingConstants.CENTER);
            jLabel.setSize(new Dimension(40, 20));
            jContentPane4 = new JPanel();
            jContentPane4.setLayout(null);
            jContentPane4.add(jLabel, null);
            jContentPane4.add(jLabel1, null);
            jContentPane4.add(jLabel2, null);
            jContentPane4.add(getJTextField(), null);
            jContentPane4.add(getJTextField1(), null);
            jContentPane4.add(getJTextField2(), null);
            jContentPane4.add(getJButtonOpe(), null);
            jContentPane4.add(getJButtonCal(), null);
            jContentPane4.add(getJButtonOk(), null);
        }
        return jContentPane4;

    }

    /**
     * This method initializes jTextField
     *
     * @return javax.swing.JTextField
     */
    private JTextField getJTextField() {
        if (jTextField == null) {
            jTextField = new JTextField();
            jTextField.setLocation(new Point(230, 10));
            jTextField.setSize(new Dimension(100, 20));
//            jTextField.setText("newProject");
        }
        return jTextField;
    }
    private JTextField jTextField2;

    private JTextField getJTextField2() {
        if (jTextField2 == null) {
            jTextField2 = new JTextField();
            jTextField2.setLocation(new Point(70, 10));
            jTextField2.setSize(new Dimension(100, 20));

        }
        return jTextField2;
    }

    /**
     * This method initializes jTextField1
     *
     * @return javax.swing.JTextField
     */
    private JTextField getJTextField1() {
        if (jTextField1 == null) {
            jTextField1 = new JTextField();
            jTextField1.setLocation(new Point(70, 40));
            jTextField1.setSize(new Dimension(230, 20));
        }
        return jTextField1;
    }
    private JTextField jTextField;
    private JLabel jLabel, jLabel1;
    private JPanel jContentPane4 = null;
    private JMenuItem saveProjectItem;

    private JMenuItem getSavePro() {
        if (saveProjectItem == null) {
            saveProjectItem = new JMenuItem();
            saveProjectItem.setText("���湤��");
            saveProjectItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
                InputEvent.CTRL_MASK));
//            jMenuItem.addActionListener(this);
            saveProjectItem.addActionListener(new java.awt.event.ActionListener() {

                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    if (!isHasProject) {
                        JOptionPane.showMessageDialog(getJContentPane(), "�����½���Ŀ");
                        return;
                    }
                    savePro();
                }
            });
        }
        return saveProjectItem;
    }

    private boolean saveProject() {
        boolean judge = false;
        try {
//            dm.saveIO();
            FileUtil.delAllFile(Project.getProjectPath() + "\\" + "data\\map");
            System.out.println("mapsize: " + mapVector.size());
            for (int i = 0, n = mapVector.size(); i
                < n; i++) {
//                if (mapVector.mapAt(i) instanceof Map) {
                saveMapVector(mapVector.mapAt(i));
//                }
            }
            judge = true;
        } catch (Exception ex) {
            judge = false;
            ex.printStackTrace();
        }
        return judge;
    }

    private void saveMapVector(Map myMap) {

        FileOutputStream fos = null;
        DataOutputStream dos = null;
        try {
            File f = new File(Project.getProjectPath() + "\\" + "data\\map");
            String path = f.getAbsolutePath();
            fos = new FileOutputStream(path + "/" + "map" + myMap.getIndex() + ".gat");
            dos = new DataOutputStream(fos);
//            dos.writeUTF(this.version);
            dos.writeInt(myMap.getIndex());
            dos.writeUTF(myMap.getName());// д���ͼ����
            dos.writeUTF(myMap.getImageName());// д��ԴͼƬ����
            dos.writeUTF(myMap.getMusicName());// 
            dos.writeByte(myMap.getRow());// д���ͼ����
            dos.writeByte(myMap.getCol());// д���ͼ����
            dos.writeByte(myMap.getCellWidth());// д�뵥Ԫ����
            dos.writeByte(myMap.getCellHeight());// д�뵥Ԫ��߶�
            dos.writeByte(myMap.getLayerNum());// д��ͼ����
            // д���ͼͼ��������
            for (int i = 0; i
                < myMap.getLayerNum(); i++) {
                for (int j = 0; j
                    < myMap.getRow(); j++) {
                    for (int k = 0; k
                        < myMap.getCol(); k++) {
                        dos.writeInt(myMap.getMap()[i][j][k]);

                    }
                }
            }
            // д���ͼͨ�ж�����
            for (int j = 0; j
                < myMap.getRow(); j++) {
                for (int k = 0; k
                    < myMap.getCol(); k++) {
                    dos.writeByte(myMap.getWay()[j][k]);
                }
            }
            int sum = 0;
            for (int j = 0; j
                < myMap.getRow(); j++) {
                for (int k = 0; k
                    < myMap.getCol(); k++) {
                    byte t = myMap.getScriptType()[j][k];
//                    System.out.print(t+" ");
                    if (t != 0) {
                        sum++;
                    }
                    dos.writeByte(t);
                }
            }
            dos.writeInt(sum);
            for (int j = 0; j
                < myMap.getRow(); j++) {
                for (int k = 0; k
                    < myMap.getCol(); k++) {
                    byte t = myMap.getScriptType()[j][k];
//                    System.out.print(t + " ");
//                    dos.writeByte(t);
                    if ((t != 0) && (myMap.getScriptList()[j][k] != null)) {
                        int si = myMap.getScriptList()[j][k].size();

                        dos.writeInt(j);
                        dos.writeInt(k);
                        dos.writeInt(si);
                        for (int i = 0; i
                            < si; i++) {
                            dos.writeUTF(myMap.getScriptList()[j][k].getString(i));
                        }
                    }
                }
            }
            fos.close();
            dos.close();
        } catch (Exception e) {
            System.out.println("saveMapVector Error");
        }
    }
    // ���ڴ��ļ�ʱ�Ĺ��������ļ���ʽΪ.png
    private JMenuItem OpenProjectItem;

    private JMenuItem getOpenPro() {
        if (OpenProjectItem == null) {
            OpenProjectItem = new JMenuItem();
            OpenProjectItem.setText("�򿪹���");
            OpenProjectItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
                InputEvent.CTRL_MASK));
//            jMenuItem.addActionListener(this);
            OpenProjectItem.addActionListener(new java.awt.event.ActionListener() {

                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    openProject();

                }
            });
        }
        return OpenProjectItem;

    }

    private Map loadMap(File file) {
        FileInputStream fis = null;
        DataInputStream dis = null;
        try {
            fis = new FileInputStream(file);
            dis = new DataInputStream(fis);
//            dis.readUTF();
            int mapIndex = dis.readInt();
            String mapName = dis.readUTF();
            String imageName = dis.readUTF();
            String musicName = dis.readUTF();
            int row = dis.readByte();
            int col = dis.readByte();
            int cellWidth = dis.readByte();
            int cellHeight = dis.readByte();
            int layerNumL = dis.readByte();
            model.Map mapL = new model.Map(mapName, imageName, row, col, cellWidth,
                cellHeight, layerNumL);
            mapL.setMusicName(musicName);
            mapL.setIndex(mapIndex);
            undoMap = new int[10][layerNumL][row][col];
            redoMap = new int[10][layerNumL][row][col];
            // ��ȡ��ͼͼ��������
            for (int i = 0; i
                < mapL.getLayerNum(); i++) {
                for (int j = 0; j
                    < mapL.getRow(); j++) {
                    for (int k = 0; k
                        < mapL.getCol(); k++) {
                        mapL.setMap(i, j, k, dis.readInt());
                    }
                }
            }
            // ��ȡ��ͼͨ�ж�����
            for (int j = 0; j
                < mapL.getRow(); j++) {
                for (int k = 0; k
                    < mapL.getCol(); k++) {
                    mapL.setWay(j, k, dis.readByte());
                }
            }
            for (int j = 0; j
                < mapL.getRow(); j++) {
                for (int k = 0; k
                    < mapL.getCol(); k++) {
                    byte t = dis.readByte();
                    mapL.getScriptType()[j][k] = t;
                }
            }
            int sum = dis.readInt();
            for (int j = 0; j
                < mapL.getRow(); j++) {
                for (int k = 0; k
                    < mapL.getCol(); k++) {
//                    byte t = dis.readByte();
//                    mapL.getScriptType()[j][k] = t;
                    if (mapL.getScriptType()[j][k] != 0) {

                        dis.readInt();
                        dis.readInt();
                        int n = dis.readInt();
                        Script s = new Script(k, j);
                        for (int i = 0; i
                            < n; i++) {
                            s.addString(dis.readUTF());
                        }
                        mapL.getScriptList()[j][k] = s;
                    }
                }
            }
            fis.close();
            dis.close();
            return mapL;
        } catch (Exception e) {
        }
        return null;
    }

    private void loadMapVector(File file) {
        mapVector.addMap(loadMap(file));
    }
//    private MapList tempMapV;

    private boolean loadProject(File f) {
        boolean judge = false;
        FileInputStream fis = null;
        DataInputStream dis = null;
        try {
            fis = new FileInputStream(f);
            dis = new DataInputStream(fis);
            Project.setProjectName(dis.readUTF());
            penCheck.setSelected(true);
            isHasProject = true;
            isChoose = false;
            isFill = false;
            isCollide = false;
            isEvent = false;
            fis.close();
            dis.close();
            judge = true;
        } catch (Exception e) {
            judge = false;
        }
        return judge;

    }
    // ���ڴ��ļ�ʱ�Ĺ��������ļ���ʽΪ.map

    class MEFileFilter extends FileFilter {

        @Override
        public boolean accept(File f) {
            // TODO �Զ����ɷ������
            return f.getName().toLowerCase().endsWith(".project") || f.isDirectory();
        }

        @Override
        public String getDescription() {
            // TODO �Զ����ɷ������
            return "MobileGameMaker���� (*.project)";
        }
    }
//    private JMenuItem CloseProjectItem;
//
//    private JMenuItem getClosePro() {
//        if (CloseProjectItem == null) {
//            CloseProjectItem = new JMenuItem();
//            CloseProjectItem.setText("�رչ���");
////            CloseProjectItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,
////                    InputEvent.CTRL_MASK));
////            jMenuItem.addActionListener(this);
//            CloseProjectItem.addActionListener(new java.awt.event.ActionListener() {
//
//                @Override
//                public void actionPerformed(java.awt.event.ActionEvent e) {
//                    System.out.println("close");
//                    if (!isHasProject) {
//                        JOptionPane.showMessageDialog(getJContentPane(), "�����½���Ŀ");
//                        return;
//                    }
//
//                    Project.setProjectPath(".");
//                    Project.setProjectName("");
//                    initTitle();
//                    initMapVector();
//                    jTable.updateTable();
//                    isHasProject = false;
////                    mapCanvas.set
//                    currentLayer = 0;
//                    layerNum = 1;
//                    penCheck.setSelected(true);
//                    slButton.setText("״̬������");
//                    scButton.setText("��ǰͼ�㣺δ��ʼ");
//                    isChoose = false;
//                    isFill = false;
//                    isCollide = false;
//                    isEvent = false;
//                    getJMenu1().repaint();
//
//
////                    map = new engine.Map("", "", 1, 1, 1, 1, 1);
////                    map.setIsVisible(false);
////                    getJPanel();
////                    getJPanel1();
//                    mapCanvas.updateCanvas();
//////                    tileCanvas.TileImg = null;
////                    tileCanvas.TileImg = null;
//                    tileCanvas.updateCanvas();
////                    tileCanvas.TileImg = null;
////                    tileCanvas = null;
////                    mapCanvas.bfg = null;
////                    mapCanvas.mapImg = null;
////                    mapCanvas = null;
//
////                    mapCanvas = null;
////                    tileCanvas  = null;
////                    mapCanvas = new MapCanvas();
////                    tileCanvas = new TileCanvas();
////                    initMapCanvas();
//                    System.gc();
//                }
//            });
//        }
//        return CloseProjectItem;
//    }
    private JMenuItem mapItem;

    private JMenuItem getMapItem() {
        if (mapItem == null) {
            mapItem = new JMenuItem();
            mapItem.setText("��ͼ����");
//            jMenuItem.addActionListener(this);
            mapItem.addActionListener(new java.awt.event.ActionListener() {

                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    setMapNews();


                }
            });

        }
        return mapItem;
    }

    private void setMapNews() {
        if (map != null) {

            getJDialog1();
            initJComboBox2();
            initJComboBox4();
            initTextFiled();
            jDialog1.setVisible(true);
            jTable.updateTable();
        } else {
            JOptionPane.showMessageDialog(getJContentPane(), "��ͼ�����ڣ����½������ͼ");
        }
    }

    private JMenuItem getSetItem() {
        if (jItemSet == null) {
            jItemSet = new JMenuItem();
            jItemSet.setText("ѡ��");
//            jItemSet.addActionListener(this);
            jItemSet.addActionListener(new java.awt.event.ActionListener() {

                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    getJDialogSet();
                    jdSet.setVisible(true);
                }
            });
        }
        return jItemSet;
    }
//
//    private JMenuItem getPicSaveItem() {
//        if (ImgItem == null) {
//            ImgItem = new JMenuItem();
//            ImgItem.setText("Ԥ������");
////            ImgItem.addActionListener(this);
//            ImgItem.addActionListener(new java.awt.event.ActionListener() {
//
//                @Override
//                public void actionPerformed(java.awt.event.ActionEvent e) {
////                    try {
//                    if (map != null) {
//                        try {
//                            File file = new File(".\\preview\\" + map.getName() + ".png");
//                            ImageUtil.writeImage(bf, file, "png");//��ΪbfΪ͸���������ʽ����ɾ���͸������ɫ�ĵ�ͼ���ɵ���tile��ͼƬ��
//                            JOptionPane.showMessageDialog(getJContentPane(), "����Ԥ��ͼ�ɹ�");
//                        } catch (Exception ex) {
//                            JOptionPane.showMessageDialog(getJContentPane(), "����Ԥ��ͼʧ��");
//                        }
//                    }
//                }
//            });
//        }
//        return ImgItem;
//    }
    private JMenuItem dataItem;

    private JMenuItem getdataItem() {
        if (dataItem == null) {
            dataItem = new JMenuItem();
            dataItem.setText("���ݹ���");
//            dataItem.addActionListener(this);
            dataItem.addActionListener(new java.awt.event.ActionListener() {

                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    if (!isHasProject) {
                        JOptionPane.showMessageDialog(getJContentPane(), "�����½���Ŀ");
                        return;
                    }
                    creatDM();
                    dm.setVisible(true);
                }
            });
        }
        return dataItem;
    }
    private AnimationMaker am = null;

    private void creatAM() {
        if (am == null) {
            am = new AnimationMaker();
        }
    }
    private JMenuItem animationItem;

    private JMenuItem getAnimationItem() {
        if (animationItem == null) {
            animationItem = new JMenuItem();
            animationItem.setText("�����༭");
//            dataItem.addActionListener(this);
            animationItem.addActionListener(new java.awt.event.ActionListener() {

                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    if (!isHasProject) {
                        JOptionPane.showMessageDialog(getJContentPane(), "�����½���Ŀ");
                        return;
                    }
                    creatAM();
                    am.setVisible(true);
                }
            });
        }
        return animationItem;
    }
//    private JMenuItem getRepaintItem() {
//        if (jRepaintItem == null) {
//            jRepaintItem = new JMenuItem();
//            jRepaintItem.setText("ˢ��");
////            jRepaintItem.addActionListener(this);
//            jRepaintItem.addActionListener(new java.awt.event.ActionListener() {
//
//                @Override
//                public void actionPerformed(java.awt.event.ActionEvent e) {
//                    if (map != null) {
//                        initMapCanvas();
//                        getPreviewDialog().repaint();
//                        getJMenu1().repaint();
//                        getPicJMenu().repaint();
//
//
//                    }
//                }
//            });
//
//
//        }
//        return jRepaintItem;
//
//
//    }

    /**
     * This method initializes jMenuItem3
     *
     * @return javax.swing.JMenuItem
     */
    private JMenuItem getJMenuItem3() {
        if (jMenuItem3 == null) {
            jMenuItem3 = new JMenuItem();
            jMenuItem3.setText("�����ͼ");
//            jMenuItem3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
//                InputEvent.CTRL_MASK));
//            jMenuItem3.addActionListener(this);
            jMenuItem3.addActionListener(new java.awt.event.ActionListener() {

                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    if (map != null) {
                        saveMap();
                    } else {
                        JOptionPane.showMessageDialog(getJSplitPane(),
                            "��ͼ�����ڣ����½������ͼ");
                    }
                }
            });
        }
        return jMenuItem3;
    }

    /**
     * This method initializes jPanel
     *
     * @return javax.swing.JPanel
     */
    private JPanel getJPanel() {
        if (jPanel == null) {
//            tileCanvas.setText("Ŀǰû�пɼ��صĵ�ͼ���봴���µ�ͼ");
            jPanel = new JPanel();
            jPanel.setLayout(new BorderLayout());
//        }
            tileCanvas = new TileCanvas();
            jPanel.setBackground(Color.gray);
            jPanel.add(tileCanvas, BorderLayout.NORTH);
        }
//        }
        return jPanel;
    }

    /**
     * This method initializes jPanel1
     *
     * @return javax.swing.JPanel
     */
    private JPanel getJPanel1() {
        if (jPanel1 == null) {

            jPanel1 = new JPanel();
            jPanel1.setLayout(new BorderLayout());
//        }
            mapCanvas = new MapCanvas();
            jPanel1.setBackground(Color.GRAY);
            jPanel1.add(mapCanvas, BorderLayout.NORTH);
        }
        return jPanel1;
    }

    /**
     * This method initializes jScrollPane
     *
     * @return javax.swing.JScrollPane
     */
    private JScrollPane getJScrollPane() {
        if (jScrollPane == null) {
            jScrollPane = new JScrollPane();
            jScrollPane.setPreferredSize(new Dimension(3, 350));
            jScrollPane.setViewportView(getJPanel());
        }
        return jScrollPane;
    }

    /**
     * This method initializes jScrollPane1
     *
     * @return javax.swing.JScrollPane
     */
    private JScrollPane getJScrollPane1() {
        if (jScrollPane1 == null) {
            jScrollPane1 = new JScrollPane();
            jScrollPane1.setViewportView(getJPanel1());
        }
        return jScrollPane1;
    }

    /**
     * This method initializes jSplitPane
     *
     * @return javax.swing.JSplitPane
     */
    private JSplitPane getJSplitPane() {
        if (jSplitPane == null) {
            jSplitPane = new JSplitPane();
            jSplitPane.setDividerSize(8);
//            jSplitPane.setUI((SplitPaneUI)(SplitPaneUI.createUI(uidefs)));
            jSplitPane.setOneTouchExpandable(true);
//            System.out.println(SplitPane.);


            jSplitPane.setLeftComponent(getJSplitPane1());
            jSplitPane.setRightComponent(getJScrollPane1());
        }
        return jSplitPane;

    }
    /**
     * This method initializes this
     *
     * @return void
     */
    public String version = "MobileGameMaker v1.0beta";

    private void initialize() {
        this.setSize(900, 650);
        this.setJMenuBar(getJJMenuBar());
        this.setContentPane(getJContentPane());
        this.add(getSbToolBar(), BorderLayout.SOUTH);
        this.add(getToolBar2(), BorderLayout.NORTH);
//        this.add(new BasicArrowButton(BasicArrowButton.NORTH), BorderLayout.NORTH);
        initTitle();
        Dimension screenSize =
            Toolkit.getDefaultToolkit().getScreenSize();
        Dimension labelSize = this.getSize();
        this.setLocation(screenSize.width / 2 - (labelSize.width / 2),
            screenSize.height / 2 - (labelSize.height / 2));//����λ����Ļ�в�
        Image image = this.getToolkit().getImage("icon/icon.png");
        this.setIconImage(image);
        data = new Data();
        mData = new Data();
        mapVector = new MapList();

    }

    private void initTitle() {
        this.setTitle(version);
    }

    public void changeTitle() {
        this.setTitle(Project.getProjectName() + " - " + version);
    }
    public MapList mapVector;

    private void initJComboBox4() {
        jComboBox4.removeAllItems();
        File[] f = new File(Project.getProjectPath() + "\\audio\\music").listFiles();
        int ii = f.length;
        jComboBox4.addItem(map.getMusicName());
        for (int i = 0; i
            < ii; i++) {
//            if (f[i].getName().endsWith(".png")) {
            //�������ļ���ʽ
            jComboBox4.addItem(f[i].getName());
//            }
        }
    }

    private void initJComboBox2() {
        jComboBox2.removeAllItems();
        File[] f = new File(Project.getProjectPath() + "\\image\\tileset").listFiles();
        int ii = f.length;
        jComboBox2.addItem(map.getImageName());
        for (int i = 0; i
            < ii; i++) {
//            if (f[i].getName().endsWith(".png")) {
            //�������ļ���ʽ
            jComboBox2.addItem(f[i].getName());
//            }
        }
    }
    private JComboBox jComboBox3, jComboBox4;

    private void initJComboBox() {
        jComboBox.removeAllItems();
        File[] f = new File(Project.getProjectPath() + "\\image\\tileset").listFiles();
        int ii = f.length;
        for (int i = 0; i
            < ii; i++) {
//            if (f[i].getName().endsWith(".png")) {
            //�������ļ���ʽ
            jComboBox.addItem(f[i].getName());
//            }
        }
    }

    private void initJComboBox3() {
        jComboBox3.removeAllItems();
        File[] f = new File(Project.getProjectPath() + "\\audio\\music").listFiles();
        int ii = f.length;
        for (int i = 0; i
            < ii; i++) {
//            if (f[i].getName().endsWith(".png")) {
            //�������ļ���ʽ
            jComboBox3.addItem(f[i].getName());
//            }
        }
    }

    public void initMapCanvas() {
        // TODO �Զ����ɷ������
        tileCanvas.updateCanvas();
        mapCanvas.updateCanvas();
    }

    private void saveMap() {
        JFileChooser jf = new JFileChooser();
        jf.setCurrentDirectory(new File(Project.getProjectPath()));
        jf.setAcceptAllFileFilterUsed(false);
        MyFileFilter txtFilter = new MyFileFilter(".txt", "txt �ļ� (*.txt)");
        jf.addChoosableFileFilter(txtFilter);
        int fresult;
        fresult = jf.showSaveDialog(this);
        if (fresult == JFileChooser.APPROVE_OPTION) { // �û�����ˡ�ȷ������ť
            File file = jf.getSelectedFile(); //����ļ���
            // ��ñ�ѡ�еĹ�����
            MyFileFilter filter = (MyFileFilter) jf.getFileFilter();
            // ��ù���������չ��
            String ends = filter.getEnds();
            File newFile = null;
            if (file.getAbsolutePath().toUpperCase().endsWith(ends.toUpperCase())) {
                // ����ļ�����ѡ����չ�������ģ���ʹ��ԭ��
                newFile = file;
            } else {
                // �������ѡ������չ��
                newFile = new File(file.getAbsolutePath() + ends);
            }
            try {
                FileWriter fw = new FileWriter(newFile);
                PrintWriter pw = new PrintWriter(fw);
                pw.println("�༭���汾��" + version);
                pw.println("��ͼ��ţ�" + currentMapIndex);
                pw.println("��ͼ���ƣ�" + map.getName());
                pw.println("ͼ�����ƣ�" + map.getImageName());
                pw.println("�������֣�" + map.getMusicName());
                pw.println("ͼ������" + map.getLayerNum());
                pw.println("��ͼ��Ԫ���ȣ�" + map.getCellWidth() + " ��ͼ��Ԫ��߶ȣ�"
                    + map.getCellHeight());
                pw.println("��ͼ���(��Ԫ����)��" + map.getCol() + " ��ͼ�߶�(��Ԫ����)��"
                    + map.getRow());
                for (int i = 0; i
                    < map.getLayerNum(); i++) {
                    pw.println("ͼ��" + (i + 1) + "��");
                    pw.print("{");
                    for (int j = 0; j
                        < map.getRow(); j++) {
                        pw.print("{");
                        for (int k = 0; k
                            < map.getCol(); k++) {
                            pw.print(map.getMap()[i][j][k]);
                            if (k != map.getCol() - 1) {
                                pw.print(",");
                            }
                        }
                        pw.print("}");

                        if (j != map.getRow() - 1) {
                            pw.println(",");
                        }
                    }
                    pw.println("};");
                }
                pw.println("ͨ�жȣ�");
                pw.print("{");
                for (int j = 0; j
                    < map.getRow(); j++) {
                    pw.print("{");
                    for (int k = 0; k
                        < map.getCol(); k++) {
                        pw.print(map.getWay()[j][k]);
                        if (k != map.getCol() - 1) {
                            pw.print(",");

                        }
                    }
                    pw.print("}");
                    if (j != map.getRow() - 1) {
                        pw.println(",");
                    }
                }
                pw.println("};");

//                int si = map.getScriptList().getScriptList().size();
//                pw.println("�ű�������" + si);
//                for (int i = 0; i
//                    < si; i++) {
//                    Script temp = (Script) map.getScriptList().getScriptList().elementAt(i);
//                    pw.println("��" + temp.getRow() + "�е�" + temp.getCol()
//                        + "��");
//                    for (int j = 0; j
//                        < temp.size(); j++) {
//                        pw.println("�ű����ݣ�" + temp.elementAt(j));
//                    }
//                }
                System.gc();
                pw.flush();
                pw.close();
                fw.close();
            } catch (Exception e) {
                // TODO �Զ����� catch ��
            }
        }
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;

    }
} // @jve:decl-index=0:visual-constraint="27,-30"

