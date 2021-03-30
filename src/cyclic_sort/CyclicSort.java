package cyclic_sort;
import java.util.ArrayList;

class Number{
    int number;
    Number(int number){
        this.number = number;
    }
    static void printNumbers(ArrayList<Number> numbers){
        System.out.print("[ ");
        for(Number number: numbers){
            System.out.print(number.number+", ");
        }
        System.out.println("]");
    }
}

public class CyclicSort {
    public static void main(String[] args) {
        ArrayList<Number> input = new ArrayList<>();
        input.add(new Number(1));
        input.add(new Number(5));
        input.add(new Number(6));
        input.add(new Number(4));
        input.add(new Number(3));
        input.add(new Number(2));
        Number.printNumbers(input);
        int i=0;
        while (i<input.size()){
            Number cur = input.get(i);
            if (cur.number-1 == i)
                i++;
            else{
                // swap cur with the number at that position
                Number actual = input.get(cur.number-1);
                input.set(i, actual);
                input.set(cur.number-1, cur);
            }
        }
        Number.printNumbers(input);
    }
}
