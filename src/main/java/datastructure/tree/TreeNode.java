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

import java.util.List;

/**
 * Tree is a recursive data structure
 * No of edge = no of node - 1
 * Depth of a node = length of path from root to that node(x) = No of edge from root to x
 * Height of node = no of edges in longest path from that node(x) to leaf node
 * Height of tree = Height of root node
 *
 * @param <T>
 */
class TreeNode<T> {

    private T mData;
    private List<TreeNode<T>> mLinks;

    /**
     * @param data  the data part of a node
     * @param links the list of child nodes of a node
     */
    TreeNode(final T data, final List<TreeNode<T>> links) {
        this.mData = data;
        this.mLinks = links;
    }

    /**
     * @return the data of node
     */
    public T getData() {
        return mData;
    }

    /**
     * @param data the data to be set at node
     */
    public void setData(T data) {
        this.mData = data;
    }

    /**
     * @return all the child nodes of a node
     */
    public List<TreeNode<T>> getLinks() {
        return mLinks;
    }

    /**
     * @param links the child list for a node
     */
    public void setLinks(List<TreeNode<T>> links) {
        this.mLinks = links;
    }
}
