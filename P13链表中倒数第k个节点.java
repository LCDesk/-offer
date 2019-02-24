import java.util.LinkedList;
import java.util.Queue;

public class P13链表中倒数第k个节点 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail(ListNode head, int k) {
        int count = 0;
        Queue<ListNode> queue = new LinkedList<>();
        while (head != null) {
            if (queue.size() == k) {
                queue.poll();
            }
            queue.offer(head);
            head = head.next;
        }
        if (queue.size() == k) {
            return queue.peek();
        } else {
            return null;
        }
    }


}
