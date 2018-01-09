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

import org.jetbrains.annotations.NotNull;

/**
 * the building block of binary search tree
 * where mData is the value of node and
 * mLeftNode & mRightNode are the left and right
 * branches of the node respectively.
 *
 * @param <T> Generic to be replaced by any object
 */
class BstNode<T> {

    private T mData;
    private BstNode<T> mLeftNode, mRightNode;

    /**
     * @param data      the data part of the node
     * @param leftNode  the left link of the node
     * @param rightNode the right link of the node
     */
    BstNode(final T data, final BstNode<T> leftNode, final BstNode<T> rightNode) {
        this.mData = data;
        this.mLeftNode = leftNode;
        this.mRightNode = rightNode;
    }

    //TODO
    BstNode(@NotNull final Builder<T> builder) {
        this.mData = builder.mData;
        this.mLeftNode = builder.mLeftNode;
        this.mRightNode = builder.mRightNode;
    }

    /**
     * @return data of the node
     */
    public T getData() {
        return mData;
    }

    /**
     * @param data the new data of the node
     */
    public void setData(final T data) {
        this.mData = data;
    }

    /**
     * @return left link of the node
     */
    public BstNode<T> getLeftNode() {
        return mLeftNode;
    }

    /**
     * @param leftNode new left link for the node
     */
    public void setLeftNode(final BstNode<T> leftNode) {
        this.mLeftNode = leftNode;
    }

    /**
     * @return right link of the node
     */
    public BstNode<T> getRightNode() {
        return mRightNode;
    }

    /**
     * @param rightNode new right link of the node
     */
    public void setRightNode(final BstNode<T> rightNode) {
        this.mRightNode = rightNode;
    }

    //TODO
    static class Builder<T> {
        private T mData;
        private BstNode<T> mLeftNode, mRightNode;

        Builder setData(T data) {
            this.mData = data;
            return this;
        }

        Builder setLeftNode(BstNode<T> leftNode) {
            this.mLeftNode = leftNode;
            return this;
        }

        Builder setRightNode(BstNode<T> rightNode) {
            this.mRightNode = rightNode;
            return this;
        }

        BstNode<T> build() {
            return new BstNode<>(this);
        }
    }
}
