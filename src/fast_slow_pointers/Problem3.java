package fast_slow_pointers;

public class Problem3 {
    static int flag = 0;
    public static void main(String[] args) {
        int[] input = {1, 2, -1, 2, 2};
        int slow = 0, fast = 0;
        System.out.println("Slow: "+slow+" , Fast: "+fast);

        boolean isPos = input[slow] > 0 ? true : false;
        do{
            slow = getNext(input, slow, isPos);
            fast = getNext(input, getNext(input, fast, isPos), isPos);
            System.out.println("Slow: "+slow+" , Fast: "+fast);

        }while(slow != fast);

        if(slow == fast && flag == 0)
            System.out.println("True");
        else
            System.out.println("False");
    }

    public static int getNext(int[] array, int index, boolean isPos){
        if ((array[index] < 0 && isPos == true) || (array[index] > 0 && isPos == false)) {
            flag = 1;
        }
        return (index+array[index])%array.length;
    }
}
