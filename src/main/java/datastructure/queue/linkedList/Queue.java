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

package datastructure.queue.linkedList;

import datastructure.linkedlist.LinkedList;

/**
 * The implementation of queue data structure.
 * Internally it uses linked list operations already defined
 * in linked list class to achieve queue functionality
 *
 * @param <T> Generics to be replaced with any object
 */
public class Queue<T> implements QueueInterface<T> {

    private final LinkedList<T> mLinkedList;

    public Queue() {
        mLinkedList = new LinkedList<>();
    }

    /**
     * @param data the data to be enqueued
     */
    @Override
    public final void enqueue(final T data) {
        mLinkedList.insertLast(data);
    }

    /**
     * @return the dequeued item
     */
    @Override
    public final T dequeue() {
        final T data = mLinkedList.getFirst();
        mLinkedList.deleteFirst();
        return data;
    }

    /**
     * @return returns the first item
     */
    @Override
    public final T peek() {
        return mLinkedList.getFirst();
    }

    /**
     * @return returns true if queue is empty else !true
     */
    @Override
    public final boolean empty() {
        return mLinkedList.isEmpty();
    }

    /**
     * @return the size of queue
     */
    @Override
    public final int size() {
        return mLinkedList.getSize();
    }

    /**
     * @param data the element to be searched
     * @return the position of the element
     */
    @Override
    public final int search(final T data) {
        return mLinkedList.getItemPosition(data);
    }

    /**
     * displays the queue elements
     */
    @Override
    public final void display() {
        mLinkedList.display();
    }
}
