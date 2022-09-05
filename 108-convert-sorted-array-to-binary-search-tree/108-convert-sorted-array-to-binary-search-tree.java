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
    public TreeNode sortedArrayToBST(int[] nums) {
        return toBST(nums, 0, nums.length - 1);
    }

    public TreeNode toBST(int nums[], int left, int right) {
        if (left == right) return new TreeNode(nums[left]);
        else if (left > right) return null;
        else {
            int mid = (left + right) / 2;
            TreeNode curr = new TreeNode(nums[mid]);
            curr.left = toBST(nums, left, mid - 1);
            curr.right = toBST(nums, mid + 1, right);
            return curr;
        }
    }
}