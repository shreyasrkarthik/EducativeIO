package merge_intervals;

import java.util.ArrayList;

class Interval{
    int start, end;
    Interval(int start, int end){
        this.start = start;
        this.end = end;
    }

    int getStart(){
        // This is written to create a comparator for sorting intervals by start
        return this.start;
    }

    int getEnd(){
        // This is written to create a comparator for sorting intervals by end
        return this.end;
    }

    static void printIntervalList(ArrayList<Interval> intervals){
        System.out.print("[");
        for(Interval interval: intervals){
            System.out.print("["+interval.start+", "+interval.end+"] ");
        }
        System.out.println("]");
    }
}
