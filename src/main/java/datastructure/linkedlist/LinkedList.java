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

package datastructure.linkedlist;

import exceptions.InValidPositionException;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * //COMMENTS NEEDS TO BE CHANGED FOR EVERY CLASS OF THE PROJECT
 *
 * @param <T> Generic to be replaced with any object sub class
 * @author Nikhil Soni
 * @version 1.0
 * @since 29-12-2017
 */
public class LinkedList<T> {

    private Node<T> mRoot;

    /**
     * Insert the node at beginning of list
     * <p>
     * If the list is empty assign root as
     * the new node else set the new node link to
     * be root and then assign the new node as root.
     *
     * @param data the value to be inserted in list
     */
    public final void insertFirst(final T data) {
        final Node<T> temp = createNewNode(data);
        if (mRoot == null) {
            mRoot = temp;
            return;
        }
        temp.setNode(mRoot);
        mRoot = temp;

    }

    /**
     * Insert element at the end of list
     * <p>
     * If the root is null the new node is assigned to root
     * else iterate until you reach the last node and then
     * set the node of the lost node to newly created
     * node.
     *
     * @param data the data to be inserted
     */
    public final void insertLast(final T data) {
        final Node<T> temp = createNewNode(data);
        if (mRoot == null) {
            mRoot = temp;
            return;
        }
        insertLast(mRoot, temp);
    }

    /**
     * @param node
     * @param newNode
     */
    private void insertLast(@NotNull final Node<T> node, final Node<T> newNode) {
        if (node.getNode() == null) {
            node.setNode(newNode);
            return;
        }
        insertLast(node.getNode(), newNode);
    }

    /**
     * Insert element at specified position
     * <p>
     * If root is null assign the new node to root
     * else if position is 1 insert at beginning
     * else if position is equal to size insert at end
     * else iterate to the position and first store the next node
     * and then set the node link to new node and then set the link
     * of new node to the stored node
     * <p>
     * Eg -> 5,6,8,9 insert 7 at 3
     * <p>
     * iterate up-to 6 and store 8 in x
     * set 6->link = 7 and 7->link = x
     * and finally you have 5,6,7,8,9
     *
     * @param position the position at which the element is to be inserted
     * @param data     the element
     */
    public final void insertAtPosition(final int position, final T data) {
        if (position > getSize()) throw new InValidPositionException(position);
        final Node<T> temp = createNewNode(data);
        if (mRoot == null) {
            mRoot = temp;
            return;
        }
        if (position == 0) {
            insertFirst(data);
            return;
        }
        if (position == getSize()) {
            insertLast(data);
            return;
        }
        insertAtPosition(mRoot, temp, position);
    }

    /**
     * @param node
     * @param newNode
     * @param position
     */
    private void insertAtPosition(final Node<T> node, final Node<T> newNode, final int position) {
        if (position == 1) {
            newNode.setNode(node.getNode());
            node.setNode(newNode);
            return;
        }
        insertAtPosition(node.getNode(), newNode, position - 1);
    }

    /**
     * Creates a new node
     *
     * @param data the value to be put in node
     * @return new node with data and pointing to null
     */
    @NotNull
    private Node<T> createNewNode(final T data) {
        return new Node<>(data, null);
    }

    /**
     * Delete the first element
     * <p>
     * Delete the first element but setting the
     * root link to point subsequent node.
     */
    public final void deleteFirst() {
        nullCheck();
        mRoot = mRoot.getNode();
    }

    /**
     * Delete the last element
     * <p>
     * Iterate to 2nd last element and
     * set its node/link to point ot null.
     */
    public final void deleteLast() {
        nullCheck();
        deleteLast(mRoot);
    }

    /**
     *
     * @param node
     */
    private void deleteLast(@NotNull final Node<T> node) {
        if (node.getNode().getNode() == null) {
            node.setNode(null);
            return;
        }
        deleteLast(node.getNode());
    }

    /**
     * Delete element at given position
     * <p>
     * if position = 1 delete from first
     * else if position is equal to size delete from end
     * else iterate up-to position-1 and set its link to
     * point to next to next node.
     * <p>
     * Eg -> 5,7,3,8,9 delete from position 3
     * iterate up-to 7 and set
     * 7->setLink = 7->getLink->getLink(which is 8 in this case)
     * and finally you have 5,7,8,9.
     *
     * @param position the position at which you want to delete the node
     */
    public final void deleteAtPosition(final int position) {
        nullCheck();
        if (position >= getSize()) throw new InValidPositionException(position);
        if (position == 0) {
            deleteFirst();
            return;
        }
        if (position == getSize() - 1) {
            deleteLast();
            return;
        }
        deleteAtPosition(mRoot, position);
    }

    /**
     *
     * @param node
     * @param position
     */
    private void deleteAtPosition(final Node<T> node, final int position) {
        if (position == 1) {
            node.setNode(node.getNode().getNode());
            return;
        }
        deleteAtPosition(node.getNode(), position - 1);
    }

    /**
     * Delete a given element
     * <p>
     * Iterate until you reach the element to whose link
     * is the element you want to delete, then set the link
     * of that element to point to next to next element
     * <p>
     * Eg -> 5,7,8,9 delete 8
     * iterate till 7 and then set
     * 7->setLink = 7->getLink->getLink(which is 9 in this case)
     * finally we have 5,7,9
     *
     * @param data the element to be deleted
     */
    public final void deleteItem(final T data) {
        nullCheck();
        if (!searchByItem(data)) throw new IllegalArgumentException("Invalid data " + data);
        deleteItem(mRoot, data);
    }

    /**
     *
     * @param node
     * @param data
     */
    private void deleteItem(@NotNull final Node<T> node, final T data) {
        if (node.getNode().getData() == data) {
            node.setNode(node.getNode().getNode());
            return;
        }
        deleteItem(node.getNode(), data);
    }

    /**
     * Gets the first element of the list
     *
     * @return the first element of the list
     */
    public final T getFirst() {
        nullCheck();
        return mRoot.getData();
    }

    /**
     * Gets the last element of the list
     * <p>
     * iterate until last node is reached and
     * then return its data.
     *
     * @return the last element of the list
     */
    public final T getLast() {
        nullCheck();
        return getLast(mRoot);
    }

    /**
     *
     * @param node
     * @return
     */
    private T getLast(@NotNull final Node<T> node) {
        if (node.getNode() == null) return node.getData();
        return getLast(node.getNode());
    }

    /**
     * Gets the element at specified position
     * <p>
     * If position = 1 get the first item
     * else if position == size get the last element
     * else iterate till position and return the data of the node
     *
     * @param position the position at which you want to get the item
     * @return the item
     */
    public final T getAtPosition(final int position) {
        nullCheck();
        if (position >= getSize()) throw new InValidPositionException(position);
        if (position == 0) return getFirst();
        if (position == getSize() - 1) getLast();
        return getAtPosition(mRoot, position);
    }

    /**
     *
     * @param node
     * @param position
     * @return
     */
    private T getAtPosition(final Node<T> node, final int position) {
        if (position == 0) return node.getData();
        return getAtPosition(node.getNode(), position - 1);
    }

    /**
     * Search a specific item
     * <p>
     * iterate till end comparing each item and return true as soon
     * as you find the ite,
     *
     * @param data the item to be searched
     * @return true if item is present else !true
     */
    public final boolean searchByItem(final T data) {
        nullCheck();
        return searchByItem(mRoot, data);
    }

    /**
     *
     * @param node
     * @param data
     * @return
     */
    @Contract("null, _ -> false")
    private boolean searchByItem(final Node<T> node, final T data) {
        return node != null && (node.getData().equals(data) || searchByItem(node.getNode(), data));
    }

    /**
     * Gets the element index in list
     * <p>
     * iterate until you find the element and also
     * increment the counter and return the counter as
     * soon as you find the element
     *
     * @param data the item whose position you want
     * @return the position of item
     */
    public final int getItemPosition(final T data) {
        nullCheck();
        if (!searchByItem(data)) return -1;
        return getItemPosition(mRoot, data);
    }

    /**
     *
     * @param node
     * @param data
     * @return
     */
    private int getItemPosition(@NotNull final Node<T> node, final T data) {
        if (node.getData().equals(data)) return 0;
        return 1 + getItemPosition(node.getNode(), data);
    }

    /**
     * Print of data of each node till end
     */
    public final void display() {
        display(mRoot);
    }

    /**
     *
     * @param node
     */
    private void display(final Node<T> node) {
        if (node == null) return;
        System.out.print(node.getData() + " ");
        display(node.getNode());
    }

    /**
     * @return the size of list
     */
    public final int getSize() {
        return getSize(mRoot);
    }

    /**
     *
     * @param node
     * @return
     */
    private int getSize(final Node<T> node) {
        if (node == null) return 0;
        return 1 + getSize(node.getNode());
    }

    /**
     * @return true if list is empty else !true
     */
    @Contract(pure = true)
    public final boolean isEmpty() {
        return mRoot == null;
    }

    /**
     * throw a null pointer exception if list is null
     */
    private void nullCheck() {
        if (mRoot == null) throw new NullPointerException("List is null");
    }
}