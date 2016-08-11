package LinkedInQuestions.Trees;

/**
 * Created by rmukherj on 8/10/16.
 */
class TreeNode {
    private int data;
    private TreeNode left;
    private TreeNode right;

    TreeNode(int data) {
        this.data = data;
    }

    TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    private void insertLeft(int data) {
        if (this.left == null) {
            this.left = new TreeNode(data);
        } else {
            this.left.insertLeft(data);
        }
    }

    private void insertRight(int data) {
        if (this.right == null) {
            this.right = new TreeNode(data);
        } else {
            this.right.insertRight(data);
        }
    }

    public void inorder(TreeNode node) {
        if (node == null) return;

        inorder(node.left);
        System.out.print(node.toString());
        inorder(node.right);
    }

    public void mapChildNodes(TreeNode node, int[][] leafs, int i, int j, int arraySize) {
        if (arraySize == 0) return;

        if (leafs[i][j] > -1) {
            node.insertLeft(leafs[i][j]);
            mapChildNodes(node.left, leafs, leafs[i][j] - 1, 0, arraySize - 1);
        }
        if (leafs[i][j + 1] > -1) {
            node.insertRight(leafs[i][j + 1]);
            mapChildNodes(node.right, leafs, leafs[i][j + 1] - 1, 0, arraySize - 1);
        }
    }

    public void swap(TreeNode node, int targetDepth, int depth) {
        if (node == null) return;

        if (depth % targetDepth == 0) {
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
        swap(node.left, targetDepth, depth + 1);
        swap(node.right, targetDepth, depth + 1);

    }

    @Override
    public String toString() {
        return this.data + " ";
    }
}