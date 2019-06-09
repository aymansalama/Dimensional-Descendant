/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dimensional_Descendant;

import java.util.ArrayList;
import java.util.Arrays;


public class CreateDataJamesBond {
    private ArrayList<CoreCell> Universe;
    private ArrayList<Dimension> dimUniverse;
    public CellsUniverse cells = new CellsUniverse();
    public DimsUniverse dims = new DimsUniverse();
    
    // Dimension Definition 
    private Dimension JamesBond = new Dimension("James Bond");
    private Dimension Creators = new Dimension("Creators");
    private Dimension CharactersOfJamesBond = new Dimension("Characters Of James Bond");
    private Dimension ConneryOfJameBond = new Dimension("Connery Of James Bond");
    private Dimension MooreOfJameBond = new Dimension("Moore Of James Bond");
    private Dimension Actors = new Dimension("Actors");
    private Dimension FilmingPeriod = new Dimension("Filming Period");
    private Dimension NumberOfMovies = new Dimension("Number of Movies");
    
    // cells definition
    private StringCell Fleming = new StringCell("Fleming");
    private StringCell RogerMoore = new StringCell("Roger Moore");
    private StringCell SeanConnery = new StringCell("Sean Connery");
    private StringCell Period1970s = new StringCell("1970's");
    private StringCell Period1960s = new StringCell("1960's");
    private StringCell ConneryMovieNumber = new StringCell("6 Movies");
    private StringCell MooreMovieNumber = new StringCell("7 Movies");
    
    
    
    CreateDataJamesBond(){
        Universe = cells.getUniverseArrayList();
        dimUniverse = dims.getDimUniverseArrayList();
        
        // add cells to mother dimension
        Creators.AddCell(Fleming);
        Fleming.setMotherDim(Creators);
        
        Actors.AddCell(RogerMoore);
        RogerMoore.setMotherDim(Actors);
        
        Actors.AddCell(SeanConnery);
        SeanConnery.setMotherDim(Actors);
        
        FilmingPeriod.AddCell(Period1970s);
        Period1970s.setMotherDim(FilmingPeriod);
        
        FilmingPeriod.AddCell(Period1960s);
        Period1960s.setMotherDim(FilmingPeriod);
        
        NumberOfMovies.AddCell(ConneryMovieNumber);
        ConneryMovieNumber.setMotherDim(NumberOfMovies);
        
        NumberOfMovies.AddCell(MooreMovieNumber);
        MooreMovieNumber.setMotherDim(NumberOfMovies);
        
        
        
        // Create Connery Dimension
        ConneryOfJameBond.AddCell(SeanConnery);
        ConneryOfJameBond.AddCell(Period1960s);
        ConneryOfJameBond.AddCell(ConneryMovieNumber);
        // Create Moore Dimension
        MooreOfJameBond.AddCell(RogerMoore);
        MooreOfJameBond.AddCell(Period1970s);
        MooreOfJameBond.AddCell(MooreMovieNumber);
        // Create Actor Dimensions
        Actors.AddCell(RogerMoore);
        Actors.AddCell(SeanConnery);
        // creating the characteres
        CharactersOfJamesBond.AddCell(ConneryOfJameBond);
        ConneryOfJameBond.setMotherDim(CharactersOfJamesBond);
        
        CharactersOfJamesBond.AddCell(MooreOfJameBond);
        MooreOfJameBond.setMotherDim(CharactersOfJamesBond);
        
        // Creating dimensions of james bond
        JamesBond.AddCell(Fleming);
        JamesBond.AddCell(CharactersOfJamesBond);
        CharactersOfJamesBond.setMotherDim(JamesBond);
       
        
    }
    
   public ArrayList<CoreCell> getUniverse (){
        return Universe; 
    }
}
