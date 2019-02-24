import java.util.HashMap;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class P4重建二叉树 {

    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        TreeNode head = new TreeNode(pre[0]);
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        return process(pre, 0, pre.length - 1, in, 0, in.length - 1, map);
    }


    private static TreeNode process(int[] pre, int prei, int prej, int[] in, int ini, int inj, Map<Integer, Integer> map) {
        if (prei > prej) {
            return null;
        }
        TreeNode head = new TreeNode(pre[prei]);
        int index = map.get(pre[prei]);
        head.left = process(pre, prei + 1, prei + index - ini, in, ini, index, map);
        head.right = process(pre, prei + index - ini + 1, prej, in, index + 1, inj, map);
        return head;
    }

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        reConstructBinaryTree(pre, in);
    }

}
