package cyclic_sort;

import java.util.Arrays;

public class FindCorruptPair {
    public static void main(String[] args) {
        int[] input = {3, 1, 2, 3, 6, 4};
        int[] output = new int[2];
        int i=0;

        while (i<input.length){
            if(input[i] == input[input[i]-1])
                i++;
            else{
                // swap two numbers
                int temp = input[input[i]-1];
                input[input[i]-1] = input[i];
                input[i] = temp;
            }
        }
        for(int j=0; j<input.length; j++){
            if(input[j] != j+1){
                output[0] = input[j];
                output[1] = j+1;
            }
        }
        System.out.println(Arrays.toString(output));
    }
}
