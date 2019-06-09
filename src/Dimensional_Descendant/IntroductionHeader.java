/*
The class main purpose is to draw the introduction header illustrated in figure 20 below. 
The class is drawing the icon and its dimensions for selection orders. 
The class is drawing the logo icon.
And finally the class is drawing two rectangles that shows the two main dimensions that each cells is selected. 
If the user selects a certain cell, there will be two rectangles in yellow and blue shows the details.
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
import java.awt.Window;
import javax.swing.ImageIcon;

/**
 *
 * @author ayman
 */
public class IntroductionHeader {
    private Graphics2D g2d;
    private float thikness; 
    private Stroke oldStroke; 
    private Color oldColor;
    private int windowW;
    private int widnowH;
    private int strWidth;
    private int strHeight;
    private FontMetrics fontMetrics;
    
    private Image refreshIcon;
    private Image logo;
    private Image editIcon;
    private Image listIcon;
    private Image recuIcon;
    
    private Rectangle imageRefreshRect;
    private Rectangle imageListRect;
    private Rectangle imageRecuRect;
    private Rectangle imageEditRect;
    
    public IntroductionHeader (Graphics2D g2d){
        this.g2d = g2d;
        windowW = g2d.getDeviceConfiguration().getBounds().width;
        widnowH = g2d.getDeviceConfiguration().getBounds().height;
        //bg = new ImageIcon("C:\\Test\\reload.png").getImage();
        refreshIcon = new ImageIcon("C:\\Test\\refresh.jpg").getImage();
        logo = new ImageIcon("C:\\Test\\logo.png").getImage();
        editIcon = new ImageIcon("C:\\Test\\edit.png").getImage();
        listIcon = new ImageIcon("C:\\Test\\list.jpg").getImage();
        recuIcon = new ImageIcon("C:\\Test\\dim.jpg").getImage();
        
    }
    
    /*
    o	The method draws all the icons. 
    o	The method is storing all the rectangle positions of the icons.
    */
    public void drawIntro(){
        imageListRect = new Rectangle();
        imageRecuRect = new Rectangle();
        imageEditRect = new Rectangle();
        imageRefreshRect = new Rectangle();
        thikness = 3;
        oldStroke = g2d.getStroke();
        oldColor = g2d.getColor();
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, windowW, 88);
        g2d.setColor(Color.BLUE);
        g2d.setStroke(new BasicStroke(thikness));
        
        g2d.drawLine(0,90,windowW,90);
        
        g2d.setStroke(oldStroke);
        g2d.setColor(oldColor);
        
        // Draw Main Logo
        g2d.drawImage(logo, 0, 0,null);

        // Draw refresh Icon
        imageRefreshRect.setBounds(windowW-refreshIcon.getWidth(null)-5,85 - refreshIcon.getHeight(null), refreshIcon.getWidth(null), refreshIcon.getHeight(null));
        g2d.drawImage(refreshIcon,windowW-refreshIcon.getWidth(null)-5,85 - refreshIcon.getHeight(null),null);
        
         // Draw two Dim List Icon
        imageListRect.setBounds(windowW-listIcon.getWidth(null)-5,5, listIcon.getWidth(null), listIcon.getHeight(null));
        g2d.drawImage(listIcon,windowW-listIcon.getWidth(null)-5,5,null);
        
        // Draw the Reucrssion Dimensional Icon
        imageRecuRect.setBounds(windowW-recuIcon.getWidth(null)-listIcon.getWidth(null)-15,5, recuIcon.getWidth(null), recuIcon.getHeight(null));
        g2d.drawImage(recuIcon,windowW-recuIcon.getWidth(null)-listIcon.getWidth(null)-15,5,null);
        
        // Draw the Edit Icon
        imageEditRect.setBounds(windowW-recuIcon.getWidth(null)-listIcon.getWidth(null)-editIcon.getWidth(null)-25,5, editIcon.getWidth(null), editIcon.getHeight(null));
        g2d.drawImage(editIcon,windowW-recuIcon.getWidth(null)-listIcon.getWidth(null)-editIcon.getWidth(null)-25,5,null);
        
    }
    

    /*
    o	the method takes the selected cell
    o	The method is drawing in the orange rectangle:
        	If the cell is dimension, it draws the cell name
        	If the cell is not dimension, it draws the mother dimension name
    */
    public void drawIntroDimTextH(CoreCell clickedCell){
        String dimNameIntroH = new String();
        g2d.setFont(new Font("Arial", Font.BOLD, 16));
        fontMetrics = g2d.getFontMetrics();
        if (clickedCell.getIsDim()){
            dimNameIntroH = "Dim: " + clickedCell.getCoreCellName();
        } else {
            dimNameIntroH = "Dim: " + clickedCell.getMotherDim().getCoreCellName();
            //System.out.println(" orange cell should be " + clickedCell.getMotherDim().getCoreCellName());
        }
        strWidth = fontMetrics.stringWidth(dimNameIntroH);
        strHeight = fontMetrics.getHeight();
        // Draw Horizontal Meaning 
        g2d.setColor(Color.ORANGE);
        g2d.fill3DRect((windowW/3) - 2, 70 - strHeight , strWidth + 4, strHeight+4, true);
        g2d.setColor(Color.BLACK);
        
        g2d.drawString(dimNameIntroH , windowW/3,70 );
        
        
    }
    
   /*
    o	The method takes the selected cell.
    o	The method is drawing in the blue rectangle
        If the cell is dimension
            •If the cell has no mother dimension
                oThe method will draw the cell name
            •If the cell has a mother dimension
                oThe method will draw the mother dimension name
        If the cell is not dimension
            •It will draw the cell name
    */
    public void drawIntroDimTextV(CoreCell clickedCell){
        String dimNameIntroV = new String();
        g2d.setFont(new Font("Arial", Font.BOLD, 16));
        fontMetrics = g2d.getFontMetrics();
        if (clickedCell.getIsDim()){
            if (clickedCell.getMotherDim().getCoreCellID() == 0){
                dimNameIntroV = "Dims conn to Cell: " + clickedCell.getCoreCellName();
            } else {
                dimNameIntroV = "Dim: " + clickedCell.getMotherDim().getCoreCellName();
            }
            
        } else {
            dimNameIntroV = "Dims conn to Cell: " + clickedCell.getCoreCellName();
        }
        strWidth = fontMetrics.stringWidth(dimNameIntroV);
        strHeight = fontMetrics.getHeight();
        // Draw Vertical meaning
        g2d.setColor(Color.BLUE);
        g2d.fill3DRect(((windowW*2)/3) - 2, 70 - strHeight , strWidth + 4, strHeight+4, true);
        g2d.setColor(Color.WHITE);
        g2d.drawString(dimNameIntroV , ((windowW*2)/3),70 );
    }
        
    public Rectangle getListImageRect(){
        return imageListRect;
    }
    public Rectangle getRecuDimImageRect(){
        return imageRecuRect;
    }
    public Rectangle getRefreshImageRect(){
        return imageRefreshRect;
    }
    public Rectangle getEditImageRect(){
        return imageEditRect;
    }
}
