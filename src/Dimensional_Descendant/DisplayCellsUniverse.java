/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dimensional_Descendant;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
/**
 *
 * @author ayman
 */
public class DisplayCellsUniverse extends JFrame{
    private JTextField cellIdText;
    private JLabel cellIdTextLabel;
    private JTextField cellContentText;
    private JLabel cellContentTextLabel;
    private JTextField cellTypeText;
    private JLabel cellTypeTextLabel;
    private JTextField cellPoswardId;
    private JLabel cellPoswardIdLabel;
    private JTextField cellNegwardId;
    private JLabel cellNegwardIdLabel;
    private ArrayList <JLabel> cellLabels;
    private ArrayList <JTextField> cellInfo;
    private JList cellDimsNames;
    private JLabel cellDimsNamesLabel;
    
    private JButton nextStringCellBut;
    private JButton previousStringCellBut;


    private JPanel rightPane = new JPanel();
    private JPanel leftPane = new JPanel();
    private JSplitPane splitPane;
    
    private CellsUniverse cells;
    private DimsUniverse dimensions;
    private StringCell newString; 
    private int displayCounter;

    
    public DisplayCellsUniverse(CellsUniverse cellsTmp, DimsUniverse dimensionsTmp) {
        super("Dimensional Informatics");

        getContentPane().setBackground(Color.cyan);
        setLayout(new FlowLayout());
        setVisible(true);
        pack();
        setSize(500,400);
        
        cells = cellsTmp;
        dimensions = dimensionsTmp;
        displayCounter=1;
        
        JLabel title = new JLabel("DI Universe Display");
        title.setFont(title.getFont().deriveFont(24.0f));
        add(title);
        cellLabels = new ArrayList <JLabel>();
        cellInfo = new ArrayList <JTextField>();
        
        //cell 0 
        cellIdText = new JTextField(10);
        cellIdText.setEditable(false);
        cellIdTextLabel = new JLabel("Cell ID: ");
        cellIdTextLabel.setLabelFor(cellIdText);
        cellLabels.add(cellIdTextLabel);
        cellInfo.add(cellIdText);
        
        //cell 1
        cellContentText = new JTextField(10);
        cellContentText.setEditable(false);
        cellContentTextLabel = new JLabel("Cell Content Text: ");
        cellContentTextLabel.setLabelFor(cellContentTextLabel);
        cellLabels.add(cellContentTextLabel);
        cellInfo.add(cellContentText);
        
        // cell 2 
        cellTypeText = new JTextField(10);
        cellTypeText.setEditable(false);
        cellTypeTextLabel = new JLabel("Cell Type Text: ");
        cellTypeTextLabel.setLabelFor(cellTypeTextLabel);
        cellLabels.add(cellTypeTextLabel);
        cellInfo.add(cellTypeText);
        
        cellPoswardId = new JTextField(10);
        cellPoswardId.setEditable(false);
        cellPoswardIdLabel = new JLabel("Cell Posward ID: ");
        cellPoswardIdLabel.setLabelFor(cellPoswardIdLabel);
        cellLabels.add(cellPoswardIdLabel);
        cellInfo.add(cellPoswardId);
        
        
        cellNegwardId = new JTextField(10);
        cellNegwardId.setEditable(false);
        cellNegwardIdLabel = new JLabel("Cell Negward ID: ");
        cellNegwardIdLabel.setLabelFor(cellNegwardIdLabel);
        cellLabels.add(cellNegwardIdLabel);
        cellInfo.add(cellNegwardId);
        
        cellDimsNames = new JList();
        cellDimsNamesLabel = new JLabel("Cell Dimensions Names: ");
        cellDimsNamesLabel.setLabelFor(cellDimsNamesLabel);
        cellDimsNames.setToolTipText("Dimensions");
        //DefaultComboBoxModel cbm = new DefaultComboBoxModel(dimensions.getDimsName());
        //cellDimsNames.setModel(cbm);
        cellDimsNames.setVisibleRowCount(3);
        cellDimsNames.setEnabled(false);

        
        //cellDimsNames.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    
        nextStringCellBut = new JButton("Next");
        previousStringCellBut = new JButton("Previous");
        
        
        Handler handleAdd = new Handler( cells, dimensions);
        
        nextStringCellBut.addActionListener(handleAdd);
        previousStringCellBut.addActionListener(handleAdd);

        rightPane.setLayout(new BoxLayout(rightPane, BoxLayout.PAGE_AXIS));
        leftPane.setLayout(new BoxLayout(leftPane, BoxLayout.Y_AXIS));
                
        // Adding all components to right and left panes and then to split pane
        for (int i=0; i<cellLabels.size();i++){
            //rightPane.
            rightPane.add(cellLabels.get(i));
            rightPane.add(cellInfo.get(i));
        }
        rightPane.add(cellDimsNamesLabel);
        rightPane.add(cellDimsNames);
        rightPane.add(new JScrollPane(cellDimsNames));
        
        leftPane.add(nextStringCellBut);
        leftPane.add(previousStringCellBut);

        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                                   leftPane, rightPane);
        splitPane.setOneTouchExpandable(true);
        splitPane.setDividerLocation(150);
        
        add(splitPane);
        printCellToScreen(1);
    }
    
      
    public class Handler implements ActionListener {
        CellsUniverse cells;
        DimsUniverse dimensions;
        StringCell newString;
        public Handler (CellsUniverse cellsTmp, DimsUniverse dimensionsTmp){
            cells = cellsTmp;
            dimensions = dimensionsTmp; 
        }
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getActionCommand().equals("Next") && displayCounter+1 < cells.getCellsUniverseSize()){
                System.out.println("the universe size from display is " + cells.getCellsUniverseSize() +" counter "+displayCounter);
                displayCounter++;
                printCellToScreen(displayCounter);
                
            }
            else if ( ae.getActionCommand().equals("Previous") && displayCounter > 1){
                displayCounter--;
                printCellToScreen(displayCounter);
                
            }
            else {
                JOptionPane.showMessageDialog(null,
                "You Have reached the Universe Border",
                "Dimensional Informatics",
                JOptionPane.WARNING_MESSAGE);
               // JOptionPane.showMessageDialog(null,"You Have reached the Universe Border");
            }
                
            
        }
    }
    
    private void printCellToScreen (int cellNoInUniverse){
        
        newString=(StringCell) cells.getCellOfIndex(cellNoInUniverse);
        String[] listDimName = new String[newString.getCellDims().size()];
        cellIdText.setText(Integer.toString(newString.getCoreCellID()));
        cellContentText.setText(newString.getCellContent());
        cellTypeText.setText(newString.getCellType());
        cellPoswardId.setText(Integer.toString(newString.getPosward()));
        cellNegwardId.setText(Integer.toString(newString.getNegward()));
        for (int i=0; i<newString.getCellDims().size(); i++){
            String x;
            x=newString.getCellDims().toArray()[0].toString(); 
            listDimName[i] = dimensions.getDimNameByID(Integer.parseInt(x));
            System.out.println("the dim ID is " + dimensions.getDimNameByID(Integer.parseInt(x)));
        }
        //cellDimsNames.setVisibleRowCount(listDimName.length);
        cellDimsNames.setListData(listDimName);
    }
}
