package Games;

/**
 * Blake Allan
 * 6/12/15.
 */
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test extends JPanel {


    int x = 0;
    int y = 0;

    int xmove = 1;
    int ymove = 1;

    public void moveBall() {
        x += xmove;
        y += ymove;

        /**if (x >= 200 || x <= 0) { //COMEBACK TO THIS, USE VAR NOT CONSTANT FOR SCALE
            x += -xmove;
        }
        if (y >= 200 || y <= 0) {
            y += -ymove;
        }*/
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.fillOval(x, y, 30, 30);

    }

    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("Guess the Number");
        Random random = new Random();

        frame.setSize(300, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for (int i = 0; i < random.nextInt(); i++) {
            Test game = new Test();
            frame.add(game);
            while (true){
                game.moveBall();
                game.repaint();
                Thread.sleep(10);
            }
        }

        /**while (true) {
            game.moveBall();
            game.repaint();
            Thread.sleep(10);
            game2.moveBall();
            game2.repaint();
        }*/


    }
}
