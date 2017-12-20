package sorting.algorithms;

/**
 * Find the smallest element of the array and place it in the beginning
 * <p>
 * here minIndex is the index of the smallest element, it is initialized
 * to the 0 at beginning and then if element is smaller than it then its
 * index is stored in it and finally the value of the ith element and
 * the value at minIndex is swapped and it is continued n-1 times
 * <p>
 * <p>
 * Eg -> 9,5,8,2,4
 * <p>
 * minIndex  = 0;
 * and ar[minIndex] = 9;
 * <p>
 * then we find the smallest elements index
 * in this case 2 and the minIndex becomes = 3
 * and the we swap the value at minIndex with value at i
 * <p>
 * and finally we get 2,5,8,9,4 after first iteration
 * and after second iteration we get 2,4,8,9,5 and soo on.
 */
public class SelectionSort implements Sorter {

    /**
     * @param ar the array
     * @return the sorted array
     */
    @Override
    public int[] sort(int[] ar) {

        for (int i = 0, size = ar.length; i < size - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < size; j++)
                if (ar[j] < ar[minIndex])
                    minIndex = j;

            int temp = ar[minIndex];
            ar[minIndex] = ar[i];
            ar[i] = temp;
        }
        return ar;
    }
}