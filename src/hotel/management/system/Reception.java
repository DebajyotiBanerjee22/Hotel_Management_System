package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Reception extends JFrame implements ActionListener {
    JButton newCustomer, rooms, departments, allEmployee, customers, managerInfo, searchRoom, update, roomStatus, pickup, checkOut, logOut,dash,payment;
    Dashboard dashboard;
    Reception() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        newCustomer = new JButton("New Customer Form");
        newCustomer.setBounds(10, 30, 200, 30);
        newCustomer.setBackground(new Color(82, 76, 66));
        newCustomer.setForeground(Color.YELLOW);
        newCustomer.addActionListener(this);
        add(newCustomer);

        rooms = new JButton("Rooms");
        rooms.setBounds(10, 70, 200, 30);
        rooms.setBackground(new Color(82, 76, 66));
        rooms.setForeground(Color.YELLOW);
        rooms.addActionListener(this);
        add(rooms);

        departments = new JButton("Departments");
        departments.setBounds(10, 110, 200, 30);
        departments.setBackground(new Color(82, 76, 66));
        departments.setForeground(Color.YELLOW);
        departments.addActionListener(this);
        add(departments);

        allEmployee = new JButton("All Employees");
        allEmployee.setBounds(10, 150, 200, 30);
        allEmployee.setBackground(new Color(82, 76, 66));
        allEmployee.setForeground(Color.YELLOW);
        allEmployee.addActionListener(this);
        add(allEmployee);

        customers = new JButton("Customer Info");
        customers.setBounds(10, 190, 200, 30);
        customers.setBackground(new Color(82, 76, 66));
        customers.setForeground(Color.YELLOW);
        customers.addActionListener(this);
        add(customers);

        managerInfo = new JButton("Manager Info");
        managerInfo.setBounds(10, 230, 200, 30);
        managerInfo.setBackground(new Color(82, 76, 66));
        managerInfo.setForeground(Color.YELLOW);
        managerInfo.addActionListener(this);
        add(managerInfo);

        checkOut = new JButton("Check Out");
        checkOut.setBounds(10, 270, 200, 30);
        checkOut.setBackground(new Color(82, 76, 66));
        checkOut.setForeground(Color.YELLOW);
        checkOut.addActionListener(this);
        add(checkOut);

        update = new JButton("Update Status");
        update.setBounds(10, 310, 200, 30);
        update.setBackground(new Color(82, 76, 66));
        update.setForeground(Color.YELLOW);
        update.addActionListener(this);
        add(update);

        roomStatus = new JButton("Update Room Status");
        roomStatus.setBounds(10, 350, 200, 30);
        roomStatus.setBackground(new Color(82, 76, 66));
        roomStatus.setForeground(Color.YELLOW);
        roomStatus.addActionListener(this);
        add(roomStatus);

        pickup = new JButton("Pickup Service");
        pickup.setBounds(10, 390, 200, 30);
        pickup.setBackground(new Color(82, 76, 66));
        pickup.setForeground(Color.YELLOW);
        pickup.addActionListener(this);
        add(pickup);

        searchRoom = new JButton("Search Room");
        searchRoom.setBounds(10, 430, 200, 30);
        searchRoom.setBackground(new Color(82, 76, 66));
        searchRoom.setForeground(Color.YELLOW);
        searchRoom.addActionListener(this);
        add(searchRoom);
	
	payment = new JButton("Payment");
        payment.setBounds(10, 470, 200, 30);
        payment.setBackground(new Color(82, 76, 66));
        payment.setForeground(Color.YELLOW);
        payment.addActionListener(this);
        add(payment);
	
	dash = new JButton("Go To Dashboard");
        dash.setBounds(10, 510, 200, 30);
        dash.setBackground(new Color(82, 76, 66));
        dash.setForeground(Color.YELLOW);
        dash.addActionListener(this);
        add(dash);
	
        logOut = new JButton("Log Off");
        logOut.setBounds(10, 550, 200, 30);
        logOut.setBackground(new Color(82, 76, 66));
        logOut.setForeground(Color.YELLOW);
        logOut.addActionListener(this);
        add(logOut);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/reception.jpg"));
	Image i2 = i1.getImage().getScaledInstance(790, 550,Image.SCALE_DEFAULT );
	ImageIcon i3 = new ImageIcon(i2);
	JLabel image = new JLabel(i3);
	image.setBounds(240,30,640,550);
	add(image);
	
	JLabel text = new JLabel("HOTEL RECEPTION");
        text.setBounds(173, 50, 350, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("TAHOMA", Font.BOLD, 30));
        image.add(text);

        setBounds(320, 140, 920, 640);
        setVisible(true);
    }
    
    Reception(Dashboard dashboard) {
	    this.dashboard= dashboard;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        newCustomer = new JButton("New Customer Form");
        newCustomer.setBounds(10, 30, 200, 30);
        newCustomer.setBackground(new Color(82, 76, 66));
        newCustomer.setForeground(Color.YELLOW);
        newCustomer.addActionListener(this);
        add(newCustomer);

        rooms = new JButton("Rooms");
        rooms.setBounds(10, 70, 200, 30);
        rooms.setBackground(new Color(82, 76, 66));
        rooms.setForeground(Color.YELLOW);
        rooms.addActionListener(this);
        add(rooms);

        departments = new JButton("Departments");
        departments.setBounds(10, 110, 200, 30);
        departments.setBackground(new Color(82, 76, 66));
        departments.setForeground(Color.YELLOW);
        departments.addActionListener(this);
        add(departments);

        allEmployee = new JButton("All Employees");
        allEmployee.setBounds(10, 150, 200, 30);
        allEmployee.setBackground(new Color(82, 76, 66));
        allEmployee.setForeground(Color.YELLOW);
        allEmployee.addActionListener(this);
        add(allEmployee);

        customers = new JButton("Customer Info");
        customers.setBounds(10, 190, 200, 30);
        customers.setBackground(new Color(82, 76, 66));
        customers.setForeground(Color.YELLOW);
        customers.addActionListener(this);
        add(customers);

        managerInfo = new JButton("Manager Info");
        managerInfo.setBounds(10, 230, 200, 30);
        managerInfo.setBackground(new Color(82, 76, 66));
        managerInfo.setForeground(Color.YELLOW);
        managerInfo.addActionListener(this);
        add(managerInfo);

        checkOut = new JButton("Check Out");
        checkOut.setBounds(10, 270, 200, 30);
        checkOut.setBackground(new Color(82, 76, 66));
        checkOut.setForeground(Color.YELLOW);
        checkOut.addActionListener(this);
        add(checkOut);

        update = new JButton("Update Status");
        update.setBounds(10, 310, 200, 30);
        update.setBackground(new Color(82, 76, 66));
        update.setForeground(Color.YELLOW);
        update.addActionListener(this);
        add(update);

        roomStatus = new JButton("Update Room Status");
        roomStatus.setBounds(10, 350, 200, 30);
        roomStatus.setBackground(new Color(82, 76, 66));
        roomStatus.setForeground(Color.YELLOW);
        roomStatus.addActionListener(this);
        add(roomStatus);

        pickup = new JButton("Pickup Service");
        pickup.setBounds(10, 390, 200, 30);
        pickup.setBackground(new Color(82, 76, 66));
        pickup.setForeground(Color.YELLOW);
        pickup.addActionListener(this);
        add(pickup);

        searchRoom = new JButton("Search Room");
        searchRoom.setBounds(10, 430, 200, 30);
        searchRoom.setBackground(new Color(82, 76, 66));
        searchRoom.setForeground(Color.YELLOW);
        searchRoom.addActionListener(this);
        add(searchRoom);
	
	payment = new JButton("Payment");
        payment.setBounds(10, 470, 200, 30);
        payment.setBackground(new Color(82, 76, 66));
        payment.setForeground(Color.YELLOW);
        payment.addActionListener(this);
        add(payment);
	
	dash = new JButton("Go To Dashboard");
        dash.setBounds(10, 510, 200, 30);
        dash.setBackground(new Color(82, 76, 66));
        dash.setForeground(Color.YELLOW);
        dash.addActionListener(this);
        add(dash);
	
        logOut = new JButton("Log Off");
        logOut.setBounds(10, 550, 200, 30);
        logOut.setBackground(new Color(82, 76, 66));
        logOut.setForeground(Color.YELLOW);
        logOut.addActionListener(this);
        add(logOut);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/reception.jpg"));
	Image i2 = i1.getImage().getScaledInstance(790, 550,Image.SCALE_DEFAULT );
	ImageIcon i3 = new ImageIcon(i2);
	JLabel image = new JLabel(i3);
	image.setBounds(240,30,640,550);
	add(image);
	
	JLabel text = new JLabel("HOTEL RECEPTION");
        text.setBounds(173, 50, 350, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("TAHOMA", Font.BOLD, 30));
        image.add(text);

        setBounds(320, 140, 920, 640);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == newCustomer) {
            dispose();
            new AddCustomer(this);
        } else if (ae.getSource() == rooms) {
            dispose();
            new Room(this);
        } else if (ae.getSource() == departments) {
            dispose();
            new Department(this);
        } else if (ae.getSource() == allEmployee) {
            dispose();
            new EmployeeInfo(this);
        } else if (ae.getSource() == customers) {
            dispose();
            new CustomerInfo(this);
        } else if (ae.getSource() == managerInfo) {
            dispose();
            new ManagerInfo(this);
        } else if (ae.getSource() == searchRoom) {
            dispose();
            new SearchRoom(this);
        } else if (ae.getSource() == update) {
            dispose();
            new UpdateCheckOut(this);
        } else if (ae.getSource() == roomStatus) {
            setVisible(false);
            new UpdateRoom(this);
        } else if (ae.getSource() == pickup) {
            dispose();
            new PickUp(this);
        } else if (ae.getSource() == checkOut) {
            dispose();
            new CheckOut(this);
        } else if(ae.getSource()== payment){
		JOptionPane.showMessageDialog(null, "Feature Under Development");
		int choice = JOptionPane.showConfirmDialog(null, "Do you want to see the preview?", "Do you want to see the preview?", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    dispose();
                    new Payment(this);
                } else if (choice == JOptionPane.NO_OPTION) {
                    dispose();
                    new Reception();
                }
	}else if (ae.getSource() == logOut) {
            int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to logoff?", "Logoff", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, "Logged off successfully!");
                System.exit(0);
            }
        }else if(ae.getSource()== dash){
		dispose();
		if (dashboard != null) {
			dashboard.setVisible(true);
		}
	}
    }

    public static void main(String[] args) {
	    Dashboard dashboard = new Dashboard();
	    new Reception(dashboard);
    }
}
