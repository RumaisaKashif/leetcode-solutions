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
    // Global pointer to current root index because preorder array places roots sequentially
    int preorderPos = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Number to index map for elements in the inorder array
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) { 
            indexMap.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, inorder, 0, inorder.length - 1, indexMap);
    }

    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int start, int end,
    Map<Integer, Integer> indexMap) {
        // Empty portion of inorder array - return null
        if (start > end) return null;
        // Get root value
        int rootVal = preorder[preorderPos++];
        // Get root index in inorder array
        int rootInorderIndex = indexMap.get(rootVal);
        
        // Recursively: 
        // Build left subtree from everything on left hand side of the root
        TreeNode left = buildTreeHelper(preorder, inorder, start, rootInorderIndex - 1,
        indexMap);
        // Build right subtree from everything on right hand side of the root      
        TreeNode right = buildTreeHelper(preorder, inorder, rootInorderIndex + 1, end,
        indexMap);

        TreeNode root = new TreeNode(rootVal);
        root.left = left;
        root.right = right;
        return root;
    }
}