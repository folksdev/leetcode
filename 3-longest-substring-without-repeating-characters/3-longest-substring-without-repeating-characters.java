class Solution {
    public static int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() < 1){
            return 0;
        }
        int a_ptr = 0;
        int max = 0;

        Set<Character> set = new HashSet();


        for (int b_ptr = 0; b_ptr < s.length(); b_ptr++){
            if (!set.contains(s.charAt(b_ptr))){
                set.add(s.charAt(b_ptr));

            }else{
                while (set.contains(s.charAt(b_ptr))){
                    set.remove(s.charAt(a_ptr));
                    a_ptr++;
                }
                set.add(s.charAt(b_ptr));
            }
            max = Math.max(b_ptr - a_ptr + 1, max);

        }
        return max;
    }
}