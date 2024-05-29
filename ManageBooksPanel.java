import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

class TextField extends JTextField {
    TextField(int x, int y, int width, int height) {
        this.setBounds(x, y, width, height);
        this.setFont(new Font("Arial", Font.PLAIN, 17));
        this.setVisible(true);
    }
}

class Label extends JLabel {
    Label(String text, int x, int y, int width, int height) {
        this.setText(text);
        this.setBounds(x, y, width, height);
        this.setFont(new Font("Arial", Font.PLAIN, 16));
    }
}

class ManageBooksPanelButton extends JButton {
    ManageBooksPanelButton(String image, String text, int x, int y, int width, int height) {
        ImageIcon img = new ImageIcon(image);
        this.setBackground(new Color(0x348734));
        this.setForeground(new Color(255, 255, 255));
        this.setFocusable(false);
        this.setFont(new Font("Arial", Font.PLAIN, 15));
        this.setBorderPainted(false);
        this.setBounds(x, y, width, height);
        this.setText(text);
        this.setLayout(null);
        this.setIconTextGap(-2);
        this.setIcon(img);
    }
}

public class ManageBooksPanel extends JPanel {
    // ___________________LABEL_____________________________
    Label bookIdLabel = new Label("Book Id", 50, 40, 200, 30);
    Label bookNameLabel = new Label("Name", 500, 40, 200, 30);
    Label bookAuthorLabel = new Label("Author", 50, 120, 200, 30);
    Label bookGenreLabel = new Label("Genre", 500, 120, 200, 30);
    // __________________TEXTFIELD___________________________
    TextField bookIdTextField = new TextField(50, 70, 350, 30);
    TextField bookNameTextField = new TextField(500, 70, 350, 30);
    TextField bookAuthorTextField = new TextField(50, 150, 350, 30);
    TextField bookGenreTextField = new TextField(500, 150, 350, 30);

    // ____________________BUTTON_____________________________
    ManageBooksPanelButton addButton = new ManageBooksPanelButton("add.png", "Add", 50, 250, 170, 40);
    ManageBooksPanelButton updateButton = new ManageBooksPanelButton("update.png", "Update", 258, 250, 170, 40);
    ManageBooksPanelButton deleteButton = new ManageBooksPanelButton("delete.png", "Delete", 468, 250, 170, 40);
    ManageBooksPanelButton clearButton = new ManageBooksPanelButton("clear.png", "Clear", 678, 250, 170, 40);

    ManageBooksPanel() {
        Object[][] data = { { 1, "How to become a Sigma", "Vinayak Shrestha", "Guide" },
                { 2, "I Am Gay", "Sagar Lama", "Biography" },
                { 3, "Gwara the goat", "Ronak Prajapati", "Fantasy" }, { 2, "hello", "vinayak", "horror" },
                { 2, "hello", "vinayak", "horror" }, { 2, "hello", "vinayak", "horror" },
                { 2, "hello", "vinayak", "horror" },
                { 2, "hello", "vinayak", "horror" },
                { 2, "hello", "vinayak", "horror" }, { 2, "hello", "vinayak", "horror" } };
        String[] str = { "Book-Id", "Name", "Author", "Genre" };
        DefaultTableModel model2 = new DefaultTableModel(data, str) {
            @Override // to make cells non-editable
            public boolean isCellEditable(int row, int column) {
                return false; // All cells are non-editable
            }
        };

        TableClass bookDetailsTable2 = new TableClass(model2);
        TableColumnModel columnModel = bookDetailsTable2.getColumnModel();
        bookDetailsTable2.setColumnWidth(columnModel, 0, 55); // bookIdColumn
        bookDetailsTable2.setColumnWidth(columnModel, 1, 395); // nameColumn
        bookDetailsTable2.setColumnWidth(columnModel, 2, 295); // authorColumn
        bookDetailsTable2.setColumnWidth(columnModel, 3, 85); // genreColumn
        JScrollPane scrollPane2 = new JScrollPane();
        scrollPane2.setViewportView(bookDetailsTable2);

        // ______________ADD BUTTON____________________
        addButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (bookIdTextField.getText().toString().isEmpty() ||
                        bookNameTextField.getText().toString().isEmpty()
                        || bookAuthorTextField.getText().toString().isEmpty()
                        || bookGenreTextField.getText().toString().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all the text fields",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                } else {

                    int bookId = Integer.parseInt(bookIdTextField.getText().toString());
                    String bookName = bookNameTextField.getText().toString();
                    String bookAuthor = bookAuthorTextField.getText().toString();
                    String bookGenre = bookGenreTextField.getText().toString();

                    Object[] newRow = { bookId, bookName, bookAuthor, bookGenre };
                    model2.addRow(newRow);

                    bookIdTextField.setText(null);
                    bookNameTextField.setText(null);
                    bookAuthorTextField.setText(null);
                    bookGenreTextField.setText(null);
                    JOptionPane.showMessageDialog(null, "Book added successfully",
                            "Information",
                            JOptionPane.INFORMATION_MESSAGE);
                }

            }
        });

        // ____________________UPDATE BUTTON__________________________
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (bookIdTextField.getText().toString().isEmpty() ||
                        bookNameTextField.getText().toString().isEmpty()
                        || bookAuthorTextField.getText().toString().isEmpty()
                        || bookGenreTextField.getText().toString().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all the text fields",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                } else {

                    int bookId = Integer.parseInt(bookIdTextField.getText().toString());
                    String bookName = bookNameTextField.getText().toString();
                    String bookAuthor = bookAuthorTextField.getText().toString();
                    String bookGenre = bookGenreTextField.getText().toString();

                    int row = bookDetailsTable2.getSelectedRow();
                    model2.setValueAt(bookId, row, 0);
                    model2.setValueAt(bookName, row, 1);
                    model2.setValueAt(bookAuthor, row, 2);
                    model2.setValueAt(bookGenre, row, 3);

                    bookIdTextField.setText(null);
                    bookNameTextField.setText(null);
                    bookAuthorTextField.setText(null);
                    bookGenreTextField.setText(null);
                    JOptionPane.showMessageDialog(null, "Book updated successfully",
                            "Information",
                            JOptionPane.INFORMATION_MESSAGE);
                }

            }
        });
        // ________________CLEAR BUTTON________________________
        clearButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                bookIdTextField.setText(null);
                bookNameTextField.setText(null);
                bookAuthorTextField.setText(null);
                bookGenreTextField.setText(null);
            }

        });

        bookDetailsTable2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // int rowIndex = bookDetailsTable2.getSelectedRow();
                int rowIndex = bookDetailsTable2.getSelectedRow();
                int bookId = (int) model2.getValueAt(rowIndex, 0);
                String bookName = (String) model2.getValueAt(rowIndex, 1);
                String bookAuthor = (String) model2.getValueAt(rowIndex, 2);
                String bookGenre = (String) model2.getValueAt(rowIndex, 3);

                bookIdTextField.setText(String.valueOf(bookId));
                bookNameTextField.setText(bookName);
                bookAuthorTextField.setText(bookAuthor);
                bookGenreTextField.setText(bookGenre);

            }
        });

        scrollPane2.setBounds(50, 350, 830, 200);
        updateButton.setBackground(new Color(0x155387));
        deleteButton.setBackground(new Color(0x942e2e));
        this.setBounds(200, 55, 950, 615);
        ImageIcon background = new ImageIcon("background.jpg");
        JLabel img = new JLabel(background);
        img.setBounds(0, 0, 950, 615);
        this.setLayout(null);
        this.add(img);
        JLabel bookDetailsLabel = new JLabel("Book Details");
        bookDetailsLabel.setFont(new Font("Arial", Font.BOLD, 16));
        bookDetailsLabel.setForeground(Color.BLACK);
        bookDetailsLabel.setBounds(50, 320, 200, 30);
        img.add(bookDetailsLabel);
        img.add(bookIdLabel);
        img.add(bookIdTextField);
        img.add(bookNameTextField);
        img.add(bookNameLabel);
        img.add(bookAuthorLabel);
        img.add(bookGenreLabel);
        img.add(bookAuthorTextField);
        img.add(bookGenreTextField);
        img.add(addButton);
        img.add(updateButton);
        img.add(deleteButton);
        img.add(clearButton);
        img.add(scrollPane2);
        this.setVisible(false);
    }
}
