package datastructure.linkedlist;

public class Node<T> {

    private T mData;
    private Node<T> mNode;

    Node(T data,Node<T> node){
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
