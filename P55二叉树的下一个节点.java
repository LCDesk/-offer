public class P55二叉树的下一个节点 {
    public static class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public static TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        if (pNode.right != null) {
            return findMostLeft(pNode.right);
        }
        return process(pNode);
    }

    private static TreeLinkNode findMostLeft(TreeLinkNode right) {
        while (right.left != null) {
            right = right.left;
        }
        return right;
    }

    private static TreeLinkNode process(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        TreeLinkNode parent = pNode.next;
        if (parent != null && parent.left == pNode) {
            return parent;
        } else {
            return process(parent);
        }
    }

    public static void main(String[] args) {
        TreeLinkNode node1 = new TreeLinkNode(8);
        TreeLinkNode node2 = new TreeLinkNode(6);
        TreeLinkNode node3 = new TreeLinkNode(10);
        TreeLinkNode node4 = new TreeLinkNode(5);
        TreeLinkNode node5 = new TreeLinkNode(7);
        TreeLinkNode node6 = new TreeLinkNode(9);
        TreeLinkNode node7 = new TreeLinkNode(11);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node2.next = node1;
        node3.next = node1;
        node4.next = node2;
        node5.next = node2;
        node6.next = node3;
        node7.next = node3;
        System.out.println(GetNext(node7));

    }
}
