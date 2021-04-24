package depth_first_search;

public class SumOfPathNumbers {
    public static int output = 0;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(2);
        TreeNode n6 = new TreeNode(9);

        TreeNode n1 = new TreeNode(7, null, null);
        TreeNode n2 = new TreeNode(9, n5, n6);

        root.left = n1;
        root.right = n2;
        getAllSum(root, root.val);
        System.out.println("Sum of all numbers is " + output);
    }

    public static void getAllSum(TreeNode root, int sum) {
        if(root.left == null && root.right == null) {
            System.out.println(sum);
            output += sum;
        }
        else if (root.left == null){
            sum = (sum*10) + root.right.val;
            getAllSum(root.right, sum);
        }
        else if (root.right == null){
            sum = (sum*10) + root.left.val;
            getAllSum(root.left, sum);
        }
        else {
            int sum1 = (sum * 10) + root.right.val;
            getAllSum(root.right, sum1);
            int sum2 = (sum * 10) + root.left.val;
            getAllSum(root.left, sum2);
        }
    }
}
