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

package datastructure.tree;

import org.jetbrains.annotations.NotNull;

/**
 * @param <T>
 */
//TODO
class Tree<T> {

    private TreeNode<T> mRoot;

    /**
     * Insert an element in tree as a child of given element
     *
     * @param data the data to inserted
     * @param node the node on which the data has to be inserted
     */
    final void insert(final T data, final T node) {
        //TODO
    }

    /**
     * Returns a new node
     *
     * @param data the data for new node
     * @return new node
     */
    @NotNull
    private TreeNode<T> createNode(final T data) {
        return new TreeNode<>(data, null);
    }

    /**
     * Deletes a given element from tree
     *
     * @param data the data to be deleted
     */
    final void delete(final T data) {
        //TODO
    }

    /**
     * Returns a node which holds the given data
     *
     * @param data the data
     * @return the node which holds the data
     */
    private TreeNode<T> getNodeFromData(final T data) {
        //TODO
        return null;
    }

    /**
     * Search a given element in tree
     *
     * @param data the data to be searched
     * @return true if data is found else !true
     */
    final boolean search(final T data) {
        //TODO
        return true;
    }

    /**
     * displays the content of tree
     */
    final void display() {
        //TODO
    }
}
