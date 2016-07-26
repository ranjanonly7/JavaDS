package LinkedList;

import java.util.Random;

/**
 * Created by rmukherj on 7/16/16.
 */
public class MergeSortLinkedList {
    static Node head;

    static class Node {
        int data;
        Node next;

        public Node()
        {}

        public Node(int d){
            data = d;
            next = null;
        }
    }

    public void insert(int val){
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
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



    public static void main(String[] args)
    {

    }
}
