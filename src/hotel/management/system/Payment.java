
package hotel.management.system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Payment extends JFrame implements ActionListener{
	RoundedButton back;
	Reception reception;
	Payment(Reception reception){
		this.reception= reception;
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel text = new JLabel("Make In India");
		text.setBounds(150, 20, 400, 50);
		text.setForeground(new Color(246,124,8));
		text.setFont(new Font("Railway", Font.BOLD, 50));
		add(text);
		
		JLabel text2 = new JLabel("#DigitalIndia");
		text2.setBounds(210, 70, 500, 35);
		text2.setForeground(new Color(8,8,132));
		text2.setFont(new Font("Railway", Font.BOLD, 30));
		add(text2);
		
		JLabel text3 = new JLabel("Online Payment System");
		text3.setBounds(131, 120, 500, 40);
		text3.setForeground(new Color(8,150,8));
		text3.setFont(new Font("Railway", Font.BOLD, 30));
		add(text3);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dummyQR.jpg"));
		Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(10, 200, 600, 100);
		add(image);
		
		JLabel text4 = new JLabel("Scan the above QR code");
		text4.setBounds(190, 300, 500, 25);
		text4.setForeground(new Color(8,8,132));
		text4.setFont(new Font("Railway", Font.BOLD, 20));
		add(text4);
		
		back = new RoundedButton("BACK");
		back.setBackground(new Color(246,124,8));
		back.setForeground(Color.white);
		back.setBounds(250, 350, 120, 30);
		back.addActionListener(this);
		add(back);
		
		setBounds(470, 200, 600, 450);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae){
		dispose();
		reception.setVisible(true);
	}
	
	public static void main(String[] args){
		Reception reception = new Reception();
		new Payment(reception);
		
	}
	
}
