package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
public class UpdateCheckOut extends JFrame implements ActionListener{
	Choice ccustomer;
	JLabel lblroomchrges;
	RoundedButton check,update,back;
	JTextField tfroom,tfname,tfpaid,tfcheckin,tfpending;
	Reception reception;
	UpdateCheckOut(Reception reception){
		this.reception= reception;
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		JLabel text = new JLabel("Update Status");
		text.setFont(new Font("Tahoma",Font.BOLD,20));
		text.setBounds(90,20,200,30);
		text.setForeground(Color.BLUE);
		add(text);
		
		JLabel lblid = new JLabel("Customer Id");
		lblid.setBounds(30,80,100,20);
		add(lblid);
		
		ccustomer = new Choice();
		ccustomer.setBounds(200, 80, 150, 25);
		add(ccustomer);
		
		try{
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from customer");
			while(rs.next()){
				ccustomer.add(rs.getString("number"));
			}
		}catch(Exception e){e.printStackTrace();
		}
		JLabel lblroom = new JLabel("Room Number");
		lblroom.setBounds(30,120,100,20);
		add(lblroom);
		
		tfroom = new JTextField();
		tfroom.setBounds(200,120,150,15);
		add(tfroom);
		
		JLabel lblname = new JLabel("Name");
		lblname.setBounds(30,160,100,20);
		add(lblname);
		
		tfname = new JTextField();
		tfname.setBounds(200,160,150,15);
		add(tfname);
		
		JLabel lblcheckin = new JLabel("Checkin Date&Time");
		lblcheckin.setBounds(30,200,150,20);
		add(lblcheckin);
		
		tfcheckin = new JTextField();
		tfcheckin.setBounds(200,200,150,15);
		add(tfcheckin);
		
		JLabel lblroomchrg = new JLabel("Room Cost");
		lblroomchrg .setBounds(30,230,100,30);
		add(lblroomchrg);
		
		lblroomchrges = new JLabel();
		lblroomchrges .setBounds(200,230,100,30);
		add(lblroomchrges);
		
		JLabel lblpaid = new JLabel("Amount Paid");
		lblpaid.setBounds(30,270,100,20);
		add(lblpaid);
		
		tfpaid = new JTextField();
		tfpaid.setBounds(200,270,150,15);
		add(tfpaid);
		
		JLabel lblpending = new JLabel("Pending Amount");
		lblpending.setBounds(30,310,100,20);
		add(lblpending);
		
		tfpending = new JTextField();
		tfpending.setBounds(200,310,150,15);
		add(tfpending);
		
		check = new RoundedButton("CHECK");
		check.setBackground(new Color(82, 76, 66));
		check.setForeground(Color.yellow);
		check.setBounds(30, 370, 100, 30);
		check.addActionListener(this);
		add(check);
		
		update = new RoundedButton("UPDATE");
		update.setBackground(new Color(82, 76, 66));
		update.setForeground(Color.yellow);
		update.setBounds(160, 370, 100, 30);
		update.addActionListener(this);
		add(update);
		
		back = new RoundedButton("BACK");
		back.setBackground(new Color(82, 76, 66));
		back.setForeground(Color.yellow);
		back.setBounds(290, 370, 100, 30);
		back.addActionListener(this);
		add(back);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
		JLabel image = new JLabel(i1);
		image.setBounds(400,50,500,300);
		add(image);
		setBounds(300,200,980,500);
		setVisible(true);
	}
	 
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource()== check){
			String id = ccustomer.getSelectedItem();
		String query = "select * from customer where number = '"+id+"'";
		try{
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery(query);
			while(rs.next()){
				tfroom.setText(rs.getString("room"));
				tfname.setText(rs.getString("name"));
				tfcheckin.setText(rs.getString("checkintime"));
				tfpaid.setText(rs.getString("deposit"));
				
			}
			ResultSet rs2 = c.s.executeQuery("select * from room where roomnumber='"+tfroom.getText()+"'");
			while(rs2.next()){
				String price = rs2.getString("price");
				lblroomchrges.setText(rs2.getString("price"));
				int amountpaid = Integer.parseInt(price)- Integer.parseInt(tfpaid.getText());
				tfpending.setText(""+amountpaid);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		}else if(ae.getSource()== update){
			String number = ccustomer.getSelectedItem();
			String room = tfroom.getText();
			String name = tfname.getText();
			String checkin=tfcheckin.getText();
			String deposit= tfpaid.getText();
			
			try{
				Conn c = new Conn();
			c.s.executeUpdate("update customer set room='" + room + "', name='" + name + "', checkintime='" + checkin + "', deposit='" + deposit + "' where number = '" + number + "'");
				JOptionPane.showMessageDialog(null," Customer Data Updated Successfully");
				setVisible(false);
				new Reception();
			}catch(Exception e){
				e.printStackTrace();
			}
		}else{
			dispose();
			reception.setVisible(true);
		}
	} 
	
	public static void main(String[] args){
		Reception reception = new Reception();
		new UpdateCheckOut(reception);
	
	}
}
