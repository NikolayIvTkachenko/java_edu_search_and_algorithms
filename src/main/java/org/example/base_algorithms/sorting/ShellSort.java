package org.example.base_algorithms.sorting;

import java.util.ArrayList;
import java.util.List;

public class ShellSort <T extends Comparable<T>> {

    private ShellSort() { }

    public static <T extends Comparable<T>> T[] sort(int[] shells, T[] unsorted) {
        for (int gap : shells) {
            List<List<T>> subarrays = new ArrayList<List<T>>(gap);
            for (int i = 0; i < gap; i++) {
                subarrays.add(new ArrayList<T>(10));
            }
            int i = 0;
            int length = unsorted.length;
            while (i < length) {
                for (int j = 0; j < gap; j++) {
                    if (i >= length)
                        continue;
                    T v = unsorted[i++];
                    List<T> list = subarrays.get(j);
                    list.add(v);
                }
            }
            sortSubarrays(subarrays);
            int k = 0;
            int iter = 0;
            while (k < length) {
                for (int j = 0; j < gap; j++) {
                    if (k >= length)
                        continue;
                    unsorted[k++] = subarrays.get(j).get(iter);
                }
                iter++;
            }
        }
        return unsorted;
    }

    private static <T extends Comparable<T>> void sortSubarrays(List<List<T>> lists) {
        for (List<T> list : lists) {
            sort(list);
        }
    }

    private static <T extends Comparable<T>> void sort(List<T> list) {
        int size = list.size();
        for (int i = 1; i < size; i++) {
            for (int j = i; j > 0; j--) {
                T a = list.get(j);
                T b = list.get(j - 1);
                if (a.compareTo(b) < 0) {
                    list.set(j - 1, a);
                    list.set(j, b);
                } else {
                    break;
                }
            }
        }
    }
}