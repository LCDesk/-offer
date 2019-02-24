public class P28连续子数组最大和 {

    public int FindGreatestSumOfSubArray(int[] array) {
        int max = array[0];
        int cur = 0;
        for (int i = 0; i < array.length; i++) {
            cur += array[i];
            max = max > cur ? max : cur;
            if (cur < 0) {
                cur = 0;
            }
        }
        return max;
    }
}
