import java.util.*;

public class P32第一个只出现一次的字符 {


    public static int FirstNotRepeatingChar(String str) {
        Map<Character, Integer> indexMap = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            if (set.contains(str.charAt(i))) {
                indexMap.remove(str.charAt(i));
            } else {
                set.add(str.charAt(i));
                indexMap.put(str.charAt(i), i);
            }
        }
        if (indexMap.size() == 0) {
            return -1;
        }
        int index = Integer.MAX_VALUE;
        for (Character character : indexMap.keySet()) {
            index = Math.min(index, indexMap.get(character));
        }
        return index;
    }

    public static void main(String[] args) {
        String str = "googgle";
        System.out.println(FirstNotRepeatingChar(str));
    }

}
