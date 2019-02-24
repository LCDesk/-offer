public class P49构建乘积数组 {
    public static int[] multiply(int[] A) {
        if (A == null || A.length == 0) {
            return A;
        }
        int[] B = new int[A.length];
        int[] pre = new int[A.length];
        int[] next = new int[A.length];
        pre[0] = 1;
        next[next.length - 1] = 1;
        for (int i = 1; i < A.length; i++) {
            pre[i] = pre[i - 1] * A[i - 1];
        }
        for (int i = A.length - 2; i >= 0; i--) {
            next[i] = next[i + 1] * A[i + 1];
        }
        for (int i = 0; i < B.length; i++) {
            B[i] = pre[i] * next[i];
        }
        return B;
    }

    public static void main(String[] args) {
        int[] arr = {2};
        for (int i : multiply(arr)) {
            System.out.println(i);
        }
    }

}
