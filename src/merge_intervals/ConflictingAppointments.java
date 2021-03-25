package merge_intervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ConflictingAppointments {
    public static void main(String[] args) {
        ArrayList<Interval> intervals = new ArrayList<>();
        boolean output = true;

        intervals.add(new Interval(4,5));
        intervals.add(new Interval(2,3));
        intervals.add(new Interval(3,6));

        Comparator<Interval> intervalComparator = Comparator.comparing(Interval::getStart);
        Collections.sort(intervals, intervalComparator);
        int i=0;

        while(i<intervals.size()-1){
            Interval first_interval = intervals.get(i);
            Interval second_interval = intervals.get(i+1);

            if(second_interval.start <= first_interval.end){
                output = false;
                break;
            }
            i++;
        }
        System.out.println(output);

    }
}
