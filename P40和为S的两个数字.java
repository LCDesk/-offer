import java.util.ArrayList;

public class P40和为S的两个数字 {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        if (array == null || array.length <= 1) {
            return new ArrayList<>();
        }
        int left = 0;
        int right = array.length - 1;
        ArrayList<Integer> list = new ArrayList<>();
        while (left < right) {
            if (array[left] + array[right] > sum) {
                right--;
            } else if (array[left] + array[right] < sum) {
                left++;
            } else {
                if (list.size() == 0) {
                    list.add(array[left]);
                    list.add(array[right]);
                } else {
                    if (array[left] * array[right] < list.get(0) * list.get(1)) {
                        list.set(0, array[left]);
                        list.set(1, array[right]);
                    }
                }
                left++;
            }
        }
        return list;
    }

    public static void main(String[] args) {

    }
}
