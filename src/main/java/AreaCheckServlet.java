import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class AreaCheckServlet extends HttpServlet {
    // thread-safe ?
    private List<Integer> arr = Arrays.asList(-5, -4, -3, -2, -1, 0, 1, 2, 3);
    private Logger log = Logger.getLogger(AreaCheckServlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        log.info("SESSION = " + session);
        long start = System.nanoTime();
        resp.setContentType("text/html");
        if (checkAcceptableValues(req, resp)) {
            double x = Double.parseDouble(req.getParameter("x_value"));
            int y = Integer.parseInt(req.getParameter("y_value"));
            double r = Double.parseDouble(req.getParameter("r_value"));
            log.info("Это информационное сообщение!");
            String res = checkODZ(x, y, r) ? "TRUE" : "FALSE";
            session.getServletContext().setAttribute(session.getId(), getTable(x, y, r, res, System.nanoTime() - start, new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime()), session));
            send(req, resp);
        } else {
            log.info("ODZ ERROR");
            //TODO add new Error handler servlet and delegate to him other work ?
        }
    }

    //TODO
    private List<String> getTable(double x, int y, double r, String res, long script_time, String current_time, HttpSession session) {
        //add some class Table Row ?
        List<String> table = session.getServletContext().getAttribute(session.getId()) == null ? new ArrayList<String>() : (List<String>) session.getServletContext().getAttribute(session.getId());
        table.add(getTableRow(x, y, r, res, script_time, current_time));
        return table;
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

    private boolean checkAcceptableValues(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            double x = Double.parseDouble(req.getParameter("x_value"));
            int y = Integer.parseInt(req.getParameter("y_value"));
            double r = Double.parseDouble(req.getParameter("r_value"));
            return (x < 5 && x > -3 && r > 2 && r < 5 && arr.contains(y)); // add regexp condition
        } catch (NumberFormatException | NullPointerException e) {
            req.getSession().getServletContext().setAttribute("ErrorType:" + req.getSession().getId(), e.toString());
            req.getSession().getServletContext().getRequestDispatcher("/ErrorHandlerServlet").forward(req, resp);
            return false;
        } catch (Exception e) {
            req.getSession().getServletContext().setAttribute("ErrorType:" + req.getSession().getId(), "It's bad");
            req.getSession().getServletContext().getRequestDispatcher("/ErrorHandlerServlet").forward(req, resp);
            return false;
        }

    }

    private String getTableRow(double x, int y, double r, String res, long script_time, String current_time) {
        return "<tr>" +
                "<td>" + x + "</td>" +
                "<td>" + y + "</td>" +
                "<td>" + r + "</td>" +
                "<td>" + current_time + "</td>" +
                "<td>" + script_time + "</td>" +
                "<td>" + res + "</td>";
    }

    private void send(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter pw = resp.getWriter();
        List<String> table = (List<String>) req.getSession().getServletContext().getAttribute(req.getSession().getId());
        pw.println(getServletContext().getAttribute("table_structure"));
        for (String table_row : table) {
            pw.println(table_row);
            log.info(table_row);
        }
    }
}
