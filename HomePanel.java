import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

class HomePanel extends JPanel {
    HomePanel() {
        Object[][] data = { { 1, "How to become a Sigma", "Vinayak Shrestha", "Guide" },
                { 2, "I Am Gay", "Sagar Lama", "Biography" },
                { 3, "Gwara the goat", "Ronak Prajapati", "Fantasy" }, { 2, "hello", "vinayak", "horror" },
                { 2, "hello", "vinayak", "horror" }, { 2, "hello", "vinayak", "horror" },
                { 2, "hello", "vinayak", "horror" },
                { 2, "hello", "vinayak", "horror" },
                { 2, "hello", "vinayak", "horror" }, { 2, "hello", "vinayak", "horror" } };
        String[] str = { "Book-Id", "Name", "Author", "Genre" };
        DefaultTableModel model = new DefaultTableModel(data, str) {
            @Override // to make cells non-editable
            public boolean isCellEditable(int row, int column) {
                return false; // All cells are non-editable
            }
        };

        TableClass bookDetailsTable = new TableClass(model);
        TableColumnModel columnModel = bookDetailsTable.getColumnModel();
        bookDetailsTable.setColumnWidth(columnModel, 0, 55); // bookIdColumn
        bookDetailsTable.setColumnWidth(columnModel, 1, 395); // nameColumn
        bookDetailsTable.setColumnWidth(columnModel, 2, 295); // authorColumn
        bookDetailsTable.setColumnWidth(columnModel, 3, 85); // genreColumn
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(bookDetailsTable);
        scrollPane.setBounds(50, 50, 830, 200);

        this.setBounds(200, 55, 950, 615);
        ImageIcon background = new ImageIcon("images\\background.jpg");
        JLabel img = new JLabel(background);
        img.setBounds(0, 0, 950, 615);
        this.add(img);
        this.setLayout(null);
        this.setVisible(true);
        img.add(scrollPane);

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

        TableClass memberDetailsTable = new TableClass(model2);
        JScrollPane scrollPane2 = new JScrollPane(memberDetailsTable);
        scrollPane2.setBounds(50, 310, 830, 200);
        img.add(scrollPane2);

        TableColumnModel columnModel2 = memberDetailsTable.getColumnModel();// for member details

        memberDetailsTable.setColumnWidth(columnModel2, 0, 65); // bookIdColumn
        memberDetailsTable.setColumnWidth(columnModel2, 1, 220); // nameColumn
        memberDetailsTable.setColumnWidth(columnModel2, 2, 220); // authorColumn
        memberDetailsTable.setColumnWidth(columnModel2, 3, 325); // genreColumn

        // validate();
    }

}
