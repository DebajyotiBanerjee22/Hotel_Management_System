package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {
    Dashboard() {
        setLayout(null);
        setBounds(0, 0, 1920, 1080);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1550, 1000);
        add(image);

        JLabel text = new JLabel("THE ROYAL PALACE WELCOMES YOU");
        text.setBounds(360, 80, 1000, 45);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("TAHOMA", Font.BOLD, 50));
        image.add(text);

        JMenuBar mb = new JMenuBar();
        mb.setBounds(0, 0, 1538, 30);
        image.add(mb);

        JMenu hotel = new JMenu("HOTEL MANAGEMENT");
        hotel.setForeground(Color.RED);
        mb.add(hotel);

        JMenuItem reception = new JMenuItem("RECEPTION");
        reception.addActionListener(this);
        hotel.add(reception);

        JMenu admin = new JMenu("ADMIN");
        admin.setForeground(Color.BLUE);
        mb.add(admin);

        JMenuItem login = new JMenuItem("LOGIN");
        login.addActionListener(this);
        admin.add(login);

        JMenu logoutMenu = new JMenu("CLOSE");
        logoutMenu.setForeground(Color.RED);
        logoutMenu.setBounds(900, 0, 70, 10);
        mb.add(Box.createHorizontalGlue());
        mb.add(logoutMenu);

        JMenuItem logout = new JMenuItem("CLOSE");
        logout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to close the session?", "Close", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, "Session closed successfully!");
                    System.exit(0);
                }
            }
        });
        logoutMenu.add(logout);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("LOGIN")) {
            new Login(this);
        } else if (ae.getActionCommand().equals("RECEPTION")) {
            new Reception(this);
        }
    }

    public static void main(String[] args) {
        new Dashboard();
    }
}
