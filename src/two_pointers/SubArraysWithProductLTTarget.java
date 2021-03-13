package two_pointers;

import java.util.ArrayList;
import java.util.List;

public class SubArraysWithProductLTTarget {
    public static void main(String[] args) {
        int[] input = {2, 5, 3, 10};
        int target = 30;
        List<List> output = new ArrayList<>();

        for(int i=0; i<input.length; i++){
            if(input[i]>=target)
                continue;
            List<Integer> cur_list = new ArrayList<>();
            if(i==input.length-1){
                cur_list.add(input[i]);
                output.add(new ArrayList<Integer>(cur_list));
                break;
            }
            cur_list.add(input[i]);
            int cur_prod = input[i], j = i+1;
            while(cur_prod < target && j<input.length){
                output.add(new ArrayList<Integer>(cur_list));
                cur_prod *= input[j];
                cur_list.add(input[j]);
                j++;
            }
            if(cur_prod < target)
                output.add(cur_list);
        }

        System.out.println(output);
    }
}
