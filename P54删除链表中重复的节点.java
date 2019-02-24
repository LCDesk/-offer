import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P54删除链表中重复的节点 {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode head = new ListNode(0);
        ListNode res = head;
        ListNode cur = pHead;
        ListNode next = pHead.next;
        while (cur != null) {
            if (next == null) {
                head.next = cur;
                head = head.next;
                cur = next;
            } else {
                if (cur.val != next.val) {
                    head.next = cur;
                    head = head.next;
                    cur = next;
                    next = next.next;
                } else {
                    while (next != null && next.val == cur.val) {
                        next = next.next;
                    }
                    cur = next;
                    if (cur != null) {
                        next = cur.next;
                    }
                }
            }
        }
        head.next = null;
        return res.next;

    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(1);
        ListNode node6 = new ListNode(1);
        ListNode node7 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        ListNode head = deleteDuplication(node1);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
