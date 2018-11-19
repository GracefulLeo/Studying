package Chapter12;

import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MiniMusicPlayer3 implements ActionListener {

    static JFrame f = new JFrame("Мой первый музыкальный клип");
    static MyDrawPanel1 ml;
    JButton button = new JButton("Play again");
    static MiniMusicPlayer3 player3 = new MiniMusicPlayer3();
    boolean changed = false;



    public static void main(String[] args) {
        player3.go();
    }

    public void setUpGui() {
        button.addActionListener(this);
        ml = new MyDrawPanel1();
        f.setBounds(300, 300, 1000, 1000);
        f.add(BorderLayout.WEST,button);
        f.getContentPane().add(BorderLayout.CENTER, ml);
        f.setVisible(true);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void go() {
        setUpGui();

        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequencer.addControllerEventListener(ml, new int[]{127});
            Sequence sequence = new Sequence(Sequence.PPQ, 4);
            Track track = sequence.createTrack();

            int r = 0;
            for (int i = 0; i < 60; i += 4) {
                r = (int) ((Math.random() * 50) + 1);
                track.add(makeEvent(144, 1, r, 100, i));
                track.add(makeEvent(176, 1, 127, 0, i));
                track.add(makeEvent(128, 1, r, 100, i + 2));
            }

            sequencer.setSequence(sequence);
            sequencer.start();
            sequencer.setTempoInBPM(120);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
        MidiEvent midiEvent = null;
        try {
            ShortMessage a = new ShortMessage();
            a.setMessage(comd, chan, one, two);
            midiEvent = new MidiEvent(a, tick);
        } catch (Exception e) {
        }
        return midiEvent;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        player3.go();
    }
}

class MyDrawPanel1 extends JPanel implements ControllerEventListener {
    boolean msg = false;

    @Override
    public void controlChange(ShortMessage event) {
        msg = true;
        repaint();
    }

    public void paintComponent(Graphics g) {
        if (msg) {
            Graphics2D g2 = (Graphics2D) g;

            int r = (int) (Math.random() * 250);
            int gr = (int) (Math.random() * 250);
            int b = (int) (Math.random() * 250);

            g.setColor(new Color(r, gr, b));

            int ht = (int) ((Math.random() * 400) + 10);
            int width = (int) ((Math.random() * 400) + 10);

            int x = (int) ((Math.random() * 400) + 10);
            int y = (int) ((Math.random() * 400) + 10);

            g.fillRect(x, y, width, ht);
            msg = false;
        }
    }
}
