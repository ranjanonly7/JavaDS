package tryingsomething;

/**
 * Created by rmukherj on 8/7/16.
 */
public class PracLL {

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




}
