package org;

import org.DAO.Vessel;
import org.DAO.VesselType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Game extends JPanel {
    Vessel v = new Vessel(VesselType.CORVETTE,50,50,25,25);
    Rectangle r1 = new Rectangle(50,50,25,25);
    Rectangle r2 = new Rectangle(150,50,25,25);
    Rectangle r3 = new Rectangle(250,50,25,25);
    ArrayList <Rectangle> fleet = new ArrayList<>();
    Vessel selected = null;
    PanelTest pt;
    Boat b = new Boat(0,0,25,25);
    public Game (){
        fleet.add(r1);
        fleet.add(r2);
        fleet.add(r3);
        setFocusable(true);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(v.contains(e.getPoint())){
                    selected=v;
                    repaint();
                }
         /*       for (Rectangle r : fleet) {
                    if (r.contains(e.getPoint())) {
                        selected = r;
                        System.out.println("selected");
                        repaint();
                    }
                }*/
            }
        });
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(selected!=null){
                    switch (e.getKeyCode()){
                        case KeyEvent.VK_SPACE:
                            selected=null;
                            repaint();
                            break;
                        case KeyEvent.VK_LEFT:
                            selected.x-=25;
                            /*selectedVessel.setX(getX()-25);*/
                            repaint();
                            System.out.println("left");
                            break;
                        case KeyEvent.VK_RIGHT:

                            System.out.println("right");
                            selected.x+=25;
                            /*selectedVessel.setX(getX()+25);*/
                            repaint();
                            break;
                        case KeyEvent.VK_UP:
                            selected.y-=25;
                            /*selectedVessel.setY(getY()-25);*/
                            repaint();
                            System.out.println(KeyEvent.VK_UP);
                            break;
                        case KeyEvent.VK_DOWN:
                            selected.y+=25;
                            /*selectedVessel.setY(getX()+25);*/
                            repaint();
                            System.out.println("down");
                            break;
                    }
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        drawMap(g);
        drawShip(g);
        /*ifSelected();*/
        if(selected!=null){
           /* showLines(g2d, selected);
            showMoves(g2d,selected);*/
            fireRange(g2d,selected);
            movementsEast(selected,g2d);
            movementsWest(selected,g2d);
            movementsNorth(selected,g2d);
            movementsSouth(selected,g2d);
            movementsNE(selected,g2d);
            movementsNW(selected, g2d);
            movementsSE(selected,g2d);
            movementsSW(selected,g2d);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800,600);
    }

    @Override
    public void invalidate() {
        super.invalidate();
        setBackground(Color.BLUE);
    }

    private void drawMap(Graphics g){
        for(int i = 0; i<800/25;i++){
            g.drawLine(i*25,0,i*25,800);
            g.drawLine(0,i*25,800,i*25);
        }
    }
    private void drawShip(Graphics g){
       /* Vessel v = new Vessel(VesselType.CORVETTE,50,50,25,25);*/
        Ship s = new Ship(0,0);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(Color.MAGENTA);
        g2d.fill(v);
        System.out.println(b.getHeight());
       /* g2d.fill(r1);
        g2d.fill(s.getR());*/
    /*    for(Rectangle r : fleet){
            g2d.fill(r);
        }*/
    }

    private void fireRange(Graphics2D g, Vessel v){
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
        /*g.drawRect(v.x+2+25,v.y+2,21,21);
        g.drawRect((2*25)+(v.x)+2,v.y+2,21,21);*/
        /*g.drawLine(r.x+12,r.y+12, r.x+112, r.y+112);
        g.drawLine(r.x+12,r.y+ 12, r.x-112, r.y-112);*/
    }

/*    private void showMoves(Graphics2D g, Rectangle r){
        g.setColor(Color.GREEN);
        g.drawRect(v.x+25,v.y,25,25);
        g.drawRect(v.x+50,v.y,25,25);
        g.drawRect(v.x+75,v.y,25,25);
        g.drawRect(v.x-25, v.y,25,25);
        g.drawRect(v.x-50,v.y,25,25);
        g.drawRect(v.x-75,v.y,25,25);
    }*/

    private void movementsEast(Vessel v, Graphics g) {
        g.setColor(Color.GREEN);
        int a = v.getBreeze();
        int x = v.x;
        int y = v.y;
        for(int i = 0;i<a;i++){
            g.drawRect(x+25,y,25,25);
            x+=25;
        }
    }

    private void movementsWest(Vessel v, Graphics g) {
        g.setColor(Color.GREEN);
        int a = v.getBreeze();
        int x = v.x;
        int y=v.y;
        for(int i = 0;i<a;i++){
            g.drawRect(x-25,y,25,25);
            x-=25;
        }
    }

    private void movementsNorth(Vessel v, Graphics g) {
        g.setColor(Color.GREEN);
        int a = v.getBreeze();
        int x = v.x;
        int y=v.y;
        for(int i = 0;i<a;i++){
            g.drawRect(x,y-25,25,25);
            y-=25;
        }
    }

    private void movementsSouth(Vessel v, Graphics g) {
        g.setColor(Color.GREEN);
        int a = v.getBreeze();
        int x = v.x;
        int y = v.y;
        for(int i = 0;i<a;i++){
            g.drawRect(x,y+25,25,25);
            y+=25;
        }
    }

    private void movementsNE(Vessel v, Graphics g) {
        g.setColor(Color.GREEN);
        int a = v.getBreeze();
        int x = v.x;
        int y = v.y;
        for(int i = 0;i<a;i++){
            g.drawRect(x+25,y-25,25,25);
            x+=25;
            y-=25;
        }
    }

    private void movementsNW(Vessel v, Graphics g) {
        g.setColor(Color.GREEN);
        int a = v.getBreeze();
        int x = v.x;
        int y=v.y;
        for(int i = 0;i<a;i++){
            g.drawRect(x-25,y-25,25,25);
            x-=25;
            y-=25;
        }
    }

    private void movementsSE(Vessel v, Graphics g) {
        g.setColor(Color.GREEN);
        int a = v.getBreeze();
        int x = v.x;
        int y=v.y;
        for(int i = 0;i<a;i++){
            g.drawRect(x+25,y+25,25,25);
            x+=25;
            y+=25;
        }
    }

    private void movementsSW(Vessel v, Graphics g) {
        g.setColor(Color.GREEN);
        int a = v.getBreeze();
        int x = v.x;
        int y = v.y;
        for(int i = 0;i<a;i++){
            g.drawRect(x-25,y+25,25,25);
            y+=25;
            x-=25;
        }
    }
}
