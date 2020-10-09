import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//TODO Error handler servlet should return some warnings on jsp
public class ErrorHandlerServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter pw = resp.getWriter();
        System.out.println("error handler start working");
        System.out.println(req.getSession().getServletContext().getAttribute("ErrorType:" + req.getSession().getId()));
        pw.println(req.getSession().getServletContext().getAttribute("ErrorType:" + req.getSession().getId()));
    }
}
