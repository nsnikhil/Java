/*
 *    Copyright 2017 nsnikhil
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package datastructure.tree.bst;

import datastructure.queue.linkedList.Queue;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Tree traversal functions works if only Integer type Tree is used.
 *
 * @param <I>
 */
public class BinarySearchTree<I> {

    private BstNode<I> mBstNode;

    /**
     * Inserts a given element in tree
     *
     * @param data the element to be inserted
     */
    final void insert(final I data) {
        mBstNode = insert(mBstNode, new BstNode<>(data, null, null));
    }

    /**
     * Inserts a given element in tree
     *
     * @param node    the root node
     * @param newNode the node to be added
     * @return the root node with new node inserted
     */
    private BstNode<I> insert(BstNode<I> node, final BstNode<I> newNode) {
        if (node == null)
            node = newNode;
        else if ((Integer) node.getData() > (Integer) newNode.getData())
            node.setLeftNode(insert(node.getLeftNode(), newNode));
        else
            node.setRightNode(insert(node.getRightNode(), newNode));
        return node;
    }

    /**
     * Removes a given node from tree
     *
     * @param data the element to be removed
     */
    final void remove(final I data) {
        if (!search(data, mBstNode)) throw new IllegalArgumentException("Invalid data");
        mBstNode = remove(data, mBstNode);
    }

    /**
     * Removes a given node from tree
     * <p>
     * If a node with 0 child is to be deleted simply set the parent to point to null
     * <p>
     * If the node with one child is to be deleted set the parent to point to child for the node
     * to be deleted
     * <p>
     * If the node with two child is to be deleted find the min in its right sub tree copy the value
     * of the min to the node to be deleted and simply remove the duplicate node like deleting a node
     * with 0 or 1 child.Or we can also go for maximum in left subtree
     *
     * @param data the element to be deleted
     * @param node the root
     */
    @Contract("_, null -> null")
    private BstNode<I> remove(final I data, final BstNode<I> node) {
        if (node == null) return null;
        else if ((Integer) data < (Integer) node.getData()) node.setLeftNode(remove(data, node.getLeftNode()));
        else if ((Integer) data > (Integer) node.getData()) node.setRightNode(remove(data, node.getRightNode()));
        else {
            //No Child
            if (node.getLeftNode() == null && node.getRightNode() == null)
                return null;
                //Only One Right Child
            else if (node.getLeftNode() == null)
                return node.getRightNode();
                //Only one Left Child
            else if (node.getRightNode() == null)
                return node.getLeftNode();
                //Two children
            else {
                node.setData(getMinNode(node.getRightNode()).getData());
                node.setRightNode(remove(getMinNode(node.getRightNode()).getData(), node.getRightNode()));
            }
        }
        return node;
    }

    /**
     * Returns true if a given element is present in the tree
     *
     * @param data the element to be searched
     * @return true if element if found else !true
     */
    final boolean search(final I data) {
        return search(data, mBstNode);
    }

    /**
     * Returns true if a given element if present in the tree
     *
     * @param data the element to be searched
     * @param node the root
     * @return true if element if found else false
     */
    @Contract("_, null -> false")
    private boolean search(final I data, final BstNode<I> node) {
        if (node == null) return false;
        if (node.getData() == data)
            return true;
        if ((Integer) node.getData() > (Integer) data)
            return search(data, node.getLeftNode());
        return search(data, node.getRightNode());
    }

    /**
     * Returns the smallest element of the tree
     *
     * @return the smallest element of the tree
     */
    final I getMin() {
        return getMinNode().getData();
    }

    /**
     * Returns the largest element of the tree
     *
     * @return the largest element of the tree
     */
    final I getMax() {
        return getMaxNode().getData();
    }

    /**
     * @return The node with minimum value
     */
    private BstNode<I> getMinNode() {
        return getMinNode(mBstNode);
    }

    /**
     * @param node the root
     * @return the node with minimum value
     */
    private BstNode<I> getMinNode(@NotNull final BstNode<I> node) {
        if (node.getLeftNode() == null) return node;
        return getMinNode(node.getLeftNode());
    }


    /**
     * @return The node with maximum value
     */
    private BstNode<I> getMaxNode() {
        return getMaxNode(mBstNode);
    }

    /**
     * @param node  the root
     * @return The node with maximum value
     */
    private BstNode<I> getMaxNode(@NotNull final BstNode<I> node) {
        if (node.getRightNode() == null) return node;
        return getMaxNode(node.getRightNode());
    }

    /**
     * Returns the height of the tree
     *
     * @return height of the tree
     */
    final int getHeight() {
        return getHeight(mBstNode);
    }

    /**
     * Returns the height of the tree
     *
     * @param node  a node of the tree
     * @return height of a given node
     */
    private int getHeight(final BstNode<I> node) {
        if (node == null) return -1;
        return getMax(getHeight(node.getLeftNode()) + 1, getHeight(node.getRightNode()) + 1);
    }

    /**
     * @param a the first element
     * @param b the second element
     * @return the larger between first and second
     */
    @Contract(pure = true)
    private int getMax(final int a, final int b) {
        return a > b ? a : b;
    }

    /**
     * Returns the depth of the given value in tree
     *
     * @param data
     * @return depth of given element in tree
     */
    final int getDepth(final I data) {
        return getDepth(mBstNode, data);
    }

    /**
     * Returns the depth of the given value in tree
     *
     * @param root  the node from where depth is to be found
     * @param data  node whose depth is to be found
     * @return the depth of a element from a given node
     */
    private int getDepth(@NotNull final BstNode<I> root, final I data) {
        if (root.getData() == data) return 0;
        if ((Integer) data < (Integer) root.getData()) return 1 + getDepth(root.getLeftNode(), data);
        return 1 + getDepth(root.getRightNode(), data);
    }

    /**
     * Inorder returns a sorted array
     *
     * @return Inorder representation of the tree
     */
    @NotNull
    final Integer[] toInorder() {
        return toInorder(mBstNode, new ArrayList<>(getNoOfElements())).toArray(new Integer[getNoOfElements()]);
    }

    /**
     *
     * @param node
     * @param list
     * @return
     */
    @NotNull
    private List<Integer> toInorder(final BstNode<I> node, final List<Integer> list) {
        if (node == null) return list;
        toInorder(node.getLeftNode(), list);
        list.add((Integer) node.getData());
        toInorder(node.getRightNode(), list);
        return list;
    }

    /**
     *
     * @return
     */
    @NotNull
    final Integer[] toPreOrder() {
        return toPreOrder(mBstNode, new ArrayList<>(getNoOfElements())).toArray(new Integer[getNoOfElements()]);
    }

    /**
     *
     * @param node
     * @param list
     * @return
     */
    @NotNull
    private List<Integer> toPreOrder(final BstNode<I> node, final List<Integer> list) {
        if (node == null) return list;
        list.add((Integer) node.getData());
        toPreOrder(node.getLeftNode(), list);
        toPreOrder(node.getRightNode(), list);
        return list;
    }

    /**
     *
     * @return
     */
    @NotNull
    final Integer[] toPostOrder() {
        return toPostOrder(mBstNode, new ArrayList<>(getNoOfElements())).toArray(new Integer[getNoOfElements()]);
    }

    /**
     *
     * @param node
     * @param list
     * @return
     */
    @NotNull
    private List<Integer> toPostOrder(final BstNode<I> node, final List<Integer> list) {
        if (node == null) return list;
        toPostOrder(node.getLeftNode(), list);
        toPostOrder(node.getRightNode(), list);
        list.add((Integer) node.getData());
        return list;
    }

    /**
     *
     * @return
     */
    final Integer[] toLevelOrder() {
        if (!isComplete()) throw new IllegalArgumentException("Incomplete binary search tree");
        Queue<BstNode<I>> queue = new Queue<>();
        queue.enqueue(mBstNode);
        return toLevelOrder(mBstNode, new Integer[getNoOfElements()], 0, queue);
    }

    /**
     *
     * @param node
     * @param ar
     * @param index
     * @param queue
     * @return
     */
    private Integer[] toLevelOrder(final BstNode<I> node, final Integer[] ar, final int index, final Queue<BstNode<I>> queue) {
        if (node == null) return ar;
        ar[index] = (Integer) queue.peek().getData();
        if (queue.peek().getLeftNode() != null) queue.enqueue(queue.peek().getLeftNode());
        if (queue.peek().getRightNode() != null) queue.enqueue(queue.peek().getRightNode());
        queue.dequeue();
        if (queue.empty()) return ar;
        return toLevelOrder(queue.peek(), ar, index + 1, queue);
    }

    /**
     *
     * @param data
     * @return
     */
    final BstNode<I> getSuccessorInOrder(final I data) {
        return getSuccessorInOrder(mBstNode, getNodeFromData(data));
    }

    /**
     *
     * @param node
     * @param temp
     * @return
     */
    //TODO
    private BstNode<I> getSuccessorInOrder(final BstNode<I> node, final BstNode<I> temp) {
        //CHECK FOR RIGHT SUBTREE IF PRESENT RETURN MIN IN RIGHT SUB TREE ELSE
        //FIND DEEPEST ANCESTOR FOR WHICH CURRENT NODE IS IN LEFT SUBTREE
        return null;
    }

    /**
     *
     */
    final void balanceBst() {
        mBstNode = balanceBst(mBstNode);
    }


    /**
     *
     * @param node
     * @return
     */
    //TODO
    private BstNode<I> balanceBst(final BstNode<I> node) {
        /*
         * Algorithm :
         * Convert to array and the insert from mid and the
         * mid-1 and mid+1 until 0 and array length if reached
         */
        return null;
    }

    /**
     * @return true if tree is a complete binary search tree else !true
     */
    final boolean isComplete() {
        Queue<BstNode<I>> queue = new Queue<>();
        queue.enqueue(mBstNode);
        return isComplete(mBstNode, queue, new AtomicBoolean(false));
    }

    /**
     * Algorithm : Traverse the tree in level order manner
     * and once you encounter a non full node then following that
     * all nodes must be non full node
     * full node - one which has both left and right child
     *
     * @param node the root
     * @return true if tree is complete else !true
     */
    @Contract("null, _, _ -> true")
    private boolean isComplete(final BstNode<I> node, final Queue<BstNode<I>> queue, final AtomicBoolean isLeafNodeFlag) {
        if (node == null) return true;
        if (queue.peek().getLeftNode() != null) {
            if (isLeafNodeFlag.get()) return false;
            queue.enqueue(queue.peek().getLeftNode());
        } else
            isLeafNodeFlag.set(true);

        if (queue.peek().getRightNode() != null) {
            if (isLeafNodeFlag.get()) return false;
            queue.enqueue(queue.peek().getRightNode());
        } else
            isLeafNodeFlag.set(true);
        queue.dequeue();
        return queue.empty() || isComplete(queue.peek(), queue, isLeafNodeFlag);
    }

    /**
     * Returns no of elements in the tree
     *
     * @return Number of elements in the tree
     */
    final int getNoOfElements() {
        return getNoOfElements(mBstNode);
    }

    /**
     *
     * @param node
     * @return
     */
    private int getNoOfElements(final BstNode<I> node) {
        if (node == null) return 0;
        return 1 + getNoOfElements(node.getLeftNode()) + getNoOfElements(node.getRightNode());
    }


    /**
     *
     * @param data
     * @return
     */
    final boolean isLeafNode(final I data) {
        return isLeafNode(getNodeFromData(data));
    }

    /**
     *
     * @param node
     * @return
     */
    private boolean isLeafNode(@NotNull final BstNode<I> node) {
        return node.getLeftNode() == null && node.getRightNode() == null;
    }

    /**
     *
     * @return
     */
    @Contract(pure = true)
    final boolean isBinarySearchTree() {
        return isBinarySearchTree(mBstNode, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /**
     *
     * @param node
     * @param minRange
     * @param maxRange
     * @return
     */
    @Contract("null, _, _ -> true")
    private boolean isBinarySearchTree(BstNode<I> node, Integer minRange, Integer maxRange) {
        return node == null || (Integer) node.getData() <= minRange && (Integer) node.getData() > maxRange && isBinarySearchTree(node.getLeftNode(), minRange, (Integer) node.getData()) && isBinarySearchTree(node.getRightNode(), (Integer) node.getData(), maxRange);
    }

    /**
     *
     * @param data
     * @return
     */
    private BstNode<I> getNodeFromData(final I data) {
        return getNodeFromData(mBstNode, data);
    }

    /**
     * Search in the tree at which node does the value
     * given present and return that node.
     *
     * @param root the node(usually root)
     * @param data the element whose node you want to return
     * @return the node of the element
     */
    private BstNode<I> getNodeFromData(final BstNode<I> root, final I data) {
        if (!search(data, root)) throw new IllegalArgumentException("Invalid data");
        if (root.getData() == data) return root;
        if ((Integer) data <= (Integer) root.getData()) return getNodeFromData(root.getLeftNode(), data);
        return getNodeFromData(root.getRightNode(), data);
    }

    /**
     *
     */
    final void display() {
        display(mBstNode);
    }

    /**
     *
     * @param node
     */
    private void display(final BstNode<I> node) {
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