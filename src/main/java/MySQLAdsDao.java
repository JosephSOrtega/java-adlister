import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {

    private Connection connection;

//    {
//        try {
//            connection = connect();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }


//    private List<Ad> ads;

    public MySQLAdsDao() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Config config = new Config();
        Connection connections = DriverManager.getConnection(
                config.getUrl(),
                config.getUsername(),
                config.getPassword()
        );
                connection = connections;
    }


//    public void setConnection(Config connection) throws SQLException {
//        Connection connections = DriverManager.getConnection(
//                connection.getUrl(),
//                connection.getUsername(),
//                connection.getPassword()
//        );
//        this.connection = connections;
//    }

//    public Connection connect() throws SQLException {
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        Config config = new Config();
//        Connection connections = DriverManager.getConnection(
//                config.getUrl(),
//                config.getUsername(),
//                config.getPassword()
//        );
//        connection = connections;
//        return connections;
//    }


    public List<Ad> all() {
        List<Ad> ads = new ArrayList<>();
        try {
//            connection = connect();
            Statement statement = connection.createStatement();
            String queryString = "SELECT * FROM ads;";
            System.out.println("Connected");
            ResultSet rs = statement.executeQuery(queryString);
            if (rs != null) {
                System.out.println("Statement Successful");
                while (rs.next()) {
//                    System.out.println("Here's the ad:");
//                    System.out.println("  id: " + rs.getLong("id"));
//                    System.out.println("  title: " + rs.getString("title"));
//                    System.out.println("  description: " + rs.getString("description"));
                    Long id = rs.getLong("id");
                    Long userid = rs.getLong("user_id");
                    String title = rs.getString("title");

                    String desc = rs.getString("description");
                    ads.add(new Ad(id, userid, title, desc));
                }
                return ads;
            } else {
                System.out.println("Statement Exploded");
                return ads;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return ads;
        }
    }

    public Long insert(Ad ad) {
        try {
//            Connection connection = connect();
            Statement statement = connection.createStatement();
            System.out.println("Connected");
            String rs = "INSERT INTO ads(user_id, title, description) value (" + ad.getUserId() + ", '" + ad.getTitle() + "', '" + ad.getDescription() + "')";
            statement.executeUpdate(rs, Statement.RETURN_GENERATED_KEYS);
            ResultSet work = statement.getGeneratedKeys();
            if (work.next()) {
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

//    public static void main(String[] args) throws SQLException {
//        Ad prect = new Ad(1, "Puppers", "Free for 20 bucks");
//        List<Ad> here = DaoFactory.getAdsDao().all();
//        for (Ad ad : here) {
//            System.out.println(ad.getId());
//            System.out.println(ad.getUserId());
//            System.out.println(ad.getTitle());
//            System.out.println(ad.getDescription());
//
//        }
//        daBomb.insert(prect);

////        //        try {
//////            Connection connection = connect();
//////            Statement statement = connection.createStatement();
//////            System.out.println("Connected");
//////            int rs = statement.executeUpdate("INSERT INTO User(username,email, password) VALUES ('mainTest','EmailHere', 'pass')");
//////            if (rs > -1) {
//////                System.out.println("Statement Successful");
//////            } else {
//////                System.out.println("Statement Exploded");
//////            }
//////        } catch (SQLException e) {
//////            e.printStackTrace();
//////        }
//////
//////
////
////
//    }
}


