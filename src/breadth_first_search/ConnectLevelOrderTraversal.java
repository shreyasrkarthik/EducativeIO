package breadth_first_search;

import java.util.*;

class Node{
    Node left, right, next;
    int val;
    Node(int val){
        this.val = val;
    }

    Node(int val, Node left, Node right){
        this.val = val;
        this.left = left;
        this.right = right;
    }

    Node(int val, Node left, Node right, Node next){
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }
}
public class ConnectLevelOrderTraversal {
    public static void main(String[] args) {
        Node root = new Node(1);
        Node left = new Node(2, new Node(4), new Node(5));
        Node right = new Node(3, new Node(6), new Node(7));
        root.left = left;
        root.right = right;

        Node connectedRoot = connectNodes(root);
        printLevelOrder(connectedRoot);
    }
    public static Node connectNodes(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node previousNode = null;
            int levelSize = queue.size();
            // connect all nodes of this level
            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll();
                if (previousNode != null)
                    previousNode.next = currentNode;
                previousNode = currentNode;

                // insert the children of current node in the queue
                if (currentNode.left != null)
                    queue.offer(currentNode.left);
                if (currentNode.right != null)
                    queue.offer(currentNode.right);
            }
        }
        return root;
    }

    public static void printLevelOrder(Node root) {
        Node nextLevelRoot = root;
        while (nextLevelRoot != null) {
            Node current = nextLevelRoot;
            nextLevelRoot = null;
            while (current != null) {
                System.out.print(current.val + " ");
                if (nextLevelRoot == null) {
                    if (current.left != null)
                        nextLevelRoot = current.left;
                    else if (current.right != null)
                        nextLevelRoot = current.right;
                }
                current = current.next;
            }
            System.out.println();
        }
    }
}
