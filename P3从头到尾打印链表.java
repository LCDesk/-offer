import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P3从头到尾打印链表 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode == null) {
            return new ArrayList<>();
        }

        List<Integer> list = new LinkedList<>();
        while (listNode != null) {
            list.add(0, listNode.val);
            listNode = listNode.next;
        }
        return new ArrayList<>(list);
    }

}
