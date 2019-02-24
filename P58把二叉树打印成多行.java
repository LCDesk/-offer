import java.util.ArrayList;

public class P58把二叉树打印成多行 {
    ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        process(pRoot, 0);
        return listAll;
    }

    private void process(TreeNode pRoot, int level) {
        if (pRoot == null) {
            return;
        }
        if (listAll.size() > level) {
            listAll.get(level).add(pRoot.val);
        } else {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(pRoot.val);
            listAll.add(list);
        }
        process(pRoot.left, level + 1);
        process(pRoot.right, level + 1);
    }
}
