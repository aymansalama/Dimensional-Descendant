    /*
The main rule of the DDstructure is that “The dimension is a cell”. 
According to this rule, the dimension class is inherited from the cell. 
The Dimension mostly would represent a semantic meaning in the data structure. 
All the contents of the CoreCell class are inherited in this class. 
Below are the main additional contents in the class. 
•	dimID
    o	This is the dimensional ID which different than the cell ID
    o	The dimensional ID is the ID of the dimension in the universe dimension array list 
•	dimName
    o	This is the name of the dimension which could be used as the cell name as well.
•	cellsInDimesion
    o	This is an array list that contains a pointer for all cells that exist in the dimension 
•	cellOrder
    o	During the process of adding any cell to a dimension, this attribute is used to present the cell order in the dimension.
    o	This attribute is only used when the order dimensions set is addressed.
•	DimUniverse
    o	This is an array list that contains all the dimensions
•	globalDimCounter
    o	This counter present the count number of the dimension in the dimension universe. 

 */

package Dimensional_Descendant;

import java.util.ArrayList;

/**
 *
 * @author ayman
 */
public class Dimension extends CoreCell{
    private static ArrayList<Dimension> DimUniverse = new ArrayList<Dimension>(); 
    private static int globalDimCounter = 0; 
    private int dimID;
    private String dimName;
    private ArrayList<CoreCell> cellsInDimesion;
    private int cellOrder;

    /**
     * o Add the dimension to the dimension universe. 
       o Set the name of the dimension and the Boolean variable of isDim
     */
    public Dimension (){
        //globalDimCounter++;
        //dimID = globalDimCounter;
        cellsInDimesion = new ArrayList<CoreCell>();
        this.setCellType("Dimension");
        this.dimName="Empty";
        setIsDim(true);
        DimUniverse.add(this);
        dimID = DimUniverse.indexOf(this);
        setCoreCellName("Dimension");
        if ( dimID == 0 ){
            dimName = "Mother Dimension";
        }
    }
    
        public Dimension (String dimName){
            this();
            this.dimName = dimName;
            setCoreCellName(dimName);
    }
    
    // Adding Cell to Dimension. It is called by the cell itself no in the main.

    /**
     *
     * o This method is used to add cell to any given dimension.
       o The method adds the cell to the array list of the cells in the dimensions.
     */
    public int AddCell (CoreCell tmpCoreCell){
        cellsInDimesion.add(tmpCoreCell);
        tmpCoreCell.AddToDimension(this);
        cellOrder=cellsInDimesion.indexOf(tmpCoreCell.getCoreCellID()); 
        return cellOrder; 
    }
    
       /******** Redundant 
        // fill the dimension from a list with int 
    public int AddArrayCoreCells (CoreCell[] tmpArrayCells){
        for (int i = 0 ; i < tmpArrayCells.length ; i++){
            cellsInDimesion.add(tmpArrayCells[i]);
            cellOrder=cellsInDimesion.indexOf(tmpArrayCells[i]); 
        }
        return cellOrder;
    }*/
    
    /*
    o	This method enables the user to add array list of cells to the dimensions.
    o	The method returns the last added cell’s order in the dimension.
    */
    public int AddArrayCells (StringCell[] tmpArrayCells){
        for (StringCell tmpArrayCell : tmpArrayCells) {
           // System.out.println(" cell insertion ID is " + tmpArrayCell.getCoreCellID()+ " content is " + tmpArrayCell.getCellContent());
            cellsInDimesion.add(tmpArrayCell);
            cellOrder = cellsInDimesion.indexOf(tmpArrayCell.getCoreCellID()); 
        }
        return cellOrder;
    }
    // Return Dimension ID

    /**
     *
     * @return
     */
        public int getDimID(){
        return dimID; 
    }
    
    // Return the number of elements in the Dimension

    /**
     *
     * @return
     */
        public int getDimSize(){
        return cellsInDimesion.size();
        }
        
        public boolean setDimName (String name){
            dimName = name; 
            return true;
        }
        
        
    public String getDimName (){
        return dimName;
    }
    
    // get the dimension list
    public ArrayList<CoreCell> getCellsArrayListfromDim(){
        return cellsInDimesion;
    }
    
    // print the dimensions and return array of string of content of dimension
    /*
    o	This method is used to return string array 
    o	The string array will contain the content of all cells in the given dimension
        	String content if the cell is String cell 
        	Or the name of the dimension if the cell is a dimension “dimension in dimension”
    */
    public String[] getDimensionsCellContentString(){
        ArrayList<CoreCell> Universe = this.getUniverseArrayList();
        String[] dimStrings = new String[cellsInDimesion.size()];
        for (CoreCell tmpCell : cellsInDimesion){
           // System.out.println(tmp);
         //   StringCell test = (StringCell)Universe.get(tmp);
           // System.out.println(" test +++++++++ "+ test.getCellContent());
            //CoreCell tmpCell = Universe.get(tmp);
            if (tmpCell instanceof StringCell){
                StringCell tmpString = (StringCell)tmpCell;
                dimStrings[cellsInDimesion.indexOf(tmpCell)] = tmpString.getCellContent();
                System.out.println("Cell ID is "+ tmpCell.getCoreCellID() + " Cell Content is "+ tmpString.getCellContent());
            }
            if (tmpCell instanceof Dimension){
                Dimension tmpString = (Dimension)tmpCell;
                dimStrings[cellsInDimesion.indexOf(tmpCell)] = tmpString.getDimName();
                System.out.println("Cell ID is "+ tmpCell.getCoreCellID() + " Cell Content is "+ tmpString.getDimName());
            }
        }
        return dimStrings;
    }
    
        // get the index of the cell in the universe
    public int getIndexDimFromUnivrse(Dimension tmpDim){
        return DimUniverse.indexOf(tmpDim);
    }
    
    public ArrayList<Dimension> getDimUniverseArrayList(){
        return DimUniverse; 
    }
    
    //get the length of the Universe 
    public int getLengthDimUnvierse(){
        return DimUniverse.size();
    }
}


