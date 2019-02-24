public class P44圆圈中最后剩下的数 {
    public static int LastRemaining_Solution(int n, int m) {
        if (n == 0) {
            return -1;
        }
        int size = 2;
        int s = 0;
        int nw = 0;
        int old;
        while (size <= n) {
            s = (m - 1) % size;
            old = (nw + s + 1) % size;
            nw = old;
            size++;
        }
        return nw;
    }

    public static void main(String[] args) {
        System.out.println(LastRemaining_Solution(5, 3));
    }
}
