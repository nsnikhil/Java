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

package datastructure.stack.linkedList;


import datastructure.linkedlist.LinkedList;

/**
 * The implementation of stack data structure.
 * Internally it uses linked list operations already defined
 * in linked list class to achieve stack functionality
 *
 * @param <T> Generics to be replaced with any object
 */
public class Stack<T> implements StackInterface<T> {

    private final LinkedList<T> mLinkedList;

    Stack() {
        mLinkedList = new LinkedList<>();
    }

    /**
     * @param data the element to be pushed into stack
     */
    @Override
    public final void push(final T data) {
        mLinkedList.insertFirst(data);
    }

    /**
     * @return the poped element from stack
     */
    @Override
    public final T pop() {
        final T data = mLinkedList.getFirst();
        mLinkedList.deleteFirst();
        return data;
    }

    /**
     * @return the first element from stack
     */
    @Override
    public final T peek() {
        return mLinkedList.getFirst();
    }

    /**
     * @return true if stack is empty else !true
     */
    @Override
    public final boolean empty() {
        return mLinkedList.isEmpty();
    }

    /**
     * @param data the element to be searched
     * @return index of the element if present else -1
     */
    @Override
    public final int search(final T data) {
        return mLinkedList.getItemPosition(data);
    }

    /**
     * displays the stack elements
     */
    @Override
    public final void display() {
        mLinkedList.display();
    }

    /**
     * @return the size of stack
     */
    @Override
    public final int size() {
        return mLinkedList.getSize();
    }

}