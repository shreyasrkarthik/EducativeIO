package merge_intervals;

import java.util.ArrayList;

public class IntervalIntersection {
    public static void main(String[] args) {
        ArrayList<Interval> intervals1 = new ArrayList<>();
        ArrayList<Interval> intervals2 = new ArrayList<>();
        ArrayList<Interval> output = new ArrayList<>();

        intervals1.add(new Interval(1,3));
        intervals1.add(new Interval(5,7));
        intervals1.add(new Interval(9,12));

        intervals2.add(new Interval(2,3));
        intervals2.add(new Interval(5,10));

        int i=0, j = 0;
        while(i < intervals1.size() && j < intervals2.size()){
            Interval interval_a = intervals1.get(i);
            Interval interval_b = intervals2.get(j);
            if(interval_a.start > interval_b.start) {
                if(interval_a.start <= interval_b.end){
                    // Intersection can be found
                    output.add(new Interval(Math.max(interval_a.start, interval_b.start), Math.min(interval_a.end, interval_b.end)));
                }
                j++;
            }
            else{
                if(interval_b.start <= interval_a.end){
                    // Intersection can be found
                    output.add(new Interval(Math.max(interval_a.start, interval_b.start), Math.min(interval_a.end, interval_b.end)));
                }
                i++;
            }
        }
        Interval.printIntervalList(output);
    }
}
