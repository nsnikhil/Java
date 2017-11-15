package sorting.algorithms;

import org.jetbrains.annotations.Nullable;

public class QuickSort implements Sorter {

    @Override
    public int[] sort(int[] ar) {
        return quickSort(ar, 0, ar.length - 1);
    }

    @Nullable
    private int[] quickSort(int ar[], int start, int end) {
        if (start >= end) {
            return null;
        }
        int pivot = partition(ar, start, end);
        quickSort(ar, start, pivot - 1);
        quickSort(ar, pivot + 1, end);
        return ar;
    }


    private int partition(int[] ar, int start, int end) {
        int pivotIndex = start;
        int temp, pivot = ar[end];
        for (int i = start; i < end; i++) {
            if (ar[i] <= pivot) {
                temp = ar[i];
                ar[i] = ar[pivotIndex];
                ar[pivotIndex] = temp;
                pivotIndex++;
            }
        }
        temp = ar[pivotIndex];
        ar[pivotIndex] = pivot;
        ar[end] = temp;
        return pivotIndex;
    }
}
