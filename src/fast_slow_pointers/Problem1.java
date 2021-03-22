package fast_slow_pointers;

public class Problem1 {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(2);
        head.next.next.next.next.next = new Node(2);
        System.out.println("Input linked list is: ");
        printLinkedList(head);

        Node middle = getMiddle(head);
        Node copyMiddle = reverse(middle);

        System.out.println("Reversed linked list at middle is: ");
        printLinkedList(copyMiddle);

        if(compareLL(head, copyMiddle))
            System.out.println("Given Linked List is a palindrome");
        else
            System.out.println("Given Linked List is not a palindrome");

        // Change it back to original
        reverse(copyMiddle);

        System.out.println("Linked list at the end of all operations is: ");
        printLinkedList(head);

    }

    public static boolean compareLL(Node head1, Node head2){

        while (head1!=null && head2 != null){
            if (head1.val != head2.val)
                return false;
            head1 = head1.next;
            head2 = head2.next;
        }
        return true;
    }
    public static Node getMiddle(Node head){
        Node slow = head, fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void printLinkedList(Node head){
        while (head!=null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static Node reverse(Node head){
        Node cur = head, prev = null;
        while(cur!=null){
            Node next = cur.next;
            cur.next = prev;

            prev = cur;
            cur = next;
        }
        return prev;
    }
}
