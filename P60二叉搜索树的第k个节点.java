public class P60二叉搜索树的第k个节点 {

    TreeNode res = null;
    int count = 0;

    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null) {
            return null;
        }
        process(pRoot, k);
        return res;
    }

    private void process(TreeNode pRoot, int k) {
        if (pRoot == null) {
            return;
        }
        process(pRoot.left, k);
        count++;
        if (count == k) {
            res = pRoot;
            return;
        }
        process(pRoot.right, k);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(8);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;


    }

}
