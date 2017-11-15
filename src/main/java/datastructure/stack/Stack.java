package datastructure.stack;


import datastructure.linkedlist.LinkedList;

public class Stack<T> {

    private LinkedList<T> mLinkedList;

    Stack(){
        mLinkedList = new LinkedList<>();
    }

    public T push(T data){
        mLinkedList.insertFirst(data);
        return data;
    }

    public T pop(){
        T  data = mLinkedList.getFirst();
        mLinkedList.deleteFirst();
        return data;
    }

    public T peek(){
        return mLinkedList.getFirst();
    }

    public boolean empty(){
        return mLinkedList.isEmpty();
    }

    public int search(T data){
        return mLinkedList.getItemPosition(data);
    }

    public void display(){
        mLinkedList.display();
    }

    public int size(){
        return mLinkedList.getSize();
    }

}
