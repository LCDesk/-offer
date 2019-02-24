public class P11数值的整次方 {
    public double Power(double base, int exponent) {
        if (exponent < 0) {
            exponent = -exponent;
            base = 1 / base;
        }
        double[] dp = new double[exponent + 1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = i % 2 == 0 ? dp[i / 2] * dp[i / 2] : dp[i / 2] * dp[i / 2] * base;
        }
        return dp[exponent];
    }

}
