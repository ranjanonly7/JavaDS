package LinkedInQuestions.Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by rmukherj on 8/9/16.
 */
public class TopViewTree {
    class Node {
        int data;
        Node left;
        Node right;
    }

    void top_view(Node root)
    {
        if(root.left!=null) top_view(root.left);

        if(root.left!=null || root.right!=null)
            System.out.print(root.data + " ");

        if(root.right!=null) top_view(root.right);
    }

    //Iterative
    void topview(Node root)
    {
        if(root==null)
            return;
        Stack<Integer> s=new Stack<Integer>();
        s.push(root.data);
        Node root2=root;
        while(root.left!=null)
        {
            s.push(root.left.data);
            root=root.left;
        }
        while(s.size()!=0)
            System.out.print(s.pop()+" ");

        Queue<Integer> q=new LinkedList<Integer>();
        q.add(root2.right.data);
        root2=root2.right;
        while(root2.right!=null)
        {
            q.add(root2.right.data);
            root2=root2.right;
        }
        while(q.size()!=0)
            System.out.print(q.poll()+" ");
    }
}
