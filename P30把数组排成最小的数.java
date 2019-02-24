import java.util.Arrays;
import java.util.Comparator;

public class P30把数组排成最小的数 {
    public static String PrintMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return "";
        }
        String[] str = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            str[i] = numbers[i] + "";
        }
        Arrays.sort(str, (o1, o2) -> (o1 + o2).compareTo(o2 + o1));
        StringBuilder sb = new StringBuilder();
        for (String s : str) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] arr = {3334, 3, 3333332};
        System.out.println(PrintMinNumber(arr));
    }
}
