/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dimensional_Descendant;

import java.util.ArrayList;
import java.util.Arrays;




public class CreateDataDNAPaper {
    private ArrayList<CoreCell> Universe;
    private ArrayList<Dimension> dimUniverse;
    public CellsUniverse cells = new CellsUniverse();
    public DimsUniverse dims = new DimsUniverse();
    
    // Dimensions creation
    private Dimension StructureOfDNAPaper = new Dimension("Structure of DNA Paper");
    private Dimension TypeOfDocument = new Dimension("Type Of Document");
    private Dimension PublicationJournalName = new Dimension ("Journal of Publication");
    private Dimension PublicationYear = new Dimension("Year of Publication");
    private Dimension AuthorsOfDNAStructurePaper = new Dimension ("Authors of DNA Structure Paper");
    private Dimension Authors = new Dimension ("Authors");
    
    // Cell Creation
    private StringCell TypeIsPaper = new StringCell("Paper");
    private StringCell JournalNameNature = new StringCell("Nature");
    private StringCell PubYear1953 = new StringCell("PubYear953");
    private StringCell AuthorWatson = new StringCell("Watson");
    private StringCell AuthorCrick = new StringCell("Crick");
    
    
    CreateDataDNAPaper(){
       Universe = cells.getUniverseArrayList();
       dimUniverse = dims.getDimUniverseArrayList();
       
       
       // Add each cell to its mother dimension 
       TypeOfDocument.AddCell(TypeIsPaper);
       TypeIsPaper.setMotherDim(TypeOfDocument);
       
       PublicationJournalName.AddCell(JournalNameNature);
       JournalNameNature.setMotherDim(PublicationJournalName);
       
       PublicationYear.AddCell(PubYear1953);
       PubYear1953.setMotherDim(PublicationYear);
       
       Authors.AddCell(AuthorWatson);
       AuthorWatson.setMotherDim(Authors);
       
       Authors.AddCell(AuthorCrick);
       AuthorCrick.setMotherDim(Authors);
       
       
       
       // Adding cells to the dimension of "structure of DNA Paper"
       StructureOfDNAPaper.AddCell(TypeIsPaper);
       StructureOfDNAPaper.AddCell(JournalNameNature);
       StructureOfDNAPaper.AddCell(PubYear1953);
       StructureOfDNAPaper.AddCell(AuthorsOfDNAStructurePaper);
       
       // Adding Cells to AuthorsOfDNAStructurePaper Dimension
       AuthorsOfDNAStructurePaper.AddCell(AuthorWatson);
       AuthorsOfDNAStructurePaper.AddCell(AuthorCrick);
       
       for ( CoreCell tmpCell : Universe){
            System.out.println(tmpCell.getCoreCellID() + " " + tmpCell.getCoreCellName());
        }
        for ( Dimension tmpDim : dimUniverse){
            System.out.println(tmpDim.getDimID() + " " + tmpDim.getDimName());
        }
       
        
    }
           
    
    public ArrayList<CoreCell> getUniverse (){
        return Universe; 
    }
}
