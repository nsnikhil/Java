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
public class DynamicIntegerArray {

    private int mSize;
    private int mIndex = 0;
    private Integer[] mArray;

    /**
     *
     */
    public DynamicIntegerArray() {
        this(10);
    }

    /**
     * @param size
     */
    DynamicIntegerArray(final Integer size) {
        mSize = size;
        mArray = new Integer[size];
    }

    /**
     * @param data
     */
    public final void add(final int data) {
        if (mIndex >= mSize) increaseSize();
        mArray[mIndex] = data;
        ++mIndex;
    }

    /**
     *
     */
    private void increaseSize() {
        mSize = mSize * 2;
        mArray = copyElements(mArray, new Integer[mSize]);
    }

    /**
     * @param oldArray
     * @param newArray
     * @return
     */
    private Integer[] copyElements(final Integer[] oldArray, final Integer[] newArray) {
        return copyElements(oldArray, newArray, 0);
    }

    /**
     * @param oldArray
     * @param newArray
     * @param index
     * @return
     */
    private Integer[] copyElements(@NotNull final Integer[] oldArray, final Integer[] newArray, final Integer index) {
        if (oldArray.length == index) return newArray;
        newArray[index] = oldArray[index];
        return copyElements(oldArray, newArray, index + 1);
    }

    /**
     * @param index
     * @return
     */
    @Contract(pure = true)
    public final Integer get(final Integer index) {
        if (index < 0 || index > mIndex) throw new IllegalArgumentException("Invalid index " + index);
        return mArray[index];
    }

    /**
     * @param data
     * @param index
     */
    public final void set(final Integer data, final Integer index) {
        if (index > mIndex) throw new IllegalArgumentException("Invalid index " + index);
        mArray[index] = data;
    }

    /**
     * @param data
     * @return
     */
    public final boolean search(Integer data) {
        return new BinarySearch().search(copyElements(mArray, new Integer[mSize], 0), data);
    }


    /**
     * @param data
     */
    public final void remove(final Integer data) {
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
    private void removeElement(final Integer ar[], final Integer deleteIndex) {
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
    private int getIndex(final Integer[] ar, final Integer data, final Integer index) {
        if (index > mIndex) return index;
        if (ar[index].equals(data)) return index;
        return getIndex(ar, data, index + 1);
    }

    /**
     *
     */
    public final void display() {
        display(mArray, 0, mIndex);
    }

    /**
     * @param array
     * @param index
     * @param size
     */
    private void display(final Integer[] array, final Integer index, @NotNull final Integer size) {
        if (size.equals(index)) return;
        System.out.print(array[index] + " ");
        display(array, index + 1, size);
    }
}