package org.window;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame{

    public MainFrame(){
        JSplitPane splitPane = new JSplitPane();
        JPanel leftPanel = new JPanel();
        JPanel rightPanel = new JPanel();
        JSplitPane split = new JSplitPane();
        JPanel bottomPanel = new JPanel();
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1000, 600));
        getContentPane().setLayout(new GridLayout());
        getContentPane().add(splitPane);
        split.setEnabled(false);
        splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setDividerLocation(700);
        splitPane.setLeftComponent(leftPanel);
        splitPane.setRightComponent(split);
        split.setOrientation(JSplitPane.VERTICAL_SPLIT);
        split.setDividerLocation(300);
        split.setTopComponent(rightPanel);
        split.setBottomComponent(bottomPanel);
        pack();
    }
    public static void main(String[] args){
        EventQueue.invokeLater(() -> new MainFrame().setVisible(true));
    }
}
