import java.util.ArrayList;

public class P57按之字形顺序打印二叉树 {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        process(pRoot, 0);
        return list;
    }

    private static void process(TreeNode pRoot, int level) {
        if (pRoot == null) {
            return;
        }
        if (level % 2 == 0) {
            if (list.size() > level) {
                list.get(level).add(pRoot.val);
            } else {
                ArrayList<Integer> list1 = new ArrayList<>();
                list1.add(pRoot.val);
                list.add(list1);
            }
        } else {
            if (list.size() > level) {
                list.get(level).add(0, pRoot.val);
            } else {
                ArrayList<Integer> list1 = new ArrayList<>();
                list1.add(0, pRoot.val);
                list.add(list1);
            }
        }
        process(pRoot.left, level + 1);
        process(pRoot.right, level + 1);
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
        System.out.println(Print(node1));
    }
}
