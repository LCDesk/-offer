public class P43扑克牌顺子 {
    public static boolean isContinuous(int[] numbers) {
        int min = Integer.MAX_VALUE;
        int count = 0;
        int[] arr = new int[5];
        for (int i : numbers) {
            if (i == 0) {
                count++;
            } else {
                min = Math.min(min, i);
            }
        }
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] != 0) {
                if (numbers[i] - min < 5) {
                    count += arr[numbers[i] - min] == 0 ? 1 : 0;
                    arr[numbers[i] - min] = 1;
                }
            }
        }
        return count == 5;
    }

    public static void main(String[] args) {
        int[] num = {1, 3, 3, 0, 0};
        System.out.println(isContinuous(num));
    }
}
