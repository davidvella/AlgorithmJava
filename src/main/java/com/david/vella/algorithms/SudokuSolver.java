package com.david.vella.algorithms;

import java.util.ArrayList;

public class SudokuSolver {
    public ArrayList<ArrayList<Integer>> solveSudoku(ArrayList<ArrayList<Integer>> board) {
        doSolve(board, 0, 0);
        return board;
    }

    private boolean doSolve(ArrayList<ArrayList<Integer>> board, int row, int col) {
        for (int i = row; i < 9; i++, col = 0) { // note: must reset col here!
            for (int j = col; j < 9; j++) {
                if (board.get(i).get(j) != 0) continue;
                for (int num = 1; num <= 9; num++) {
                    if (isValid(board, i, j, num)) {
                        board.get(i).set(j, num);
                        if (doSolve(board, i, j + 1)) {
                            return true;
                        }
                        board.get(i).set(j, 0);
                    }
                }
                return false;
            }
        }
        return true;
    }

    private boolean isValid(ArrayList<ArrayList<Integer>> board, int row, int col, int c) {
        int blkrow = (row / 3) * 3, blkcol = (col / 3) * 3; // Block no. is i/3, first element is i/3*3
        for (int i = 0; i < 9; i++)
            if (board.get(i).get(col) == c || board.get(row).get(i) == c ||
                    board.get(blkrow + i / 3).get(blkcol + i % 3) == c)
                return false;
        return true;
    }
}
