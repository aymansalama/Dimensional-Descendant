/*
The core cell class is the core class for the Dimensional Descendant structure.
This class is the core type of the cells and the dimensions. 
All cell types are inherited from this class. 
The dimension class is also inherited from this class. 
This inheritance confirms the DDstructure where the dimension is a cell. 
The class contains simple get and set methods. 
The class is abstract so no entity can create an instance from it. 
The description of each element in the class is described below: 
•	coreCellID
    o This is the ID of the cell which is unique
    o	The ID is used for the identification of the cell or the dimension 
•	coreCellName
    o	Each cell has a name that could be used for elaboration
•	serverIP
    o	This is a part of the cell identification for future use.
    o	The identification of the cell will use the server IP when different cells are in different servers.
    o	It is used for global cell identification.
•	Slice
    o	This is the slice number on the server which contains the cell.
    o	It is used for global cell identification.
•	cellType
    o	This is a string value which shows the type of the cell.
    o	The type of the cell could be string, image, video, etc. 
    o	The current system support the string type only.
•	Posward
    o	It is used only in case the dimension is ordered set.
    o	This field stores the cell ID of the connected cell in the positive direction
•	Negward
    o	It is used only in case the dimension is ordered set.
    o	This field stores the cell ID of the connected cell in the negative direction
•	cellDims
    o	It is an arraylist which contains a pointer for all the dimensions that this cell is connected to. 
•	isDim
    o	This is a Boolean type that illustrate if this cell is dimension or not.
•	motherDim
    o	Any cell must be connected to a mother dimension which contains its type. 
    o	Like the cell color RED must be connected to mother dimension “Color”
•	Universe
    o	This is an array list which contains the list of all cells created in the system. 
•	globalCellCounter
    o	This counter is used to illustrate the count number of this cell in the universe. 
•	The constructor method 
    o	The constructor create the cell
    o	Adding it to the universe
    o	Set the mother dimension  

 */

package Dimensional_Descendant;

import java.util.ArrayList;

/**
 *
 * @author ayman
 */
abstract public class CoreCell {
    private static ArrayList<CoreCell> Universe = new ArrayList<CoreCell>(); 
    private static int globalCellCounter = 0; 
    private int coreCellID;
    private String coreCellName;
    private String serverIP;
    private String slice;
    private String cellType; 
    private int posward; 
    private int negward;
    private ArrayList<Dimension> cellDims;
    private boolean isDim; 
    private Dimension motherDim;
    
    // Constructor

    public CoreCell (){
        cellDims = new ArrayList<Dimension>();
        //dimOrder = 0; 
        Universe.add(this);
        setIsDim(false);
        //globalCellCounter++;
        //coreCellID = globalCellCounter; 
        coreCellID = Universe.indexOf(this);
        cellType = "Default";
        coreCellName = cellType;
        if ( coreCellID == 0 ){
            coreCellName = "Mother Cell";
        }
        if (coreCellID != 0){
            motherDim = (Dimension) Universe.get(1);
        }
    }
    
    // get the index of the cell in the universe
    public int getIndexCellFromUnivrse(CoreCell tmpCell){
        return Universe.indexOf(tmpCell);
    }
    
    public ArrayList getUniverseArrayList(){
        return Universe; 
    }
    
    //get the length of the Universe 
    public int getLengthUnvierse(){
        return Universe.size();
    }
    
    
    
    //==========================================================================
    //Adding cell to requested dimension

    /**
     *
     * @param dim
     * @return
     */
        public boolean AddToDimension (Dimension tmpDim){
        // Adding the requested dimensions to the list of dimensions in the cell
        cellDims.add(tmpDim);
       // System.out.println("Iam in core cell and i am storing" + dimID);
        //dimOrder++; 
        return true;
        }
    
    //==========================================================================
    //Get the dimensions that the cells are attached to

    /**
     *
     * @return
     */
        /*public int[] getCellDims (){
            int [] dimArray = new int[cellDims.size()];
            for (int i=0;i<cellDims.size();i++){
                dimArray[i] = cellDims.get(i);
                System.out.println("Iam in core cell and i am extracting " + dimArray[i]);
            }
            //cellDims.toArray(dimArray);
            return dimArray; 
        }*/
    public ArrayList<Dimension> getCellDims (){
           return cellDims; 
        }
    
    //==========================================================================
    //Get the cell ID

    /**
     *
     * @return
     */
        public int getCoreCellID (){
            return coreCellID;
        }
    
    //==========================================================================
    //set Direction

    /**
     *
     * @param cellPosward
     * @return
     */
        public boolean setPosward (int cellPosward){
        posward = cellPosward;
        return true;
    }

    /**
     *
     * @param cellNegward
     * @return
     */
    public boolean setNegward (int cellNegward){
        negward = cellNegward;
        return true; 
    }
    
    //==========================================================================
    //get Direction

    /**
     *
     * @return
     */
        public int getPosward (){
        return posward;
    }

    /**
     *
     * @return
     */
    public int getNegward (){
        return negward;
    }
    
    //==========================================================================
    // Set the type of the cell. should not be used in the main

    /**
     *
     * @param mytype
     * @return
     */
        public boolean setCellType (String mytype){
        cellType = mytype; 
        return true; 
    }
    
    //==========================================================================
    // get the type of the cell.

    /**
     *
     * @return
     */
        public String getCellType (){
        return cellType; 
    }
        
    //==========================================================================
    /**
     *
     * Set is Dimension parameter 
     */
        public void setIsDim (boolean isDim){
            this.isDim = isDim; 
    }
        
    //==========================================================================
    /**
     *
     * get is Dimension parameter 
     */
        public boolean getIsDim (){
            return isDim; 
    }
        
    //==========================================================================
    /**
     *
     * set Core Cell Name parameter 
     */
        public void setCoreCellName (String coreCellName){
            this.coreCellName = coreCellName; 
    }
        
    //==========================================================================
    /**
     *
     * get Core Cell Name parameter 
     */
        public String getCoreCellName (){
            return coreCellName; 
    }
    //==========================================================================
    /**
     *
     * set Mother Dimension ID parameter 
     */
        public void setMotherDim (Dimension motherDim){
            this.motherDim = motherDim;
    }
        
    //==========================================================================
    /**
     *
     * get Mother Dimension ID parameter 
     */
        public Dimension getMotherDim (){
            return motherDim;
    }
}
