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

import static org.Firing.fireRange;
import static org.window.Movements.movements;

public class Game extends JPanel {
    Vessel v = new Vessel(VesselType.CORVETTE,250,250,25,25);
    Rectangle r1 = new Rectangle(50,50,25,25);
    Rectangle r2 = new Rectangle(150,50,25,25);
    Rectangle r3 = new Rectangle(250,50,25,25);
    ArrayList <Rectangle> fleet = new ArrayList<>();
    Vessel selected = null;
    PanelTest pt;
    Weather w;
    Boat b = new Boat(0,0,25,25);
    public Game (){

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
                            changeWeather();
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
           // showLines(g2d, selected);
            showMoves(g2d,selected,w);
            showFireRange(g2d,selected);

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
        w = new Weather ();
        System.out.println(w.getDirection());
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

    private void showFireRange (Graphics2D g, Vessel v){
       fireRange(g,v);
    }

    private void showMoves(Graphics g, Vessel v, Weather w) {
        movements(g,v,w);
    }

    private void changeWeather(){
        w=new Weather();
    }
}
