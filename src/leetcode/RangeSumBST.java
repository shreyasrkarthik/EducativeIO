package leetcode;

import java.util.ArrayList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
    }

    public static void preOrder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
 }
public class RangeSumBST {
    
    public static int rangeSumBST(TreeNode root, int low, int high) {
        int output = 0;
        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        while(queue.size() != 0){
            TreeNode cur = queue.get(0);
            queue.remove(0);
            if(cur.val >= low && cur.val <= high)
                output += cur.val;
            if (cur.left != null)
                queue.add(cur.left);
            if (cur.right != null)
                queue.add(cur.right);
        }
        return output;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);

        root.right = new TreeNode(15);
        root.right.right = new TreeNode(18);

        int low = 7, high = 15;
        int output = rangeSumBST(root, low, high);
        System.out.println(output);
    }
}
