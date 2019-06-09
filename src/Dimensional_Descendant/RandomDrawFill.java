/*
The random draw and fill class is responsible for creating a random distribution of all cells on the screen. 
The class takes all random distributed cells and draws them on the screen. 
The class is creating the random distribution without having an overlap between cells areas with each other’s.
 */

package Dimensional_Descendant;

import java.awt.BasicStroke;
import java.awt.Color;
import static java.awt.Color.RED;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author ayman
 */
public class RandomDrawFill {
    private ArrayList<CoreCell> Universe;
    private Graphics2D g2d;
    private  Font oldFont;
    private int x = 10 ; 
    private int y = 20 ;
    private int strWidth;
    private int strHeight;
    private Rectangle borderRect;
    private ScreenObjects newObject = new ScreenObjects();
    private float thikness = 2;
    private DisplayAlgorithm algo = new DisplayAlgorithm();
    private int wW;
    private int wH;
    private IntroductionHeader headerIntro;

            
    public RandomDrawFill(Graphics2D g2d, ArrayList<CoreCell> Universe){
        this.g2d = g2d;
        this.Universe = Universe; 
        //System.out.println("i am here");
        headerIntro = new IntroductionHeader (g2d);
    }
    
    /*
    * Randomly disribute all elements on the screen 
    * avoid overlap 
    * avoid getting out of borders 
    o	The method is creating a random number for X and Y positions.
    o	The methods set the position for each cell and then create new random positions. 
    o	The new positions are checked to make sure that it doesn’t intersect with the existing cells position. 
    o	The method is taking into consideration the size of the cell according to the font and the characters in the string and its alignment.
    o	The method creates an array list that contains the screen object, cells and positions. 

    */
    public synchronized ScreenObjects drawUniverseString (){
        
        wH = g2d.getDeviceConfiguration().getBounds().height;
        wW = g2d.getDeviceConfiguration().getBounds().width;
        int randomX =10;
        int randomY =100;
        boolean pointExist = false;
        Point tmpPoint = new Point();
        boolean first_time = false; 
        
                    newObject.getAllScreenObjects().clear();

        for ( CoreCell tmpCell : Universe ){
            pointExist = true; 
            if ( ! (tmpCell.getCoreCellID() == 0 || tmpCell.getCoreCellID() == 1)){
                while  ( pointExist && first_time){

                    //Font strFont = new Font("Arial", Font.PLAIN, 12);
                    g2d.setFont(new Font("Arial", Font.PLAIN, 12));
                    String str = tmpCell.getCoreCellName();
                    FontMetrics fontMetrics = g2d.getFontMetrics();
                    strWidth = fontMetrics.stringWidth(str);
                    strHeight = fontMetrics.getHeight();
                    randomX = (int)(Math.random() * (wW - strWidth - 10 )) +10 ;
                    randomY = (int)(Math.random() * (wH - strHeight - 130))  + 100;
                    tmpPoint.setLocation(randomX, randomY);
                    borderRect = new Rectangle(randomX - 2, randomY - 2, strWidth + 4, strHeight+4);
                   // int i = 0;
                     for ( ScreenObjects tmpObj : newObject.getAllScreenObjects() ){
                        // System.out.println("the point "+ tmpPoint.toString() + "and the rect is "+ tmpObj.getRectangle().getLocation().toString());
                         Rectangle tmpRect = tmpObj.getRectangle();
                         if (tmpRect.intersects(borderRect) ){
                             pointExist = true;
                             break;
                         } else {
                              pointExist = false; 
                         }
                     }
                }
                first_time = true; 

                String str = tmpCell.getCoreCellName();
                FontMetrics fontMetrics = g2d.getFontMetrics();
                strWidth = fontMetrics.stringWidth(str);
                strHeight = fontMetrics.getHeight();
                //

                Stroke oldStroke = g2d.getStroke();
                g2d.setStroke(new BasicStroke(thikness));
                borderRect = new Rectangle(randomX - 4, randomY - 4, strWidth + 6, strHeight+6);
                g2d.setColor(Color.WHITE);
                g2d.fill3DRect(borderRect.x, borderRect.y, borderRect.width, borderRect.height,true);
                g2d.setStroke(oldStroke);
                g2d.setColor(Color.BLACK);
                g2d.drawString(str, randomX , randomY);
                newObject = new ScreenObjects(tmpCell, borderRect);
                }

        }
        return newObject;
    }
    
    
    /*
     * draw all the screen objects that are loaded on the array 
    */
            
        public synchronized void drawAllScrrenObject(){
            ArrayList<ScreenObjects> allObjects = newObject.getAllScreenObjects();
            for ( ScreenObjects tmpObj : allObjects ){
                g2d.setFont(new Font("Arial", Font.PLAIN, 12));
                String str = tmpObj.getCoreCell().getCoreCellName();
                FontMetrics fontMetrics = g2d.getFontMetrics();
                strHeight = fontMetrics.getHeight();
                Rectangle rect = tmpObj.getRectangle();
                // we increased the x and y for the string as what is stored is 
                // the rect poin not the string, so we will need to adjust 
                // it to be in the center
                oldFont = g2d.getFont();
                Stroke oldStroke = g2d.getStroke();
                g2d.setStroke(new BasicStroke(tmpObj.getThiknessRect()));
                //g2d.setColor(tmpObj.getRectColor());
                g2d.setColor(Color.WHITE);
                g2d.fill3DRect(rect.x, rect.y , rect.width, rect.height,true);
                g2d.setStroke(oldStroke);
                //g2d.setColor(tmpObj.getStringColor());
                g2d.setColor(Color.BLACK);
                g2d.drawString(str, rect.x + 2 , rect.y + strHeight  );
                g2d.setFont(oldFont);
            }
        }
        
        /*
         * when the cell is selected, draw mechnism 
        o	the method takes a clicked point
        o	The method search for this point in the array list of the screen objects. 
        o	If the object if found then drawing mechanism starts
        o	The drawing mechanism is simply redraw all the cells in the screen 
        o	If the cell is the selected on, then draw two colors orange and blue
        o	If the cells in the Horizontal dimensions in the display algorithm , then draw with the orange color
        o	If the cells in the Vertical dimensions in the display algorithm , then draw with the blue color
        o	All other cells are drawn normally. 
        o	The method draws lines between all Horizontal and Vertical cells according to their colors. 
        */
        public synchronized boolean drawSelectedDims(Point clickPoint){
            ScreenObjects clickedObj = new ScreenObjects();
            ArrayList<CoreCell> HCells;
            ArrayList<CoreCell> VCells;
            boolean found = false; 
            ArrayList<ScreenObjects> allObjects = newObject.getAllScreenObjects();
            Point p1H = new Point(); 
            Point p2H = new Point();
            Point p1V = new Point(); 
            Point p2V = new Point();
            
            for ( ScreenObjects tmpObj : allObjects ){
                if (tmpObj.getRectangle().contains(clickPoint)){
                    clickedObj = tmpObj;

                    found = true; 
                    break;
                } 
            }
            if ( found ){
                HCells = algo.getHorizontalCellofCenteredCell(clickedObj.getCoreCell());
                VCells = algo.getVerticalCellofCenteredCell(clickedObj.getCoreCell());
                for ( ScreenObjects tmpObj : allObjects ){
                    
                    
                    if ( tmpObj == clickedObj ){
                        // Draw Selected Cell
                        //**********************
                        // set new font, thikness and color
                        tmpObj.setStrFont(new Font("Arial", Font.BOLD, 16) );
                        tmpObj.setThiknessRect(4);
                        tmpObj.setRectColor(Color.BLUE);
                        tmpObj.setStringColor(Color.BLACK);
                        oldFont = g2d.getFont();
                        g2d.setFont(tmpObj.getStrFont());

                        // set new rect
                        String str = tmpObj.getCoreCell().getCoreCellName();
                        FontMetrics fontMetrics = g2d.getFontMetrics();
                        strWidth = fontMetrics.stringWidth(str);
                        strHeight = fontMetrics.getHeight();
                        borderRect = new Rectangle(tmpObj.getRectangle().x - 2, tmpObj.getRectangle().y - 2, strWidth + 4, strHeight+4);

                        // draw the object
                        
                        Stroke oldStroke = g2d.getStroke();
                        g2d.setStroke(new BasicStroke(tmpObj.getThiknessRect()));
                        g2d.setColor(tmpObj.getRectColor());
                        g2d.fill3DRect(borderRect.x, borderRect.y , borderRect.width/2, borderRect.height,true);
                        float doublethink = 4; 
                        g2d.setStroke(new BasicStroke(doublethink));
                        g2d.setColor(Color.ORANGE);
                        g2d.fillRect(borderRect.x  + (borderRect.width/2) , borderRect.y  , (borderRect.width) /2, borderRect.height);
                        
                        g2d.setColor(tmpObj.getStringColor());
                        g2d.drawString(str, borderRect.x + 2 , borderRect.y + strHeight  );
                        g2d.setFont(oldFont);
                        g2d.setStroke(oldStroke);
                        
                        

                        
                    } else if ( HCells.contains(tmpObj.getCoreCell())) {
                        g2d.setColor(Color.ORANGE);
                        g2d.setStroke(new BasicStroke(2));
                        p1H = tmpObj.getRectangle().getLocation();
                        if ( p2H.x == 0  ){
                            p2H = clickedObj.getRectangle().getLocation();
                            g2d.drawLine(p1H.x, p1H.y, p2H.x, p2H.y);
                        } else {
                            g2d.drawLine(p1H.x, p1H.y, p2H.x, p2H.y);
                        }
                        p2H = p1H; 
                        // Draw Horizontal  Cells
                        // *********************
                        // set new font, thikness and color
                        tmpObj.setStrFont(new Font("Arial", Font.BOLD, 14) );
                        tmpObj.setThiknessRect(4);
                        tmpObj.setRectColor(Color.ORANGE);
                        tmpObj.setStringColor(Color.BLACK);
                        oldFont = g2d.getFont();
                        g2d.setFont(tmpObj.getStrFont());
                        
                        // set new rect
                        String str = tmpObj.getCoreCell().getCoreCellName();
                        FontMetrics fontMetrics = g2d.getFontMetrics();
                        strWidth = fontMetrics.stringWidth(str);
                        strHeight = fontMetrics.getHeight();
                        borderRect = new Rectangle(tmpObj.getRectangle().x - 2, tmpObj.getRectangle().y - 2, strWidth + 4, strHeight+4);
                        
                        // draw the object
                        Stroke oldStroke = g2d.getStroke();
                        g2d.setStroke(new BasicStroke(tmpObj.getThiknessRect()));
                        g2d.setColor(tmpObj.getRectColor());
                        g2d.fill3DRect(borderRect.x, borderRect.y , borderRect.width, borderRect.height, true);
                        g2d.setStroke(oldStroke);
                        g2d.setColor(tmpObj.getStringColor());
                        g2d.drawString(str, borderRect.x + 2 , borderRect.y + strHeight  );
                        g2d.setFont(oldFont);
                        
                        
                        headerIntro.drawIntroDimTextH(clickedObj.getCoreCell());
                        
                        
                    }else if ( VCells.contains(tmpObj.getCoreCell())){
                        //Draw Lines
                        g2d.setColor(Color.BLUE);
                        g2d.setStroke(new BasicStroke(2));
                        p1V = tmpObj.getRectangle().getLocation();
                        if ( p2V.x == 0  ){
                            p2V = clickedObj.getRectangle().getLocation();
                            g2d.drawLine(p1V.x, p1V.y, p2V.x, p2V.y);
                        } else {
                            g2d.drawLine(p1V.x, p1V.y, p2V.x, p2V.y);
                        }
                        p2V = p1V; 
                        // Draw Vertical Cells
                        //**********************
                        // set new font, thikness and color
                        tmpObj.setStrFont(new Font("Arial", Font.BOLD, 14) );
                        tmpObj.setThiknessRect(4);
                        tmpObj.setRectColor(Color.BLUE);
                        tmpObj.setStringColor(Color.WHITE);
                        oldFont = g2d.getFont();
                        g2d.setFont(tmpObj.getStrFont());
                        
                        // set new rect
                        String str = tmpObj.getCoreCell().getCoreCellName();
                        FontMetrics fontMetrics = g2d.getFontMetrics();
                        strWidth = fontMetrics.stringWidth(str);
                        strHeight = fontMetrics.getHeight();
                        borderRect = new Rectangle(tmpObj.getRectangle().x - 2, tmpObj.getRectangle().y - 2, strWidth + 4, strHeight+4);
                        
                        // draw the object
                        Stroke oldStroke = g2d.getStroke();
                        g2d.setStroke(new BasicStroke(tmpObj.getThiknessRect()));
                        g2d.setColor(tmpObj.getRectColor());
                        g2d.fill3DRect(borderRect.x, borderRect.y , borderRect.width, borderRect.height, true);
                        g2d.setStroke(oldStroke);
                        g2d.setColor(tmpObj.getStringColor());
                        g2d.drawString(str, borderRect.x + 2 , borderRect.y + strHeight  );
                        g2d.setFont(oldFont);
                        
                        
                        headerIntro.drawIntroDimTextV(clickedObj.getCoreCell());
                        
                    } else  {
                        // Draw the rest of the cells 
                        //*****************************
                        // set new font, thikness and color
                        tmpObj.setStrFont(new Font("Arial", Font.PLAIN, 12) );
                        tmpObj.setThiknessRect(1);
                        tmpObj.setRectColor(Color.WHITE);
                        tmpObj.setStringColor(Color.BLACK);
                        oldFont = g2d.getFont();
                        g2d.setFont(tmpObj.getStrFont());
                        
                        // set new rect
                        String str = tmpObj.getCoreCell().getCoreCellName();
                        FontMetrics fontMetrics = g2d.getFontMetrics();
                        strWidth = fontMetrics.stringWidth(str);
                        strHeight = fontMetrics.getHeight();
                        borderRect = new Rectangle(tmpObj.getRectangle().x - 2, tmpObj.getRectangle().y - 2, strWidth + 4, strHeight+4);
                        
                        // draw the object
                        
                        Stroke oldStroke = g2d.getStroke();
                        g2d.setStroke(new BasicStroke(tmpObj.getThiknessRect()));
                        g2d.setColor(tmpObj.getRectColor());
                        g2d.fill3DRect(borderRect.x, borderRect.y , borderRect.width, borderRect.height, true);
                        g2d.setStroke(oldStroke);
                        g2d.setColor(tmpObj.getStringColor());
                        g2d.drawString(str, borderRect.x + 2 , borderRect.y + strHeight  );
                    }
                }
            }
            
            return found; 
        }
        
}
