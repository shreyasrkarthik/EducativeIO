package cyclic_sort;

import java.util.ArrayList;
import java.util.Arrays;

public class FindAllMissingNumbers {
    public static void main(String[] args) {
        int[] input = {2, 4, 1, 2};
        ArrayList<Integer> output = new ArrayList<>();
        int i=0;
        while (i < input.length){
            if(input[input[i]-1] == input[i])
                i++;
            else{
                // swap numbers at i, input[i]
                int temp = input[input[i]-1];
                input[input[i]-1] = input[i];
                input[i] = temp;
            }
        }
        for(int j=0; j<input.length; j++){
            if (input[j] != j+1)
                output.add((int)j+1);
        }
        System.out.println(Arrays.toString(output.toArray()));
    }
}
