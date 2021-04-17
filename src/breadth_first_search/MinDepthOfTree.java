package breadth_first_search;

import java.util.ArrayList;
import java.util.List;

public class MinDepthOfTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2, new TreeNode(4), null);
        TreeNode right = new TreeNode(3, new TreeNode(6), new TreeNode(7));
        root.left = left;
        root.right = right;

        int output = minDepth(root);
        System.out.println(output);
    }

    public static int minDepth(TreeNode root) {
        int output = 0;
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int queue_size = queue.size();
            output += 1;
            for (int i = 0; i < queue_size; i++) {
                TreeNode cur = queue.get(i);
                if(cur.left == null && cur.right == null)
                    return output;
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }

            for (int i = 0; i < queue_size; i++) {
                queue.remove(0);
            }
        }
        return output;
    }
}
