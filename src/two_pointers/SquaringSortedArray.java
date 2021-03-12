package two_pointers;

import java.util.ArrayList;
import java.util.List;

public class SquaringSortedArray {
    public static void main(String[] args) {

        // variables
        int[] input = {-2, -1, 0, 2, 3};
        List<Integer> output = new ArrayList<>();
        int last_negative_integer = -1, first_positive_integer = 0;

        // logic
        for(int i=0; i<input.length; i++){
            if(input[i] < 0)
                last_negative_integer = i;
            if(input[i] > 0){
                first_positive_integer = i;
                break;
            }
        }

        for(int i=0; i<first_positive_integer-last_negative_integer-1; i++){
            output.add(0);
        }

        while (last_negative_integer>=0 && first_positive_integer <input.length ){
            if(input[first_positive_integer] > Math.abs(input[last_negative_integer])){
                output.add(input[last_negative_integer] * input[last_negative_integer]);
                last_negative_integer--;
            }else{
                output.add(input[first_positive_integer] * input[first_positive_integer]);
                first_positive_integer++;
            }
        }

        while (last_negative_integer >=0){
            output.add(input[last_negative_integer] * input[last_negative_integer]);
            last_negative_integer--;
        }

        while (first_positive_integer <input.length){
            output.add(input[first_positive_integer] * input[first_positive_integer]);
            first_positive_integer++;
        }
        System.out.println(output);
    }
}
