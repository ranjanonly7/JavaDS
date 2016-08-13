package LinkedList;

/**
 * Created by rmukherj on 7/19/16.
 */

class Node {
    int data;
    Node left, right;

    public Node(int d){
        this.data = d;
        left = null;
        right = null;

    }
}
public class BinaryTreeToDLL {

    static Node root;

    // head --> Pointer to head node of created doubly linked list
    static Node head;

    // Initialize previously visited node as NULL. This is
    // static so that the same value is accessible in all recursive
    // calls
    static Node prev;

    private void BinaryTree2DoublyLinkedList(Node root){
        if(root == null){
            return;
        }

        BinaryTree2DoublyLinkedList(root.left);

        if(prev == null){
            head = root;
        } else {
            root.left = prev;
            prev.right = root;
        }

        prev = root;

        BinaryTree2DoublyLinkedList(root.right);
    }

    /* Function to print nodes in a given doubly linked list */
    void printList(Node node)
    {
        while (node != null)
        {
            System.out.print(node.data + " ");
            node = node.right;
        }
    }

    // Driver program to test above functions
    public static void main(String[] args)
    {
        // Let us create the tree as shown in above diagram
        BinaryTreeToDLL tree = new BinaryTreeToDLL();
        tree.root = new Node(10);
        tree.root.left = new Node(12);
        tree.root.right = new Node(15);
        tree.root.left.left = new Node(25);
        tree.root.left.right = new Node(30);
        tree.root.right.left = new Node(36);

        // convert to DLL
        tree.BinaryTree2DoublyLinkedList(root);

        // Print the converted List
        tree.printList(head);

    }

}

