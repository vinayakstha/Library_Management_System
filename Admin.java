import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class SidePanelButton extends JButton {
    SidePanelButton(String image, String text, int x, int y, int width, int height) {
        this.setBackground(new Color(0x1d1d1f));
        this.setForeground(new Color(255, 255, 255));
        this.setFocusable(false);
        this.setFont(new Font("Arial", Font.PLAIN, 12));
        this.setBorderPainted(false);
        ImageIcon icon = new ImageIcon(image);
        this.setIcon(icon);
        this.setText(text);
        this.setBounds(x, y, width, height);
    }
}

class TopPanel extends JPanel {
    TopPanel() {
        ImageIcon logoImage = new ImageIcon("logo2.png");
        JLabel label = new JLabel(logoImage);
        label.setBounds(1, 3, 50, 50);

        ImageIcon accountImage = new ImageIcon("icons\\account.png");
        JLabel label2 = new JLabel(accountImage);
        label2.setBounds(980, 3, 50, 50);

        JLabel title = new JLabel("Nanathari Library");
        title.setBounds(60, 14, 200, 30);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setForeground(Color.WHITE);

        JLabel adminLabel = new JLabel("Admin");
        adminLabel.setBounds(1025, 14, 150, 30);
        adminLabel.setFont(new Font("Arial", Font.BOLD, 20));
        adminLabel.setForeground(Color.WHITE);

        this.add(label);
        this.add(label2);
        this.add(adminLabel);
        this.add(title);
        this.setLayout(null);
        this.setBounds(0, 0, 1150, 55);
        this.setBackground(new Color(0x42a5f5));// 0x03a3a6
    }
}

class SidePanel extends JPanel implements ActionListener {
    // buttons
    SidePanelButton b1 = new SidePanelButton("icons\\homeIcon.png", "home", 15, 20, 170, 40);
    SidePanelButton b2 = new SidePanelButton("icons\\manageBooksIcon.png", "Manage Books", 15, 70, 170, 40);
    SidePanelButton b3 = new SidePanelButton("icons\\manageMembersIcon.png", "Manage Members", 15, 120, 170, 40);
    SidePanelButton b4 = new SidePanelButton("icons\\issueBooksIcon.png", "Issue Books", 15, 170, 170, 40);
    SidePanelButton b5 = new SidePanelButton("icons\\logoutIcon.png", "Logout", 15, 520, 170, 40);

    // panels
    // HomePanel p1 = new HomePanel();
    // ManageBooksPanel p2 = new ManageBooksPanel();

    SidePanel() {
        b1.setBackground(new Color(0x37383b));
        b1.setIconTextGap(-2);
        b5.setBackground(new Color(0x42a5f5));
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
            MyFrame.homePanel.setVisible(true);
            MyFrame.manageBooksPanel.setVisible(false);
            MyFrame.manageMembersPanel.setVisible(false);
        } else if (e.getSource() == b2) {
            b2.setBackground(new Color(0x37383b));
            b1.setBackground(new Color(0x1d1d1f));
            b3.setBackground(new Color(0x1d1d1f));
            b4.setBackground(new Color(0x1d1d1f));
            MyFrame.homePanel.setVisible(false);
            MyFrame.manageBooksPanel.setVisible(true);
            MyFrame.manageMembersPanel.setVisible(false);
        } else if (e.getSource() == b3) {
            b3.setBackground(new Color(0x37383b));
            b1.setBackground(new Color(0x1d1d1f));
            b2.setBackground(new Color(0x1d1d1f));
            b4.setBackground(new Color(0x1d1d1f));
            MyFrame.homePanel.setVisible(false);
            MyFrame.manageBooksPanel.setVisible(false);
            MyFrame.manageMembersPanel.setVisible(true);
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
    static HomePanel homePanel = new HomePanel();
    static ManageBooksPanel manageBooksPanel = new ManageBooksPanel();
    static ManageMembersPanel manageMembersPanel = new ManageMembersPanel();

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
        this.add(manageBooksPanel);
        this.add(manageMembersPanel);
    }
}

public class Admin {
    public static void main(String[] args) {
        new MyFrame();
    }
}