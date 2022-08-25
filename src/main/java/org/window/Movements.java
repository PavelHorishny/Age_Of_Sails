package org.window;

import org.DAO.Vessel;
import org.Weather;

import java.awt.*;

public class Movements {

    public static void movements(Graphics g, Vessel v, Weather w){
        int mp = v.getBreeze();
        switch (w.getDirection()){
            case "N":
                movementsNorth(v,g,mp);
                movementsNW(v,g,mp-1);
                movementsNE(v,g,mp-1);
                movementsEast(v,g,mp-2);
                movementsWest(v,g,mp-2);
                movementsSW(v,g,mp-3);
                movementsSE(v,g,mp-3);
                movementsSouth(v,g,mp-4);
                break;
            case "S":
                movementsSouth(v,g,mp);
                movementsSW(v,g,mp-1);
                movementsSE(v,g,mp-1);
                movementsWest(v,g,mp-2);
                movementsEast(v,g,mp-2);
                movementsNW(v,g,mp-3);
                movementsNE(v,g,mp-3);
                movementsNorth(v,g,mp-4);
                break;
            case "W":
                movementsWest(v,g,mp);
                movementsNW(v,g,mp-1);
                movementsSW(v,g,mp-1);
                movementsNorth(v,g,mp-2);
                movementsSouth(v,g,mp-2);
                movementsNE(v,g,mp-3);
                movementsSE(v,g,mp-3);
                movementsEast(v,g, mp-4);
                break;
            case "E":
                movementsEast(v,g,mp);
                movementsNE(v,g,mp-1);
                movementsSE(v,g,mp-1);
                movementsNorth(v,g,mp-2);
                movementsSouth(v,g,mp-2);
                movementsNW(v,g,mp-3);
                movementsSW(v,g,mp-3);
                movementsWest(v,g, mp-4);
                break;
            case "NW":
                movementsNW(v,g,mp);
                movementsWest(v,g,mp-1);
                movementsNorth(v,g,mp-1);
                movementsNE(v,g,mp-2);
                movementsSW(v,g,mp-2);
                movementsSouth(v,g,mp-3);
                movementsEast(v,g,mp-3);
                movementsSE(v,g,mp-4);
                break;
            case "NE":
                movementsNE(v,g,mp);
                movementsNorth(v,g,mp-1);
                movementsEast(v,g,mp-1);
                movementsNW(v,g,mp-2);
                movementsSE(v,g,mp-2);
                movementsWest(v,g,mp-3);
                movementsSouth(v,g,mp-3);
                movementsSW(v,g,mp-4);
                break;
            case "SW":
                movementsSW(v,g,mp);
                movementsSouth(v,g,mp-1);
                movementsWest(v,g,mp-1);
                movementsNW(v,g,mp-2);
                movementsSE(v,g,mp-2);
                movementsNorth(v,g,mp-3);
                movementsEast(v,g,mp-3);
                movementsNE(v,g,mp-4);
                break;
            case "SE":
                movementsSE(v,g,mp);
                movementsEast(v,g,mp-1);
                movementsSouth(v,g,mp-1);
                movementsSW(v,g,mp-2);
                movementsNE(v,g,mp-2);
                movementsWest(v,g,mp-3);
                movementsNorth(v,g,mp-3);
                movementsNW(v,g,mp-4);
                break;
        }

    }
    private static void movementsEast(Vessel v, Graphics g, int mp) {
        g.setColor(Color.GREEN);
        int a = mp;
        int x = v.x;
        int y = v.y;
        for(int i = 0;i<a;i++){
            g.drawRect(x+25,y,25,25);
            x+=25;
        }
    }

    private static void movementsWest(Vessel v, Graphics g, int mp) {
        g.setColor(Color.GREEN);
        int a = mp;
        int x = v.x;
        int y=v.y;
        for(int i = 0;i<a;i++){
            g.drawRect(x-25,y,25,25);
            x-=25;
        }
    }

    private static void movementsNorth(Vessel v, Graphics g, int mp) {
        g.setColor(Color.GREEN);
        int a = mp;
        int x = v.x;
        int y=v.y;
        for(int i = 0;i<a;i++){
            g.drawRect(x,y-25,25,25);
            y-=25;
        }
    }

    private static void movementsSouth(Vessel v, Graphics g, int mp) {
        g.setColor(Color.GREEN);
        int a = mp;
        int x = v.x;
        int y = v.y;
        for(int i = 0;i<a;i++){
            g.drawRect(x,y+25,25,25);
            y+=25;
        }
    }

    private static void movementsNE(Vessel v, Graphics g, int mp) {
        g.setColor(Color.GREEN);
        int a = mp;
        int x = v.x;
        int y = v.y;
        for(int i = 0;i<a;i++){
            g.drawRect(x+25,y-25,25,25);
            x+=25;
            y-=25;
        }
    }

    private static void movementsNW(Vessel v, Graphics g, int mp) {
        g.setColor(Color.GREEN);
        int a = mp;
        int x = v.x;
        int y=v.y;
        for(int i = 0;i<a;i++){
            g.drawRect(x-25,y-25,25,25);
            x-=25;
            y-=25;
        }
    }

    private static void movementsSE(Vessel v, Graphics g, int mp) {
        g.setColor(Color.GREEN);
        int a = mp;
        int x = v.x;
        int y=v.y;
        for(int i = 0;i<a;i++){
            g.drawRect(x+25,y+25,25,25);
            x+=25;
            y+=25;
        }
    }

    private static void movementsSW(Vessel v, Graphics g, int mp) {
        g.setColor(Color.GREEN);
        int a = mp;
        int x = v.x;
        int y = v.y;
        for(int i = 0;i<a;i++){
            g.drawRect(x-25,y+25,25,25);
            y+=25;
            x-=25;
        }
    }
}
