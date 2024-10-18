package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class UpdateRoom extends JFrame implements ActionListener {
    Choice ccustomer, sbroom;
    RoundedButton check, update, back, sbr;
    JLabel lblcleanstatus;
    JRadioButton rbcleaned, rbdirty;
    JTextField tfroom, tfavailable;
    Reception reception;

    UpdateRoom(Reception reception) {
        this.reception = reception;
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel text = new JLabel("Update Room Status");
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        text.setBounds(90, 20, 250, 30);
        text.setForeground(new Color(181, 23, 158));
        add(text);

        JLabel lblid = new JLabel("Customer Id");
        lblid.setBounds(30, 80, 100, 20);
        add(lblid);

        ccustomer = new Choice();
        ccustomer.setBounds(200, 80, 150, 25);
        add(ccustomer);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while (rs.next()) {
                ccustomer.add(rs.getString("number"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel lblroom = new JLabel("Room Number");
        lblroom.setBounds(30, 120, 100, 20);
        add(lblroom);

        tfroom = new JTextField();
        tfroom.setBounds(200, 120, 150, 20);
        add(tfroom);

        sbroom = new Choice();
        sbroom.setBounds(30, 160, 100, 25);
        add(sbroom);
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from room");
            while (rs.next()) {
                sbroom.add(rs.getString("roomnumber"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JLabel lblavailable = new JLabel("Availability");
        lblavailable.setBounds(30, 200, 100, 20);
        add(lblavailable);

        tfavailable = new JTextField();
        tfavailable.setBounds(200, 200, 150, 20);
        add(tfavailable);

        JLabel lblcleanStatus = new JLabel("Cleaning Status");
        lblcleanStatus.setBounds(30, 240, 150, 20);
        add(lblcleanStatus);

        lblcleanstatus = new JLabel();
        lblcleanstatus.setBounds(200, 240, 150, 20);
        add(lblcleanstatus);

        JLabel lblcurrStatus = new JLabel("Current Status");
        lblcurrStatus.setBounds(30, 280, 150, 20);
        add(lblcurrStatus);

        rbcleaned = new JRadioButton("Cleaned");
        rbcleaned.setBounds(200, 280, 80, 30);
        rbcleaned.setFont(new Font("Tahoma", Font.PLAIN, 14));
        rbcleaned.setBackground(Color.WHITE);
        add(rbcleaned);

        rbdirty = new JRadioButton("Dirty");
        rbdirty.setBounds(280, 280, 70, 30);
        rbdirty.setFont(new Font("Tahoma", Font.PLAIN, 14));
        rbdirty.setBackground(Color.WHITE);
        add(rbdirty);

        ButtonGroup bj = new ButtonGroup();
        bj.add(rbcleaned);
        bj.add(rbdirty);

        sbr = new RoundedButton("Srch By Room ");
        sbr.setBackground(new Color(82, 76, 66));
        sbr.setForeground(Color.yellow);
        sbr.setBounds(200, 160, 150, 25);
        sbr.addActionListener(this);
        add(sbr);

        check = new RoundedButton("CHECK");
        check.setBackground(new Color(82, 76, 66));
        check.setForeground(Color.yellow);
        check.setBounds(30, 320, 100, 30);
        check.addActionListener(this);
        add(check);

        update = new RoundedButton("UPDATE");
        update.setBackground(new Color(82, 76, 66));
        update.setForeground(Color.yellow);
        update.setBounds(160, 320, 100, 30);
        update.addActionListener(this);
        add(update);

        back = new RoundedButton("BACK");
        back.setBackground(new Color(82, 76, 66));
        back.setForeground(Color.yellow);
        back.setBounds(290, 320, 100, 30);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 50, 500, 300);
        add(image);

        setBounds(300, 200, 980, 450);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == check) {
            String id = ccustomer.getSelectedItem();

            try {
                Conn c = new Conn();
                String query = "select * from customer where number = '" + id + "'";
                ResultSet rs = c.s.executeQuery(query);

                if (rs.next()) {
                    tfroom.setText(rs.getString("room"));
                }

                ResultSet rs2 = c.s.executeQuery("select * from room where roomnumber='" + tfroom.getText() + "'");
                if (rs2.next()) {
                    tfavailable.setText(rs2.getString("availability"));
                    lblcleanstatus.setText(rs2.getString("cleaning_status"));
                }
		JOptionPane.showMessageDialog(null, "Searching by customer id while ignoring search by room option");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == sbr) {
            String rn = sbroom.getSelectedItem();
            try {
                Conn c = new Conn();
                String query = "select * from room where roomnumber='" + rn + "'";
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()) {
                    tfroom.setText(rn); // Set the room number text field
                    tfavailable.setText(rs.getString("availability"));
                    lblcleanstatus.setText(rs.getString("cleaning_status"));
                } else {
                    tfroom.setText(rn); // Set the room number text field
                    tfavailable.setText("");
                    lblcleanstatus.setText("");
                }
		JOptionPane.showMessageDialog(null, "Searching by search by room option while ignoring customer id");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == update) {
            String room;
            if (tfroom.getText() != null && !tfroom.getText().isEmpty()) {
                room = tfroom.getText();
            } else {
                room = sbroom.getSelectedItem();
            }
            String available = tfavailable.getText();
            String cleanstatus = null;
            if (rbcleaned.isSelected()) {
                cleanstatus = "Cleaned";
            } else if (rbdirty.isSelected()) {
                cleanstatus = "Dirty";
            }

            try {
                Conn c = new Conn();
                c.s.executeUpdate("update room set availability ='" + available + "', cleaning_status='" + cleanstatus + "' where roomnumber = '" + room + "'");
                JOptionPane.showMessageDialog(null, "Customer Room Data Updated Successfully");
		int choice = JOptionPane.showConfirmDialog(null, "Do you want to Change the status of another Room?", "Change Another room status", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    setVisible(false);
                    new UpdateRoom(reception);
                } else if (choice == JOptionPane.NO_OPTION) {
                    dispose();
                    reception.setVisible(true);
                }
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
        new UpdateRoom(reception);
    }
}
