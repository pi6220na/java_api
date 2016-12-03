import javax.swing.table.AbstractTableModel;
import java.util.Vector;

/*
 * Created by Jeremy on 12/2/2016.
 */
public class ComboTableModel extends AbstractTableModel {



    private Vector<Combo> ComboVector;

    // Column names, displayed as table headers in the JTable.
    private String[] columnsNames = { "M_Modifier", "M_Name", "M_Summary", "K_Type", "K_Name", "P_Name" } ;

    ComboTableModel(Vector<Combo> ComboVectors) {
        ComboVector = ComboVectors;
    }


    @Override
    public int getRowCount() {

        return ComboVector.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        if (columnIndex == 0) {
            return ComboVector.get(rowIndex).getMethod_modifier();
        }

        if (columnIndex == 1) {
            return ComboVector.get(rowIndex).getMethod_name();
        }

        if (columnIndex == 2) {
            return ComboVector.get(rowIndex).getMethod_summary();
        }

        if (columnIndex == 3) {
            return ComboVector.get(rowIndex).getKlass_type();
        }

        if (columnIndex == 4) {
            return ComboVector.get(rowIndex).getKlass_name();
        }

        if (columnIndex == 5) {
            return ComboVector.get(rowIndex).getPackage_name();
        }

        return null;
    }


    @Override
    public String getColumnName(int col) {

        return columnsNames[col];

    }

}
