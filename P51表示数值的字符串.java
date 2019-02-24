public class P51表示数值的字符串 {
    public static boolean isNumeric(char[] str) {
        if (str == null || str.length == 0) {
            return false;
        }
        for (int i = 0; i < str.length; i++) {
            if (str[i] == 'e' || str[i] == 'E' || str[i] == '.') {
                return i != str.length - 1 && process(str, 0, i, str[i]);
            }
        }
        return process(str, 0, str.length, ' ');
    }

    private static boolean process(char[] str, int left, int i, char ch) {
        for (int j = left; j < i; j++) {
            if (str[j] == '+' || str[j] == '-') {
                if (j != left) {
                    return false;
                }
            } else {
                if (str[j] >= 48 && str[j] <= 57) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        if (ch == '.') {
            for (int j = i + 1; j < str.length; j++) {
                if (str[j] == 'e' || str[j] == 'E') {
                    return process(str, i + 1, j, str[j]);
                }
            }
        }
        for (int j = i + 1; j < str.length; j++) {
            if (str[j] == '+' || str[j] == '-') {
                if (j != i + 1 && (ch == 'e' || ch == 'E')) {
                    return false;
                }
            } else {
                if (str[j] >= 48 && str[j] <= 57) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "-1E-16";
        System.out.println(isNumeric(str.toCharArray()));
    }
}
