import java.util.WeakHashMap;

public class P6斐波那契数列 {
    public int Fibonacci(int n) {
        if (n < 2) {
            return n;
        }
        int last = 0;
        int pre = 1;
        int cur = 0;
        while (n-- - 2 >= 0) {
            cur = last + pre;
            last = pre;
            pre = cur;
        }
        return cur;
    }
}
