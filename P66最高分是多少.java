import java.util.PriorityQueue;
import java.util.Scanner;

public class P66最高分是多少 {
    static PriorityQueue<Integer> pq = new PriorityQueue<>(((o1, o2) -> o2 - o1));
    static int[] arr = new int[30000];

    static public void upadte(int id, int grade) {
        arr[id] = grade;
    }

    static public int query(int id1, int id2) {
        pq.clear();
        if (id1 > id2) {
            int temp = id1;
            id1 = id2;
            id2 = temp;
        }
        for (; id1 <= id2; id1++) {
            pq.add(arr[id1]);
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String[] line1 = sc.nextLine().split(" ");
            int num = Integer.valueOf(line1[0]);
            int loop = Integer.valueOf(line1[1]);
            String[] line2 = sc.nextLine().split(" ");
            for (int i = 0; i < line2.length; i++) {
                arr[i] = Integer.valueOf(line2[i]);
            }
            for (int i = 0; i < loop; i++) {
                String[] line = sc.nextLine().split(" ");
                if (line[0].equals("Q")) {
                    System.out.println(query(Integer.valueOf(line[1]) - 1, Integer.valueOf(line[2]) - 1));
                } else {
                    upadte(Integer.valueOf(line[1]) - 1, Integer.valueOf(line[2]));
                }
            }

        }

    }
}
