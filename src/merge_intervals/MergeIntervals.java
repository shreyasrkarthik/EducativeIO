package merge_intervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MergeIntervals {
    public static void main(String[] args) {
        ArrayList<Interval> intervals = new ArrayList<Interval>();
        ArrayList<Interval> output = new ArrayList<>();
        intervals.add(new Interval(1,4));
        intervals.add(new Interval(2,6));
        intervals.add(new Interval(5,9));

        System.out.print("Input interval list is: ");
        Interval.printIntervalList(intervals);

        // Sort the interval List
        Comparator<Interval> intervalComparator = Comparator.comparing(Interval::getStart);
        Collections.sort(intervals, intervalComparator);

        System.out.print("Sorted interval list is: ");
        Interval.printIntervalList(intervals);

        System.out.println("Merged intervals are:");
        output = mergeIntervals(intervals);
        Interval.printIntervalList(output);
    }

    public static ArrayList<Interval> mergeIntervals(ArrayList<Interval> intervals){
        ArrayList<Interval> output = new ArrayList<>();
        for(Interval interval: intervals){
            int output_size = output.size();
            if(output_size == 0){
                output.add(interval);
            }
            else{
                Interval prevInterval = output.get(output_size-1);
                if(interval.start <= prevInterval.end || interval.end <= prevInterval.end){
                    output.remove(prevInterval);
                    output.add(new Interval(prevInterval.start, Math.max(interval.end, prevInterval.end)));
                }
                else
                    output.add(interval);
            }
        }
        return output;
    }
}
