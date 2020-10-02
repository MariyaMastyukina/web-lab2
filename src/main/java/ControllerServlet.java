import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ControllerServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.setContentType("text/html");
        String method=req.getMethod();
        if (method.equals("POST")){
            try {
                double x = Double.parseDouble(req.getParameter("X"));
                int y = Integer.parseInt(req.getParameter("Y"));
                double r = Double.parseDouble(req.getParameter("R"));
                req.getRequestDispatcher("/areaChecker").forward(req,resp);

            }
            catch (NullPointerException | NumberFormatException  e){
                req.getRequestDispatcher("index.jsp").forward(req,resp);
            }
            catch(ServletException e){
                try (PrintWriter pw = resp.getWriter();) {
                    pw.println("Java never lies!");
                }
            }
        }

    }
}
