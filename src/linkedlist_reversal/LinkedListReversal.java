package linkedlist_reversal;


public class LinkedListReversal {
    public static void main(String[] args) {
        Node head = new Node(2);
        head.next = new Node(4);
        head.next.next = new Node(6);
        head.next.next.next = new Node(8);
        head.next.next.next.next = new Node(10);

        Node.printLL(head);
        head = reverseLL(head);
        Node.printLL(head);
    }

    public static Node reverseLL(Node head){
        Node prev = null, next;
        while (head != null){
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
