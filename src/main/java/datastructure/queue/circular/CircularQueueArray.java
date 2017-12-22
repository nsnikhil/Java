package datastructure.queue.circular;

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

    private int[] mQueue;
    private int mFront = -1, mRear = -1;

    CircularQueueArray(int size) {
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
    void enqueue(int data) {
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
    void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Empty");
            return;
        }
        ++mFront;
    }

    /**
     * @return returns the element from front of queue
     */
    public int getFront() {
        return mQueue[mFront];
    }

    /**
     * @return returns the element from rear of the queue
     */
    public int getRear() {
        return mQueue[mRear];
    }

    /**
     * @return true if queue is full else !true
     */
    boolean isFull() {
        return mFront == 0 && mRear == mQueue.length - 1 || mRear == mFront - 1;
    }

    /**
     * @return true if queue is empty else !true
     */
    boolean isEmpty() {
        return mRear == -1 && mFront == 1;
    }

    /**
     *
     * If queue if empty return -1
     * else if
     * if front < rear than search the queue linearly
     * else
     * search from front to end of queue and then from
     * start to rear
     * and if element if found return its index else -1
     *
     * @param data  the element to be searched
     * @return index of the element if found else -1
     */
    int search(int data) {
        if (isEmpty()) {
            System.out.println("Queue Empty");
            return -1;
        }
        if (mFront <= mRear) {
            for (int i = mFront; i <= mRear; i++)
                if (mQueue[i] == data)
                    return i;
        } else {
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

    /**
     * Displays the element of list
     *
     * if
     * front is less than rear than the element
     * has not been wrapped so display linearly
     * else
     * display from front to end of queue
     * and from 0 to rear
     */
    void display() {
        if (isEmpty()) {
            System.out.println("Queue Empty");
            return;
        }
        if (mFront <= mRear)
            for (int i = mFront; i <= mRear; i++)
                System.out.print(mQueue[i] + " ");
        else {
            for (int j = mFront, size = mQueue.length; j <= size - 1; j++)
                System.out.print(mQueue[j] + " ");
            for (int j = 0; j <= mRear; j++)
                System.out.print(mQueue[j] + " ");
        }
    }
}