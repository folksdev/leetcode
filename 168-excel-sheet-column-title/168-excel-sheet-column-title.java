class Solution {
    public String convertToTitle(int columnNumber) { //%100 fast
        StringBuilder result = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            result.insert(0, (char) ((columnNumber % 26) + 65));
            columnNumber /= 26;
        }

        return result.toString();
    }
    
    public static String convertToTitle2(int columnNumber) { //%20 fast - alternative
        return new StringBuilder(recursive(columnNumber)).reverse().toString();
    }

    public static String recursive(int columnNumber) {
        if (columnNumber == 0) {
            return "";
        }
            columnNumber--;
        return (char) ((columnNumber % 26) + 65) +
                recursive(columnNumber / 26);
    }
}