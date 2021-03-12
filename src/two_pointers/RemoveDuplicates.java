package two_pointers;

import java.util.ArrayList;
import java.util.Arrays;

public class RemoveDuplicates {
    public static void main(String[] args) {

        // input variables
        int[] input = {2, 2, 2, 11};
        int output=0, i=0, j=Math.min(1, input.length-1);

        // logic
        while (j < input.length){
            if(input[j] != input[i]){
                input[output+1] = input[j];
                i=j; j++;
                output ++;
            }
            else{
                j++;
            }
        }
        System.out.println(output+1);
        System.out.println(Arrays.toString(input));

    }
}
