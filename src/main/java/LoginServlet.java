import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        if (session.getAttribute("loggedIn") != null) {
            String isLogged = (String) session.getAttribute("loggedIn");
            if (isLogged.equalsIgnoreCase("user")) {
                response.sendRedirect("/profile");
            } else {
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        } else {
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean validAttempt = username.equals("admin") && password.equals("p");

        if (validAttempt) {
            response.sendRedirect("/profile");
        } else {
            response.sendRedirect("/login");
        }
    }
}
