import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLJDBCTest {
    public static Connection connect() throws SQLException {
        Config config = new Config();
        Connection connection = DriverManager.getConnection(
                config.getUrl(),
                config.getUsername(),
                config.getPassword()
        );
        return connection;
    }

    public static void main(String[] args) {
        try {
            Connection connection = connect();
            Statement statement = connection.createStatement();
            String queryString = "SELECT * FROM User;";
            System.out.println("Connected");
            if (statement.execute(queryString)){
                System.out.println("Statement Successful");
            } else {
                System.out.println("Statement Exploded");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
