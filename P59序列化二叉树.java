import java.util.LinkedList;
import java.util.Queue;

public class P59序列化二叉树 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    static String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode head = queue.poll();
            if (head == null) {
                sb.append("_#");
            } else {
                queue.offer(head.left);
                queue.offer(head.right);
                sb.append("_" + head.val);
            }
        }
        sb.append("_");
        return sb.toString();
    }

    static TreeNode Deserialize(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        TreeNode res = null;
        char[] chars = str.toCharArray();
        Queue<TreeNode> queue = new LinkedList<>();
        int left = 0;
        int mid = 0;
        int right = 1;
        while (chars[right] != '_') {
            right++;
        }
        String s = str.substring(left + 1, right);
        res = "#".equals(s) ? null : new TreeNode(Integer.valueOf(s));
        if (res != null) {
            queue.offer(res);
        }
        left = mid = right;
        right++;
        while (right != chars.length) {
            if (chars[right] != '_') {
                right++;
            } else {
                if (mid == left) {
                    mid = right++;
                    continue;
                }
                TreeNode head = queue.poll();
                String lchild = str.substring(left + 1, mid);
                String rchild = str.substring(mid + 1, right);
                TreeNode lnode = "#".equals(lchild) ? null : new TreeNode(Integer.valueOf(lchild));
                TreeNode rnode = "#".equals(rchild) ? null : new TreeNode(Integer.valueOf(rchild));
                head.left = lnode;
                head.right = rnode;
                if (lnode != null) {
                    queue.offer(head.left);
                }
                if (rnode != null) {
                    queue.offer(head.right);
                }
                left = right;
                mid = right;
                right++;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        Deserialize(Serialize(node1));
    }
}
