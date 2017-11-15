package sorting.algorithms;

import org.jetbrains.annotations.Nullable;

public class MergeSort implements Sorter {

    @Override
    public int[] sort(int[] ar) {
        return mergeSort(ar);
    }

    @Nullable
    private int[] mergeSort(int[] ar) {
        int arrayLength = ar.length;

        if (arrayLength <= 1) {
            return null;
        }

        int mid = ar.length / 2;
        int leftSubArray[], rightSubArray[];


        if (arrayLength % 2 == 0) {
            leftSubArray = new int[mid];
            rightSubArray = new int[mid];
        } else {
            leftSubArray = new int[mid];
            rightSubArray = new int[mid + 1];
        }

        for (int i = 0, size = leftSubArray.length; i < size; i++) {
            leftSubArray[i] = ar[i];
        }

        for (int i = mid; i < arrayLength; i++) {
            rightSubArray[i - mid] = ar[i];
        }

        mergeSort(leftSubArray);

        mergeSort(rightSubArray);

        merge(ar, leftSubArray, rightSubArray);

        return ar;

    }

    private void merge(int[] ar, int[] leftArray, int[] rightArray) {
        int leftLength = leftArray.length;
        int rightLength = rightArray.length;

        int i = 0, j = 0, k = 0;

        while (i < leftLength && j < rightLength) {

            if (leftArray[i] < rightArray[j]) {
                ar[k] = leftArray[i];
                i++;
            } else {
                ar[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < leftLength) {
            ar[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < rightLength) {
            ar[k] = rightArray[j];
            j++;
            k++;
        }

    }

}