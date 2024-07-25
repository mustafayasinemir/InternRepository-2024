package i2i_intern;

import java.sql.*;
import java.util.Random;

public class Oracle {

    public Connection connection(String username, String password) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", username, password);
        } catch (Exception e) {
            System.out.println("Connection error: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public long insertNumbers(Connection conn) throws SQLException {
        String SQL = "INSERT INTO NUMBERS(ID, NUM) VALUES(?, ?)";
        long startTime = System.currentTimeMillis();

        try (PreparedStatement statement = conn.prepareStatement(SQL)) {
            Random rand = new Random();
            for (int i = 0; i < 100000; i++) {
                int randInt = rand.nextInt();
                statement.setInt(1, i);
                statement.setInt(2, randInt);
                statement.executeUpdate();
            }
        } catch (SQLException ex) {
            System.out.println("Insert error: " + ex.getMessage());
            ex.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public long selectNumbers(Connection conn) throws SQLException {
        String SQL = "SELECT * FROM NUMBERS";
        long startTime = System.currentTimeMillis();

        try (Statement statement = conn.createStatement();
             ResultSet result = statement.executeQuery(SQL)) {

            while (result.next()) {
                result.getInt(1);
                result.getInt(2);
            }
        } catch (SQLException ex) {
            System.out.println("Select error: " + ex.getMessage());
            ex.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public void closeConnection(Connection conn) throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }
}
