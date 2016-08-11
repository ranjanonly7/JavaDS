package LinkedInQuestions.Trees;

import java.util.Scanner;

/*
input
17
2 3
4 5
6 -1
-1 7
8 9
10 11
12 13
-1 14
-1 -1
15 -1
16 17
-1 -1
-1 -1
-1 -1
-1 -1
-1 -1
-1 -1
2
2
3
o/p

14 8 5 9 2 4 13 7 12 1 3 10 15 6 17 11 16
9 5 14 8 2 13 7 12 4 1 3 17 11 16 6 10 15

Test Case #00: As node 2 and 3 has no child, swapping will not have any effect on it.
We only have to swap the child nodes of root node.

    1   [s]       1    [s]       1
   / \      ->   / \        ->  / \
  2   3 [s]     3   2  [s]     2   3
Test Case #01: Swapping child nodes of node 2 and 3 we get

    1                  1
   / \                / \
  2   3   [s]  ->    2   3
   \   \            /   /
    4   5          4   5
Test Case #02: Here we perform swap operations at the nodes whose depth is either 2 and 4 and then at nodes whose depth is 4.

         1                     1                          1
        / \                   / \                        / \
       /   \                 /   \                      /   \
      2     3    [s]        2     3                    2     3
     /      /                \     \                    \     \
    /      /                  \     \                    \     \
   4      5          ->        4     5          ->        4     5
  /      / \                  /     / \                  /     / \
 /      /   \                /     /   \                /     /   \
6      7     8   [s]        6     7     8   [s]        6     7     8
 \          / \            /           / \              \         / \
  \        /   \          /           /   \              \       /   \
   9      10   11        9           11   10              9     10   11
 */
public class SwapNodesHackerRank {


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        final int N = s.nextInt();
        int[][] leafs = new int[N][2];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2; j++) {
                leafs[i][j] = s.nextInt();
            }
        }

        int[] depths = new int[s.nextInt()];

        for (int i = 0; i < depths.length; i++) {
            depths[i] = s.nextInt();
        }

        TreeNode leftTree = (leafs[0][0] > -1) ? new TreeNode(leafs[0][0]) : null;
        TreeNode rightTree = (leafs[0][1] > -1) ? new TreeNode(leafs[0][1]) : null;

        if (leafs[0][0] > -1) leftTree.mapChildNodes(leftTree, leafs, (leafs[0][0] > -1) ? 1 : 2, 0, N);
        if (leafs[0][1] > -1) rightTree.mapChildNodes(rightTree, leafs, (leafs[0][0] > -1) ? 2 : 1, 0, N);

        TreeNode mainTree = new TreeNode(1, leftTree, rightTree);

        for(int d : depths) {
            mainTree.swap(mainTree, d, 1);
            mainTree.inorder(mainTree);
            System.out.println();
        }
    }
}

/* Revised Solution
import java.util.Scanner;

public class Solution {
    public static final int ROOT_NODE = 1;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        final int N = s.nextInt();
        int[][] tree = new int[N+ROOT_NODE][2];

        for (int i = ROOT_NODE; i < N+ROOT_NODE; i++) {
            for (int j = 0; j < 2; j++) {
                tree[i][j] = s.nextInt();
            }
        }

        int numDepths = s.nextInt();
        for (int i = 0; i < numDepths; i++) {
            swap(tree, ROOT_NODE, s.nextInt(), 1);
            System.out.println();
        }
    }

    public static void swap(int [][] tree, int node, int targetDepth,
            int depth) {
        if(node == -1) return;

        if(depth % targetDepth == 0) {
            int temp = tree[node][0];
            tree[node][0] = tree[node][1];
            tree[node][1] = temp;
        }
        swap(tree, tree[node][0], targetDepth, depth+1);
        System.out.print(Integer.toString(node) + " ");
        swap(tree, tree[node][1], targetDepth, depth+1);
    }
}
 */