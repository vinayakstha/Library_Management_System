import java.awt.Font;

import javax.swing.ImageIcon;
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

public class ManageBooksPanel extends JPanel {
    // -----------------LABEL--------------------------
    Label bookIdLabel = new Label("Book Id", 50, 40, 200, 30);
    Label bookNameLabel = new Label("Name", 500, 40, 200, 30);
    Label bookAuthorLabel = new Label("Author", 50, 120, 200, 30);
    Label bookGenreLabel = new Label("Genre", 500, 120, 200, 30);
    // ------------------TEXTFIELD--------------------------
    TextField bookIdTextField = new TextField(50, 70, 350, 30);
    TextField bookNameTextField = new TextField(500, 70, 350, 30);
    TextField bookAuthorTextField = new TextField(50, 150, 350, 30);
    TextField bookGenreTextField = new TextField(500, 150, 350, 30);

    ManageBooksPanel() {
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
        this.setVisible(false);
    }
}
