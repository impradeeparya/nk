package test;

public class Test {



  static boolean incSequence(int[] input) {

    int index = 1;
    while ((index < input.length) && input[index] >= input[index - 1]) {
      index++;
    }

    if (index == input.length) {
      return false;
    }

    while ((index < input.length) && input[index] <= input[index - 1]) {
      index++;
    }

    if (index == input.length) {
      return true;
    } else {
      return false;
    }


  }

  static boolean decSequence(int[] input) {
    int index = 1;
    while ((index < input.length) && input[index] <= input[index - 1]) {
      index++;
    }

    if (index == input.length) {
      return false;
    }

    while ((index < input.length) && input[index] >= input[index - 1]) {
      index++;
    }

    if (index == input.length) {
      return true;
    } else {
      return false;
    }
  }

  static boolean isbitnoic(int[] input) {

    boolean isInc = false;
    for (int index = 1; index < input.length; index++) {

      if (input[index] == input[index - 1]) {
        continue;
      }

      if (input[index] < input[index - 1]) {
        isInc = false;
      } else {
        isInc = true;
      }
      break;

    }

    return isInc ? incSequence(input) : decSequence(input);

  }


  public static void main(String[] args) {
    int[] input1 = {-3, 9, 18, 20, 17, 5, 1};
    System.out.println(isbitnoic(input1) ? "YES" : "NO");
    int[] input2 ={5, 6, 7, 2, 9, 10, 1, 3};
    System.out.println(isbitnoic(input2) ? "YES" : "NO");
    int[] input3 ={16, 4, -43, -34, 3, 6};
    System.out.println(isbitnoic(input3) ? "YES" : "NO");
  }

}
