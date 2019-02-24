public class P8变态跳台阶 {
    public int JumpFloorII(int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = 2 * dp[i - 1];
        }
        return dp[target];
    }

}
