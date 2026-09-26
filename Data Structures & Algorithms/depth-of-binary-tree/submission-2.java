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
        maxDepth = 0;

        if(root == null)
            return maxDepth;

        Stack<Pair<TreeNode,Integer>> stack = new Stack<>();
        stack.push(new Pair(root,1));

        while(!stack.isEmpty()){
            Pair<TreeNode, Integer> pair = stack.pop();
            maxDepth = Math.max(maxDepth, pair.getValue());

            if (pair.getKey().left != null)
                stack.push(new Pair(pair.getKey().left, pair.getValue() + 1));
            if (pair.getKey().right != null)
                stack.push(new Pair(pair.getKey().right, pair.getValue() + 1));

        }
        return maxDepth;
    }

}
