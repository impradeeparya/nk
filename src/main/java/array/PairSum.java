package array;

import java.util.HashMap;
import java.util.Map;

public class PairSum {

  public static void main(String[] args) {

    int[] sampleData = {1, 3, 6, 4, 7, 2, 9, -1, 7, 5, 10};

    Map<Integer, String> sumFrequencyMap = new HashMap<>();

    for (int row = 0; row < sampleData.length; row++) {

      boolean isFound = false;
      int firstElement = sampleData[row];

      for (int col = 0; col < sampleData.length; col++) {

        if (col != row) {
          int secondElement = sampleData[col];

          int sum = firstElement + secondElement;
          String data = sumFrequencyMap.get(sum);
          if (data == null) {
            sumFrequencyMap.put(sum, row + "-" + col);
          } else {
            System.out.println("found " + row + "-" + col + ", " + data);
            isFound = true;
            break;
          }
        }
      }

      if (isFound) {
        break;
      }
    }

  }
}
