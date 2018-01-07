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
    void insert(T data, T node) {
        TreeNode<T> temp = new TreeNode<>(data, null);
        if (mRoot == null) {
            mRoot = temp;
            return;
        }
    }

    /**
     * Deletes a given element from tree
     *
     * @param data the data to be deleted
     */
    void delete(T data) {

    }

    /**
     * Search a given element in tree
     *
     * @param data the data to be searched
     * @return true if data is found else !true
     */
    boolean search(T data) {
        return false;
    }

    /**
     * displays the content of tree
     */
    void display() {

    }
}
