import java.util.HashMap;

public class P23复杂链表的复制 {

    public static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public static RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        HashMap<Integer, RandomListNode> map = new HashMap<>();
        RandomListNode cpHead = pHead;
        while (cpHead != null) {
            map.put(cpHead.label, new RandomListNode(cpHead.label));
            cpHead = cpHead.next;
        }
        RandomListNode head = map.get(pHead.label);
        RandomListNode cur = head;
        while (pHead.next != null) {
            cur.next = map.get(pHead.next.label);
            if (pHead.random != null) {
                cur.random = map.get(pHead.random.label);
            }
            cur = cur.next;
            pHead = pHead.next;
        }
        return head;
    }

    public static void main(String[] args) {


        RandomListNode head1 = new RandomListNode(10);
        RandomListNode head2 = new RandomListNode(5);
        RandomListNode head3 = new RandomListNode(12);
        RandomListNode head4 = new RandomListNode(4);
        RandomListNode head5 = new RandomListNode(7);
        head1.next = head2;
        head1.random = head3;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;
        System.out.println(Clone(head1));
    }
}