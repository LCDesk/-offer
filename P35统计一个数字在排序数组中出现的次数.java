public class P35统计一个数字在排序数组中出现的次数 {

    public int GetNumberOfK(int[] array, int k) {
        int i = process(array, k, 0, array.length - 1);
        if (i == -1) {
            return 0;
        }
        int left = i - 1;
        int right = i + 1;
        while (left >= 0 && array[left] == k) {
            left--;
        }
        while (right < array.length && array[right] == k) {
            right++;
        }
        return right - left - 1;
    }

    private int process(int[] array, int k, int i, int j) {
        if (i <= j) {
            int mid = (i + j) / 2;
            if (array[mid] > k) {
                return process(array, k, i, mid - 1);
            } else if (array[mid] < k) {
                return process(array, k, mid + 1, j);
            } else {
                return mid;
            }
        } else {
            return -1;
        }
    }

}
