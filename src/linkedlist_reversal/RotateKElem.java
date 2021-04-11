package linkedlist_reversal;

public class RotateKElem {
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

        int k = 15;
        Node reverse = rotateKElem(head, k);
        Node.printLL(reverse);
    }
    public static Node rotateKElem(Node head, int k){
        int linkedListLength = 1; Node lastNode=head;
        while (lastNode.next != null){
            linkedListLength ++;
            lastNode = lastNode.next;
        }
        int rotations = k%linkedListLength;

        Node newHead=head, lastNodeFirstHalf = null;
        for(int i=0;i<rotations;i++){
            lastNodeFirstHalf = newHead;
            newHead = newHead.next;
        }
        lastNodeFirstHalf.next = null;
        lastNode.next = head;

        return newHead;
    }
}
