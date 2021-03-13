package two_pointers;

import java.util.Arrays;

public class DutchNationalFlagProblem {
    public static void main(String[] args) {
        int[] input = {2, 2, 0, 1, 2, 0};
        int z_pointer = 0, t_pointer = input.length-1, cur = 0;
        while(cur < input.length){
            if(input[cur] == 0 && cur>z_pointer && z_pointer < input.length){
                // swap cur with z-pointer
                input[cur] += input[z_pointer];
                input[z_pointer] = input[cur]-input[z_pointer];
                input[cur] = input[cur] - input[z_pointer];
                z_pointer++;
            }
            else if(input[cur] == 2 && cur<t_pointer && t_pointer>=0){
                // swap cur with t_pointer
                input[cur] += input[t_pointer];
                input[t_pointer] = input[cur]-input[t_pointer];
                input[cur] = input[cur] - input[t_pointer];
                t_pointer--;
            }
            else{
                cur++;
            }
        }
        System.out.println(Arrays.toString(input));
    }
}
