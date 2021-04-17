package breadth_first_search;

import java.util.ArrayList;
import java.util.List;

public class LevelOrderSuccessor {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2, new TreeNode(4), null);
        TreeNode last = new TreeNode(7);
        TreeNode right = new TreeNode(3, new TreeNode(6), last);
        root.left = left;
        root.right = right;

        TreeNode output = getSuccessor(root, last);
        if (output == null)
            System.out.println("NULL");
        else System.out.println(output.val);
    }

    public static TreeNode getSuccessor(TreeNode root, TreeNode neighbour){
        TreeNode successor = null;
        List<TreeNode> queue  = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode cur = queue.get(0);
            if(cur == neighbour && queue.size() == 1)
                return cur.left; // Last node of that level
            else if (cur == neighbour)
                return queue.get(1);
            if (cur.left != null) queue.add(cur.left);
            if (cur.right != null) queue.add(cur.right);
            queue.remove(cur);
        }
        return successor;
    }

}
