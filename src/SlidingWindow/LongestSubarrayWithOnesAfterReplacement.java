package SlidingWindow;

public class LongestSubarrayWithOnesAfterReplacement {
    public static void main(String[] args) {
        // Input variables
        int array[] = {0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1};
        int k = 2;

        //Other Variables
        int start = 0, end = 0, output = 0;
        int cur_sum = 0;

        //Logic
        while(end<array.length){
            cur_sum += array[end++];

            if((end-start-cur_sum) <=k){
                output = Math.max(output, end-start);
            }
            else if(array[start] == 1){
                start++;
                cur_sum --;
            }
            else{
                start++;
            }
        }
        System.out.println(output);
    }
}
