import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ApplyServlet", urlPatterns = "/apply")
public class ApplyServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the session attr named program so we can decide the price
        String program = (request.getSession().getAttribute("program") == null) ? "" : (String) request.getSession().getAttribute("program");
        if(program.equals("DS")){
            request.setAttribute("price", 10);
        }else{
            request.setAttribute("price", 11);
        }
//        request.getRequestDispatcher("/WEB-INF/apply.jsp").forward(request, response);
        request.getRequestDispatcher("apply.jsp").forward(request, response);
    }
}
