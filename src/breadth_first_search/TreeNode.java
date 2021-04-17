package breadth_first_search;

public class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int _val){
        this.val = _val;
    }

    TreeNode(int _val, TreeNode left, TreeNode right){
        this.val = _val;
        this.left = left;
        this.right = right;
    }
}
