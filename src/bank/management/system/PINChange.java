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
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class PINChange extends JFrame implements ActionListener {
    JPasswordField passwordField1;
    JPasswordField passwordField2;
    JButton button1;
    JButton button2;
    JButton EXIT;
    String Nat_id;

    public static void main(String[] args) {
        new PINChange("");
    }

    public PINChange(String nationalId) {
        this.Nat_id = nationalId;
        this.passwordField1 = new JPasswordField();
        this.passwordField1.setFont(new Font("Arial", 0, 28));
        this.passwordField1.setForeground(Color.BLACK);
        this.passwordField1.setBounds(80, 335, 120, 30);
        this.add(this.passwordField1);
        this.passwordField2 = new JPasswordField();
        this.passwordField2.setFont(new Font("Arial", 0, 28));
        this.passwordField2.setForeground(Color.BLACK);
        this.passwordField2.setBounds(80, 415, 120, 30);
        this.add(this.passwordField2);
        this.button1 = new JButton("Change");
        this.button1.setBounds(740, 600, 120, 30);
        this.button1.setBackground(new Color(59, 89, 182));
        this.button1.setForeground(Color.WHITE);
        this.button1.setFocusPainted(false);
        this.button1.setFont(new Font("Tahoma", 1, 20));
        this.button1.addActionListener(this);
        this.add(this.button1);
        this.button2 = new JButton("Back");
        this.button2.setBounds(600, 600, 120, 30);
        this.button2.setBackground(new Color(59, 89, 182));
        this.button2.setForeground(Color.WHITE);
        this.button2.setFocusPainted(false);
        this.button2.setFont(new Font("Tahoma", 1, 20));
        this.button2.addActionListener(this);
        this.add(this.button2);
        this.EXIT = new JButton("EXIT");
        this.EXIT.setBounds(800, 15, 80, 25);
        this.EXIT.setBackground(new Color(180, 70, 80));
        this.setUndecorated(true);
        this.EXIT.setForeground(Color.WHITE);
        this.EXIT.setFocusPainted(false);
        this.EXIT.addActionListener(this);
        this.add(this.EXIT);
        ImageIcon background = new ImageIcon(ClassLoader.getSystemResource("icons/Atm3.png"));
        Image img = background.getImage();
        background = new ImageIcon(img);
        JLabel back = new JLabel(background);
        back.setBounds(0, 0, 900, 700);
        this.add(back);
        this.setTitle("PIN change");
        this.setDefaultCloseOperation(3);
        this.setResizable(false);
        this.setSize(900, 700);
        this.setLocationRelativeTo((Component)null);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.button2) {
            this.setVisible(false);
            new Main(this.Nat_id);
        } else if (e.getSource() == this.EXIT) {
            System.exit(0);
        } else if (e.getSource() == this.button1) {
            if (this.passwordField1.getText().strip() != "" && this.passwordField2.getText().strip() != "") {
                if (!this.passwordField1.getText().strip().equals(this.passwordField2.getText().strip())) {
                    JOptionPane.showMessageDialog((Component)null, "Password fields don't match");
                } else if (this.passwordField1.getPassword().length != 4) {
                    JOptionPane.showMessageDialog((Component)null, "PIN consist of 4 digits");
                } else {
                    try {
                        String PINNUM = this.passwordField1.getText().strip();
                        int x = Integer.parseInt(PINNUM);
                        Conn con = new Conn();
                        con.connection.setAutoCommit(false);
                        String q1 = "UPDATE signin SET pin = ? WHERE national_id = ?";
                        PreparedStatement stmt1 = con.connection.prepareStatement(q1);
                        stmt1.setString(1, PINNUM);
                        stmt1.setString(2, this.Nat_id);
                        stmt1.executeUpdate();
                        String q2 = "UPDATE signup3 SET pin = ? WHERE national_id = ?";
                        PreparedStatement stmt2 = con.connection.prepareStatement(q2);
                        stmt2.setString(1, PINNUM);
                        stmt2.setString(2, this.Nat_id);
                        stmt2.executeUpdate();
                        con.connection.commit();
                        JOptionPane.showMessageDialog((Component)null, "Password changed successfully");
                        this.setVisible(false);
                        new Main(this.Nat_id);
                    } catch (NumberFormatException var9) {
                        JOptionPane.showMessageDialog((Component)null, "PIN must consist of 4 digits");
                    } catch (SQLException var10) {
                        throw new RuntimeException(var10);
                    }
                }
            } else {
                JOptionPane.showMessageDialog((Component)null, "Please enter the new password twice");
            }
        }

    }
}
