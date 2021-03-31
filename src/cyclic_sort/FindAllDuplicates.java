package cyclic_sort;

import java.util.Arrays;
import java.util.HashSet;

public class FindAllDuplicates {
    public static void main(String[] args) {
        int[] input = {5, 4, 7, 2, 3, 5, 3};
        HashSet<Integer> output = new HashSet<>();
        int i=0;
        while (i<input.length){
            if(input[i] == input[input[i]-1])
                i++;
            else{
                //swap two numbers
                int temp = input[input[i]-1];
                input[input[i] - 1] = input[i];
                input[i] = temp;
            }
        }
        System.out.println(Arrays.toString(input));
        for (int j=0; j<input.length; j++){
            if(input[j] != j+1)
                output.add(input[j]);
        }
        System.out.println(output.toString());
    }
}
