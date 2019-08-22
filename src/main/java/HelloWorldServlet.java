import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HelloWorldServlet", urlPatterns = "/")
public class HelloWorldServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.getWriter().println("<h1>Hello, World!</h1>");
        Ads AdsDao = DaoFactory.getAdsDao();
        List<Ad> ads = AdsDao.all();
        request.setAttribute("ads", ads);
        request.getRequestDispatcher("/ads/ads.jsp").forward(request, response);

    }
}
