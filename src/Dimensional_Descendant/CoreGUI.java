/*
The class is creating an object from screenManager class. 
The class mainly has the running loop of the GUI. 
And it runs a function for initiating the program and looping it and stopping the program. 
The class doesn’t control the draw method of the grapics2d.
*/

package Dimensional_Descendant;

import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public abstract class CoreGUI {

    private static DisplayMode modes[] = {
        new DisplayMode(1366, 768, 32, 0),
        new DisplayMode(1366, 768, 24, 0),
        new DisplayMode(1366, 768, 16, 0), 
        
        new DisplayMode(1024, 768, 32, 0),
        new DisplayMode(1024, 768, 24, 0),
        new DisplayMode(1024, 768, 16, 0), 
        
        new DisplayMode(800, 600, 32, 0),
        new DisplayMode(800, 600, 24, 0),
        new DisplayMode(800, 600, 16, 0),

        new DisplayMode(640, 480, 32, 0),
        new DisplayMode(640, 480, 24, 0),
        new DisplayMode(640, 480, 16, 0),
        
        
    };

    private boolean running;
    protected ScreenManager s;

    //Stop method
    public void stop() {
        running = false;
    }

    //call init and gameloop
    public void run() {
        try {
            init();
           systemLoop();
        } finally {
            s.restoreScreen();
        }
    }

    //set to full screen
    public void init() {
        s = new ScreenManager();
        DisplayMode dm = s.findFirstCompatibleMode(modes);
        s.setFullScreen(dm);

        Window w = s.getFullScreenWindow();
        w.setFont(new Font("Arial", Font.PLAIN, 12));
        w.setBackground(Color.WHITE);
        w.setForeground(Color.BLACK);
        Graphics2D g = s.getGraphics();

        running = true;
    }

    //main program loop
    public void systemLoop() {
        //long startTime = System.currentTimeMillis();
        //long cumTime = startTime;

       while (running) {
          //  long timePassed = System.currentTimeMillis() - cumTime;
            //cumTime += timePassed;

            //update(timePassed);
            Graphics2D g = s.getGraphics();
            draw(g);
            g.dispose();
            s.update();

            try {
                Thread.sleep(20);
            } catch (Exception ex) {
                System.err.println("Error when trying to sleep: " + ex);
            }
        }
    }

    //update animation
    public void update(long timePassed) {
        //empty//
    }

    //draws to the screen
    public abstract void draw(Graphics2D g);
    
    public JFrame getJFrame(){
        return s.getJFrame();
    }
    
    public Graphics2D getgraphics(){
        return s.getGraphics();
    }
}