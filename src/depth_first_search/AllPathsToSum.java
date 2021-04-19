package depth_first_search;

import java.util.ArrayList;
import java.util.List;

public class AllPathsToSum {

    public static List<List<Integer>> output = new ArrayList<>();
    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(10);
        TreeNode n6 = new TreeNode(5);

        TreeNode n1 = new TreeNode(7, n3, null);
        TreeNode n2 = new TreeNode(1, n5, n6);

        root.left = n1;
        root.right = n2;
        int sum = 23;

        List<Integer> cur_list= new ArrayList<>();
        cur_list.add(root.val);

        findAllPaths(sum-root.val, root, cur_list);
        System.out.println("All the paths that add upto "+ sum+" are: ");
        System.out.println(output.toString());
    }
    public static List<Integer> cloneList(List<Integer> originalList){
        List<Integer> clonedList = new ArrayList<>(originalList);
        return clonedList;
    }
    public static void findAllPaths(int sum, TreeNode root, List<Integer> cur_list){
        if(root.left == null && root.right == null) {
            if (sum == 0) {
                output.add(cur_list);
            }
            else
                return;
        }
        else if(root.right == null) {
            List<Integer> left_list = cloneList(cur_list);
            left_list.add(root.left.val);
            findAllPaths(sum - root.left.val, root.left, left_list);
        }
        else if(root.left == null) {
            List<Integer> right_list = cloneList(cur_list);
            right_list.add(root.right.val);
            findAllPaths(sum - root.right.val, root.right, right_list);
        }
        else {
            List<Integer> left_list = cloneList(cur_list);
            left_list.add(root.left.val);
            findAllPaths(sum - root.left.val, root.left, left_list);
            List<Integer> right_list = cloneList(cur_list);
            right_list.add(root.right.val);
            findAllPaths(sum - root.right.val, root.right, right_list);
        }
    }
}
