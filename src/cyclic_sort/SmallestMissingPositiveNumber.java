package cyclic_sort;

import java.util.Arrays;

public class SmallestMissingPositiveNumber {
    public static void main(String[] args) {
        int[] input = {3, 2, 5, 1};
        int output = -1;
        int i=0;

        while (i<input.length){
            if(input[i] <= 0 || input[i]>input.length || input[i] == input[input[i]-1])
                i++;
            else{
                // swap two numbers
                int temp = input[input[i]-1];
                input[input[i]-1] = input[i];
                input[i] = temp;

            }
        }
        for(int j=0; j<input.length; j++){
            if(input[j] != j+1) {
                output = j + 1;
                break;
            }
        }
        System.out.println(output);
    }
}
