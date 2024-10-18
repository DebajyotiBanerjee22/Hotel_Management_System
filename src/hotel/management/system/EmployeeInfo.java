package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.*;
import java.awt.event.*;
public class EmployeeInfo extends JFrame implements ActionListener{
	JTable table;
	RoundedButton back;
	Reception reception;
	EmployeeInfo(Reception reception){
		this.reception = reception;
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
	
		JLabel l1 = new JLabel("Name");
		l1.setBounds(40,10,100,20);
		l1.setForeground((Color.BLUE));
		add(l1);
		JLabel l2 = new JLabel("Age");
		l2.setBounds(170,10,100,20);
		l2.setForeground((Color.BLUE));
		add(l2);
		JLabel l3 = new JLabel("Gender");
		l3.setBounds(290,10,100,20);
		l3.setForeground((Color.BLUE));
		add(l3);
		JLabel l4 = new JLabel("Job Role");
		l4.setBounds(410,10,100,20);
		l4.setForeground((Color.BLUE));
		add(l4);
		JLabel l5 = new JLabel("Salary");
		l5.setBounds(530,10,100,20);
		l5.setForeground((Color.BLUE));
		add(l5);
		JLabel l6 = new JLabel("Phone No.");
		l6.setBounds(650,10,100,20);
		l6.setForeground((Color.BLUE));
		add(l6);
		JLabel l7 = new JLabel("Email");
		l7.setBounds(800,10,100,20);
		l7.setForeground((Color.BLUE));
		add(l7);
		JLabel l8 = new JLabel("Aadhaar");
		l8.setBounds(900,10,100,20);
		l8.setForeground((Color.BLUE));
		add(l8);

		table = new JTable();
		table.setBounds(0,40,1000,400);
		add(table);
		try{
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from employee");
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
		new EmployeeInfo(reception);
	
	}
}
