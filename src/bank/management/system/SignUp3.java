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
import java.util.Random;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class SignUp3 extends JFrame implements ActionListener {
    JLabel label1 = new JLabel("Account type: ");
    JLabel label2;
    JLabel label3;
    JLabel label4;
    JLabel label5;
    JRadioButton r1;
    JRadioButton r2;
    JRadioButton m1;
    JRadioButton m2;
    JCheckBox c5;
    JButton button1;
    JButton EXIT;
    User temp;

    SignUp3(User x) {
        this.label1.setFont(new Font("Arial", 1, 28));
        this.label1.setForeground(Color.WHITE);
        this.label1.setBounds(30, 150, 250, 40);
        this.add(this.label1);
        this.m1 = new JRadioButton("Saving account");
        this.m1.setFont(new Font("Raleway", 1, 18));
        this.m1.setOpaque(false);
        this.m1.setBounds(30, 200, 200, 30);
        this.add(this.m1);
        this.m2 = new JRadioButton("Current account");
        this.m2.setFont(new Font("Raleway", 1, 18));
        this.m2.setOpaque(false);
        this.m2.setBounds(30, 250, 200, 30);
        this.add(this.m2);
        this.r1 = new JRadioButton("Fixed deposit account");
        this.r1.setFont(new Font("Raleway", 1, 18));
        this.r1.setOpaque(false);
        this.r1.setBounds(220, 250, 300, 30);
        this.add(this.r1);
        this.r2 = new JRadioButton("Recurring deposit account");
        this.r2.setFont(new Font("Raleway", 1, 18));
        this.r2.setOpaque(false);
        this.r2.setBounds(220, 200, 300, 30);
        this.add(this.r2);
        ButtonGroup statusGroup = new ButtonGroup();
        statusGroup.add(this.m1);
        statusGroup.add(this.m2);
        statusGroup.add(this.r1);
        statusGroup.add(this.r2);
        this.label2 = new JLabel("Card number:    XXXX - XXXX - XXXX - 4841");
        this.label2.setFont(new Font("Arial", 1, 28));
        this.label2.setOpaque(false);
        this.label2.setForeground(Color.white);
        this.label2.setBounds(30, 300, 600, 28);
        this.add(this.label2);
        this.label3 = new JLabel("Your 16-digit card number will appear on your ATM card & your banking app");
        this.label3.setFont(new Font("Arial", 1, 14));
        this.label3.setOpaque(false);
        this.label3.setBounds(30, 330, 600, 28);
        this.add(this.label3);
        this.label4 = new JLabel("PIN: XXXX");
        this.label4.setFont(new Font("Arial", 1, 28));
        this.label4.setOpaque(false);
        this.label4.setForeground(Color.white);
        this.label4.setBounds(30, 380, 600, 28);
        this.add(this.label4);
        this.label5 = new JLabel("4-digit password");
        this.label5.setFont(new Font("Arial", 1, 14));
        this.label5.setOpaque(false);
        this.label5.setBounds(30, 410, 600, 28);
        this.add(this.label5);
        this.c5 = new JCheckBox(" I confirm that all my personal details are accurate");
        this.c5.setFont(new Font("Arial", 1, 20));
        this.c5.setOpaque(false);
        this.c5.setBounds(30, 500, 600, 28);
        this.add(this.c5);
        this.button1 = new JButton("Submit");
        this.button1.setBackground(new Color(59, 89, 182));
        this.button1.setForeground(Color.WHITE);
        this.button1.setFocusPainted(false);
        this.button1.setFont(new Font("Tahoma", 1, 20));
        this.button1.setBounds(260, 600, 250, 30);
        this.button1.addActionListener(this);
        this.add(this.button1);
        this.EXIT = new JButton("EXIT");
        this.EXIT.setBounds(800, 15, 80, 25);
        this.setUndecorated(true);
        this.EXIT.setBackground(new Color(180, 70, 80));
        this.EXIT.setForeground(Color.WHITE);
        this.EXIT.setFocusPainted(false);
        this.EXIT.addActionListener(this);
        this.add(this.EXIT);
        this.temp = new User(x);
        ImageIcon background = new ImageIcon(ClassLoader.getSystemResource("icons/form3.png"));
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
        if (e.getSource() == this.EXIT) {
            System.exit(0);
        }

        if (e.getSource() == this.button1) {
            if (this.c5.isSelected() && (this.m1.isSelected() || this.m2.isSelected() || this.r1.isSelected() || this.r2.isSelected())) {
                String account_type = "";
                if (this.m1.isSelected()) {
                    account_type = "Saving account";
                } else if (this.m2.isSelected()) {
                    account_type = "Current account";
                } else if (this.r1.isSelected()) {
                    account_type = "Fixed deposit account";
                } else if (this.r2.isSelected()) {
                    account_type = "Recurring deposit account";
                }
                try{
                    DataValidation.validateAccountType(account_type);
                }
                catch (InvalidDataException E)
                {
                    JOptionPane.showMessageDialog(null,E.getMessage());
                    return;
                }


                this.temp.setAccount_type(account_type);
                Random ran = new Random();
                long N = ran.nextLong() % 90000000L + 1409963000000000L;
                String cardNo = "" + N;
                Long M = ran.nextLong() % 9000L + 1000L;
                String pin = UserServices.generateUniquePin();
                this.temp.setPincode(pin);
                this.temp.setCardNo(cardNo);
                Conn con = new Conn();

                try {
                    con.connection.setAutoCommit(false);
                    String var10000 = this.temp.getFirstname();
                    String q = "INSERT INTO signup (first_name, last_name, birth_date, address, city, status, gender, email, national_id) VALUES ('" + var10000 + "', '" + this.temp.getLastname() + "', '" + this.temp.getBirthdate() + "', '" + this.temp.getAddress() + "', '" + this.temp.getCity() + "', '" + this.temp.getStatus() + "', '" + this.temp.getGender() + "', '" + this.temp.getEmail() + "', '" + this.temp.getNat_id() + "')";
                    con.stmt.executeUpdate(q);
                    var10000 = this.temp.getReligion();
                    q = "INSERT INTO signup2 (religion, income, education, occupation, existing_account, national_id) VALUES ('" + var10000 + "', '" + this.temp.getIncome() + "', '" + this.temp.getEducation() + "', '" + this.temp.getOccupation() +  "', '" + this.temp.getExisting_account() + "', '" + this.temp.getNat_id() + "')";
                    con.stmt.executeUpdate(q);
                    var10000 = this.temp.getAccount_type();
                    q = "INSERT INTO signup3 (atype, cardno, pin, national_id) VALUES ('" + var10000 + "', '" + this.temp.getCardNo() + "', '" + this.temp.getPincode() + "', '" + this.temp.getNat_id() + "')";
                    con.stmt.executeUpdate(q);
                    var10000 = this.temp.getNat_id();
                    q = "INSERT INTO signin (national_id, cardno, pin) VALUES ('" + var10000 + "', '" + this.temp.getCardNo() + "', '" + this.temp.getPincode() + "')";
                    con.stmt.executeUpdate(q);
                    con.connection.commit();
                    JOptionPane.showMessageDialog((Component)null, "card number: " + cardNo + "\npin code: " + this.temp.getPincode(), "Your account details", 1);
                    this.setVisible(false);
                    new Main(this.temp.getNat_id());
                } catch (SQLException var21) {
                    try {
                        con.connection.rollback();
                    } catch (SQLException var20) {
                        var20.printStackTrace();
                    }

                    throw new RuntimeException(var21);
                } finally {
                    try {
                        con.connection.setAutoCommit(true);
                        con.stmt.close();
                    } catch (SQLException var19) {
                        var19.printStackTrace();
                    }

                }
            } else {
                JOptionPane.showMessageDialog((Component)null, "please Select the account type and the check box below");
            }
        }

    }
}
