package fast_slow_pointers;

public class Problem2 {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        System.out.println("Input linked list is: ");
        Problem1.printLinkedList(head);

        Node middle = Problem1.getMiddle(head);
        System.out.println("Middle node value is "+middle.val);

        Node headSecondHalf = Problem1.reverse(middle);
        System.out.println("Reversal of second half of the LL is");
        Problem1.printLinkedList(headSecondHalf);
        Node headFirstHalf = head;

        while (headFirstHalf!=null && headSecondHalf!=null){
            Node temp = headFirstHalf.next;
            headFirstHalf.next = headSecondHalf;
            headFirstHalf = temp;

            temp = headSecondHalf.next;
            headSecondHalf.next = headFirstHalf;
            headSecondHalf = temp;
        }

        if (headFirstHalf != null)
            headFirstHalf.next = null;

        System.out.println("Output linked list is: ");
        Problem1.printLinkedList(head);
    }

}
