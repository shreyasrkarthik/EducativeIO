package daily_problems;

import java.util.Arrays;

public class Day2 {
    public static void main(String[] args) {
        /*
         Given an array of integers, return a new array such that each element at index i of the new array
         is the product of all the numbers in the original array except the one at i.
         For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24].
         If our input was [3, 2, 1], the expected output would be [2, 3, 6]
         */
        int[] input = {1, 2, 3, 4, 5};
        int[] output = new int[input.length];
        int prod = 1;
        for(int i=0; i<input.length; i++){
            prod *= input[i];
        }

        for(int i=0; i<input.length; i++){
            output[i] = prod/input[i];
        }

        System.out.println(Arrays.toString(output));
    }
}
