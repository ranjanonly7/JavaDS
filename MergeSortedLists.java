package LinkedList;

/**
 * Created by rmukherj on 7/16/16.
 */
public class MergeSortedLists {
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

    Node recursiveSortedMerge(Node current, Node prev){
         Node result = null;
         if(current == null){
             return prev;
         }

         if(prev == null ){
             return current;
         }

         if(current.data<=prev.data){

             current.next = recursiveSortedMerge(current.next,prev);
             return current;
         } else {
             prev.next = recursiveSortedMerge(prev.next, current);
             return prev;

         }

        // return result;

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
        MergeSortedLists list = new MergeSortedLists();
        list.head = new Node(8);
        list.head.next = new Node(5);
        list.head.next.next = new Node(4);
        list.head.next.next.next = new Node(2);

        MergeSortedLists list1 = new MergeSortedLists();
        list.head = new Node(5);
        list.head.next = new Node(3);
        list.head.next.next = new Node(4);
        list.head.next.next.next = new Node(1);

        Node n = new Node(7);
        n.next = new Node(4);
        n.next.next = new Node(2);
        n.next.next.next = new Node(1);

        Node n1 = new Node(72);
        n1.next = new Node(43);
        n1.next.next = new Node(52);
        n1.next.next.next = new Node(13);

        System.out.println("Original Linked list is :");
       // list.printList(head);
       // head = list.recursiveSortedMerge(n,n1);
        head = list.mergeSort(n);
        list.printList(head);
        System.out.println("");
      //  System.out.println("Reversed linked list : ");
      //  list.printList(head);
    }

}
