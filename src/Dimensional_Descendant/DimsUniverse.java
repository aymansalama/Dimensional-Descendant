/*
This Dimensions universe class is an array list of all dimensions that exists in the universe.
The class contains a series of set and get methods for the dimensions in the universe. 
The class also implements some methods to add a dimension to the universe or remove another. 
 */

package Dimensional_Descendant;

import java.util.ArrayList;

/**
 *
 * @author ayman
 */
public class DimsUniverse extends Dimension{
    private ArrayList<Dimension> DimensionsUniverse;

    /**
     *
     */
    public DimsUniverse (){
        DimensionsUniverse = new ArrayList<Dimension>(); 
    }
    
    /**
     *	The method is used to add a dimensions to the array list of the universe.
     */
    public int addDimToUniverse (Dimension theDim){
        DimensionsUniverse.add(theDim);
        return DimensionsUniverse.indexOf(theDim); 
    }
    
    /**
     *	The method is used to remove a Dimension from the universe
     */
    public boolean removeDimFromUniverse (Dimension theDim){
        return (DimensionsUniverse.remove(theDim));
    }
    
    /**
     *	The method is used to remove the dimension from universe given the index of the cell.
     */
    public Dimension removeDimFromUniverseByIndex (int theDimIndex){
        return (DimensionsUniverse.remove(theDimIndex));
    }
    
    /**
     *o	The method is used to remove all dimensions from the universe.
     */
    public boolean destroyDimsUniverse (){
        DimensionsUniverse.clear();
        return true;
    }
    
    /*
    *o	The method is used to get the dimension given its index in the universe.
    */
    public Dimension getDimByIndexFromUniverse(int theDimIndex){
        return DimensionsUniverse.get(theDimIndex);
    }
    
    /*
    *o	The method is used to get array of all dimensions’ name.
    */
    public String[] getDimsName(){
        Dimension [] dimArray = new Dimension[DimensionsUniverse.size()];
        DimensionsUniverse.toArray(dimArray);
        String [] dimNameArray = new String[dimArray.length];
        for (int i=0 ; i < dimArray.length; i++)
            dimNameArray[i] = dimArray[i].getDimName();
        return dimNameArray; 
        
    }
    
    /*
    *o	The method is used to get the dimension name given the dimensions ID. 
    */
    public String getDimNameByID(int dimID){
        return DimensionsUniverse.get(dimID).getDimName();
    }
} 
