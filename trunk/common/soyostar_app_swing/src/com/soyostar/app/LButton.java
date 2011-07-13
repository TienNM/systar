/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soyostar.app;

import com.soyostar.app.event.ActionListener;
import com.soyostar.app.event.KeyEvent;
import com.soyostar.app.event.TouchEvent;

/**
 *
 * @author Administrator
 */
public class LButton extends Widget {

    private static final int STATE_AFCAL = 0;
    private static final int STATE_FOCUS = 1;
    private String text = "";
    private Image focusImage = null;
    private Image afocalImage = null;
    private int textColor = Color.BLACK;
    private int textSize = -1;
    private ActionListener actionListener = null;
    private int state = STATE_AFCAL;

    public LButton() {
    }

    public LButton(String text) {
        this.text = text;
    }

    public LButton(Image afocalImage, Image focusImage) {
        this.afocalImage = afocalImage;
        this.focusImage = focusImage;
    }

    public Image getAfocalImage() {
        return afocalImage;
    }

    public void setAfocalImage(Image afocalImage) {
        this.afocalImage = afocalImage;
    }

    public Image getFocusImage() {
        return focusImage;
    }

    public void setFocusImage(Image focusImage) {
        this.focusImage = focusImage;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getTextColor() {
        return textColor;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }

    public int getTextSize() {
        return textSize;
    }

    public void setTextSize(int textSize) {
        this.textSize = textSize;
    }

    public ActionListener getActionListener() {
        return actionListener;
    }

    public void setActionListener(ActionListener listener) {
        this.actionListener = listener;
    }

    @Override
    public boolean dispatchTouchEvent(TouchEvent touchEvent) {
        System.out.println("LButton-dispatchTouchEvent type:" + touchEvent.getType() + "  x:" + touchEvent.getX() + " y:" + touchEvent.getY());
        boolean state = false;
        switch (touchEvent.getType()) {
            case TouchEvent.TOUCH_DOWN:
            case TouchEvent.TOUCH_MOVE: {
                this.state = STATE_FOCUS;
                state = super.dispatchTouchEvent(touchEvent);
            }
            break;
            case TouchEvent.TOUCH_UP: {
                this.state = STATE_AFCAL;
                if (actionListener != null) {
                    actionListener.actionPerformed(this);
                    state = true;
                } else {
                    state = super.dispatchTouchEvent(touchEvent);
                }
            }
            break;
        }
        return state;
    }

    @Override
    public void paint(Painter painter) {
        painter.setColor(getBackground());
        painter.fillRect(0, 0, getWidth(), getHeight());
        switch (state) {
            case STATE_AFCAL: {
                if (afocalImage != null) {
                    painter.drawImage(afocalImage, 0, 0, Painter.LT);
                }
            }
            break;
            case STATE_FOCUS: {
                if (focusImage != null) {
                    painter.drawImage(focusImage, 0, 0, Painter.LT);
                }
            }
            break;
        }
        painter.setColor(textColor);
        if (textSize > 0) {
            painter.setTextSize(textSize);
        }
        painter.drawString(text, getWidth() / 2, getHeight() / 2, Painter.HV);
    }
}
