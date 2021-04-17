package breadth_first_search;

import java.util.ArrayList;
import java.util.List;

public class LevelAverages {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2, new TreeNode(4), new TreeNode(5));
        TreeNode right = new TreeNode(3, new TreeNode(6), new TreeNode(7));
        root.left = left;
        root.right = right;

        List<Float> output = levelAverages(root);
        System.out.println(output.toString());
    }

    public static List<Float> levelAverages(TreeNode root) {
        List<Float> output = new ArrayList<>();
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int queue_size = queue.size();
            int sum = 0, count = 0;

            for (int i = 0; i < queue_size; i++) {
                TreeNode cur = queue.get(i);
                sum += cur.val;
                count++;

                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }

            for (int i = 0; i < queue_size; i++) {
                queue.remove(0);
            }
            float avg = (float)sum/count;
            output.add(avg);
        }
        return output;
    }
}
