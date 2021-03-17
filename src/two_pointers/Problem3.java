package two_pointers;

public class Problem3 {
    public static void main(String[] args) {
        int[] input = {1, 2, 5, 3, 7, 10, 9, 12};
        int i=0, j=0;
        int point1 = -1, point2 = -1, min_so_far = Integer.MAX_VALUE;

        // Find points of change
        while(i<input.length - 1){
            if(input[i+1]<input[i]) {
                if (point1 == -1) {
                    point1 = i;
                    min_so_far = Math.min(min_so_far, input[point1]);
                }
                else{
                    point2 = i + 1;
                    min_so_far = Math.min(min_so_far, input[point2]);
                }
            }
            i++;
        }

        // Check if point 1 needs to be changed
        while (j<input.length){
            if(input[j]>min_so_far)
                point1 = Math.min(j, point1);
            j++;
        }

        if(point1 == -1 && point2 == -1)
            System.out.println("Output: 0");
        else
            System.out.println("Output: "+ (point2 - point1 + 1));

    }
}
