package SlidingWindow;

public class Problem3 {

    public static int arraySum(int[] array){
        int sum = 0;
        for(int i: array){
            sum += i;
        }
        return sum;
    }
    public static void main(String[] args) {
        //input variables
        String input = "abcabcabc", pattern = "abc";

        //other variables
        int[] input_map = new int[500];
        int[] pattern_map = new int[500];
        int start = 0, end = 0, start_flag = 0;
        StringBuilder output = new StringBuilder();

        //Fill in the count array
        for(int i=0; i< input.length(); i++){
            input_map[(int)input.charAt(i)] += 1;
        }

        for(int j=0; j< pattern.length(); j++){
            pattern_map[(int)pattern.charAt(j)] += 1;
        }

        //Logic
        for(int i=0; i<input.length(); i++ ){
            char cur = input.charAt(i);
            int ascii = (int) cur;
            if(input_map[ascii] > pattern_map[ascii] && pattern_map[ascii] != 0){
                input_map[ascii]--;
                if(start_flag == 0)
                    start++;
            }
            else if(input_map[ascii] == pattern_map[ascii]){
                if (start_flag == 0){
                    start_flag = 1;
                    start = i;
                }
                end  = i;
                pattern_map[ascii] = 0;
                input_map[ascii] = 0;
            }
        }
        System.out.println(start + " " + end);
        if (arraySum(pattern_map) == 0){
            for(int i=start; i<=end; i++){
                output.append(input.charAt(i));
            }
        }
        System.out.println("Output: " + output.toString());
    }
}
