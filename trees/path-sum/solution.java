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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        // Root must be a leaf
        if (root.left == null && root.right == null && root.val == targetSum) return true;
        boolean leftSumExists = false;
        boolean rightSumExists = false;
        if (root.left != null) leftSumExists = hasPathSum(root.left, targetSum - root.val);
        if (root.right != null) rightSumExists = hasPathSum(root.right, targetSum - root.val);
        return leftSumExists || rightSumExists;
    }
}