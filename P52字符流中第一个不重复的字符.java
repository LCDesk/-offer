import java.util.*;

public class P52字符流中第一个不重复的字符 {
    static List<Character> list = new LinkedList<>();
    static Set<Character> set = new HashSet<>();

    //Insert one char from stringstream
    public static void Insert(char ch) {
        if (!set.contains(ch)) {
            list.add(0, ch);
            set.add(ch);
        } else {
            list.remove((Character) ch);
        }
    }

    //return the first appearence once char in current stringstream
    public static char FirstAppearingOnce() {
        if (list.size() == 0) {
            return '#';
        } else {
            return list.get(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Insert('g');
        System.out.println(FirstAppearingOnce());
        Insert('o');
        System.out.println(FirstAppearingOnce());
        Insert('o');
        System.out.println(FirstAppearingOnce());
        Insert('g');
        System.out.println(FirstAppearingOnce());
        Insert('l');
        System.out.println(FirstAppearingOnce());
        Insert('e');
        System.out.println(FirstAppearingOnce());


    }

}
