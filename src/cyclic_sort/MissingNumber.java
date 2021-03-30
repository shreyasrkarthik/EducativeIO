package cyclic_sort;

public class MissingNumber {
    public static void main(String[] args) {
        int[] input = {8, 3, 5, 2, 4, 6, 0, 1};
        int i=0, output = -1;
        while (i < input.length){
            if(input[i] == input.length || input[i] == i)
                i++;
            else{
                int temp = input[i];
                if(temp != input.length) {
                    int actual = input[temp];
                    input[i] = actual;
                    input[temp] = temp;
                }
            }
        }
        for(int j=0; j<input.length; j++){
            if(input[j] != j) {
                output = j;
                break;
            }
        }
        System.out.println("Missing number is " + output);
    }
}
