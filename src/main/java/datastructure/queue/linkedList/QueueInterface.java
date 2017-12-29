package datastructure.queue.linkedList;

/**
 * @param <T>
 * @author Nikhil Soni
 * @version 1.0
 * @since 29-12-2017
 */
public interface QueueInterface<T> {
    void enqueue(final T data);

    T dequeue();

    T peek();

    boolean empty();

    int size();

    int search(final T data);

    void display();
}
