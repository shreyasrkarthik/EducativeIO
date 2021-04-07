package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class MoveAllOnesToEachBox {
    public static int[] minOperations(String boxes) {
        ArrayList<Integer> ones = new ArrayList<>();
        int[] output = new int[boxes.length()];

        for(int i=0; i<boxes.length();i++){
            if(boxes.charAt(i) == '1'){
                ones.add(i);
            }
        }
        for(int i=0; i<boxes.length();i++){
            int total = 0;
            for(int j=0;j<ones.size();j++){
                if(i!=ones.get(j))
                    total += Math.abs(i-ones.get(j));
            }
            output[i] = total;
        }
        return output;
    }

    public static void main(String[] args) {
        String boxes = "001011";
        System.out.println(Arrays.toString(minOperations(boxes)));

        boxes = "110";
        System.out.println(Arrays.toString(minOperations(boxes)));
    }
}
