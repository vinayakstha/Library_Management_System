import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class Button extends JButton {
    Button() {
        this.setBackground(new Color(0x1d1d1f));
        this.setForeground(new Color(255, 255, 255));
        this.setFocusable(false);
        this.setFont(new Font("Arial", Font.PLAIN, 12));
        this.setBorderPainted(false);
    }
}

class HomeButton extends Button {
    ImageIcon homeIcon = new ImageIcon("homeIcon.png");

    HomeButton() {
        this.setBounds(15, 20, 170, 40);
        this.setBackground(new Color(0x37383b));
        this.setText("Home");
        this.setLayout(null);
        this.setIconTextGap(-2);
        this.setIcon(homeIcon);
    }
}

class ManageBooksButton extends Button {
    ImageIcon manageBookIcon = new ImageIcon("ManageBooksIcon.png");

    ManageBooksButton() {
        this.setBounds(15, 70, 170, 40);
        this.setText("Manage Books");
        this.setIcon(manageBookIcon);
    }
}

class ManageMembersButton extends Button {
    ImageIcon manangeMembersIcon = new ImageIcon("manageMembersIcon.png");

    ManageMembersButton() {
        this.setBounds(15, 120, 170, 40);
        this.setText("Manage Members");
        this.setIcon(manangeMembersIcon);
    }
}

class IssueBooksButton extends Button {
    ImageIcon issueBooksIcon = new ImageIcon("issueBooksIcon.png");

    IssueBooksButton() {
        this.setBounds(15, 170, 170, 40);
        this.setText("Issue Books");
        this.setIcon(issueBooksIcon);
    }
}

class LogoutButton extends Button {
    ImageIcon logoutIcon = new ImageIcon("logoutIcon.png");

    LogoutButton() {
        this.setBounds(15, 520, 170, 40);
        this.setBackground(new Color(0x42a5f5));
        this.setText("Logout");
        this.setIcon(logoutIcon);
    }
}

class TopPanel extends JPanel {
    TopPanel() {
        ImageIcon logoImage = new ImageIcon("logo2.png");
        JLabel label = new JLabel(logoImage);
        label.setBounds(1, 3, 50, 50);
        this.add(label);
        this.setLayout(null);
        this.setBounds(0, 0, 1150, 55);
        this.setBackground(new Color(0x42a5f5));// 0x03a3a6
    }
}

class SidePanel extends JPanel implements ActionListener {
    HomeButton b1 = new HomeButton();
    ManageBooksButton b2 = new ManageBooksButton();
    ManageMembersButton b3 = new ManageMembersButton();
    IssueBooksButton b4 = new IssueBooksButton();
    LogoutButton b5 = new LogoutButton();

    SidePanel() {
        this.add(b1);
        this.add(b2);
        this.add(b3);
        this.add(b4);
        this.add(b5);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        this.setLayout(null);
        this.setBounds(0, 55, 200, 620);
        this.setBackground(new Color(0x1d1d1f));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            b1.setBackground(new Color(0x37383b));
            b2.setBackground(new Color(0x1d1d1f));
            b3.setBackground(new Color(0x1d1d1f));
            b4.setBackground(new Color(0x1d1d1f));
        } else if (e.getSource() == b2) {
            b2.setBackground(new Color(0x37383b));
            b1.setBackground(new Color(0x1d1d1f));
            b3.setBackground(new Color(0x1d1d1f));
            b4.setBackground(new Color(0x1d1d1f));
        } else if (e.getSource() == b3) {
            b3.setBackground(new Color(0x37383b));
            b1.setBackground(new Color(0x1d1d1f));
            b2.setBackground(new Color(0x1d1d1f));
            b4.setBackground(new Color(0x1d1d1f));
        } else if (e.getSource() == b4) {
            b4.setBackground(new Color(0x37383b));
            b1.setBackground(new Color(0x1d1d1f));
            b2.setBackground(new Color(0x1d1d1f));
            b3.setBackground(new Color(0x1d1d1f));
        }
    }
}

class MyFrame extends JFrame {
    SidePanel sidePanel = new SidePanel();
    TopPanel topPanel = new TopPanel();
    HomePanel homePanel = new HomePanel();

    MyFrame() {
        ImageIcon icon = new ImageIcon("logo.png");
        // ImageIcon background = new ImageIcon("background.jpg");
        // JLabel img = new JLabel(background);
        // img.setBounds(0, 0, 950, 615);
        this.setIconImage(icon.getImage());
        this.setBounds(80, 5, 1150, 670);
        this.setVisible(true);
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(sidePanel);
        this.add(topPanel);
        this.add(homePanel);
    }
}

public class AdminHome {
    public static void main(String[] args) {
        new MyFrame();
    }
}