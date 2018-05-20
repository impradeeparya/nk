package array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ArrayTester {

  public static void main(String[] args) {

    int[] array = {1, 2, 3, 2, 4, 4, 1};
    oddOneOutXOR(array);

    array = new int[] {1, 2, 3, 2, 4, 4, 1, 3, 1};
    oddOneOutXOR(array);

    array = new int[] {1, 2, 3, 2, 4, 4, 1, 3, 1, 2, 5, 6, 6, 5, 5};
    oddOneOutMap(array);

    oddOneOut(array);
    array = new int[] {1, 2, 3, 2, 4, 4, 1, 5};
    oddOneOut(array);

  }

  private static void oddOneOut(int[] array) {

    long startTime = System.currentTimeMillis();
    Set<Integer> uniqueNumber = new HashSet<>();

    for (int row = 0; row < array.length; row++) {
        boolean isOdd = true;
      if (!uniqueNumber.contains(array[row])) {
        for (int column = row + 1; column < array.length; column++) {
          if (array[row] == array[column]) {
            isOdd = !isOdd;
          }
        }
        if (isOdd) {
          System.out.print(array[row] + " ");
        }
        uniqueNumber.add(array[row]);
      }
    }
    System.out.println("Time taken ms : " + (System.currentTimeMillis() - startTime));

  }

  private static void oddOneOutXOR(int[] array) {

    long startTime = System.currentTimeMillis();
    int oddNumber = array[0];
    for (int index = 1; index < array.length; index++) {
      oddNumber = oddNumber ^ array[index];
    }
    System.out.println("odd one out : " + oddNumber);
    System.out.println("Time taken ms : " + (System.currentTimeMillis() - startTime));
  }

  private static void oddOneOutMap(int[] array) {
    long startTime = System.currentTimeMillis();
    Map<Integer, Boolean> oddMapper = new HashMap<>();
    for (int index = 0; index < array.length; index++) {

      Boolean value = oddMapper.get(array[index]);

      if (value == null) {
        oddMapper.put(array[index], true);
      } else {
        oddMapper.remove(array[index]);
      }
    }
    System.out.println("odd one out : " + oddMapper.keySet());
    System.out.println("Time taken ms : " + (System.currentTimeMillis() - startTime));
  }
}
