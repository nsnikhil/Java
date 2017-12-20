package datastructure.linkedlist;

/**
 * The building block of linked list
 * where the mData is the item to stored
 * in list and mNode is pointer to next node.
 *
 * @param <T> generic to be replaced by any object
 */
public class Node<T> {

    private T mData;
    private Node<T> mNode;

    Node(T data, Node<T> node) {
        mData = data;
        mNode = node;
    }

    public void setNode(Node<T> node) {
        this.mNode = node;
    }

    public void setData(T data) {
        this.mData = data;
    }

    public Node<T> getNode() {
        return mNode;
    }

    public T getData() {
        return mData;
    }
}
