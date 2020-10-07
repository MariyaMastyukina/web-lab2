//import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.logging.Logger;

public class ControllerServlet extends HttpServlet {
    private Logger log = Logger.getLogger(ControllerServlet.class.getName());

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.setContentType("text/html");
            if (req.getMethod().equals("POST")) {
                Map<String, String[]> parMap = req.getParameterMap();
                if (parMap.containsKey("x_value") && parMap.containsKey("y_value") && parMap.containsKey("r_value")) {
                    log.info(Arrays.toString(parMap.get("x_value")) + " " + Arrays.toString(parMap.get("y_value")) + " " + Arrays.toString(parMap.get("r_value")));
                    req.getRequestDispatcher("/areaCheck").forward(req, resp);
                } else {
                    log.info("Request didn't contains X or Y or R");
                    req.getRequestDispatcher("index.jsp").forward(req, resp);
                }
            }
        } catch (NumberFormatException | NullPointerException e) {
            req.getSession().getServletContext().setAttribute("ErrorType:" + req.getSession().getId(), e.toString());
            req.getSession().getServletContext().getRequestDispatcher("/ErrorHandlerServlet").forward(req, resp);
        } catch (Exception e) {
            req.getSession().getServletContext().setAttribute("ErrorType:" + req.getSession().getId(), "It's bad");
            req.getSession().getServletContext().getRequestDispatcher("/ErrorHandlerServlet").forward(req, resp);
        }
    }

    @Override
    public void init() {
        getServletContext().setAttribute("table_structure",
                "<tr>\n" +
                        "<th width=\"10%\">X</th>\n" +
                        "<th width=\"10%\">Y</th>\n" +
                        "<th width=\"10%\">R</th>\n" +
                        "<th width=\"16.7%\">Current Time</th>\n" +
                        "<th width=\"16.7%\">Execution Time</th>\n" +
                        "<th width=\"16.7%\">Hit Result</th>\n" +
                        "</tr>");
    }
}
