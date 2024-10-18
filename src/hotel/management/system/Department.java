package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;

public class Department extends JFrame implements ActionListener {JTable table;
	RoundedButton back;
	Reception reception;
	Department(Reception reception){
		this.reception = reception;
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
	
	
		JLabel l1 = new JLabel("Department");
		l1.setBounds(180,10,100,20);
		l1.setForeground((Color.BLUE));
		l1.setBackground(Color.red);
		add(l1);

		JLabel l2 = new JLabel("Allocated Budget");
		l2.setBounds(420,10,100,20);
		l2.setForeground((Color.BLUE));
		add(l2);

		table = new JTable();
		table.setBounds(0,50,700,350);
		add(table);
		try{
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from department");
			table.setModel(DbUtils.resultSetToTableModel(rs));

		}catch(Exception e){
			e.printStackTrace();
		}

		back = new RoundedButton("BACK");
		back.setBackground(new Color(82, 76, 66));
		back.setForeground(Color.yellow);
		back.setBounds(280, 400, 120, 30);
		back.addActionListener(this);
		add(back);
		
		setBounds(400,200,700,480);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae){
		dispose();
		reception.setVisible(true);
	}
	
	
	
	
	public static void main(String[] args){
		Reception reception = new Reception();
		new Department(reception);
	
	}
}
