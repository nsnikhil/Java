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

package searching.algorithms;

import sorting.algorithms.QuickSort;

/**
 * Implementation of binary search algorithm
 */
public class BinarySearch implements Searcher {

    /**
     * To perform a binary search the given
     * array has to be sorted
     *
     * @param ar the original array
     * @param n  the value to be searched
     * @return true of value if found
     */
    @Override
    public boolean search(final Integer[] ar, final Integer n) {
        return binarySearch(new QuickSort().sort(ar), 0, ar.length, n);
    }

    /**
     * Find the mid of the array and search if no
     * is equal to array at mid index if not
     * then recursively search right of mid index if element is
     * greater than value at mid index else search from start to
     * mid of the array.
     * <p>
     * Eg -> 2,3,8,9,14,51,55,88 and no - 3
     * mid  = (0+8)/2 = 4
     * ar[mid] = 9
     * since no < ar[mid]
     * recursively search from (0 to mid)
     * and if value if found return true.
     *
     * @param ar    the sorted array
     * @param start the starting index
     * @param end   the end index
     * @param no    the number to be searched
     * @return true if number is present
     */
    private boolean binarySearch(final Integer[] ar, final Integer start, final Integer end, final Integer no) {
        if (start > end) return false;
        final int mid = (start + end) / 2;
        if (no.equals(ar[mid])) return true;
        if (no < ar[mid]) return binarySearch(ar, start, mid - 1, no);
        return binarySearch(ar, mid + 1, end, no);
    }
}