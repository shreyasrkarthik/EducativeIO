package sliding_window;

public class LongestSubStringWithKCharacters {

    public static boolean check_character(char visited[], char sample){
        for(char a: visited){
            if(a == sample)
                return true;
        }
        return false;
    }
    public static void main(String[] args) {
        // Input variables
        String sample_str = "cbbebi";
        int k = 3;

        // Created Variables
        int i = 0, end = 0, start = 0, distinct_char = 0;
        char[] visited = new char [sample_str.length()];
        int [] char_map = new int[500];
        int longest_sub_str_length = 0;

        // Logic
        while(start < sample_str.length() && end < sample_str.length()) {

            // Get the current character and update the char-count array
            char cur_char = sample_str.charAt(end);
            int ascii = (int) cur_char;
            char_map[ascii] += 1;

            // Add current char into visited array, if not already added
            if (!check_character(visited, cur_char)) {
                // Character is missing from the visited array
                distinct_char += 1;
                visited[i++] = cur_char;
            }
            end += 1;

            if(distinct_char <= k){
                longest_sub_str_length = Math.max(longest_sub_str_length, end-start);
            }
            else{

                // Move the start by one and remove its count from char-map
                char first_char = sample_str.charAt(start);
                char_map[(int) first_char] -= 1;
                if(char_map[(int) first_char] == 0){
                    distinct_char -= 1;
                    // Remove from visited array
                    for(int x=0; x< visited.length; x++){
                        if(visited[x] == first_char){
                            visited[x] = 0;
                        }
                    }
                }
                start += 1;
            }
        }

        System.out.println("Maximum length of the substring with k characters is "+ longest_sub_str_length);

    }
}
