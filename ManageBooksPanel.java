import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class TextField extends JTextField {
    TextField() {
        this.setFont(new Font("Arial", Font.PLAIN, 17));
        this.setVisible(true);
    }
}

class BookIdTextField extends TextField {
    BookIdTextField() {
        this.setBounds(50, 70, 350, 30);
    }
}

class BookIdLabel extends JLabel {
    BookIdLabel() {
        this.setText("Book ID");
        this.setBounds(50, 40, 200, 30);
        this.setFont(new Font("Arial", Font.PLAIN, 16));
    }
}

public class ManageBooksPanel extends JPanel {
    BookIdLabel searchLabel = new BookIdLabel();
    BookIdTextField bookIdTextField = new BookIdTextField();

    ManageBooksPanel() {
        this.setBounds(200, 55, 950, 615);
        ImageIcon background = new ImageIcon("background.jpg");
        JLabel img = new JLabel(background);
        img.setBounds(0, 0, 950, 615);
        this.setLayout(null);
        this.add(img);
        img.add(searchLabel);
        img.add(bookIdTextField);
        this.setVisible(false);
    }
}
