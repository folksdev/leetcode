import java.math.BigDecimal;
import java.math.MathContext;


class Solution {
    public boolean checkPowersOfThree(int n) {
        return checkPowersOfThree(n, new ArrayList<>());
    }
    
    public static boolean checkPowersOfThree(int n, List<Integer> check) {
        if (n == 1 || n == 0) {
            return true;
        }
        if (n == 2 || n < 0) {
            return false;
        }
        int x = BigDecimal.valueOf(Math.log(n) / Math.log(3)).round(MathContext.DECIMAL32).intValue();
        int pow = (int) (Math.pow(3, x));
        if (check.contains(pow)){
            return false;
        } else {
            check.add(pow);
        }
        return checkPowersOfThree(n - pow, check);
    }
}