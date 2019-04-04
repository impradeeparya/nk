package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import static java.util.stream.Collectors.*;
import static java.util.Map.Entry.*;


public class Solution {

  private static int findMissingNumber(List<Integer> numbers, int n) {
    int total = (n * (n + 1)) / 2;

    int sum = numbers.stream().mapToInt(number -> number.intValue()).sum();
    return total - sum;
  }

  // public static void main(String[] args) throws IOException {
  //
  // Scanner scanner = new Scanner(System.in);
  //
  // int testCase = Integer.parseInt(scanner.nextLine());
  //
  // for (int index = 0; index < testCase; index++) {
  //
  // int size = Integer.parseInt(scanner.nextLine());
  // String line = scanner.nextLine();
  //
  // List<Integer> numbers = new ArrayList<>();
  // Arrays.stream(line.split(" ")).forEach(number -> {
  // numbers.add(Integer.parseInt(number));
  // });
  // System.out.println(findMissingNumber(numbers, size));
  //
  // }
  //
  // }

  private static void printIndex(List<Integer> numbers, int n, int k) {

    int currentSum = numbers.get(0);
    int startIndex = 0;
    int currentIndex = 0;
    for (int index = 1; index < n;) {

      if (currentSum == k) {
        System.out.println((startIndex + 1) + " " + (currentIndex + 1));
        break;
      } else if (currentSum > k) {
        while (currentSum > k && startIndex < currentIndex) {
          currentSum -= numbers.get(startIndex);
          startIndex++;
        }
        continue;
      }

      currentSum += numbers.get(index);
      currentIndex++;
      index++;
    }
  }

  private static void printLeader(List<Integer> numbers, int n) {
    int currentMax = numbers.get(n - 1);
    List<Integer> leaders = new ArrayList<>();
    leaders.add(currentMax);
    for (int index = n - 2; index >= 0; index--) {
      if (numbers.get(index) >= currentMax) {
        currentMax = numbers.get(index);
        leaders.add(currentMax);
      }
    }

    System.out.println();
    for (int index = leaders.size() - 1; index >= 0; index--) {
      System.out.print(leaders.get(index) + " ");
    }

  }

  private static void parkTrain(Map<Integer, Integer> platform, Integer arTime, Integer drTime) {

    boolean isParked = false;
    Integer key = null;
    for (Entry<Integer, Integer> entry : platform.entrySet()) {
      if (entry.getValue() < arTime) {
        key = entry.getKey();
        isParked = true;
        break;
      }
    }

    if (isParked) {
      platform.remove(key);
    }
    platform.put(arTime, drTime);
  }

  private static int getPlatformCount(List<Integer> ar, List<Integer> dr) {

    Map<Integer, Integer> platform = new LinkedHashMap<>();
    for (int index = 0; index < ar.size(); index++) {
      parkTrain(platform, ar.get(index), dr.get(index));
    }
    return platform.size();
  }

  private static void printMaxSubarray(List<Integer> input, int n, int k) {
    System.out.println();
    for (int index = 0; index <= n - k; index++) {
      int max = Integer.MIN_VALUE;
      for (int window = index; window < index + k; window++) {
        if (max < input.get(window)) {
          max = input.get(window);
        }
      }
      System.out.print(max + " ");
    }

  }

  private static void fun1(String s) {

  }

  private static void fun1(int s) {

  }

  private static void fun1(Integer i) {

  }

  private static void fun1(Object o) {

  }

  private static void fun1(Long s) {

  }

  // public static void main(String[] args) throws IOException {
  //
  // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  //
  // int testCase = Integer.parseInt(br.readLine());
  //
  // for (int index = 0; index < testCase; index++) {
  // String[] N = br.readLine().split(" ");
  // int n = Integer.parseInt(N[0]);
  // int k = Integer.parseInt(N[1]);
  // String[] S = br.readLine().split(" ");
  // List<Integer> input = new ArrayList<>();
  // Arrays.stream(S).forEach(number -> {
  // input.add(Integer.parseInt(number));
  // });
  // printMaxSubarray(input, n, k);
  // }
  //
  // fun1(1);
  // }

  public static void main(String[] args) throws Exception {
    // a Map with string keys and integer values
    Map<String, Integer> budget = new HashMap<>();
    budget.put("clothes", 120);
    budget.put("grocery", 150);
    budget.put("transportation", 100);
    budget.put("utility", 130);
    budget.put("rent", 1150);
    budget.put("miscellneous", 90);
    System.out.println("map before sorting: " + budget);
    // let's sort this map by values first
    Map<String, Integer> sorted = budget.entrySet().stream().sorted(comparingByValue())
        .collect(toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2, LinkedHashMap::new));
    System.out.println("map after sorting by values: " + sorted);
    // above code can be cleaned a bit by using method reference
    sorted = budget.entrySet().stream().sorted(comparingByValue())
        .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

    // now let's sort the map in decreasing order of value
    sorted = budget.entrySet().stream()
        .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
        .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

    System.out.println("map after sorting by values in descending order: " + sorted);

  }

}
