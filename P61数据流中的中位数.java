import java.util.PriorityQueue;

public class P61数据流中的中位数 {
    static PriorityQueue<Integer> minpq = new PriorityQueue<>();
    static PriorityQueue<Integer> maxpq = new PriorityQueue<>((o1, o2) -> o2 - o1);

    static public void Insert(Integer num) {
        if (maxpq.size() == 0) {
            maxpq.add(num);
        } else {
            if (num > maxpq.peek()) {
                maxpq.add(num);
            } else {
                minpq.add(num);
            }
            if (maxpq.size() != 0 && minpq.size() != 0 && maxpq.peek() > minpq.peek()) {
                int temp = maxpq.poll();
                maxpq.add(minpq.poll());
                minpq.add(temp);
            }
        }
        if (maxpq.size() - minpq.size() > 1) {
            minpq.add(maxpq.poll());
        } else if (minpq.size() - maxpq.size() > 1) {
            maxpq.add(minpq.poll());
        }
    }

    static public Double GetMedian() {
        if (maxpq.size() == minpq.size()) {
            return (maxpq.peek() + minpq.peek()) / 2.0;
        }
        return (double) (maxpq.size() > minpq.size() ? maxpq.peek() : minpq.peek());
    }

    public static void main(String[] args) {
        Insert(5);
        System.out.println(GetMedian());
        Insert(2);
        System.out.println(GetMedian());
        Insert(3);
        System.out.println(GetMedian());
        Insert(4);
        System.out.println(GetMedian());
        Insert(1);
        System.out.println(GetMedian());
        Insert(6);
        System.out.println(GetMedian());
        Insert(7);
        System.out.println(GetMedian());
        Insert(0);
        System.out.println(GetMedian());
        Insert(8);
        System.out.println(GetMedian());
    }

}
