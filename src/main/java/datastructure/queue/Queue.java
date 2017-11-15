package datastructure.queue;

import datastructure.linkedlist.LinkedList;

public class Queue<T> {

    private LinkedList<T> mLinkedList;

    public Queue() {
        mLinkedList = new LinkedList<>();
    }

    public boolean enqueue(T data){
        mLinkedList.insertLast(data);
        return false;
    }

    public T dequeue(){
        T data = mLinkedList.getFirst();
        mLinkedList.deleteFirst();
        return data;
    }

    public T peek(){
        return mLinkedList.getFirst();
    }

    public boolean empty(){
        return mLinkedList.isEmpty();
    }

    public int size(){
        return mLinkedList.getSize();
    }

    public int search(T data){
        return mLinkedList.getItemPosition(data);
    }

    public void display(){
        mLinkedList.display();
    }
}
