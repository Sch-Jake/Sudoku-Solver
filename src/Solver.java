package src;
import java.util.*;

public class Solver {
    private int[][] board;
    private static final int SIZE = 9; // Size of the Sudoku board

    // Constructor to initialize the board
    public Solver(int[][] board) {
        this.board = board;
    }

    // Method to solve the Sudoku puzzle
    public boolean solve() {
        int[] cell = findEmptyCell(); // Find an empty cell on the board
        if (cell == null) {
            return true; // No empty cell found, puzzle is solved
        }
        int row = cell[0];
        int col = cell[1];

        List<Integer> candidates = getCandidates(row, col); // Get list of valid candidates for the cell
        for (int num : candidates) { // Try each candidate
            board[row][col] = num;
            if (solve()) { // Recursively attempt to solve the board
                return true; // Solved successfully
            }
            board[row][col] = 0; // Reset the cell if solving fails
        }

        return false; // No solution found for this configuration
    }

    // Helper method to find an empty cell (cell with value 0)
    private int[] findEmptyCell() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == 0) {
                    return new int[]{row, col}; // Return the position of the empty cell
                }
            }
        }
        return null; // No empty cell found
    }

    // Helper method to get valid candidates for a given cell
    private List<Integer> getCandidates(int row, int col) {
        boolean[] used = new boolean[SIZE + 1]; // Boolean array to mark used numbers
        Arrays.fill(used, false);

        // Mark numbers used in the current row
        for (int i = 0; i < SIZE; i++) {
            if (board[row][i] != 0) {
                used[board[row][i]] = true;
            }
        }

        // Mark numbers used in the current column
        for (int i = 0; i < SIZE; i++) {
            if (board[i][col] != 0) {
                used[board[i][col]] = true;
            }
        }

        // Mark numbers used in the current 3x3 sub-grid
        for (int i = 0; i < SIZE; i++) {
            int boxRow = row / 3 * 3 + i / 3;
            int boxCol = col / 3 * 3 + i % 3;
            if (board[boxRow][boxCol] != 0) {
                used[board[boxRow][boxCol]] = true;
            }
        }

        // Collect all numbers that are not used
        List<Integer> candidates = new ArrayList<>();
        for (int num = 1; num <= SIZE; num++) {
            if (!used[num]) {
                candidates.add(num);
            }
        }

        return candidates; // Return list of valid candidates
    }

    // Method to print the current state of the Sudoku board
    public void printBoard() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }
}
