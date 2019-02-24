import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P27最小的K个数 {


    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        if (input == null || input.length == 0 || k > input.length) {
            return new ArrayList<>();
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i : input) {
            if (pq.size() <= k) {
                pq.add(i);
            } else {
                if (i < pq.peek()) {
                    pq.poll();
                    pq.add(i);
                }
            }
        }
        return new ArrayList<>(pq);
    }
}
