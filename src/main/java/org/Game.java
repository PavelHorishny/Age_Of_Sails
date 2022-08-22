package org;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Game extends JPanel {
    Rectangle r1 = new Rectangle(50,50,25,25);
    Rectangle r2 = new Rectangle(150,50,25,25);
    Rectangle r3 = new Rectangle(250,50,25,25);
    ArrayList <Rectangle> fleet = new ArrayList<>();
    Rectangle selected = null;
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
            /*    if(b.contains(e.getPoint())){
                    selected=b;
                    repaint();
                }*/
                for (Rectangle r : fleet) {
                    if (r.contains(e.getPoint())) {
                        selected = r;
                        System.out.println("selected");
                        repaint();
                    }
                }
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
            showLines(g2d, selected);
            showMoves(g2d,selected);
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
        Ship s = new Ship(0,0);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(Color.MAGENTA);
        g2d.fill(b);
        System.out.println(b.getHeight());
       /* g2d.fill(r1);
        g2d.fill(s.getR());*/
        for(Rectangle r : fleet){
            g2d.fill(r);
        }
    }

    private void showLines(Graphics2D g, Rectangle r){
        g.setColor(Color.RED);
        g.drawRect(r.x+2+25,r.y+2,21,21);
        g.drawRect((2*25)+(r.x)+2,r.y+2,21,21);
        /*g.drawLine(r.x+12,r.y+12, r.x+112, r.y+112);
        g.drawLine(r.x+12,r.y+ 12, r.x-112, r.y-112);*/
    }

    private void showMoves(Graphics2D g, Rectangle r){
        g.setColor(Color.GREEN);
        g.drawRect(r.x+25,r.y,25,25);
        g.drawRect(r.x+50,r.y,25,25);
        g.drawRect(r.x+75,r.y,25,25);
        g.drawRect(r.x-25,r.y,25,25);
        g.drawRect(r.x-50,r.y,25,25);
        g.drawRect(r.x-75,r.y,25,25);
    }
/*    private void ifSelected(){

        if(selected!=null) {
            Graphics2D g = (Graphics2D) getGraphics().create();
            g.setColor(Color.RED);
            g.fill(selected);
            repaint();
        }
    }*/
}
