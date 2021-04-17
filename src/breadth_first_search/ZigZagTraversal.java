package breadth_first_search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ZigZagTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2, new TreeNode(4), new TreeNode(5));
        TreeNode right = new TreeNode(3, new TreeNode(6), new TreeNode(7));
        root.left = left;
        root.right = right;

        List<List<Integer>> output = zigzagTraversal(root);
        System.out.println(output.toString());
    }

    public static List<List<Integer>> zigzagTraversal(TreeNode root){
        List<List<Integer>> output = new ArrayList<>();
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);

        boolean traversing_left = true;

        while(!queue.isEmpty()){
            int queue_size = queue.size();

            List<Integer> cur_level = new ArrayList<>();

            for(int i=0; i< queue_size; i++){
                TreeNode cur = queue.get(i);
                if (traversing_left) cur_level.add(cur.val);
                else cur_level.add(0, cur.val);

                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }

            for(int i=0; i<queue_size; i++){
                queue.remove(0);
            }
            if(traversing_left)
                traversing_left = false;
            else
                traversing_left = true;
            output.add(cur_level);

        }

        return output;
    }
}
