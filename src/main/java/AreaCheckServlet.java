import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Date;

public class AreaCheckServlet extends HttpServlet {
    int[] arrayY={-4,-3,-2,-1,0,1,2,3,4,5};
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        double X=Double.parseDouble(req.getParameter("X"));
        int Y=Integer.parseInt(req.getParameter("Y"));
        double R=Double.parseDouble(req.getParameter("R"));
        if (X>-5&&X<3&& Arrays.asList(arrayY).contains(Y)&&R>0&&R<6){
            getServletContext().setAttribute("X",X);
            getServletContext().setAttribute("Y",Y);
            getServletContext().setAttribute("R",R);
            getServletContext().setAttribute("Result",check(X,Y,R));
            getServletContext().setAttribute("Current Time",new Date().getTime());
        }
        try (PrintWriter pw = resp.getWriter();) {
            pw.println("Java lies...");
        }
    }
    public boolean check(double X,int Y,double R){
        return (X>=0&&Y>=0&&X<=(R/2)&&Y<=R)||(X<=0&&Y<=X+R/2&&(X*X+Y*Y>=R*R/4));
    }
}
