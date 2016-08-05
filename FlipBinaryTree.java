package LinkedList;

import java.util.Queue;

/**
 * Created by rmukherj on 7/30/16.
 */
public class FlipBinaryTree {

    static class BinaryTree{
        int data;
        BinaryTree left, right;

        public BinaryTree(int d){
            this.data = d;
            this.left = null;
            this.right = null;
        }
    }

    /*
    1. Recursively traverse to the leftmost node.
    2. This becomes the NewRoot, and keep returning this value, up the chain.
    3. Make the following changes
        - CurrentRoot. Left.Left = CurrentRoot.Right
        - CurrentRoot.Left.Right = CurrentRoot
        - CurrentRoot.Left = CurrentRoot.Right = NULL
     */

    BinaryTree flipTree(BinaryTree root){
        if(root == null){
            return null;

        }

        if(root.left == null && root.right == null){
            return root;
        }

        BinaryTree newRoot = flipTree(root.left);
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        return newRoot;
    }

    //book solution



//    public static BinaryTree flippityFlip(BinaryTree n) {
//
//        if(n == null) {
//            return n;
//        }
//
//        Stack<BinaryTree> S = new Stack<BinaryTree>();
//        // push all left nodes into stack.
//        while(n != null) {
//            S.push(n);
//            n = n.left;
//        }
//
//        BinaryTree root = S.peek();
//        while(!S.isEmpty()) {
//            flip(S.pop(), S.peek());
//        }
//        return root;
//    }
//
//    // takes node and its parent, and flips the node.
//    private static void flip(BinaryTree n, BinaryTree p) {
//        if(p==null) {
//            n.left = null;
//            n.right = null;
//        } else {
//            n.left = p.right;
//            n.right = p;
//        }
//    }

    public void levelOrderNaiveApproach(BinaryTree root){
        int h = height(root);
        for(int i=1;i<=h;i++){
            printLevels(root,i);
            System.out.println("");
        }
    }
    public void printLevels(BinaryTree root, int h){
        if(root==null) return;
        if(h==1) System.out.print(" " + root.data);
        else{
            printLevels(root.left,h-1);
            printLevels(root.right,h-1);
        }
    }
    public int height(BinaryTree root){
        if (root==null) return 0;
        return 1 + Math.max(height(root.left),height(root.right));
    }

    public void levelOrderQueue(BinaryTree root){
        Queue q = (Queue) new LinkedList();
        int levelNodes =0;
        if(root==null) return;
        q.add(root);
        while(!q.isEmpty()){
            levelNodes = q.size();
            while(levelNodes>0){
                BinaryTree n = (BinaryTree)q.remove();
                System.out.print(" " + n.data);
                if(n.left!=null) q.add(n.left);
                if(n.right!=null) q.add(n.right);
                levelNodes--;
            }
            System.out.println("");
        }
    }

    public static BinaryTree Reverse(BinaryTree root){
        if(root == null){
            return null;
        }

        BinaryTree temp = root.left;
        root.left = Reverse(root.right);
        root.right = Reverse(temp);
        return root;
    }

    public static void main(String[] args){
//        BinaryTree tree = new BinaryTree(5);
//        tree.left = new BinaryTree(10);
//        tree.right = new BinaryTree(15);
//        tree.left.left = new BinaryTree(20);
//        tree.left.right = new BinaryTree(25);
//        tree.right.left = new BinaryTree(30);
//        tree.right.right = new BinaryTree(35);
        BinaryTree tree = new BinaryTree(1);
        tree.left = new BinaryTree(2);
        tree.right = new BinaryTree(3);
        tree.left.left = new BinaryTree(4);
        tree.left.right = new BinaryTree(5);
       // tree.right.left = new BinaryTree(30);
       // tree.right.right = new BinaryTree(35);
        tree.left.left.left = new BinaryTree(6);
        tree.left.left.right = new BinaryTree(7);

        FlipBinaryTree bt = new FlipBinaryTree();
        bt.levelOrderNaiveApproach(tree);
        tree = Reverse(tree);
      //  tree = bt.flipTree(tree);
        //tree = inverse(tree);
       // tree = flippityFlip(tree);
        bt.levelOrderNaiveApproach(tree);

    }



}
