package org.example.base_algorithms.sorting;

public class CountingSort {

    private CountingSort() { }

    public static Integer[] sort(Integer[] unsorted) {
        int maxValue = findMax(unsorted);
        int[] counts = new int[maxValue + 1];//counts number of elements
        updateCounts(unsorted, counts);
        populateCounts(unsorted, counts);
        return unsorted;
    }
    //finding maximum value in unsorted array
    private static int findMax(Integer[] unsorted) {
        int max = Integer.MIN_VALUE;//assume minimum value(-2147483648) of interger is maximum
        for (int i : unsorted) {
            if (i > max)
                max = i;
        }
        return max;
    }
    //Incrementing the number of counts in unsorted array
    private static void updateCounts(Integer[] unsorted, int[] counts) {
        for (int e : unsorted)
            counts[e]++;
    }

    private static void populateCounts(Integer[] unsorted, int[] counts) {
        int index = 0;
        for (int i = 0; i < counts.length; i++) {
            int e = counts[i];
            while (e > 0) {
                unsorted[index++] = i;
                e--;
            }
        }
    }
}
