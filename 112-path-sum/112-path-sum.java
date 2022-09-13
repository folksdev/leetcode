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

        return reachToSum(root, targetSum);
    }

    public boolean reachToSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        if (targetSum - root.val == 0 && root.left == null && root.right == null) {
            return true;
        }
        
        return reachToSum(root.left, targetSum - root.val) || reachToSum(root.right, targetSum - root.val);
    }
}