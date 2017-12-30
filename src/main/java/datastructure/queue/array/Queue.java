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

package datastructure.queue.array;

import org.jetbrains.annotations.Contract;

/**
 * Implementation of queue using array
 * <p>
 * <p>
 * Insertion happens from rear and deletion from front
 * <p>
 * so if you want to enqueue insert into rear+1
 * and to dequeue increment front
 * the value of front to rear represents
 * the start and end of queue in array.
 * <p>
 * Eg : -> 0,0,5,6,8
 * <p>
 * here front = 2 and rear  = 4
 */
public class Queue {

    private final int[] mQueue;
    private int mFront = -1, mRear = -1;

    Queue(final int size) {
        mQueue = new int[size];
    }

    /**
     * check if the queue is full
     * else insert the value to the rear
     * of queue
     *
     * @param data the data to be inserted
     */
    final void enqueue(final int data) {
        if (isFull()) {
            System.out.println("Queue Full");
            return;
        }
        if (mFront == -1) mFront = 0;
        mQueue[++mRear] = data;
    }

    /**
     * check if queue is empty
     * else increment the front
     */
    final void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Empty");
            return;
        }
        ++mFront;
    }

    /**
     * check if queue is empty
     * if not return the element at front
     *
     * @return element at front of queue if not empty else -1
     */
    final int getFront() {
        if (isEmpty()) {
            System.out.println("Queue Empty");
            return -1;
        }
        return mQueue[mFront];
    }

    /**
     * check if queue is empty
     * if not return element at rear of queue
     *
     * @return element at rear of queue if not empty else -1
     */
    final int getRear() {
        if (isEmpty()) {
            System.out.println("Queue Empty");
            return -1;
        }
        return mQueue[mRear];
    }

    /**
     * @return true if queue if full else !true
     */
    @Contract(pure = true)
    final boolean isFull() {
        return mRear >= mQueue.length - 1;
    }

    /**
     * check if rear and front are -1
     * or
     * if front is greater than rear than its empty
     *
     * @return true if queue is empty else !true
     */
    @Contract(pure = true)
    final boolean isEmpty() {
        return mRear == -1 && mFront == -1 || mFront > mRear;
    }

    /**
     * check if queue is empty
     * if not search the data in the queue
     * if found return its index
     * else return -1
     *
     * @param data the element to be searched
     * @return the index of element if found else -1
     */
    final int search(final int data) {
        if (isEmpty()) {
            System.out.println("Queue Empty");
            return -1;
        }
        return search(mRear, mQueue, mFront, data);
    }

    private int search(final int rear, final int[] queue, int index, final int data) {
        if (rear < index) return -1;
        if (queue[index] == data) return index;
        return search(rear, queue, ++index, data);
    }

    /**
     * check if queue is empty
     * if not display the elements of queue
     */
    final void display() {
        if (isEmpty()) {
            System.out.println("Queue Empty");
            return;
        }
        display(mRear, mQueue, mFront);
    }

    private void display(final int rear, final int queue[], int index) {
        if (rear < index) return;
        System.out.print(queue[index] + " ");
        display(rear, queue, ++index);
    }
}