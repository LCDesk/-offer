public class P38数组中只出现一次的数字 {


    /**
     * 异或的性质：相同的数异或为0，0异或任何书等于他本身
     *
     * @param array
     * @param num1
     * @param num2
     */
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        int bit = 0;
        for (int i : array) {
            bit ^= i;
        }
        int index = findIndex(bit);
        for (int i : array) {
            if (((i >> index) & 1) == 1) {
                num1[0] ^= i;
            } else {
                num2[0] ^= i;
            }
        }


    }

    private int findIndex(int bit) {
        int index = 0;
        while (index < 32) {
            if (((bit >> index) & 1) == 1) {
                break;
            }
            index++;
        }
        return index;
    }
}
