package datastructure.tree;

import org.jetbrains.annotations.Contract;

public class BinarySearchTree<I> {

    /**
     * If root node is null assign the new node to root
     * else find the data node is greater or smaller tha one given
     * if smaller recursively find the position in left side where the
     * data can be inserted else if data is greater do the same for right side
     * of the node.
     *
     * @param data the value to be inserted
     * @param node the node to be inserted on(generally root node)
     * @return the node after insertion is complete
     */
    BstNode<I> insert(I data, BstNode<I> node) {
        BstNode<I> temp = new BstNode<>(data, null, null);
        if (node == null) {
            node = temp;
            return node;
        }
        if ((Integer) node.getData() > (Integer) data)
            node.setLeftNode(insert(data, node.getLeftNode()));
        else
            node.setRightNode(insert(data, node.getRightNode()));
        return node;
    }

    //TODO
    BstNode<I> remove(I data, BstNode<I> node) {
        if (!search(data, node)) throw new IllegalArgumentException("Invalid data");
        return node;
    }

    /**
     * if node is null return false as nothing can't have anything
     * if node data equals data given return true
     * else if data is smaller than node element
     * recursively search the right sub tree
     * else recursively search the right sub tree
     *
     * @param data the element to be searched
     * @param node the node on which element is to be searched(generally the root node)
     * @return true if element is found else !true
     */
    boolean search(I data, BstNode<I> node) {
        if (node == null) return false;
        if (node.getData() == data)
            return true;
        if ((Integer) node.getData() > (Integer) data)
            return search(data, node.getLeftNode());
        return search(data, node.getRightNode());
    }

    /**
     *
     * Reach the left most node
     * and return the value at that node
     *
     * @param node  the node to be searched in
     * @return the smallest element of the tree
     */
    I getMin(BstNode<I> node) {
        while (node.getLeftNode() != null)
            node = node.getLeftNode();
        return node.getData();
    }

    /**
     * Reach the right most node
     * and return the value at that node
     *
     * @param node  the node to be searched in
     * @return the largest element of the tree
     */
    I getMax(BstNode<I> node) {
        while (node.getRightNode() != null)
            node = node.getRightNode();
        return node.getData();
    }

    /**
     *
     * the length of longest branch from node is the height
     * of the node
     *
     * @param node  the node whose height is to be found
     * @return the height of that node
     */
    int getHeight(BstNode<I> node) {
        if (node == null) return 0;
        int left = 1 + getHeight(node.getLeftNode());
        int right = 1 + getHeight(node.getRightNode());
        return getMax(left, right);
    }

    /**
     * @param a the first element
     * @param b the second element
     * @return the larger between first and second
     */
    @Contract(pure = true)
    private int getMax(int a, int b) {
        return a > b ? a : b;
    }

    /**
     *
     * The depth of a node is its height from the
     * tree root.
     *
     * @param root  the node
     * @param data  the element whose depth is to be found
     * @return the depth of the element in the node
     */
    int getDepth(BstNode<I> root, I data) {
        if (root.getData() == data) return 1;
        if ((Integer) data < (Integer) root.getData()) return 1 + getDepth(root.getLeftNode(), data);
        return 1 + getDepth(root.getRightNode(), data);
    }

    //TODO
    I[] toArray(BstNode<I> node) {
        if (!isComplete(node)) throw new IllegalArgumentException("Incomplete binary search tree");
        return null;
    }

    //TODO
    I[] toInorder(BstNode<I> node) {
        if (!isComplete(node)) throw new IllegalArgumentException("Incomplete binary search tree");
        return null;
    }

    //TODO
    I[] toPreOrder(BstNode<I> node) {
        if (!isComplete(node)) throw new IllegalArgumentException("Incomplete binary search tree");
        return null;
    }

    //TODO
    I[] toPostOrder(BstNode<I> node) {
        if (!isComplete(node)) throw new IllegalArgumentException("Incomplete binary search tree");
        return null;
    }

    //TODO
    I[] toLevelOrder(BstNode<I> node) {
        if (!isComplete(node)) throw new IllegalArgumentException("Incomplete binary search tree");
        return null;
    }

    //TODO
    boolean isComplete(BstNode<I> root) {
        if (root == null) return true;
        if (!isLeafNode(root, root.getData())) {
            if (root.getLeftNode() == null && root.getRightNode() != null) {
                return false;
            }
        }
        return isComplete(root.getLeftNode()) && isComplete(root.getRightNode());
    }

    /**
     *
     * add 1 until all the elements of the node has been
     * visited
     *
     * @param node  the node(usually root)
     * @return the no of element in that node
     */
    int getNoOfElements(BstNode<I> node) {
        if (node == null) return 0;
        return 1 + getNoOfElements(node.getLeftNode()) + getNoOfElements(node.getRightNode());
    }

    /**
     *
     * If the nodes has no left and right child its a root node
     *
     * @param root  the node(usually root)
     * @param data  the element to be checked
     * @return true if element is at leaf else !true
     */
    boolean isLeafNode(BstNode<I> root, I data) {
        BstNode<I> node = getNodeFromData(root, data);
        return node.getLeftNode() == null && node.getRightNode() == null;
    }

    /**
     *
     * Search in the tree at which node does the value
     * given present and return that node.
     *
     * @param root  the node(usually root)
     * @param data  the element whose node you want to return
     * @return the node of the element
     */
    private BstNode<I> getNodeFromData(BstNode<I> root, I data) {
        if (!search(data, root)) throw new IllegalArgumentException("Invalid data");
        if (root.getData() == data) return root;
        if ((Integer) data <= (Integer) root.getData()) return getNodeFromData(root.getLeftNode(), data);
        return getNodeFromData(root.getRightNode(), data);
    }

    /**
     * @param node  the tree you want to display
     */
    void display(BstNode<I> node) {
        if (node == null) return;
        System.out.print(node.getData() + " ");
        if (node.getLeftNode() != null)
            System.out.print("/");
        if (node.getRightNode() != null)
            System.out.print("\\");
        display(node.getLeftNode());
        display(node.getRightNode());
    }
}