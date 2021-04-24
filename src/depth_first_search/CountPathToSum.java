package depth_first_search;

public class CountPathToSum {
    public static int output = 0;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode n3 = new TreeNode(6);
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(2);
        TreeNode n6 = new TreeNode(3);

        TreeNode n1 = new TreeNode(7, n3, n4);
        TreeNode n2 = new TreeNode(9, n5, n6);

        root.left = n1;
        root.right = n2;

        int sum = 12;
        getPathSum(root, root.val, sum);
        System.out.println("Number of Paths adding upto sum of " + sum + " is: "+ output);
    }

    public static boolean getPathSum(TreeNode root, int val, int sum){
        System.out.println(val+ " "+ root.val);
        if (val == sum) {
            output++;
            return false;
        }
        if(root.left == null && root.right == null) {
            return false;
        }
        else if(root.left != null && root.right != null){
            return getPathSum(root.left, val+root.left.val, sum) || getPathSum(root.left, root.left.val, sum) ||
                    getPathSum(root.right, val+root.right.val, sum) || getPathSum(root.right, root.right.val, sum);
        }
        else if(root.right != null){
            return getPathSum(root.right, val+root.right.val, sum) || getPathSum(root.right, root.right.val, sum);
        }
        else{
            return getPathSum(root.left, val+root.left.val, sum) ||  getPathSum(root.left, root.left.val, sum);
        }
    }

}
