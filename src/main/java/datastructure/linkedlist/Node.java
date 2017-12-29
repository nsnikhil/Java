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

    /**
     * @param data the data part of the node
     * @param node the pointer to next node
     */
    Node(final T data, final Node<T> node) {
        mData = data;
        mNode = node;
    }

    /**
     * @return node
     */
    public Node<T> getNode() {
        return mNode;
    }

    /**
     * @param node new node
     */
    public void setNode(final Node<T> node) {
        this.mNode = node;
    }

    /**
     * @return data at the node
     */
    public T getData() {
        return mData;
    }

    /**
     * @param data the data of the node
     */
    public void setData(final T data) {
        this.mData = data;
    }
}