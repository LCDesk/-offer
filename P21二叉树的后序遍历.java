public class P21二叉树的后序遍历 {
    public static boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return process(sequence, 0, sequence.length - 1);
    }

    public static boolean process(int[] sequence, int i, int j) {
        if (i >= j) {
            return true;
        }
        int target = sequence[j];
        int start = i;
        int mid = 0;
        for (; start < j; start++) {
            if (sequence[start] > target) {
                break;
            }
        }
        mid = start;
        for (; start < j; start++) {
            if (sequence[start] < target) {
                return false;
            }
        }
        return process(sequence, i, mid - 1) & process(sequence, mid, j-1);
    }

    public static void main(String[] args) {
        int[] arr = {4, 6, 7, 5};
        System.out.println(VerifySquenceOfBST(arr));
    }
}
