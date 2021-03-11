package daily_problems;

import java.util.HashMap;

public class Day1 {
    /*
        Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
        For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
    */

    public static void main(String[] args) {
        int array[] = {10, 15, 3, 7};
        int k = 17;

        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap cap = new HashMap<Integer, Integer>();

        for(int i=0; i<array.length; i++){
            map.put(array[i],  map.getOrDefault(array[i], 0)+1);
        }
        boolean output = false;

        for(int i=0; i<array.length; i++){
            if(k - array[i] == array[i]){
                map.put(array[i], map.getOrDefault(array[i], 0)-1);
            }
            if(map.getOrDefault(k-array[i], 0)>0){
                output = true;
                System.out.println("Two numbers that add up to "+k + ": are "+array[i]+" and "+(k-array[i]));
                break;
            }

        }
        if (!output)
            System.out.println("No two numbers add up to "+k);
    }
}
