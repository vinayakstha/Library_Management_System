import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
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
        JTableHeader header = this.getTableHeader();
        header.setBackground(new Color(73, 150, 252));
        header.setForeground(new Color(255, 255, 255));
        header.setFont(new Font("Arial", Font.PLAIN, 12));
        header.setPreferredSize(new Dimension(header.getWidth(), 30));
    }

    public void setColumnWidth(TableColumnModel columnModel, int columnIndex, int width) {
        TableColumn column = columnModel.getColumn(columnIndex);
        column.setPreferredWidth(width);
        column.setMinWidth(width);
        column.setMaxWidth(width);
    }

}
