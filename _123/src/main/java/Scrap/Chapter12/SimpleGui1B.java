package Scrap.Chapter12;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleGui1B  implements ActionListener {
    JButton button;

    public static void main(String[] args) {

        SimpleGui1B simpleGui1B = new SimpleGui1B();
        simpleGui1B.go();

    }

    private void go() {
        JFrame frame = new JFrame();
        button = new JButton("Click me");


        button.addActionListener(this);

        frame.getDefaultCloseOperation();
        frame.setSize(1000,1000);
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        button.setText("I've been clicked");
    }
}
