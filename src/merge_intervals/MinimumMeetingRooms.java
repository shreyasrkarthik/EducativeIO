package merge_intervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MinimumMeetingRooms {
    public static void main(String[] args) {
        ArrayList<Interval> intervals = new ArrayList<>();
        ArrayList<Interval> ongoingMeetings = new ArrayList<>();
        int output = 1;
        intervals.add(new Interval(1,4));
        intervals.add(new Interval(2,5));
        intervals.add(new Interval(7,9));

        Comparator<Interval> intervalComparator = Comparator.comparing(Interval::getStart).thenComparing(Interval::getEnd);
        Collections.sort(intervals, intervalComparator);
        Interval.printIntervalList(intervals);
        int i=0;
        while(i<intervals.size()){
            Interval current = intervals.get(i++);
            if(ongoingMeetings.isEmpty()){
                ongoingMeetings.add(current);
            }else{
                int flag = 0;
                for(int j=0; j<ongoingMeetings.size(); j++){
                    Interval meeting = ongoingMeetings.get(j);
                    if(current.start>= meeting.end){
                        ongoingMeetings.set(j, current);
                        flag=1;
                        break;
                    }
                }
                if(flag == 0)
                    ongoingMeetings.add(current);
            }
        }
        System.out.println(ongoingMeetings.size());
    }
}
