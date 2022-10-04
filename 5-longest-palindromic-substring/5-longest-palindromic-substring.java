class Solution {
    public String longestPalindrome(String s) {
        if (s.length() <= 1 || isPalindrome(s)) {
            return s;
        }
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            String substring = s.substring(i);
            for (int j = substring.length(); j >= 0; j--){
                substring = substring.substring(0,j);
                if (isPalindrome(substring)){
                    if (substring.length() > result.length()) {
                        result = substring;
                    }
                }
            }
        }
        return result;
    }

    public static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}