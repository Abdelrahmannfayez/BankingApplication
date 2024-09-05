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

public class FastCash extends JFrame implements ActionListener {
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton button5;
    JButton button6;
    JButton button7;
    JButton EXIT;
    String nat_id;

    FastCash(String nat_id) {
        this.nat_id = nat_id;
        this.button1 = new JButton("100 EGP");
        this.button1.setBounds(80, 180, 170, 30);
        this.button1.setForeground(Color.WHITE);
        this.button1.setBackground(Color.decode("#a6a6a6"));
        this.button1.setBorderPainted(false);
        this.button1.setFocusPainted(false);
        this.button1.setFont(new Font("Tahoma", 1, 16));
        this.button1.addActionListener(this);
        this.add(this.button1);
        this.button2 = new JButton("300 EGP");
        this.button2.setBounds(300, 180, 170, 30);
        this.button2.setForeground(Color.WHITE);
        this.button2.setBackground(Color.decode("#a6a6a6"));
        this.button2.setBorderPainted(false);
        this.button2.setFocusPainted(false);
        this.button2.setFont(new Font("Tahoma", 1, 16));
        this.button2.addActionListener(this);
        this.add(this.button2);
        this.button3 = new JButton("500 EGP");
        this.button3.setBounds(80, 230, 170, 30);
        this.button3.setForeground(Color.WHITE);
        this.button3.setBackground(Color.decode("#a6a6a6"));
        this.button3.setBorderPainted(false);
        this.button3.setFocusPainted(false);
        this.button3.setFont(new Font("Tahoma", 1, 16));
        this.button3.addActionListener(this);
        this.add(this.button3);
        this.button4 = new JButton("1000 EGP");
        this.button4.setBounds(300, 230, 170, 30);
        this.button4.setForeground(Color.WHITE);
        this.button4.setBackground(Color.decode("#a6a6a6"));
        this.button4.setBorderPainted(false);
        this.button4.setFocusPainted(false);
        this.button4.setFont(new Font("Tahoma", 1, 16));
        this.button4.addActionListener(this);
        this.add(this.button4);
        this.button5 = new JButton("2000 EGP");
        this.button5.setBounds(80, 280, 170, 30);
        this.button5.setForeground(Color.WHITE);
        this.button5.setBackground(Color.decode("#a6a6a6"));
        this.button5.setBorderPainted(false);
        this.button5.setFocusPainted(false);
        this.button5.setFont(new Font("Tahoma", 1, 16));
        this.button5.addActionListener(this);
        this.add(this.button5);
        this.button6 = new JButton("5000 EGP");
        this.button6.setBounds(300, 280, 170, 30);
        this.button6.setForeground(Color.WHITE);
        this.button6.setBackground(Color.decode("#a6a6a6"));
        this.button6.setBorderPainted(false);
        this.button6.setFocusPainted(false);
        this.button6.setFont(new Font("Tahoma", 1, 16));
        this.button6.addActionListener(this);
        this.add(this.button6);
        this.button7 = new JButton("Back");
        this.button7.setBounds(300, 350, 170, 30);
        this.button7.setForeground(Color.WHITE);
        this.button7.setBackground(Color.decode("#a6a6a6"));
        this.button7.setBorderPainted(false);
        this.button7.setFocusPainted(false);
        this.button7.setFont(new Font("Tahoma", 1, 16));
        this.button7.addActionListener(this);
        this.add(this.button7);
        this.EXIT = new JButton("EXIT");
        this.EXIT.setBounds(780, 634, 80, 25);
        this.EXIT.setBackground(new Color(180, 70, 80));
        this.EXIT.setForeground(Color.WHITE);
        this.EXIT.setFocusPainted(false);
        this.EXIT.addActionListener(this);
        this.add(this.EXIT);
        ImageIcon background = new ImageIcon(ClassLoader.getSystemResource("icons/main.png"));
        Image img = background.getImage();
        background = new ImageIcon(img);
        JLabel back = new JLabel(background);
        back.setBounds(0, 0, 900, 700);
        this.add(back);
        this.setDefaultCloseOperation(3);
        this.setUndecorated(true);
        this.setResizable(false);
        this.setSize(900, 700);
        this.setLocationRelativeTo((Component)null);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.button7) {
            this.setVisible(false);
            new Main(this.nat_id);
        } else if (e.getSource() == this.EXIT) {
            System.exit(0);
        } else {
            int indx = ((JButton)e.getSource()).getText().indexOf("EGP");
            String strAmount = ((JButton)e.getSource()).getText().substring(0, indx);
            int amount = Integer.parseInt(strAmount.strip());
            Date datee = new Date();
            String date = User.adjustDate(datee.toString());
            Conn con = new Conn();

            try {
                User Temp = new User();
                Temp.setNat_id(this.nat_id);
                int balance = Temp.CalcBalance();
                if (balance < amount) {
                    throw new InvalidAmountException("Sorry, Insufficient Balance!");
                }

                String q = "INSERT INTO atm (national_id, date, amount, type) VALUES ('" + this.nat_id + "', '" + date + "', '" + strAmount.strip() + "', 'withdrawal')";
                con.stmt.executeUpdate(q);
                JOptionPane.showMessageDialog((Component)null, "" + amount + " LE are withdraw Successfully \n your balance '" + Temp.CalcBalance() + "'", "Successfully Withdraw", -1);
                this.setVisible(false);
                new Main(this.nat_id);
            } catch (InvalidAmountException var11) {
                JOptionPane.showMessageDialog((Component)null, var11.getMessage(), "Invalid amount", 0);
            } catch (SQLException var12) {
                JOptionPane.showMessageDialog((Component)null, var12.getMessage());
            }
        }

    }
}
