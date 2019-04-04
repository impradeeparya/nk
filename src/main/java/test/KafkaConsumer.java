package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class KafkaConsumer {

  // public static List<String> getShrunkArray(List<String> inputArray, int burstLength) {
  // Map<String, List<Integer>> extraElements = new HashMap<>();
  // for (int index = 0; index < inputArray.size(); index++) {
  //
  // String input = inputArray.get(index);
  //
  // if (extraElements.get(input) == null) {
  // List<Integer> indexs = new ArrayList<>();
  // indexs.add(index);
  // extraElements.put(input, indexs);
  // int count = 1;
  // for (int inputIndex = index + 1; inputIndex < inputArray.size(); inputIndex++) {
  // if (inputArray.get(inputIndex).equals(input)) {
  // indexs.add(inputIndex);
  // extraElements.put(input, indexs);
  // count++;
  // }
  // }
  // if (count < burstLength) {
  // extraElements.remove(input);
  // }
  // }
  //
  // }
  // System.out.println(extraElements);
  //
  // for (Map.Entry<String, List<Integer>> extraElement : extraElements.entrySet()) {
  // while (inputArray.remove(extraElement.getKey())) {
  //
  // }
  // }
  // return inputArray;
  //
  // }

  public static List<String> getShrunkArray(List<String> inputArray, int burstLength) {
    List<String> shrunkArray = new ArrayList<>();
    List<Integer> indexes = new ArrayList<>();
    for (int index = 0; index < inputArray.size(); index++) {
      String input = inputArray.get(index);
      if (input != null) {
        int count = 1;
        indexes.add(index);
        for (int inputIndex = index + 1; inputIndex < inputArray.size(); inputIndex++) {
          if (input.equals(inputArray.get(inputIndex))) {
            indexes.add(inputIndex);
            count++;
          }
        }
        if (count < burstLength) {
          inputArray.set(index, null);
          shrunkArray.add(input);
        } else {
          for (int removeIndex = 0; removeIndex < indexes.size(); removeIndex++) {
            inputArray.set(indexes.get(removeIndex), null);
          }
        }
        System.out.println(shrunkArray);
      }
      indexes.clear();
    }

    return shrunkArray;

  }

  static boolean isValid(int element, List<List<Integer>> matrix, int row, int column) {
    List<Integer> rowElements = matrix.get(row);
    boolean isRowMin = true;
    for (int index = 0; index < rowElements.size(); index++) {
      if (index != column && rowElements.get(index) <= element) {
        isRowMin = false;
        break;
      }
    }
    boolean isRowMax = true;
    for (int index = 0; index < rowElements.size(); index++) {
      if (index != column && rowElements.get(index) >= element) {
        isRowMax = false;
        break;
      }
    }

    boolean isColumnMin = true;
    for (int index = 0; index < matrix.size(); index++) {
      if (index != row && matrix.get(index).get(column) <= element) {
        isColumnMin = false;
        break;
      }
    }

    boolean isColumnMax = true;
    for (int index = 0; index < matrix.size(); index++) {
      if (index != row && matrix.get(index).get(column) >= element) {
        isColumnMax = false;
        break;
      }
    }

    return isRowMax || isRowMin || isColumnMax || isColumnMin;

  }

  static int countSpecialElements(List<List<Integer>> matrix) {

    int count = -1;
    for (int row = 0; row < matrix.size(); row++) {
      for (int column = 0; column < matrix.get(0).size(); column++) {
        int element = matrix.get(row).get(column);
        count = isValid(element, matrix, row, column) ? count + 1 : count;
      }
    }

    return count;
  }

  public static void main(String[] args) {
    // List<List<Integer>> input = new ArrayList<>();
    // List<Integer> subList = new ArrayList<>();
    // subList.add(1);
    // subList.add(3);
    // subList.add(4);
    // input.add(subList);
    // subList = new ArrayList<>();
    // subList.add(5);
    // subList.add(2);
    // subList.add(9);
    // input.add(subList);
    // subList = new ArrayList<>();
    // subList.add(8);
    // subList.add(7);
    // subList.add(6);
    // input.add(subList);
    // System.out.println(countSpecialElements(input));

    List<String> input = new ArrayList<>();
    input.add("a");
    input.add("b");
    input.add("c");
    input.add("d");
    input.add("e");
    input.add("e");
    input.add("e");
    input.add("e");
    input.add("d");
    input.add("d");
    input.add("c");
    input.add("b");
    input.add("f");
    input.add("g");
    input.add("f");
    System.out.println(getShrunkArray(input, 3));
  }
}
