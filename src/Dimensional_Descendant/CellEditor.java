/*
 * Here the GUI is created and the action should be taken from here to access 
 * the Dimensional informatics world. 
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
public class CellEditor extends  JFrame {
            //Create a regular text field.
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
    
    private JButton addStringCell;
    private JButton submitDataStringCell;
    private JButton displayCellUniverseBut;

    private JPanel rightPane = new JPanel();
    private JPanel leftPane = new JPanel();
    private JSplitPane splitPane;

    
    public CellEditor(CellsUniverse cells, DimsUniverse dimensions) {
        super("Dimensional Informatics");
        
        setLayout(new FlowLayout());
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setVisible(true);
        pack();
        setSize(500,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel title = new JLabel("Dimensional Informatics Universe");
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
        //cellDimsNames.setEditable(false);
        cellDimsNamesLabel = new JLabel("Cell Dimensions Names: ");
        cellDimsNamesLabel.setLabelFor(cellDimsNamesLabel);
        cellDimsNames.setToolTipText("Dimensions");
        DefaultComboBoxModel cbm = new DefaultComboBoxModel(dimensions.getDimsName());
        cellDimsNames.setModel(cbm);
        cellDimsNames.setVisibleRowCount(3);
        cellDimsNames.setEnabled(false);

        
        cellDimsNames.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    
        addStringCell = new JButton("Add New String Cell");
        submitDataStringCell = new JButton("Submit");
        submitDataStringCell.setEnabled(false);
        displayCellUniverseBut = new JButton("Display Cell Universe");
        
        Handler handleAdd = new Handler( cells, dimensions);
        
        addStringCell.addActionListener(handleAdd);
        submitDataStringCell.addActionListener(handleAdd);
        displayCellUniverseBut.addActionListener(handleAdd);

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
        
        leftPane.add(addStringCell);
        leftPane.add(submitDataStringCell);
        leftPane.add(displayCellUniverseBut);

        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                                   leftPane, rightPane);
        splitPane.setOneTouchExpandable(true);
        splitPane.setDividerLocation(150);
        
        add(splitPane);
        
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
            if (ae.getActionCommand().equals("Add New String Cell")){
                CreateEmptyStringCell emptyCell = 
                        new CreateEmptyStringCell(cells, dimensions);
                newString=emptyCell.changeLayoutFillText(cellInfo,
                        submitDataStringCell,addStringCell,cellDimsNames);
                
                
            }
            else if ( ae.getActionCommand().equals("Submit")){
                SubmitDataNewString fillCell = new SubmitDataNewString(cells,
                        dimensions,newString);
                fillCell.collectDataFillCell(cellInfo,
                        submitDataStringCell,addStringCell,cellDimsNames);
                System.out.println("the universe size from submit is " + cells.getCellsUniverseSize());
            }
            else if ( ae.getActionCommand().equals("Display Cell Universe")){
                if (cells.getCellsUniverseSize() <= 1){
                    JOptionPane.showMessageDialog(null,
                        "No Cells in the Universe",
                        "Dimensional Informatics",
                        JOptionPane.WARNING_MESSAGE);
                } else {
                DisplayCellsUniverse displayTheUniverse = 
                        new DisplayCellsUniverse(cells, dimensions);}
                
                /*JFrame newDisplay = new JFrame();
                newDisplay.setLayout(new FlowLayout());
                newDisplay.setVisible(true);
                newDisplay.pack();
                newDisplay.setSize(500,500);
                //newDisplay.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
            }
        }
        
    }
    


}
