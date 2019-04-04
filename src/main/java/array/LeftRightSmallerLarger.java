package array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeftRightSmallerLarger {


  private static void leftRight(List<Integer> input, int n) {

    int start = input.get(0);
    int end = input.get(n - 1);

    int i = 1;
    int j = n - 2;
    while (i < j) {

      if (input.get(i) >= start) {
        start = input.get(i);
      }
      i++;

      if (j <= end) {
        j--;
      }

    }

    if (input.get(i) >= start && input.get(i-1) < start) {
      start = input.get(i);
    }

    if (i == j && i != n - 1) {
      System.out.println(start);
    } else if (Math.abs(i - j) == 1 && i != n - 1) {
      System.out.println(start);
    } else {
      System.out.println(-1);
    }

  }


  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int testCase = Integer.parseInt(br.readLine());

    for (int index = 0; index < testCase; index++) {
      int n = Integer.parseInt(br.readLine());
      String[] S = br.readLine().split(" ");
      List<Integer> input = new ArrayList<>();
      Arrays.stream(S).forEach(number -> {
        if (!number.isEmpty())
          input.add(Integer.parseInt(number));
      });
      leftRight(input, n);
    }

  }
}
