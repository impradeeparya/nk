package recursion;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.BiConsumer;

public class BinaryString {

    private static BiConsumer<Integer[], Integer> binary = (array, index) -> {

        if (index < 1) {
            Arrays.stream(array).forEach(System.out::print);
            System.out.println();
        } else {
            array[index - 1] = 0;
            BinaryString.binary.accept(array, index - 1);
            array[index - 1] = 1;
            BinaryString.binary.accept(array, index - 1);
        }
    };

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter length of array : ");
        int n = scanner.nextInt();
        Integer[] array = new Integer[n];
        BinaryString.binary.accept(array, n);

    }
}
