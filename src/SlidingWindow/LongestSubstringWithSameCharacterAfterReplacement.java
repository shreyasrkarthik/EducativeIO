package SlidingWindow;

import java.util.HashMap;

public class LongestSubstringWithSameCharacterAfterReplacement {
    public static void main(String[] args) {
        // Input variables
        String input = "abccde";
        int k = 1;

        // Other variables
        int output = 0, start = 0, end = 0, max_repeat = 0;
        var char_index = new HashMap<Character, Integer>();

        //Logic
        while(end < input.length()){
            char cur_char = input.charAt(end++);
            int char_count = char_index.getOrDefault(cur_char, 0);
            char_index.put(cur_char, char_count+1);
            max_repeat = Math.max(max_repeat, char_count+1);

            if ((end - start - max_repeat) <= k){
                output = Math.max(output, (end-start));
            }
            else{
                char start_char = input.charAt(start++);
                int start_count = char_index.get(start_char);
                char_index.put(start_char, start_count-1);
            }
        }
        System.out.println(output);
    }
}
