/*
 * the class basicsly contains an element that contains core cell and rectangle
 * this rect contains the coordination of it on the screen
 */

package Dimensional_Descendant;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

/**
 *
 * @author ayman
 */
public class ScreenObjects {
    private CoreCell cell; 
    private Rectangle cellRect ; 
    private static ArrayList<ScreenObjects> allObjects = new ArrayList<ScreenObjects>(); 
    private Color strignColor = Color.BLACK; 
    private Color rectColor = Color.WHITE; 
    private float thikness = 2; 
    private Font strFont = new Font("Arial", Font.PLAIN, 12);
    
    public ScreenObjects (){}
    public ScreenObjects (CoreCell cell, Rectangle cellRect) {
        this.cell = cell ; 
        this.cellRect = cellRect; 
        allObjects.add(this);
    }
    
    public ArrayList<ScreenObjects> getAllScreenObjects(){
        return allObjects;
    }
    
    public Rectangle getRectangle(){
        return cellRect;
    }
    
    public CoreCell getCoreCell(){
        return cell; 
    }
    
    // take point , and return a cell 
    public CoreCell getCellByPoint(Point p){
        for (ScreenObjects tmpObject : allObjects){
            Rectangle tmpRect = tmpObject.getRectangle();
            if ( tmpRect.contains(p))
                return tmpObject.getCoreCell(); 
        }
        return null; 
        
    }
    
    public void setRectangle(Rectangle cellRect){
        this.cellRect = cellRect;
    }
    
    public Color getStringColor(){
        return this.strignColor; 
    }
    
    public Color getRectColor(){
        return this.rectColor;
    }
    
    public void setStringColor(Color stringColor){
        this.strignColor = stringColor;
    }
    
    public void setRectColor(Color rectColor){
        this.rectColor = rectColor; 
    }
    
    public void setThiknessRect(float thikness){
        this.thikness = thikness;
    }
    
    public float getThiknessRect(){
        return this.thikness;
    }
    public Font getStrFont(){
        return strFont;
    }
    public void setStrFont(Font strFont){
        this.strFont = strFont; 
    }
}
