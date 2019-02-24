public class P33数组中逆序对 {
    public static int InversePairs(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        return process(array, 0, array.length - 1);
    }

    private static int process(int[] array, int i, int j) {
        if (i < j) {
            int mid = (i + j) / 2;
            int left = process(array, i, mid);
            int right = process(array, mid + 1, j);
            return merge(array, i, mid, j) + left + right;
        } else {
            return 0;
        }
    }

    private static int merge(int[] array, int i, int mid, int j) {
        int[] temp = new int[j - i + 1];
        int pair = 0;
        int count = 0;
        int left = i;
        int right = mid + 1;
        while (left <= mid && right <= j) {
            if (array[left] < array[right]) {
                temp[count++] = array[left++];
            } else {
                pair += (mid - left + 1);
                temp[count++] = array[right++];
            }
        }
        if (left == mid + 1) {
            while (right <= j) {
                temp[count++] = array[right++];
            }
        }
        if (right == j + 1) {
            while (left <= mid) {
                temp[count++] = array[left++];
            }
        }
        for (int index = 0; index < temp.length; index++) {
            array[i + index] = temp[index];
        }
        return pair;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 0};
        System.out.println(InversePairs(arr));
    }
}
