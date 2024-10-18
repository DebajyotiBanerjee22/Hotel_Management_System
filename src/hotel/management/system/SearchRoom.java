package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.*;
import java.awt.event.*;
public class SearchRoom extends JFrame implements ActionListener{
	RoundedButton back,submit,shwall;
	JCheckBox available,occupied;
	JComboBox bedType;
	JTable table;
	Reception reception;
	SearchRoom(Reception reception){
		this.reception = reception;
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
	
		JLabel sfr = new JLabel("Search For Room");
		sfr.setFont(new Font("Tahoma",Font.BOLD,20));
		sfr.setBounds(400,30,200,30);
		sfr.setForeground((Color.RED));
		add(sfr);
		
		JLabel lblbed = new JLabel("Bed Type");
		lblbed.setBounds(50,100,100,20);
		add(lblbed);
		
		bedType = new JComboBox(new String[]{"","Single Bed","Double Bed"});
		bedType.setBounds(150, 100, 150, 25);
		bedType.setBackground(Color.WHITE);
		add(bedType);
		
		available = new JCheckBox("Diplay Available ");
		available.setBounds(450,100,150,25);
		available.setBackground(Color.white);
		add(available);
		
		occupied = new JCheckBox("Diplay Occupied ");
		occupied.setBounds(650,100,150,25);
		occupied.setBackground(Color.white);
		add(occupied);
		
		JLabel l1 = new JLabel("Room Number");
		l1.setBounds(70,160,100,20);
		l1.setForeground((Color.BLUE));
		add(l1);
		JLabel l2 = new JLabel("Availabilty");
		l2.setBounds(270,160,100,20);
		l2.setForeground((Color.BLUE));
		add(l2);
		JLabel l3 = new JLabel("Cleaning Status");
		l3.setBounds(460,160,100,20);
		l3.setForeground((Color.BLUE));
		add(l3);
		JLabel l4 = new JLabel("Price");
		l4.setBounds(680,160,100,20);
		l4.setForeground((Color.BLUE));
		add(l4);
		JLabel l5 = new JLabel("Bed Type");
		l5.setBounds(870,160,100,20);
		l5.setForeground((Color.BLUE));
		add(l5);

		table = new JTable();
		table.setBounds(0,200,1000,300);
		add(table);
		try{
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from room");
			table.setModel(DbUtils.resultSetToTableModel(rs));

		}catch(Exception e){
			e.printStackTrace();
		}
		
		submit = new RoundedButton("SUBMIT");
		submit.setBackground(new Color(82, 76, 66));
		submit.setForeground(Color.yellow);
		submit.setBounds(250, 520, 120, 30);
		submit.addActionListener(this);
		add(submit);
		
		back = new RoundedButton("BACK");
		back.setBackground(new Color(82, 76, 66));
		back.setForeground(Color.yellow);
		back.setBounds(450, 520, 120, 30);
		back.addActionListener(this);
		add(back);
		
		shwall = new RoundedButton("All Rooms");
		shwall.setBackground(new Color(82, 76, 66));
		shwall.setForeground(Color.yellow);
		shwall.setBounds(650, 520, 120, 30);
		shwall.addActionListener(this);
		add(shwall);
		
		setBounds(300,200,1000,600);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == submit) {
		    try {
			Conn c = new Conn();
			ResultSet rs = null;

			if (available.isSelected() && occupied.isSelected()) {
			    JOptionPane.showMessageDialog(this, "Please select only one checkbox.");
			} else if (available.isSelected()) {
			    String q2 = "select * from room where availability ='Available'";
			    if (!bedType.getSelectedItem().equals("")) {
				q2 += " and bed_type ='" + bedType.getSelectedItem() + "'";
			    }
			    rs = c.s.executeQuery(q2);
			} else if (occupied.isSelected()) {
			    String q4 = "select * from room where availability <>'Available'";
			    if (!bedType.getSelectedItem().equals("")) {
				q4 += " and bed_type ='" + bedType.getSelectedItem() + "'";
			    }
			    rs = c.s.executeQuery(q4);
			} else {
			    if (!bedType.getSelectedItem().equals("")) {
				String q1 = "select * from room where bed_type ='" + bedType.getSelectedItem() + "'";
				rs = c.s.executeQuery(q1);
			    }
			}

			if (rs != null) {
			    table.setModel(DbUtils.resultSetToTableModel(rs));
			}
		    } catch (Exception e) {
			e.printStackTrace();
		    }
		} else if (ae.getSource() == shwall) {
		    try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from room");
			table.setModel(DbUtils.resultSetToTableModel(rs));
		    } catch (Exception e) {
			e.printStackTrace();
		    }
		} else {
		    dispose();
		    reception.setVisible(true);
		}
	    }
	
	public static void main(String[] args){
		Reception reception = new Reception();
		new SearchRoom(reception);
	
	}
}
