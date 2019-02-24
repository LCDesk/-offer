public class P47把字符串转换成整数 {
    public static int StrToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        str = str.trim();
        int sum = 0;
        char[] chars = str.toCharArray();
        int len = str.length() - 1;
        int index = 0;
        int a = 1;
        if (chars[index] == '+' || chars[index] == '-') {
            a = chars[index++] == '+' ? 1 : -1;
        }
        for (; index < chars.length; index++) {
            if (chars[index] >= 48 && chars[index] <= 57) {
                sum = a * (chars[index] - 48) + sum * 10;
            } else {
                return 0;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(StrToInt("-2147483648"));
    }
}
