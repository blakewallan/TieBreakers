package Games;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Blake Allan
 * Description: This class implements an actionlistener,
 * it gives behavior to all the buttons and labels and uses and instance
 * of my rules class to run the GUI.
 * 5/14/15.
 */

public class RPSButtonControl implements ActionListener {

    //Initializing variables
    JButton rock;
    JButton paper;
    JButton scissors;
    JLabel wins;
    JLabel losses;
    JLabel ties;
    JLabel playerChoice;
    JLabel computerChoice;
    JLabel declareWinner;

    int choice;

    //Creating an object of GameRules to use the data
    public RPSGameRules game = new RPSGameRules();

    //Constructor bringing in the labels to be changed
    public RPSButtonControl(JButton rock, JButton paper, JButton scissors, JLabel wins, JLabel losses, JLabel ties,
                            JLabel playerChoice, JLabel computerChoice, JLabel declareWinner)
    {

        this.rock = rock;
        this.paper = paper;
        this.scissors = scissors;
        this.wins = wins;
        this.losses = losses;
        this.ties = ties;
        this.playerChoice = playerChoice;
        this.computerChoice = computerChoice;
        this.declareWinner = declareWinner;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //Getting user input through buttons and
        if (e.getSource() == rock) {
            choice = 1;
        }
        else if (e.getSource() == paper) {
            choice = 2;
        }
        else if (e.getSource() == scissors) {
            choice = 3;
        }

        //Printing the labels with the players choice
        if (choice == 1) {
            playerChoice.setText("You chose: Rock");
        }
        if (choice ==2) {
            playerChoice.setText("You chose: Paper");
        }
        if (choice == 3) {
            playerChoice.setText("You chose: Scissors");
        }

        //Printing the label with the computers choice
        int cpuChoice = game.cpuChoice();
        if (cpuChoice == 1) {
            computerChoice.setText("The computer chose: Rock");
        }
        else if (cpuChoice == 2) {
            computerChoice.setText("The computer chose: Paper");
        }
        else if (cpuChoice == 3) {
            computerChoice.setText("The computer chose: Scissors");
        }

        //creating a winner int from my Rules class
        int winner = game.runGame(game.getWinner(cpuChoice, choice));

        //If else for setting win/tie/loss scores and printing who won
        if (winner == 1) {
            wins.setText("Wins: " + game.getWins());
            declareWinner.setText("YOU WON!");
        }
        else if (winner == 2){
            losses.setText("Losses: " + game.getLosses());
            declareWinner.setText("Sorry, you lost");
        }
        else if (winner == 3){
            ties.setText("Ties: " + game.getTies());
            declareWinner.setText("It was a tie");
        }
    }
}

