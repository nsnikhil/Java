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
     * Recursive bubble sort
     *
     * Completely insane never go completely insane
     *
     * @param ar the array
     * @return the sorted array
     */
    @Override
    public int[] sort(final int[] ar) {
        return outerSort(ar, 0);
    }

    private int[] outerSort(@NotNull final int ar[], int index) {
        if (ar.length == index) return ar;
        innerSort(ar, 0, ar.length - index - 1);
        return outerSort(ar, ++index);
    }

    private void innerSort(@NotNull final int ar[], int index, final int end) {
        if (index >= end) return;
        if (ar[index] > ar[index + 1]) {
            int temp = ar[index];
            ar[index] = ar[index + 1];
            ar[index + 1] = temp;
        }
        innerSort(ar, ++index, end);
    }

    /**
     * Iterative implementation of bubble sort
     *
     * @param ar the array to be sorted
     * @return the sorted array
     */
    private int[] bubbleSortNonRecurivse(@NotNull final int[] ar) {
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