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
    int maxDepth;
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
            
        maxDepthUtil(root, 0);
        return maxDepth + 1;
    }

    void maxDepthUtil(TreeNode root, int depth){
        maxDepth = Math.max(maxDepth, depth);

        if(root == null || (root.left == null && root.right == null))
            return;

        maxDepth = Math.max(maxDepth, depth);
        maxDepthUtil(root.left, depth+1);
        maxDepthUtil(root.right, depth+1);
        
        
    }
}
