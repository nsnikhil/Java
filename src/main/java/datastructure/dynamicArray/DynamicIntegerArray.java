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
 * Implementation of dynamic array
 * <p>
 * an internal array and counter is used to
 * maintain the stare of array for addition or
 * removal of elements.
 */
public class DynamicIntegerArray {

    /**
     * the size of a the array
     */
    private int mSize;

    /**
     * the element until mIndex in the array
     * are considered to be elements present in
     * dynamic array, it is also used to keep the
     * record of size of array while adding or
     * removing elements
     */
    private int mIndex = 0;

    /**
     * the array
     */
    private Integer[] mArray;

    /**
     * Empty constructor initializes array with size 10
     */
    DynamicIntegerArray() {
        this(10);
    }

    /**
     * dynamic array constructor initializes array
     * with given size
     *
     * @param size the size of array
     */
    DynamicIntegerArray(final Integer size) {
        mSize = size;
        mArray = new Integer[size];
    }

    /**
     * Adds new element in array
     * <p>
     * Algorithm :
     * If the index of array is greater than
     * or equals to size then increase the
     * size by 2 and double the array space
     * and then insert the new element in array
     *
     * @param data the element to add
     */
    public final void add(final int data) {
        if (mIndex >= mSize) increaseSize();
        mArray[mIndex] = data;
        ++mIndex;
    }

    /**
     * increases the size of array by 2
     * its does this by creating a new array
     * of double the size of original and
     * copying the content of original array to
     * new array created
     */
    private void increaseSize() {
        mSize = mSize * 2;
        mArray = copyElements(mArray, new Integer[mSize]);
    }

    /**
     * Copies element from a given array to another array
     *
     * @param oldArray the array from element has to be copied
     * @param newArray the array where the element has to be copied
     * @return the new array after elements have been copied from old
     */
    private Integer[] copyElements(final Integer[] oldArray, final Integer[] newArray) {
        return copyElementsUtil(oldArray, newArray, 0);
    }

    /**
     * Copies element from a given array to another array
     *
     * @param oldArray the array from element has to be copied
     * @param newArray the array where the element has to be copied
     * @param index    the point from where the array has to be copied
     * @return the new array after elements have been copied from old
     */
    private Integer[] copyElementsUtil(@NotNull final Integer[] oldArray, final Integer[] newArray, final Integer index) {
        if (oldArray.length == index) return newArray;
        newArray[index] = oldArray[index];
        return copyElementsUtil(oldArray, newArray, index + 1);
    }

    /**
     * Returns element at given index
     *
     * @param index the index at which element is required
     * @return a element from array at given index
     */
    @Contract(pure = true)
    public final Integer get(final Integer index) {
        if (index < 0 || index > mIndex) throw new IllegalArgumentException("Invalid index " + index);
        return mArray[index];
    }

    /**
     * Replaces data at given index with new value
     *
     * @param data  the new data/value
     * @param index the index at which swap is to be performed
     */
    public final void set(final Integer data, final Integer index) {
        if (index > mIndex) throw new IllegalArgumentException("Invalid index " + index);
        mArray[index] = data;
    }

    /**
     * Search a given element in the array
     *
     * @param data the element to be searched
     * @return true if element is found else !true
     */
    public final boolean search(Integer data) {
        return new BinarySearch().search(copyElementsUtil(mArray, new Integer[mSize], 0), data);
    }


    /**
     * Removes a given element from the array
     * <p>
     * Algorithm:
     * First search if element is present
     * then get the index at which the element
     * to be deleted is present if its the
     * last element decrease the index else
     * copy the value from next index to
     * previous index from point of deletion till
     * end and then decrement the index
     * <p>
     * Eg: 5,8,9,4,3,8
     * <p>
     * mIndex = 5
     * remove(9)
     * i = 2
     * copy elements from ar[i+1] to ar[i] ... till n
     * and finally we have
     * 5,8,4,3,8,8
     * set the last value as 0 and decrement the counter
     * the array remaining is
     * 5,8,4,3,8
     *
     * @param data the element to be removed
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
     * copies elements from deleteIndex+1 to deleteIndex ... till n
     * ar[i+1] to ar[i] ... till n
     *
     * @param ar          the array where the action is to be performed
     * @param deleteIndex the index from which the action has to be performed
     */
    private void removeElement(final Integer ar[], final Integer deleteIndex) {
        if (deleteIndex >= mIndex) return;
        ar[deleteIndex] = ar[deleteIndex + 1];
        removeElement(ar, deleteIndex + 1);
    }

    /**
     * Returns the index of a given element
     *
     * @param ar    the array
     * @param data  the element whose index is to be found out
     * @param index utility variable used for recursion
     * @return the index of given element
     */
    private int getIndex(final Integer[] ar, final Integer data, final Integer index) {
        if (index > mIndex) return index;
        if (ar[index].equals(data)) return index;
        return getIndex(ar, data, index + 1);
    }

    /**
     * displays the array
     */
    public final void display() {
        display(mArray, 0, mIndex);
    }

    /**
     * displays the array
     *
     * @param array the array to be displayed
     * @param index the starting point/index from where the array is to be displayed
     * @param size  the ending point/index till where the array is to be displayed
     */
    private void display(final Integer[] array, final Integer index, @NotNull final Integer size) {
        if (size.equals(index)) return;
        System.out.print(array[index] + " ");
        display(array, index + 1, size);
    }
}