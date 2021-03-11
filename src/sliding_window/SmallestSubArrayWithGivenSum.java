package sliding_window;

public class SmallestSubArrayWithGivenSum {
    public static void main(String[] args){
        int[] arr = {2, 1, 5, 1, 3, 5, 2};
        int s = 7;
        int flag = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] >= s){
                System.out.println("The Smallest sub array size is "+ 1);
                flag = 1;
            }
        }
        if(flag == 0){
            int min_size = Integer.MAX_VALUE, cur_size = 0, cur_sum = 0, min_start=-1, min_end = -1;
            // Get the size of first sub-array that exceeds s
            while(cur_sum < s){
                cur_sum += arr[cur_size];
                cur_size+=1;
            }
            min_size = cur_size;
            // Remove and add elements from left to right to arrive at the smallest sub-array
            int i=0, arr_len = arr.length;
            while(i < arr_len && cur_size < arr_len){
                // Remove the left-most element
                cur_sum -= arr[i];
                i+=1;

                if(cur_sum >= s){
                    min_size -= 1;
                    min_start = i;
                    min_end = cur_size-1;
                }
                else{
                    // Add the next element
                    cur_sum += arr[cur_size++];
                }
            }
            System.out.println("The Smallest sub array size is "+ min_size);
            System.out.println("The Smallest sub array range is ("+ min_start +", "+ min_end +")");
        }
    }
}
