package array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class TrappingRainWater {

  private static int trappingWaterStackImpl(List<Integer> inputs, int n) {

    int sum = 0;

    Stack<Integer> stack = new Stack<>();

    Integer firstBlock = inputs.get(0);

    for (int index = 1; index < n; index++) {

      if (inputs.get(index) < firstBlock) {
        stack.push(inputs.get(index));
      } else {
        while (!stack.isEmpty()) {
          sum += (firstBlock - stack.pop());
        }
        firstBlock = inputs.get(index);
      }
    }

    if (!stack.isEmpty()) {
      firstBlock = stack.pop();
      while (!stack.isEmpty()) {
        Integer pop = stack.pop();
        if (firstBlock > pop) {
          sum += firstBlock - pop;
        }else{
            firstBlock = pop;
        }
      }
    }


    return sum;
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
      System.out.println(trappingWaterStackImpl(input, n));
    }
  }
}
