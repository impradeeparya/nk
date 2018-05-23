package backtrack;

import java.util.LinkedList;
import java.util.List;

public class NQueenSolver {

  static class NQueen {
    private boolean solve(int[][] board, int row) {

      int column = 0;
      if (row >= board.length) {
        return true;
      }
      while (column < board[row].length) {

        board[row][column] = 1;

        if (isSafe(board, row, column) && solve(board, row + 1)) {
          return true;
        }
        board[row][column] = 0;
        column++;
      }

      return false;
    }

    private boolean isSafe(int[][] board, int row, int column) {
      return isSafeColumn(board, row, column) && isSafeDiagonal(board, row, column);
    }

    private boolean isSafeDiagonal(int[][] board, int row, int column) {

      int rowIndex = row;
      int columnIndex = column;

      // up left check
      rowIndex--;
      columnIndex--;
      while (rowIndex >= 0 && columnIndex >= 0) {
        if (board[rowIndex][columnIndex] == 1) {
          return false;
        }
        rowIndex--;
        columnIndex--;
      }

      rowIndex = row;
      columnIndex = column;
      // up right check
      rowIndex--;
      columnIndex++;
      while (rowIndex >= 0 && columnIndex < board[row].length) {
        if (board[rowIndex][columnIndex] == 1) {
          return false;
        }
        rowIndex--;
        columnIndex++;
      }

      rowIndex = row;
      columnIndex = column;
      // down left check
      rowIndex++;
      columnIndex--;
      while (rowIndex < board.length && columnIndex >= 0) {
        if (board[rowIndex][columnIndex] == 1) {
          return false;
        }
        rowIndex++;
        columnIndex--;
      }

      rowIndex = row;
      columnIndex = column;
      // down right check
      rowIndex++;
      columnIndex++;
      while (rowIndex < board.length && columnIndex < board[row].length) {
        if (board[rowIndex][columnIndex] == 1) {
          return false;
        }
        rowIndex++;
        columnIndex++;
      }

      return true;
    }

    private boolean isSafeColumn(int[][] board, int row, int column) {

      for (int rowIndex = 0; rowIndex < row; rowIndex++) {
        if (board[rowIndex][column] == 1) {
          return false;
        }
      }

      for (int rowIndex = row + 1; rowIndex < board.length; rowIndex++) {
        if (board[rowIndex][column] == 1) {
          return false;
        }
      }

      return true;
    }
  }


  static class OptimizedNQueen {
    List<Block> queenPositions = new LinkedList<>();

    private boolean solve(int N, int row) {

      int column = 0;
      if (row >= N) {
        return true;
      }
      while (column < N) {
        Block block = new Block(row, column);

        if (isSafe(row, column)) {
          queenPositions.add(block);
          if (solve(N, row + 1)) {
            return true;
          }
          queenPositions.remove(block);
        }
        column++;
      }

      return false;
    }

    private boolean isSafe(int row, int column) {
      for (Block block : queenPositions) {
        int x = block.getX();
        int y = block.getY();

        if (column == y || (Math.abs(row - x) == Math.abs(column - y))) {
          return false;
        }
      }

      return true;
    }

    private void placeQueens(int[][] board) {
      for (Block block : queenPositions) {
        board[block.getX()][block.getY()] = 1;
      }
    }
  }


  private static void print(int[][] board) {

    for (int row = 0; row < board.length; row++) {
      for (int column = 0; column < board[0].length; column++) {
        System.out.print(board[row][column] + " ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {

    // int[][] board = {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};

    int[][] board = {{0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}};

    print(board);
    System.out
        .println("#############################################################################");


    System.out.println("Nqueen with backtracking");
    System.out.println("solution : ");
    NQueen nQueen = new NQueen();
    if (nQueen.solve(board, 0)) {
      print(board);
    } else {
      System.out.println("no solution found");
    }

    board = new int[][] {{0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}};
    // board = new int[][]{{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
    System.out
        .println("#############################################################################");
    System.out.println("Optimized Nqueen with backtracking");
    System.out.println("solution : ");
    OptimizedNQueen optimizedNQueen = new OptimizedNQueen();
    if (optimizedNQueen.solve(board.length, 0)) {
      optimizedNQueen.placeQueens(board);
      print(board);
    } else {
      System.out.println("no solution found");
    }

  }
}
