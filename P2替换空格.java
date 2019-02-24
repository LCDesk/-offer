public class P2替换空格 {
    public String replaceSpace(StringBuffer str) {
        char[] s = str.toString().toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : s) {
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
