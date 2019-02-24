public class P41左旋转字符串 {
    public static String LeftRotateString(String str, int n) {
        if (str == null || "".equals(str.trim())) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        n = n % str.length();
        if (n == 0) {
            return str;
        }
        sb.append(str.substring(n)).append(str.substring(0, n));
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(LeftRotateString("abcXYZdef", 3));
    }
}
