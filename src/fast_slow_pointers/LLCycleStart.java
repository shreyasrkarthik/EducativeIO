package fast_slow_pointers;
public class LLCycleStart{

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList cycle start: " + getCycleStart(head).val);

        head.next.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList cycle start: " + getCycleStart(head).val);

        head.next.next.next.next.next.next = head;
        System.out.println("LinkedList cycle start: " + getCycleStart(head).val);
    }

    public static Node getCycleStart(Node head) {

        Node fast = head.next, slow = head;
        int cycleLength = 0;
        if (slow != fast) {
            while (fast != null && fast.next != null) {
                if (fast.next.next == slow.next)
                    break;
                slow = slow.next;
                fast = fast.next.next;
                cycleLength++;
            }
            cycleLength += 2;
        }
        System.out.println("cycle-length: "+cycleLength);

        fast = head.next;
        slow = head;
        for(int i=1; i<cycleLength;i++){
            fast = fast.next;
        }
        while (fast!=slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
