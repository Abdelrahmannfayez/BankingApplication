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
import java.sql.SQLException;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Withdrawal extends JFrame implements ActionListener {
    JTextField textField1;
    JButton button1;
    JButton EXIT;
    JButton button2;
    String nat_id;

    public Withdrawal(String nat_id) {
        this.nat_id = nat_id;
        this.textField1 = new JTextField();
        this.textField1.setFont(new Font("Arial", 0, 28));
        this.textField1.setForeground(Color.BLACK);
        this.textField1.setBounds(80, 420, 400, 50);
        this.add(this.textField1);
        this.button1 = new JButton("Back");
        this.button1.setBackground(Color.white);
        this.button1.setForeground(new Color(59, 89, 182));
        this.button1.setFocusPainted(false);
        this.button1.setFont(new Font("Tahoma", 1, 16));
        this.button1.setBounds(600, 600, 120, 30);
        this.button1.addActionListener(this);
        this.add(this.button1);
        this.button2 = new JButton("Withdraw");
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
        ImageIcon background = new ImageIcon(ClassLoader.getSystemResource("icons/ATM2.png"));
        Image img = background.getImage();
        background = new ImageIcon(img);
        JLabel back = new JLabel(background);
        back.setBounds(0, 0, 900, 700);
        this.add(back);
        this.setTitle("Withdraw");
        this.setDefaultCloseOperation(3);
        this.setResizable(false);
        this.setSize(900, 700);
        this.setUndecorated(true);
        this.setLocationRelativeTo((Component)null);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.button2) {
            String amount = this.textField1.getText();
            Date datee = new Date();
            String date = DateHandling.adjustDate(datee.toString());


            try {
                int process_amount = UserServices.CheckIfValidAmount(amount);
                UserServices Temp = new UserServices(nat_id);
                int balance = Temp.CalcBalance();
                if (balance < process_amount) {
                    throw new InvalidAmountException("Sorry, Insufficient Balance!");
                }

                String q = "INSERT INTO atm (national_id, date, amount, type) VALUES ('" + this.nat_id + "', '" + date + "', '" + amount.strip() + "', 'withdrawal')";

                DatabaseQuerying.executeUpdate(q);
                JOptionPane.showMessageDialog((Component)null, amount.strip() + " LE are withdrawn Successfully \n your balance '" + Temp.CalcBalance() + "'", "Successfully Withdraw", -1);
                this.setVisible(false);
                new Main(this.nat_id);
            } catch (NumberFormatException var10) {
                JOptionPane.showMessageDialog((Component)null, "Please enter a valid amount of money", "Invalid amount", 0);
            } catch (InvalidAmountException var11) {
                JOptionPane.showMessageDialog((Component)null, var11.getMessage(), "Invalid amount", 0);
            }
        } else if (e.getSource() == this.button1) {
            this.setVisible(false);
            new Main(this.nat_id);
        } else if (e.getSource() == this.EXIT) {
            System.exit(0);
        }

    }
}
