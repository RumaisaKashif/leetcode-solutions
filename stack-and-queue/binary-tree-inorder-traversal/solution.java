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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderHelper(root, result);
        return result;
    }
    
    // Recursive approach
    private void inorderHelper(TreeNode root, List<Integer> result) { 
        if (root == null) return;
        // Recurse left
        inorderHelper(root.left, result);
        // Add root
        result.add(root.val);
        // Recurse right
        inorderHelper(root.right, result);
    }
}