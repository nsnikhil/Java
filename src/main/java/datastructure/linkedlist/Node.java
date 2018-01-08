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

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * The building block of linked list
 * where the mData is the item to stored
 * in list and mNode is pointer to next node.
 *
 * @param <T> generic to be replaced by any object
 */
public final class Node<T> {

    private T mData;
    private Node<T> mNode;

    Node(@NotNull Builder<T> builder) {
        this.mData = builder.mData;
        this.mNode = builder.mNode;
    }

    /**
     * @param data the data part of the node
     * @param node the pointer to next node
     */
    public Node(final T data, final Node<T> node) {
        mData = data;
        mNode = node;
    }

    /**
     * @return node
     */
    @Contract(pure = true)
    public Node<T> getNode() {
        return mNode;
    }

    /**
     * @param node new node
     */
    public void setNode(final Node<T> node) {
        this.mNode = node;
    }

    /**
     * @return data at the node
     */
    @Contract(pure = true)
    public T getData() {
        return mData;
    }

    /**
     * @param data the data of the node
     */
    public void setData(final T data) {
        this.mData = data;
    }

    //TODO
    static class Builder<T> {

        private T mData;
        private Node<T> mNode;

        public Builder setNode(Node<T> node) {
            this.mNode = node;
            return this;
        }

        public Builder setData(T data) {
            this.mData = data;
            return this;
        }

        public Node<T> build() {
            return new Node<>(this);
        }
    }
}