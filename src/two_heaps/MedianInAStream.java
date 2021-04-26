package two_heaps;

import java.util.PriorityQueue;

public class MedianInAStream {
    public static void main(String[] args) {
        MedianOfASlidingWindow medianOfASlidingWindow = new MedianOfASlidingWindow();
        medianOfASlidingWindow.insertNum(3);
        medianOfASlidingWindow.insertNum(1);
        System.out.println("The median is: " + medianOfASlidingWindow.findMedian());
        medianOfASlidingWindow.insertNum(5);
        System.out.println("The median is: " + medianOfASlidingWindow.findMedian());
        medianOfASlidingWindow.insertNum(4);
        System.out.println("The median is: " + medianOfASlidingWindow.findMedian());
    }
}

class MedianOfASlidingWindow {

    public PriorityQueue<Integer> minHeap;
    public PriorityQueue<Integer> maxHeap;

    public MedianOfASlidingWindow(){
        this.minHeap = new PriorityQueue<>((a,b)-> a-b);
        this.maxHeap = new PriorityQueue<>((a,b)-> b-a);
    }
    public void insertNum(int num){
        // Add the number to a heap
        if(this.maxHeap.size() == 0)
            this.maxHeap.add(num);
        else if(this.maxHeap.peek() >= num){
            this.maxHeap.add(num);
        }
        else{
            this.minHeap.add(num);
        }

        // Re-balance the heaps
        if(this.maxHeap.size() > this.minHeap.size()+1){
            this.minHeap.add(this.maxHeap.poll());
        }
        else if(this.minHeap.size() > this.maxHeap.size()){
            this.maxHeap.add(this.minHeap.poll());
        }
    }

    public float findMedian(){
        if(this.minHeap.size() == this.maxHeap.size())
            return (float)(this.minHeap.peek() + this.maxHeap.peek())/2;
        else
            return (float)this.maxHeap.peek();
    }
}
