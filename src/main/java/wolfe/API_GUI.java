package wolfe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

/*
 * Created by Jeremy on 12/1/2016.
 *
 * Java_API GUI code. Accesses data from java_api database via calls to DB class methods.
 */
public class API_GUI extends JFrame {
    private JPanel rootPanel;
    private JTable Level3Tables;
    private JTable Level2Tables;
    private JTable Level1Tables;
    private JTable ComboTable;
    private JTextField textFieldPackage;
    private JTextField textFieldClass;
    private JTextField textFieldMethod;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JRadioButton radioButton3;
    private JRadioButton radioButton4;
    private JRadioButton radioButton5;
    private JRadioButton searchNameRadioButton;
    private JRadioButton searchDescriptionRadioButton;
    private JButton helpButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;

    // Vectors for JTables.
    Vector<Level1> level1Vector = new Vector<>(100);
    Vector<Level2> level2Vector = new Vector<>(100);
    Vector<Level3> level3Vector = new Vector<>(100);
    Vector<Combo> comboVector = new Vector<>(100);


    //Models for JTables.
    Level1TableModel level1TableModel;
    Level2TableModel level2TableModel;
    Level3TableModel level3TableModel;
    ComboTableModel comboTableModel;

    // Boolean used to indicate column to search on
    boolean useName = true;

    public API_GUI() {

        super("Java API Application");

        setContentPane(rootPanel);
        setPreferredSize(new Dimension(1000, 700));   //Set preferred size before call to pack()
        pack();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);


        //Group the radio buttons.
        ButtonGroup group = new ButtonGroup();
        group.add(radioButton1);
        group.add(radioButton2);
        group.add(radioButton3);
        group.add(radioButton4);
        group.add(radioButton5);

        // second group of radio buttons.
        ButtonGroup rGroup = new ButtonGroup();
        rGroup.add(searchNameRadioButton);
        rGroup.add(searchDescriptionRadioButton);

        searchNameRadioButton.setSelected(true);

        // Create model for JTables
        level1TableModel = new Level1TableModel(level1Vector);
        level2TableModel = new Level2TableModel(level2Vector);
        level3TableModel = new Level3TableModel(level3Vector);
        comboTableModel = new ComboTableModel(comboVector);

        //Configure each component to use its model
        Level1Tables.setModel(level1TableModel);
        Level2Tables.setModel(level2TableModel);
        Level3Tables.setModel(level3TableModel);
        ComboTable.setModel(comboTableModel);

        // listeners here


        // Package level(1) user input text field handler
        textFieldPackage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Read data from JTextField
                String packageSearch = textFieldPackage.getText();
                //Check that user entered data
                if (packageSearch.trim().length() != 0) {
                    //query database
                    Vector<Level1> inData = Controller.db.fetchLevel1Records(packageSearch);
                    level1Vector.clear();
                    for (Level1 item: inData) {
                        level1Vector.add(item);
                    }
                    level1TableModel.fireTableDataChanged();
                    textFieldPackage.setText("");
                }
            }
        });


        // Class level(2) user input text field handler
        textFieldClass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Read data from JTextField
                String classSearch = textFieldClass.getText();
                //Check that user entered data
                if (classSearch.trim().length() != 0) {
                    //query database
                    Vector<Level2> inData = Controller.db.fetchLevel2Records(classSearch);
                    level2Vector.clear();
                    for (Level2 item: inData) {
                        level2Vector.add(item);
                    }
                    level2TableModel.fireTableDataChanged();
                    textFieldClass.setText("");
                }

            }
        });


        // Field(3) level user input text field handler
        textFieldMethod.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Read data from JTextField
                String methodSearch = textFieldMethod.getText();
                //Check that user entered data
                if (methodSearch.trim().length() != 0) {
                    //query database
                    Vector<Level3> inData = Controller.db.fetchLevel3Records(methodSearch);
                    level3Vector.clear();
                    for (Level3 item: inData) {
                        level3Vector.add(item);
                    }
                    level3TableModel.fireTableDataChanged();
                    textFieldMethod.setText("");
                }

            }
        });


        // Combined query on package, class, and method tables
        radioButton1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange()==1) {
                    System.out.println("RadioButton1-combo pressed");

                    // Read data from JTextField
                    String methodSearch = textFieldMethod.getText();
                    //Check that user entered data
                    if (methodSearch.trim().length() != 0) {
                        //query database
                        Vector<Combo> inData = Controller.db.fetchComboRecords(methodSearch);
                        comboVector.clear();
                        for (Combo item: inData) {
                            comboVector.add(item);
                        }
                        comboTableModel.fireTableDataChanged();
                        textFieldMethod.setText("");
                    }
                    group.clearSelection();
                }
            }
        });


        // query on exception table trigger
        radioButton3.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange()==1) {
                    System.out.println("RadioButton3-exception pressed");

                    // Read data from JTextField
                    String methodSearch = textFieldClass.getText();
                    //Check that user entered data
                    if (methodSearch.trim().length() != 0) {
                        //query database
                        Vector<Level2> inData = Controller.db.fetchExceptionRecords(methodSearch);
                        level2Vector.clear();
                        for (Level2 item: inData) {
                            level2Vector.add(item);
                        }
                        level2TableModel.fireTableDataChanged();
                        textFieldClass.setText("");
                    }
                    group.clearSelection();
                }
            }
        });


        // query on errors table trigger
        radioButton5.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange()==1) {
                    System.out.println("RadioButton5-errors pressed");

                    // Read data from JTextField
                    String methodSearch = textFieldClass.getText();
                    //Check that user entered data
                    if (methodSearch.trim().length() != 0) {
                        //query database
                        Vector<Level2> inData = Controller.db.fetchErrorsRecords(methodSearch);
                        level2Vector.clear();
                        for (Level2 item: inData) {
                            level2Vector.add(item);
                        }
                        level2TableModel.fireTableDataChanged();
                        textFieldClass.setText("");
                    }
                    group.clearSelection();
                }
            }
        });


        // query on field table trigger
        radioButton4.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange()==1) {
                    System.out.println("RadioButton4-field pressed");

                    // Read data from JTextField
                    String methodSearch = textFieldMethod.getText();
                    //Check that user entered data
                    if (methodSearch.trim().length() != 0) {
                        //query database
                        Vector<Level3> inData = Controller.db.fetchFieldRecords(methodSearch);
                        level3Vector.clear();
                        for (Level3 item: inData) {
                            level3Vector.add(item);
                        }
                        level3TableModel.fireTableDataChanged();
                        textFieldMethod.setText("");
                    }
                    group.clearSelection();
                }
            }
        });


        // query on constructor table trigger
        radioButton2.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange()==1) {
                    System.out.println("RadioButton2-constructor pressed");

                    // Read data from JTextField
                    String methodSearch = textFieldMethod.getText();
                    //Check that user entered data
                    if (methodSearch.trim().length() != 0) {
                        //query database
                        Vector<Level3> inData = Controller.db.fetchConstructorRecords(methodSearch);
                        level3Vector.clear();
                        for (Level3 item: inData) {
                            level3Vector.add(item);
                        }
                        level3TableModel.fireTableDataChanged();
                        textFieldMethod.setText("");
                    }
                    group.clearSelection();
                }
            }
        });


        // copy Package level row information to detail section
        Level1Tables.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println("table 1 mouse clicked");
                clearTextFields();
                textField1.setText(Level1Tables.getValueAt(Level1Tables.getSelectedRow(), 0).toString());
                textField2.setText(Level1Tables.getValueAt(Level1Tables.getSelectedRow(), 1).toString());
                textField3.setText(Level1Tables.getValueAt(Level1Tables.getSelectedRow(), 2).toString());
            }

        });

        // copy Class level row information to detail section
        Level2Tables.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println("table 2 mouse clicked");
                clearTextFields();
                textField1.setText(Level2Tables.getValueAt(Level2Tables.getSelectedRow(), 0).toString());
                textField2.setText(Level2Tables.getValueAt(Level2Tables.getSelectedRow(), 1).toString());
                textField3.setText(Level2Tables.getValueAt(Level2Tables.getSelectedRow(), 2).toString());
                textField4.setText(Level2Tables.getValueAt(Level2Tables.getSelectedRow(), 3).toString());
                textField5.setText(Level2Tables.getValueAt(Level2Tables.getSelectedRow(), 4).toString());
            }

        });

        // copy Method level row information to detail section
        Level3Tables.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println("table 3 mouse clicked");
                try {
                    clearTextFields();
                    textField1.setText(Level3Tables.getValueAt(Level3Tables.getSelectedRow(), 0).toString());
                    textField2.setText(Level3Tables.getValueAt(Level3Tables.getSelectedRow(), 1).toString());
                    textField3.setText(Level3Tables.getValueAt(Level3Tables.getSelectedRow(), 2).toString());
                    textField4.setText(Level3Tables.getValueAt(Level3Tables.getSelectedRow(), 3).toString());
                    // null data value causing exception on column 5
                    // textField5.setText(Level3Tables.getValueAt(Level3Tables.getSelectedRow(), 4).toString());
                    textField6.setText(Level3Tables.getValueAt(Level3Tables.getSelectedRow(), 5).toString());
                } catch (NullPointerException npe) {
                    System.out.println("Table 3 mouse clicked exception on null value");
                    npe.printStackTrace();
                    System.out.println();

                }

            }

        });


        // // copy Combo level row information to detail section
        ComboTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println("wolfe.Combo Table mouse clicked");
                try {
                    clearTextFields();
                    textField1.setText(ComboTable.getValueAt(ComboTable.getSelectedRow(), 0).toString());
                    textField2.setText(ComboTable.getValueAt(ComboTable.getSelectedRow(), 1).toString());
                    textField3.setText(ComboTable.getValueAt(ComboTable.getSelectedRow(), 2).toString());
                    textField4.setText(ComboTable.getValueAt(ComboTable.getSelectedRow(), 3).toString());
                    textField5.setText(ComboTable.getValueAt(ComboTable.getSelectedRow(), 4).toString());
                    textField6.setText(ComboTable.getValueAt(ComboTable.getSelectedRow(), 5).toString());
                } catch (NullPointerException npe) {
                    System.out.println("wolfe.Combo Table mouse clicked exception on null value");
                    npe.printStackTrace();
                    System.out.println();

                }
            }
        });


        // close app and window from exit "X" button on window title bar
        //https://www.clear.rice.edu/comp310/JavaResources/frame_close.html
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {

                System.exit(0);

            }
        });


        // set boolean for searching on name or description
        searchNameRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (searchNameRadioButton.isSelected()) {
                    useName = true;
                } else {
                    useName = false;
                }
                System.out.println("Name button = " + useName);
            }
        });

        // set boolean for searching on name or description
        searchDescriptionRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (searchDescriptionRadioButton.isSelected()) {
                    useName = false;
                } else {
                    useName = true;
                }
                System.out.println("Description button = " + useName);
            }
        });


        // display help text in separate JFrame window
        helpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                // http://alvinalexander.com/blog/post/jfc-swing/java-swing-create-jscrollpane-example-editor
                SwingUtilities.invokeLater(new Runnable()
                {
                    public void run()
                    {
                        // create a jtextarea
                        JTextArea textArea = new JTextArea();

                        // add text to it; we want to make it scroll
                        textArea.setText("Welcome to the Java API GUI Help Instructions. This application is a database of information\n" +
                                "extracted from the Oracle Web Site for Java SE version 8. Currently, seven tables are utilized. They are:\n\n" +
                                "Package - Package level name and description\n" +
                                "Class - Class level type (1 = class, 2 = interface), name, and summary\n" +
                                "Exception - Exceptions a particular package can throw\n" +
                                "Errors - Errors a particular packaage can throw\n" +
                                "Method - Methods of a Class, modifier, name, and summary\n" +
                                "Field - Fields of a Class, modifier, name, and summary\n" +
                                "Constructor - Constructors of a Class, modifier, name, and summary\n\n" +
                                " ---  Enter a word in one of the three text entry boxes: Search Package Level, " +
                                "Search Class Level, or Search Method Level, followd by the enter key.\n\n" +
                                "  ---  Four Radio Buttons at the top left: represents four other tables that can be searched by entering" +
                                " data in their respective text box\n (Class Level or Method Level).\n\n" +
                                "  ---  Radio Button \"Join on Pack/Class/Method\": enter data in the Method Level text box and click the\n" +
                                " Radio Button. Data will be shown in the bottom table.\n\n" +
                                "  ---  Top right buttons: Search Name and Search Description are mutually exclusive and determine which\n" +
                                " field in the table to search on. Applies to all tables and buttons except the Join button.\n\n" +
                                "  ---  Clicking on a table row will select that row and copy the columns to individual text fields in the\n" +
                                " Details Section.\n\n");

                        // create a scrollpane, givin it the textarea as a constructor argument
                        JScrollPane scrollPane = new JScrollPane(textArea);

                        // now add the scrollpane to the jframe's content pane, specifically
                        // placing it in the center of the jframe's borderlayout
                        JFrame frame = new JFrame("Java API GUI Instructions for Usage");
                        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

                        // make it easy to close the application
                        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

                        // set the frame size (you'll usually want to call frame.pack())
                        frame.setSize(new Dimension(840, 480));

                        // center the frame
                        frame.setLocationRelativeTo(null);

                        // make it visible to the user
                        frame.setVisible(true);
                    }
                });

            }
        });
    }

    // clear out the six detail section text fields
    void clearTextFields() {
        textField1.setText("");
        textField2.setText("");
        textField3.setText("");
        textField4.setText("");
        textField5.setText("");
        textField6.setText("");

    }

    public boolean searchName() {
        return useName;
    }


    // first time run - load Package level table with data from string specified in Class Controller
    public void initializeTable(Vector<Level1> inData) {

        for (Level1 item : inData) {
            level1Vector.add(item);
        }
        level1TableModel.fireTableDataChanged();

    }
}