package two_pointers;

import java.util.Arrays;

public class TripletSumClosestTarget {
    public static void main(String[] args) {

        int[] input = {0,1,1,1};
        Arrays.sort(input);
        int target = 3, output = Integer.MAX_VALUE;
        int closest_target = Integer.MAX_VALUE;

        for(int i=0; i<input.length; i++){
            int t1 = input[i], new_target = target-t1;
            int left = i+1, right = input.length-1;

            while (left < right){
                int t2 = input[left], t3 = input[right];
                if(Math.abs(new_target - t2 - t3) < closest_target){
                    closest_target = new_target-t2-t3;
                    output = t1+t2+t3;
                }
                else if((new_target - t2 - t3) == closest_target)
                    output = Math.min(output, t1+t2+t3);
                if(t2+t3 > new_target)
                    right --;
                if(t2+t3 <= new_target)
                    left ++;
            }
        }
        System.out.println(output);
    }
}
