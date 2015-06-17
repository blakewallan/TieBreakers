package Games;

import java.applet.Applet;
import java.awt.*;

/**
 * Blake Allan
 * 6/10/15.
 */

public class BallStart extends Applet implements Runnable{

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void start(){
        Thread thread = new Thread(this);
    }

    @Override
    public void run() {

    }

    @Override
    public void stop(){
        super.stop();
    }

    @Override
    public void destroy(){

    }

    @Override
    public void paint(Graphics g){

    }

}
