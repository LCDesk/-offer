import java.util.ArrayList;
import java.util.HashMap;

public class P39和为S的连续正数序列 {
    static ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        int[] dp = new int[sum];
        HashMap<Integer, Integer> map = new HashMap<>();
        dp[0] = 1;
        map.put(0, -1);
        map.put(1, 0);
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i - 1] + i + 1;
            if (i > sum / 2 ) {
                break;
            }
            if (map.containsKey(dp[i]-sum)) {
                int left = map.get(dp[i]-sum) + 1;
                ArrayList<Integer> list = new ArrayList<>();
                while (left <= i) {
                    list.add(left + 1);
                    left++;

                }
                lists.add(list);
            }
            map.put(dp[i], i);
        }
        return lists;
    }

    public static void main(String[] args) {
        System.out.println(FindContinuousSequence(100));
    }
}
