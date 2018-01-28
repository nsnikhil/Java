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

package datastructure.hash.chaining;

import datastructure.linkedlist.LinkedList;
import org.jetbrains.annotations.NotNull;

/**
 * Implementation of a map
 */
public class MyHashMap implements MapInterface<String, Integer> {

    /**
     * Prime constant used to calculate hash value
     */
    private static final Integer CONSTANT = 101;

    /**
     * Array of linked list where each linked list
     * is pointed from hash table
     */
    private LinkedList<Integer>[] mHashList;

    /**
     *
     */
    @SuppressWarnings("unchecked")
    MyHashMap() {
        mHashList = new LinkedList[16];
    }

    /**
     * @param key  the key
     * @param data the data
     */
    @Override
    public void put(final String key, final Integer data) {
        final int index = getIndex(getHashCode(key));
        if (mHashList[index] == null) mHashList[index] = new LinkedList<>();
        mHashList[index].insertLast(data);

    }

    /**
     * @param key the key
     * @return the data for the given key
     */
    @Override
    public Integer get(final String key) {
        return mHashList[getIndex(getHashCode(key))].getLast();
    }

    /**
     * @param key the key
     * @return the hash coe for the given key
     */
    @Override
    public Integer getHashCode(final String key) {
        return getHashCodeUtil(key, 0, key.length(), 0);
    }

    /**
     * Algorithm :
     * ascii value of first character * Prime Constant^Index of char in string +
     * ascii value of second character * Prime Constant^Index of char in string + .... to length of string
     * <p>
     * Eg :
     * abc
     * <p>
     * => 97 * 101^0 + 98 * 101^1 + 99 * 101^2
     * => 97*1 + 98 * 101 + 99 * 10201
     * => 97 + 9898 + 1009899
     * => 101984
     * <p>
     * 101984 is the hash code for abc
     *
     * @param key      the key
     * @param index    the starting point
     * @param size     the size of key
     * @param hashCode the hash code
     * @return hash code
     */
    private Integer getHashCodeUtil(final String key, @NotNull final Integer index, final Integer size, Integer hashCode) {
        if (index.equals(size)) return hashCode;
        return key.charAt(index) * (int) Math.pow(CONSTANT, index) + getHashCodeUtil(key, index + 1, size, hashCode);
    }

    /**
     * Returns the index at which the a given data
     * will be stored
     * <p>
     * Algorithm :
     * HashCode % Size of table
     * <p>
     * Eg :
     * => 101984 % 16
     * => 0
     * <p>
     * Hence a given data will be stored in 0th index
     * of hash table(or the first linked list)
     *
     * @param hashCode the has code
     * @return index at which the a given data
     * will be stored
     */
    @Override
    public Integer getIndex(final Integer hashCode) {
        return Math.abs(hashCode % MapInterface.DEFAULT_HASH_TABLE_SIZE);
    }
}
