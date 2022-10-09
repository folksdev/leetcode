import java.math.BigDecimal;


class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }
        if (!Character.isDigit(s.charAt(0)) && (s.charAt(0) != '-' && s.charAt(0) != '+')) {
            return 0;
        }
        s = s.replace("[^\\d[-|+]]", "");
        String trimmed = "";
        boolean flag = false;
        boolean digitOccured = false;
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) == '-' || s.charAt(i) == '+') && !digitOccured) {
                if (!flag) {
                    trimmed += s.charAt(i);
                    flag = true;
                } else {
                    return 0;
                }

            } else if (Character.isDigit(s.charAt(i))) {
                digitOccured = true;
                if (trimmed.length() == 0 && s.charAt(i) == '0') {
                    continue;
                }
                trimmed += s.charAt(i);
            } else {
                break;
            }
        }
        if (trimmed.length() == 0) {
            return 0;
        }
        if (trimmed.length() == 1 && (s.charAt(0) == '-' || s.charAt(0) == '+')) {
            return 0;
        }

        BigDecimal result;
        try {
            result = BigDecimal.valueOf(Long.parseLong(trimmed));
        } catch (NumberFormatException e) {
            if (trimmed.charAt(0) == '-') {
                result = BigDecimal.valueOf(Integer.MIN_VALUE);
            } else {
                result = BigDecimal.valueOf(Integer.MAX_VALUE);
            }
        }
        if (result.compareTo(BigDecimal.valueOf(Integer.MAX_VALUE)) > 0) {
            result = BigDecimal.valueOf(Integer.MAX_VALUE);
        } else if (result.compareTo(BigDecimal.valueOf(Integer.MIN_VALUE)) < 0) {
            result = BigDecimal.valueOf(Integer.MIN_VALUE);
        }
        return result.intValue();
    }
}