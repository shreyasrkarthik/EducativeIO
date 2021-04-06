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


        Node copyHead = new Node(2);
        copyHead.next = new Node(4);
        copyHead.next.next = new Node(6);
        copyHead.next.next.next = new Node(8);
        copyHead.next.next.next.next = new Node(10);
        copyHead.next.next.next.next.next = new Node(12);
        copyHead.next.next.next.next.next.next = new Node(14);
        copyHead.next.next.next.next.next.next.next = new Node(16);
        copyHead.next.next.next.next.next.next.next.next = new Node(18);

        int k = 3;
        Node output = null, copyOutput = null;

        // print current Linked List
        System.out.print("Given linked list is:");
        Node.printLL(copyHead);

        // Count number of Nodes
        int countNumNodes = 0;
        while (copyHead != null){
            countNumNodes += 1;
            copyHead = copyHead.next;
        }
        System.out.println("Number of nodes in the LL is "+countNumNodes);
        for(int i=1; i<=countNumNodes; i+=k){
            System.out.println(i+" "+(i+k)+" "+getNthNode(copyHead, i)+" "+copyHead);
            Node reversedHead = reverseSubList(getNthNode(copyHead, i), getNthNode(copyHead, i+k));
            Node.printLL(reversedHead);
            Node.printLL(head);

            if(output == null) {
                output = reversedHead;
                copyOutput = reversedHead;
            }
            else{
                output = getNthNode(output, i-1);
                output.next = reversedHead;
            }
        }
        Node.printLL(copyOutput);
    }

    public static Node reverseSubList(Node start, Node end){
        Node prev = null, next;
        while (start!=end){
            next = start.next;
            start.next = prev;
            prev = start;
            start = next;
        }
        return prev;
    }
    public static Node getNthNode(Node head, int n){
        Node start;
        start = head;
        while(n>1 && start!=null){
            start = start.next;
            n--;
        }
        return start;
    }
}
