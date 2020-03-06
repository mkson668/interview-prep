import java.util.*;

class SudokuValidCheck {
    public static void main(String[] args) {
        String[][] board = new String[][]{
        {"1","3",".",".","7",".",".",".","."},
        {"6",".",".","1","9","5",".",".","."},
        {".","9","8",".",".",".",".","6","."},
        {"8",".",".",".","6",".",".",".","3"},
        {"4",".",".","8",".","3",".",".","1"},
        {"7",".",".",".","2",".",".",".","6"},
        {".","6",".",".",".",".","2","8","."},
        {".",".",".","4","1","9",".",".","5"},
        {".",".",".",".","8",".",".","7","5"}};
        boolean valid = isValidSudoku(board);
        System.out.println(valid);
        }

    public static boolean isValidSudoku(String[][] board) {
        boolean validSoFar = true;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                String c = board[i][j];
                if (c.equals(".")) {
                    // this should always be continue
                    continue;
                } else {
                    // check 3x3 and col row for each number
                    boolean validSec = checkSector(board, i, j);
                    boolean validRow = checkRow(board, i, j);
                    boolean validCol = checkCol(board, i, j);
                    if (validSec && validRow && validCol) {
                        continue;
                    } else {
                        validSoFar = false;
                    }
                }
            }
        }
        return validSoFar;
    }

    public static boolean checkSector(String[][] board, int row, int col) {
        int minCol;
        int maxCol;
        int minRow;
        int maxRow;

        // this should be the same stupid repeat code
        if (col <= 2 && col >= 0) {
            minCol = 0;
            maxCol = 2;
        } else if (col <= 5 && col >= 3) {
            minCol = 3;
            maxCol = 5;
        } else {
            minCol = 6;
            maxCol = 8;
        }

        if (row <= 2 && row >= 0) {
            minRow = 0;
            maxRow = 2;
        } else if (row <= 5 && row >= 3) {
            minRow  = 3;
            maxRow = 5;
        } else {
            minRow  = 6;
            maxRow = 8;
        }

        Set<String> charSet = new HashSet<>();
        for (int i = minCol; i <= maxCol; i++) {
            for (int j = minRow; j <= maxRow; j++) {
                String c = board[i][j];
                if (c.equals(".")) {
                    continue;
                } else if (charSet.contains(c)) {
                    return false;
                } else {
                    charSet.add(c);
                }
            }
        }
        return true;
    }

    public static boolean checkRow(String[][] board, int row, int col) {
        Set<String> st = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            String c = board[row][i];
            if (c.equals(".")) {
                continue;
            } else if (st.contains(c)) {
                return false;
            } else {
                st.add(c);
            }
        }
        return true;
    }

    public static boolean checkCol(String[][] board, int row, int col) {
        Set<String> st = new HashSet<>(); 
        for (int i = 0; i < board.length; i++) {
            String c = board[i][col];
            if (c.equals(".")) {
                continue;
            } else if (st.contains(c)) {
                return false;
            } else {
                st.add(c);
            }
        }
        return true;
    }

    public static boolean checkSudokuOptimal(char[][] board) {
        Set<String> st = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != '.') {
                    String charStr = "(" + board[i][j] + ")";
                    if (!st.add(i + charStr) || !st.add(charStr + j) || !st.add(i/3 + charStr + j/3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}