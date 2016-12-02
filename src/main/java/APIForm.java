import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.util.Vector;

/**
 * Created by myrlin on 12/1/2016.
 */
public class APIForm extends JFrame {
    private JPanel rootPanel;
    private JTable Level3Tables;
    private JTable Level2Tables;
    private JTable Level1Tables;
    private JTextField textFieldPackage;
    private JTextField textFieldClass;
    private JTextField textFieldMethod;
    private JRadioButton radioButton2;
    private JRadioButton radioButton4;
    private JRadioButton radioButton1;
    private JRadioButton radioButton5;
    private JRadioButton radioButton3;
    private JRadioButton radioButton6;


    Vector<Level1> level1Vector = new Vector<>(100);


    //Models for JTables.
    Level1TableModel level1TableModel;



    public APIForm(Vector<Level1> inData) {

        super("Java API Application");

        for (Level1 item : inData) {
            System.out.println("item = " + item.getId());
            System.out.println("item = " + item.getName());
            System.out.println("item = " + item.getDescription());
            level1Vector.add(item);
        }

        setContentPane(rootPanel);
        setPreferredSize(new Dimension(1000, 600));   //Set preferred size before call to pack()
        pack();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);


        // Create model for JTables
        level1TableModel = new Level1TableModel(level1Vector);   //Provide Vector of Open Tickets

        //Configure each component to use its model
        Level1Tables.setModel(level1TableModel);

//        for (Level1 item: inData) {
//            level1Vector.add(item);
//        }
//        level1TableModel.fireTableDataChanged();

    }

}