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

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BinarySearchTree<I> {

    private BstNode<I> mBstNode;

    final void insert(final I data) {
        mBstNode = insert(mBstNode, new BstNode<>(data, null, null));
    }

    private BstNode<I> insert(BstNode<I> node, final BstNode<I> newNode) {
        if (node == null) {
            node = newNode;
            return node;
        }
        if ((Integer) node.getData() > (Integer) newNode.getData())
            node.setLeftNode(insert(node.getLeftNode(), newNode));
        else
            node.setRightNode(insert(node.getRightNode(), newNode));
        return node;
    }

    final void remove(final I data) {
        remove(data, mBstNode);
    }

    //TODO
    private void remove(final I data, final BstNode<I> node) {
        if (!search(data, node)) throw new IllegalArgumentException("Invalid data");
    }


    final boolean search(final I data) {
        return search(data, mBstNode);
    }

    @Contract("_, null -> false")
    private boolean search(final I data, final BstNode<I> node) {
        if (node == null) return false;
        if (node.getData() == data)
            return true;
        if ((Integer) node.getData() > (Integer) data)
            return search(data, node.getLeftNode());
        return search(data, node.getRightNode());
    }


    final I getMin() {
        return getMin(mBstNode);
    }

    private I getMin(@NotNull final BstNode<I> node) {
        if (node.getLeftNode() == null) return node.getData();
        return getMin(node.getLeftNode());
    }

    final I getMax() {
        return getMax(mBstNode);
    }

    private I getMax(@NotNull final BstNode<I> node) {
        if (node.getRightNode() == null) return node.getData();
        return getMax(node.getRightNode());
    }

    final int getHeight() {
        return getHeight(mBstNode);
    }

    private int getHeight(final BstNode<I> node) {
        if (node == null) return 0;
        return getMax(1 + getHeight(node.getLeftNode()), 1 + getHeight(node.getRightNode()));
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

    final int getDepth(final I data) {
        return getDepth(mBstNode, data);
    }

    private int getDepth(@NotNull final BstNode<I> root, final I data) {
        if (root.getData() == data) return 1;
        if ((Integer) data < (Integer) root.getData()) return 1 + getDepth(root.getLeftNode(), data);
        return 1 + getDepth(root.getRightNode(), data);
    }

    final I[] toArray() {
        return toArray(mBstNode);
    }

    //TODO
    @Nullable
    private I[] toArray(final BstNode<I> node) {
        if (!isComplete(node)) throw new IllegalArgumentException("Incomplete binary search tree");
        return null;
    }

    final I[] toInorder() {
        return toInorder(mBstNode);
    }

    //TODO
    @Nullable
    private I[] toInorder(final BstNode<I> node) {
        if (!isComplete(node)) throw new IllegalArgumentException("Incomplete binary search tree");
        return null;
    }

    final I[] toPreOrder() {
        return toPreOrder(mBstNode);
    }

    //TODO
    @Nullable
    private I[] toPreOrder(final BstNode<I> node) {
        if (!isComplete(node)) throw new IllegalArgumentException("Incomplete binary search tree");
        return null;
    }

    final I[] toPostOrder() {
        return toPostOrder(mBstNode);
    }

    //TODO
    @Nullable
    private I[] toPostOrder(final BstNode<I> node) {
        if (!isComplete(node)) throw new IllegalArgumentException("Incomplete binary search tree");
        return null;
    }


    final I[] toLevelOrder() {
        return toLevelOrder(mBstNode);
    }

    //TODO
    @Nullable
    private I[] toLevelOrder(final BstNode<I> node) {
        if (!isComplete(node)) throw new IllegalArgumentException("Incomplete binary search tree");
        return null;
    }


    final boolean isComplete() {
        return isComplete(mBstNode);
    }

    //TODO
    @Contract("null -> true")
    private boolean isComplete(final BstNode<I> root) {
        if (root == null) return true;
        if (!isLeafNode(root, root.getData())) {
            if (root.getLeftNode() == null && root.getRightNode() != null) {
                return false;
            }
        }
        return isComplete(root.getLeftNode()) && isComplete(root.getRightNode());
    }

    final int getNoOfElements() {
        return getNoOfElements(mBstNode);
    }

    private int getNoOfElements(final BstNode<I> node) {
        if (node == null) return 0;
        return 1 + getNoOfElements(node.getLeftNode()) + getNoOfElements(node.getRightNode());
    }


    final boolean isLeafNode(final I data) {
        return isLeafNode(mBstNode, data);
    }

    private boolean isLeafNode(final BstNode<I> root, final I data) {
        BstNode<I> node = getNodeFromData(root, data);
        return node.getLeftNode() == null && node.getRightNode() == null;
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

    final void display() {
        display(mBstNode);
    }

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