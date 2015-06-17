package Games;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

/**
 * Blake Allan
 * 5/11/15.
 */

public class Game extends Canvas implements Runnable{

    public static final int WIDTH = 600;
    public static final int HEIGHT = 800;
    public static final String NAME = "Tie Breakers!";

    private JFrame frame;

    public boolean running = false;
    public int tickCount = 0;

    private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

    public Game(){

        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        setMaximumSize(new Dimension(WIDTH, HEIGHT));
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        frame = new JFrame(NAME);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        frame.add(this, BorderLayout.CENTER);
        frame.pack();

        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public synchronized void start() {
        running = true;
        new Thread(this).start();
    }

    public synchronized void stop() {
        running = false;
    }

    public void run() {
        long lastTime = System.nanoTime();
        double nsPerTick = 1000000000D/60D;
        int frames = 0;
        int ticks = 0;

        long lastTimer = System.currentTimeMillis();
        double delta = 0;

        while (running){
            long now = System.nanoTime();
            delta += (now - lastTime) / nsPerTick;
            lastTime = now;
            boolean shouldRender = true;
            while(delta >= 1) {
                ticks++;
                tick();
                delta -= 1;
                shouldRender = true;
            }

            if (shouldRender) {
                frames++;
                render();
            }

            if(System.currentTimeMillis() - lastTimer >= 1000){
                lastTimer += 1000;
                System.out.println(ticks + " ticks, " + frames + " frames");
                frames = 0;
                ticks = 0;
            }
        }
    }

    public void tick(){
        tickCount++;
        for (int i = 0; i < pixels.length; i++){
            pixels[i] = i + tickCount;
        }
    }

    public void render() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null){
            createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 40, 40);
        g.dispose();
        bs.show();
    }

    public static void main(String[] args){
        new Game().start();
    }
}