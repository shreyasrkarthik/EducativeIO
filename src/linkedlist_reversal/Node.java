package linkedlist_reversal;

class Node{
    int value = 0;
    Node next;
    public Node(int value){
        this.value = value;
        this.next = null;
    }
    public Node(){
    }
    public static void printLL(Node head){
        System.out.print("[ ");
        while (head != null){
            System.out.print(head.value+", ");
            head = head.next;
        }
        System.out.println("]");
    }
}
