import java.util.Stack;

public class P19栈的压入弹出序列 {
    /**
     * 利用辅助栈
     *
     * @param pushA
     * @param popA
     * @return
     */
    public static boolean IsPopOrder(int[] pushA, int[] popA) {
        int count = 1;
        Stack<Integer> stack = new Stack<>();
        stack.add(pushA[0]);
        for (int i : popA) {
            while (i != stack.peek() && count < pushA.length) {
                stack.add(pushA[count++]);
            }
            if (stack.peek() == i) {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] push = {1, 2, 3, 4, 5};
        int[] pop = {4, 5, 3, 2, 1};
        System.out.println(IsPopOrder(push, pop));
    }

}
