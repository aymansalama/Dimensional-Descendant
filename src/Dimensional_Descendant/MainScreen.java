/*
The main interface “floating cell graphical interface” is built using the main screen class. 
The main screen class extends the Core GUI class and implements the mouse and the keyboard listener. 
The class is initiating the screen and its properties by calling different functions. 
The keyboard listener is mainly for pressing escape to quit and to handle the arrow keys. 
The mouse listener is mainly to listen for the user choice.
 */

package Dimensional_Descendant;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Color.RED;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author ayman
 */
public class MainScreen extends CoreGUI implements KeyListener, MouseListener, MouseMotionListener, MouseWheelListener {
    
    private String[] dataArray = new String[5];
    //private CreateData systemLife = new CreateData();
    //private CreateDataDNAPaper systemLife = new CreateDataDNAPaper();
    //private CreateDataJamesBond systemLife = new CreateDataJamesBond();
    //private CreateDataSwan systemLife = new CreateDataSwan();
    private CreateDataHeadOfState systemLife = new CreateDataHeadOfState();
    private Image bg;
    private boolean counterFirsttime = true; 
    private Rectangle testRect;
    private ScreenObjects scrObj;
    private RandomDrawFill drawRandom;
    private Graphics2D g2d;
    private boolean clicked = false; 
    private Point clickedPoint = new Point();
    private IntroductionHeader intro;
    private TwoDimView twoD;
    private int view =0;

//init also call init from super class
    /*
    o	Initiate the screen properties and the full screen setting. 
    o	Add the key and the mouse listener 
    o	Draw the introduction header by creating introduction object.
    o	Draw randomly all the cells in the universe by calling the random drawing function. 
    o	Preparing the two dimensional graphical interface. 
    */
    public void init() {
        super.init();
        Window w = s.getFullScreenWindow();
        w.setFocusTraversalKeysEnabled(false);
        w.addKeyListener(this);
        w.addMouseListener(this);
        w.addMouseMotionListener(this);
        w.addMouseWheelListener(this);
        g2d = s.getGraphics();
        drawRandom = new RandomDrawFill(g2d, systemLife.getUniverse());
        intro = new IntroductionHeader(g2d);
        twoD = new TwoDimView(g2d, systemLife.getUniverse());
    }

    //key pressed
    /*
    o	If user presses escape, exit the program. 
    o	Check for the arrow pressing to be used in the two dimensional graphical interface
    */
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        /*if (keyCode == KeyEvent.VK_ESCAPE) {
            stop();
        }*/
        switch (keyCode){
            case (KeyEvent.VK_ESCAPE):{
                 stop();
                 break;
            }
            case (KeyEvent.VK_RIGHT):{
                 twoD.addtoCounterX(1);
                 break;
            }
            case (KeyEvent.VK_LEFT):{
                 twoD.addtoCounterX(-1);
                 break;
            }
            case (KeyEvent.VK_UP):{
                 twoD.addtoCounterY(1);
                 break;
            }
            case (KeyEvent.VK_DOWN):{
                 twoD.addtoCounterY(-1);
                 break;
            }
        }
        e.consume();
    }

    //key released
    public void keyReleased(KeyEvent e) {
        e.consume();
    }

    //last method from interface
    public void keyTyped(KeyEvent e) {
        e.consume();
    }
/*
    1.	The list icon enable the use to go to the two dimensional interface
    2.	The circle in the middle enables the customer to go to the floating cell graphical interface. 
    3.	The edit icon “third on the left” enables the user to go to the edit mode.
    4.	The refresh icon enables the customer to change the random distribution of the cells in the universe.
*/
     public void mousePressed(MouseEvent e) {
        Toolkit.getDefaultToolkit().beep();
         clickedPoint = new Point(e.getX() , e.getY());
         clicked = true; 
         
         // Check the mouse click location on which image
         // click on refresh 
         if (intro.getRefreshImageRect().contains(clickedPoint)){
             drawRandom.drawUniverseString();
         }
         if (intro.getListImageRect().contains(clickedPoint)){
             view = 1;
            // twoD.
         } else if ( intro.getRecuDimImageRect().contains(clickedPoint)){
             view = 0; 
             
         } else if (intro.getEditImageRect().contains(clickedPoint)){
             view = 2; 
         }
         
         e.consume();
     }

    @Override
    public void mouseReleased(MouseEvent e){}
    @Override
    public void mouseClicked(MouseEvent e){}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}

    //mouse motion interface
    public void mouseDragged(MouseEvent e) {}

    public void mouseMoved(MouseEvent e) {}

    //mouse wheel interface
    public void mouseWheelMoved(MouseWheelEvent e) {}
    //draw method
    
    /*
    o	The method is drawing the background image
    o	Setting the color of the screen and the fore and back ground 
    o	Calling the introduction drawing method
    o	Check for the mode view 
        	Floating cells graphical interface
        	Two dimensional graphical interface 
    */
    public synchronized void draw(Graphics2D g2d) {
        Window w = s.getFullScreenWindow();
        g2d.setColor(w.getBackground());
        g2d.fillRect(0, 0, s.getWidth(), s.getHeight());
        g2d.setColor(w.getForeground());
        
        //bg = new ImageIcon("C:\\Test\\bg2.jpg").getImage();
        //bg = new ImageIcon("C:\\Test\\bg3.jpg").getImage();
        //bg = new ImageIcon("C:\\Test\\bg6.jpg").getImage();
        bg = new ImageIcon("C:\\Test\\bg7.jpg").getImage();
        //bg = new ImageIcon("C:\\Test\\bg8.jpg").getImage();
        //bg = new ImageIcon("C:\\Test\\bg9.jpg").getImage();
        //bg = new ImageIcon("C:\\Test\\bg10.jpg").getImage();
        //bg = new ImageIcon("C:\\Test\\bg11.png").getImage();
        g2d.drawImage(bg,0,0,null);
        
        intro.drawIntro();
        twoD.drawSelectionImage();

        switch(view){
            case 0:{
                if (this.counterFirsttime){
                    scrObj = drawRandom.drawUniverseString();
                    this.counterFirsttime = false; 
                }else if (clicked) {
                    boolean onObject = drawRandom.drawSelectedDims(clickedPoint);
                    if (!onObject){
                        clicked = false;
                    }
                }else {
                    drawRandom.drawAllScrrenObject();
                }
                break;
            }
            case 1: {
                twoD.drawTwoDimensionLayout();
            }
            case 2: {
                //editMode.
            }
                
        }
        
        
        
      
    }
         
        
}
         
     
