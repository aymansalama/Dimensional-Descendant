/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dimensional_Descendant;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTextField;
/**
 *
 * @author ayman
 */
public class SubmitDataNewString {
       
    private CellsUniverse cells;
    private DimsUniverse dimensions;
    private StringCell newString; 


    public SubmitDataNewString (CellsUniverse cellsTmp
            , DimsUniverse dimensionsTmp, StringCell newStringTmp){
        cells = cellsTmp;
        dimensions = dimensionsTmp; 
        newString = newStringTmp;
        
    }
    
    public boolean collectDataFillCell (ArrayList<JTextField> labels, 
            JButton submitDataStringCellButton , 
            JButton addStringCellButton, JList cellDimsNamesList){
        
        // Set Cell Content
        labels.get(1).setEditable(false);
        newString.setCellContent(labels.get(1).getText());
        
        // Cell Type
        labels.get(2).setText(newString.getCellType());
        
        // Cell Passowrd
        labels.get(3).setEditable(false);
        newString.setPosward(Integer.parseInt(labels.get(3).getText()));
        
        // Cell Negward
        labels.get(4).setEditable(false);
        newString.setNegward(Integer.parseInt(labels.get(4).getText()));
        
        //Cell Dimensions
        cellDimsNamesList.setEnabled(false);
        String [] selectedDims = new String[cellDimsNamesList.getSelectedIndex()];
        cellDimsNamesList.getSelectedValuesList().toArray(selectedDims);
        //System.out.println(" the array of selected are + " + selectedDims);
        for (int i =0 ; i<cellDimsNamesList.getSelectedIndices().length; i++){
            newString.AddToDimension(dimensions.getDimByIndexFromUniverse(cellDimsNamesList.getSelectedIndices()[i]));
            //System.out.println(" chosed element number is " + cellDimsNamesList.getSelectedIndices()[i]);
        }
        // Handling GUI Buttons
        submitDataStringCellButton.setEnabled(false);
        addStringCellButton.setEnabled(true);
        
        //cellDimsNamesList.setEnabled(true);
        
        return true;
    }
}
