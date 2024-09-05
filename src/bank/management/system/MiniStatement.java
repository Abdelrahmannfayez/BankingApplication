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
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MiniStatement extends JFrame implements ActionListener {
    JButton button7;
    JButton EXIT;
    String nat_id;
    String firstName;
    String lastName;
    JLabel label1;
    JLabel name;

    MiniStatement(String nat_id) {
        this.nat_id = nat_id;
        User Temp = new User();
        Temp.setNat_id(nat_id);
        int balance = Temp.CalcBalance();
        Conn con = new Conn();
        String q1 = "Select * From signup Where national_id = '" + this.nat_id + "' ";

        try {
            for(ResultSet rs = con.stmt.executeQuery(q1); rs.next(); this.lastName = rs.getString("last_name")) {
                this.firstName = rs.getString("first_name");
            }
        } catch (Exception var16) {
            JOptionPane.showMessageDialog((Component)null, var16.getMessage());
            System.out.println(var16.toString());
        }

        String[] columns = new String[]{"Date", "Type", "Amount"};
        List<String[]> Data = new ArrayList();
        String q = "Select * From atm Where national_id = '" + this.nat_id + "' ";

        try {
            ResultSet rs = con.stmt.executeQuery(q);

            while(rs.next()) {
                Data.add(new String[]{rs.getString("date"), rs.getString("type"), rs.getString("amount")});
            }
        } catch (Exception var15) {
            JOptionPane.showMessageDialog((Component)null, var15.getMessage());
            System.out.println(var15.toString());
        }

        String[][] rowData = (String[][])Data.toArray(new String[0][]);
        JTable table = new JTable(rowData, columns) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        scrollPane.setBounds(80, 220, 400, 150);
        this.add(scrollPane);
        this.name = new JLabel(this.firstName + " " + this.lastName);
        this.name.setFont(new Font("Ralway", 1, 19));
        this.name.setForeground(Color.WHITE);
        this.name.setBounds(175, 130, 400, 30);
        this.add(this.name);
        this.label1 = new JLabel("Account Balance in EGP: " + balance + " ");
        this.label1.setFont(new Font("Ralway", 1, 20));
        this.label1.setForeground(Color.WHITE);
        this.label1.setBounds(80, 160, 400, 40);
        this.add(this.label1);
        this.button7 = new JButton("Back");
        this.button7.setBounds(300, 400, 170, 30);
        this.button7.setForeground(Color.WHITE);
        this.button7.setBackground(Color.decode("#a6a6a6"));
        this.button7.setBorderPainted(false);
        this.button7.setFocusPainted(false);
        this.button7.setFont(new Font("Tahoma", 1, 16));
        this.button7.addActionListener(this);
        this.add(this.button7);
        this.EXIT = new JButton("EXIT");
        this.EXIT.setBounds(780, 634, 80, 25);
        this.setUndecorated(true);
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
