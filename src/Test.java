package src;

public class Test {
    public static void main(String[] args) {
        testSolver();
        testSolverInvalidBoard();
        testSolverAlreadySolvedBoard();
        testSolverNearlyEmptyBoard();
    }

    public static void testSolver() {
        int[][] board = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        Solver solver = new Solver(board);
        if (solver.solve()) {
            System.out.println("Solved puzzle:");
            solver.printBoard();
        } else {
            System.out.println("No solution exists for the puzzle.");
        }
    }

    public static void testSolverInvalidBoard() {
        int[][] invalidBoard = {
            {5, 5, 0, 0, 7, 0, 0, 0, 0}, // Invalid row
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        Solver solver = new Solver(invalidBoard);
        if (!solver.solve()) {
            System.out.println("Correctly identified invalid puzzle.");
        } else {
            System.out.println("Incorrectly solved invalid puzzle:");
            solver.printBoard();
        }
    }

    public static void testSolverAlreadySolvedBoard() {
        int[][] solvedBoard = {
            {5, 3, 4, 6, 7, 8, 9, 1, 2},
            {6, 7, 2, 1, 9, 5, 3, 4, 8},
            {1, 9, 8, 3, 4, 2, 5, 6, 7},
            {8, 5, 9, 7, 6, 1, 4, 2, 3},
            {4, 2, 6, 8, 5, 3, 7, 9, 1},
            {7, 1, 3, 9, 2, 4, 8, 5, 6},
            {9, 6, 1, 5, 3, 7, 2, 8, 4},
            {2, 8, 7, 4, 1, 9, 6, 3, 5},
            {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };

        Solver solver = new Solver(solvedBoard);
        if (solver.solve()) {
            System.out.println("Recognized already solved puzzle:");
            solver.printBoard();
        } else {
            System.out.println("Incorrectly failed to recognize solved puzzle.");
        }
    }

    public static void testSolverNearlyEmptyBoard() {
        int[][] nearlyEmptyBoard = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        Solver solver = new Solver(nearlyEmptyBoard);
        if (solver.solve()) {
            System.out.println("Solved nearly empty puzzle:");
            solver.printBoard();
        } else {
            System.out.println("No solution exists for the nearly empty puzzle.");
        }
    }
}
