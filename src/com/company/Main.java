package com.company;

public class Main {


    private static boolean valueIsPossible(int[][] board, int x, int y, int value) {
        for (int i = 0; i < 9; i++) {
            if (board[y][i] == value || board[i][x] == value) {
                return false;
            }
        }
        int x0 = (x / 3) * 3;
        int y0 = (y / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[y0 + i][x0 + j] == value) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean solve(int[][] board, int x, int y) {
        for (x = 0; x < 9; x++) {
            for (y = 0; y < 9; y++) {
                if (board[y][x] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (valueIsPossible(board, x, y, num)) {
                            board[y][x] = num;

                            if (solve(board, x, y)) {
                                return true;
                            } else {
                                board[y][x] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static void solve(int[][] board) {
        if (solve(board, 0, 0))
            printBoard(board);
        else
            System.out.println("The sudoku template is unsolvable");
    }

    private static void printBoard(int[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++)
                System.out.print(board[i][j] + "  ");
            System.out.println();
        }
    }


    public static void main(String[] args) {
        int[][] board = {
                {0, 0, 0,  8, 0, 4,  9, 3, 7},
                {0, 7, 4,  1, 0, 0,  0, 8, 0},
                {8, 3, 2,  0, 0, 0,  4, 0, 0},

                {2, 0, 5,  3, 0, 0,  7, 4, 0},
                {0, 0, 0,  0, 0, 0,  0, 1, 6},
                {1, 4, 3,  0, 0, 0,  2, 0, 0},

                {0, 0, 7,  0, 9, 0,  6, 0, 0},
                {0, 2, 1,  7, 5, 6,  8, 9, 0},
                {6, 5, 9,  2, 3, 0,  0, 7, 4}};

        solve(board);
    }
}