package tryingsomething;

/**
 * Created by rmukherj on 7/27/16.
 */
public class DoublyLinkedList {

    public static class Node {
        public int data;
        public Node next;
        public Node prev;

        public Node(int d){
            this.data = d;
            this.next = null;
            this.prev = null;
        }

        public Node(Node prev, Node next, int data){
            this.prev = prev == null ? this: prev;
            this.next = next == null ? this: next;
            this.data = data;
        }

        public void displayNode() {
            System.out.print(data + " ");
        }
    }

    public Node Insert(Node head, int data){
        if(null == head){
            return new Node(data);
        }

        Node insertion = new Node(head.prev, head, data);
        insertion.prev.next = insertion;
        insertion.next.prev = insertion;
        return insertion;
    }

    public Node Find(Node head, int data){
        Node current = head;
        while(null !=current && current.data!=data){
            current= current.next;
            if(current.data== head.data){
                return null;
            }
        }

        return current;
    }

    public Node Delete(Node head, Node target){
        if(head!=null && head.next== head && head == target){
            return null;
        }

        target.prev.next = target.next;
        target.next.prev = target.prev;

        if(head == target){
            head = target.next;
        }

        return head;
    }

    public static void main(String[] args){
        DoublyLinkedList dll = new DoublyLinkedList();
        DoublyLinkedList.Node n = new Node(12);
        dll.Insert(n,23);
        dll.Insert(new Node(36),21);


    }
}
