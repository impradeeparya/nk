package sorting;

public class QuickSort {

    public void sort(int[] elements, int startIndex, int endIndex) {


        if (startIndex < endIndex) {
            int partitionKey = partition(elements, startIndex, endIndex);
            sort(elements, startIndex, partitionKey - 1);
            sort(elements, partitionKey + 1, endIndex);
        }

    }

    private int partition(int[] elements, int startIndex, int endIndex) {
        int partitionKey = startIndex;
        int sIndex = startIndex;
        int eIndex = endIndex;

        while (sIndex < eIndex) {

            while (elements[sIndex] <= elements[partitionKey] && sIndex < eIndex) {
                sIndex++;
            }

            while (elements[eIndex] > elements[partitionKey] && eIndex > partitionKey) {
                eIndex--;
            }

            if (sIndex < eIndex) {
                elements[sIndex] = elements[sIndex] + elements[eIndex];
                elements[eIndex] = elements[sIndex] - elements[eIndex];
                elements[sIndex] = elements[sIndex] - elements[eIndex];
            }

        }

        if(partitionKey < eIndex) {
            elements[partitionKey] = elements[partitionKey] + elements[eIndex];
            elements[eIndex] = elements[partitionKey] - elements[eIndex];
            elements[partitionKey] = elements[partitionKey] - elements[eIndex];
        }

        return eIndex;
    }
}
