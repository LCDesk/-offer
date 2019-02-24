import java.util.PriorityQueue;
import java.util.Stack;

public class P18包含min的栈 {
    Stack<Integer> stack = new Stack<>();
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    public void push(int node) {
        stack.push(node);
        pq.add(node);

    }

    public void pop() {
        int ele = stack.pop();
        pq.remove(ele);
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return pq.peek();
    }

}
