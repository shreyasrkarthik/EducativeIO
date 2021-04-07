package leetcode;

public class CountConsistentStrings {
    // Problem Num: 1684
    public static void main(String[] args) {
        String allowed = "abc";
        String[] input = {"a","b","c","ab","ac","bc","abc"};
        int output = countConsistentStrings(allowed, input);
        System.out.println(output);
    }
    public static int countConsistentStrings(String allowed, String[] words) {
        int[] charPresent = new int[500];
        for(int i=0; i<allowed.length(); i++){
            char c = allowed.charAt(i);
            charPresent[(int) c] += 1;
        }
        int output = 0;
        for(String word: words){
            output += 1;
            for(int i=0; i<word.length(); i++){
                char c = word.charAt(i);
                if(charPresent[(int) c] == 0){
                    output -= 1;
                    break;
                }
            }
        }
        return output;
    }
}
