import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

public class ControllerServlet extends HttpServlet {
    private Logger log = Logger.getLogger(ControllerServlet.class);

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        if (req.getMethod().equals("POST")) {
            try {
                //do I need a thread-safe map here? probably yes;
                Map<String, String[]> parMap = req.getParameterMap();
                if (parMap.containsKey("x_value") && parMap.containsKey("y_value") && parMap.containsKey("r_value")) {
                    log.info(Arrays.toString(parMap.get("x_value")) + " " + Arrays.toString(parMap.get("y_value")) + " " + Arrays.toString(parMap.get("r_value")));
                    req.getRequestDispatcher("/areaCheck").forward(req, resp);
                } else {
                    log.info("error");
                    req.getRequestDispatcher("index.jsp").forward(req, resp);
                }
            } catch (NullPointerException | NumberFormatException e) {
                //TODO
            } catch (ServletException e) {
                //TODO
            }
        }
    }
}
