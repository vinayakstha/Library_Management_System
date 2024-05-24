import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
        updateButton.setBackground(new Color(0x155387));
        deleteButton.setBackground(new Color(0x942e2e));
        this.setBounds(200, 55, 950, 615);
        ImageIcon background = new ImageIcon("background.jpg");
        JLabel img = new JLabel(background);
        img.setBounds(0, 0, 950, 615);
        this.setLayout(null);
        this.add(img);
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
        this.setVisible(false);
    }
}
