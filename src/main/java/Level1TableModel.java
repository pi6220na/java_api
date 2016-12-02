
import javax.swing.table.AbstractTableModel;
import java.util.Vector;

/*
 * Created by Jeremy on 12/1/2016.
 */
public class Level1TableModel extends AbstractTableModel {

    private Vector<Level1> Level1Vector;

    // Column names, displayed as table headers in the JTable.
    private String[] columnsNames = { "ID", "Name", "Description" } ;

    Level1TableModel(Vector<Level1> Level1Vectors) {
        Level1Vector = Level1Vectors;
    }


    @Override
    public int getRowCount() {

        return Level1Vector.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        if (columnIndex == 0) {
            return Level1Vector.get(rowIndex).getId();
        }

        if (columnIndex == 1) {
            return Level1Vector.get(rowIndex).getName();
        }

        if (columnIndex == 2) {
            return Level1Vector.get(rowIndex).getDescription();
        }

        return null;
    }


    @Override
    public String getColumnName(int col) {

        return columnsNames[col];

    }



}
