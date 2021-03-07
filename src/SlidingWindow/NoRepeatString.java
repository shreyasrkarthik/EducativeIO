package SlidingWindow;

public class NoRepeatString {

    public static boolean check_character(char[] visited, char c){
        for(char a: visited){
            if(a == c)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        // Input variables
        String input = "abbbb";

        //Other Variables
        int start = 0, end = 0, max_length = 0, i = 0;
        char visited_chars[] = new char[input.length()];


        //Logic
        while(start < input.length() && end < input.length()){
            char cur_char = input.charAt(end);
            if(!check_character(visited_chars, cur_char)){
                // Char is missing from the visited characters
                visited_chars[i++] = cur_char;
                // Max-length is the number of visited characters
                end ++;
            }
            else{
                // Remove character at start from visited
                for(int j=0; j<visited_chars.length; j++){
                    if (visited_chars[j] == input.charAt(start)){
                        visited_chars[j] = 0;
                        break;
                    }
                }
                start += 1;
            }
            max_length = Math.max(max_length, end-start);
        }
        System.out.println("Max length of no-repeat string is: "+max_length);
    }
}
