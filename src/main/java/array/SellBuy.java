package array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SellBuy {

  private static void sellBuy(List<Integer> input, int n) {

    int startIndex = 0;
    int endIndex = 0;
    boolean haveProfit = false;
    for (int index = 1; index < n; index++) {

      boolean found = false;
      if (input.get(index - 1) <= input.get(index)) {
        endIndex = index;
      } else {
        endIndex = index - 1;
        found = true;
      }

      if (found) {
        if (startIndex < endIndex) {
          System.out.print("(" + startIndex + " " + endIndex + ") ");
          haveProfit = true;
        }
        startIndex = index;
        endIndex = index;
      }
    }

    if (startIndex < endIndex) {
      System.out.print("(" + startIndex + " " + endIndex + ")");
      haveProfit = true;
    }

    if (!haveProfit) {
      System.out.print("No Profit");
    }
    System.out.println();

  }


  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int testCase = Integer.parseInt(br.readLine());

    for (int index = 0; index < testCase; index++) {
      int n = Integer.parseInt(br.readLine());
      String[] S = br.readLine().split(" ");
      List<Integer> input = new ArrayList<>();
      Arrays.stream(S).forEach(number -> {
        input.add(Integer.parseInt(number));
      });
      sellBuy(input, n);
    }

  }
}
