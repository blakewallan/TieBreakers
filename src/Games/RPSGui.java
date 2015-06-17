package Games;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;


public class RPSGui extends JFrame {

    //ints for panel size
    final int Width = 400;
    final int Height = 600;

    //Swing GUI
    JFrame frame;
    JPanel panel;
    JPanel scores;

    //buttons for user choice
    JButton rockButton = new JButton("Rock");
    JButton paperButton = new JButton("Paper");
    JButton scissorsButton = new JButton("Scissors");

    //Labels for wins, losses, and ties
    JLabel wins = new JLabel("Wins: 0");
    JLabel losses = new JLabel("Losses: 0");
    JLabel ties = new JLabel("Ties: 0");
    JLabel playerChoice = new JLabel("You chose: ");
    JLabel computerChoice = new JLabel("The Computer chose: ");
    JLabel declareWinner = new JLabel("Who will win?");

    public RPSGui() {

        //creating new panel and frame, setting size, and making settings
        frame = new JFrame("ROCK PAPER SCISSORS");
        frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        panel = new JPanel();
        scores = new JPanel();
        panel.setPreferredSize(new Dimension(Width, Height/2));
        scores.setPreferredSize(new Dimension(Width, Height/2));
        panel.setLayout(new GridLayout(9, 1));
        panel.setBackground(Color.WHITE);
        frame.add(panel);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        //Adding Buttons to the Jpanel
        panel.add(rockButton);
        panel.add(paperButton);
        panel.add(scissorsButton);

        //Adding labels to Jpanel and making new font for the labels
        Font test = new Font("serif", Font.BOLD, 25);
        panel.add(declareWinner).setFont(test);
        panel.add(wins).setFont(test);
        panel.add(losses).setFont(test);
        panel.add(ties).setFont(test);
        panel.add(playerChoice).setFont(test);
        panel.add(computerChoice).setFont(test);;

        //Packing and making visible
        frame.pack();
        frame.setVisible(true);

        //adding action listeners to all the buttons
        ActionListener buttons = new RPSButtonControl(rockButton, paperButton, scissorsButton, wins, losses, ties,
                playerChoice, computerChoice, declareWinner);

        rockButton.addActionListener(buttons);
        paperButton.addActionListener(buttons);
        scissorsButton.addActionListener(buttons);

    }
}

