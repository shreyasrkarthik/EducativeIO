package two_pointers;

import java.util.*;

public class TripletsSumToZero {

    public static int getLastIndexOf(int[] array, int k){
        for(int i=array.length-1; i>=0; i--){
            if(array[i] == k)
                return i;
        }
        return -1;
    }
    public static void main(String[] args) {

        // variables
        int[] input = {-3, 0, 1, 2, -1, 1, -2};
        Set<List> output = new HashSet<>();
        HashMap<Integer, Integer> input_map = new HashMap<>();

        // Fill in the hashmap
        for(int i=0; i<input.length; i++){
            input_map.put(input[i], input_map.getOrDefault(input[i], 0)+1);
        }

        System.out.println(Arrays.toString(input));
        // Logic
        for(int i=0; i<input.length; i++){
            int t1 = input[i];
            int target = 0 - t1;
            HashSet<Integer> visited_values = new HashSet<>();
            int t2, t3;
            for(int j=i+1; j<input.length; j++){
                t2 = input[j];
                t3 = target-t2;
                if(t2 == t3 && input_map.get(t2) < 2)
                    continue;
                if(getLastIndexOf(input, t3) < j)
                    continue;

                if(input_map.containsKey(t3) && !(visited_values.contains(t2) && visited_values.contains(t3))){
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(t1);triplet.add(t2);triplet.add(t3);
                    visited_values.add(t2); visited_values.add(t3);
                    output.add(triplet);
                }
            }
        }
        System.out.println(output);

    }
}
