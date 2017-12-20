package sorting.algorithms;

/**
 * The corresponding two elements of the array are compared
 * and if value of the first element is greater than the
 * value of the next element the value are swapped and this goes on
 * until we reach the end of list and we have an array with
 * the largest element to it end. Then the same process is
 * repeated again but this time till 1 less elements is compared
 * since the last element have been sorted and moved to correct place
 * and this goes on till the entire array is sorted.
 * <p>
 * Eg : ar -> 9,5,8,2,4
 * <p>
 * At the beginning 9 and 5 are compared and since
 * 9 is greater than 5 they are swapped and this goes on
 * like this
 * 5,9,8,2,4
 * 5,8,9,2,4
 * 5,8,2,9,4
 * 5,8,2,4,9
 * <p>
 * after this the first iteration is complete and this
 * repeats n time where n is the size of array and each time
 * only n-i-1 element are compared.
 * <p>
 * and finally we have -> 2,4,5,8,9
 */
public class BubbleSort implements Sorter {

    /**
     * @param ar the array
     * @return the sorted array
     */
    @Override
    public int[] sort(int[] ar) {
        for (int i = 0, size = ar.length; i < size; i++)
            for (int j = 0; j < size - i - 1; j++)
                if (ar[j] > ar[j + 1]) {
                    int temp = ar[j];
                    ar[j] = ar[j + 1];
                    ar[j + 1] = temp;
                }
        return ar;
    }

}