package breadth_first_search;

import java.util.List;
import java.util.ArrayList;

public class ConnectAllLevelOrderSiblings {
    public static void main(String[] args) {
        Node root = new Node(1);
        Node left = new Node(2, new Node(4), null);
        Node right = new Node(3, new Node(6), new Node(7));
        root.left = left;
        root.right = right;

        connectNodes(root);
        while (root!=null){
            System.out.print(root.val + " ");
            root = root.next;
        }
    }

    public static Node connectNodes(Node root){
        List<Node> queue = new ArrayList<>();
        Node previous = new Node();
        queue.add(root);
        while (!queue.isEmpty()){
            int queue_size = queue.size();
            for(int i=0; i<queue_size; i++){
                Node cur = queue.get(0);
                if(previous != null)
                    previous.next = cur;
                previous = cur;
                if(cur.left != null) queue.add(cur.left);
                if(cur.right != null) queue.add(cur.right);
                queue.remove(0);
            }
        }
        previous.next = null;
        return root;
    }
}
