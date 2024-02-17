import java.util.ArrayList;
import java.util.List;
public class queensSafePosition {
    public boolean isSafe(int row, int col, char[][] board) {
        //horizontal
        for(int j=0; j<board.length; j++) {
            if(board[row][j] == 'Q') {
                return false;
            }
        }
       
        //vertical
        for(int i=0; i<board.length; i++) {
            if(board[i][col] == 'Q') {
                return false;
            }
        }
       
        //upper left
        int r = row;
        for(int c=col; c>=0 && r>=0; c--, r--) {
            if(board[r][c] == 'Q') {
                return false;
            }
        }
       
        //upper right
        r = row;
        for(int c=col; c<board.length && r>=0; r--, c++) {
            if(board[r][c] == 'Q') {
                return false;
            }
        }
       
        //lower left
        r = row;
        for(int c=col; c>=0 && r<board.length; r++, c--) {
            if(board[r][c] == 'Q') {
                return false;
            }
        }
       
        //lower right
        for(int c=col; c<board.length && r<board.length; c++, r++) {
            if(board[r][c] == 'Q') {
                return false;
            }
        }
       
        return true;
    }
   
    public void saveBoard(char[][] board, List<List<String>> allBoards) {
        String row = "";
        List<String> newBoard = new ArrayList<>();
       
        for(int i=0; i<board.length; i++) {
            row = "";
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j] == 'Q')
                    row += 'Q';
                else
                    row += '.';
            }
            newBoard.add(row);
        }
       
        allBoards.add(newBoard);
    }
   
    public void helper(char[][] board, List<List<String>> allBoards, int col) {
        if(col == board.length) {
            saveBoard(board, allBoards);
            return;
        }
       
        for(int row=0; row<board.length; row++) {
            if(isSafe(row, col, board)) {
                board[row][col] = 'Q';
                helper(board, allBoards, col+1);
                board[row][col] = '.';
            }
        }
    }
   
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> allBoards = new ArrayList<>();
        char[][] board = new char[n][n];
       
        helper(board, allBoards, 0);
        return allBoards;
    }

    public static void main(String[] args) {
        
    }
 }
 







/* 

import java.util.ArrayList;
import java.util.List;

public class queensSafePosition {
    public boolean isSafe(int row, int col, char[][] board) {
        // Horizontal Line Check
        for (int j = 0; j < board.length; j++) {
            if (board[row][j] == 'Q') {
                return false;
            }
        }

        // Vertical Line Check
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Upper Left
        int r = row;
        for (int c = col; c >= 0 && r >= 0; c--, r--) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }

        // Upper Right
        for (int c = col; c < board.length && r >= 0; r--, c++) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }

        // Lower Left
        for (int c = col; c >= 0 && r < board.length; r++, c--) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }

        // Lower Right
        for (int c = col; c < board.length && r < board.length; c++, r++) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public void saveBoard(char[][] board, List<List<String>> allBoards) {
        List<String> newBoard = new ArrayList<>();

        for (char[] row : board) {
            StringBuilder sb = new StringBuilder();
            for (char c : row) {
                sb.append(c);
            }
            newBoard.add(sb.toString());
        }
        allBoards.add(newBoard);
    }

    public void helper(char[][] board, List<List<String>> allBoards, int col) {
        if (col == board.length) {
            saveBoard(board, allBoards);
            return;
        }
        for (int row = 0; row < board.length; row++) {
            if (isSafe(row, col, board)) {
                board[row][col] = 'Q';
                helper(board, allBoards, col + 1);
                board[row][col] = '.';
            }
        }
    }

    public List<List<String>> safePositions(int n) {
        List<List<String>> allBoards = new ArrayList<>();
        char[][] board = new char[n][n];

        // Initialize the board with empty cells
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        helper(board, allBoards, 0);

        return allBoards;
    }

    public static void main(String[] args) {
        int n = 4; // Change the value of n as needed
        queensSafePosition queensSafePosition = new queensSafePosition();
        List<List<String>> allBoards = queensSafePosition.safePositions(n);
        for (List<String> board : allBoards) {
            for (String row : board) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}

*/



/*
import java.util.ArrayList;
import java.util.List;

public class queensSafePosition {
    public boolean isSafe(int row, int col, char[][] board) {
        // Horizontal Line Check
        for (int j = 0; j < board.length; j++) {
            if (board[row][j] == 'Q') {
                return false;
            }
        }

        // Vertical Line Check
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Upper Left
        for (int r = row, c = col; r >= 0 && c >= 0; r--, c--) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }

        // Upper Right
        for (int r = row, c = col; r >= 0 && c < board.length; r--, c++) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }

        // Lower Left
        for (int r = row, c = col; r < board.length && c >= 0; r++, c--) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }

        // Lower Right
        for (int r = row, c = col; r < board.length && c < board.length; r++, c++) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public void saveBoard(char[][] board, List<List<String>> allBoard) {
        List<String> newBoard = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < board[0].length; j++) {
                row.append(board[i][j]);
            }
            newBoard.add(row.toString());
        }
        allBoard.add(newBoard);
    }

    public void helper(char[][] board, List<List<String>> allBoard, int col) {
        if (col == board.length) {
            saveBoard(board, allBoard);
            return;
        }
        for (int row = 0; row < board.length; row++) {
            if (isSafe(row, col, board)) {
                board[row][col] = 'Q';
                helper(board, allBoard, col + 1);
                board[row][col] = '.';
            }
        }
    }

    public List<List<String>> safePosition(int n) {
        List<List<String>> allBoard = new ArrayList<>();
        char[][] board = new char[n][n];

        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        helper(board, allBoard, 0);

        return allBoard;
    }
}

*/




/*
import java.util.*;
public class queensSafePosition {
    public boolean isSafe(int row, int col, char[][] board) {
        // Horizontal Line Check
        for(int j = 0; j < board.length; j++) {
            if(board[row][j] == 'Q') {
                return false;
            }
        }

        // Vertical Line Check
        for(int i = 0; i < board.length; i++) {
            if(board[i][col] == 'Q') {
                return false;
            }
        }

        // Upper Left
        int r = row;
        for(int c = col; c >= 0 && r >= 0; c--, r--) {
            if(board[r][c] == 'Q') {
                return false;
            }
        }

        // Upper Right
        for(int c = col; c < board.length && r >= 0; r--, c++) {
            if(board[r][c] == 'Q') {
                return false;
            }
        }

        // Lower Left
        for(int c = col; c >= 0 && r < board.length; r++, c--) {
            if(board[r][c] == 'Q') {
                return false;
            }
        }

        // Lower Right
        for(int c = col; c < board.length && r > board.length; c++, r++) {
            if(board[r][c] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public void saveBorad(char[][] board, List<List<String>> allBoard) {
        String row = "";
        List<String> newBoard = new ArrayList<>();

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 'Q') {
                    row += 'Q';
                }else {
                    row += '.';
                }
            }
            newBoard.add();
        }
        allBoard.add(newBoard);
    }

    public void helper(char[][] board, List<List<String>> allBoard, int col) {
        if(col == board.length) {
            saveBorad(board, allBoard);
            return;
        }
        for(int row = 0; row < board.length; row++) {
            if(isSafe(row, col, board)) {
                board[row][col] = 'Q';
                helper(board, null, col + 1);
                board[row][col] = '.';
            }
        }
    }
    
    public List<List<String>> safePosition(int n) {
        List<List<String>> allBoard = new ArrayList<>();
        char[][] board = new board[][];

        helper(board, null, 0);

        return allBoard;
    }
}

 */