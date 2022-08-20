package org;

import org.window.GameField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TestPanel extends JPanel implements ActionListener {
    Rectangle r1;
    Rectangle r2;
    Rectangle selected = null;
    Polygon p = new Polygon(new int[]{50, 62, 75},new int[]{50,25,50},3);
    public TestPanel(){
        setBackground(Color.BLUE);
        setFocusable(true);
        r1=new Rectangle(50,50,25,25);
        r2 = new Rectangle(500,500,25,25);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(selected!=null){switch (e.getKeyCode()){
                    case KeyEvent.VK_LEFT:
                        selected.x-=25;
                        repaint();
                        System.out.println("left");
                        break;
                    case KeyEvent.VK_RIGHT:

                        System.out.println("right");
                        selected.x+=25;
                        repaint();
                        break;
                    case KeyEvent.VK_UP:
                        selected.y-=25;
                        repaint();
                        System.out.println(KeyEvent.VK_UP);
                        break;
                    case KeyEvent.VK_DOWN:
                        selected.y+=25;
                        repaint();
                        System.out.println("down");
                        break;
                }
            }
            }
        });
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (r1.contains(e.getPoint())){
                    selected=r1;
                    System.out.println("selected");
                    repaint();
                }
                if(p.contains(e.getPoint())){
                    System.out.println("selelcted");
                }
                if (r2.contains(e.getPoint())){
                    selected=r2;
                    System.out.println("selected 2");
                    repaint();
                }
            }
        });
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800,600);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(Color.RED);

        g.fillPolygon(p);
        drawMap(g);
        drawShips(g);
        if(selected!=null){
            g2d.setColor(Color.RED);
            /*g2d.fill(selected);*/
            showLines(g2d, selected);
            showMoves(g2d,selected);
        }
    }
    private void drawMap(Graphics g){

        for(int i = 0; i<800/25;i++){
            g.drawLine(i*25,0,i*25,800);
            g.drawLine(0,i*25,800,i*25);
        }
    }

    private void drawShips(Graphics g){
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(Color.MAGENTA);
        g2d.fill(r1);
        g2d.setColor(Color.CYAN);
        g2d.fill(r2);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
/*    public class MyKeyAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            switch (e.getKeyCode()){
                case KeyEvent.VK_LEFT:
                    System.out.println("left");
                    break;
                case KeyEvent.VK_RIGHT:

                    System.out.println("right");
                    break;
                case KeyEvent.VK_UP:
                    System.out.println(KeyEvent.VK_UP);
                    break;
                case KeyEvent.VK_DOWN:
                    System.out.println("down");
                    break;
            }
        }
    }*/
}
