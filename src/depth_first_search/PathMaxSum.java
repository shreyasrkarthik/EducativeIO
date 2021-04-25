package depth_first_search;

import java.util.ArrayList;
import java.util.List;

public class PathMaxSum {
    public static List<TreeNode> nonLeadNodes = new ArrayList<>();
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println("Maximum Path Sum: " + findMaximumPathSum(root));

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        System.out.println("Maximum Path Sum: " + findMaximumPathSum(root));

//        root = new TreeNode(-1);
//        root.left = new TreeNode(-3);
//        System.out.println("Maximum Path Sum: " + findMaximumPathSum(root));
    }

    public static int findMaximumPathSum(TreeNode node){
        int maxSum = Integer.MIN_VALUE;
        preOrder(node);
        System.out.println(nonLeadNodes.toString());
        for(TreeNode curNode: nonLeadNodes){
            System.out.println(curNode.val);
            maxSum = Math.max(maxSum, (getMaxPathSum(curNode.left, curNode.left.val)+
                    getMaxPathSum(curNode.right, curNode.right.val) + curNode.val));
        }
        return maxSum;
    }

    public static void preOrder(TreeNode node){
        if (node==null)
            return;
        if(node.left!=null && node.right != null)
            nonLeadNodes.add(node);
        preOrder(node.left);
        preOrder(node.right);
    }
    public static int getMaxPathSum(TreeNode node, int cur_sum){
        if(node == null || (node.left == null && node.right==null)) {
            return cur_sum;
        }
        else{
            int leftSum=0, rightSum=0;
            if(node.left!=null)
                leftSum = getMaxPathSum(node.left, cur_sum+ node.left.val);
            if(node.right!=null)
                rightSum = getMaxPathSum(node.right, cur_sum+ node.right.val);
            return Math.max(leftSum, rightSum);
        }
    }

}
