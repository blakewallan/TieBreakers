package Games;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Blake Allan
 * 6/2/15.
 */

public class GuessTheNumber extends JPanel implements ActionListener {

    Random random = new Random();

    //ints for panel size
    int Width = 400;
    int Height = 400;

    //Swing GUI
    JFrame frame;
    JPanel panel;
    JPanel bottomPanel;
    JButton playGame = new JButton("Ready to play?");
    JTextField textField;

    //Constructor
    public GuessTheNumber() {
        createAndShowGUI();
    }

    public void createAndShowGUI() {

        //creating new panel and frame, setting size, and making settings
        //Game rules string
        JLabel gameRulesLabel = new JLabel("<html>This game will test your quick counting skills,  " +
                " <br> rectangles will start falling  <br> Your goal is to count the rectangles! " +
                "<br> when you are ready to play just hit the button bellow</html>");

        frame = new JFrame("GUESS THE NUMBER");
        frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        frame.setPreferredSize(new Dimension(Width, Height));
        panel = new JPanel();
        textField = new JTextField("Enter Your Guess");

        //Adding the introduction label
        panel.add(gameRulesLabel);

        //Adding button for user to start game after being explained the rules
        panel.add(playGame);
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    //Used to make random colored balls
    public Color randColor(int rand){
        if (rand == 1) {
            return Color.RED;
        }
        if (rand == 2) {
            return Color.blue;
        }
        if (rand == 3) {
            return Color.yellow;
        }
        if (rand == 4) {
            return Color.green;
        }
        else return Color.orange;
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.black);
        g.fillOval(10, 10, 10, 10);
    }

    int ballDiameter = 20;

    public void moveBalls() {
        //xPos += xMove;
        //yPos += yMove;

       // if (xPos >= 400 || xPos <= 0) { //COMEBACK TO THIS, USE VAR NOT CONSTANT FOR SCALE
          //  xMove = -xMove;
        }
        //if (yPos >= 400 || yPos <= 0) {
            //yMove = -yMove;
        //}
    //}

    @Override
    public void actionPerformed(ActionEvent e) {
        Random random = new Random();
        if (e.getSource() == playGame) {

        }

    }
}
