package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserServices {
    private String nat_id;
    public UserServices(String nat_id)
    {
        this.nat_id = nat_id;
    }

    public int CalcBalance() {
        int x = 0;
        String q = "Select * From atm Where national_id = '" + this.nat_id + "' ";

        try {
            try (ResultSet rs = DatabaseQuerying.retreiveData(q)) {
                while (rs.next()) {
                    int amount = Integer.parseInt(rs.getString("amount").strip());
                    if (rs.getString("type").equals("deposit")) {
                        x += amount;
                    } else {
                        x -= amount;
                    }
                }
            }

            return x;
        } catch (Exception var6) {
            JOptionPane.showMessageDialog((Component) null, var6.getMessage());
            System.out.println(var6.toString());
            return x;
        }
    }

    public static int CheckIfValidAmount(String amount) throws NumberFormatException, InvalidAmountException {
        int x = Integer.parseInt(amount.strip());
        if (x > 0 && x <= 7000) {
            return x;
        } else {
            throw new InvalidAmountException("Please enter a valid amount of money, Maximum of 7,000 LE");
        }
    }



    public static String generateUniquePin() {
        List<Integer> digits = new ArrayList();

        for (int i = 0; i < 10; ++i) {
            digits.add(i);
        }

        Collections.shuffle(digits);
        StringBuilder pin = new StringBuilder();

        for (int i = 0; i < 4; ++i) {
            pin.append(digits.get(i));
        }

        return pin.toString();
    }
}

