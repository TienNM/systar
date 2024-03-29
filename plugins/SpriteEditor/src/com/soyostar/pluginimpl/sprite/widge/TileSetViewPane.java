/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soyostar.pluginimpl.sprite.widge;

import com.soyostar.pluginimpl.sprite.model.Animation;
import com.soyostar.pluginimpl.sprite.model.TileSet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Administrator
 */
public class TileSetViewPane extends JPanel {

    private int selectedIndex = -1;
    private Dimension viewSize = new Dimension(128, 128);
    private int titleSize = 16;

    public TileSetViewPane() {
    }

    /**
     *
     * @return
     */
    public int getSelectedIndex() {
        return this.selectedIndex;
    }

    /**
     *
     * @param index
     */
    public void setSelectedIndex(int index) {
        this.selectedIndex = index;
        this.updateUI();
    }

    public TileSet getSelectedTileSet() {

        return this.selectedIndex < 0 ? null : Animation.getInstance().getTileSet(this.selectedIndex);
    }

    /**
     *
     * @param x
     * @param y
     */
    public void setSelectedTileSet(int x, int y) {
        int len = Animation.getInstance().getTileSetsCount();
        if (y > 0 && y <= this.viewSize.height + this.titleSize) {
            if (x > 0 && x <= len * this.viewSize.width) {
                this.setSelectedIndex(x / this.viewSize.width);
                return;
            }
        }
        this.setSelectedIndex(-1);
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension size = super.getPreferredSize();
        int len = Animation.getInstance().getTileSetsCount();
        return new Dimension(Math.max(size.width, len * (this.viewSize.width + 1)), Math.max(size.height, this.viewSize.height + this.titleSize));
    }

    @Override
    public void paintComponent(Graphics g) {
        g.clearRect(0, 0, this.getWidth(), this.getHeight());
        int cc = 150 / this.titleSize;
        for (int i = 0; i < Animation.getInstance().getTileSetsCount(); i++) {
            g.setColor(Color.WHITE);
            g.fillRect(i * viewSize.width, titleSize, viewSize.width - 1, viewSize.height - 1);
            g.setColor(Color.LIGHT_GRAY);
            for (int y = titleSize / 8; y < (titleSize + viewSize.height) / 8; y++) {
                for (int x = i * viewSize.width / 8; x < (i + 1) * viewSize.width / 8; x++) {
                    if ((y + x) % 2 == 1) {
                        g.fillRect(x * 8, y * 8, 8, 8);
                    }
                }
            }
            Animation.getInstance().getTileSet(i).paintPreview(g, i * this.viewSize.width + 2, this.titleSize + 2, this.viewSize.width - 4);
            Color labelColor = Color.BLACK;
            if (this.selectedIndex == i) {
                labelColor = Color.BLUE;
            }
            for (int j = 0; j < this.titleSize; j++) {
                g.setColor(new Color(labelColor.getRed(), labelColor.getGreen(), labelColor.getBlue(), 105 + j * cc));
                g.drawLine(i * this.viewSize.width, j + 1, i * this.viewSize.width + this.viewSize.width - this.titleSize + j, j + 1);
            }
            if (this.selectedIndex == i) {
                g.setColor(Color.BLUE);
            } else {
                g.setColor(Color.BLACK);
            }
            g.draw3DRect(i * (this.viewSize.width), this.titleSize, this.viewSize.width - 1, this.viewSize.height - 1, true);
            g.setColor(Color.WHITE);
            g.drawString(Animation.getInstance().getTileSet(i).getName(), i * (this.viewSize.width) + 2, this.titleSize - 2);
        }
    }
}
