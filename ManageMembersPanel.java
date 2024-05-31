import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;

public class ManageMembersPanel extends JPanel {
    // ___________________LABEL_____________________________
    Label memberIdLabel = new Label("Member Id", 50, 80, 200, 30);
    Label memberFirstNameLabel = new Label("First Name", 500, 80, 200, 30);
    Label memberLastNameLabel = new Label("Last Name", 50, 160, 200, 30);
    Label memberEmailLabel = new Label("Email", 500, 160, 200, 30);
    // __________________TEXTFIELD___________________________
    TextField searchTextField1 = new TextField(50, 40, 230, 30);
    TextField memberIdTextField = new TextField(50, 110, 350, 30);
    TextField memberFirstNameTextField = new TextField(500, 110, 350, 30);
    TextField memberLastNameTextField = new TextField(50, 190, 350, 30);
    TextField memberEmailTextField = new TextField(500, 190, 350, 30);

    // ____________________BUTTON_____________________________
    ManageBooksPanelButton searchButton1 = new ManageBooksPanelButton("icons\\search.png", "Search", 285, 40, 115, 29);
    ManageBooksPanelButton updateButton1 = new ManageBooksPanelButton("icons\\update.png", "Update", 150, 260, 170, 40);
    ManageBooksPanelButton deleteButton1 = new ManageBooksPanelButton("icons\\delete.png", "Delete", 368, 260, 170, 40);
    ManageBooksPanelButton clearButton1 = new ManageBooksPanelButton("icons\\clear.png", "Clear", 578, 260, 170, 40);

    ManageMembersPanel() {
        Object[][] data2 = { { 1, "Vinayak", "Shrestha", "vinayak@gmail.com" },
                { 2, "Sagar", "Lama", "imgay@gmail.com" },
                { 3, "Ronak", "Prajapati", "gwara@gmail.com" }, { 2, "hello", "vinayak", "horror" },
                { 2, "hello", "vinayak", "horror" }, { 2, "hello", "vinayak", "horror" },
                { 2, "hello", "vinayak", "horror" }, { 2, "hello", "vinayak", "horror" },
                { 2, "hello", "vinayak", "horror" }, { 2, "hello", "vinayak", "horror" } };
        String[] str2 = { "Member-Id", "First-Name", "Last-Name", "e-mail" };
        DefaultTableModel model3 = new DefaultTableModel(data2, str2) {
            @Override // to make cells non-editable
            public boolean isCellEditable(int row, int column) {
                return false; // All cells are non-editable
            }
        };
        TableClass memberDetailsTable2 = new TableClass(model3);
        TableColumnModel columnModel3 = memberDetailsTable2.getColumnModel();// for member details

        memberDetailsTable2.setColumnWidth(columnModel3, 0, 65); // bookIdColumn
        memberDetailsTable2.setColumnWidth(columnModel3, 1, 220); // nameColumn
        memberDetailsTable2.setColumnWidth(columnModel3, 2, 220); // authorColumn
        memberDetailsTable2.setColumnWidth(columnModel3, 3, 325); // genreColumn

        JScrollPane scrollPane3 = new JScrollPane(memberDetailsTable2);
        scrollPane3.setBounds(50, 350, 830, 200);
        scrollPane3.setViewportView(memberDetailsTable2);

        // _______________SEARCH TEXTFIELD_______________
        TableRowSorter<DefaultTableModel> rowSorter = new TableRowSorter<>(model3);
        memberDetailsTable2.setRowSorter(rowSorter);

        searchTextField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String text = searchTextField1.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text, 1, 2));
                }
            }
        });

        searchButton1.setBackground(new Color(0, 0, 0));
        updateButton1.setBackground(new Color(0x155387));
        deleteButton1.setBackground(new Color(0x942e2e));
        this.setBounds(200, 55, 950, 615);
        ImageIcon background1 = new ImageIcon("background.jpg");
        JLabel img1 = new JLabel(background1);

        JLabel memberDetailsLabel = new JLabel("Member Details");
        memberDetailsLabel.setFont(new Font("Arial", Font.BOLD, 16));
        memberDetailsLabel.setForeground(Color.BLACK);
        memberDetailsLabel.setBounds(50, 320, 200, 30);
        img1.setBounds(0, 0, 950, 615);
        this.setLayout(null);
        this.add(img1);
        img1.add(searchTextField1);
        img1.add(memberIdTextField);
        img1.add(memberEmailTextField);
        img1.add(memberFirstNameTextField);
        img1.add(memberLastNameTextField);
        img1.add(searchButton1);
        img1.add(updateButton1);
        img1.add(deleteButton1);
        img1.add(clearButton1);
        img1.add(memberIdLabel);
        img1.add(memberEmailLabel);
        img1.add(memberFirstNameLabel);
        img1.add(memberLastNameLabel);
        img1.add(memberDetailsLabel);
        img1.add(scrollPane3);

        this.setVisible(false);
    }
}
