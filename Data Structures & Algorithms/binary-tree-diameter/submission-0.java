/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int diameter;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

        diamaterUtil(root);
        return diameter;
    }
    int diamaterUtil(TreeNode node){
        if(node == null)
            return 0;

        int leftDepth = diamaterUtil(node.left);
        int rightDepth = diamaterUtil(node.right);

        diameter = Math.max(diameter, leftDepth  + rightDepth);

        return 1 + Math.max(leftDepth, rightDepth);

    }
}
