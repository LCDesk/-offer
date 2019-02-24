public class P9矩阵覆盖 {
    public int RectCover(int target) {
        if (target == 1) {
            return 1;
        }
        int[] dp = new int[target + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[target];
    }
}
