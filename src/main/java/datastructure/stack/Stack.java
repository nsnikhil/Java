package datastructure.stack;


import datastructure.linkedlist.LinkedList;

/**
 * The implementation of stack data structure.
 * Internally it uses linked list operations already defined
 * in linked list class to achieve stack functionality
 *
 * @param <T> Generics to be replaced with any object
 */
public class Stack<T> {

    private LinkedList<T> mLinkedList;

    Stack(){
        mLinkedList = new LinkedList<>();
    }

    /**
     * @param data the element to be pushed into stack
     */
    public void push(T data) {
        mLinkedList.insertFirst(data);
    }

    /**
     * @return the poped element from stack
     */
    public T pop(){
        T  data = mLinkedList.getFirst();
        mLinkedList.deleteFirst();
        return data;
    }

    /**
     * @return the first element from stack
     */
    public T peek(){
        return mLinkedList.getFirst();
    }

    /**
     * @return true if stack is empty else !true
     */
    public boolean empty(){
        return mLinkedList.isEmpty();
    }

    /**
     * @param data the element to be searched
     * @return index of the element if present else -1
     */
    public int search(T data){
        return mLinkedList.getItemPosition(data);
    }

    /**
     * displays the stack elements
     */
    public void display(){
        mLinkedList.display();
    }

    /**
     * @return the size of stack
     */
    public int size(){
        return mLinkedList.getSize();
    }

}