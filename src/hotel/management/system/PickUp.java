package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.sql.*;
import net.proteanit.sql.*;
import java.awt.event.*;

public class PickUp extends JFrame implements ActionListener {
    Choice cartype;
    RoundedButton back, submit, shwall;
    JTable table;
    Reception reception;
    PickUp(Reception reception) {
	this.reception = reception;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel sfd = new JLabel("Pickup Service");
        sfd.setFont(new Font("Tahoma", Font.BOLD, 20));
        sfd.setBounds(400, 30, 200, 30);
        sfd.setForeground((Color.RED));
        add(sfd);

        JLabel lblctype = new JLabel("Car Type");
        lblctype.setBounds(50, 100, 100, 20);
        add(lblctype);

        cartype = new Choice();
        cartype.setBounds(150, 100, 150, 25);
        add(cartype);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from driver");
            while (rs.next()) {
                cartype.add(rs.getString("model"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel l1 = new JLabel("Name");
        l1.setBounds(40, 160, 100, 20);
        l1.setForeground((Color.BLUE));
        add(l1);
        JLabel l2 = new JLabel("Age");
        l2.setBounds(170, 160, 100, 20);
        l2.setForeground((Color.BLUE));
        add(l2);
        JLabel l3 = new JLabel("Gender");
        l3.setBounds(290, 160, 100, 20);
        l3.setForeground((Color.BLUE));
        add(l3);
        JLabel l4 = new JLabel("Brand");
        l4.setBounds(420, 160, 100, 20);
        l4.setForeground((Color.BLUE));
        add(l4);
        JLabel l5 = new JLabel("Model");
        l5.setBounds(540, 160, 100, 20);
        l5.setForeground((Color.BLUE));
        add(l5);
        JLabel l6 = new JLabel("Availability");
        l6.setBounds(660, 160, 100, 20);
        l6.setForeground((Color.BLUE));
        add(l6);
        JLabel l7 = new JLabel("Location");
        l7.setBounds(780, 160, 100, 20);
        l7.setForeground((Color.BLUE));
        add(l7);
        JLabel l8 = new JLabel("VIN");
        l8.setBounds(900, 160, 100, 20);
        l8.setForeground((Color.BLUE));
        add(l8);

        table = new JTable();
        table.setBounds(0, 200, 1000, 300);
        add(table);

        submit = new RoundedButton("SUBMIT");
        submit.setBackground(new Color(82, 76, 66));
        submit.setForeground(Color.YELLOW);
        submit.setBounds(250, 520, 120, 30);
        submit.addActionListener(this);
        add(submit);

        back = new RoundedButton("BACK");
        back.setBackground(new Color(82, 76, 66));
        back.setForeground(Color.YELLOW);
        back.setBounds(450, 520, 120, 30);
        back.addActionListener(this);
        add(back);

        shwall = new RoundedButton("All drivers");
        shwall.setBackground(new Color(82, 76, 66));
        shwall.setForeground(Color.YELLOW);
        shwall.setBounds(650, 520, 120, 30);
        shwall.addActionListener(this);
        add(shwall);

        setBounds(300, 200, 1000, 600);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            try {
                Conn c = new Conn();
                String selectedModel = cartype.getSelectedItem();
                String q1 = "select * from driver where model ='" + selectedModel + "'";
                ResultSet rs = c.s.executeQuery(q1);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == shwall) {
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from driver");
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            dispose();
            reception.setVisible(true);
        }
    }

    public static void main(String[] args) {
	    Reception reception = new Reception();
	    new PickUp(reception);
    }
}
