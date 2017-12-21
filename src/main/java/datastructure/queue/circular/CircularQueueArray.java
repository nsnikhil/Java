package datastructure.queue.circular;

//TODO
public class CircularQueueArray {

    private int[] mQueue;
    private int mFront = -1, mRear = -1;

    CircularQueueArray(int size) {
        mQueue = new int[size];
    }

    void enqueue(int data) {
        if (isFull()) {
            System.out.print("Queue is full");
            return;
        }
        if (mFront == -1) mFront = 0;
        mRear = (mRear + 1) % mQueue.length;
        mQueue[mRear] = data;
    }

    void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Empty");
            return;
        }
        ++mFront;
    }

    public int getFront() {
        return mQueue[mFront];
    }

    public int getRear() {
        return mQueue[mRear];
    }

    boolean isFull() {
        return mRear == mFront - 1;
    }

    boolean isEmpty() {
        return mRear == -1 && mFront == 1;
    }

    int search(int data) {
        return -1;
    }

    void display() {
        if (isEmpty()) {
            System.out.println("Queue Empty");
            return;
        }
        for (int i = mFront; i <= mRear; i++)
            System.out.print(i + " ");
    }
}