package linkedlist_reversal;

public class ReverseSubList {
    public static void main(String[] args) {
        Node head = new Node(2);
        head.next = new Node(4);
        head.next.next = new Node(6);
        head.next.next.next = new Node(8);
        head.next.next.next.next = new Node(10);

        Node copyHead = head;

        System.out.println("Linked List is:");
        Node.printLL(copyHead);

        Node prev = null, next = null, first = null, last = null;
        int p = 2, q = 4, count = 1;
        System.out.println("p: "+p+", q:"+q);

        while (head != null && count <= q+1){
            if(count == p-1)
                prev = head;
            else if(count == p)
                first = head;
            else if(count == q)
                last = head;
            else if(count == q+1)
                next = head;
            count += 1;
            head = head.next;
        }
        Node headPartial = reversePartialList(first, last.next);

        prev.next = headPartial;
        while(headPartial != null){
            last = headPartial;
            headPartial = headPartial.next;
        }
        last.next = next;
        Node.printLL(copyHead);
    }

    public static Node reversePartialList(Node first, Node last){
        Node next, prev = null;
        while (first!=last){
            next = first.next;
            first.next = prev;
            prev = first;
            first = next;
        }
        return prev;
    }
}
