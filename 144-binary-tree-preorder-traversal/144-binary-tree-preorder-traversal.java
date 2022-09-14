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
    public List<Integer> preorderTraversal(TreeNode root) {
        return traverse(root);
    }
    
    public List<Integer> traverse(TreeNode root) {
        if (root == null) {
            return List.of();
        }
        
        List<Integer> result = new ArrayList<>();
        result.add(root.val);
        result.addAll(traverse(root.left));
        result.addAll(traverse(root.right));
        
        return result;
    }
}