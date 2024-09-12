package bank.management.system;

import org.jetbrains.annotations.NotNull;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;

public class DataValidation {
    public static void validateNames(@NotNull String Name) throws InvalidDataException {
        if (Name.isBlank()) {
            throw new InvalidDataException("please fill in first and last names correctly");
        }
    }

    public static void validateAddress(@NotNull String address, String city) throws InvalidDataException {
        if (address.isBlank() || city.isBlank()) {
            throw new InvalidDataException("please fill in Your address & city correctly");
        }
    }

    public static void validateNationalId(@NotNull String Natid) throws InvalidDataException {
        if (Natid.isBlank()) {
            throw new InvalidDataException("please fill in your national id correctly");
        } else if (Natid.length() != 14) {
            throw new InvalidDataException("national id must consist of 14 numbers");
        } else {
            try {
                Double.parseDouble(Natid);

            } catch (NumberFormatException e) {
                throw new InvalidDataException("national id must consist of 14 numbers");
            }
            Conn con = new Conn();
            String q = "Select * From signup where national_id = '"+Natid+"'";
            ResultSet rs = null;
            try {
                rs = con.stmt.executeQuery(q);
            } catch (SQLException e) {
                return;
            }
            try {
                if (rs.next())
                    throw new InvalidDataException("National ID has an already established account ");
            } catch (SQLException e) {
                return;
            }
        }
    }

    public static void validateBirthDate(@NotNull String Date) throws InvalidDataException {
        if (Date.isBlank()) {
            throw new InvalidDataException("please fill in your BirthDate");
        }
        int age = DateHandling.calcAge(Date);
        if (age < 18) {
            throw new InvalidDataException("Sorry you must be 18 or older to create a bank account");
        }
    }

    public static void validateStatus(@NotNull String status) throws InvalidDataException {
        if (status.isBlank()) {
            throw new InvalidDataException("please choose your current marital status");
        }
    }

    public static void validateGender( @NotNull String gender) throws InvalidDataException {
        if (gender.isBlank()) {
            throw new InvalidDataException("please choose your gender");
        }
    }

    public static void validateReligion(@NotNull String Religion) throws InvalidDataException {
        if (Religion.isBlank()) {
            throw new InvalidDataException("please choose your Religion");
        }
    }

    public static void validateIncome(@NotNull String income) throws InvalidDataException {
        if (income.isBlank()) {
            throw new InvalidDataException("please choose your income Range");
        }
    }

    public static void validateOccupation(@NotNull String occupation) throws InvalidDataException {
        if (occupation.isBlank()) {
            throw new InvalidDataException("please choose your current occupation");
        }
    }

    public static void validateEducation(@NotNull String education) throws InvalidDataException {
        if (education.isBlank()) {
            throw new InvalidDataException("please choose your level of education");
        }
    }

    public static void validateAccountType(@NotNull String education) throws InvalidDataException {
        if (education.isBlank()) {
            throw new InvalidDataException("please choose your level of education");
        }
    }

    public static void validateEmail(@NotNull String email) throws InvalidDataException {
        // Check if the email is blank
        if (email.isBlank()) {
            throw new InvalidDataException("Please fill in your Email");
        }

        // Define the regex pattern for email validation
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(emailRegex);

        // Validate the email format
        if (!pattern.matcher(email).matches()) {
            throw new InvalidDataException("Invalid email format");
        }
    }


    public static void validateExistigAccount(@NotNull String existingAccount) throws InvalidDataException {
        if (existingAccount.isBlank()) {
            throw new InvalidDataException("please fill in if you hava an existing account");
        }
    }
}
