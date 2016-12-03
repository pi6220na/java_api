
import javax.swing.table.AbstractTableModel;
import java.util.Vector;

/*
 * Created by Jeremy on 12/1/2016.
 */
public class Level2TableModel extends AbstractTableModel {

    private Vector<Level2> Level2Vector;

    // Column names, displayed as table headers in the JTable.
    private String[] columnsNames = { "ID", "Type", "Name", "Summary", "Package_FK" } ;

    Level2TableModel(Vector<Level2> Level2Vectors) {
        Level2Vector = Level2Vectors;
    }


    @Override
    public int getRowCount() {

        return Level2Vector.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        if (columnIndex == 0) {
            return Level2Vector.get(rowIndex).getId();
        }

        if (columnIndex == 1) {
            return Level2Vector.get(rowIndex).getType();
        }

        if (columnIndex == 2) {
            return Level2Vector.get(rowIndex).getName();
        }

        if (columnIndex == 3) {
            return Level2Vector.get(rowIndex).getSummary();
        }

        if (columnIndex == 4) {
            return Level2Vector.get(rowIndex).getPackage_fk();
        }

        return null;
    }


    @Override
    public String getColumnName(int col) {

        return columnsNames[col];

    }

}
