import java.util.HashMap;

public class P26数组中次数超过一半的数字 {

    public int MoreThanHalfNum_Solution(int[] array) {
        int size = array.length / 2;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : array) {
            if (map.containsKey(i)) {
                int count = map.get(i) + 1;
                if (count > size) {
                    return i;
                }
                map.put(i, count);
            } else {
                if (1 > size) {
                    return i;
                }
                map.put(i, 1);
            }
        }
        return 0;
    }
}
