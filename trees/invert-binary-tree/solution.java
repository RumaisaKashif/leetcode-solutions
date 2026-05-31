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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        // Recursively invert the left anfd right trees first
        TreeNode leftInverted = invertTree(root.left);
        TreeNode rightInverted = invertTree(root.right);

        // Swap left and right trees (inverted versions)
        root.left = rightInverted;
        root.right = leftInverted;

        return root;
    }
}