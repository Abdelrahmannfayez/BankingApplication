//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package bank.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {
    String url = "jdbc:postgresql://localhost:5432/bank";
    String username = "postgres";
    String password = "afayez";
    Statement stmt;
    Connection connection;

    public Conn() {
        try {
            this.connection = DriverManager.getConnection(this.url, this.username, this.password);
            this.stmt = this.connection.createStatement();
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Conn();
    }
}
