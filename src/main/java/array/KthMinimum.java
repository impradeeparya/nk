package array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class KthMinimum {


  private static void populateKmin(List<Integer> kNumbers, int k, Integer input) {

    boolean isPushed = false;
    for (int index = 0; index < kNumbers.size(); index++) {
      if (input <= kNumbers.get(index)) {
        kNumbers.add(index, input);
        isPushed = true;
        break;
      }
    }

    if (!isPushed && kNumbers.size() < k) {
      kNumbers.add(input);
    }
    if (kNumbers.size() > k) {
      kNumbers.remove(kNumbers.size() - 1);
    }
  }

  private static int printKmin(List<Integer> input, int n, int k) {

    List<Integer> kNumbers = new LinkedList<>();
    for (int index = 0; index < n; index++) {
      populateKmin(kNumbers, k, input.get(index));
    }
    return kNumbers.get(k-1);
  }

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int testCase = Integer.parseInt(br.readLine());

    for (int index = 0; index < testCase; index++) {
      int n = Integer.parseInt(br.readLine());
      String[] S = br.readLine().split(" ");
      int k = Integer.parseInt(br.readLine());
      List<Integer> input = new ArrayList<>();
      Arrays.stream(S).forEach(number -> {
        input.add(Integer.parseInt(number));
      });
      System.out.println(printKmin(input, n, k));
    }

  }
}
