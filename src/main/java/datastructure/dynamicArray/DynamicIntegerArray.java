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

package datastructure.dynamicArray;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import searching.algorithms.BinarySearch;

/**
 *
 */
class DynamicIntegerArray {

    private int mSize;
    private int mIndex = 0;
    private int[] mArray;

    /**
     *
     */
    DynamicIntegerArray() {
        this(10);
    }

    /**
     * @param size
     */
    DynamicIntegerArray(final int size) {
        mSize = size;
        mArray = new int[size];
    }

    /**
     * @param data
     */
    final void add(final int data) {
        if (mIndex >= mSize) increaseSize();
        mArray[mIndex] = data;
        ++mIndex;
    }

    /**
     *
     */
    private void increaseSize() {
        mSize = mSize * 2;
        mArray = copyElements(mArray, new int[mSize]);
    }

    /**
     * @param oldArray
     * @param newArray
     * @return
     */
    private int[] copyElements(final int[] oldArray, final int[] newArray) {
        return copyElements(oldArray, newArray, 0);
    }

    /**
     * @param oldArray
     * @param newArray
     * @param index
     * @return
     */
    private int[] copyElements(@NotNull final int[] oldArray, final int[] newArray, final int index) {
        if (oldArray.length == index) return newArray;
        newArray[index] = oldArray[index];
        return copyElements(oldArray, newArray, index + 1);
    }

    /**
     * @param index
     * @return
     */
    @Contract(pure = true)
    final int get(final int index) {
        if (index < 0 || index > mIndex) throw new IllegalArgumentException("Invalid index " + index);
        return mArray[index];
    }

    /**
     * @param data
     * @param index
     */
    final void set(final int data, final int index) {
        if (index > mIndex) throw new IllegalArgumentException("Invalid index " + index);
        mArray[index] = data;
    }

    /**
     * @param data
     * @return
     */
    final boolean search(int data) {
        return new BinarySearch().search(copyElements(mArray, new int[mSize], 0), data);
    }


    /**
     * @param data
     */
    final void remove(final int data) {
        if (!search(data)) throw new IllegalArgumentException("Invalid element " + data);
        final int index = getIndex(mArray, data, 0);
        if (index == mSize - 1)
            mArray[index] = 0;
        else
            removeElement(mArray, index);
        --mIndex;
    }

    /**
     * @param ar
     * @param deleteIndex
     */
    private void removeElement(final int ar[], final int deleteIndex) {
        if (deleteIndex >= mIndex) return;
        ar[deleteIndex] = ar[deleteIndex + 1];
        removeElement(ar, deleteIndex + 1);
    }

    /**
     * @param ar
     * @param data
     * @param index
     * @return
     */
    private int getIndex(final int[] ar, final int data, final int index) {
        if (index > mIndex) return index;
        if (ar[index] == data) return index;
        return getIndex(ar, data, index + 1);
    }

    /**
     *
     */
    final void display() {
        display(mArray, 0, mIndex);
    }

    /**
     * @param array
     * @param index
     * @param size
     */
    private void display(final int[] array, final int index, final int size) {
        if (size == index) return;
        System.out.print(array[index] + " ");
        display(array, index + 1, size);
    }
}