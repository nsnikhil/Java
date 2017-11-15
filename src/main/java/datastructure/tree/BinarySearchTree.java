package datastructure.tree;

import org.jetbrains.annotations.Contract;

public class BinarySearchTree<I> {

    BstNode<I> insert(I data, BstNode<I> node) {
        BstNode<I> temp = new BstNode<>(data, null, null);
        if (node == null) {
            node = temp;
            return node;
        }
        if ((Integer) node.getData() > (Integer) data) {
            node.setLeftNode(insert(data, node.getLeftNode()));
        } else {

            node.setRightNode(insert(data, node.getRightNode()));
        }
        return node;
    }


    //TODO
    BstNode<I> remove(I data, BstNode<I> node) {
        if (!search(data, node)) {
            throw new IllegalArgumentException("Invalid data");
        }
        return node;
    }

    boolean search(I data, BstNode<I> node) {
        if (node == null) return false;
        if (node.getData() == data) {
            return true;
        }
        if ((Integer) node.getData() > (Integer) data) {
            return search(data, node.getLeftNode());
        }
        return search(data, node.getRightNode());
    }

    I getMin(BstNode<I> node) {
        while (node.getLeftNode() != null) {
            node = node.getLeftNode();
        }
        return node.getData();
    }

    I getMax(BstNode<I> node) {
        while (node.getRightNode() != null) {
            node = node.getRightNode();
        }
        return node.getData();
    }

    int getHeight(BstNode<I> node) {
        if (node == null) return 0;
        int left = 1 + getHeight(node.getLeftNode());
        int right = 1 + getHeight(node.getRightNode());
        return getMax(left, right);
    }

    @Contract(pure = true)
    private int getMax(int a, int b) {
        return a > b ? a : b;
    }

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

    int getNoOfElements(BstNode<I> node) {
        if (node == null) return 0;
        return 1 + getNoOfElements(node.getLeftNode()) + getNoOfElements(node.getRightNode());
    }


    boolean isLeafNode(BstNode<I> root, I data) {
        BstNode<I> node = getNodeFromData(root, data);
        return node.getLeftNode() == null && node.getRightNode() == null;
    }

    private BstNode<I> getNodeFromData(BstNode<I> root, I data) {
        if (!search(data, root)) {
            throw new IllegalArgumentException("Invalid data");
        }
        if (root.getData() == data) return root;
        if ((Integer) data <= (Integer) root.getData()) return getNodeFromData(root.getLeftNode(), data);
        return getNodeFromData(root.getRightNode(), data);
    }

    void display(BstNode<I> node) {
        if (node == null) return;
        System.out.print(node.getData() + " ");
        if (node.getLeftNode() != null) {
            System.out.print("/");
        }
        if (node.getRightNode() != null) {
            System.out.print("\\");
        }
        display(node.getLeftNode());
        display(node.getRightNode());
    }

}
