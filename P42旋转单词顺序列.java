public class P42旋转单词顺序列 {
    public static String ReverseSentence(String str) {
        if (str == null || "".equals(str.trim())) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        int pre = str.length();
        for (int i = str.length() - 1; i >= -1; i--) {
            if (i == -1 || str.charAt(i) == ' ') {
                sb.append(str.substring(i + 1, pre)).append(" ");
                pre = i;
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "student. a am I";
        System.out.println(ReverseSentence(str));
    }
}
