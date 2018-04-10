package recursion;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.BiConsumer;
import java.util.stream.IntStream;

public class K_ary {

    private static Integer[] array;

    private static BiConsumer<Integer, Integer> k_string = (n, k) -> {

        if (n < 1) {
            Arrays.stream(array).forEach(System.out::print);
            System.out.println();
        } else {
            IntStream.range(0, k).forEach(index -> {
                array[n - 1] = index;
                K_ary.k_string.accept(n - 1, k);
            });
        }
    };

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter length of array : ");
        int n = scanner.nextInt();
        array = new Integer[n];
        K_ary.k_string.accept(n, n);
    }
}

