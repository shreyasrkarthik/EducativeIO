package fast_slow_pointers;

public class HappyNumber {
    public static void main(String[] args){
        int input = 23;
        int slow = input, fast = input;
        do{
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }while(fast!=slow);
        if(fast == 1)
            System.out.println(input+" is a happy number");
        else
            System.out.println(input+" is an unhappy number");
    }

    public static int getNext(int a){
        int next = 0;
        while(a != 0){
            next += (a%10)*(a%10);
            a = a/10;
        }
        return next;
    }

}
