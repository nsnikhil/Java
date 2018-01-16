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

public final class HeapActions {

    /**
     * Algorithm :
     * We can insert Integer.MIN_VALUE and the call
     * increase value with new value
     *
     * @param ar
     * @param value
     */
    public final void insertIntoMaxHeap(final Integer ar[], Integer value) {

    }

    /**
     * Algorithm :
     * We can insert Integer.MAX_VALUE and the call
     * decrease value with new value
     *
     * @param ar
     * @param value
     */
    public final void insertIntoMinHeap(final Integer ar[], Integer value) {

    }


    /**
     * Max heapifies a given array/tree
     * <p>
     * Since the node staring from (n/2)+1 to n are all leaf node
     * so we need to apply max heapify on nodes from n/2 to 1
     *
     * @param ar the array to max heapify
     */
    final void maxHeapify(final Integer[] ar) {

    }

    /**
     * Min heapifies a given array/tree
     * <p>
     * Since the node staring from (n/2)+1 to n are all leaf node
     * so we need to apply min heapify on nodes from n/2 to 1
     *
     * @param ar the array to min heapify
     */
    final void minHeapify(final Integer[] ar) {

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
    private void maxHeapify(final Integer[] ar, final int index) {

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
    private void minHeapify(final Integer[] ar, final int index) {

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
    public final void deleteMax(final Integer[] ar) {

    }

    /**
     * @param ar
     */
    public final void deleteMin(final Integer[] ar) {

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
    public final void increaseValueMaxHeap(final Integer[] ar, final int index, final int newVal) {

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
    public final void decreaseValueMaxHeap(final Integer[] ar, final int index, final int newVal) {

    }

    /**
     * For Max heap only
     * Algorithm :
     * Set the new value and call min heapify from the
     * node with new value
     *
     * @param ar
     * @param index
     * @param newVal
     */
    public final void increaseeValueMinHeap(final Integer[] ar, final int index, final int newVal) {

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
    public final void decreaseValueMinHeap(final Integer[] ar, final int index, final int newVal) {

    }

    private boolean isMaxHeap(final Integer[] ar) {
        return false;
    }

    private boolean isMinHeap(final Integer[] ar) {
        return false;
    }
}
