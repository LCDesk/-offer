import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class P20从上到下打印二叉树 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode head = q.poll();
            if (head.left != null) {
                q.offer(head.left);
            }
            if (head.right != null) {
                q.offer(head.right);
            }
            list.add(head.val);
        }
        return list;
    }
}
