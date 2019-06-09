/*
This class is inherited from the CoreCell class. 
The new component in this class is the string content.
All other coreCell class properties are inherited. 
The class contains methods to set and get the string content of the cell. 
 */

package Dimensional_Descendant;

/**
 *
 * @author ayman
 */
public class StringCell extends CoreCell {
    private String content;

    /**
     * Constructors 
     */
    public StringCell(){
        setCellType("String");
        this.content = "Empty";
        setCoreCellName("String");
    }
    
    public StringCell(String content){
        this();
        this.content = content; 
        setCoreCellName(content);
    }
    
    // Set the content of the string Object

    /**
     *
     * @param str
     * @return
     */
        public boolean setCellContent(String str){
        content = str; 
        return true; 
    }
    
    /**
     *
     * @return
     */
    public String getCellContent(){
        return content; 
    }
}
