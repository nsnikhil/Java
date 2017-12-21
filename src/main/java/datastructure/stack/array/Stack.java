package datastructure.stack.array;


import util.ArrayUtil;

/**
 * Implementation of stack using array
 */
class Stack {

    private int[] mStack;
    private int mTop = -1;

    Stack(int size) {
        mStack = new int[size];
    }

    /**
     * Check if the stack is full or not
     * if not full add the data to the next
     * position in stack
     *
     * @param data the data to be pushed into stack
     */
    void push(int data) {
        if (mTop >= mStack.length - 1) {
            System.out.println("Stack over flow");
            return;
        }
        mStack[++mTop] = data;
    }

    /**
     * Check if the stack is empty or not
     * if not empty set the top element to 0
     * and decrement the top
     */
    void pop() {
        if (mTop <= -1) {
            System.out.println("Stack under flow");
            return;
        }
        mStack[mTop] = 0;
        --mTop;
    }

    /**
     * Check if stack is empty or not
     * if not empty return the element
     * at top of stack
     *
     * @return the element at top of stack
     */
    int peek() {
        if (mTop <= -1) {
            System.out.println("Stack under flow");
            return -1;
        }
        return mStack[mTop];
    }

    /**
     * Check if stack is empty or not
     * if not empty search the stack for element
     * and return the position if found
     * else return -1
     *
     * @param data the data to be searched
     * @return position of data if found else -1
     */
    int search(int data) {
        if (mTop <= -1) {
            System.out.println("Stack under flow");
            return -1;
        }
        for (int i = 0, size = mStack.length; i < size; i++)
            if (mStack[i] == data)
                return i;
        return -1;
    }

    /**
     * @return true if stack is empty else !true
     */
    boolean isEmpty() {
        return mTop == -1;
    }

    boolean isFull() {
        return mTop >= mStack.length - 1;
    }

    /**
     * Check if stack is empty
     * if not display the stack
     * <p>
     * displays the stack
     */
    void display() {
        if (mTop <= -1) {
            System.out.println("Stack Empty");
            return;
        }
        ArrayUtil.printArray(mStack);
    }
}