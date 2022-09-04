public class LengthOfLastWord {

    //https://leetcode.com/problems/length-of-last-word/

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("   fly me   to   the moon  "));
    }

    public static int lengthOfLastWord(String s) {
        String[] sArr = s.trim().split(" ");
        return sArr[sArr.length-1].length();
    }
}
