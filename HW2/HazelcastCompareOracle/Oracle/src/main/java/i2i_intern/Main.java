package i2i_intern;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Oracle oracleTime = new Oracle();
        Connection conn = oracleTime.connection("SYSTEM", "YourPassword..");

        if (conn != null) {
            System.out.println("Oracle insert 100000 users time : " + oracleTime.insertNumbers(conn) + " ms");
            System.out.println("Oracle select 100000 users time : " + oracleTime.selectNumbers(conn) + " ms");

            oracleTime.closeConnection(conn);
        } else {
            System.out.println("Connection to Oracle DB failed.");
        }
    }
}
