package test;

import java.util.HashMap;
import java.util.Map;

public class Printer {

  static Map<Integer, Integer> populateFrequency(int[] input) {
    Map<Integer, Integer> frequencies = new HashMap<>();
    for (int index = 0; index < input.length; index++) {
      Integer frequency = frequencies.get(input[index]);
      if (frequency == null) {
        frequencies.put(input[index], 1);
      } else {
        frequencies.put(input[index], frequency + 1);
      }
    }
    return frequencies;
  }

  static void printPairs(int[] input, int sum) {
    Map<Integer, Integer> frequencies = populateFrequency(input);
    for (int index = 0; index < input.length; index++) {
      int firstElement = input[index];
      if (frequencies.get(firstElement) > 0) {
        int diff = sum - firstElement;
        Integer frequency = frequencies.get(diff);
        if (frequency != null && frequency > 0) {
          while (frequency != 0) {
            System.out.println(firstElement + ", " + diff);
            frequency--;
          }
          frequencies.put(firstElement, firstElement == diff ? frequencies.get(firstElement) - 2
              : frequencies.get(firstElement) - 1);
        }
      }
    }

  }

  public static void main(String[] args) {
    int[] input = {2, 2, 5, 6, 3, 9, 7, 7, 11, 5};
    printPairs(input, 10);
  }
}
