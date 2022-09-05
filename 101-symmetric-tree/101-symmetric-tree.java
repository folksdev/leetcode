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
        List<Integer> left = traverse(root.left, true);
        List<Integer> right = traverse(root.right, false);
        return left.equals(right);
    }

    public static List<Integer> traverse(TreeNode root, boolean left) {
        if (root == null) {
            return List.of(0);
        }
        List<Integer> result = new ArrayList<>();
        if (left) {
            result.addAll(traverse(root.left,true));
            result.addAll(traverse(root.right, false));
        } else {
            result.addAll(traverse(root.right, false));
            result.addAll(traverse(root.left,true));
        }
        result.add(root.val);
        return result;
    }
}