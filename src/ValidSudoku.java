import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    //https://leetcode.com/problems/valid-sudoku/

    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            Set<Character> charSet = new HashSet<>();
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (charSet.contains(board[i][j])) {
                    return false;
                }
                charSet.add(board[i][j]);
            }
        }

        for (int i = 0; i < board.length; i++) {
            Set<Character> charSet = new HashSet<>();
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] == '.') {
                    continue;
                }
                if (charSet.contains(board[j][i])) {
                    return false;
                }
                charSet.add(board[j][i]);
            }
        }

        for (int i = 0; i < board.length; i = i + 3) {
            for (int j = 0; j < board.length; j = j + 3) {
                Set<Character> charSet = new HashSet<>();
                for (int l = i, count = 0; count < 3; count++, l++) {
                    for (int k = j, cnt = 0; cnt < 3; cnt++, k++) {
                        if (board[l][k] == '.') {
                            continue;
                        }
                        if (charSet.contains(board[l][k])) {
                            return false;
                        }
                        charSet.add(board[l][k]);
                    }
                }

            }
        }
        return true;
    }
}
