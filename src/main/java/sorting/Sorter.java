package sorting;

public class Sorter {

    public static void main(String[] args) {
        int[] elements = {100, 19, 8, 7, 6, 5, 4, 3, 12, 18};
        int sIndex = 0;
        int eIndex = 9;

        print(elements);
        new QuickSort().sort(elements, sIndex, eIndex);
        print(elements);
    }


    private static void print(int[] elements) {
        for (int index = 0; index < elements.length; index++) {
            System.out.print(elements[index] + " ");
        }
        System.out.println();
    }
}
