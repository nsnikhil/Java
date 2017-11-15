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
            node.setLeftNode(insert(data,node.getLeftNode()));
        } else {

            node.setRightNode(insert(data,node.getRightNode()));
        }
        return node;
    }

    BstNode<I> remove(I data,BstNode<I> node) {
        if(!search(data,node)){
            throw new IllegalArgumentException("Invalid data");
        }
        return null;
    }

    boolean search(I data,BstNode<I> node) {
        if(node==null)return false;
        if(node.getData()==data){
            return true;
        }
        if((Integer)node.getData()>(Integer)data) {
            return search(data,node.getLeftNode());
        }
        return search(data,node.getRightNode());
    }

    I getMin(BstNode<I> node) {
        while (node.getLeftNode()!=null){
            node = node.getLeftNode();
        }
        return node.getData();
    }

    I getMax(BstNode<I> node) {
        while (node.getRightNode()!=null){
            node = node.getRightNode();
        }
        return node.getData();
    }

    int getHeight() {
        return Integer.MIN_VALUE;
    }

    int getDepth() {
        return Integer.MIN_VALUE;
    }

    I[] toArray() {
        return null;
    }

    I[] toInorder() {
        return null;
    }

    I[] toPreOrder() {
        return null;
    }

    I[] toPostOrder() {
        return null;
    }

    I[] toLevelOrder() {
        return null;
    }

    int getNoOfElements() {
        return Integer.MIN_VALUE;
    }

    boolean isLeafNode(I data) {
        return false;
    }

    void display(BstNode<I> node) {
        if(node==null)return;
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

    @Contract("null -> fail")
    private void nullCheck(BstNode<I> node) {
        if (node == null) {
            throw new NullPointerException("Tree is null");
        }
    }

}
