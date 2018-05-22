package backtrack;

public class SudokuSolver {

  private static boolean solve(int[][] board) {

    Block block = unassignedBlock(board);
    if (block == null) {
      return true;
    }
    for (int value = 1; value <= 9; value++) {
      if (isSafe(board, block, value)) {
        board[block.getX()][block.getY()] = value;
        if (solve(board)) {
          return true;
        }
        board[block.getX()][block.getY()] = 0;
      }
    }

    return false;
  }

  private static boolean isValidColumn(int[][] board, int row, int value) {

    boolean isValid = true;
    for (int column = 0; column < board[0].length; column++) {
      if (board[row][column] == value) {

        isValid = false;
        break;
      }
    }
    return isValid;
  }

  private static boolean isValidRow(int[][] board, int column, int value) {

    boolean isValid = true;
    for (int rowIndex = 0; rowIndex < board.length; rowIndex++) {
      if (board[rowIndex][column] == value) {
        isValid = false;
        break;
      }
    }
    return isValid;
  }

  private static boolean isValidBoard(int[][] board, int rIndex, int cIndex, int value) {

    for (int rowIndex = 0; rowIndex < 3; rowIndex++) {
      for (int columnIndex = 0; columnIndex < 3; columnIndex++) {
        if (board[rowIndex + rIndex][columnIndex + cIndex] == value) {
          return false;
        }
      }
    }
    return true;
  }

  private static boolean isSafe(int[][] board, Block block, int value) {
    int row = block.getX();
    int column = block.getY();
    return isValidColumn(board, row, value) && isValidRow(board, column, value)
        && isValidBoard(board, row - row % 3, column - column % 3, value);
  }

  private static Block unassignedBlock(int[][] board) {

    Block block = null;
    for (int rowIndex = 0; rowIndex < board.length; rowIndex++) {
      for (int columnIndex = 0; columnIndex < board[0].length; columnIndex++) {

        if (board[rowIndex][columnIndex] == 0) {
          block = new Block(rowIndex, columnIndex);
          break;
        }
      }
      if (block != null) {
        break;
      }
    }
    return block;
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

    int[][] board =
        {{3, 4, 6, 5, 0, 8, 4, 0, 0}, {5, 2, 0, 0, 0, 0, 0, 0, 0}, {0, 8, 7, 0, 0, 0, 0, 3, 1},
            {0, 0, 3, 0, 1, 0, 0, 8, 0}, {9, 0, 0, 8, 6, 3, 0, 0, 5}, {0, 5, 0, 0, 9, 0, 6, 0, 0},
            {1, 3, 0, 0, 0, 0, 2, 5, 0}, {0, 0, 0, 0, 0, 0, 0, 7, 4}, {0, 0, 5, 2, 0, 6, 3, 0, 0}};



    print(board);
    if (solve(board)) {
      print(board);
    } else {
      System.out.println("no solution found");
    }

  }
}
