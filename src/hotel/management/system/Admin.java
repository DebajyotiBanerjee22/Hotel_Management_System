package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Admin extends JFrame implements ActionListener {
    JButton addEmployee, addRooms, addDepartments, addDriver, back;
    Dashboard dashboard;
	Admin(){
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);

		addEmployee = new JButton("ADD EMPLOYEE");
		addEmployee.setBounds(10, 30, 200, 30);
		addEmployee.setBackground(new Color(82, 76, 66));
		addEmployee.setForeground(Color.YELLOW);
		addEmployee.addActionListener(this);
		add(addEmployee);

		addRooms = new JButton("ADD ROOM");
		addRooms.setBounds(10, 70, 200, 30);
		addRooms.setBackground(new Color(82, 76, 66));
		addRooms.setForeground(Color.YELLOW);
		addRooms.addActionListener(this);
		add(addRooms);

		addDepartments = new JButton("ADD DEPARTMENT");
		addDepartments.setBounds(10, 110, 200, 30);
		addDepartments.setBackground(new Color(82, 76, 66));
		addDepartments.setForeground(Color.YELLOW);
		addDepartments.addActionListener(this);
		add(addDepartments);

		addDriver = new JButton("ADD DRIVER");
		addDriver.setBounds(10, 150, 200, 30);
		addDriver.setBackground(new Color(82, 76, 66));
		addDriver.setForeground(Color.YELLOW);
		addDriver.addActionListener(this);
		add(addDriver);

		back = new JButton("BACK");
		back.setBounds(10, 190, 200, 30);
		back.setBackground(new Color(82, 76, 66));
		back.setForeground(Color.YELLOW);
		back.addActionListener(this);
		add(back);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/admin.jpg"));
		Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(250, 0, 200, 250);
		add(image);

		setBounds(530, 250, 500, 300);
		setVisible(true);
	}

	Admin(Dashboard dashboard){
		this.dashboard = dashboard;
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);

		addEmployee = new JButton("ADD EMPLOYEE");
		addEmployee.setBounds(10, 30, 200, 30);
		addEmployee.setBackground(new Color(82, 76, 66));
		addEmployee.setForeground(Color.YELLOW);
		addEmployee.addActionListener(this);
		add(addEmployee);

		addRooms = new JButton("ADD ROOM");
		addRooms.setBounds(10, 70, 200, 30);
		addRooms.setBackground(new Color(82, 76, 66));
		addRooms.setForeground(Color.YELLOW);
		addRooms.addActionListener(this);
		add(addRooms);

		addDepartments = new JButton("ADD DEPARTMENT");
		addDepartments.setBounds(10, 110, 200, 30);
		addDepartments.setBackground(new Color(82, 76, 66));
		addDepartments.setForeground(Color.YELLOW);
		addDepartments.addActionListener(this);
		add(addDepartments);

		addDriver = new JButton("ADD DRIVER");
		addDriver.setBounds(10, 150, 200, 30);
		addDriver.setBackground(new Color(82, 76, 66));
		addDriver.setForeground(Color.YELLOW);
		addDriver.addActionListener(this);
		add(addDriver);

		back = new JButton("BACK");
		back.setBounds(10, 190, 200, 30);
		back.setBackground(new Color(82, 76, 66));
		back.setForeground(Color.YELLOW);
		back.addActionListener(this);
		add(back);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/admin.jpg"));
		Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(250, 0, 200, 250);
		add(image);

		setBounds(530, 250, 500, 300);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae){
		if (ae.getSource() == addDepartments) {
		    setVisible(false);
		    new AddDepartment(this);
		} else if (ae.getSource() == addDriver) {
		    setVisible(false);
		    new AddDriver(this);
		} else if (ae.getSource() == addEmployee) {
		    setVisible(false);
		    new AddEmployee(this);
		} else if (ae.getSource() == addRooms) {
		    setVisible(false);
		    new AddRooms(this);
		} else if (ae.getSource() == back) {
		    dispose();
		    if (dashboard != null) {
			dashboard.setVisible(true);
		    }
		}
	}

	public static void main(String[] args) {
		Dashboard dashboard = new Dashboard();
		new Admin(dashboard);
	}
}
