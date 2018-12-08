package Scrap.Chapter12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TwoButtons  {

    JFrame jFrame;
    JLabel jLabel;

    public static void main(String[] args) {
        TwoButtons gui = new TwoButtons();
        gui.go();
    }

    public void go() {
        jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton labelButton = new JButton("Change label ");
        labelButton.addActionListener(new LabelListener());

        JButton colorButton = new JButton("Change Colors");
        colorButton.addActionListener(new ColorListener());

        jLabel = new JLabel("I'm GRUT!!!");
        MyDrawPanel1 drawPanel = new MyDrawPanel1();

        jFrame.getContentPane().add(BorderLayout.SOUTH, colorButton);
        jFrame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        jFrame.getContentPane().add(BorderLayout.EAST, labelButton);
        jFrame.getContentPane().add(BorderLayout.WEST, jLabel);

        jFrame.setSize(300,300);
        jFrame.setVisible(true);
    }

    class LabelListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            jLabel.setText("Ouch!");
        }
    }

    class ColorListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            jFrame.repaint();
        }
    }

}
