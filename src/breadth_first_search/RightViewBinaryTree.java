package breadth_first_search;

import java.util.*;

public class RightViewBinaryTree {
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2, new TreeNode(4), null);
        TreeNode right = new TreeNode(3, new TreeNode(6), new TreeNode(7));
        root.left = left;
        root.right = right;

        ArrayList<Integer> rightViewTreeNodes = getRightView(root);
        System.out.println(rightViewTreeNodes.toString());
    }
    
    public static ArrayList<Integer> getRightView(TreeNode root){
        ArrayList<Integer> rightTreeNodes = new ArrayList<>();
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int queue_size = queue.size();
            TreeNode cur = null;
            for(int i=0; i<queue_size; i++){
                 cur = queue.get(i);
                if(cur.left != null) queue.add(cur.left);
                if(cur.right != null) queue.add(cur.right);
            }
            rightTreeNodes.add(cur.val);
            for(int i=0; i<queue_size; i++) {
                queue.remove(0);
            }
        }
        return rightTreeNodes;
    }
}
