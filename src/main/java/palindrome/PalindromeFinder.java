package palindrome;

public class PalindromeFinder {

  private static void print(boolean[][] matrix) {
    for (int row = 0; row < matrix.length; row++) {
      for (int column = 0; column < matrix.length; column++) {
        System.out.print(matrix[row][column] + " ");
      }
      System.out.println();
    }
  }

  private static boolean[][] findPalindrome(String str) {

    int length = str.length();
    boolean[][] matrix = new boolean[length][length];

    for (int index = 0; index < length; index++) {
      matrix[index][index] = true;
    }

    for (int row = 0; row < length - 1; row++) {
      if (str.charAt(row) == str.charAt(row + 1)) {
        matrix[row][row + 1] = true;
      }
    }

    for (int row = length - 1; row >= 0; row--) {
      for (int column = row + 2; column < length; column++) {

        if (str.charAt(row) == str.charAt(column) && matrix[row + 1][column - 1]) {
          matrix[row][column] = true;
        }
      }
    }
    return matrix;
  }


  private static void check(String str) {

    int length = str.length();

    char[] chars = str.toCharArray();

    int p = 0;
    int q = 0;

    for (int index = 0; index < length; index++) {

      int l = index;
      int r = index + 2;

      while (l >= 0 && r < length) {
        if (chars[l] != chars[r]) {
          l++;
          r--;
          break;
        }
        l--;
        r++;
      }

      if (l < 0) {
        l = 0;
      }
      if (r >= length) {
        r = length - 1;
      }

      if ((q - p) < (r - l)) {
        p = l;
        q = r;
      }


      l = index;
      r = index + 1;
      while (l >= 0 && r < length) {
        if (chars[l] != chars[r]) {
          l++;
          r--;

          if (l > r) {
            l = r;
          }
          break;
        }
        l--;
        r++;
      }

      if (l < 0) {
        l = 0;
      }
      if (r >= length) {
        r = length - 1;
      }

      if (l <= p && r >= q) {
        p = l;
        q = r;
      }
    }

    System.out.println(p + " " + q);

  }

  public static void main(String[] args) {
    String str = "pmadamp";
    boolean[][] matrix = findPalindrome(str);
    String palindrome = fetchPalindrome(matrix, str);
    System.out.println(palindrome);
  }

  private static String fetchPalindrome(boolean[][] matrix, String str) {

    int rowIndex = 0;
    int columnIndex = 0;
    for (int row = 0; row < matrix.length; row++) {
      for (int column = row; column < matrix.length; column++) {

        if (matrix[row][column] && ((column - row) > (columnIndex - rowIndex))) {
          rowIndex = row;
          columnIndex = column;
        }
      }
    }

    return str.substring(rowIndex, columnIndex + 1);
  }
}
