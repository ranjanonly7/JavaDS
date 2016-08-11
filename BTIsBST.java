package LinkedInQuestions.Trees;

/**
 * Created by rmukherj on 8/10/16.
 */
public class BTIsBST {

    private boolean isValidBST(Node node, int MIN, int MAX) {
        if(node == null)
            return true;
        if(node.data > MIN
                && node.data < MAX
                && isValidBST(node.left, MIN, node.data)
                && isValidBST(node.right, node.data, MAX))
            return true;
        else
            return false;
    }

    boolean checkBST(Node root) {
        return isValidBST(root, Integer.MIN_VALUE,
                Integer.MAX_VALUE);

    }
}
