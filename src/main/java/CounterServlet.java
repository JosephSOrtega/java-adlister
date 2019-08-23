import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "CounterServlet", urlPatterns = "/logout")
public class CounterServlet extends HttpServlet {
//    private int counter = 0;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        counter += 1;
//        response.getWriter().println("<h1>The count is " + counter + ".</h1>");request.getSession().invalidate();
        HttpSession session = request.getSession();
        request.getSession().removeAttribute("loggedIn");
        session.removeAttribute("loggedIn");
        request.getRequestDispatcher("/login").forward(request, response);



    }
}
