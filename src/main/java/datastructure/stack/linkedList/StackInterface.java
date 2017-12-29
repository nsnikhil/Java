package datastructure.stack.linkedList;

public interface StackInterface<T> {
    void push(final T data);

    T pop();

    T peek();

    boolean empty();

    int search(final T data);

    void display();

    int size();
}
