package org;

import org.DAO.Vessel;

import java.awt.*;

public class Firing {
    public static void fireRange(Graphics g, Vessel v){
        g.setColor(Color.RED);
        int a = v.getRange();
        int x = v.x;
        int y = v.y;
        for(int i = 1; i<=a;i++){
            g.drawRect(x+2+(25*i),y+2,21,21);
            g.drawRect(x+2-(25*i),y+2,21,21);
            g.drawRect(x+2,y+2+(25*i),21,21);
            g.drawRect(x+2,y+2-(25*i),21,21);
            g.drawRect(x+2+(25*i),y+2+(25*i),21,21);
            g.drawRect(x+2+(25*i),y+2-(25*i),21,21);
            g.drawRect(x+2-(25*i),y+2+(25*i),21,21);
            g.drawRect(x+2-(25*i),y+2-(25*i),21,21);
        }
    }
}
