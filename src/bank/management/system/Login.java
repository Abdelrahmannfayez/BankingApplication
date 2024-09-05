//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package bank.management.system;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener {
    JLabel label1 = new JLabel("Card number:");
    JLabel label2;
    JTextField textField1;
    JPasswordField passwordField;
    JButton button1;
    JButton button2;
    JButton button3;
    JButton EXIT;

    public Login() {
        this.label1.setFont(new Font("Ralway", 1, 28));
        this.label1.setForeground(Color.WHITE);
        this.label1.setBounds(390, 300, 200, 40);
        this.add(this.label1);
        this.label2 = new JLabel("PIN:");
        this.label2.setFont(new Font("Ralway", 1, 28));
        this.label2.setForeground(Color.WHITE);
        this.label2.setBounds(390, 370, 200, 40);
        this.add(this.label2);
        this.textField1 = new JTextField();
        this.textField1.setFont(new Font("Arial", 0, 28));
        this.textField1.setForeground(Color.BLACK);
        this.textField1.setBounds(600, 305, 275, 30);
        this.add(this.textField1);
        this.passwordField = new JPasswordField();
        this.passwordField.setFont(new Font("Arial", 0, 28));
        this.passwordField.setForeground(Color.BLACK);
        this.passwordField.setBounds(600, 375, 275, 30);
        this.add(this.passwordField);
        this.EXIT = new JButton("EXIT");
        this.EXIT.setBounds(780, 634, 80, 25);
        this.EXIT.setBackground(new Color(180, 70, 80));
        this.EXIT.setForeground(Color.WHITE);
        this.EXIT.setFocusPainted(false);
        this.EXIT.addActionListener(this);
        this.add(this.EXIT);
        this.button1 = new JButton("Sign in");
        this.button1.setBounds(600, 410, 140, 30);
        this.button1.setBackground(new Color(59, 89, 182));
        this.button1.setForeground(Color.WHITE);
        this.button1.setFocusPainted(false);
        this.button1.setFont(new Font("Tahoma", 1, 20));
        this.button1.addActionListener(this);
        this.add(this.button1);
        this.button2 = new JButton("Clear");
        this.button2.setBounds(775, 410, 100, 30);
        this.button2.setBackground(new Color(59, 89, 182));
        this.button2.setForeground(Color.WHITE);
        this.button2.setFocusPainted(false);
        this.button2.setFont(new Font("Tahoma", 1, 20));
        this.button2.addActionListener(this);
        this.add(this.button2);
        this.button3 = new JButton("Sign up");
        this.button3.setBackground(new Color(59, 89, 182));
        this.button3.setForeground(Color.WHITE);
        this.button3.setFocusPainted(false);
        this.button3.setFont(new Font("Tahoma", 1, 20));
        this.button3.setBounds(600, 450, 275, 30);
        this.button3.addActionListener(this);
        this.add(this.button3);
        ImageIcon background = new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
        Image img = background.getImage();
        background = new ImageIcon(img);
        JLabel back = new JLabel(background);
        back.setBounds(0, 0, 900, 700);
        this.add(back);
        this.setTitle("Bank account login");
        this.setDefaultCloseOperation(3);
        this.setResizable(false);
        this.setSize(900, 700);
        this.setUndecorated(true);
        this.setLocationRelativeTo((Component)null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Login();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.button2) {
            this.textField1.setText("");
            this.passwordField.setText("");
        } else if (e.getSource() == this.EXIT) {
            System.exit(0);
        } else if (e.getSource() == this.button1) {
            Conn con = new Conn();
            String cardnumber = this.textField1.getText().strip();
            String password = this.passwordField.getText();
            String q = "Select * From signin where cardno = '" + cardnumber + "' and pin = '" + password + "'";

            try {
                ResultSet rs = con.stmt.executeQuery(q);
                if (rs.next()) {
                    String nat_id = rs.getString("national_id");
                    this.setVisible(false);
                    new Main(nat_id);
                } else {
                    JOptionPane.showMessageDialog((Component)null, "Incorrect Card number or PIN ");
                }
            } catch (SQLException var8) {
                JOptionPane.showMessageDialog((Component)null, "Something wrong with the request");
            }
        } else {
            this.setVisible(false);
            new SignUp();
        }

    }
}
