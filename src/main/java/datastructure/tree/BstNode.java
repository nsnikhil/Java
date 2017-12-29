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

    /**
     * @param data      the data part of the node
     * @param leftNode  the left link of the node
     * @param rightNode the right link of the node
     */
    BstNode(final T data, final BstNode<T> leftNode, final BstNode<T> rightNode) {
        this.mData = data;
        this.mLeftNode = leftNode;
        this.mRightNode = rightNode;
    }

    /**
     * @return data of the node
     */
    public T getData() {
        return mData;
    }

    /**
     * @param data the new data of the node
     */
    public void setData(final T data) {
        this.mData = data;
    }

    /**
     * @return left link of the node
     */
    public BstNode<T> getLeftNode() {
        return mLeftNode;
    }

    /**
     * @param leftNode new left link for the node
     */
    public void setLeftNode(final BstNode<T> leftNode) {
        this.mLeftNode = leftNode;
    }

    /**
     * @return right link of the node
     */
    public BstNode<T> getRightNode() {
        return mRightNode;
    }

    /**
     * @param rightNode new right link of the node
     */
    public void setRightNode(final BstNode<T> rightNode) {
        this.mRightNode = rightNode;
    }
}
