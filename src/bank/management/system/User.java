//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package bank.management.system;

import java.awt.Component;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;

public class User {
    private String firstname;
    private String lastname;
    private String birthdate;
    private String pincode;
    private String address;
    private String city;
    private String status;
    private String Gender;
    private String email;
    private String nat_id;
    private String income;
    private String religion;
    private String education;
    private String occupation;

    private String existing_account;
    private String account_type;
    private String cardNo;

    public String getIncome() {
        return this.income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public String getReligion() {
        return this.religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getEducation() {
        return this.education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getOccupation() {
        return this.occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }



    public String getExisting_account() {
        return this.existing_account;
    }

    public void setExisting_account(String existing_account) {
        this.existing_account = existing_account;
    }

    public User() {
    }

    public User(String firstname, String lastname, String birthdate, String address, String city, String status, String gender, String email, String nationalId) {

        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.address = address;
        this.city = city;
        this.status = status;
        this.Gender = gender;
        this.email = email;
        this.nat_id = nationalId;

    }

    public User(User other) {
        if (other == null) {
            throw new IllegalArgumentException("Cannot copy from a null object");
        } else {
            this.firstname = other.firstname;
            this.lastname = other.lastname;
            this.cardNo = other.cardNo;
            this.birthdate = other.birthdate;
            this.address = other.address;
            this.city = other.city;
            this.status = other.status;
            this.Gender = other.Gender;
            this.email = other.email;
            this.nat_id = other.nat_id;
            this.income = other.income;
            this.religion = other.religion;
            this.education = other.education;
            this.occupation = other.occupation;

            this.existing_account = other.existing_account;
            this.pincode = other.pincode;
            this.account_type = other.account_type;

        }
    }

    public String toString() {
        return "User{firstname='" + this.firstname + "', lastname='" + this.lastname + "', birthdate='" + this.birthdate + "', address='" + this.address + "', city='" + this.city + "', status='" + this.status + "', Gender='" + this.Gender + "', email='" + this.email + "', nat_id='" + this.nat_id + "'}";
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getBirthdate() {
        return this.birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getPincode() {
        return this.pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGender() {
        return this.Gender;
    }

    public void setGender(String gender) {
        this.Gender = gender;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNat_id() {
        return this.nat_id;
    }

    public void setNat_id(String nat_id) {
        this.nat_id = nat_id;
    }

    public String getAccount_type() {
        return this.account_type;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }

    public String getCardNo() {
        return this.cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public int CalcBalance() {
        int x = 0;
        Conn con = new Conn();
        String q = "Select * From atm Where national_id = '" + this.nat_id + "' ";

        try {
            ResultSet rs = con.stmt.executeQuery(q);

            while (rs.next()) {
                int amount = Integer.parseInt(rs.getString("amount").strip());
                if (rs.getString("type").equals("deposit")) {
                    x += amount;
                } else {
                    x -= amount;
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
