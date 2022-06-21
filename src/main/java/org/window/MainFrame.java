package org.window;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame{

    public MainFrame(){
        JSplitPane mainPane = new JSplitPane();
        JPanel gameField = new JPanel();
        JPanel infoPanel = new JPanel();
        JSplitPane secondaryPane = new JSplitPane();
        JPanel buttonPanel = new JPanel();
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1000, 600));
        getContentPane().setLayout(new GridLayout());
        getContentPane().add(mainPane);
        mainPane.setEnabled(false);
        secondaryPane.setEnabled(false);
        mainPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        mainPane.setDividerLocation(700);
        mainPane.setLeftComponent(gameField);
        mainPane.setRightComponent(secondaryPane);
        secondaryPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
        secondaryPane.setDividerLocation(300);
        secondaryPane.setTopComponent(infoPanel);
        secondaryPane.setBottomComponent(buttonPanel);
        pack();
    }
    public static void main(String[] args){
        EventQueue.invokeLater(() -> new MainFrame().setVisible(true));
    }
}
