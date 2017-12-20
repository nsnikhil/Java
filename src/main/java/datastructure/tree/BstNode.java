package datastructure.tree;

/**
 * the building block of binary search tree
 * where mData is the value of node and
 * mLeftNode & mRightNode are the left and right
 * branches of the node respectively.
 *
 * @param <T> Generic to be replaced by any object
 */
class BstNode<T> {

    private T mData;
    private BstNode<T> mLeftNode,mRightNode;

    BstNode(T data, BstNode<T> leftNode, BstNode<T> rightNode) {
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
