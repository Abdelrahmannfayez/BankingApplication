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
import javax.swing.*;

public class SignUp2 extends JFrame implements ActionListener {
    JLabel label1 = new JLabel("Religion: ");
    JLabel label2;
    JLabel label3;
    JLabel label5;
    JLabel label6;
    JLabel label7;
    JTextField textField1;
    JComboBox c1;
    JComboBox c2;
    JComboBox c3;
    JComboBox c4;
    JRadioButton m1;
    JRadioButton m2;
    JButton button1;
    JButton EXIT;
    User temp;
    ButtonGroup accStatusGroup;

    SignUp2(User x) {
        this.label1.setFont(new Font("Arial", 1, 28));
        this.label1.setForeground(Color.WHITE);
        this.label1.setBounds(30, 150, 250, 40);
        this.add(this.label1);
        String[] Religion = new String[]{"Muslim", "Christian", "Other"};
        this.c1 = new JComboBox(Religion);
        this.c1.setFont(new Font("Arial", 0, 20));
        this.c1.setForeground(Color.BLACK);
        this.c1.setBounds(260, 155, 250, 30);
        this.add(this.c1);
        this.label2 = new JLabel("Income: ");
        this.label2.setFont(new Font("Arial", 1, 28));
        this.label2.setForeground(Color.WHITE);
        this.label2.setBounds(30, 200, 250, 40);
        this.add(this.label2);
        String[] income = new String[]{"less than 50,000", "less than 200,000 ", "less than 500,000", "more than 500,000"};
        this.c2 = new JComboBox(income);
        this.c2.setFont(new Font("Arial", 0, 20));
        this.c2.setForeground(Color.BLACK);
        this.c2.setBounds(260, 205, 250, 30);
        this.add(this.c2);
        this.label3 = new JLabel("Education: ");
        this.label3.setFont(new Font("Arial", 1, 28));
        this.label3.setForeground(Color.WHITE);
        this.label3.setBounds(30, 250, 250, 40);
        this.add(this.label3);
        String[] edu = new String[]{"Non-graduate", "Graduate", "Post-graduate", "Doctrate", "Other"};
        this.c3 = new JComboBox(edu);
        this.c3.setFont(new Font("Raleway", 1, 18));
        this.c3.setOpaque(false);
        this.c3.setBounds(260, 255, 250, 30);
        this.add(this.c3);
        this.label5 = new JLabel("Occupation: ");
        this.label5.setFont(new Font("Arial", 1, 28));
        this.label5.setForeground(Color.WHITE);
        this.label5.setBounds(30, 350, 250, 40);
        this.add(this.label5);
        String[] occupation = new String[]{"Salaried", "Self-employed", "Business", "Student", "Retired", "Other"};
        this.c4 = new JComboBox(occupation);
        this.c4.setFont(new Font("Arial", 0, 20));
        this.c4.setForeground(Color.BLACK);
        this.c4.setBounds(260, 355, 250, 30);
        this.add(this.c4);
        this.label7 = new JLabel("Existing Account: ");
        this.label7.setFont(new Font("Arial", 1, 28));
        this.label7.setForeground(Color.WHITE);
        this.label7.setBounds(30, 400, 250, 40);
        this.add(this.label7);
        this.m1 = new JRadioButton("Yes");
        this.m1.setFont(new Font("Raleway", 1, 18));
        this.m1.setOpaque(false);
        this.m1.setBounds(300, 405, 150, 30);
        m1.setActionCommand("Yes");
        this.add(this.m1);
        this.m2 = new JRadioButton("NO");
        this.m2.setFont(new Font("Raleway", 1, 18));
        this.m2.setOpaque(false);
        this.m2.setBounds(450, 405, 150, 30);
        m2.setActionCommand("No");
        this.add(this.m2);
        accStatusGroup = new ButtonGroup();
        accStatusGroup.add(this.m1);
        accStatusGroup.add(this.m2);
        this.button1 = new JButton("Next");
        this.button1.setBackground(new Color(59, 89, 182));
        this.button1.setForeground(Color.WHITE);
        this.button1.setFocusPainted(false);
        this.button1.setFont(new Font("Tahoma", 1, 20));
        this.button1.setBounds(260, 600, 250, 30);
        this.button1.addActionListener(this);
        this.add(this.button1);
        this.temp = new User(x);
        this.EXIT = new JButton("EXIT");
        this.EXIT.setBounds(800, 15, 80, 25);
        this.setUndecorated(true);
        this.EXIT.setBackground(new Color(180, 70, 80));
        this.EXIT.setForeground(Color.WHITE);
        this.EXIT.setFocusPainted(false);
        this.EXIT.addActionListener(this);
        this.add(this.EXIT);
        ImageIcon background = new ImageIcon(ClassLoader.getSystemResource("icons/form2.png"));
        Image img = background.getImage();
        background = new ImageIcon(img);
        JLabel back = new JLabel(background);
        back.setBounds(0, 0, 900, 700);
        this.add(back);
        this.setTitle("Application Form");
        this.setDefaultCloseOperation(3);
        this.setResizable(false);
        this.setSize(900, 700);
        this.setLocationRelativeTo((Component) null);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.button1) {
            String religion = (String) this.c1.getSelectedItem();
            String income = (String) this.c2.getSelectedItem();
            String eduacation = (String) this.c3.getSelectedItem();
            String occupation = (String) this.c4.getSelectedItem();
            ButtonModel selectedModel = accStatusGroup.getSelection();
            String existing_account="";
            if(m1.isSelected())existing_account="Yes";
            else if(m2.isSelected())existing_account="No";

            //Data validation
            try {

                DataValidation.validateReligion(religion);
                DataValidation.validateIncome(income);
                DataValidation.validateEducation(eduacation);
                DataValidation.validateOccupation(occupation);
                DataValidation.validateExistigAccount(existing_account);


            } catch (InvalidDataException E) {
                JOptionPane.showMessageDialog(null, E.getMessage());
                return;
            }


            this.temp.setReligion(religion);
            this.temp.setIncome(income);
            this.temp.setEducation(eduacation);
            this.temp.setOccupation(occupation);


            this.temp.setExisting_account(existing_account);
            new SignUp3(this.temp);
            this.setVisible(false);
        } else if (e.getSource() == this.EXIT) {
            System.exit(0);
        }

    }
}
