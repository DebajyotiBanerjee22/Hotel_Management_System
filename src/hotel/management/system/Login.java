package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JTextField username, password;
    RoundedButton login, cancel,forgotpass;
    Dashboard dashboard;

    Login(Dashboard dashboard) {
        this.dashboard = dashboard;

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel user = new JLabel("Username");
        user.setBounds(40, 20, 100, 30);
        add(user);

        JLabel pass = new JLabel("Password");
        pass.setBounds(40, 70, 100, 30);
        add(pass);

        username = new JTextField();
        username.setBounds(150, 20, 150, 30);
        add(username);

        password = new JTextField();
        password.setBounds(150, 70, 150, 30);
        add(password);

        login = new RoundedButton("Login");
        login.setBounds(40, 150, 120, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.YELLOW);
        login.addActionListener(this);
        add(login);

        cancel = new RoundedButton("Cancel");
        cancel.setBounds(180, 150, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.YELLOW);
        cancel.addActionListener(this);
        add(cancel);
	
	forgotpass = new RoundedButton("Forget Password");
        forgotpass.setBounds(90, 200, 160, 30);
        forgotpass.setBackground(Color.BLACK);
        forgotpass.setForeground(Color.YELLOW);
        forgotpass.addActionListener(this);
        add(forgotpass);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 10, 200, 200);
        add(image);

        setBounds(500, 200, 600, 300);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            String user = username.getText();
            String pass = password.getText();
            try {
                Conn c = new Conn();

                String query = "select * from login where username = '" + user + "' and password = '" + pass + "'";
                ResultSet rs = c.s.executeQuery(query);

                if (rs.next()) {
                    dispose();
                    new Admin(dashboard);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                    dispose();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
            dashboard.setVisible(true);
        }else if(ae.getSource()== forgotpass){
		JOptionPane.showMessageDialog(null, "Feature under development");
                dispose();
	}
    }

    public static void main(String[] args) {
        new Login(new Dashboard());
    }
}
