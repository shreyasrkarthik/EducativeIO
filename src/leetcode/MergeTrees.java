package leetcode;

import com.sun.source.tree.Tree;

public class MergeTrees {
    // Problem No. 617

    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        if(root1 == null && root2 == null)
            return null;
        TreeNode result = new TreeNode((root1==null?0:root1.val)+(root2==null?0:root2.val));
        result.left = mergeTrees(root1==null?null:root1.left, root2==null?null:root2.left);
        result.right = mergeTrees(root1==null?null:root1.right, root2==null?null:root2.right);
        return result;
    }

    public static void main(String[] args) {

        TreeNode root1 = new TreeNode(10);
        root1.left = new TreeNode(5);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(7);

        root1.right = new TreeNode(15);
        root1.right.right = new TreeNode(18);

        TreeNode root2 = new TreeNode(10);
        root2.left = new TreeNode(5);
        root2.left.left = new TreeNode(3);
        root2.left.right = new TreeNode(7);

        root2.right = new TreeNode(15);
        root2.right.right = new TreeNode(18);

        TreeNode result = mergeTrees(root1, root2);
        TreeNode.preOrder(result);
    }
}
