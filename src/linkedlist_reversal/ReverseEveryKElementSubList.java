package linkedlist_reversal;

public class ReverseEveryKElementSubList {
    public static void main(String[] args) {
        Node head = new Node(2);
        head.next = new Node(4);
        head.next.next = new Node(6);
        head.next.next.next = new Node(8);
        head.next.next.next.next = new Node(10);
        head.next.next.next.next.next = new Node(12);
        head.next.next.next.next.next.next = new Node(14);
        head.next.next.next.next.next.next.next = new Node(16);
        head.next.next.next.next.next.next.next.next = new Node(18);

        int k = 3;

        Node reverse = reverseKElements(head, k);
        Node.printLL(reverse);
    }

    public static Node reverseKElements(Node head, int k){
        if(head == null || k<=1)
            return head;

        Node previous = null, current = head;

        while (true){
            Node lastNodeOfPrevSubList = previous, lastNodeOfSubList = current, next = null;

            for(int i=0; i<k && current!=null; i++){
                next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }

            if(lastNodeOfPrevSubList == null)
                head = previous; // Assign new head
            else
                lastNodeOfPrevSubList.next = previous; // Connect the two lists

            lastNodeOfSubList.next = current;
            if(current == null)
                break;
            previous = lastNodeOfSubList;
        }
        return head;
    }
}
