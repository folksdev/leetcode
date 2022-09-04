import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class PolindromeNumber {

    public static void main(String[] args) {

        System.out.println(isPalindrome2(12112));

    }

    public static boolean isPalindrome(int x) {
        String s = String.valueOf(x);

        List<Character> cArr = new java.util.ArrayList<>(s.chars().mapToObj(e -> (char) e).toList());

        Collections.reverse(cArr);

        return cArr.stream().map(String::valueOf).collect(Collectors.joining()).equals(s);
    }

    public static boolean isPalindrome2(int x) {
        String s = String.valueOf(x);

        Stack<Character> stack = new Stack<>();
        stack.addAll(s.chars().mapToObj(e -> (char) e).toList());

        int i = 0;
        while (!stack.isEmpty()) {
            if (!(stack.pop() == s.charAt(i))) {
                return false;
            }
            i++;
        }

        return true;
    }
}
