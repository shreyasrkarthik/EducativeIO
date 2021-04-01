package linkedlist_reversal;

class Node{
    int value = 0;
    Node next;
    Node(int value){
        this.value = value;
        this.next = null;
    }

    static void printLL(Node head){
        System.out.print("[ ");
        while (head != null){
            System.out.print(head.value+", ");
            head = head.next;
        }
        System.out.println("]");
    }
}
