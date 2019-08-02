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


    Map<Integer, Integer> result = new HashMap<>(16);

    private void posMapping(int[] pre, int[] in) {
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        for (int i = 0; i < pre.length; i++) {
            result.put(i, map.get(pre[i]));
        }

    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length == 0 || in.length == 0) {
            return null;
        }
        posMapping(pre, in);
        return process(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private TreeNode process(int[] pre, int preI, int preJ, int[] in, int inI, int inJ) {
        if (preI > preJ) {
            return null;
        }
        TreeNode node = new TreeNode(pre[preI]);
        node.left = process(pre, preI + 1, result.get(preI) - inI + preI, in, inI,
            result.get(preI) - 1);
        node.right = process(pre, preJ - inJ + result.get(preI) + 1, preJ, in,
            result.get(preI) + 1, inJ);
        return node;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7};
        int[] arr2 = {3, 2, 4, 1, 6, 5, 7};
        P4重建二叉树 p = new P4重建二叉树();
        System.out.println(p.reConstructBinaryTree(arr1, arr2));
    }



}
