/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dimensional_Descendant;

import java.util.ArrayList;

public class CreateDataSwan {
    private ArrayList<CoreCell> Universe;
    private ArrayList<Dimension> dimUniverse;
    public CellsUniverse cells = new CellsUniverse();
    public DimsUniverse dims = new DimsUniverse();
    
    private Dimension SwanSpecies = new Dimension("Swan Species");
    private Dimension SwanColors = new Dimension("Swan Color");
    private Dimension BlackSwan = new Dimension("Black Swan");
    private Dimension WhiteSwan = new Dimension("White Swan");
    private Dimension BlackWhiteSwan = new Dimension("Black and White Swan");
    private Dimension Colors = new Dimension("Color");
    private Dimension AnimalType = new Dimension("Animal Type");
    
    private StringCell bird = new StringCell("Bird");
    private StringCell black = new StringCell("Black");
    private StringCell white = new StringCell("White");
    
    CreateDataSwan(){
        
        Universe = cells.getUniverseArrayList();
        dimUniverse = dims.getDimUniverseArrayList();
        
        Colors.AddCell(black);
        black.setMotherDim(Colors);
        Colors.AddCell(white);
        white.setMotherDim(Colors);
        
        AnimalType.AddCell(bird);
        bird.setMotherDim(AnimalType);
        
        BlackSwan.AddCell(black);
        WhiteSwan.AddCell(white);
        BlackWhiteSwan.AddCell(black);
        BlackWhiteSwan.AddCell(white);
        
        SwanColors.AddCell(BlackSwan);
        BlackSwan.setMotherDim(SwanColors);
        
        SwanColors.AddCell(WhiteSwan);
        WhiteSwan.setMotherDim(SwanColors);
        
        SwanColors.AddCell(BlackWhiteSwan);
        BlackWhiteSwan.setMotherDim(SwanColors);
        
        SwanSpecies.AddCell(bird);
        SwanSpecies.AddCell(SwanColors);
        SwanColors.setMotherDim(SwanSpecies);
        
        
    }
    
    
    public ArrayList<CoreCell> getUniverse (){
        return Universe; 
    }
}
