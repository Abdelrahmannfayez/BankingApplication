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

public class BalanceEnquiry extends JFrame implements ActionListener {
    JButton button7;
    JButton EXIT;
    String nat_id;
    JLabel label1;

    BalanceEnquiry(String nat_id) {
        this.nat_id = nat_id;
        User Temp = new User();
        Temp.setNat_id(nat_id);
        int balance = Temp.CalcBalance();
        this.label1 = new JLabel("Your Current Balance in EGP: " + balance + " ");
        this.label1.setFont(new Font("Ralway", 1, 20));
        this.label1.setForeground(Color.WHITE);
        this.label1.setBounds(80, 200, 400, 40);
        this.add(this.label1);
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
        this.EXIT.setBounds(800, 15, 80, 25);
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
        this.setTitle("Balance Enquiry");
        this.setDefaultCloseOperation(3);
        this.setResizable(false);
        this.setUndecorated(true);
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
        }

    }
}
