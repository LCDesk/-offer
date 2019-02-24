import java.util.ArrayList;

/**
 * 需要返回List的一般套路
 */


public class P22二叉树中和为某一值的路径 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    static ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();
    static ArrayList<Integer> list = new ArrayList<>();


    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return listAll;
        }
        process(root, target);
        return listAll;
    }

    private static void process(TreeNode root, int target) {
        if (target < 0) {
            return;
        }
        list.add(root.val);
        if (target == root.val && root.left == null && root.right == null) {
            listAll.add(new ArrayList<>(list));
        }
        if (root.left != null) {
            process(root.left, target - root.val);
        }
        if (root.right != null) {
            process(root.right, target - root.val);
        }
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode head1 = new TreeNode(10);
        TreeNode head2 = new TreeNode(5);
        TreeNode head3 = new TreeNode(12);
        TreeNode head4 = new TreeNode(4);
        TreeNode head5 = new TreeNode(7);
        head1.left = head2;
        head1.right = head3;
        head2.left = head4;
        head2.right = head5;
        System.out.println(FindPath(head1, 22));


    }
}
