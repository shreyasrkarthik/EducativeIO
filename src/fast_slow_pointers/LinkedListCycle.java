package fast_slow_pointers;

public class LinkedListCycle {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        System.out.println("LinkedList has cycle: " + hasCycle(head));

        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList has cycle: " + hasCycle(head));

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList has cycle: " + hasCycle(head));
    }
    public static boolean hasCycle(Node head){
       Node fast_pointer = head.next, slow_pointer = head;
       while(fast_pointer.next!=null && fast_pointer!=null ){
           if(fast_pointer == slow_pointer)
               return true;
           fast_pointer = fast_pointer.next.next;
           slow_pointer = slow_pointer.next;
       }
        return false;
    }
}
