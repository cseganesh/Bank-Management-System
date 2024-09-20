package banking_system;

import java.sql.*;

public class Conn {
    Connection c;
    Statement s;
    public Conn() {
        try {
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "Ganesh@1120KM");
            s = c.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
