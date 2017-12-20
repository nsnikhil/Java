package sorting.algorithms;

import org.jetbrains.annotations.Nullable;

public class MergeSort implements Sorter {

    /**
     * @param ar the original array
     * @return the sorted array
     */
    @Override
    public int[] sort(int[] ar) {
        return mergeSort(ar);
    }

    /**
     * Divide the array into two equal* halves
     * and continue diving until one one element is left
     * in each of the two array and then call the merge function to
     * merge the two array into one array that is sorted.
     * <p>
     * Eg -> ar - 9,8,5,2,6,4
     * <p>
     * Divide into two 9,5,8 and 2,6,4
     * again divide 9 and 8,5
     * and then 8 and 5
     * and then 8 & 5 are merged to form 5,8
     * and then 9 and 5,8 are merged to form 5,8,9
     * <p>
     * similar for 2,6,4 to form 2,4,6
     * <p>
     * and finally merge is called with 5,8,9 and 2,6,4
     * to form  2,4,5,6,8,9
     *
     * @param ar the original array
     * @return the sorted array
     */
    @Nullable
    private int[] mergeSort(int[] ar) {
        int arrayLength = ar.length;

        if (arrayLength <= 1) return null;

        int mid = ar.length / 2;
        int leftSubArray[], rightSubArray[];

        leftSubArray = new int[mid];

        if (arrayLength % 2 == 0)
            rightSubArray = new int[mid];
        else
            rightSubArray = new int[mid + 1];

        for (int i = 0, size = leftSubArray.length; i < size; i++)
            leftSubArray[i] = ar[i];

        for (int i = mid; i < arrayLength; i++)
            rightSubArray[i - mid] = ar[i];

        mergeSort(leftSubArray);

        mergeSort(rightSubArray);

        merge(ar, leftSubArray, rightSubArray);

        return ar;
    }

    /**
     * The merge function merges two array into the main array
     * the value of left and right array are compared element wise
     * and the smallest of the two is inserted into the original array and
     * its index value is increased and this goes on until of the array is
     * completely inserted and then the remaining array is inserted into the
     * array as it is.
     * <p>
     * Eg - > leftArray : 2,5,9. rightArray : 3,4,7
     * <p>
     * int l = 0 , r = 0 , k = 0;
     * <p>
     * ar[k] = smaller of leftArray[l] & rightArray[k]
     * <p>
     * here
     * <p>
     * ar[0] = 2 amd l and k are incremented by one then
     * ar[1] = 3 and r and k are incremented by one and so on
     * <p>
     * finally we have ar = 2,3,4,5,7,9
     *
     * @param ar         the original array
     * @param leftArray  the left sub array
     * @param rightArray the right sub array
     */
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