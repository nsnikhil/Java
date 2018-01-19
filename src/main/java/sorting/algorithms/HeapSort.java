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
import util.ArrayUtil;

public class HeapSort implements Sorter {

    /**
     * @param ar the original array
     * @return the sorted array
     */
    @Override
    public final Integer[] sort(@NotNull final Integer[] ar) {
        return heapSort(ar);
    }

    /**
     * Algorithm :
     * Max Heapify the array
     * and then swap the root with last element
     * and reduce the size of heap by 1 and
     * repeat the above process
     * <p>
     * Eg:
     * Given -> 3,5,1,2,6,7,4
     * <p>
     * Max Heapify array -> 7,6,4,2,5,1,3
     * <p>
     * Exchange root with last element -> 3,6,4,2,5,1,7
     * <p>
     * Reduce heap size by 1
     * New Heap -> 3,6,4,2,5,1
     * <p>
     * Now Again Max Heapify -> 6,5,4,2,3,1
     * <p>
     * Exchange root with last element -> 1,5,4,2,3,6
     * <p>
     * Reduce heap size by 1
     * New Heap -> 1,5,4,2,3
     * <p>
     * Repeat the above steps i.e. max heapify the heap and
     * swap root with last element and reduce the size of heap by 1
     * <p>
     * and finally you have 1,2,3,4,5,6,7
     *
     * @param ar
     */
    private Integer[] heapSort(@NotNull final Integer[] ar) {
        final Integer heapSize = ar.length;
        maxHeapify(ar, heapSize, heapSize / 2);
        heapSortUtil(ar, heapSize - 1);
        return ar;
    }

    /**
     * @param ar
     * @param heapSize
     */
    private void heapSortUtil(final Integer[] ar, final Integer heapSize) {
        if (heapSize < 0) return;
        //ArrayUtil.swapValues(0, heapSize, ar);
        final int temp = ar[0];
        ar[0] = ar[heapSize];
        ar[heapSize] = temp;
        maxHeapify(ar, heapSize, 0);
        heapSortUtil(ar, heapSize - 1);
    }

    /**
     * @param ar
     * @param heapSize
     * @param index
     */
    private void maxHeapify(Integer[] ar, Integer heapSize, Integer index) {
        maxHeapifyUtil(ar, heapSize, index);
    }

    /**
     * @param ar
     * @param heapSize
     * @param index
     */
    private void maxHeapifyUtil(Integer[] ar, Integer heapSize, Integer index) {
        if (index < 0) return;
        maxHeapifyUtil(ar, heapSize, index, index, 2 * index + 1, 2 * index + 2);
        maxHeapifyUtil(ar, heapSize, index - 1);
    }

    /**
     * @param ar
     * @param heapSize
     * @param index
     * @param largest
     * @param left
     * @param right
     */
    private void maxHeapifyUtil(Integer[] ar, Integer heapSize, Integer index, Integer largest, Integer left, Integer right) {
        if (left < heapSize && ar[largest] < ar[left])
            largest = left;
        if (right < heapSize && ar[largest] < ar[right])
            largest = right;
        if (!index.equals(largest)) {
            ArrayUtil.swapValues(index, largest, ar);
            maxHeapifyUtil(ar, heapSize, largest, largest, 2 * largest + 1, 2 * largest + 2);
        }
    }
}
