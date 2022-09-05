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
        return traverse(root.left, root.right);
    }

    public boolean traverse(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return (p.val == q.val) && traverse(p.left, q.right) && traverse(p.right, q.left);
    }

    //Alternative
    public boolean isSymmetric2(TreeNode root) {
        return traverse2(root.left, true).equals(traverse2(root.right, false));
    }

    public String traverse2(TreeNode root, boolean left) {
        if (root == null) {
            return " ";
        }
        String result = "";
        if (left) {
            result += traverse2(root.left, true);
            result += traverse2(root.right, false);
        } else {
            result += traverse2(root.right, false);
            result += traverse2(root.left, true);
        }
        result += root.val;
        return result;
    }
}