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
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Deposit extends JFrame implements ActionListener {
    JTextField textField1;
    JButton button1;
    JButton EXIT;
    JButton button2;
    String nat_id;

    public Deposit(String nat_id) {
        this.nat_id = nat_id;
        this.textField1 = new JTextField();
        this.textField1.setFont(new Font("Arial", 0, 28));
        this.textField1.setForeground(Color.BLACK);
        this.textField1.setBounds(90, 220, 390, 50);
        this.add(this.textField1);
        this.button1 = new JButton("Back");
        this.button1.setBackground(Color.white);
        this.button1.setForeground(new Color(59, 89, 182));
        this.button1.setFocusPainted(false);
        this.button1.setFont(new Font("Tahoma", 1, 16));
        this.button1.setBounds(600, 600, 120, 30);
        this.button1.addActionListener(this);
        this.add(this.button1);
        this.button2 = new JButton("Deposit");
        this.button2.setBackground(Color.white);
        this.button2.setForeground(new Color(59, 89, 182));
        this.button2.setFocusPainted(false);
        this.button2.setFont(new Font("Tahoma", 1, 16));
        this.button2.setBounds(740, 600, 120, 30);
        this.button2.addActionListener(this);
        this.add(this.button2);
        this.EXIT = new JButton("EXIT");
        this.EXIT.setBounds(800, 15, 80, 25);
        this.EXIT.setBackground(new Color(180, 70, 80));
        this.EXIT.setForeground(Color.WHITE);
        this.EXIT.setFocusPainted(false);
        this.EXIT.addActionListener(this);
        this.add(this.EXIT);
        ImageIcon background = new ImageIcon(ClassLoader.getSystemResource("icons/ATM1.png"));
        Image img = background.getImage();
        background = new ImageIcon(img);
        JLabel back = new JLabel(background);
        back.setBounds(0, 0, 900, 700);
        this.add(back);
        this.setTitle("Deposit");
        this.setUndecorated(true);
        this.setDefaultCloseOperation(3);
        this.setResizable(false);
        this.setSize(900, 700);
        this.setLocationRelativeTo((Component)null);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.button2) {
            String amount = this.textField1.getText();
            Date datee = new Date();
            String date = DateHandling.adjustDate(datee.toString());
            Conn con = new Conn();

            try {
                int process_amount = User.CheckIfValidAmount(amount);
                String q = "INSERT INTO atm (national_id, date, amount, type) VALUES ('" + this.nat_id + "', '" + date + "', '" + amount.strip() + "', 'deposit')";
                con.stmt.executeUpdate(q);
                JOptionPane.showMessageDialog((Component)null, amount.strip() + " LE are deposited Successfully", "Successfully Deposited", -1);
                this.setVisible(false);
                new Main(this.nat_id);
            } catch (NumberFormatException var8) {
                JOptionPane.showMessageDialog((Component)null, "Please enter a valid amount of money", "Invalid amount", 0);
            } catch (InvalidAmountException var9) {
                JOptionPane.showMessageDialog((Component)null, var9.getMessage(), "Invalid amount", 0);
            } catch (Exception var10) {
                JOptionPane.showMessageDialog((Component)null, "Something wrong with the request");
            }
        } else if (e.getSource() == this.button1) {
            this.setVisible(false);
            new Main(this.nat_id);
        } else if (e.getSource() == this.EXIT) {
            System.exit(0);
        }

    }
}
