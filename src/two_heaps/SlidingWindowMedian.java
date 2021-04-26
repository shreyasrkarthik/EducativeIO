package two_heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class SlidingWindowMedian {
    public static PriorityQueue<Integer> minHeap;
    public static PriorityQueue<Integer> maxHeap;
    
    public static void main(String[] args) {
        double[] result = findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 2);
        System.out.print("Sliding window medians are: ");
        for (double num : result)
            System.out.print(num + " ");
        System.out.println();

        result = findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 3);
        System.out.print("Sliding window medians are: ");
        for (double num : result)
            System.out.print(num + " ");
    }

    public static double[] findSlidingWindowMedian(int[] arr, int winSize){
        double[] res = new double[arr.length - winSize + 1];
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<winSize; i++)
            insertNum(arr[i]);
        int i;
        for(i=0; i<res.length-1; i++){
            res[i] = findMedian();
            removeNum(arr[i]);
            insertNum(arr[i + winSize]);
        }
        res[i] = findMedian();
        return res;
    }

    public static void insertNum(int num){
        // Add the number to a heap
        if(maxHeap.size() == 0)
            maxHeap.add(num);
        else if(maxHeap.peek() >= num){
            maxHeap.add(num);
        }
        else{
            minHeap.add(num);
        }

        // Re-balance the heaps
        if(maxHeap.size() > minHeap.size()+1){
            minHeap.add(maxHeap.poll());
        }
        else if(minHeap.size() > maxHeap.size()){
            maxHeap.add(minHeap.poll());
        }
    }
    
    public static void removeNum(int num){
        if(num <= maxHeap.peek())
            maxHeap.remove(num);
        else
            minHeap.remove(num);
    }
    
    public static float findMedian(){
        if(minHeap.size() == maxHeap.size())
            return (float)(minHeap.peek() + maxHeap.peek())/2;
        else
            return (float)maxHeap.peek();
    }
}