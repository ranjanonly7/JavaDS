package LinkedInQuestions.Trees;

/**
 * Created by rmukherj on 8/9/16.
 * The problem lies in your base case.
 * "The height of a tree is the length of the path from the root to the deepest node
 * in the tree. A (rooted) tree with only a node (the root) has a height of zero.
 * " - Wikipedia If there is no node you want to return -1 not 0 because you are
 * adding 1 at the end so if there isn't a node you return -1 which cancels out the +1.
 */
public class HeightOfBinaryTree {
    public class Node {
        int data;
       Node left;
       Node right;
    }

    int height(Node root)
    {
        if(root == null){
            return -1;
        } else{
            return 1+(Math.max(height(root.left),height(root.right)));
        }

    }
}
