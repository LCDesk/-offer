import java.util.ArrayList;


public class P3从头到尾打印链表 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        return process(listNode);
    }

    private ArrayList<Integer> process(ListNode listNode) {
        if (listNode == null) {
            return new ArrayList<>();
        }
        ArrayList<Integer> list = process(listNode.next);
        list.add(listNode.val);
        return list;
    }
}
