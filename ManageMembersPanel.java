import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
        searchButton1.setBackground(new Color(0, 0, 0));
        updateButton1.setBackground(new Color(0x155387));
        deleteButton1.setBackground(new Color(0x942e2e));
        this.setBounds(200, 55, 950, 615);
        ImageIcon background1 = new ImageIcon("background.jpg");
        JLabel img1 = new JLabel(background1);
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

        this.setVisible(false);
    }
}
