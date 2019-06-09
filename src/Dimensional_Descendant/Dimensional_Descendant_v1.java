/*
 * This is the main function. which calls only the GUI to be created.
 */

package Dimensional_Descendant;

import java.awt.Graphics2D;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Ayman Salama
 */
public class Dimensional_Descendant_v1  {

    /**
     *
     * Universes initialization 
     */
    public CellsUniverse cells;
    public DimsUniverse dimensions;
    public static ArrayList<CoreCell> Universe;
    // test 
    private String mess = "";
    
    
    public static void main(String[] args) {
    
      
        
       // CellEditor addCell = new CellEditor(cells, dimensions);
       // addCell.setVisible(true);
        MainScreen UniverseWindow = new MainScreen();        
        UniverseWindow.run();

    }
}
    
    
    