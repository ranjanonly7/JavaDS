package LinkedList;

public class LinkedListIsPalindrome {

    public boolean isPalindrome(Nodel head){
        if(head == null){
            return true;
        }

        Nodel p = head;
        Nodel prev = new Nodel(head.data);

        while (p.next!=null){
            Nodel temp = new Nodel(p.next.data);
            temp.next = prev;
            prev = temp;
            p= p.next;
        }

        Nodel p1 = head;
        Nodel p2 = prev;

        while(p1!=null){
            if(p1.data !=p2.data){
                return false;
            }

            p1= p1.next;
            p2 = p2.next;

        }

        return true;
    }

    public boolean isPalindromeSlowFast(Nodel head){
        if(head == null || head.next == null){
            return true;
        }

        Nodel fast = head;
        Nodel slow = head;

        while(fast.next !=null && fast.next.next !=null){
            fast = fast.next.next;
            slow = slow.next;
        }

        Nodel secondHead = slow.next;
        slow.next = null;

        Nodel p1 = secondHead;
        Nodel p2 = p1.next;

        while(p1!=null && p2!=null){
            Nodel temp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = temp;
        }

        secondHead.next = null;

        //compare two sublists now
        Nodel p = (p2==null?p1:p2);
        Nodel q = head;
        while(p!=null){
            if(p.data != q.data)
                return false;

            p = p.next;
            q = q.next;

        }

        return true;

    }

    public static void main(String[] args) {
       LinkedListIsPalindrome lp = new LinkedListIsPalindrome();
        Nodel head;
        head = new Nodel(1);
        head.next = new Nodel(4);
        head.next.next = new Nodel(4);
        head.next.next.next = new Nodel(2);
        boolean isValid = lp.isPalindrome(head);
        System.out.println(isValid);

    }
}
