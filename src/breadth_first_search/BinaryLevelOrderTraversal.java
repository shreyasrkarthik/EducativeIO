package breadth_first_search;

import java.util.ArrayList;
import java.util.List;

public class BinaryLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2, new TreeNode(4), new TreeNode(5));
        TreeNode right = new TreeNode(3, new TreeNode(6), new TreeNode(7));
        root.left = left;
        root.right = right;

        printLevelOrder(root);
    }
    public static void printLevelOrder(TreeNode root){
        List<TreeNode> queue = new ArrayList<>();
        if(root == null)
            return;
        queue.add(root);
        while (queue.size()>0){
            TreeNode cur = queue.get(0);
            queue.remove(0);
            System.out.print(cur.val+", ");
            if(cur.left != null) queue.add(cur.left);
            if(cur.right != null) queue.add(cur.right);
        }
    }
}
