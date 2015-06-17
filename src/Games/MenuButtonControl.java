package Games;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Blake Allan
 * 5/14/15.
 */

public class MenuButtonControl implements ActionListener {

    JButton rps;
    JButton quit;
    JButton guessNumber;

    public MenuButtonControl(JButton rps, JButton guessNumber, JButton quit) {
        this.rps = rps;
        this.quit = quit;
        this.guessNumber = guessNumber;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == rps){
            new RPSGui();
        }
        else if (e.getSource() == quit){
            System.exit(0);
        }
        else if (e.getSource() == guessNumber) {
            new GuessTheNumber().createAndShowGUI();
        }
    }
}
