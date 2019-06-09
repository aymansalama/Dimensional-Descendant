/*
The main aspect of the DDstructure implementation is to make the cell is the main navigational point. 
So by providing any cell, the navigation into the universe should be accessible. 
This class provides two methods to get the main two dimensions of each cells.  
 */

package Dimensional_Descendant;

import java.util.ArrayList;

/**
 *
 * @author ayman
 */
public class DisplayAlgorithm {
    
    /*
    o	The method takes the cell as input 
    o   If the cell is dimension, the method will return the set of cells in the dimension
    o	If the cell is not a dimension, the method will return the cells connected in the mother dimensions. 

    */
       public ArrayList<CoreCell> getHorizontalCellofCenteredCell (CoreCell tmpCoreCell){
           ArrayList<CoreCell> tmpArray = new ArrayList<CoreCell>();
           if (tmpCoreCell.getIsDim()){
               Dimension tmpDim = (Dimension) tmpCoreCell; 
               tmpArray = tmpDim.getCellsArrayListfromDim();
           } else if ( tmpCoreCell.getCoreCellID() == 0 ) {
               
           } else {
               Dimension tmpMotherDim = tmpCoreCell.getMotherDim();
               tmpArray = tmpMotherDim.getCellsArrayListfromDim();
           }
           return tmpArray; 
    }
    
       /*
       oThe method takes the cell as input 
       oIf the cell is a dimension 
            	The method will return the cells in the dimension
        oIf the cell is a dimension and its mother dimension is universe 
            The method will return the cells in the dimension
        oIf the cell is not a dimension
            The method will return the dimensions that the cell is connected to.
       */
    public ArrayList<CoreCell> getVerticalCellofCenteredCell (CoreCell tmpCoreCell){
        ArrayList<CoreCell> tmpArray = new ArrayList<CoreCell>();
        if (tmpCoreCell.getIsDim()){
            if ( tmpCoreCell.getMotherDim().getCoreCellID() != 1 ){
                Dimension tmpMotherDim = tmpCoreCell.getMotherDim();
                tmpArray = tmpMotherDim.getCellsArrayListfromDim();
            }else {
                tmpArray.addAll( tmpCoreCell.getCellDims());
            }
        } else {
            tmpArray.addAll( tmpCoreCell.getCellDims());
            //Dimension tmpMotherDim = tmpCoreCell.getMotherDim();
            //tmpArray = tmpMotherDim.getCellsArrayListfromDim();
        }
        return tmpArray;
   }
    
}
