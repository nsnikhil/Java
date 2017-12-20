package sorting.algorithms;

/**
 * Two variable i and j are initialized to 0 and 1 respectively
 * where i represents the point which divides the array into two
 * parts the left one is the sorted portion while the right is the
 * unsorted portion.
 * <p>
 * The array is divided into two parts containing one element and
 * n-1 element and then each element of unsorted portion is picked and
 * inserted at the correct position in sorted portion.
 * <p>
 * Eg -> 9,5,8,2,4
 * <p>
 * At first i = 0 and j = 1 and elements till ar[i] are sorted
 * since i = 0 and one single element array is always a sorted array
 * <p>
 * Now when a element is found that is smaller than the value at last index
 * of sorted array the sorted array is shifted and the value if inserted at
 * correct position
 * <p>
 * This is done by copying the value of elements until the correct position
 * and the inserting the value at correct position
 * given -> 2,4,5,8,3 then to inset three it is sorted in variable and
 * then 8 is copied to next index so 2,4,5,8,8 remains and then 5 is copied
 * so 2,4,5,5,8 remains and then 4 and 2,4,4,5,8 remains and 2 is smaller so its
 * not copied and 3 is inserted at index 1 and 2,3,4,5,8 remains.
 * <p>
 * first iteration :
 * <p>
 * i = 0, j = 1;
 * <p>
 * j < array length(5)
 * no = ar[j] = 5
 * p = i = 0;
 * p(0) >= 0 && ar[p](9)>5
 * ar[p+1](1) = ar[p](9)
 * --p(-1)
 * ar[p+1](0) = no(5)
 * ++i(1)
 * ++j(2)
 * <p>
 * and we get 5,9,8,2,4
 * <p>
 * and all elements within i are sorted after first iteration
 */
public class InsertionSort implements Sorter {

    /**
     * @param ar the array
     * @return the sorted array
     */
    @Override
    public int[] sort(int[] ar) {
        int i = 0;
        int j = 1;
        while (j < ar.length) {
            int no = ar[j];
            int p = i;
            while (p >= 0 && ar[p] > no) {
                ar[p + 1] = ar[p];
                --p;
            }
            ar[p + 1] = no;
            ++i;
            ++j;
        }
        return ar;
    }
}