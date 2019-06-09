/*
 * Creation of empty string cell
 */

package Dimensional_Descendant;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTextField;


/**
 *
 * @author ayman
 */
public class CreateEmptyStringCell {
    
    
    private StringCell newString;
    private CellsUniverse cells;
    private DimsUniverse dimensions;


    public CreateEmptyStringCell (CellsUniverse cellsTmp, DimsUniverse dimensionsTmp){
        newString = new StringCell();
        cells = cellsTmp;
        dimensions = dimensionsTmp; 
        
        cells.addCelltoUniverse(newString);
        //System.out.println("cell ID "+ Integer.toString(newString.getCellID()) );
        //System.out.println("universe  size"+ cells.getCellsUniverseSize() );
    }
    
    public StringCell changeLayoutFillText (ArrayList<JTextField> labels, 
            JButton submitDataStringCellButton , 
            JButton addStringCellButton, JList cellDimsNamesList){
        String[] dimsName = dimensions.getDimsName();
        //Cell ID
        labels.get(0).setText(Integer.toString(newString.getCoreCellID()));
        // Cell Content
        labels.get(1).setEditable(true);
        labels.get(1).setText("Default");
        // Cell Type
        labels.get(2).setText(newString.getCellType());
        // Cell Passowrd
        labels.get(3).setEditable(true);
        labels.get(3).setText("0");
        // Cell Negward
        labels.get(4).setEditable(true);
        labels.get(4).setText("0");
        // Cell Dimensions
        cellDimsNamesList.setEnabled(true);
        cellDimsNamesList.setSelectedIndex(0);

        // Handling GUI
        submitDataStringCellButton.setEnabled(true);
        addStringCellButton.setEnabled(false);
       // cells.addCelltoUniverse(newString);
        
        return newString;
    }
}
