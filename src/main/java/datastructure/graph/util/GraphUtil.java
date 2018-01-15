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

package datastructure.graph.util;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class GraphUtil {

    /**
     *
     */
    public static final String CHARACTER_INPUT = "Enter the vertex name";

    /**
     * @param vertex
     * @param vertexList
     * @return
     */
    public static int getVertexIndex(final Character vertex, final List<Character> vertexList) {
        return getVertexIndex(vertex, vertexList, 0, vertexList.size());
    }

    /**
     * @param vertex
     * @param vertexList
     * @param index
     * @param size
     * @return
     */
    private static int getVertexIndex(final Character vertex, final List<Character> vertexList, final int index, final int size) {
        if (size == index) return index;
        if (vertexList.get(index).equals(vertex)) return index;
        return getVertexIndex(vertex, vertexList, index + 1, size);
    }

    /**
     * @param index
     * @param vertexList
     * @return
     */
    @Contract(pure = true)
    public static Character[] getNodesFromIndex(@NotNull final Integer[] index, @NotNull final List<Character> vertexList) {
        return getNodesFromIndex(index, index.length, vertexList, new Character[index.length], 0);
    }


    /**
     * @param indexes
     * @param size
     * @param vertexList
     * @param charArray
     * @param index
     * @return
     */
    private static Character[] getNodesFromIndex(final Integer[] indexes, final int size, @NotNull final List<Character> vertexList, final Character[] charArray, final int index) {
        if (size == index || indexes[index] == null) return charArray;
        charArray[index] = vertexList.get(indexes[index]);
        return getNodesFromIndex(indexes, size, vertexList, charArray, index + 1);
    }

    /**
     * @param ar
     */
    public static void print(@NotNull Character[] ar) {
        print(ar, ar.length, 0);
    }

    /**
     * @param ar
     * @param size
     * @param index
     */
    private static void print(final Character[] ar, final int size, final int index) {
        if (size == index) return;
        if (ar[index] != null) System.out.print(ar[index] + " ");
        print(ar, size, index + 1);
    }

}
