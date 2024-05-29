import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class TableClass extends JTable {
    TableClass(DefaultTableModel model) {
        this.getTableHeader().setReorderingAllowed(false);
        this.setColumnSelectionAllowed(false);
        this.setRowSelectionAllowed(true);
        this.setRowHeight(30);
        this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.setModel(model);
    }

    public void setColumnWidth(TableColumnModel columnModel, int columnIndex, int width) {
        TableColumn column = columnModel.getColumn(columnIndex);
        column.setPreferredWidth(width);
        column.setMinWidth(width);
        column.setMaxWidth(width);
    }

}
