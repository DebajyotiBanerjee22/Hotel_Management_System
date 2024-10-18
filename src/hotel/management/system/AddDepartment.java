package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class AddDepartment extends JFrame implements ActionListener {
    Choice cdept;
    JTextField tfdeptname, tfbudget;
    RoundedButton submit, refresh, search, cancel;
    Admin admin;
    
    AddDepartment() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("NEW DEPARTMENT REGISTRATION FORM");
        text.setBounds(35, 20, 450, 30);
        text.setFont(new Font("Railway", Font.PLAIN, 20));
        add(text);

        JLabel lblroom = new JLabel("All departments");
        lblroom.setBounds(35, 80, 200, 25);
        lblroom.setFont(new Font("Railway", Font.PLAIN, 20));
        add(lblroom);

        JLabel lbldeptname = new JLabel("Department Name");
        lbldeptname.setBounds(35, 140, 200, 25);
        lbldeptname.setFont(new Font("Railway", Font.PLAIN, 20));
        add(lbldeptname);

        tfdeptname = new JTextField();
        tfdeptname.setBounds(300, 140, 150, 20);
        add(tfdeptname);

        JLabel lblbudget = new JLabel("Allocated Budget");
        lblbudget.setBounds(35, 200, 200, 25);
        lblbudget.setFont(new Font("Railway", Font.PLAIN, 20));
        add(lblbudget);

        tfbudget = new JTextField();
        tfbudget.setBounds(300, 200, 150, 25);
        add(tfbudget);

        search = new RoundedButton("SEARCH");
        search.setBounds(12, 260, 100, 30);
        search.setBackground(new Color(82, 76, 66));
        search.setForeground(Color.YELLOW);
        search.addActionListener(this);
        add(search);

        submit = new RoundedButton("ADD DEPT");
        submit.setBounds(135, 260, 100, 30);
        submit.setBackground(new Color(82, 76, 66));
        submit.setForeground(Color.YELLOW);
        submit.addActionListener(this);
        add(submit);

        refresh = new RoundedButton("REFRESH");
        refresh.setBounds(255, 260, 100, 30);
        refresh.setBackground(new Color(82, 76, 66));
        refresh.setForeground(Color.YELLOW);
        refresh.addActionListener(this);
        add(refresh);

        cancel = new RoundedButton("CANCEL");
        cancel.setBounds(375, 260, 100, 30);
        cancel.setBackground(new Color(82, 76, 66));
        cancel.setForeground(Color.YELLOW);
        cancel.addActionListener(this);
        add(cancel);

        cdept = new Choice();

        try {
            Conn conn = new Conn();
            String query = "select * from department;";
            ResultSet rs = conn.s.executeQuery(query);
            while (rs.next()) {
                String department = rs.getString("department");
                if (department != null && !department.trim().isEmpty()) {
                    cdept.add(department);
                } else {
                    System.out.println("Skipping null or empty department name");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        cdept.setBounds(300, 80, 150, 25);
        add(cdept);

        setBounds(530, 200, 500, 350);
        setVisible(true);
    }
    
    AddDepartment(Admin admin) {
        this.admin = admin;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("NEW DEPARTMENT REGISTRATION FORM");
        text.setBounds(35, 20, 450, 30);
        text.setFont(new Font("Railway", Font.PLAIN, 20));
        add(text);

        JLabel lblroom = new JLabel("All departments");
        lblroom.setBounds(35, 80, 200, 25);
        lblroom.setFont(new Font("Railway", Font.PLAIN, 20));
        add(lblroom);

        JLabel lbldeptname = new JLabel("Department Name");
        lbldeptname.setBounds(35, 140, 200, 25);
        lbldeptname.setFont(new Font("Railway", Font.PLAIN, 20));
        add(lbldeptname);

        tfdeptname = new JTextField();
        tfdeptname.setBounds(300, 140, 150, 20);
        add(tfdeptname);

        JLabel lblbudget = new JLabel("Allocated Budget");
        lblbudget.setBounds(35, 200, 200, 25);
        lblbudget.setFont(new Font("Railway", Font.PLAIN, 20));
        add(lblbudget);

        tfbudget = new JTextField();
        tfbudget.setBounds(300, 200, 150, 25);
        add(tfbudget);

        search = new RoundedButton("SEARCH");
        search.setBounds(12, 260, 100, 30);
        search.setBackground(new Color(82, 76, 66));
        search.setForeground(Color.YELLOW);
        search.addActionListener(this);
        add(search);

        submit = new RoundedButton("ADD DEPT");
        submit.setBounds(135, 260, 100, 30);
        submit.setBackground(new Color(82, 76, 66));
        submit.setForeground(Color.YELLOW);
        submit.addActionListener(this);
        add(submit);

        refresh = new RoundedButton("REFRESH");
        refresh.setBounds(255, 260, 100, 30);
        refresh.setBackground(new Color(82, 76, 66));
        refresh.setForeground(Color.YELLOW);
        refresh.addActionListener(this);
        add(refresh);

        cancel = new RoundedButton("CANCEL");
        cancel.setBounds(375, 260, 100, 30);
        cancel.setBackground(new Color(82, 76, 66));
        cancel.setForeground(Color.YELLOW);
        cancel.addActionListener(this);
        add(cancel);

        cdept = new Choice();

        try {
            Conn conn = new Conn();
            String query = "select * from department;";
            ResultSet rs = conn.s.executeQuery(query);
            while (rs.next()) {
                String department = rs.getString("department");
                if (department != null && !department.trim().isEmpty()) {
                    cdept.add(department);
                } else {
                    System.out.println("Skipping null or empty department name");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        cdept.setBounds(300, 80, 150, 25);
        add(cdept);

        setBounds(530, 200, 500, 350);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {
            String deptname = cdept.getSelectedItem();
            String query = "select * from department where department = '" + deptname + "'";
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                while (rs.next()) {
                    tfdeptname.setText(rs.getString("department"));
                    tfbudget.setText(rs.getString("budget"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == submit) {
            String dname = tfdeptname.getText();
            String dallocbudget = tfbudget.getText();

            try {
                Conn c = new Conn();
                String query = "insert into department(department, budget) values('" + dname + "', '" + dallocbudget + "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "New department added successfully");

                int choice = JOptionPane.showConfirmDialog(null, "Do you want to add another department?", "Add Another", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    setVisible(false);
                    new AddDepartment(admin);
                } else if (choice == JOptionPane.NO_OPTION) {
                    setVisible(false);
                    admin.setVisible(true);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == refresh) {
            try {
                Conn c = new Conn();
                cdept.removeAll();
                String query = "select * from department";
                ResultSet rs = c.s.executeQuery(query);
                while (rs.next()) {
                    String department = rs.getString("department");
                    if (department != null && !department.trim().isEmpty()) {
                        cdept.add(department);
                    } else {
                        System.out.println("Skipping null or empty department name");
                    }
                }
                JOptionPane.showMessageDialog(null, "Page refreshed successfully");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == cancel) {
            dispose();
            admin.setVisible(true);
        }
    }

    public static void main(String[] args) {
        Admin admin = new Admin(new Dashboard());
        new AddDepartment(admin);
    }
}
