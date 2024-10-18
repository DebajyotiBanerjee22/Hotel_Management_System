package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.*;
import java.awt.event.*;
public class CustomerInfo extends JFrame implements ActionListener{
	JTable table;
	RoundedButton back;
	Reception reception;
	CustomerInfo(Reception reception){
		this.reception = reception;
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
	
		JLabel l1 = new JLabel("Document Type");
		l1.setBounds(20,10,100,20);
		l1.setForeground((Color.BLUE));
		add(l1);
		JLabel l2 = new JLabel("Number");
		l2.setBounds(170,10,100,20);
		l2.setForeground((Color.BLUE));
		add(l2);
		JLabel l3 = new JLabel("Name");
		l3.setBounds(290,10,100,20);
		l3.setForeground((Color.BLUE));
		add(l3);
		JLabel l4 = new JLabel("Gender");
		l4.setBounds(410,10,100,20);
		l4.setForeground((Color.BLUE));
		add(l4);
		JLabel l5 = new JLabel("Country");
		l5.setBounds(530,10,100,20);
		l5.setForeground((Color.BLUE));
		add(l5);
		JLabel l6 = new JLabel("Room No.");
		l6.setBounds(650,10,100,20);
		l6.setForeground((Color.BLUE));
		add(l6);
		JLabel l7 = new JLabel("CheckIn_Time");
		l7.setBounds(770,10,100,20);
		l7.setForeground((Color.BLUE));
		add(l7);
		JLabel l8 = new JLabel("Deposit");
		l8.setBounds(900,10,100,20);
		l8.setForeground((Color.BLUE));
		add(l8);

		table = new JTable();
		table.setBounds(0,40,1000,400);
		add(table);
		try{
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from customer");
			table.setModel(DbUtils.resultSetToTableModel(rs));

		}catch(Exception e){
			e.printStackTrace();
		}
	
		back = new RoundedButton("BACK");
		back.setBackground(new Color(82, 76, 66));
		back.setForeground(Color.yellow);
		back.setBounds(445, 500, 120, 30);
		back.addActionListener(this);
		add(back);
		
		setBounds(300,200,1000,600);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae){
		dispose();
		reception.setVisible(true);
	}
	
	public static void main(String[] args){
		Reception reception = new Reception();
		new CustomerInfo(reception);
	}
}
