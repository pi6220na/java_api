package wolfe;

import javax.swing.table.AbstractTableModel;
import java.util.Vector;

/*
 * Created by Jeremy on 12/1/2016.
 */
public class Level3TableModel extends AbstractTableModel {

    private Vector<Level3> Level3Vector;

    // Column names, displayed as table headers in the JTable.
    private String[] columnsNames = { "ID", "Modifier", "Name", "Summary", "Detail", "Klass_FK" } ;

    Level3TableModel(Vector<Level3> Level3Vectors) {
        Level3Vector = Level3Vectors;
    }


    @Override
    public int getRowCount() {

        return Level3Vector.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        if (columnIndex == 0) {
            return Level3Vector.get(rowIndex).getId();
        }

        if (columnIndex == 1) {
            return Level3Vector.get(rowIndex).getModifier();
        }

        if (columnIndex == 2) {
            return Level3Vector.get(rowIndex).getName();
        }

        if (columnIndex == 3) {
            return Level3Vector.get(rowIndex).getSummary();
        }

        if (columnIndex == 4) {
            return Level3Vector.get(rowIndex).getDetail();
        }

        if (columnIndex == 5) {
            return Level3Vector.get(rowIndex).getKlass_fk();
        }

        return null;
    }


    @Override
    public String getColumnName(int col) {

        return columnsNames[col];

    }

}
