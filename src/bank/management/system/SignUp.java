//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package bank.management.system;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SignUp extends JFrame implements ActionListener {
    JLabel label1 = new JLabel("Name: ");
    JLabel label2;
    JLabel label3;
    JLabel label4;
    JLabel label5;
    JLabel label6;
    JLabel label7;
    JLabel label8;
    JLabel label10;
    JTextField textField1;
    JTextField textField2;
    JTextField textField5;
    JTextField textField7;
    JTextField textField8;
    JTextField textField10;
    JRadioButton r1;
    JRadioButton r2;
    JRadioButton m1;
    JRadioButton m2;
    JDateChooser d;
    JButton button1;
    JButton EXIT;

    SignUp() {
        this.label1.setFont(new Font("Arial", 1, 28));
        this.label1.setForeground(Color.WHITE);
        this.label1.setBounds(30, 100, 250, 40);
        this.add(this.label1);
        this.textField1 = new JTextField();
        this.textField1.setFont(new Font("Arial", 0, 20));
        this.textField1.setForeground(Color.BLACK);
        this.textField1.setBounds(260, 105, 250, 30);
        this.add(this.textField1);
        this.label2 = new JLabel("Last Name: ");
        this.label2.setFont(new Font("Arial", 1, 28));
        this.label2.setForeground(Color.WHITE);
        this.label2.setBounds(30, 150, 250, 40);
        this.add(this.label2);
        this.textField2 = new JTextField();
        this.textField2.setFont(new Font("Arial", 0, 20));
        this.textField2.setForeground(Color.BLACK);
        this.textField2.setBounds(260, 155, 250, 30);
        this.add(this.textField2);
        this.label10 = new JLabel("National id: ");
        this.label10.setFont(new Font("Arial", 1, 28));
        this.label10.setForeground(Color.WHITE);
        this.label10.setBounds(30, 200, 250, 40);
        this.add(this.label10);
        this.textField10 = new JTextField();
        this.textField10.setFont(new Font("Arial", 0, 20));
        this.textField10.setForeground(Color.BLACK);
        this.textField10.setBounds(260, 205, 250, 30);
        this.add(this.textField10);
        this.label3 = new JLabel("Gender: ");
        this.label3.setFont(new Font("Arial", 1, 28));
        this.label3.setForeground(Color.WHITE);
        this.label3.setBounds(30, 250, 250, 40);
        this.add(this.label3);
        this.r1 = new JRadioButton("Male");
        this.r1.setFont(new Font("Raleway", 1, 18));
        this.r1.setOpaque(false);
        this.r1.setBounds(260, 255, 90, 30);
        this.add(this.r1);
        this.r2 = new JRadioButton("Female");
        this.r2.setFont(new Font("Raleway", 1, 18));
        this.r2.setOpaque(false);
        this.r2.setBounds(450, 255, 90, 30);
        this.add(this.r2);
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(this.r1);
        genderGroup.add(this.r2);
        this.label4 = new JLabel("Date: ");
        this.label4.setFont(new Font("Arial", 1, 28));
        this.label4.setForeground(Color.WHITE);
        this.label4.setBounds(30, 300, 250, 40);
        this.add(this.label4);
        this.d = new JDateChooser();
        this.d.setForeground(new Color(105, 105, 105));
        this.d.setBounds(260, 305, 250, 30);
        this.add(this.d);
        this.label5 = new JLabel("Email address: ");
        this.label5.setFont(new Font("Arial", 1, 28));
        this.label5.setForeground(Color.WHITE);
        this.label5.setBounds(30, 350, 250, 40);
        this.add(this.label5);
        this.textField5 = new JTextField();
        this.textField5.setFont(new Font("Arial", 0, 20));
        this.textField5.setForeground(Color.BLACK);
        this.textField5.setBounds(260, 355, 250, 30);
        this.add(this.textField5);
        this.label6 = new JLabel("Status: ");
        this.label6.setFont(new Font("Arial", 1, 28));
        this.label6.setForeground(Color.WHITE);
        this.label6.setBounds(30, 400, 250, 40);
        this.add(this.label6);
        this.m1 = new JRadioButton("Married");
        this.m1.setFont(new Font("Raleway", 1, 18));
        this.m1.setOpaque(false);
        this.m1.setBounds(260, 405, 150, 30);
        this.add(this.m1);
        this.m2 = new JRadioButton("Single");
        this.m2.setFont(new Font("Raleway", 1, 18));
        this.m2.setOpaque(false);
        this.m2.setBounds(450, 405, 150, 30);
        this.add(this.m2);
        ButtonGroup statusGroup = new ButtonGroup();
        statusGroup.add(this.m1);
        statusGroup.add(this.m2);
        this.label7 = new JLabel("Address: ");
        this.label7.setFont(new Font("Arial", 1, 28));
        this.label7.setForeground(Color.WHITE);
        this.label7.setBounds(30, 450, 250, 40);
        this.add(this.label7);
        this.textField7 = new JTextField();
        this.textField7.setFont(new Font("Arial", 0, 20));
        this.textField7.setForeground(Color.BLACK);
        this.textField7.setBounds(260, 455, 250, 30);
        this.add(this.textField7);
        this.label8 = new JLabel("City: ");
        this.label8.setFont(new Font("Arial", 1, 28));
        this.label8.setForeground(Color.WHITE);
        this.label8.setBounds(30, 500, 250, 40);
        this.add(this.label8);
        this.textField8 = new JTextField();
        this.textField8.setFont(new Font("Arial", 0, 20));
        this.textField8.setForeground(Color.BLACK);
        this.textField8.setBounds(260, 505, 250, 30);
        this.add(this.textField8);
        this.button1 = new JButton("Next");
        this.button1.setBackground(new Color(59, 89, 182));
        this.button1.setForeground(Color.WHITE);
        this.button1.setFocusPainted(false);
        this.button1.setFont(new Font("Tahoma", 1, 20));
        this.button1.setBounds(260, 600, 250, 30);
        this.button1.addActionListener(this);
        this.add(this.button1);
        this.EXIT = new JButton("EXIT");
        this.EXIT.setBounds(800, 15, 80, 25);
        this.EXIT.setBackground(new Color(180, 70, 80));
        this.EXIT.setForeground(Color.WHITE);
        this.setUndecorated(true);
        this.EXIT.setFocusPainted(false);
        this.EXIT.addActionListener(this);
        this.add(this.EXIT);
        ImageIcon background = new ImageIcon(ClassLoader.getSystemResource("icons/form1.png"));
        Image img = background.getImage();
        background = new ImageIcon(img);
        JLabel back = new JLabel(background);
        back.setBounds(0, 0, 900, 700);
        this.add(back);
        this.setTitle("Application Form");
        this.setDefaultCloseOperation(3);
        this.setResizable(false);
        this.setSize(900, 700);
        this.setLocationRelativeTo((Component)null);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.button1) {
            String name = this.textField1.getText();
            String lastname = this.textField2.getText();
            String dateOfBirth = ((JTextField)this.d.getDateEditor().getUiComponent()).getText();
            String email = this.textField5.getText();
            String gender = this.r1.isSelected() ? "male" : "female";
            String status = this.m1.isSelected() ? "married" : "single";
            String address = this.textField7.getText();
            String city = this.textField8.getText();
            String Nat_id = this.textField10.getText();
            try{
                DataValidation.validateNames(name);
                DataValidation.validateNames(lastname);
                DataValidation.validateNationalId(Nat_id);
                DataValidation.validateGender(gender);
                DataValidation.validateBirthDate(dateOfBirth);
                DataValidation.validateEmail(email);
                DataValidation.validateStatus(status);
                DataValidation.validateAddress(address,city);
            }
            catch (InvalidDataException E)
            {
                JOptionPane.showMessageDialog(null,E.getMessage());
                return;
            }
            User temp = new User(name, lastname, dateOfBirth, address, city, status, gender, email, Nat_id);
            new SignUp2(temp);
            this.setVisible(false);
        } else if (e.getSource() == this.EXIT) {
            System.exit(0);
        }

    }
}
