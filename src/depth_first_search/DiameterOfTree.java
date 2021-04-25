package depth_first_search;

import java.util.*;

public class DiameterOfTree {

    public static List<TreeNode> nonLeadNodes = new ArrayList<>();
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println("Tree Diameter: " + getDiameter(root));
        root.left.left = null;
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        root.right.left.right.left = new TreeNode(10);
        root.right.right.left.left = new TreeNode(11);
        System.out.println("Tree Diameter: " + getDiameter(root));
    }

    public static int getDiameter(TreeNode node){
        int depth = 0;
        preOrder(node);
        for(TreeNode curNode: nonLeadNodes){
            depth = Math.max(depth, (getDepth(curNode.left, 1)+getDepth(curNode.right, 1) + 1));
        }
        return depth;
    }

    public static void preOrder(TreeNode node){
        if (node==null)
            return;
        if(node.left!=null && node.right != null)
            nonLeadNodes.add(node);
        preOrder(node.left);
        preOrder(node.right);
    }
    public static int getDepth(TreeNode node, int cur_depth){
        if(node == null || (node.left == null && node.right==null)) {
            return cur_depth;
        }
        else{
            return Math.max(getDepth(node.left, cur_depth+1), getDepth(node.right, cur_depth+1));
        }
    }
}
