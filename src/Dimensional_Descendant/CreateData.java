/*
This class is built mainly to build a test sample data for demonstration purpose of the DDstructure. 
The constructor of the class contains series of arrays of data. 
The constructor is calling different methods to create the links between the cells and the dimensions. 
The class contains printing methods for data demonstration purpose. 
Below is the sample data that was used in the example. 

Students	Student Ayman	Student John	Student Ahmed	Student Li	Student Mona
Fname	Ayman	John	Ahmed	Li	Mona
Sname	Salama	Peter	Ibrahim	Wu	Hafiz
Birth Date	1984	1990	1985	1993	2000
Faculty	Science	Engineering	Social Sciences	Arts	Science
Country	Egypt	England	Egypt	Malaysia	Egypt

Schools	Science	Engineering	Social Sciences	Arts
School Location	BLOCK B	BLOCK C	BLOCK E	BLOCK E
Head of School	Prof. Kal	Prof.Andrew	Prof.Li	Prof.Mohamed
Students of	Science School	Engineering School	Social Sciences School	Arts School


 */

package Dimensional_Descendant;

//import static Dimensional_Recursion.Dimensional_Recursion_v1.Universe;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author ayman
 */
public class CreateData {
    public CellsUniverse cells = new CellsUniverse();
    public DimsUniverse dims = new DimsUniverse();
    
        Dimension StudentsDim = new Dimension("Students");
        Dimension BirthDateDim = new Dimension("Birth Date");
        Dimension FNameDim = new Dimension("First Name");
        Dimension SNameDim = new Dimension("Second Name");
        //Dimension SchoolDim = new Dimension("School Name");
        Dimension CountryDim = new Dimension("Home Country");
         // creating students dimension
        Dimension StudentAymanDim = new Dimension("Student Ayman");
        Dimension StudentJohnDim = new Dimension("Student John");
        Dimension StudentAhmedDim = new Dimension("Student Ahmed");
        Dimension StudentLiDim = new Dimension("Student Li");
        Dimension StudentMonaDim = new Dimension("Student Mona");
        // Create School Dimensions
        Dimension schoolsDim = new Dimension("Schools");
        Dimension sciSchoolDim = new Dimension ("School of Science");
        Dimension engSchoolDim = new Dimension ("School of Engineering");
        Dimension socSciSchoolDim = new Dimension ("School of Social Sciences");
        Dimension artsSchoolDim = new Dimension ("School of Arts");
        // Create School parameters dimensions
        Dimension schoolLocationDim = new Dimension("School Location");
        Dimension schoolHeadDim = new Dimension("Head of School");
        Dimension schoolStudentsDim = new Dimension("School Students");
        // create school students dimensions
        Dimension stdSchoolScienceDim = new Dimension("Student of School of Science");
        Dimension stdSchoolEngDim = new Dimension("Student of School of Engineering");
        Dimension stdSchoolSocSciDim = new Dimension("Student of School of Social Science");
        Dimension stdSchoolArtsDim = new Dimension("Student of School of Arts");
        
        StringCell fnameCells [] = {
            new StringCell("Ayman"),
            new StringCell("John"),
            new StringCell("Ahmed"),
            new StringCell("Li"),
            new StringCell("Mona"),
        };
        StringCell snameCells [] = {
            new StringCell("Salama"),
            new StringCell("Peter"),
            new StringCell("Ibrahim"),
            new StringCell("Wu"),
            new StringCell("Hafiz"),
        };
        StringCell bdCells [] = {
            new StringCell("1984"),
            new StringCell("1990"),
            new StringCell("1985"),
            new StringCell("1993"),
            new StringCell("2000"),
        };
        /*StringCell schoolCells [] = {
            new StringCell("Science"),
            new StringCell("Engineering"),
            new StringCell("Social Sciences"),
            new StringCell("Arts"),
        };*/
        StringCell countryCells [] = {
            new StringCell("Egypt"),
            new StringCell("England"),
            new StringCell("Malaysia"),
        };
        StringCell schoolLocationCells [] = {
            new StringCell("BLOCK B"),
            new StringCell("BLOCK C"),
            new StringCell("BLOCK E")
        };
        StringCell headOfSchoolCells [] = {
            new StringCell("Prof. Kal"),
            new StringCell("Prof.Andrew"),
            new StringCell("Prof.Li"),
            new StringCell("Prof.Mohamed")
        };
    private ArrayList<CoreCell> Universe;
    private ArrayList<Dimension> dimUniverse;
        
    public CreateData(){
         
       Universe = cells.getUniverseArrayList();
       dimUniverse = dims.getDimUniverseArrayList();
       // DimsUniverse dimensions = new DimsUniverse();
        
        //cells.addCelltoUniverse(cells);

        /*dimensions.addDimToUniverse(StudentsDim);
        dimensions.addDimToUniverse(BirthDateDim);
        dimensions.addDimToUniverse(FNameDim);
        dimensions.addDimToUniverse(SNameDim);
        dimensions.addDimToUniverse(SchoolDim);
        dimensions.addDimToUniverse(CountryDim);*/
        
       
        
        //Students dimensions and its cells 
        StudentsDim.AddCell(StudentAymanDim);
        StudentAymanDim.setMotherDim(StudentsDim);
        
        StudentsDim.AddCell(StudentJohnDim);
        StudentJohnDim.setMotherDim(StudentsDim);
        
        StudentsDim.AddCell(StudentAhmedDim);
        StudentAhmedDim.setMotherDim(StudentsDim);
        
        StudentsDim.AddCell(StudentLiDim);
        StudentLiDim.setMotherDim(StudentsDim);
        
        StudentsDim.AddCell(StudentMonaDim);
        StudentMonaDim.setMotherDim(StudentsDim);
        
        // FName Dimension and cells 
        FNameDim.AddArrayCells(fnameCells);
        for (StringCell tmpStringCell : fnameCells){
            tmpStringCell.setMotherDim(FNameDim);
        }
       // FNameDim.printGetDimensionsCellContentString();
        
        // SName Dimension and cells 
        SNameDim.AddArrayCells(snameCells);
        for (StringCell tmpStringCell : snameCells){
            tmpStringCell.setMotherDim(SNameDim);
        }
        
        // Birth data dimensions and cells 
        BirthDateDim.AddArrayCells(bdCells);
        for (StringCell tmpStringCell : bdCells){
            tmpStringCell.setMotherDim(BirthDateDim);
        }

        // School dimensions and cells 
        /*SchoolDim.AddArrayCells(schoolCells);
        for (StringCell tmpStringCell : schoolCells){
            tmpStringCell.setMotherDim(SchoolDim);
        }*/
        
        // Country dimensions and cells 
        CountryDim.AddArrayCells(countryCells);
        for (StringCell tmpStringCell : countryCells){
            tmpStringCell.setMotherDim(CountryDim);
        }
        
        // Filling Ayman Dimension
        StudentAymanDim.AddCell(fnameCells[0]);
        StudentAymanDim.AddCell(snameCells[0]);
        StudentAymanDim.AddCell(bdCells[0]);
        StudentAymanDim.AddCell(this.sciSchoolDim);
        StudentAymanDim.AddCell(countryCells[0]);
        
        // Filling John Dimension
        StudentJohnDim.AddCell(fnameCells[1]);
        StudentJohnDim.AddCell(snameCells[1]);
        StudentJohnDim.AddCell(bdCells[1]);
        StudentJohnDim.AddCell(this.engSchoolDim);
        StudentJohnDim.AddCell(countryCells[1]);
        
        // Filling Ahmed Dimension
        StudentAhmedDim.AddCell(fnameCells[2]);
        StudentAhmedDim.AddCell(snameCells[2]);
        StudentAhmedDim.AddCell(bdCells[2]);
        StudentAhmedDim.AddCell(this.socSciSchoolDim);
        StudentAhmedDim.AddCell(countryCells[0]);
        
        // Filling Li Dimension
        StudentLiDim.AddCell(fnameCells[3]);
        StudentLiDim.AddCell(snameCells[3]);
        StudentLiDim.AddCell(bdCells[3]);
        StudentLiDim.AddCell(this.artsSchoolDim);
        StudentLiDim.AddCell(countryCells[2]);
        
        // Filling Mona Dimension
        StudentMonaDim.AddCell(fnameCells[4]);
        StudentMonaDim.AddCell(snameCells[4]);
        StudentMonaDim.AddCell(bdCells[4]);
        StudentMonaDim.AddCell(this.sciSchoolDim);
        StudentMonaDim.AddCell(countryCells[0]);
        
        // adding the dimensions of school to the schoolDimension
        schoolsDim.AddCell(this.sciSchoolDim);
        schoolsDim.AddCell(this.engSchoolDim);
        schoolsDim.AddCell(this.socSciSchoolDim);
        schoolsDim.AddCell(this.artsSchoolDim);
        this.sciSchoolDim.setMotherDim(this.schoolsDim);
        this.engSchoolDim.setMotherDim(this.schoolsDim);
        this.socSciSchoolDim.setMotherDim(this.schoolsDim);
        this.artsSchoolDim.setMotherDim(this.schoolsDim);
        
        // Adding the name of schools to the schoolNameDim 
        this.schoolLocationDim.AddArrayCells(this.schoolLocationCells);
        for ( StringCell tmpStr : this.schoolLocationCells)
            tmpStr.setMotherDim(this.schoolLocationDim);
        
        // Adding the name of head of school to the dim of schoolHeadDim
        this.schoolHeadDim.AddArrayCells(this.headOfSchoolCells);
        for ( StringCell tmpStr : this.headOfSchoolCells)
            tmpStr.setMotherDim(this.schoolHeadDim);
        
        // Adding the school students dimension to the dimension of sudents. 
        this.schoolStudentsDim.AddCell(this.stdSchoolArtsDim);
        this.stdSchoolArtsDim.setMotherDim(schoolStudentsDim);
        
        this.schoolStudentsDim.AddCell(this.stdSchoolEngDim);
        this.stdSchoolEngDim.setMotherDim(schoolStudentsDim);
        
        this.schoolStudentsDim.AddCell(this.stdSchoolScienceDim);
        this.stdSchoolScienceDim.setMotherDim(schoolStudentsDim);
        
        this.schoolStudentsDim.AddCell(this.stdSchoolSocSciDim);
        this.stdSchoolSocSciDim.setMotherDim(schoolStudentsDim);
        
        // put students in school students dimensions 
        stdSchoolArtsDim.AddCell(this.StudentLiDim);
        stdSchoolEngDim.AddCell(this.StudentJohnDim);
        stdSchoolScienceDim.AddCell(this.StudentAymanDim);
        stdSchoolScienceDim.AddCell(this.StudentMonaDim);
        stdSchoolSocSciDim.AddCell(this.StudentAhmedDim);
        
        // Fill School Dimensions
        this.sciSchoolDim.AddCell(this.schoolLocationCells[0]);
        this.sciSchoolDim.AddCell(this.headOfSchoolCells[0]);
        this.sciSchoolDim.AddCell(this.stdSchoolScienceDim);
        
        this.engSchoolDim.AddCell(this.schoolLocationCells[1]);
        this.engSchoolDim.AddCell(this.headOfSchoolCells[1]);
        this.engSchoolDim.AddCell(this.stdSchoolEngDim);
        
        this.socSciSchoolDim.AddCell(this.schoolLocationCells[2]);
        this.socSciSchoolDim.AddCell(this.headOfSchoolCells[2]);
        this.socSciSchoolDim.AddCell(this.stdSchoolSocSciDim);
        
        this.artsSchoolDim.AddCell(this.schoolLocationCells[2]);
        this.artsSchoolDim.AddCell(this.headOfSchoolCells[3]);
        this.artsSchoolDim.AddCell(this.stdSchoolArtsDim);
        
        
        
        
        for ( CoreCell tmpCell : Universe){
            System.out.println(tmpCell.getCoreCellID() + " " + tmpCell.getCoreCellName());
        }
        for ( Dimension tmpDim : dimUniverse){
            System.out.println(tmpDim.getDimID() + " " + tmpDim.getDimName());
        }
        //String [] printme = StudentsDim.printGetDimensionsCellContentString();
        //System.out.println(" print again " + Arrays.toString(printme));
        
    }
    
    public String[] getDimString(){
        String [] printme = StudentsDim.getDimensionsCellContentString();
        //System.out.println(" print again " + Arrays.toString(printme));
        return printme;
    }
    public void printDimString(){
        String [] printme = StudentsDim.getDimensionsCellContentString();
        System.out.println(" teeest " + Arrays.toString(printme));
    }
    public ArrayList<CoreCell> getUniverse (){
        return Universe; 
    }
    
 
    
}
