import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    //https://leetcode.com/problems/valid-parentheses/

    public static void main(String[] args) {
        System.out.println(isValid("({[]}){"));
    }

    public static boolean isValid(String s) {
        if (s == null || s.isEmpty() || s.length() % 2 != 0) {
            return false;
        }
        Map<Character, Character> map = Map.of(
                '(', ')',
                '[', ']',
                '{', '}'
        );

        Map<Character, Character> map1 = Map.of(
                ')', '(',
                ']', '[',
                '}', '{'
        );

        Stack<Character> cStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (map.containsKey(current)) {
                cStack.push(current);
            } else {
                if (cStack.isEmpty())
                    return false;
                else if (map1.get(current) == cStack.peek() && map.get(cStack.peek()) == current) {
                    cStack.pop();
                } else
                    break;
            }
        }

        return cStack.isEmpty();
    }

}
