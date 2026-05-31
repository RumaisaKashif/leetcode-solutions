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
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode node, Integer lower, Integer upper) {
        if (node == null) return true;

        int val = node.val;
        // All values in right st must be > lower bound (root)
        if (lower != null && val <= lower) return false;
        if (upper != null && val >= upper) return false;
        // For the right subtree, the curr node val = lower bound
        boolean validRight = isValidBST(node.right, val, upper);
        // For the left subtree, the curr node val = upper bound
        boolean validLeft = isValidBST(node.left, lower, val);

        return validRight && validLeft;
    }
}
