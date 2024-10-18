
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddEmployee extends JFrame implements ActionListener{
   
	JTextField tfname,tfage,tfphone,tfsalary,tfemail,tfaadhaar;
	JRadioButton rbmale,rbfemale,rbother;
	RoundedButton submit,back;
	JComboBox cbjob;
	Admin admin;
   
	AddEmployee(){
		setLayout(null);

		JLabel text = new JLabel("NEW EMPLOYEE FORM");
		text.setBounds(300, 10, 300, 30);
		text.setFont(new Font("Railway", Font.BOLD, 20));
		add(text);

		JLabel lblname = new JLabel("NAME");
		lblname.setBounds(40, 50, 120, 30);
		lblname.setFont(new Font("Tahoma", Font.PLAIN,17));
		add(lblname);

		tfname = new JTextField();
		tfname.setBounds(200,50,150,30);
		add(tfname);

		JLabel lblage = new JLabel("AGE");
		lblage.setBounds(40, 100, 120, 30);
		lblage.setFont(new Font("Tahoma", Font.PLAIN,17));
		add(lblage);

		tfage = new JTextField();
		tfage.setBounds(200,100,150,30);
		add(tfage);

		JLabel lblgender = new JLabel("GENDER");
		lblgender.setBounds(40, 150, 120, 30);
		lblgender.setFont(new Font("Tahoma", Font.PLAIN,17));
		add(lblgender);

		rbmale = new JRadioButton("Male");
		rbmale.setBounds(200,150,70,30);
		rbmale.setFont(new Font("Tahoma",Font.PLAIN,14));
		rbmale.setBackground(Color.WHITE);
		add(rbmale);

		rbfemale = new JRadioButton("Female");
		rbfemale.setBounds(280,150,70,30);
		rbfemale.setFont(new Font("Tahoma",Font.PLAIN,14));
		rbfemale.setBackground(Color.WHITE);
		add(rbfemale);

		rbother = new JRadioButton("Others");
		rbother.setBounds(360,150,70,30);
		rbother.setFont(new Font("Tahoma",Font.PLAIN,14));
		rbother.setBackground(Color.WHITE);
		add(rbother);

		ButtonGroup bj = new ButtonGroup();
		bj.add(rbmale);
		bj.add(rbfemale);
		bj.add(rbother);

		JLabel lbljob = new JLabel("JOB");
		lbljob.setBounds(40, 200, 120, 30);
		lbljob.setFont(new Font("Tahoma", Font.PLAIN,17));
		add(lbljob);

		String str[] = {"Front Desk Clerks","Porters","HouseKeeping","Room Service","Chefs","Waiter/Waitress","Manager","Accountant","Driver"};
		cbjob = new JComboBox(str);
		cbjob.setBounds(200,200,150,30);
		cbjob.setBackground(Color.WHITE);
		add(cbjob);

		JLabel lblsalary = new JLabel("SALARY");
		lblsalary.setBounds(40, 250, 120, 30);
		lblsalary.setFont(new Font("Tahoma", Font.PLAIN,17));
		add(lblsalary);

		tfsalary = new JTextField();
		tfsalary.setBounds(200,250,150,30);
		add(tfsalary);

		JLabel lblphone = new JLabel("PHONE");
		lblphone.setBounds(40, 300, 120, 30);
		lblphone.setFont(new Font("Tahoma", Font.PLAIN,17));
		add(lblphone);

		tfphone = new JTextField();
		tfphone.setBounds(200,300,150,30);
		add(tfphone);

		JLabel lblemail = new JLabel("EMAIL");
		lblemail.setBounds(40, 350, 120, 30);
		lblemail.setFont(new Font("Tahoma", Font.PLAIN,17));
		add(lblemail);

		tfemail = new JTextField();
		tfemail.setBounds(200,350,150,30);
		add(tfemail);

		JLabel lblaadhaar = new JLabel("AADHAAR");
		lblaadhaar.setBounds(40, 400, 120, 30);
		lblaadhaar.setFont(new Font("Tahoma", Font.PLAIN,17));
		add(lblaadhaar);

		tfaadhaar = new JTextField();
		tfaadhaar.setBounds(200,400,150,30);
		add(tfaadhaar);

		submit = new RoundedButton("SUBMIT");
		submit.setBackground(new Color(82, 76, 66));
		submit.setForeground(Color.YELLOW);
		submit.setBounds(40, 450, 130, 30);
		submit.addActionListener(this);
		add(submit);

		back = new RoundedButton("CANCEL");
		back.setBackground(new Color(82, 76, 66));
		back.setForeground(Color.YELLOW);
		back.setBounds(220, 450, 130, 30);
		back.addActionListener(this);
		add(back);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
		Image i2 = i1.getImage().getScaledInstance(500,550,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(400,60,450,420);
		add(image);


		getContentPane().setBackground(Color.WHITE);
		setBounds(360,200,850,540);
		setVisible(true);
	}
   
	AddEmployee(Admin admin){
		this.admin = admin;
		setLayout(null);

		JLabel text = new JLabel("NEW EMPLOYEE FORM");
		text.setBounds(300, 10, 300, 30);
		text.setFont(new Font("Railway", Font.BOLD, 20));
		add(text);

		JLabel lblname = new JLabel("NAME");
		lblname.setBounds(40, 50, 120, 30);
		lblname.setFont(new Font("Tahoma", Font.PLAIN,17));
		add(lblname);

		tfname = new JTextField();
		tfname.setBounds(200,50,150,30);
		add(tfname);

		JLabel lblage = new JLabel("AGE");
		lblage.setBounds(40, 100, 120, 30);
		lblage.setFont(new Font("Tahoma", Font.PLAIN,17));
		add(lblage);

		tfage = new JTextField();
		tfage.setBounds(200,100,150,30);
		add(tfage);

		JLabel lblgender = new JLabel("GENDER");
		lblgender.setBounds(40, 150, 120, 30);
		lblgender.setFont(new Font("Tahoma", Font.PLAIN,17));
		add(lblgender);

		rbmale = new JRadioButton("Male");
		rbmale.setBounds(200,150,70,30);
		rbmale.setFont(new Font("Tahoma",Font.PLAIN,14));
		rbmale.setBackground(Color.WHITE);
		add(rbmale);

		rbfemale = new JRadioButton("Female");
		rbfemale.setBounds(280,150,70,30);
		rbfemale.setFont(new Font("Tahoma",Font.PLAIN,14));
		rbfemale.setBackground(Color.WHITE);
		add(rbfemale);

		rbother = new JRadioButton("Others");
		rbother.setBounds(360,150,70,30);
		rbother.setFont(new Font("Tahoma",Font.PLAIN,14));
		rbother.setBackground(Color.WHITE);
		add(rbother);

		ButtonGroup bj = new ButtonGroup();
		bj.add(rbmale);
		bj.add(rbfemale);
		bj.add(rbother);

		JLabel lbljob = new JLabel("JOB");
		lbljob.setBounds(40, 200, 120, 30);
		lbljob.setFont(new Font("Tahoma", Font.PLAIN,17));
		add(lbljob);

		String str[] = {"Front Desk Clerks","Porters","HouseKeeping","Room Service","Chefs","Waiter/Waitress","Manager","Accountant","Driver"};
		cbjob = new JComboBox(str);
		cbjob.setBounds(200,200,150,30);
		cbjob.setBackground(Color.WHITE);
		add(cbjob);

		JLabel lblsalary = new JLabel("SALARY");
		lblsalary.setBounds(40, 250, 120, 30);
		lblsalary.setFont(new Font("Tahoma", Font.PLAIN,17));
		add(lblsalary);

		tfsalary = new JTextField();
		tfsalary.setBounds(200,250,150,30);
		add(tfsalary);

		JLabel lblphone = new JLabel("PHONE");
		lblphone.setBounds(40, 300, 120, 30);
		lblphone.setFont(new Font("Tahoma", Font.PLAIN,17));
		add(lblphone);

		tfphone = new JTextField();
		tfphone.setBounds(200,300,150,30);
		add(tfphone);

		JLabel lblemail = new JLabel("EMAIL");
		lblemail.setBounds(40, 350, 120, 30);
		lblemail.setFont(new Font("Tahoma", Font.PLAIN,17));
		add(lblemail);

		tfemail = new JTextField();
		tfemail.setBounds(200,350,150,30);
		add(tfemail);

		JLabel lblaadhaar = new JLabel("AADHAAR");
		lblaadhaar.setBounds(40, 400, 120, 30);
		lblaadhaar.setFont(new Font("Tahoma", Font.PLAIN,17));
		add(lblaadhaar);

		tfaadhaar = new JTextField();
		tfaadhaar.setBounds(200,400,150,30);
		add(tfaadhaar);

		submit = new RoundedButton("SUBMIT");
		submit.setBackground(new Color(82, 76, 66));
		submit.setForeground(Color.YELLOW);
		submit.setBounds(40, 450, 130, 30);
		submit.addActionListener(this);
		add(submit);

		back = new RoundedButton("CANCEL");
		back.setBackground(new Color(82, 76, 66));
		back.setForeground(Color.YELLOW);
		back.setBounds(220, 450, 130, 30);
		back.addActionListener(this);
		add(back);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
		Image i2 = i1.getImage().getScaledInstance(500,550,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(400,60,450,420);
		add(image);


		getContentPane().setBackground(Color.WHITE);
		setBounds(360,200,850,540);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae){
		String name =tfname.getText();
		String age = tfage.getText();
		String salary = tfsalary.getText();
		String phone = tfphone.getText();
		String email = tfemail.getText();
		String aadhaar = tfaadhaar.getText();
		String gender = null;
		if(rbmale.isSelected()){
		    gender = "Male";
		}else if(rbfemale.isSelected()){
		    gender = "Female";
		}else if(rbother.isSelected()){
		    gender = "Other";
		}
		String job = (String) cbjob.getSelectedItem();
		if(ae.getSource()== submit){
			if(name.equals("")){
			    JOptionPane.showMessageDialog(null, "Name should not be empty");
			    return;
			}else if((age.equals(aadhaar))||(age.equals(salary)||(age.equals("")))){
			    JOptionPane.showMessageDialog(null, "Name should not be empty and/or cannot be your salary or your aadhaar");
			    return;
			}else if(salary.equals(0)|| salary.isEmpty()){
			    JOptionPane.showMessageDialog(null, "Salary should be not be 'Empty' or 'Zero' ");
			    return;
			}else if(phone.equals(0)|| phone.isEmpty() || phone.equals(salary)|| phone.equals(aadhaar)){
			    JOptionPane.showMessageDialog(null, "Phone should be not be 'Empty' or 'Zero' or should not be same as salary or aadhaar ");
			    return;
			}else if(aadhaar.equals(0)|| aadhaar.isEmpty() || aadhaar.equals(salary)|| aadhaar.equals(phone)){
			    JOptionPane.showMessageDialog(null, "Aadhaar should be not be 'Empty' or 'Zero' or should not be same as salary or phone ");
			    return;
			}

			try{
			    Conn conn = new Conn();
			    String query = "insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+email+"','"+aadhaar+"')";
			    conn.s.executeUpdate(query);
			    JOptionPane.showMessageDialog(null,"Employee added successfuly");
			    setVisible(false);
			    admin.setVisible(true);
			}catch(Exception e){
			    e.printStackTrace();
			}
		}else if(ae.getSource()== back){
			dispose();
			 admin.setVisible(true);
		}
	}
	public static void main(String[] args){
		Admin admin = new Admin();    
		new AddEmployee(admin);
	}
}
