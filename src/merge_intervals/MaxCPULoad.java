package merge_intervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MaxCPULoad {
    public static void main(String[] args) {
        ArrayList<Interval> cpuCycles = new ArrayList<>();
        int output = 0, max_load = 0;
        cpuCycles.add(new Interval(1,4,3));
        cpuCycles.add(new Interval(2,5,4));
        cpuCycles.add(new Interval(7,9,6));

        Comparator<Interval> intervalComparator = Comparator.comparing(Interval::getStart).thenComparing(Interval::getEnd);
        Collections.sort(cpuCycles, intervalComparator);

        int i=0;
        while (i<cpuCycles.size()-1){
            Interval one = cpuCycles.get(i), two = cpuCycles.get(i+1);
            max_load = Math.max(max_load, Math.max(one.load, two.load));
            if(two.start < one.end){
                cpuCycles.set(i, new Interval(one.start, Math.max(one.end, two.end), one.load+ two.load));
                cpuCycles.remove(i+1);
            }
            else{
                i++;
            }
        }
        for(Interval interval: cpuCycles){
            output = Math.max(output, interval.load);
        }
        System.out.println(output);
    }
}
