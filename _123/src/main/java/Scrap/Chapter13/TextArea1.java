package Scrap.Chapter13;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextArea1 implements ActionListener {

    JTextArea text;

    public static void main(String[] args) {
        TextArea1 gui = new TextArea1();
        gui.go();
    }

    public void go() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JButton button = new JButton("Just click it");
        button.addActionListener(this);
        text = new JTextArea(10, 20);
        text.setLineWrap(true);

        JScrollPane scrollPane = new JScrollPane(text);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panel.add(scrollPane);

        frame.getContentPane().add(BorderLayout.CENTER,panel);
        frame.getContentPane().add(BorderLayout.SOUTH, button);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        panel.setSize(screenSize.width,screenSize.height);
        frame.setBounds(0,0,screenSize.width, screenSize.height);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        text.append("button clicked \n ");
    }
}
