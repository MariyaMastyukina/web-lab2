

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Date;

public class AreaCheckServlet extends HttpServlet {
    // thread-safe ?
    private int[] arrayY = {-4, -3, -2, -1, 0, 1, 2, 3, 4, 5};
    private Logger log = Logger.getLogger(AreaCheckServlet.class);

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        long start = new Date().getTime();
        resp.setContentType("text/html");
        if (checkAcceptableValues(req)) {
            double x = Double.parseDouble(req.getParameter("X"));
            int y = Integer.parseInt(req.getParameter("Y"));
            double r = Double.parseDouble(req.getParameter("R"));
            log.info("Это информационное сообщение!");
            String res = checkODZ(x, y, r) ? "TRUE" : "FALSE";
            getServletContext().setAttribute("table", getTable(x, y, r, res, new Date().getTime() - start, new Date().getTime()));
        } else {
            //TODO add new Error handler servlet and delegate to him other work ?
        }
    }

    //TODO
    private String getTable(double x, int y, double r, String res, long script_time, long current_time) {
        //add some class Table Row ?
        return "";
    }

    private boolean checkODZ(double x, int y, double r) {
        if (x >= 0 && y >= 0)
            return checkFirstQ(x, y, r);
        else if (x <= 0 && y <= 0)
            return checkThirdQ(x, y, r);
        else if (x >= 0 && y <= 0)
            return checkFourthQ(x, y, r);
        else
            return checkSecondQ(x, y, r);
    }

    private boolean checkFirstQ(double x, int y, double r) {
        return (x <= r / 2 && y <= r);
    }

    private boolean checkSecondQ(double x, int y, double r) {
        return (x - y + r / 2 >= 0);
    }

    private boolean checkThirdQ(double x, int y, double r) {
        return (x * x + y * y <= r * r / 4);
    }

    private boolean checkFourthQ(double x, int y, double r) {
        return false;
    }

    private boolean checkAcceptableValues(HttpServletRequest req) {
        try {
            double x = Double.parseDouble(req.getParameter("X"));
            int y = Integer.parseInt(req.getParameter("Y"));
            double r = Double.parseDouble(req.getParameter("R"));
            return (x < 5 && x > -3 && r > 2 && r < 5 && Arrays.asList(arrayY).contains(y)); // add regexp condition
        } catch (NumberFormatException | NullPointerException e) {
            //TODO some logic to add some info that sth went wrong with numbers to Error handler ?
            return false;
        } catch (Exception e) {
            //TODO some info to Error Handler about exception
            return false;
        }
    }
}
