package org;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ship {
    int x;
    int y;
    Rectangle r;
    public Ship(int x,int y){
        this.x=x;
        this.y=y;
        r = new Rectangle(25,25,25,25);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Rectangle getR(){
        return r;
    }
}
