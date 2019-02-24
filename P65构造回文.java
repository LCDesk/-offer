public class P65构造回文 {

    public static int mindelete(String str) {
        char[] chars = str.toCharArray();
        char[] rechars = new char[chars.length];
        int index = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            rechars[index++] = chars[i];
        }
        int[][] dp = new int[chars.length + 1][chars.length + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i < dp.length; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i <= chars.length; i++) {
            for (int j = 1; j <= chars.length; j++) {
                if (chars[i - 1] == rechars[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return chars.length - dp[chars.length][chars.length];
    }

    public static void main(String[] args) {
        System.out.println(mindelete("abcda"));
    }
}
