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

import datastructure.queue.linkedList.QueueInterface;

/**
 * Implementation of circular queue using Linked List
 * <p>
 * Here the last node contains a pointer to first node
 * not null like in general linked list
 *
 * @author Nikhil Soni
 * @version 1.0
 * @since 29-12-2017
 */
public class CircularQueue<T> implements QueueInterface<T> {

    private final CircularLinkedList<T> mLinkedList;

    CircularQueue() {
        mLinkedList = new CircularLinkedList<>();
    }

    /**
     * Enqueue an element in the queue
     * <p>
     * Check if the queue if empty or not
     * if empty
     * add the new node in the list
     * and assign the root to new node
     * else
     * add the new node to end and set the
     * node to point to head
     *
     * @param data the element to be inserted in queue
     */
    @Override
    public final void enqueue(final T data) {
        mLinkedList.insertLast(data);
    }

    /**
     * Dequeue an element from queue
     * <p>
     * Remove the element from start of the queue
     *
     * @return the element dequeued from the list
     */
    @Override
    public final T dequeue() {
        T data = mLinkedList.getFirst();
        mLinkedList.deleteFirst();
        return data;
    }

    /**
     * Returns the first element of the queue
     *
     * @return the first element of the queue
     */
    @Override
    public final T peek() {
        return mLinkedList.getFirst();
    }

    /**
     * @return true if the queue if empty else !true
     */
    @Override
    public final boolean empty() {
        return mLinkedList.isEmpty();
    }


    /**
     * Returns the size of queue
     *
     * @return the size of queue
     */
    @Override
    public final int size() {
        return mLinkedList.getSize();
    }

    /**
     * Search an element in the queue
     *
     * @param data the element to be searched
     * @return the index of the element in the list if found else -1
     */
    @Override
    public final int search(T data) {
        return mLinkedList.getItemPosition(data);
    }

    /**
     * displays the queue
     */
    @Override
    public final void display() {
        mLinkedList.display();
    }
}