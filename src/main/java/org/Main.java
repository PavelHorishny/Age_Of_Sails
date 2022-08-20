package org;

import javax.swing.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
/*        TestPanel t = new TestPanel();
        JFrame frame = new JFrame();
        frame.add(t);
        frame.setTitle("ddddd");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);*/
/*        Wind [] wf = Wind.windForce;
        System.out.println(wf[2]);*/

        for (int i = 0; i < 20; i++) {
            Weather w = new Weather();
            System.out.println(w.getForce());
            System.out.println(w.getDirection());
            System.out.println("next");
        }
    }
}
