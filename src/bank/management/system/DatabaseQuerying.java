package bank.management.system;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseQuerying {
    public static ResultSet retreiveData(String query)
    {
        Conn con = new Conn();

        try {
            ResultSet rs = con.stmt.executeQuery(query);
            return rs;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public static void executeUpdate(String update)
    {
        Conn con = new Conn();
        try {
           con.stmt.executeUpdate(update);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
