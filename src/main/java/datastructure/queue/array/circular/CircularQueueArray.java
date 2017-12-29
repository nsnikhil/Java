package datastructure.queue.array.circular;

import org.jetbrains.annotations.Contract;

/**
 * Implementation of circular queue using array
 * <p>
 * SEARCH FUNCTION MIGHT BE INCORRECT
 * <p>
 * A circular queue overcomes the shortcoming of regular
 * structure where if a element at position is dequeued
 * it cannot be used again, it overcomes this by linking
 * the first and last index, if an element is bo added and
 * the queue if full it checks from start if index is available
 * and it inserts over their
 * <p>
 * Eg -> size = 5
 * <p>
 * Add -> 2,3,4,5,6
 * <p>
 * now dequeue 2 time
 * <p>
 * we have -> x,x,4,5,6
 * <p>
 * in regular queue we can't use the x position
 * but here if want to add two new elements like 7,8
 * we can do it and queue finally becomes 7,8,4,5,6
 * <p>
 * where front = 4 and rear = 8.
 */
public class CircularQueueArray {

    private final int[] mQueue;
    private int mFront = -1, mRear = -1;

    CircularQueueArray(final int size) {
        mQueue = new int[size];
    }

    /**
     * Check if the queue is full
     * if not full insert into (rear + 1) % size
     * (rear + 1) % size will give the index until
     * last and will start again from beginning once
     * end is reached.
     * <p>
     * Eg if size if 5 it will insert until index 4
     * and then to index 0 if it has been dequeued
     *
     * @param data the value to be enqueued
     */
    final void enqueue(final int data) {
        if (isFull()) {
            System.out.print("Queue is full");
            return;
        }
        if (mFront == -1) mFront = 0;
        mRear = (mRear + 1) % mQueue.length;
        mQueue[mRear] = data;
    }

    /**
     * Increments the front to point ot next index
     */
    final void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Empty");
            return;
        }
        ++mFront;
    }

    /**
     * @return returns the element from front of queue
     */
    @Contract(pure = true)
    public final int getFront() {
        return mQueue[mFront];
    }

    /**
     * @return returns the element from rear of the queue
     */
    @Contract(pure = true)
    public final int getRear() {
        return mQueue[mRear];
    }

    /**
     * @return true if queue is full else !true
     */
    @Contract(pure = true)
    final boolean isFull() {
        return mFront == 0 && mRear == mQueue.length - 1 || mRear == mFront - 1;
    }

    /**
     * @return true if queue is empty else !true
     */
    @Contract(pure = true)
    final boolean isEmpty() {
        return mRear == -1 && mFront == 1;
    }

    /**
     * If queue if empty return -1
     * else if
     * if front < rear than search the queue linearly
     * else
     * search from front to end of queue and then from
     * start to rear
     * and if element if found return its index else -1
     *
     * @param data the element to be searched
     * @return index of the element if found else -1
     */
    final int search(final int data) {
        if (isEmpty()) {
            System.out.println("Queue Empty");
            return -1;
        }
        if (mFront <= mRear)
            return search(mFront, mRear, mQueue, data);
        else {
            //TODO
            int counter = 0;
            for (int j = mFront, size = mQueue.length; j <= size - 1; j++, counter++)
                if (mQueue[j] == data)
                    return counter;
            for (int j = 0; j <= mRear; j++, counter++)
                if (mQueue[j] == data)
                    return counter;
        }
        return -1;
    }

    private int search(int index, final int rear, final int queue[], final int data) {
        if (rear < index) return -1;
        if (queue[index] == data) return index;
        return search(++index, rear, queue, data);
    }

    /**
     * Displays the element of list
     * <p>
     * if
     * front is less than rear than the element
     * has not been wrapped so display linearly
     * else
     * display from front to end of queue
     * and from 0 to rear
     */
    final void display() {
        if (isEmpty()) {
            System.out.println("Queue Empty");
            return;
        }
        if (mFront <= mRear)
            display(mFront, mRear, mQueue);
        else {
            display(mFront, mQueue.length - 1, mQueue);
            display(0, mRear, mQueue);
        }
    }

    private void display(int index, final int rear, final int[] queue) {
        if (rear < index) return;
        System.out.print(queue[index] + " ");
        display(++index, rear, queue);
    }
}