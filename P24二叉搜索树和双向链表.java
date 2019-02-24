import java.util.LinkedList;
import java.util.Queue;

public class P24二叉搜索树和双向链表 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    //双向链表的左边头结点和右边头节点
    static TreeNode leftHead = null;
    static TreeNode rightHead = null;

    public static TreeNode Convert(TreeNode pRootOfTree) {
        //递归调用叶子节点的左右节点返回null
        if (pRootOfTree == null) {
            return null;
        }
        //第一次运行时，它会使最左边叶子节点为链表第一个节点
        Convert(pRootOfTree.left);
        if (rightHead == null) {
            leftHead = rightHead = pRootOfTree;
        } else {
            //把根节点插入到双向链表右边，rightHead向后移动
            rightHead.right = pRootOfTree;
        pRootOfTree.left = rightHead;
        rightHead = pRootOfTree;
    }
        //把右叶子节点也插入到双向链表（rightHead已确定，直接插入）
        Convert(pRootOfTree.right);
        //返回左边头结点
        return leftHead;
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
        TreeNode head = Convert(head1);
        while (head != null) {
            System.out.println(head.val);
            head = head.right;
        }
    }

}
