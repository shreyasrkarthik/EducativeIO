package cyclic_sort;

import java.util.Arrays;

public class FirstKMissingNumbers {
    public static void main(String[] args) {
        int[] input = {-2, -3, 4};
        int k = 2, i = 0, x = 0, max_num = 0;
        int[] output = new int[k];

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
        System.out.println(Arrays.toString(input));
        for(int j=0; j<input.length && k>0; j++){
            max_num = Math.max(max_num, input[j]);
            if(input[j] != j+1) {
                k--;
                output[x++] = j + 1;
            }
        }
        while (k>0){
            k--;
            max_num++;
            output[x++] = max_num;
        }
        System.out.println(Arrays.toString(output));
    }
}
