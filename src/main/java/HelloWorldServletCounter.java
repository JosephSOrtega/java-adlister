import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/count")
public class HelloWorldServletCounter extends HttpServlet {
    long counter;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().println("You should see this in the browser");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>Counter went up by 1</h1>");
        out.println("<h3>"+counter+"</h1>");
        counter += 1;

        String query = request.getParameter("reset");
        System.out.println(query);
        if (query.equalsIgnoreCase("reset")) {
            counter = 0;
        }

    }

}

