package org.window;

import javax.swing.*;
import java.awt.*;

public class GameField extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        for(int i = 0; i<600/25;i++){
            g.drawLine(i*25,0,i*25,600);
            g.drawLine(0,i*25,600,i*25);
        }
    }
}
