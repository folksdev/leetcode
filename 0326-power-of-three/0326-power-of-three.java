class Solution {
    public boolean isPowerOfThree(int num) {
        if (num == 1) {
            return true;
        }
        if (num % 3 != 0 || num == 0) {
            return false;
        }

        return isPowerOfThree(num / 3);
    }
}