import java.util.ArrayList;
import java.util.List;

public class P31丑数 {
    public static int GetUglyNumber_Solution(int index) {
        int res = 1;
        if (index == 0) {
            return res;
        }
        List<Integer> mult2 = new ArrayList<>();
        List<Integer> mult3 = new ArrayList<>();
        List<Integer> mult5 = new ArrayList<>();
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        while (index-- > 1) {
            mult2.add(res * 2);
            mult3.add(res * 3);
            mult5.add(res * 5);
            int min = Math.min(mult2.get(p2), Math.min(mult3.get(p3), mult5.get(p5)));
            if (min == mult2.get(p2)) {
                p2++;
            }
            if (min == mult3.get(p3)) {
                p3++;
            }
            if (min == mult5.get(p5)) {
                p5++;
            }
            res = min;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(GetUglyNumber_Solution(7));
    }
}
