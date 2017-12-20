package datastructure.queue;

import datastructure.linkedlist.LinkedList;

/**
 * The implementation of queue data structure.
 * Internally it uses linked list operations already defined
 * in linked list class to achieve queue functionality
 *
 * @param <T> Generics to be replaced with any object
 */
public class Queue<T> {

    private LinkedList<T> mLinkedList;

    Queue() {
        mLinkedList = new LinkedList<>();
    }

    /**
     * @param data the data to be enqueued
     */
    public void enqueue(T data) {
        mLinkedList.insertLast(data);
    }

    /**
     * @return the dequeued item
     */
    public T dequeue(){
        T data = mLinkedList.getFirst();
        mLinkedList.deleteFirst();
        return data;
    }

    /**
     * @return returns the first item
     */
    public T peek(){
        return mLinkedList.getFirst();
    }

    /**
     * @return returns true if queue is empty else !true
     */
    public boolean empty(){
        return mLinkedList.isEmpty();
    }

    /**
     * @return the size of queue
     */
    public int size(){
        return mLinkedList.getSize();
    }

    /**
     * @param data the element to be searched
     * @return the position of the element
     */
    public int search(T data){
        return mLinkedList.getItemPosition(data);
    }

    /**
     * displays the queue elements
     */
    public void display(){
        mLinkedList.display();
    }
}
