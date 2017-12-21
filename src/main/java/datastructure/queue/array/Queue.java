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

    int mFront = -1, mRear = -1;
    private int[] mQueue;

    Queue(int size) {
        mQueue = new int[size];
    }

    /**
     * check if the queue is full
     * else insert the value to the rear
     * of queue
     *
     * @param data the data to be inserted
     */
    void enqueue(int data) {
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
    void dequeue() {
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
    int getFront() {
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
    int getRear() {
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
    boolean isFull() {
        return mRear >= mQueue.length - 1;
    }

    /**
     * check if rear and front are -1
     * or
     * if front is greater than rear than its empty
     *
     * @return true if queue is empty else !true
     */
    boolean isEmpty() {
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
    int search(int data) {
        if (isEmpty()) {
            System.out.println("Queue Empty");
            return -1;
        }
        for (int i = mFront; i <= mRear; i++)
            if (mQueue[i] == data)
                return i;
        return -1;
    }

    /**
     * check if queue is empty
     * if not display the elements of queue
     */
    void display() {
        if (isEmpty()) {
            System.out.println("Queue Empty");
            return;
        }
        for (int i = mFront; i <= mRear; i++)
            System.out.print(mQueue[i] + " ");
    }
}