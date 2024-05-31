import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;

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
    Label bookIdLabel = new Label("Book Id", 50, 80, 200, 30);
    Label bookNameLabel = new Label("Name", 500, 80, 200, 30);
    Label bookAuthorLabel = new Label("Author", 50, 160, 200, 30);
    Label bookGenreLabel = new Label("Genre", 500, 160, 200, 30);
    // __________________TEXTFIELD___________________________
    TextField searchTextField = new TextField(50, 40, 230, 30);
    TextField bookIdTextField = new TextField(50, 110, 350, 30);
    TextField bookNameTextField = new TextField(500, 110, 350, 30);
    TextField bookAuthorTextField = new TextField(50, 190, 350, 30);
    TextField bookGenreTextField = new TextField(500, 190, 350, 30);

    // ____________________BUTTON_____________________________
    ManageBooksPanelButton searchButton = new ManageBooksPanelButton("icons\\search.png", "Search", 285, 40, 115, 29);
    ManageBooksPanelButton addButton = new ManageBooksPanelButton("icons\\add.png", "Add", 50, 260, 170, 40);
    ManageBooksPanelButton updateButton = new ManageBooksPanelButton("icons\\update.png", "Update", 258, 260, 170, 40);
    ManageBooksPanelButton deleteButton = new ManageBooksPanelButton("icons\\delete.png", "Delete", 468, 260, 170, 40);
    ManageBooksPanelButton clearButton = new ManageBooksPanelButton("icons\\clear.png", "Clear", 678, 260, 170, 40);

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

        // _______________SEARCH TEXTFIELD_______________
        TableRowSorter<DefaultTableModel> rowSorter = new TableRowSorter<>(model2);
        bookDetailsTable2.setRowSorter(rowSorter);

        searchTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String text = searchTextField.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text, 1));
                }
            }
        });
        // ______________ADD BUTTON____________________
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (bookIdTextField.getText().toString().isEmpty() ||
                        bookNameTextField.getText().toString().isEmpty() ||
                        bookAuthorTextField.getText().toString().isEmpty() ||
                        bookGenreTextField.getText().toString().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all the text fields",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    try {
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
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Book ID must be an integer",
                                "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        // ____________________UPDATE BUTTON__________________________
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (bookDetailsTable2.getSelectedRow() == -1) {
                    JOptionPane.showMessageDialog(null, "Please select a book to update",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                } else {
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

                        // Get the selected row index from the view
                        int viewRowIndex = bookDetailsTable2.getSelectedRow();

                        // Check if a row is selected
                        if (viewRowIndex != -1) {
                            // Convert the view row index to the model row index
                            int modelRowIndex = bookDetailsTable2.convertRowIndexToModel(viewRowIndex);

                            // Update the row in the model using the model row index
                            model2.setValueAt(bookId, modelRowIndex, 0);
                            model2.setValueAt(bookName, modelRowIndex, 1);
                            model2.setValueAt(bookAuthor, modelRowIndex, 2);
                            model2.setValueAt(bookGenre, modelRowIndex, 3);

                            bookIdTextField.setText(null);
                            bookNameTextField.setText(null);
                            bookAuthorTextField.setText(null);
                            bookGenreTextField.setText(null);
                            JOptionPane.showMessageDialog(null, "Book updated successfully",
                                    "Information",
                                    JOptionPane.INFORMATION_MESSAGE);
                            bookDetailsTable2.clearSelection();
                        }
                    }
                }
            }
        });

        // _________________DELETE BUTTON_________________________
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (bookDetailsTable2.getSelectedRow() == -1) {
                    JOptionPane.showMessageDialog(null, "Please select a book to delete", "Error",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    int selection = JOptionPane.showConfirmDialog(null, "Do you want to delete this book?", "Confirm",
                            JOptionPane.YES_NO_OPTION);
                    if (selection == JOptionPane.YES_OPTION) {
                        // Get the selected row index from the view
                        int viewRowIndex = bookDetailsTable2.getSelectedRow();

                        // Convert the view row index to the model row index
                        int modelRowIndex = bookDetailsTable2.convertRowIndexToModel(viewRowIndex);

                        // Delete the row in the model using the model row index
                        model2.removeRow(modelRowIndex);

                        JOptionPane.showMessageDialog(null, "Book deleted successfully!", "Message",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
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
                bookDetailsTable2.clearSelection();
            }

        });

        bookDetailsTable2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Get the selected row index from the view
                int viewRowIndex = bookDetailsTable2.getSelectedRow();

                // Convert the view row index to the model row index
                int modelRowIndex = bookDetailsTable2.convertRowIndexToModel(viewRowIndex);

                // Get the data from the model using the model row index
                int bookId = (int) model2.getValueAt(modelRowIndex, 0);
                String bookName = (String) model2.getValueAt(modelRowIndex, 1);
                String bookAuthor = (String) model2.getValueAt(modelRowIndex, 2);
                String bookGenre = (String) model2.getValueAt(modelRowIndex, 3);

                // Set the data to the text fields
                bookIdTextField.setText(String.valueOf(bookId));
                bookNameTextField.setText(bookName);
                bookAuthorTextField.setText(bookAuthor);
                bookGenreTextField.setText(bookGenre);
            }
        });

        scrollPane2.setBounds(50, 350, 830, 200);
        searchButton.setBackground(new Color(0, 0, 0));
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
        img.add(searchTextField);
        img.add(bookIdTextField);
        img.add(bookNameTextField);
        img.add(bookNameLabel);
        img.add(bookAuthorLabel);
        img.add(bookGenreLabel);
        img.add(bookAuthorTextField);
        img.add(bookGenreTextField);
        img.add(searchButton);
        img.add(addButton);
        img.add(updateButton);
        img.add(deleteButton);
        img.add(clearButton);
        img.add(scrollPane2);
        this.setVisible(false);
    }
}
