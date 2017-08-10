package com.iongeger.networkingtestandroid;
import java.io.Serializable;

public class Message implements Serializable {

    private static final long serialVersionUID = -2723363051271966964L;

    private int x, y;
    private boolean last_msg = false;

    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public boolean isLast_msg() {
        return last_msg;
    }
    public void setLast_msg(boolean last_msg) {
        this.last_msg = last_msg;
    }

}