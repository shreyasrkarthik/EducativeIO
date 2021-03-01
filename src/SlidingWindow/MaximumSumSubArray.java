package SlidingWindow;

public class MaximumSumSubArray {

    public static int getMaxSum(int arr[], int k){
        int sum = 0;
        for(int i=0; i<k; i++){
            sum += arr[i];
        }
        int max_sum = sum, i=0;
        for(int j=k; j<arr.length; j++){
            sum -= arr[i];
            sum += arr[j];
            max_sum = Math.max(max_sum, sum);
            i++;
        }
        return max_sum;
    }
    public static void main(String[] args) {
        int k = 3;
        int[] arr = {2, 1, 5, 1, 3, 2};
        System.out.println("The maximum sum of size "+ k+ " is: "+getMaxSum(arr, k));
    }

}
