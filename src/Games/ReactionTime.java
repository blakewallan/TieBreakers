package Games;

import javax.swing.*;

/**
 * Blake Allan
 * 6/16/15.
 */
import java.awt.*;
import java.awt.event.*;

public class ReactionTime extends JApplet implements ActionListener {

    JButton startButton = new JButton("CLICK ME!");
    long start;
    long end;
    long randomTime;
    boolean started = false;
    String results = "";

    public void init() {
        JPanel panel = new JPanel(new GridLayout(4, 4));
        startButton.setSize(50, 25);
        panel.add(startButton, BorderLayout.SOUTH);
        this.add(panel, BorderLayout.SOUTH);

        startButton.addActionListener(this);
    }

    public void timer() {
        started = true;
        start = System.currentTimeMillis();
        randomTime = Math.round(Math.random() * 5000) + 1000;
        try {
            Thread.sleep(randomTime);
        }
        catch(InterruptedException e) {}
    }

    public void paint(Graphics g)  {
        g.drawString("" + results, 20, 175);
        g.drawOval(120, 10, 150, 150);

        if (started) {
            g.setColor(Color.red);
            g.fillOval(120, 10, 150, 150);
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            if (started) {
                started = false;
                end = System.currentTimeMillis();
                if (end < (start + randomTime)) {
                    results = "You clicked too soon, try again";
                }
                else if (e.getSource() == startButton) {
                    results = "Your reaction time is " + (end - (start + randomTime)) + " MilliSeconds";
                    started = false;
                }
            }
             else {
                timer();
            }
            repaint();
        }

    }
}
