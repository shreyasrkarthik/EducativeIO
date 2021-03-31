package cyclic_sort;

public class FindDuplicate {
    public static void main(String[] args) {
        int[] input = {2, 4, 1, 4, 4};
        int i=0;
        while (i < input.length){
            if(input[input[i]-1] == input[i])
                i++;
            else{
                int temp = input[input[i]-1];
                input[input[i]-1] = input[i];
                input[i] = temp;
            }
        }
        for(int j=0; j<input.length; j++){
            if(j+1 != input[j]){
                System.out.println("Missing number is: "+ input[j]);
                break;
            }
        }

    }
}
