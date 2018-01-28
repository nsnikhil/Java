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

/**
 * Interface defining the map interface
 *
 * @param <K> the key
 * @param <V> the value
 */
public interface MapInterface<K, V> {
    Integer DEFAULT_HASH_TABLE_SIZE = 16;

    void put(final K key, final V data);

    V get(final K key);

    Integer getHashCode(final K key);

    Integer getIndex(final Integer hashCode);
}
