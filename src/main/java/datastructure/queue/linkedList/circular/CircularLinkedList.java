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

package datastructure.queue.linkedList.circular;

import datastructure.linkedlist.Node;
import org.jetbrains.annotations.NotNull;

/**
 * Custom linked list implementation for circular queue
 *
 * @param <T>
 */
public class CircularLinkedList<T> {

    private Node<T> mRoot;
    private int mQueueSize = 0;

    /**
     * Inserts an element at the end of the queue
     * <p>
     * Check if root is null
     * if null
     * assign root to new new node and
     * then set the new node to point to root and
     * finally increment the size counter
     * else
     * traverse till the last node and set the
     * last node to new node and then set the
     * new node to point ot first node and then
     * increment the pointer
     *
     * @param data the element to be inserted
     */
    public void insertLast(final T data) {
        final Node<T> temp = new Node<>(data, null);
        if (mRoot == null) {
            mRoot = temp;
            temp.setNode(mRoot);
            ++mQueueSize;
            return;
        }
        insertLast(temp, mRoot, 0, mQueueSize);
    }

    /**
     * Inserts the element at the end of queue if root is not null
     * <p>
     * Recursively traverse till the end of list and the set the
     * end to point to new node and then set the new node to point
     * to root and then increment the size by 1
     *
     * @param newNode the node to be inserted
     * @param node    the root node
     * @param index   the starting point
     * @param size    the size of the queue
     */
    private void insertLast(@NotNull final Node<T> newNode, @NotNull final Node<T> node, final int index, final int size) {
        if (index == size - 1) {
            node.setNode(newNode);
            newNode.setNode(mRoot);
            ++mQueueSize;
            return;
        }
        insertLast(newNode, node.getNode(), index + 1, size);
    }

    /**
     * Deletes the element from front of the queue
     * <p>
     * if queue size is 0 then return
     * if queue size if 1 then set the
     * root to null and set size to 0
     * else
     * decrement the queue size and
     * point the root to the following node
     */
    public void deleteFirst() {
        if (mQueueSize == 0) return;
        if (mQueueSize == 1) {
            mRoot = null;
            mQueueSize = 0;
            return;
        }
        mRoot = mRoot.getNode();
        --mQueueSize;
    }

    /**
     * Returns the first element of the queue
     *
     * @return the first element of the queue
     */
    T getFirst() {
        nullCheck();
        return mRoot.getData();
    }

    /**
     * Returns true if queue is empty
     *
     * @return true if queue is empty else !true
     */
    boolean isEmpty() {
        return mQueueSize == 0;
    }

    /**
     * Search a specific item
     * <p>
     * iterate till end comparing each item and return true as soon
     * as you find the item
     *
     * @param data the item to be searched
     * @return true if item is present else !true
     */
    private boolean searchByItem(final T data) {
        nullCheck();
        return searchByItem(mRoot, data, 0, mQueueSize);
    }

    /**
     * Search the queue for the element and returns true if element is found
     *
     * @param node  the root
     * @param data  the element to be searched
     * @param index the starting point
     * @param size  the size of queue
     * @return true if element is found else !true
     */
    private boolean searchByItem(final Node<T> node, final T data, final int index, final int size) {
        return index != size && (node.getData() == data || searchByItem(node.getNode(), data, index + 1, size));
    }

    /**
     * Returns the position of given element else -1
     *
     * @param data the element whose position is desired
     * @return elements position if present else -1
     */
    int getItemPosition(final T data) {
        nullCheck();
        if (!searchByItem(data)) return -1;
        return getItemPosition(data, mRoot);
    }

    /**
     * Returns the position of given element else -1
     *
     * @param data the element whose position is desired
     * @param node the root
     * @return elements position if present else -1
     */
    private int getItemPosition(final T data, @NotNull final Node<T> node) {
        if (node.getData() == data) return 0;
        return 1 + getItemPosition(data, node.getNode());
    }

    /**
     * Returns the size of queue
     *
     * @return the size of queue
     */
    public int getSize() {
        return this.mQueueSize;
    }

    /**
     * Displays all the element of queue
     */
    public void display() {
        if (mRoot == null) return;
        display(0, mQueueSize, mRoot);
    }

    /**
     * Displays all the element of queue
     *
     * @param index the starting point
     * @param size  the size of queue
     * @param node  the root
     */
    private void display(final int index, final int size, final Node<T> node) {
        if (index == size) return;
        System.out.print(node.getData() + " ");
        display(index + 1, size, node.getNode());
    }

    /**
     * throw a null pointer exception if list is null
     */
    private void nullCheck() {
        if (mRoot == null) throw new NullPointerException("List is null");
    }
}
