import java.util.HashSet;
import java.util.Set;

public class P34两个链表的第一个公共节点 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }

        public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
            if (pHead1 == null | pHead2 == null) {
                return null;
            }
            Set<ListNode> set = new HashSet<>();
            ListNode cur1 = pHead1;
            ListNode cur2 = pHead2;
            while (cur1 != null && !set.contains(cur1)) {
                set.add(cur1);
                cur1 = cur1.next;
            }
            while (cur2 != null) {
                if (set.contains(cur2)) {
                    break;
                }
                cur2 = cur2.next;
            }
            return cur2;
        }
    }

}
