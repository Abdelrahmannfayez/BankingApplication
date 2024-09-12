package bank.management.system;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
public class DateHandling {
    public static int calcAge(String date) {
        // Define the date format pattern
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d, yyyy");

        // Parse the input date
        LocalDate birthDate = LocalDate.parse(date, formatter);

        // Get the current date
        LocalDate currentDate = LocalDate.now();

        // Calculate the age
        Period age = Period.between(birthDate, currentDate);

        // Return the years part of the age
        return age.getYears();
    }

    public static String adjustDate(String date) {
        String ret = "";
        String[] arr = date.split(" ");
        ret = arr[0] + " " + arr[1] + " " + arr[2] + " " + arr[5];
        return ret;
    }

}
