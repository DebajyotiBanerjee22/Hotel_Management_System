package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;
import java.util.Date;

public class CheckOut extends JFrame implements ActionListener {
    Choice ccustomer;
    RoundedButton checkout, back, search;
    JLabel lblcustname, lblroomnumber, lblcheckintime, lblcheckouttime;
    Reception reception;
    CheckOut(Reception reception) {
	this.reception = reception;
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel text = new JLabel("Check Out");
        text.setBounds(100, 20, 130, 30);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(text);

        JLabel lblid = new JLabel("Check Out");
        lblid.setBounds(30, 80, 100, 30);
        add(lblid);

        ccustomer = new Choice();
        ccustomer.add(""); // Adding an empty option
        ccustomer.setBounds(150, 80, 150, 25);
        add(ccustomer);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(310, 80, 20, 20);
        add(image);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(30, 120, 100, 30);
        add(lblname);

        lblcustname = new JLabel();
        lblcustname.setBounds(150, 120, 100, 30);
        add(lblcustname);

        JLabel lblroom = new JLabel("Room Number");
        lblroom.setBounds(30, 160, 100, 30);
        add(lblroom);

        lblroomnumber = new JLabel();
        lblroomnumber.setBounds(150, 160, 100, 30);
        add(lblroomnumber);

        JLabel lblcheckin = new JLabel("Checkin Time");
        lblcheckin.setBounds(30, 200, 100, 30);
        add(lblcheckin);

        lblcheckintime = new JLabel();
        lblcheckintime.setBounds(150, 200, 100, 30);
        add(lblcheckintime);

        JLabel lblcheckout = new JLabel("Checkout Time");
        lblcheckout.setBounds(30, 240, 100, 30);
        add(lblcheckout);

        Date date = new Date();
        lblcheckouttime = new JLabel("" + date);
        lblcheckouttime.setBounds(150, 240, 100, 30);
        add(lblcheckouttime);

        search = new RoundedButton("SEARCH");
        search.setBackground(new Color(82, 76, 66));
        search.setForeground(Color.yellow);
        search.setBounds(30, 320, 120, 30);
        search.addActionListener(this);
        add(search);

        checkout = new RoundedButton("CHECKOUT");
        checkout.setBackground(new Color(82, 76, 66));
        checkout.setForeground(Color.yellow);
        checkout.setBounds(170, 320, 120, 30);
        checkout.addActionListener(this);
        add(checkout);

        back = new RoundedButton("BACK");
        back.setBackground(new Color(82, 76, 66));
        back.setForeground(Color.yellow);
        back.setBounds(310, 320, 120, 30);
        back.addActionListener(this);
        add(back);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while (rs.next()) {
                ccustomer.add(rs.getString("number"));
                lblcustname.setText(rs.getString("name"));
                lblroomnumber.setText(rs.getString("room"));
                lblcheckintime.setText(rs.getString("checkintime"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image i5 = i4.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image2 = new JLabel(i6);
        image2.setBounds(350, 50, 400, 250);
        add(image2);

        setBounds(300, 200, 800, 400);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == search) {
		    String selectedCustomer = ccustomer.getSelectedItem();
		    if (!selectedCustomer.equals("")) {
			String q1 = "select * from customer where number = '" + selectedCustomer + "'";
			try {
			    Conn c = new Conn();
			    ResultSet rs = c.s.executeQuery(q1);
			    if (rs.next()) {
				lblcustname.setText(rs.getString("name"));
				lblroomnumber.setText(rs.getString("room"));
				lblcheckintime.setText(rs.getString("checkintime"));
			    } else {
				JOptionPane.showMessageDialog(this, "Customer not found!");
				lblcustname.setText("");
				lblroomnumber.setText("");
				lblcheckintime.setText("");
			    }
			} catch (Exception e) {
			    e.printStackTrace();
			}
		    } else {
			// Clear the fields if no customer is selected
			lblcustname.setText("");
			lblroomnumber.setText("");
			lblcheckintime.setText("");
		    }
		} else if (ae.getSource() == checkout) {
		    String selectedCustomer = ccustomer.getSelectedItem();
		    if (!selectedCustomer.equals("")) {
			String q1 = "delete from customer where number = '" + selectedCustomer + "'";
			String q2 = "update room set availability = 'Available' where roomnumber = '" + lblroomnumber.getText() + "'";
			String q3 = "update room set cleaning_status = 'Dirty' where roomnumber = '" + lblroomnumber.getText() + "'";
			try {
			    Conn c = new Conn();
			    c.s.executeUpdate(q1);
			    c.s.executeUpdate(q2);
			    c.s.executeUpdate(q3);
			    JOptionPane.showMessageDialog(null, "Successfully Checked Out");
			    setVisible(false);
			    new Reception();
			} catch (Exception e) {
			    e.printStackTrace();
			}
		    } else {
			JOptionPane.showMessageDialog(this, "Please select a customer first!");
		    }
		} else {
		    dispose();
		    reception.setVisible(true);
		}
	}
    
    public static void main(String[] args) {
	    Reception reception = new Reception();
	    new CheckOut(reception);
    }

}
