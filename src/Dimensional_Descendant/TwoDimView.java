/*
This class is responsible for drawing the two dimensional graphical interface. 
X and Y axis are representing two main dimensions. 
Using the arrows keys, the user can change the selection of X and Y dimensions. 
And the intersection of the two dimensions is resulting into different cells 
that shows the connection between cells.
 */

package Dimensional_Descendant;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author ayman
 */
public class TwoDimView {
    private Graphics2D g2d;
    private float thikness; 
    private Stroke oldStroke; 
    private Color oldColor;
    private int windowW;
    private int windowH;
    private int strWidth;
    private int strHeight;
    private FontMetrics fontMetrics;

    private int counterY = 1;
    private int counterX = 1;
    private ArrayList<Dimension> dimUniverse;
    private Dimension tmpDimX;
    private Dimension tmpDimY;
    private Font oldFont;
    
    public TwoDimView (Graphics2D g2d , ArrayList<CoreCell> Universe){
        dimUniverse = ((Dimension)Universe.get(1)).getDimUniverseArrayList();
        this.g2d = g2d;
        windowW = g2d.getDeviceConfiguration().getBounds().width;
        windowH = g2d.getDeviceConfiguration().getBounds().height;
        fontMetrics = g2d.getFontMetrics();


    }
    
    public void drawSelectionImage(){
       

    }

    
    public void drawTwoDimensionLayout(){
        oldStroke = g2d.getStroke();
        g2d.setStroke(new BasicStroke(4));
        
        g2d.setColor(Color.RED);
        g2d.drawLine( 180 , windowH-80 , 180, 200 );
        
        g2d.setColor(Color.RED);
        g2d.drawLine( 180 , windowH-80 , windowW -180 , windowH -80 );
        
        tmpDimX = dimUniverse.get(counterX);
        tmpDimY = dimUniverse.get(counterY);
        
        String dimStrX = tmpDimX.getCoreCellName();
        String dimStrY = tmpDimY.getCoreCellName();
        oldFont = g2d.getFont();
        g2d.setFont(new Font("Arial", Font.BOLD, 16));
        fontMetrics = g2d.getFontMetrics();
        
        strWidth = fontMetrics.stringWidth(dimStrY);
        strHeight = fontMetrics.getHeight();
        // Draw Horizontal Meaning 
        g2d.setColor(Color.BLUE);
        g2d.fill3DRect(180 -2 - (strWidth/2) , 180 - strHeight -2 , strWidth + 4, strHeight+8, true);
        g2d.setColor(Color.WHITE);
        g2d.drawString(dimStrY , 180 - (strWidth/2), 180  );
        
        strWidth = fontMetrics.stringWidth(dimStrX);
        strHeight = fontMetrics.getHeight();
        // Draw Horizontal Meaning 
        g2d.setColor(Color.ORANGE);
        g2d.fill3DRect(windowW/2 - (strWidth/2) - 3 , windowH -50 - strHeight , strWidth + 4, strHeight+6, true);
        g2d.setColor(Color.BLACK);
        g2d.drawString(dimStrX , windowW/2 - (strWidth/2) -2, windowH -50  );
        
        drawTwoDimensions(); 
        
        
        
        
        g2d.setStroke(oldStroke);
        g2d.setFont(oldFont);
    }
    
    public void addtoCounterX(int x){
        counterX += x;
        if ( counterX == dimUniverse.size()){
            counterX = 1;
        }else if ( counterX == 0 ){
            counterX = dimUniverse.size()-1;
        }
    }
    
    public void addtoCounterY(int y){
        counterY += y;
        if ( counterY == dimUniverse.size())
            counterY = 1;
        else if ( counterY == 0 )
            counterY = dimUniverse.size()-1;
    }
    
    
    // get two dimensions and algorithm them and draw them on screen
    /*
Two Dimensional visualization 
        1.	We have Dim Y and Dim X 
        2.	Loop in dim Y 
        a.	If cell is dim 
        i.	Loop in dim X 
        ii.	Check if the cell in dim X has the selected Dim Y in its list of Dim
        b.	If cell is pure cell 
        i.	Loop in dim X 
        ii.	If the cell in dim x is dim 
        1.	If the cell in Y is in its cells
        iii.	If the cell in dim x is cell 
        1.	do nothing

    */
    
    public void drawTwoDimensions(){
        ArrayList<ArrayList<CoreCell>> twDim = new ArrayList<ArrayList<CoreCell>>();

        int yposX = 200;
        int yposY = 220;
        int marginY = 0;
        int marginX = 0;
        
        for ( CoreCell tmpCellY : tmpDimY.getCellsArrayListfromDim() ){
            int xposX = 200;
            int xposY = 220;
            // draw Y First Cell 
            oldFont = g2d.getFont();
            g2d.setFont(new Font("Arial", Font.PLAIN, 14));
            fontMetrics = g2d.getFontMetrics();
            strWidth = fontMetrics.stringWidth(tmpCellY.getCoreCellName());
            strHeight = fontMetrics.getHeight();
            // Draw Horizontal Meaning 
            g2d.setColor(Color.BLUE);
            g2d.fill3DRect(yposX -2 , yposY - strHeight +2 , strWidth + 4, strHeight+8, true);
            g2d.setColor(Color.WHITE);
            g2d.drawString(tmpCellY.getCoreCellName() , yposX , yposY  );
            marginY = strHeight + 20;
            marginX = strWidth + 20;
            xposY = yposY;
            yposY += marginY;
            
            if( tmpCellY.getIsDim()){   
                for ( CoreCell tmpCellX : tmpDimX.getCellsArrayListfromDim()){
                    if (tmpCellX.getCellDims().contains((Dimension)tmpCellY))
                    {
                        oldFont = g2d.getFont();
                        g2d.setFont(new Font("Arial", Font.PLAIN, 14));
                        fontMetrics = g2d.getFontMetrics();
                        strWidth = fontMetrics.stringWidth(tmpCellX.getCoreCellName());
                        strHeight = fontMetrics.getHeight();
                        // Draw Horizontal Meaning 
                        xposX += marginX;
                        g2d.setColor(Color.ORANGE);
                        g2d.fill3DRect(xposX -2 , xposY - strHeight +2 , strWidth + 4, strHeight+8, true);
                        g2d.setColor(Color.BLACK);
                        g2d.drawString(tmpCellX.getCoreCellName() , xposX , xposY  );
                        marginX = strWidth +20;
                        
                    }
                }
                
            } else {
                    for ( CoreCell tmpCellX : tmpDimX.getCellsArrayListfromDim()){
                        if ( tmpCellX.getIsDim() ){
                            Dimension tmpDimInner = (Dimension)tmpCellX;
                            if (tmpDimInner.getCellsArrayListfromDim().contains(tmpCellY)){
                                oldFont = g2d.getFont();
                                g2d.setFont(new Font("Arial", Font.PLAIN, 14));
                                fontMetrics = g2d.getFontMetrics();
                                strWidth = fontMetrics.stringWidth(tmpCellX.getCoreCellName());
                                strHeight = fontMetrics.getHeight();
                                // Draw Horizontal Meaning 
                                xposX += marginX;
                                g2d.setColor(Color.PINK);
                                g2d.fill3DRect(xposX -2 , xposY - strHeight +2 , strWidth + 4, strHeight+8, true);
                                g2d.setColor(Color.BLACK);
                                g2d.drawString(tmpCellX.getCoreCellName() , xposX , xposY  );
                                marginX = strWidth +20;
                            } else {
                                Dimension tmpdimme = (Dimension)tmpCellX;
                                if (tmpdimme.getCellsArrayListfromDim().contains(tmpCellY)){
                                    oldFont = g2d.getFont();
                                    g2d.setFont(new Font("Arial", Font.PLAIN, 14));
                                    fontMetrics = g2d.getFontMetrics();
                                    strWidth = fontMetrics.stringWidth(tmpCellX.getCoreCellName());
                                    strHeight = fontMetrics.getHeight();
                                    // Draw Horizontal Meaning 
                                    xposX += marginX;
                                    g2d.setColor(Color.RED);
                                    g2d.fill3DRect(xposX -2 , xposY - strHeight +2 , strWidth + 4, strHeight+8, true);
                                    g2d.setColor(Color.BLACK);
                                    g2d.drawString(tmpCellX.getCoreCellName() , xposX , xposY  );
                                    marginX = strWidth +20;
                                }
                            }
                        }
                    }
            }
            
            
        }
    }
}
