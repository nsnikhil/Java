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
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Implementation of binary search tree
 * <p>
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
        mBstNode = insert(mBstNode, createNewNode(data));
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
     * Inserts a given element in tree using avl insertion method
     * which ensures the tree is balanced
     *
     * @param node    the root
     * @param newNode the node to be inserted
     * @return the root with new node inserted and the tree balanced
     */
    private BstNode<I> insertAVL(final BstNode<I> node, final BstNode<I> newNode) {
        //TODO
        return null;
    }


    /**
     * Rotates the tree from a given node to the left
     *
     * @param node the node from where rotation has to take place
     * @return the node after left rotation
     */
    private BstNode<I> rotateLeft(final BstNode<I> node) {
        //TODO
        return null;
    }

    /**
     * Rotates the tree from a given node to the right
     *
     * @param node the node from where rotation has to take place
     * @return the node after right rotation
     */
    private BstNode<I> rotateRight(final BstNode<I> node) {
        //TODO
        return null;
    }

    /**
     * Returns the balance of given node
     * <p>
     * Balance is given by difference between the node's left and right sub tree
     * A node is said to be balanced if its balancing factor lies between -1 & 1
     *
     * @param node the node whose balance is to be found
     * @return the balancing factor of the node
     */
    private int getBalance(@NotNull final BstNode<I> node) {
        return getHeight(node.getLeftNode()) - getHeight(node.getRightNode());
    }

    /**
     * Returns a new node with the data provided
     *
     * @param data the data for the node
     * @return the new node
     */
    @NotNull
    private BstNode<I> createNewNode(final I data) {
        return new BstNode<>(data, null, null);
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
     * @return the node after deletion of element
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
     * Removes a given node from tree using AVL method to persis the tree balance
     * <p>
     * <p>
     * If a node with 0 child is to be deleted simply set the parent to point to null
     * <p>
     * If the node with one child is to be deleted set the parent to point to child for the node
     * to be deleted
     * <p>
     * If the node with two child is to be deleted find the min in its right sub tree copy the value
     * of the min to the node to be deleted and simply remove the duplicate node like deleting a node
     * with 0 or 1 child.Or we can also go for maximum in left subtree
     * <p>
     * Re-Balancing Algorithm is TODO
     *
     * @param data the element to be deleted
     * @param node the root
     * @return the node after deletion of element and after re-balancing the tree
     */
    private BstNode<I> removeAVL(final I data, final BstNode<I> node) {
        //TODO
        return null;
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
     * Returns the smallest node of the tree
     *
     * @return The node with minimum value
     */
    private BstNode<I> getMinNode() {
        return getMinNode(mBstNode);
    }

    /**
     * Returns the smallest node of the tree
     *
     * @param node the root
     * @return the node with minimum value
     */
    private BstNode<I> getMinNode(@NotNull final BstNode<I> node) {
        if (node.getLeftNode() == null) return node;
        return getMinNode(node.getLeftNode());
    }


    /**
     * Returns the largest node of the tree
     *
     * @return The node with maximum value
     */
    private BstNode<I> getMaxNode() {
        return getMaxNode(mBstNode);
    }

    /**
     * Returns the largest node of the tree
     *
     * @param node the root
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
     * @param node a node of the tree
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
     * @param data the element/node whose depth is to be found
     * @return depth of given element in tree
     */
    final int getDepth(final I data) {
        return getDepth(mBstNode, data);
    }

    /**
     * Returns the depth of the given value in tree
     *
     * @param root the node from where depth is to be found
     * @param data node whose depth is to be found
     * @return the depth of a element from a given node
     */
    private int getDepth(@NotNull final BstNode<I> root, final I data) {
        if (root.getData() == data) return 0;
        if ((Integer) data < (Integer) root.getData()) return 1 + getDepth(root.getLeftNode(), data);
        return 1 + getDepth(root.getRightNode(), data);
    }

    /**
     * Returns and array with element of tree traversed in In Order
     * <p>
     * Inorder returns a sorted array
     *
     * @return Inorder representation of the tree
     */
    @NotNull
    final Integer[] toInorder() {
        return toInorder(mBstNode, new ArrayList<>(getNoOfElements())).toArray(new Integer[getNoOfElements()]);
    }

    /**
     * Returns and array with element of tree traversed in In Order
     *
     * @param node the root
     * @param list the list
     * @return list with element of tree traversed in In Order
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
     * Returns and array with element of tree traversed in Pre Order
     *
     * @return Pre Order representation of the tree
     */
    @NotNull
    final Integer[] toPreOrder() {
        return toPreOrder(mBstNode, new ArrayList<>(getNoOfElements())).toArray(new Integer[getNoOfElements()]);
    }

    /**
     * Returns and array with element of tree traversed in Pre Order
     *
     * @param node the root
     * @param list the list
     * @return list with element of tree traversed in Pre Order
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
     * Returns and array with element of tree traversed in Post Order
     *
     * @return Post Order representation of the tree
     */
    @NotNull
    final Integer[] toPostOrder() {
        return toPostOrder(mBstNode, new ArrayList<>(getNoOfElements())).toArray(new Integer[getNoOfElements()]);
    }

    /**
     * Returns and array with element of tree traversed in Post Order
     *
     * @param node the root
     * @param list the list
     * @return list with element of tree traversed in Post Order
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
     * Returns and array with element of tree traversed in Level Order
     *
     * @return Level Order representation of the tree
     */
    final Integer[] toLevelOrder() {
        if (!isComplete()) throw new IllegalArgumentException("Incomplete binary search tree");
        final Queue<BstNode<I>> queue = new Queue<>();
        queue.enqueue(mBstNode);
        return toLevelOrder(mBstNode, new Integer[getNoOfElements()], 0, queue);
    }

    /**
     * Returns and array with element of tree traversed in Post Order
     *
     * @param node  the root
     * @param ar    the array
     * @param index starting index of array
     * @param queue the queue
     * @return array with element of tree traversed in Level Order
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
     * Returns and In Order Successor of a element/node
     * <p>
     * <p>
     * Algorithm :
     * If the node has right child/sub-tree then the
     * smallest element in right sub tree is the In Order Successor
     * else
     * If data in current node is less than ancestor than this ancestor
     * can be the successor, set the successor to be current node and go left
     * else traverse right. i.e. once you traverse left set the successor to the node
     * from where you traverse left and update it again if you ever traverse left
     * as that node will be the node that will not have been visited un-till all its
     * children are visited.
     *
     * @param data the node/element whose In Order successor is to be found
     * @return In Order successor of the node
     */
    @Nullable
    final I getSuccessorInOrder(final I data) {
        if (!search(data, mBstNode)) throw new IllegalArgumentException("Invalid data");
        if (getMax().equals(data)) {
            System.out.println(data + " has no successor as it is the last element");
            return null;
        }
        final BstNode<I> temp = getNodeFromData(data);
        if (temp.getRightNode() != null) return getMinNode(temp.getRightNode()).getData();
        return getSuccessorInOrder(mBstNode, data, null).getData();
    }

    /**
     * Returns and In Order Successor of a element/node
     *
     * @param node the root1
     * @param data the element whose successor is to be found
     * @return In Order successor of the node
     */
    private BstNode<I> getSuccessorInOrder(final BstNode<I> node, final I data, final BstNode<I> successor) {
        if (node == null || node.getData() == data) return successor;
        if ((Integer) data < (Integer) node.getData())
            return getSuccessorInOrder(node.getLeftNode(), data, node);
        else
            return getSuccessorInOrder(node.getRightNode(), data, successor);
    }

    /**
     * Balances the Binary Search Tree
     */
    final void balanceBst() {
        mBstNode = balanceBst(toInorder(mBstNode, new ArrayList<>(getNoOfElements())), 0, getNoOfElements() - 1);
    }


    /**
     * Balances the Binary Search Tree
     * <p>
     * Algorithm :
     * Traverse the tree in order to get a list which has all the
     * elements in sorted order and then insert the mid element of the list
     * and then for the left and right child recursively add from start to mid-1 and
     * from mid+1 to end
     * <p>
     * This method might not work is a tree is composed of type other than Integers
     *
     * @param list the root
     * @return a balanced bst
     */
    @Nullable
    @SuppressWarnings("unchecked")
    private BstNode<I> balanceBst(final List<Integer> list, int start, int end) {
        if (start > end) return null;
        final int mid = (start + end) / 2;
        final BstNode<I> temp = createNewNode((I) list.get(mid));
        temp.setLeftNode(balanceBst(list, start, mid - 1));
        temp.setRightNode(balanceBst(list, mid + 1, end));
        return temp;
    }

    /**
     * Returns true if the tree is complete
     *
     * @return true if tree is a complete binary search tree else !true
     */
    final boolean isComplete() {
        final Queue<BstNode<I>> queue = new Queue<>();
        queue.enqueue(mBstNode);
        return isComplete(mBstNode, queue, new AtomicBoolean(false));
    }

    /**
     * Returns true if a tree from a given node is complete
     * <p>
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
     * Returns true of tree is balanced
     *
     * @return true if the tree is balanced else !true
     */
    final boolean isBalanced() {
        return isBalanced(mBstNode);
    }

    /**
     * Returns true if the tree from a given node is balanced
     * <p>
     * Algorithm :
     * A empty tree is balanced
     * A non empty tree is balanced if
     * Left sub tree is balanced &
     * Right sub tree us balanced &
     * The diff between height of left and right sub tree is not more than 1
     *
     * @param node the node
     * @return true if the tree is balanced else !true
     */
    @Contract("null -> true")
    private boolean isBalanced(final BstNode<I> node) {
        return node == null || Math.abs(getHeight(node.getLeftNode()) - getHeight(node.getRightNode())) <= 1 && isBalanced(node.getLeftNode()) && isBalanced(node.getRightNode());
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
     * @param node the node
     * @return no of elements linked from the node
     */
    private int getNoOfElements(final BstNode<I> node) {
        if (node == null) return 0;
        return 1 + getNoOfElements(node.getLeftNode()) + getNoOfElements(node.getRightNode());
    }


    /**
     * @param data the node
     * @return true if node is a leaf node else !true
     */
    final boolean isLeafNode(final I data) {
        return isLeafNode(getNodeFromData(data));
    }

    /**
     * @param node the node
     * @return true if node is a leaf node else !true
     */
    private boolean isLeafNode(@NotNull final BstNode<I> node) {
        return node.getLeftNode() == null && node.getRightNode() == null;
    }

    /**
     * @return true if a given tree is a binary search tree else !true
     */
    @Contract(pure = true)
    final boolean isBinarySearchTree() {
        return isBinarySearchTree(mBstNode, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /**
     * Algorithm :
     * The data in a node must me in a range, for root its the Max and Min.
     * and for the left subtree the range is between Min and Root
     * and for right subtree the range is between Root and Max.
     * If these condition satisfy then the given tree is a bst
     *
     * @param node     the node
     * @param minRange the min range
     * @param maxRange the max range
     * @return true if a given tree is a binary search tree else !true
     */
    @Contract("null, _, _ -> true")
    private boolean isBinarySearchTree(BstNode<I> node, Integer minRange, Integer maxRange) {
        return node == null || (Integer) node.getData() < minRange && (Integer) node.getData() > maxRange && isBinarySearchTree(node.getLeftNode(), minRange, (Integer) node.getData()) && isBinarySearchTree(node.getRightNode(), (Integer) node.getData(), maxRange);
    }

    /**
     * @param data the element/data
     * @return the node which contains the data
     */
    private BstNode<I> getNodeFromData(final I data) {
        if (!search(data, mBstNode)) throw new IllegalArgumentException("Invalid data");
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
    private BstNode<I> getNodeFromData(@NotNull final BstNode<I> root, final I data) {
        if (root.getData() == data) return root;
        if ((Integer) data <= (Integer) root.getData()) return getNodeFromData(root.getLeftNode(), data);
        return getNodeFromData(root.getRightNode(), data);
    }

    /**
     * Displays the tree
     */
    final void display() {
        display(mBstNode);
    }

    /**
     * Displays the tree from given node
     *
     * @param node the node
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