import java.util.HashSet;
import java.util.Set;

public class P48数组重复的数字 {
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        if (numbers == null || numbers.length <= 1) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int i : numbers) {
            if (set.contains(i)) {
                duplication[0] = i;
                return true;
            } else {
                set.add(i);
            }
        }
        return false;
    }
}
