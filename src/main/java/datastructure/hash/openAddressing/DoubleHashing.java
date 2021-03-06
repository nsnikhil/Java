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

package datastructure.hash.openAddressing;

import datastructure.hash.chaining.MapInterface;
import org.jetbrains.annotations.NotNull;

import static datastructure.hash.openAddressing.OpenAddressingUtil.*;

/**
 * Double hashing
 * <p>
 * The value are stored directly in hash table.
 * Hash value and then index are calculated for
 * each key and then data is stored directly
 * in hash table at index obtained only if the cell
 * at given index is empty else we check for
 * next cells and keep checking until an
 * empty one is found.
 * <p>
 * Since two hash functions are used to calculate
 * the index this method is called double hashing
 */
public class DoubleHashing {

    private final Integer doubleHashing[] = new Integer[MapInterface.DEFAULT_HASH_TABLE_SIZE];

    /**
     * Stores data in hash table
     * <p>
     * Algorithm:
     * Check if the value at obtained index
     * is null or marked deleted then store
     * he value at obtained index else increment
     * by double hash function an empty cell is found
     * where the value can be stored
     *
     * @param key     the key
     * @param integer the value to be stored
     */
    void put(final String key, final Integer integer) {
        final int index = getIndex(getHash(key));
        if (doubleHashing[index] == null || doubleHashing[index].equals(DELETED_INDICATION))
            doubleHashing[index] = integer;
        else putDoubleHashing(key, integer, index, index + 1, MapInterface.DEFAULT_HASH_TABLE_SIZE);
    }

    /**
     * Stores data in hash table
     * <p>
     * Check until you find a empty spot
     * if you reach end of table
     * start from 0 and try till you reach the
     * original index and still you couldn't find
     * any empty index then table is full
     *
     * @param integer the value to be stored
     * @param start   the original index obtained
     * @param index   the next index
     * @param size    the size of hash table
     */
    private void putDoubleHashing(final String key, final Integer integer, final Integer start, @NotNull Integer index, final Integer size) {
        if (index.equals(start)) return;
        if (index > start || index.equals(size)) index = 0;
        if (doubleHashing[index] == null) {
            doubleHashing[index] = integer;
            return;
        }
        putDoubleHashing(key, integer, start, index * getHash2(key), size);
    }

    /**
     * Returns data for given key
     *
     * @param key the key
     * @return data for given key
     */
    Integer get(final String key) {
        return doubleHashing[getIndex(getHash(key))];
    }

    /**
     * Removes data for given key
     *
     * @param key the key
     */
    void remove(final String key) {
        doubleHashing[getIndex(getHash(key))] = DELETED_INDICATION;
    }

}
