import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class P25字符串的排列 {
    static Set<String> sSet = new TreeSet<>();

    public static ArrayList<String> Permutation(String str) {
        if (str == null || str.length() == 0) {
            return new ArrayList<>();
        }
        char[] chars = str.toCharArray();
        process(chars, 0);
        return new ArrayList<>(sSet);
    }

    private static void process(char[] chars, int i) {
        if (i == chars.length) {
            sSet.add(new String(chars));
            return;
        }
        for (int j = i; j < chars.length; j++) {
            swap(chars, i, j);
            process(chars, i + 1);
            swap(chars, i, j);
        }
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void main(String[] args) {
        String s = "abc";
        ArrayList<String> list = Permutation(s);
        System.out.println(list);
    }
}
