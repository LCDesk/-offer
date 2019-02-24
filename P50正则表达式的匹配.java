public class P50正则表达式的匹配 {
    public static boolean match(char[] str, char[] pattern) {
        if (str == null) {
            return false;
        }
        return match2(str, pattern);
    }

    private static boolean process(char[] str, char[] pattern, int i, int j) {
        if (j == pattern.length) {
            return i == str.length;
        }
        if (j == pattern.length - 1 || pattern[j + 1] != '*') {
            return i != str.length && (str[i] == pattern[j] || pattern[j] == '.') && process(str, pattern, i + 1, j + 1);
        }
        while (i != str.length && (str[i] == pattern[j] || pattern[j] == '.')) {
            if (process(str, pattern, i, j + 2)) {
                return true;
            }
            i++;
        }
        return process(str, pattern, i, j + 2);
    }

    public static boolean match2(char[] s, char[] p) {
        boolean[][] dp = new boolean[p.length + 1][s.length + 1];
        dp[p.length][s.length] = true;
        for (int j = p.length - 1; j >= 0; j--) {
            for (int i = 0; i < s.length + 1; i++) {
                if (j == p.length - 1 || p[j + 1] != '*') {
                    dp[j][i] = i != s.length && (p[j] == s[i] || p[j] == '.') && dp[j + 1][i + 1];
                } else {
                    int index = i;
                    while (index != s.length && (s[index] == p[j] || p[j] == '.')) {
                        if (dp[j + 2][index]) {
                            dp[j][i] = true;
                            break;
                        }
                        index++;
                    }
                    if (!dp[j][i]) {
                        dp[j][i] = dp[j + 2][index];
                    }
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        char[] str = {'a', 'a', 'a'};
        char[] pat = {'a', '*', 'a'};
        System.out.println(match2(str, pat));


    }

}
