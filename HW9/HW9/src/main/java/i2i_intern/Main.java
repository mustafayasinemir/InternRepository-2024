package i2i_intern;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Main {
    private static String jdbcUrl =AppSettings.jdbcUrl;
    private static String username = AppSettings.username;
    private static String password = AppSettings.password;

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcUrl, username, password);
    }

    public static void main(String[] args) {
        try {
            Class.forName("org.apache.ignite.IgniteJdbcThinDriver");
            Connection connection = Main.getConnection();
            Statement statement = connection.createStatement();

            String sqlQuery = "SELECT * FROM SUBSCRIBER";
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()) {
                int subscId = resultSet.getInt("SUBSC_ID");
                String subscName = resultSet.getString("SUBSC_NAME");
                String subscSurname = resultSet.getString("SUBSC_SURNAME");
                String msisdn = resultSet.getString("MSISDN");
                int tariffId = resultSet.getInt("TARIFF_ID");
                String startDate = resultSet.getString("START_DATE");

                System.out.println(subscId + " " + subscName + " "
                        + subscSurname + " " + msisdn
                        + " " + tariffId + " " + startDate);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
