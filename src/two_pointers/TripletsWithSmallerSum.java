package two_pointers;

import java.util.Arrays;

public class TripletsWithSmallerSum {

    public static int totalPairsWithSum(int[] array, int left, int sum){
        int count = 0;
        int right = array.length-1;
        while(left < right){
            if((array[left]+array[right])<sum) {
                count+=(right-left);
                left++;
            }
            right--;
        }
        return count;
    }
    public static void main(String[] args) {

        int[] input = {-1, 0, 2, 3};
        int target = 3, output = 0;

        Arrays.sort(input);

        for(int i=0; i<input.length; i++){
            int new_target = target-input[i];
            output += totalPairsWithSum(input, i+1, new_target);
        }
        System.out.println(output);
    }
}
