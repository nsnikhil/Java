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

package datastructure.stack.array;


import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import util.ArrayUtil;

/**
 * Implementation of stack using array
 */
class Stack {

    private final Integer[] mStack;
    private int mTop = -1;

    Stack(final int size) {
        mStack = new Integer[size];
    }

    /**
     * Check if the stack is full or not
     * if not full add the data to the next
     * position in stack
     *
     * @param data the data to be pushed into stack
     */
    final void push(final Integer data) {
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
    final void pop() {
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
    final Integer peek() {
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
    final Integer search(final Integer data) {
        if (mTop <= -1) {
            System.out.println("Stack under flow");
            return -1;
        }
        return search(mStack, data, 0);
    }

    /**
     * @param stack
     * @param data
     * @param index
     * @return
     */
    private Integer search(@NotNull final Integer[] stack, final Integer data, final Integer index) {
        if (stack.length == index) return -1;
        if (stack[index].equals(data)) return index;
        return search(stack, data, index + 1);
    }

    /**
     * @return true if stack is empty else !true
     */
    @Contract(pure = true)
    final boolean isEmpty() {
        return mTop == -1;
    }

    @Contract(pure = true)
    final boolean isFull() {
        return mTop >= mStack.length - 1;
    }

    /**
     * Check if stack is empty
     * if not display the stack
     * <p>
     * displays the stack
     */
    final void display() {
        if (mTop <= -1) {
            System.out.println("Stack Empty");
            return;
        }
        ArrayUtil.printArray(mStack);
    }
}