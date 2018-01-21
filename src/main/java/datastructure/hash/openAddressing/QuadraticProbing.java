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

public class QuadraticProbing {

    private final Integer quadraticArray[] = new Integer[MapInterface.DEFAULT_HASH_TABLE_SIZE];

    /**
     * @param key
     * @param integer
     */
    void put(final String key, final Integer integer) {
        final int index = getIndex(getHash(key));
        if (quadraticArray[index] == null || quadraticArray[index].equals(DELETED_INDICATION))
            quadraticArray[index] = integer;
        else putQuadratic(integer, index, index + 1, MapInterface.DEFAULT_HASH_TABLE_SIZE);
    }

    /**
     * @param integer
     * @param start
     * @param index
     * @param size
     */
    private void putQuadratic(final Integer integer, final Integer start, @NotNull Integer index, final Integer size) {
        if (index.equals(start)) return;
        if (index > start || index.equals(size)) index = 0;
        if (quadraticArray[index] == null) {
            quadraticArray[index] = integer;
            return;
        }
        putQuadratic(integer, start, (int) Math.pow(index, 2), size);
    }

    /**
     * @param key
     * @return
     */
    Integer get(final String key) {
        return quadraticArray[getIndex(getHash(key))];
    }

    /**
     * @param key
     */
    void remove(final String key) {
        quadraticArray[getIndex(getHash(key))] = DELETED_INDICATION;
    }

}