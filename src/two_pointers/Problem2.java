package two_pointers;

import java.util.Arrays;

public class Problem2 {
    public static void main(String[] args) {
        String str1 = "xywrrmp";
        String str2 = "xywrrmu#p";
        int i=0, j=0, count1=0, count2=0;
        char[] arr1 = new char[str1.length()];
        char[] arr2 = new char[str2.length()];

        while(i<str1.length()){
            char cur = str1.charAt(i);
            if(cur == '#'){
                arr1[--count1] = 0;
            }
            else {
                arr1[count1++] = cur;
            }
            i++;
        }
        System.out.println(Arrays.toString(arr1));

        while(j<str2.length()){
            char cur = str2.charAt(j);
            if(cur == '#'){
                arr2[--count2] = 0;
            }
            else {
                arr2[count2++] = cur;
            }
            j++;
        }
        System.out.println(Arrays.toString(arr2));

        int flag = 0;
        for(int k=0; k<Math.min(str1.length(), str2.length()); k++){
            if(arr1[k] != arr2[k]){
                System.out.println("False");
                flag = 1;
            }
        }
        if(flag == 0)
            System.out.println("True");
    }
}
