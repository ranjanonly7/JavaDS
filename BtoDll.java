package LinkedList;

/**
 * Created by rmukherj on 7/19/16.
 *In the following implementation, we traverse the tree in inorder fashion.
 * We add nodes at the beginning of current linked list and update head of the list using pointer to head pointer.
 * Since we insert at the beginning, we need to process leaves in reverse order.
 * For reverse order, we first traverse the right subtree before the left subtree. i.e. do a reverse inorder traversal.
 */

/* Structure for tree and Linked List */
class Node1
{
    int data;
    Node left, right;

    public Node1(int data)
    {
        this.data = data;
        left = right = null;
    }
}

public class BtoDll {
    // 'root' - root of binary tree
    static Node root;

    // 'head' - reference to head node of created
    //double linked list
    static Node head;

    // A simple recursive function to convert a given
    // Binary tree to Doubly Linked List
    void BToDLL(Node root) {
        // Base cases
        if (root == null)
            return;

        BToDLL(root.right);

        root.right = head;

        if(head!=null){
            head.left = root;
        }

        head = root;

        BToDLL(root.left);

    }

    // Utility function for printing double linked list.
    void printList(Node head)
    {
        System.out.println("Extracted Double Linked List is : ");
        while (head != null)
        {
            System.out.print(head.data + " ");
            head = head.right;
        }
    }
    // Driver program to test the above functions
    public static void main(String[] args)
    {
        /* Constructing below tree
               5
             /   \
            3     6
           / \     \
          1   4     8
         / \       / \
        0   2     7   9  */

        BtoDll tree = new BtoDll();
        tree.root = new Node(5);
        tree.root.left = new Node(3);
        tree.root.right = new Node(6);
        tree.root.left.right = new Node(4);
        tree.root.left.left = new Node(1);
        tree.root.right.right = new Node(8);
        tree.root.left.left.right = new Node(2);
        tree.root.left.left.left = new Node(0);
        tree.root.right.right.left = new Node(7);
        tree.root.right.right.right = new Node(9);

        tree.BToDLL(root);
        tree.printList(head);
    }
}
