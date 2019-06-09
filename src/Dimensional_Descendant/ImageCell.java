/*
This class is inherited from the CoreCell class. 
The new component in this class is the image content. 
All other coreCell class properties are inherited. 
The class contains methods to set and get the image content of the cell. 
Currently this class is not used. 
The current deployment only supports the string cell. 
However no major changes are needed for the image cell manipulation. 
 */

package Dimensional_Descendant;
import java.awt.image.BufferedImage;

/**
 *
 * @author ayman
 */
public class ImageCell extends CoreCell{

    /**
     *
     */
    public ImageCell (){
        setCellType("Image");
    }
    
}
