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
    public boolean isSymmetric(TreeNode root) {
        return traverse(root.left, true).equals(traverse(root.right, false));
    }

    public String traverse(TreeNode root, boolean left) {
        if (root == null) {
            return " ";
        }
        String result = "";
        if (left) {
            result += traverse(root.left,true);
            result += traverse(root.right, false);
        } else {
            result += traverse(root.right, false);
            result += traverse(root.left,true);
        }
        result  +=  root.val;
        return result;
    }
}