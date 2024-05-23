import java.awt.Color;
import java.awt.Font;

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
    TableColumnWidthSetter BookDetailsColumns = new TableColumnWidthSetter();// for bookdetails table
    TableColumnWidthSetter memberDetailsColumns = new TableColumnWidthSetter();// for memberdetails table

    HomePanel() {
        this.setBounds(200, 55, 950, 615);
        ImageIcon background = new ImageIcon("background.jpg");
        JLabel img = new JLabel(background);
        img.setBounds(0, 0, 950, 615);
        this.add(img);
        this.setLayout(null);
        this.setVisible(true);

        JLabel bookDetailsLabel = new JLabel("Book Details");
        bookDetailsLabel.setFont(new Font("Arial", Font.BOLD, 16));
        bookDetailsLabel.setForeground(Color.BLACK);
        bookDetailsLabel.setBounds(50, 20, 200, 30);
        img.add(bookDetailsLabel);

        JLabel memberDetailsLabel = new JLabel("Member Details");
        memberDetailsLabel.setFont(new Font("Arial", Font.BOLD, 16));
        memberDetailsLabel.setForeground(Color.BLACK);
        memberDetailsLabel.setBounds(50, 280, 200, 30);
        img.add(memberDetailsLabel);

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

        Object[][] data2 = { { 1, "Vinayak", "Shrestha", "vinayak@gmail.com" },
                { 2, "Sagar", "Lama", "imgay@gmail.com" },
                { 3, "Ronak", "Prajapati", "gwara@gmail.com" }, { 2, "hello", "vinayak", "horror" },
                { 2, "hello", "vinayak", "horror" }, { 2, "hello", "vinayak", "horror" },
                { 2, "hello", "vinayak", "horror" }, { 2, "hello", "vinayak", "horror" },
                { 2, "hello", "vinayak", "horror" }, { 2, "hello", "vinayak", "horror" } };
        String[] str2 = { "Member-Id", "First-Name", "Last-Name", "e-mail" };
        DefaultTableModel model2 = new DefaultTableModel(data2, str2) {
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

        JTable memberDetails = new JTable(model2);
        memberDetails.getTableHeader().setReorderingAllowed(false);// disables drag and drop of the column
        memberDetails.setColumnSelectionAllowed(false);// column selection
        memberDetails.setRowSelectionAllowed(true);// row selection
        memberDetails.setRowHeight(30);
        memberDetails.setSelectionBackground(Color.GREEN);
        memberDetails.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// only allows to select single row
        JScrollPane scrollPane2 = new JScrollPane(memberDetails);
        scrollPane2.setBounds(50, 310, 830, 200);
        img.add(scrollPane2);

        TableColumnModel columnModel = bookDetails.getColumnModel();// for book details
        TableColumnModel columnModel2 = memberDetails.getColumnModel();// for member details

        // Set the preferred, min, and max width for columns
        BookDetailsColumns.setColumnWidth(columnModel, 0, 55); // bookIdColumn
        BookDetailsColumns.setColumnWidth(columnModel, 1, 395); // nameColumn
        BookDetailsColumns.setColumnWidth(columnModel, 2, 295); // authorColumn
        BookDetailsColumns.setColumnWidth(columnModel, 3, 85); // genreColumn

        memberDetailsColumns.setColumnWidth(columnModel2, 0, 65); // bookIdColumn
        memberDetailsColumns.setColumnWidth(columnModel2, 1, 220); // nameColumn
        memberDetailsColumns.setColumnWidth(columnModel2, 2, 220); // authorColumn
        memberDetailsColumns.setColumnWidth(columnModel2, 3, 325); // genreColumn

        // validate();
    }

}
