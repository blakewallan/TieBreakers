package Games;


/**
 * Blake Allan
 * 5/14/15.
 */
public class RPSGameRules {

    public int wins = 0;
    public int losses = 0;
    public int ties = 0;

    public int getWinner(int computerChoice, int playerChoice) {

        //If statements that return false if computer wins & true if player wins
        if (computerChoice == 1 && playerChoice == 2){
            wins ++;
            return 1;
        }
        if (computerChoice == 2 && playerChoice == 3){
            wins ++;
            return 1;
        }
        if (computerChoice == 3 && playerChoice == 1){
            wins ++;
            return 1;
        }
        if (computerChoice == playerChoice){
            ties ++;
            return 3;
        }
        else {
            losses ++;
            return 2;
        }
    }

    public int runGame(int results){
        if (results == 1){
            return 1;
        }
        if (results == 2){
            return 2;
        }
        if (results == 3){
            return 3;
        }
        else return 4;
    }

    public int cpuChoice() {
        return (int) (Math.random() * (4 - 1) + 1);
    }

    public int getWins(){
        return wins;
    }
    public int getLosses(){
        return losses;
    }
    public int getTies(){
        return ties;
    }

}
