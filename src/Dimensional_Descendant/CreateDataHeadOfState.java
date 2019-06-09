/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dimensional_Descendant;

/**
 *
 * @author ayman
 */

import java.util.ArrayList;

    

public class CreateDataHeadOfState {
    private ArrayList<CoreCell> Universe;
    private ArrayList<Dimension> dimUniverse;
    public CellsUniverse cells = new CellsUniverse();
    public DimsUniverse dims = new DimsUniverse();
    
    private Dimension HeadOfState = new Dimension("Position Head Of State");
    private Dimension PosBritainHeadOfState = new Dimension("Position Britain Head Of State");
    private Dimension PosUSAHeadOfState= new Dimension("Position USA Head Of State");
    private Dimension Title = new Dimension("Title");
    private Dimension Country = new Dimension("Country");
    private Dimension HoSOfBritain = new Dimension("Heads of States Of Britain");
    private Dimension HoSOfUSA = new Dimension("Heads of States Of USA");
    private Dimension GeorgeHoS = new Dimension("George II HoS");
    private Dimension ElizabethHoS = new Dimension("Elizabeth HoS");
    private Dimension Name = new Dimension("Name");
    private Dimension Coronated = new Dimension("Coronated");
    
    private StringCell Elizabeth = new StringCell("Elizabeth");
    private StringCell George = new StringCell("George");
    private StringCell Year1952 = new StringCell("Year 1952");
    private StringCell Year1962 = new StringCell("Year 1962");
    private StringCell Britain = new StringCell("Britain");
    private StringCell USA = new StringCell("USA");
    private StringCell Monarch = new StringCell("Monarch");
    private StringCell President = new StringCell("President");
   
    
    CreateDataHeadOfState(){
        Universe = cells.getUniverseArrayList();
        dimUniverse = dims.getDimUniverseArrayList();
        
        Name.AddCell(Elizabeth);
        Elizabeth.setMotherDim(Name);
        Name.AddCell(George);
        George.setMotherDim(Name);
        
        Coronated.AddCell(Year1952);
        Year1952.setMotherDim(Coronated);
        Coronated.AddCell(Year1962);
        Year1962.setMotherDim(Coronated);
        
        GeorgeHoS.AddCell(George);
        GeorgeHoS.AddCell(Year1962);
        
        ElizabethHoS.AddCell(Elizabeth);
        ElizabethHoS.AddCell(Year1952);
        
        HoSOfBritain.AddCell(ElizabethHoS);
        ElizabethHoS.setMotherDim(HoSOfBritain);
        HoSOfBritain.AddCell(GeorgeHoS);
        GeorgeHoS.setMotherDim(HoSOfBritain);
        
        Country.AddCell(Britain);
        Britain.setMotherDim(Country);
        Country.AddCell(USA);
        USA.setMotherDim(Country);
        
        Title.AddCell(Monarch);
        Monarch.setMotherDim(Title);
        Title.AddCell(President);
        President.setMotherDim(Title);
        
        PosBritainHeadOfState.AddCell(Monarch);
        PosBritainHeadOfState.AddCell(Britain);
        PosBritainHeadOfState.AddCell(HoSOfBritain);
        HoSOfBritain.setMotherDim(PosBritainHeadOfState);
        PosUSAHeadOfState.AddCell(President);
        PosUSAHeadOfState.AddCell(USA);
        
        HeadOfState.AddCell(PosUSAHeadOfState);
        PosUSAHeadOfState.setMotherDim(HeadOfState);
        HeadOfState.AddCell(PosBritainHeadOfState);
        PosBritainHeadOfState.setMotherDim(HeadOfState);
        
        
        
    }
    
    public ArrayList<CoreCell> getUniverse (){
        return Universe; 
    }
    
}
