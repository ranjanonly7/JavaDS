package LinkedList;

/**
 * Created by rmukherj on 7/16/16.
 * input: Head of following linked list
 * 1->2->3->4
 * Output: 4->3->2->1
 *
 */
public class ReverserLinkedList {

    static Node head;


    static class Node {
        int data;
        Node next;

        public Node(){}

        public Node(int d){
            data = d;
            next = null;
        }
    }

    Node reverse(Node node){
        Node prev = null;
        Node current = node;
        Node next = null;
        while(current!=null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        node = prev;
        return node;

    }

    void printList(Node node){
        while(node != null){
            System.out.println(node.data + " ");
            node= node.next;
        }
    }

    public Node mergeSort(Node current){
        if(current == null || current.next == null){
            return current;
        }

        Node a = current;
        Node b = current.next;

        while((b!=null) && (b.next!=null)){
            current = current.next;
            b = (b.next).next;
        }

        b = current.next;
        current.next = null;
        return merge(mergeSort(a),mergeSort(b));
    }

    public Node merge(Node a, Node b){
        Node temp = new Node();
        Node head = temp;
        Node c = head;
        while ((a != null) && (b != null))
        {
            if (a.data <= b.data)
            {
                c.next = a;
                c = a;
                a = a.next;
            }
            else
            {
                c.next = b;
                c = b;
                b = b.next;
            }
        }
        c.next = (a == null) ? b : a;
        return head.next;


    }

    public static void main(String[] args){
        ReverserLinkedList list = new ReverserLinkedList();
        list.head = new Node(85);
        list.head.next = new Node(15);
        list.head.next.next = new Node(4);
        list.head.next.next.next = new Node(20);

        System.out.println("Original Linked list is :");
        list.printList(head);
        head = list.reverse(head);
        System.out.println("");
        System.out.println("Reversed linked list : ");
        list.printList(head);
    }
}
