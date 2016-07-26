package LinkedList;

/**
 * Created by rmukherj on 7/14/16.
 */
public class LinkedList {

    Node head;
    class Node
    {
        int data;
        Node next;

        Node(int d){
            data = d;
            next = null;
        }
    }

    public void push(int new_data){
        Node node = new Node(new_data);
        node.next = head;
        head = node;
    }

    /* Inserts a new node after the given prev_node. */
    public void insertAfter(Node prev_node, int new_data){
        if(prev_node == null){
            System.out.println("Prev node cannot be null");
            return;
        }

        Node new_node = new Node(new_data);
        new_node.next = prev_node.next;
        prev_node.next = new_node;
    }

    /* Appends a new node at the end.  This method is
       defined inside LinkedList class shown above */
    public void append(int new_data){
         /* 1. Allocate the Node &
           2. Put in the data
           3. Set next as null */

        Node new_node = new Node(new_data);
         /* 4. If the Linked List is empty, then make the
              new node as head */
        if(head == null){
            head = new Node(new_data);
            return;

        }

          /* 4. This new node is going to be the last node, so
              make next of it as null */

        new_node.next = null;
        Node last = head;

         /* 5. Else traverse till the last node */
        while(last.next!=null){
            last = last.next;
        }

        last.next = new_node;
        return;
    }

    /* This function prints contents of linked list starting from
      the given node */
    public void printList()
    {
        Node tnode = head;
        while (tnode != null)
        {
            System.out.print(tnode.data+" ");
            tnode = tnode.next;
        }
    }

    /* Given a key, deletes the first occurrence of key in linked list */
    void deleteNode(int key)
    {
        // Store head node
        Node temp = head, prev = null;

        // If head node itself holds the key to be deleted
        if (temp != null && temp.data == key)
        {
            head = temp.next; // Changed head
            return;
        }

        // Search for the key to be deleted, keep track of the
        // previous node as we need to change temp.next
        while (temp != null && temp.data != key)
        {
            prev = temp;
            temp = temp.next;
        }

        // If key was not present in linked list
        if (temp == null) return;

        // Unlink the node from linked list
        prev.next = temp.next;
    }

    /* Given a reference (pointer to pointer) to the head of a list
       and a position, deletes the node at the given position */
    void deleteNodeOnPosition(int position)
    {
        // If linked list is empty
        if (head == null)
            return;

        // Store head node
        Node temp = head;

        // If head needs to be removed
        if (position == 0)
        {
            head = temp.next;   // Change head
            return;
        }

        // Find previous node of the node to be deleted
        for (int i=0; temp!=null && i<position-1; i++)
            temp = temp.next;

        // If position is more than number of ndoes
        if (temp == null || temp.next == null)
            return;

        // Node temp->next is the node to be deleted
        // Store pointer to the next of node to be deleted
        Node next = temp.next.next;

        temp.next = next;  // Unlink the deleted node from list
    }

    /* Drier program to test above functions. Ideally this function
       should be in a separate user class.  It is kept here to keep
       code compact */
    public static void main(String[] args)
    {
        /* Start with the empty list */
        LinkedList llist = new  LinkedList();

        // Insert 6.  So linked list becomes 6->NUllist
        llist.append(6);

        // Insert 7 at the beginning. So linked list becomes
        // 7->6->NUllist
        llist.push(7);

        // Insert 1 at the beginning. So linked list becomes
        // 1->7->6->NUllist
        llist.push(1);

        // Insert 4 at the end. So linked list becomes
        // 1->7->6->4->NUllist
        llist.append(4);

        // Insert 8, after 7. So linked list becomes
        // 1->7->8->6->4->NUllist6
        llist.insertAfter(llist.head.next, 8);

        System.out.println("\nCreated Linked list is: ");
        llist.printList();
        llist.deleteNode(1); // Delete node at position 4

        System.out.println("\nLinked List after Deletion at position 4:");
        llist.printList();

        llist.deleteNodeOnPosition(2);
        llist.printList();
    }


}
