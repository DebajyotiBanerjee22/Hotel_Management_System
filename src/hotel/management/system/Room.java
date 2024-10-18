package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.*;
import java.awt.event.*;
public class Room extends JFrame implements ActionListener{
	JTable table;
	RoundedButton back;
	Reception reception;
	Room(Reception reception){
		this.reception = reception;
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
		Image i2 = i1.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(500,0,600,600);
		add(image);
		
		

		JLabel l1 = new JLabel("Room Number");
		l1.setBounds(10,10,100,20);
		l1.setForeground((Color.BLUE));
		add(l1);
		JLabel l2 = new JLabel("Availabilty");
		l2.setBounds(120,10,100,20);
		l2.setForeground((Color.BLUE));
		add(l2);
		JLabel l3 = new JLabel("Cleaning Status");
		l3.setBounds(200,10,100,20);
		l3.setForeground((Color.BLUE));
		add(l3);
		JLabel l4 = new JLabel("Price");
		l4.setBounds(330,10,100,20);
		l4.setForeground((Color.BLUE));
		add(l4);
		JLabel l5 = new JLabel("Bed Type");
		l5.setBounds(420,10,100,20);
		l5.setForeground((Color.BLUE));
		add(l5);

		table = new JTable();
		table.setBounds(0,60,500,400);
		add(table);
		try{
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from room");
			table.setModel(DbUtils.resultSetToTableModel(rs));

		}catch(Exception e){
			e.printStackTrace();
		}

		back = new RoundedButton("BACK");
		back.setBackground(new Color(82, 76, 66));
		back.setForeground(Color.yellow);
		back.setBounds(200, 500, 120, 30);
		back.addActionListener(this);
		add(back);
		
	
		
		setBounds(300,200,1050,600);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae){
		
		
			dispose();
			reception.setVisible(true);
	}
	
	
	
	
	public static void main(String[] args){
		Reception reception = new Reception();
		new Room(reception);
	
	}
}
