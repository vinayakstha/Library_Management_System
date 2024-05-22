import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

class TableColumnWidthSetter {

    public void setColumnWidth(TableColumnModel columnModel, int columnIndex, int width) {
        TableColumn column = columnModel.getColumn(columnIndex);
        column.setPreferredWidth(width);
        column.setMinWidth(width);
        column.setMaxWidth(width);
    }
}

class HomePanel extends JPanel {
    TableColumnWidthSetter BookDetailsColumns = new TableColumnWidthSetter();

    HomePanel() {
        this.setBounds(200, 55, 950, 615);
        ImageIcon background = new ImageIcon("background.jpg");
        JLabel img = new JLabel(background);
        img.setBounds(0, 0, 950, 615);
        this.add(img);
        this.setLayout(null);

        Object[][] data = { { 1, "hello", "vinayak", "horror" }, { 2, "hello", "vinayak", "horror" },
                { 2, "hello", "vinayak", "horror" }, { 2, "hello", "vinayak", "horror" },
                { 2, "hello", "vinayak", "horror" }, { 2, "hello", "vinayak", "horror" },
                { 2, "hello", "vinayak", "horror" }, { 2, "hello", "vinayak", "horror" },
                { 2, "hello", "vinayak", "horror" }, { 2, "hello", "vinayak", "horror" } };
        String[] str = { "Book-Id", "Name", "Author", "Genre" };
        DefaultTableModel model = new DefaultTableModel(data, str) {
            @Override // to make cells non-editable
            public boolean isCellEditable(int row, int column) {
                return false; // All cells are non-editable
            }
        };

        JTable bookDetails = new JTable(model);
        bookDetails.getTableHeader().setReorderingAllowed(false);// disables drag and drop of the column
        bookDetails.setColumnSelectionAllowed(false);// column selection
        bookDetails.setRowSelectionAllowed(true);// row selection
        bookDetails.setRowHeight(30);
        bookDetails.setSelectionBackground(Color.GREEN);
        bookDetails.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// only allows to select single row
        JScrollPane scrollPane = new JScrollPane(bookDetails);
        scrollPane.setBounds(50, 50, 830, 200);
        img.add(scrollPane);

        TableColumnModel columnModel = bookDetails.getColumnModel();

        // Set the preferred, min, and max width for columns
        BookDetailsColumns.setColumnWidth(columnModel, 0, 55); // bookIdColumn
        BookDetailsColumns.setColumnWidth(columnModel, 1, 400); // nameColumn
        BookDetailsColumns.setColumnWidth(columnModel, 2, 300); // authorColumn
        BookDetailsColumns.setColumnWidth(columnModel, 3, 75); // genreColumn

        // validate();
    }

}
