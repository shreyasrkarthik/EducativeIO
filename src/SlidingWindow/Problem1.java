package SlidingWindow;

import java.util.HashMap;

public class Problem1 {

    public static int[] char_count(String pattern){
        int char_count[] = new int[500];

        //Update Char Count of pattern
        for(int i=0; i<pattern.length(); i++){
            char cur = pattern.charAt(i);
            char_count[(int) cur] += 1;
        }
        return char_count;
    }
    public static int getSum(int[] array){
        int sum = 0;
        for(int a: array){
            sum += a;
        }
        return sum;
    }

    public static void main(String[] args) {
        //Problem: Permutation in a String

        //input variables
        String input = "bcdxabcdy", pattern = "cbd";

        //other variables
        int start = 0, end = 0, input_len = input.length();
        int char_count[] = char_count(pattern);

        //Logic
        while (end < input_len) {
            if(char_count[(int)(input.charAt(end))] == 0){
                if(end-start == pattern.length() && getSum(char_count) == 0){
                    System.out.println("Found the matching pattern");
                    System.exit(1);
                }
                else{
                    char_count = char_count(pattern);
                    start = end + 1;
                    end = start;
                }
            }
            else{
                char_count[(int)(input.charAt(end))] --;
                end ++;
            }

        }
        if(end-start == pattern.length() && getSum(char_count) == 0)
        System.out.println("Found the matching pattern");
        else
        System.out.println("Couldn\'t find the pattern in the input string");
    }
}
