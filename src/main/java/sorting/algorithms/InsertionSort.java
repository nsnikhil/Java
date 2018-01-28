/*
 *    Copyright 2017 nsnikhil
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package sorting.algorithms;

import org.jetbrains.annotations.NotNull;

/**
 * Two variable i and j are initialized to 0 and 1 respectively
 * where i represents the point which divides the array into two
 * parts the left one is the sorted portion while the right is the
 * unsorted portion.
 * <p>
 * The array is divided into two parts containing one element and
 * n-1 elements and then each element of unsorted portion is picked and
 * inserted at the correct position in sorted portion.
 * <p>
 * Eg -> 9,5,8,2,4
 * <p>
 * At first i = 0 and j = 1 and elements till ar[i] are sorted
 * since i = 0 and one single element array is always a sorted array
 * <p>
 * Now when a element is found that is smaller than the value at last index
 * of sorted array the sorted array is shifted by 1 and the value if inserted at
 * correct position
 * <p>
 * This is done by copying the value of elements until the correct position
 * and the inserting the value at correct position
 * given -> 2,4,5,8,3 and it is sorted till the 3rd index and then to complete
 * the sorting we have to insert three from unsorted portion into correct position
 * of the sorted part so first it is sorted in variable and then each element from
 * sorted part is compared to 3 from end and copied if it is greater than 3
 * so, 8 is copied to next index so 2,4,5,8,8->remains and then 5 is copied
 * so 2,4,5,5,8->remains and then 4 and 2,4,4,5,8 remains and 2 is smaller so its
 * not copied and 3 is inserted at index 1 and 2,3,4,5,8->remains which is sorted.
 * <p>
 * Given array -> 9,5,8,2,4
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
     * Recursive implementation of insertion sort
     *
     * @param ar the array
     * @return the sorted array
     */
    @Override
    public final Integer[] sort(final Integer[] ar) {
        return insertionSort(ar, 0, 1);
    }

    /**
     * @param ar the array
     * @param i  the starting index
     * @param j  the index till which array is sorted
     * @return sorted array
     */
    private Integer[] insertionSort(@NotNull final Integer[] ar, final int i, final int j) {
        if (ar.length == j) return ar;
        final int number = ar[j];
        final int position = insertAtCorrectPosition(ar, i, number);
        ar[position + 1] = number;
        return insertionSort(ar, i + 1, j + 1);
    }

    /**
     * @param ar       the array
     * @param position the position at which numbers is to inserted
     * @param number   the number to be inserted
     * @return position at which number is to be inserted
     */
    private int insertAtCorrectPosition(@NotNull final Integer[] ar, final int position, final int number) {
        if (position < 0 || ar[position] < number) return position;
        ar[position + 1] = ar[position];
        return insertAtCorrectPosition(ar, position - 1, number);
    }

    /**
     * Iterative implementation of insertion sort
     *
     * @param ar the array to be sorted
     * @return the sorted array
     */
    private Integer[] insertionSortIterative(@NotNull final Integer[] ar) {
        int i = 0;
        int j = 1;
        while (j < ar.length) {
            final int no = ar[j];
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