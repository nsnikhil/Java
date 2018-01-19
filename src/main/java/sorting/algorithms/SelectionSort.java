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
     * Recursive implementation of selection sort
     *
     * @param ar the array
     * @return the sorted array
     */
    @Override
    public final Integer[] sort(final Integer[] ar) {
        return selectionSort(ar, 0);
    }

    private Integer[] selectionSort(@NotNull final Integer[] ar, final int index) {
        if (ar.length == index) return ar;
        final int minIndex = findMinIndex(ar, index + 1, index);
        //ArrayUtil.swapValues(minIndex,index,ar);
        final int temp = ar[minIndex];
        ar[minIndex] = ar[index];
        ar[index] = temp;
        return selectionSort(ar, index + 1);
    }

    private int findMinIndex(@NotNull final Integer[] ar, final int index, final int minIndex) {
        if (ar.length == index) return minIndex;
        if (ar[index] < ar[minIndex])
            return findMinIndex(ar, index + 1, index);
        return findMinIndex(ar, index + 1, minIndex);
    }

    /**
     * Iterative implementation of selection sort
     *
     * @param ar the array to be sorted
     * @return the sorted array
     */
    private Integer[] selectionSortIterative(@NotNull final Integer ar[]) {
        for (int i = 0, size = ar.length; i < size - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < size; j++)
                if (ar[j] < ar[minIndex])
                    minIndex = j;

            final int temp = ar[minIndex];
            ar[minIndex] = ar[i];
            ar[i] = temp;
        }
        return ar;
    }
}