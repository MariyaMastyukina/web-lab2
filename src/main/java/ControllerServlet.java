import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class ControllerServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        if (req.getMethod().equals("POST")) {
            try {
                //do I need a thread-safe map here? probably yes
                Map<String, String[]> parMap = req.getParameterMap();
                if (parMap.containsKey("X") && parMap.containsKey("Y") && parMap.containsKey("R")) {
                    req.getRequestDispatcher("/areaCheck").forward(req, resp);
                } else
                    req.getRequestDispatcher("index.jsp").forward(req, resp);
            } catch (NullPointerException | NumberFormatException e) {
                //TODO
            } catch (ServletException e) {
                //TODO
            } catch (IOException e) {
                //TODO
            }
        }
    }
}
