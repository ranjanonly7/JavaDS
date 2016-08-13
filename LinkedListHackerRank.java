package tryingsomething;

/**
 * Created by rmukherj on 8/7/16.
 */
public class LinkedListHackerRank {

    /*
  Insert Node at the end of a linked list
  head pointer input could be NULL as well for empty list
  Node is defined as
  class Node {
     int data;
     Node next;
  }
*/
    static class Node {
        int data;
        Node next;
    }

    Node InsertNewTail(Node head,int data) {

        if(head == null){
            head = new Node();
            head.data = data;
        } else{
            Node temp = head;
            while(temp.next!=null){
                temp = temp.next;
            }

            temp.next = new Node();
            temp.next.data = data;
        }

        return head;
    }

    /*
  Insert Node at the beginning of a linked list
  head pointer input could be NULL as well for empty list
  Node is defined as

*/

    Node InsertHead(Node head,int x) {
        Node node = new Node();
        node.data = x;
        node.next = head;
        return node;
    }

    //Insert a node at a specific position in a linked list
    Node InsertNth(Node head, int data, int position) {
        // This is a "method-only" submission.
        // You only need to complete this method.
        Node node = head;
        if(position==0){
            node = new Node();
            node.data = data;
            node.next = head;
            return node;
        } else{
            while(--position>0){
                node= node.next;

            }

            Node i = node.next;
            node.next = new Node();
            node.next.data = data;
            node.next.next = i;
            return head;
        }

    }

    public static void AddNode(Node head, int Data)
    {
        if(head==null)
        {
            head= new Node();
            head.data = Data;
        }
        else
        {
            Node temp = head;
            while(temp.next!=null)
            {
                if(temp.data== Data)
                    return;
                temp=temp.next;

            }

            if(temp.data== Data)
                return;
            temp.next=new Node();
            temp.next.data = Data;

        }
    }

    public static void main(String[] args) {
        int[] arr = {1,3,4,5,3,2,7,1,78};
        Node Head = new Node();
        for(int i =0;i<arr.length;i++)
        {
            AddNode(Head,arr[i]);

        }
    }


}
