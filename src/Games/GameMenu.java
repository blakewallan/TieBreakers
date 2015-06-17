package Games;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GameMenu extends JFrame{

    //Swing GUI
    JFrame frame;
    JPanel panel;
    JButton rps = new JButton("Play rock paper scissors!");
    JButton quit = new JButton("Quit Game");
    JButton guessNumber = new JButton("Play guess the number!");

    //Panel Dimensions
    final int Width = 400;
    final int Height = 200;

    //constructor

    public GameMenu() {
        frame = new JFrame("TIE BREAKERS!");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(Width, Height));
        frame.add(panel);
        frame.pack();

        panel.add(rps);
        panel.add(guessNumber);
        panel.add(quit);

        ActionListener buttons = new MenuButtonControl(rps, guessNumber, quit);
        rps.addActionListener(buttons);
        guessNumber.addActionListener(buttons);
        quit.addActionListener(buttons);
    }
}