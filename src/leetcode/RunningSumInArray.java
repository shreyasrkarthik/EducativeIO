package leetcode;

import java.util.Arrays;

public class RunningSumInArray {
    // Problem No. 1480
    public static void main(String[] args) {
        int[] input = {1,2,3,4};
        System.out.println(Arrays.toString(runningSum(input)));
    }

    public static int[] runningSum(int[] input) {
        for(int i=1; i<input.length; i++){
            input[i] += input[i-1];
        }
        return input;
    }
}
