
package hotel.management.system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AddDriver extends JFrame implements ActionListener {
    RoundedButton add,cancel;
    JComboBox gendercombo,availablecombo;
    JTextField tfname,tfage,tfbrand,tfmodel,tflocation,tfnoplate;
    Admin admin;
    AddDriver(Admin admin){
	this.admin = admin;
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        
        JLabel heading = new JLabel("Add Drivers");
	heading.setForeground(Color.BLUE);
        heading.setFont(new Font("Tahoma", Font.BOLD,18));
        heading.setBounds(150, 10, 200, 20);
        add(heading);
        
        JLabel lblname = new JLabel("Name");
        lblname.setFont(new Font("Tahoma", Font.PLAIN,16));
        lblname.setBounds(60, 50, 120, 30);
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(200, 50, 150, 30);
        add(tfname);
        
        JLabel lblage = new JLabel("AGE");
        lblage.setFont(new Font("Tahoma", Font.PLAIN,16));
        lblage.setBounds(60, 90, 120, 30);
        add(lblage);
        
        tfage = new JTextField();
        tfage.setBounds(200, 90, 150, 30);
        add(tfage);
        
        JLabel lblgender = new JLabel("Gender");
        lblgender.setFont(new Font("Tahoma", Font.PLAIN,16));
        lblgender.setBounds(60, 130, 120, 30);
        add(lblgender);
        
        String genderOptions[] = {"Male","Female","Other"};
        gendercombo = new JComboBox(genderOptions);
        gendercombo.setBounds(200,130,150,30);
        gendercombo.setBackground(Color.WHITE);
        add(gendercombo);
        
        JLabel lblbrand = new JLabel("Car Brand");
        lblbrand.setFont(new Font("Tahoma", Font.PLAIN,16));
        lblbrand.setBounds(60, 170, 120, 30);
        add(lblbrand);
        
        tfbrand = new JTextField();
        tfbrand.setBounds(200, 170, 150, 30);
        add(tfbrand);
        
        JLabel lblmodel = new JLabel("Car Model");
        lblmodel.setFont(new Font("Tahoma", Font.PLAIN,16));
        lblmodel.setBounds(60, 210, 120, 30);
        add(lblmodel);
        
        tfmodel = new JTextField();
        tfmodel.setBounds(200, 210, 150, 30);
        add(tfmodel);
        
        JLabel lblavailable = new JLabel("Available");
        lblavailable.setFont(new Font("Tahoma", Font.PLAIN,16));
        lblavailable.setBounds(60, 250, 120, 30);
        add(lblavailable);
        
        String driverOptions[] = {"Available","Busy"};
        availablecombo = new JComboBox(driverOptions);
        availablecombo.setBounds(200,250,150,30);
        availablecombo.setBackground(Color.WHITE);
        add(availablecombo);
        
        JLabel lbllocation = new JLabel("Location");
        lbllocation.setFont(new Font("Tahoma", Font.PLAIN,16));
        lbllocation.setBounds(60, 290, 120, 30);
        add(lbllocation);
        
        tflocation = new JTextField();
        tflocation.setBounds(200, 290, 150, 30);
        add(tflocation);
        
        JLabel lblNoplate = new JLabel("Number Plate");
        lblNoplate.setFont(new Font("Tahoma", Font.PLAIN,16));
        lblNoplate.setBounds(60, 330, 120, 30);
        add(lblNoplate);
        
        tfnoplate = new JTextField();
        tfnoplate.setBounds(200, 330, 150, 30);
        add(tfnoplate);
        
        add = new RoundedButton("Add Driver");
        add.setBackground(new Color(82, 76, 66));
        add.setForeground(Color.YELLOW);
        add.setBounds(60, 370, 130, 30);
        add.addActionListener(this);
        add(add);
        
        cancel = new RoundedButton("Cancel");
        cancel.setBackground(new Color(82, 76, 66));
        cancel.setForeground(Color.YELLOW);
        cancel.setBounds(220, 370, 130, 30);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,55,500,300);
        add(image);
        
        
        setBounds(300,200,980,470);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== add){
            String name = tfname.getText();
            String age = tfage.getText();
            String gender =(String) gendercombo.getSelectedItem();
            String brand = tfbrand.getText();
            String model = tfmodel.getText();
            String availability =(String) availablecombo.getSelectedItem();
            String location = tflocation.getText();
            String numberplate = tfnoplate.getText();
            try{
                 Conn conn = new Conn();
                String str = "insert into driver values('"+name+"','"+age+"','"+gender+"','"+brand+"','"+model+"','"+availability+"','"+location+"','"+numberplate+"')";
                conn.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"New Driver added successfuly");
                setVisible(false);
		admin.setVisible(true);
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
		dispose();
		admin.setVisible(true);
        }
    }
    public static void main(String[] args){
	Admin admin = new Admin(new Dashboard());
        new AddDriver(admin);
    }
}
