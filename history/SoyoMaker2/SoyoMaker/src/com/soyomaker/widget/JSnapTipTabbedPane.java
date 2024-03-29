/*
 * Copyright 2010-2011 Soyostar Software, Inc. All rights reserved.
 */
package com.soyomaker.widget;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JTabbedPane;
import javax.swing.JToolTip;

/**
 *
 * @author rehte
 */
public class JSnapTipTabbedPane extends JTabbedPane {

    private double scaleRatio = 0.4;
    private HashMap<String, Component> maps = new HashMap<String, Component>();

    @Override
    public void insertTab(String title, Icon icon, Component component, String tip, int index) {
        tip = "tab" + component.hashCode();
        maps.put(tip, component);
        super.insertTab(title, icon, component, tip, index);
    }

    @Override
    public void removeTabAt(int index) {
        Component component = getComponentAt(index);
        maps.remove("tab" + component.hashCode());
        super.removeTabAt(index);
    }

    @Override
    public JToolTip createToolTip() {
        ImageToolTip tooltip = new ImageToolTip();
        tooltip.setComponent(this);
        return tooltip;
    }

    class ImageToolTip extends JToolTip {

        @Override
        public Dimension getPreferredSize() {
            String tip = getTipText();
            Component component = maps.get(tip);
            if (component != null) {
                return new Dimension((int) (getScaleRatio() * component.getWidth()), (int) (getScaleRatio() * component.getHeight()));
            } else {
                return super.getPreferredSize();
            }
        }

        @Override
        public void paintComponent(Graphics g) {
            String tip = getTipText();
            Component component = maps.get(tip);
            if (component instanceof JComponent) {
                JComponent jcomponent = (JComponent) component;
                Graphics2D g2d = (Graphics2D) g;
                AffineTransform at = g2d.getTransform();
                g2d.transform(AffineTransform.getScaleInstance(getScaleRatio(), getScaleRatio()));
                ArrayList<JComponent> dbcomponents = new ArrayList<JComponent>();
                updateDoubleBuffered(jcomponent, dbcomponents);
                jcomponent.paint(g);
                resetDoubleBuffered(dbcomponents);
                g2d.setTransform(at);
            }
        }

        private void updateDoubleBuffered(JComponent component, ArrayList<JComponent> dbcomponents) {
            if (component.isDoubleBuffered()) {
                dbcomponents.add(component);
                component.setDoubleBuffered(false);
            }
            for (int i = 0; i < component.getComponentCount(); i++) {
                Component c = component.getComponent(i);
                if (c instanceof JComponent) {
                    updateDoubleBuffered((JComponent) c, dbcomponents);
                }
            }
        }

        private void resetDoubleBuffered(ArrayList<JComponent> dbcomponents) {
            for (JComponent component : dbcomponents) {
                component.setDoubleBuffered(true);
            }
        }
    }

    /**
     *
     * @return
     */
    public double getScaleRatio() {
        return scaleRatio;
    }

    /**
     *
     * @param scaleRatio
     */
    public void setScaleRatio(double scaleRatio) {
        this.scaleRatio = scaleRatio;
    }
}