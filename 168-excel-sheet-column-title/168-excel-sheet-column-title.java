class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            result.insert(0, (char) ((columnNumber % 26) + 65));
            columnNumber /= 26;
        }

        return result.toString();
    }
}