package breadth_first_search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReverseLevelOrder {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2, new TreeNode(4), new TreeNode(5));
        TreeNode right = new TreeNode(3, new TreeNode(6), new TreeNode(7));
        root.left = left;
        root.right = right;

        List<List<Integer>> output = reverseLevelOrder(root);
        Collections.reverse(output);
        System.out.println(output.toString());
    }

    public static List<List<Integer>> reverseLevelOrder(TreeNode root){
        List<List<Integer>> output = new ArrayList<>();
        if(root == null)
            return output;
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> cur_level = new ArrayList<>();
            int queue_size = queue.size();
            for(int i=0; i< queue_size; i++){
                TreeNode cur = queue.get(i);
                cur_level.add(cur.val);
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }

            for(int i=0; i<queue_size; i++){
                queue.remove(0);
            }
            output.add(cur_level);
        }
        return output;
    }
}
