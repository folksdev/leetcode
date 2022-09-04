public class SearchInsertPosition {

    //https://leetcode.com/problems/search-insert-position/

    public static void main(String[] args) {

    }

    public int searchInsert(int[] nums, int target) {
        int i = 0;
        for (; i < nums.length; i++) {
            if (nums[i] >= target) {
                break;
            }
        }
        return i;
    }
}
