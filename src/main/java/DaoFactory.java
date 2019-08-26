import java.sql.SQLException;

public class DaoFactory {
    private static Ads adsDao;

    public static Ads getAdsDao() {
        adsDao = new MySQLAdsDao();
        return adsDao;
    }
}
