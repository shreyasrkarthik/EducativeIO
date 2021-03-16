package two_pointers;

import java.util.*;

public class Problem1 {

    public static void findPairs(int[] array, int left, int target, List cur_list, Set output){

        int right = array.length-1;
        List<Integer> new_cur_list = new ArrayList<>(cur_list);
        while (left < right){
            if(array[left]+array[right] == target){
                //Add left & right to global list
                new_cur_list.add(array[left]);
                new_cur_list.add(array[right]);
                output.add(new_cur_list);
                new_cur_list = new ArrayList<>(cur_list);
                left ++;
                right = array.length - 1;
            }
            else if(array[left]+array[right] > target){
                right --;
            }
            else left++;
        }
    }
    public static void main(String[] args) {
        int[] input = {2, 0, -1, 1, -2, 2};
        int target = 2;
        Set<List> output = new HashSet<>();

        Arrays.sort(input);

        for(int i=0; i<input.length; i++){
            for(int j=i+1; j<input.length; j++){
                List<Integer> cur_list = new ArrayList<>();
                cur_list.add(input[i]);
                cur_list.add(input[j]);
                int new_target = target - (input[i] + input[j]);
                findPairs(input, j+1, new_target, cur_list, output);
            }
        }
        System.out.println(output);
    }
}
