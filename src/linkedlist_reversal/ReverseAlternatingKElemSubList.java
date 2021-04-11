package linkedlist_reversal;

public class ReverseAlternatingKElemSubList {
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

        Node reverse = reverseAlternateKElements(head, k);
        Node.printLL(reverse);
    }
    public static Node reverseAlternateKElements(Node head, int k){
        if(head == null || k<=1)
            return head;

        Node previous = null, current = head;
        while (current != null){
            Node lastNodeOfPrevSubList = previous, lastNodeSubList = current;

            for(int i=0; i<k && current!=null; i++)
            {
                Node next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }

            if(lastNodeOfPrevSubList == null)
                head = previous;
            else
                lastNodeOfPrevSubList.next = previous;

            lastNodeSubList.next = current;

            for(int i=0;i<k&&current!=null;i++){
                previous = current;
                current = current.next;
            }
        }
        return head;
    }
}
