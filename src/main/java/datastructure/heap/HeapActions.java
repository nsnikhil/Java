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

package datastructure.heap;

import org.jetbrains.annotations.NotNull;
import util.ArrayUtil;

public final class HeapActions {

    /**
     * Algorithm :
     * We can insert Integer.MIN_VALUE and the call
     * increase value with new value
     *
     * @param ar
     * @param value
     */
    public static void insertIntoMaxHeap(final Integer ar[], Integer value) {
        if (ar[ar.length - 1] != null) throw new ArrayIndexOutOfBoundsException("Array is full ");
        insertIntoMaxHeap(ar, value, getInsertIndex(ar, 0));
    }

    /**
     * @param ar
     * @param value
     * @param index
     */
    private static void insertIntoMaxHeap(@NotNull final Integer[] ar, final Integer value, final int index) {
        ar[index] = Integer.MIN_VALUE;
        increaseValueMaxHeap(ar, index, value);
    }

    /**
     * Algorithm :
     * We can insert Integer.MAX_VALUE and the call
     * decrease value with new value
     *
     * @param ar
     * @param value
     */
    public static void insertIntoMinHeap(final Integer ar[], Integer value) {
        if (ar[ar.length - 1] != null) throw new ArrayIndexOutOfBoundsException("Array is full ");
        insertIntoMinHeap(ar, value, getInsertIndex(ar, 0));
    }

    /**
     * @param ar
     * @param value
     * @param index
     */
    private static void insertIntoMinHeap(final Integer ar[], Integer value, int index) {
        ar[index] = Integer.MAX_VALUE;
        decreaseValueMinHeap(ar, index, value);
    }

    /**
     * Returns the index in the array where value can be inserted
     *
     * @param ar
     * @param index
     * @return
     */
    private static int getInsertIndex(final Integer ar[], final int index) {
        if (ar.length - 1 == index) return index;
        if (ar[index] == null) return index;
        return getInsertIndex(ar, index + 1);
    }


    /**
     * Max heapifies a given array/tree
     * <p>
     * Since the node staring from (n/2)+1 to n are all leaf node
     * so we need to apply max heapify on nodes from n/2 to 1
     *
     * @param ar the array to max heapify
     */
    public static void maxHeapify(@NotNull final Integer[] ar) {
        maxHeapify(ar, ar.length / 2);
        ArrayUtil.printArray(ar);
    }

    /**
     * @param ar
     * @param index
     */
    private static void maxHeapify(@NotNull final Integer[] ar, final int index) {
        if (index < 0) return;
        maxHeapifyUtil(ar, index);
        maxHeapify(ar, index - 1);
    }

    /**
     * Min heapifies a given array/tree
     * <p>
     * Since the node staring from (n/2)+1 to n are all leaf node
     * so we need to apply min heapify on nodes from n/2 to 1
     *
     * @param ar the array to min heapify
     */
    static void minHeapify(final Integer[] ar) {
        minHeapify(ar, ar.length / 2);
        ArrayUtil.printArray(ar);
    }

    /**
     * @param ar
     * @param index
     */
    private static void minHeapify(final Integer[] ar, final int index) {
        if (index < 0) return;
        minHeapifyUtil(ar, index);
        minHeapify(ar, index - 1);
    }

    /**
     * Max heapifies a given array/tree
     * <p>
     * Algorithm :
     * All the leaf nodes are already max heap and all the
     * index following the index passed are max heap.
     * <p>
     * We find the largest element between given node and
     * its children and if the parent is not largest we swap
     * the value from the node with largest value with the parent
     * and call max heapify on the node from which the element is
     * swapped
     * <p>
     * eg:
     * <p>
     * 2
     * /    \
     * 8     6
     * / \   / \
     * 3  5  1  4
     * <p>
     * we call the function passing array and index 0
     * the max of three will be found out which is 8 and
     * 2 will be swapped with 8
     * <p>
     * 8
     * /    \
     * 2     6
     * / \   / \
     * 3  5  1  4
     * <p>
     * and now max since the root was not max and value have
     * been swapped it is possible that tree from the swapped node
     * might not follow max heap so we will call max heap on 2
     * and again max of three will be found and swapped if necessary
     * here 5 will be swapped with 2
     * <p>
     * 8
     * /    \
     * 5     6
     * / \   / \
     * 3  2  1  4
     * <p>
     * and now gain max heap will be called on 2 since 2 has no children
     * and itself is a max heap nothing will happen and function will return
     * and finally we will have out max heap
     *
     * @param ar    the array to max heapify
     * @param index the index on which the heapify will occur
     */
    private static void maxHeapifyUtil(final Integer[] ar, final int index) {
        maxHeapifyUtil(ar, index, index, 2 * index + 1, 2 * index + 2);
    }

    /**
     * @param ar
     * @param index
     * @param largest
     * @param left
     * @param right
     */
    private static void maxHeapifyUtil(@NotNull final Integer[] ar, final int index, int largest, final int left, final int right) {
        if (left < ar.length && ar[left] > ar[largest])
            largest = left;
        if (right < ar.length && ar[right] > ar[largest])
            largest = right;
        if (index != largest) {
            ArrayUtil.swapValues(index, largest, ar);
            maxHeapifyUtil(ar, largest, largest, 2 * largest + 1, 2 * largest + 2);
        }
    }


    /**
     * Min heapifies a given array/tree
     * <p>
     * Algorithm :
     * All the leaf nodes are already min heap and all the
     * index following the index passed are min heap.
     * <p>
     * We find the smallest element between given node and
     * its children and if the parent is not smallest we swap
     * the value from the node with smallest value with the parent
     * and call min heapify on the node from which the element is
     * swapped
     * <p>
     * eg:
     * <p>
     * 8
     * /    \
     * 2     10
     * / \   /  \
     * 3  5  16  14
     * <p>
     * we call the function passing array and index 0
     * the min of three will be found out which is 2 and
     * 2 will be swapped with 8
     * <p>
     * 2
     * /    \
     * 8     10
     * / \   /  \
     * 3  5  16  14
     * <p>
     * and now min since the root was not min and value have
     * been swapped it is possible that tree from the swapped node
     * might not follow min heap so we will call min heap on 8
     * and again min of three will be found and swapped if necessary
     * here 3 will be swapped with 8
     * <p>
     * 2
     * /    \
     * 3     10
     * / \   /  \
     * 8  5  16  14
     * <p>
     * and now gain min heap will be called on 8 since 8 has no children
     * and itself is a min heap nothing will happen and function will return
     * and finally we will have out min heap
     *
     * @param ar    the array to min heapify
     * @param index the index on which the heapify will occur
     */
    private static void minHeapifyUtil(final Integer[] ar, final int index) {
        minHeapifyUtil(ar, index, index, 2 * index + 1, 2 * index + 2);
    }

    private static void minHeapifyUtil(@NotNull final Integer[] ar, final int index, int smallest, final int left, final int right) {
        if (left < ar.length && ar[left] < ar[smallest])
            smallest = left;
        if (right < ar.length && ar[right] < ar[smallest])
            smallest = right;
        if (index != smallest) {
            ArrayUtil.swapValues(index, smallest, ar);
            minHeapifyUtil(ar, smallest, smallest, 2 * smallest + 1, 2 * smallest + 2);
        }
    }

    /**
     * This will delete the max value from a max heap
     * <p>
     * Algorithm :
     * Delete the root and place the last value as the root
     * now both the child of root are max heap and root might
     * be max heap so we call max heap from root
     *
     * @param ar
     */
    public static Integer extractMaxMaxHeap(final Integer[] ar) {
        final Integer max = ar[0];
        ar[0] = ar[ar.length - 1];
        ar[ar.length - 1] = null;
        maxHeapify(ar, 0);
        return max;
    }

    /**
     * @param ar
     */
    public static Integer extractMinMinHeap(final Integer[] ar) {
        //TODO
        return null;
    }

    /**
     * For Max heap only
     * Algorithm :
     * The new value should be greater than previous value
     * Set the new value at node and the keep swapping with
     * parent if the parent is smaller than new value continue
     * until you reach root or if parent is greater than new value
     *
     * @param ar
     * @param index
     * @param newVal
     */
    public static void increaseValueMaxHeap(@NotNull final Integer[] ar, final int index, final int newVal) {
        if (ar[index] > newVal)
            throw new IllegalArgumentException(newVal + " is smaller than previous value " + ar[index]);
        ar[index] = newVal;
        swapParentMaxHeap(ar, index);
    }

    /**
     * @param ar
     * @param index
     */
    private static void swapParentMaxHeap(final Integer ar[], final int index) {
        if (index < 0 || ar[index] < ar[index / 2]) return;
        ArrayUtil.swapValues(index, index / 2, ar);
        swapParentMaxHeap(ar, index / 2);
    }

    /**
     * For Max heap only
     * Algorithm :
     * Set the new value and call max heapify from the
     * node with new value
     *
     * @param ar
     * @param index
     * @param newVal
     */
    public static void decreaseValueMaxHeap(@NotNull final Integer[] ar, final int index, final int newVal) {
        if (ar[index] < newVal)
            throw new IllegalArgumentException(newVal + " is larger than previous value " + ar[index]);
        ar[index] = newVal;
        maxHeapify(ar, index);
    }

    /**
     * For Min heap only
     * Algorithm :
     * Set the new value and call min heapify from the
     * node with new value
     *
     * @param ar
     * @param index
     * @param newVal
     */
    public static void increaseeValueMinHeap(@NotNull final Integer[] ar, final int index, final int newVal) {
        if (ar[index] > newVal)
            throw new IllegalArgumentException(newVal + " is smaller than previous value " + ar[index]);
        ar[index] = newVal;
        minHeapify(ar, index);
    }

    /**
     * For Min heap only
     * Algorithm :
     * The new value should be smaller than previous value
     * Set the new value at node and the keep swapping with
     * parent if the parent is greater than new value continue
     * until you reach root or if parent is smaller than new value
     *
     * @param ar
     * @param index
     * @param newVal
     */
    public static void decreaseValueMinHeap(@NotNull final Integer[] ar, final int index, final int newVal) {
        if (ar[index] < newVal)
            throw new IllegalArgumentException(newVal + " is larger than previous value " + ar[index]);
        ar[index] = newVal;
        swapParentMinHeap(ar, index);
    }

    /**
     * @param ar
     * @param index
     */
    private static void swapParentMinHeap(final Integer ar[], final int index) {
        if (index < 0 || ar[index] > ar[index / 2]) return;
        ArrayUtil.swapValues(index, index / 2, ar);
        swapParentMinHeap(ar, index / 2);
    }

    /**
     * @param ar
     * @return
     */
    public static boolean isMaxHeap(final Integer[] ar) {
        //TODO CHECK
        return isMaxHeaps(ar, 0);
    }

    /**
     * @param ar
     * @param index
     * @return
     */
    private static boolean isMaxHeaps(@NotNull final Integer[] ar, final int index) {
        return ar.length / 2 == index || ar[index] >= ar[index * 2 + 1] && ar[index] >= ar[index * 2 + 2] && isMaxHeaps(ar, index + 1);
    }

    /**
     * @param ar
     * @param index
     * @return
     */
    private static boolean isMinHeaps(@NotNull final Integer[] ar, final int index) {
        return ar.length / 2 == index || ar[index] <= ar[index * 2 + 1] && ar[index] <= ar[index * 2 + 2] && isMaxHeaps(ar, index + 1);
    }

    /**
     * @param ar
     * @return
     */
    private boolean isMinHeap(final Integer[] ar) {
        //TODO CHECK
        return isMinHeaps(ar, 0);
    }
}
