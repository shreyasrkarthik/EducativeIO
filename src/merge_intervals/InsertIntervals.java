package merge_intervals;

import java.util.ArrayList;

public class InsertIntervals {
    public static void main(String[] args) {
        Interval interval = new Interval(4,10);

        ArrayList<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1,3));
        intervals.add(new Interval(5,7));
        intervals.add(new Interval(8,12));

        System.out.println("Given Interval is: ");
        Interval.printIntervalList(intervals);

        insertInterval(intervals, interval);
        intervals = MergeIntervals.mergeIntervals(intervals);

        Interval.printIntervalList(intervals);
    }

    public static void insertInterval(ArrayList<Interval> intervals, Interval interval){
        for(int i=0; i<intervals.size(); i++){
            Interval current = intervals.get(i);
            if(interval.start < current.end) {
                intervals.set(i, new Interval(Math.min(current.start, interval.start), Math.max(current.end, interval.end)));
                break;
            }
        }
    }
}
