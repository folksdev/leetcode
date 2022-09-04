public class DivideTwoIntegers {

    //https://leetcode.com/problems/divide-two-integers/
    /*
            10 / 3 = 10 - 3 = 7  +1
            7 - 3 = 4            +1
            4 - 3 = 1            +1
            1 - 3 = -2           0
            3 = 111
            */

    public static void main(String[] args) {

        System.out.println(divide(Integer.MIN_VALUE, -1)); //2147483647 +1  - 2147483647
        System.out.println(divide(-10, 10));

    }

    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if (dividend == Integer.MIN_VALUE && divisor == 1) return Integer.MIN_VALUE;
        if (dividend == divisor) return 1;
        if (divisor == 1) return dividend;
        if (divisor == -1) return -dividend;

        int sign = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0) ? -1 : 1;

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        if (dividend == divisor) return -1;
        int result = 0;
        while ((dividend - divisor) >= 0) {
            result++;
            dividend = dividend - divisor;
        }

        return sign < 0 ? -result : result;
    }
}
