package backtrack;

public class NQueenSolver {

  private static boolean solve(int[][] board, int row, int column) {

    if (row >= board.length) {
      return true;
    }
    while (column < board[row].length) {

      board[row][column] = 1;

      if (isSafe(board, row, column) && solve(board, row + 1, 0)) {
        return true;
      }
      board[row][column] = 0;
      column++;
    }

    return false;
  }

  private static boolean isSafe(int[][] board, int row, int column) {
    return isSafeColumn(board, row, column) && isSafeDiagonal(board, row, column);
  }

  private static boolean isSafeDiagonal(int[][] board, int row, int column) {

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

  private static boolean isSafeColumn(int[][] board, int row, int column) {

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

    System.out.println("solution : ");
    if (solve(board, 0, 0)) {
      print(board);
    } else {
      System.out.println("no solution found");
    }

  }
}
