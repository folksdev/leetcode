import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PlusOne {

    //https://leetcode.com/problems/plus-one/

    public static void main(String[] args) {

        int[] a = plusOne(new int[]{9,9});

         for (int i: a) {
             System.out.print(i);
         }

    }

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length-1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i] = digits[i] + 1;
                break;
            }
        }
        if (digits[0] == 0) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            return result;
        }
        return digits;
    }
}
