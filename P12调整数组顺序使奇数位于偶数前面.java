public class P12调整数组顺序使奇数位于偶数前面 {
    public static void reOrderArray(int[] array) {
        process(array, 0, array.length - 1);
    }

    private static boolean isOdd(int num) {
        if (num % 2 == 0) {
            return false;
        }
        return true;
    }

    private static void process(int[] array, int i, int j) {
        if (i < j) {
            int mid = (i + j) / 2;
            process(array, i, mid);
            process(array, mid + 1, j);
            merge(array, i, mid, j);
        }
    }

    private static void merge(int[] array, int i, int mid, int j) {
        int[] temp = new int[j - i + 1];
        int count = 0;
        int left = i;
        int right = mid + 1;
        while (left <= mid && right <= j) {
            if (isOdd(array[left])) {
                temp[count++] = array[left++];
            } else if (isOdd(array[right])) {
                temp[count++] = array[right++];
            } else {
                temp[count++] = array[left++];
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

    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 3, 4, 6, 1};
        reOrderArray(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

}
