import java.sql.*;
import java.util.List;

public class MySQLAdsDao implements Ads {

    private Connection connection;
    public static MySQLAdsDao daBomb;

    static {
        try {
            daBomb = new MySQLAdsDao(connect());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<Ad> all() throws SQLException {
        try {
            Statement statement = connection.createStatement();
            String queryString = "SELECT * FROM ads;";
            System.out.println("Connected");
            ResultSet rs = statement.executeQuery(queryString);
            if (rs != null) {
                System.out.println("Statement Successful");
                while (rs.next()) {
                    System.out.println("Here's the ad:");
                    System.out.println("  id: " + rs.getLong("id"));
                    System.out.println("  title: " + rs.getString("title"));
                    System.out.println("  description: " + rs.getString("description"));
                    return null;
                }
            } else {
                System.out.println("Statement Exploded");
                return null;


            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;

        }
        return null;

    }

    @Override
    public Long insert(Ad ad) {
        try {
            Statement statement = connection.createStatement();
            System.out.println("Connected");
            boolean rs = statement.execute("INSERT INTO ads(user_id, title, description) value (" + ad.getUserId() + ", '" + ad.getTitle() + "', '" + ad.getDescription() + "')");
            String queryString = "SELECT * FROM ads where title = '" + ad.getTitle() + "';";
            ResultSet work = statement.executeQuery(queryString);
            if (work != null) {
                System.out.println("Success");
                return null;
            } else {
                System.out.println("Failed");
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Connection connect() throws SQLException {
        Config config = new Config();
        Connection connection = DriverManager.getConnection(
                config.getUrl(),
                config.getUsername(),
                config.getPassword()
        );
        return connection;
    }

    public MySQLAdsDao(Connection connection) throws SQLException {
        this.connection = connection;
    }

    public static void main(String[] args) throws SQLException {
        Ad prect = new Ad(1, "Puppers", "Free for 20 bucks");
        daBomb.all();
        daBomb.insert(prect);

        //        try {
//            Connection connection = connect();
//            Statement statement = connection.createStatement();
//            System.out.println("Connected");
//            int rs = statement.executeUpdate("INSERT INTO User(username,email, password) VALUES ('mainTest','EmailHere', 'pass')");
//            if (rs > -1) {
//                System.out.println("Statement Successful");
//            } else {
//                System.out.println("Statement Exploded");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//


    }
}


