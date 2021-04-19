package depth_first_search;

public class BinaryTreePathSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(6);
        TreeNode n6 = new TreeNode(7);

        TreeNode n1 = new TreeNode(2, n3, n4);
        TreeNode n2 = new TreeNode(3, n5, n6);

        root.right = n2;
        root.left = n1;
        int sum = 10;

        boolean isPathPresent = pathExists(sum-root.val, root);
        if(isPathPresent)
            System.out.println("There is a path present that adds up to "+ sum);
        else
            System.out.println("There are no paths that add up to "+ sum);
    }

    public static boolean pathExists(int sum, TreeNode root){
        if(root.left == null && root.right == null) {
            if (sum == 0)
                return true;
            else
                return false;
        }
        else if(root.right == null)
            return pathExists(sum-root.left.val, root.left);
        else if(root.left == null)
            return pathExists(sum-root.right.val, root.right);
        return pathExists(sum-root.left.val, root.left) || pathExists(sum-root.right.val, root.right);
    }
}
