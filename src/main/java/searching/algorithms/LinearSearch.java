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

package searching.algorithms;

import org.jetbrains.annotations.NotNull;

/**
 * Implementation of linear search algorithm
 */
public class LinearSearch implements Searcher {

    /**
     * Pathetic Algorithm no documentation needed
     *
     * @param ar the original array
     * @param n  the value to be searched
     * @return true if value if searched
     */
    @Override
    public boolean search(final Integer[] ar, final Integer n) {
        return search(ar, n, 0);
    }

    /**
     * @param ar    the array
     * @param n     the element to search
     * @param index the starting index of array
     * @return true of given element is found else !true
     */
    private boolean search(@NotNull final Integer ar[], final Integer n, final Integer index) {
        return ar.length != index && (ar[index].equals(n) || search(ar, n, index + 1));
    }
}
