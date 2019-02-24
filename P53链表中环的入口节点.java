public class P53链表中环的入口节点 {

    static public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }
        ListNode slow = pHead.next;
        ListNode fast = pHead.next.next;
        while (fast != null && fast.next != null & fast != slow) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast == slow) {
            fast = pHead;
            while (fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }
            return fast;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(5);
        EntryNodeOfLoop(node);
    }
}
