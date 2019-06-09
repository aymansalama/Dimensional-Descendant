/*
 *This cells universe class is an array list of all cells that exists in the universe. 
 *The class contains a series of set and get methods for the cells in the universe. 
 *The class also implements some methods to add a cell to the universe or remove another. 
 */

package Dimensional_Descendant;

import java.util.ArrayList;

/**
 *
 * @author ayman
 */
public class CellsUniverse extends CoreCell{
    
    private ArrayList<CoreCell> cellsUniverse;

    public CellsUniverse (){
        cellsUniverse = new ArrayList<CoreCell>(); 
    }
    
    /**
     *	The method is used to add a cell to the array list of the universe
     */
    public int addCelltoUniverse (CoreCell theCell){
        cellsUniverse.add(theCell);
        return cellsUniverse.indexOf(theCell); 
    }
    
    /**
     *	The method is used to remove a cell from the universe
     */
    public boolean removeCellFromUniverse (CoreCell theCell){
        return (cellsUniverse.remove(theCell));
    }
    
    /**
     *	The method is used to remove the cell from universe given the index of the cell.
     */
    public CoreCell removeCellFromUniverseByIndex (int theCellIndex){
        return (cellsUniverse.remove(theCellIndex));
    }
    
    /**
     *	The method is used to remove all cells from the universe.
     */
    public boolean destroyCellUniverse (){
        cellsUniverse.clear();
        return true;
    }
    
    /*
    *	The method is used to get size of the universe. 
    */
    public int getCellsUniverseSize(){
        return cellsUniverse.size();
    }
    
    /*
    *	The method is used to get the last cell in the Universe.
    */
    public CoreCell getLastCellInUniverse (){
        return cellsUniverse.get(cellsUniverse.size()-1);
    }
    
    /*
    *	The method is used to get the cell given its index in the universe.
    */
    public CoreCell getCellOfIndex (int i){
        return cellsUniverse.get(i);
    }
    /*public CoreCell getCellFromUniverse (int cellIndex){
         CoreCell temp =  cellsUniverse.get(cellIndex);
         
    }*/
    
    
}
