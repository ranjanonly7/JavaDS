package LinkedInQuestions.Trees;

/**
 * Created by rmukherj on 8/9/16.
 * Running code HackerRank.
 */
public class LowestCommonAncestor {


    static Node lca(Node root,int v1,int v2)
    {
        if(root == null){
            return root;
        }

        Node left, right;
        if(root.data == v1 || root.data == v2){
            return root;
        }

        left = lca(root.left, v1, v2);
        right = lca(root.right, v1, v2);
        if(left!=null && right !=null){
            return root;
        } else
            return (left !=null ? left : right);


    }


    public void levelOrderNaiveApproach(Node root){
        int h = height(root);
        for(int i=1;i<=h;i++){
            printLevels(root,i);
            System.out.println("");
        }
    }
    public void printLevels(Node root, int h){
        if(root==null) return;
        if(h==1) System.out.print(" " + root.data);
        else{
            printLevels(root.left,h-1);
            printLevels(root.right,h-1);
        }
    }
    public int height(Node root){
        if (root==null) return 0;
        return 1 + Math.max(height(root.left),height(root.right));
    }

    public static void main(String[] args) {
//        Scanner s = new Scanner(System.in);
//        int size = s.nextInt();
//        s.nextLine();
//        int a[] = new int[size];
//        for(int i=0;i<size;i++){
//            a[i]= s.nextInt();
//        }

        Node tree = new Node(4);
        tree.left = new Node(2);
        tree.right = new Node(7);
        tree.left.left = new Node(1);
        tree.left.right = new Node(3);
        // tree.right.left = new BinaryTree(30);
        // tree.right.right = new BinaryTree(35);
        tree.right.left = new Node(6);


        int v1 = 1;
        int v2 = 7;

        Node vc = lca(tree, v1, v2);
        LowestCommonAncestor bt = new LowestCommonAncestor();
        bt.levelOrderNaiveApproach(vc);



    }
}
