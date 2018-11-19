package Chapter12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleGui3C implements ActionListener {

    JFrame jFrame;

    public static void main(String[] args) {
        SimpleGui3C simpleGui3C = new SimpleGui3C();
        simpleGui3C.go();

    }

    public void go() {
        jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton jButton = new JButton("Change Colors");

        jButton.addActionListener(this);

        MyDrawPanel1 myDrawPanel1 = new MyDrawPanel1();

        jFrame.getContentPane().add(BorderLayout.SOUTH,jButton);
        jFrame.getContentPane().add(BorderLayout.CENTER, myDrawPanel1);
        jFrame.setSize(1000,1000);
        jFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        jFrame.repaint();
    }


}

    class MyDrawPanel extends JPanel {
        public void paintComponent (Graphics g) {
            g.fillRect(0,0,this.getWidth(),this.getHeight());

            int red = (int) (Math.random() *255);
            int blue = (int) (Math.random() *255);
            int green = (int) (Math.random() *255);

            Color randomColor = new Color(red,green,blue);
            g.setColor(randomColor);
            g.fillOval(70,70,100,100);
        }
    }