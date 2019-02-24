import java.util.ArrayList;

public class P62滑动窗口最大值 {
    public static ArrayList<Integer> maxInWindows(int[] num, int size) {
        if (size == 0 || num.length < size) {
            return new ArrayList<>();
        }

        int max = 0;
        int next = 0;
        int i = 1;
        for (; i < size; i++) {
            if (num[i] > num[max]) {
                max = i;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        next = max + 1;
        i = size - 1;
        while (i < num.length) {
            if (i - max < size) {
                if (num[max] > num[i]) {
                    next = num[next] > num[i] ? next : i;
                } else {
                    max = i;
                    next = max + 1;
                }
            } else {
                max = num[next] > num[i] ? next : i;
                next = max + 1;
            }
            list.add(num[max]);
            i++;
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 2, 6, 2, 5, 1};
        System.out.println(maxInWindows(arr, 3));

    }
}
