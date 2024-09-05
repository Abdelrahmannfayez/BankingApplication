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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main extends JFrame implements ActionListener {
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton button5;
    JButton button6;
    JButton button7;
    String nat_id;

    Main(String nat_id) {
        this.nat_id = nat_id;
        this.button1 = new JButton("Deposit");
        this.button1.setBounds(80, 180, 170, 30);
        this.button1.setForeground(Color.WHITE);
        this.button1.setBackground(Color.decode("#a6a6a6"));
        this.button1.setBorderPainted(false);
        this.button1.setFocusPainted(false);
        this.button1.setFont(new Font("Tahoma", 1, 16));
        this.button1.addActionListener(this);
        this.add(this.button1);
        this.button2 = new JButton("Cash withdrawl");
        this.button2.setBounds(300, 180, 170, 30);
        this.button2.setForeground(Color.WHITE);
        this.button2.setBackground(Color.decode("#a6a6a6"));
        this.button2.setBorderPainted(false);
        this.button2.setFocusPainted(false);
        this.button2.setFont(new Font("Tahoma", 1, 16));
        this.button2.addActionListener(this);
        this.add(this.button2);
        this.button3 = new JButton("Fast cash");
        this.button3.setBounds(80, 230, 170, 30);
        this.button3.setForeground(Color.WHITE);
        this.button3.setBackground(Color.decode("#a6a6a6"));
        this.button3.setBorderPainted(false);
        this.button3.setFocusPainted(false);
        this.button3.setFont(new Font("Tahoma", 1, 16));
        this.button3.addActionListener(this);
        this.add(this.button3);
        this.button4 = new JButton("Mini statement");
        this.button4.setBounds(300, 230, 170, 30);
        this.button4.setForeground(Color.WHITE);
        this.button4.setBackground(Color.decode("#a6a6a6"));
        this.button4.setBorderPainted(false);
        this.button4.setFocusPainted(false);
        this.button4.setFont(new Font("Tahoma", 1, 16));
        this.button4.addActionListener(this);
        this.add(this.button4);
        this.button5 = new JButton("PIN change");
        this.button5.setBounds(80, 280, 170, 30);
        this.button5.setForeground(Color.WHITE);
        this.button5.setBackground(Color.decode("#a6a6a6"));
        this.button5.setBorderPainted(false);
        this.button5.setFocusPainted(false);
        this.button5.setFont(new Font("Tahoma", 1, 16));
        this.button5.addActionListener(this);
        this.add(this.button5);
        this.button6 = new JButton("Balance enquiry");
        this.button6.setBounds(300, 280, 170, 30);
        this.button6.setForeground(Color.WHITE);
        this.button6.setBackground(Color.decode("#a6a6a6"));
        this.button6.setBorderPainted(false);
        this.button6.setFocusPainted(false);
        this.button6.setFont(new Font("Tahoma", 1, 16));
        this.button6.addActionListener(this);
        this.add(this.button6);
        this.button7 = new JButton("EXIT");
        this.button7.setBounds(300, 350, 170, 30);
        this.button7.setForeground(Color.WHITE);
        this.button7.setBackground(Color.decode("#a6a6a6"));
        this.button7.setBorderPainted(false);
        this.button7.setFocusPainted(false);
        this.button7.setFont(new Font("Tahoma", 1, 16));
        this.button7.addActionListener(this);
        this.add(this.button7);
        ImageIcon background = new ImageIcon(ClassLoader.getSystemResource("icons/main.png"));
        Image img = background.getImage();
        background = new ImageIcon(img);
        JLabel back = new JLabel(background);
        back.setBounds(0, 0, 900, 700);
        this.add(back);
        this.setUndecorated(true);
        this.setDefaultCloseOperation(3);
        this.setResizable(false);
        this.setSize(900, 700);
        this.setLocationRelativeTo((Component)null);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.button1) {
            this.setVisible(false);
            new Deposit(this.nat_id);
        } else if (e.getSource() == this.button2) {
            this.setVisible(false);
            new Withdrawal(this.nat_id);
        } else if (e.getSource() == this.button3) {
            this.setVisible(false);
            new bank.management.system.FastCash(this.nat_id);
        } else if (e.getSource() == this.button5) {
            this.setVisible(false);
            new PINChange(this.nat_id);
        } else if (e.getSource() == this.button4) {
            this.setVisible(false);
            new MiniStatement(this.nat_id);
        } else if (e.getSource() == this.button6) {
            this.setVisible(false);
            new BalanceEnquiry(this.nat_id);
        } else if (e.getSource() == this.button7) {
            System.exit(0);
        }

    }
}
