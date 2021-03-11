package sliding_window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem4 {
    public static void main(String[] args) {
        // input variables
        String input = "catcatfoxfox";
        String words[] = {"cat", "fox"};

        // other variables
        int numWords = words.length, wordLength = words[0].length();
        List<Integer> output = new ArrayList<>();
        HashMap<String, Integer> wordCounter = new HashMap<>();

        for(String word: words){
            wordCounter.put(word, wordCounter.getOrDefault(word, 0)+1);
        }

        //Logic
        for(int i = 0; i <= input.length() - numWords * wordLength; i++){
            HashMap<String, Integer> wordsSeen = new HashMap<>();
            int j = 0;
            for(j=0; j<numWords; j++){
                int nextWordIndex = i + j * wordLength;
                String cur_word = input.substring(nextWordIndex, nextWordIndex+wordLength);
                if(wordCounter.getOrDefault(cur_word, -1) == -1)
                    break;
                wordsSeen.put(cur_word, wordsSeen.getOrDefault(cur_word, 0)+1);
                if(wordCounter.getOrDefault(cur_word, 0) < wordsSeen.get(cur_word)){
                    break;
                }
            }

            if(j==numWords){
                output.add(i);
            }
        }
        System.out.println(output);
    }
}
