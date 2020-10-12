import java.util.Arrays;
import java.util.List;

public class RowData {
    private List<Integer> arr = Arrays.asList(-5, -4, -3, -2, -1, 0, 1, 2, 3);
    double x;
    int y;
    double r;
    String res;
    long script_time;
    String current_time;

    public RowData(double x, int y, double r, String res, long script_time, String current_time) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.res = res;
        this.script_time = script_time;
        this.current_time = current_time;
    }

}
