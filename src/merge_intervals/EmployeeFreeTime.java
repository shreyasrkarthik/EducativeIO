package merge_intervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class EmployeeFreeTime {
    public static void main(String[] args) {
        ArrayList<ArrayList> employeeWorkTimings = new ArrayList<>();
        ArrayList<Interval> output = new ArrayList<>();

        ArrayList<Interval> employee1 = new ArrayList<>();
        employee1.add(new Interval(1,3));
//        employee1.add(new Interval(9,12));
        employeeWorkTimings.add(employee1);

        ArrayList<Interval> employee2 = new ArrayList<>();
        employee2.add(new Interval(2,4));
//        employee2.add(new Interval(6,8));
        employeeWorkTimings.add(employee2);

        ArrayList<Interval> employee3 = new ArrayList<>();
        employee3.add(new Interval(3,5));
        employee3.add(new Interval(7,9));
        employeeWorkTimings.add(employee3);

        ArrayList<Interval> combinedWorkTimings = new ArrayList<>();
        for(ArrayList employee: employeeWorkTimings){
            for(int i=0; i< employee.size(); i++){
                combinedWorkTimings.add((Interval) employee.get(i));
            }
        }
        Interval.printIntervalList(combinedWorkTimings);
        Comparator<Interval> intervalComparator = Comparator.comparing(Interval::getStart).thenComparing(Interval::getEnd);
        Collections.sort(combinedWorkTimings, intervalComparator);
        Interval.printIntervalList(combinedWorkTimings);

        int j=0;
        while (j < combinedWorkTimings.size()-1){
            Interval first = combinedWorkTimings.get(j), second = combinedWorkTimings.get(j+1);
            if(second.start > first.end){
                output.add(new Interval(first.end, second.start));
            }
            j++;
        }
        Interval.printIntervalList(output);
    }
}
