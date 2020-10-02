import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AreaCheckServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        double x=Double.parseDouble("X");
        int y=Integer.parseInt("Y");
        double r=Double.parseDouble("R");
        if ((x<=r/2&&y<=r&&x>0&&y>0)||(x<0&&y>0&&y<=(x+r/2)||)
        try (PrintWriter pw = resp.getWriter();) {
            pw.println("Java lies...");
        }
    }
}
