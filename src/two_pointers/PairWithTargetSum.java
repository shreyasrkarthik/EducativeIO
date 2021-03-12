package two_pointers;

import java.util.ArrayList;
import java.util.List;

public class PairWithTargetSum {
    public static void main(String[] args) {

        // input variables
        int[] array = {1, 2, 3, 4, 6};
        int target = 6;

        // other variables
        List<Integer> output = new ArrayList<>();
        int i=0, j=array.length-1;

        // logic
        while (i!=j){
            if(array[i]+array[j] == target){
                output.add(i);
                output.add(j);
                break;
            }else if(array[i]+array[j] > target){
                j--;
            }else{
                i++;
            }
        }
        System.out.println(output);
    }
}
