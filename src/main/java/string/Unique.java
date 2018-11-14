package string;

import java.util.Scanner;

public class Unique {

  public static boolean isUniqueChars(String str) {
    int checker = 0;
    for (int i = 0; i < str.length(); ++i) {
      int val = str.charAt(i) - 'a';
      System.out.println("checker " + checker);
      System.out.println("element : " + val);
      System.out.println("shift : " + (1 << val));
      System.out.println("checker & " + (checker & (1 << val)));
      if ((checker & (1 << val)) > 0)
        return false;
      checker |= (1 << val);
      System.out.println("checker | " + checker);
        System.out.println("###################################");
    }
    return true;
  }

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    String input = scanner.nextLine();

    System.out.println(isUniqueChars(input));

  }
}
