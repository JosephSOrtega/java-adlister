import java.sql.SQLException;

public class DaoFactory {
    private static Ads adsDao;

    public static Ads getAdsDao() {
        try {
            adsDao = new MySQLAdsDao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return adsDao;
    }
}
