class Solution {
    public String convertToTitle(int columnNumber) {
        if (columnNumber <= 26) {
            return String.valueOf((char) (columnNumber + 64));
        }
        String result = "";
        while (columnNumber > 0) {
            columnNumber--;
            result = (char) ((columnNumber % 26) + 65) + result;
            columnNumber /= 26;
        }

        return result;
    }
}