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
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Utility class for open addressing hashing technique
 */
class OpenAddressingUtil {

    static final Integer DELETED_INDICATION = Integer.MIN_VALUE;

    static final Integer PRIME_CONSTANT = 101;

    /**
     * Returns the hash code for a given key
     *
     * @param string the key
     * @return the hash code
     */
    static Integer getHash(final String string) {
        return getHashUtil(string, string.length(), 0, 0);
    }

    /**
     * Returns the hash code for a given key
     * <p>
     * Used in double hashing
     *
     * @param string the key
     * @return the hash code
     */
    static Integer getHash2(final String string) {
        return getHashUtil2(string, string.length(), 0, 0);
    }

    /**
     * Returns the hash code for a given key
     *
     * @param string       the key
     * @param stringLength length of key
     * @param hashCode     the empty hash code
     * @param index        the start index of key
     * @return the hash code
     */
    private static Integer getHashUtil(final String string, final Integer stringLength, final Integer hashCode, @NotNull final Integer index) {
        if (index.equals(stringLength)) return hashCode;
        return (string.charAt(index) + (int) Math.pow(PRIME_CONSTANT, index)) + getHashUtil(string, stringLength, hashCode, index + 1);
    }

    /**
     * Returns the hash code for a given key
     * <p>
     * Used in double hashing
     *
     * @param string       the key
     * @param stringLength length of key
     * @param hashCode     the empty hash code
     * @param index        the start index of key
     * @return the hash code
     */
    private static Integer getHashUtil2(final String string, final Integer stringLength, final Integer hashCode, @NotNull final Integer index) {
        if (index.equals(stringLength)) return hashCode;
        return (string.charAt(index) + (int) Math.pow(PRIME_CONSTANT, index * 2)) + getHashUtil(string, stringLength, hashCode, index + 1);
    }

    /**
     * Returns an index from given hash code
     *
     * @param hashCode the hash code
     * @return index
     */
    @NotNull
    @Contract(pure = true)
    static Integer getIndex(final Integer hashCode) {
        return Math.abs(hashCode % MapInterface.DEFAULT_HASH_TABLE_SIZE);
    }

}