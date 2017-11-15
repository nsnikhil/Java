package datastructure.tree;

public class BstNode<T> {

    private T mData;
    private BstNode<T> mLeftNode,mRightNode;

    public BstNode(T data, BstNode<T> leftNode, BstNode<T> rightNode) {
        this.mData = data;
        this.mLeftNode = leftNode;
        this.mRightNode = rightNode;
    }

    public T getData() {
        return mData;
    }

    public void setData(T data) {
        this.mData = data;
    }

    public BstNode<T> getLeftNode() {
        return mLeftNode;
    }

    public void setLeftNode(BstNode<T> leftNode) {
        this.mLeftNode = leftNode;
    }

    public BstNode<T> getRightNode() {
        return mRightNode;
    }

    public void setRightNode(BstNode<T> rightNode) {
        this.mRightNode = rightNode;
    }
}
