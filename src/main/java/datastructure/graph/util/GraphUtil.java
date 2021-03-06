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

/**
 * Utility class that houses some
 * common graph functions
 */
public class GraphUtil {

    /**
     *
     */
    public static final String CHARACTER_INPUT = "Enter the vertex name";

    /**
     * Returns the index of the vertex
     * from a vertex list
     *
     * @param vertex     the vertex whose index is to be found
     * @param vertexList the vertex list
     * @return the index of vertex in vertex list
     */
    public static int getVertexIndex(final Character vertex, final List<Character> vertexList) {
        return getVertexIndexUtil(vertex, vertexList, 0, vertexList.size());
    }

    /**
     * Returns the index of the vertex
     * from a vertex list
     *
     * @param vertex     the vertex whose index is to be found
     * @param vertexList the vertex list
     * @param index      the starting point of search
     * @param size       the size of list
     * @return the index of vertex in vertex list
     */
    private static int getVertexIndexUtil(final Character vertex, final List<Character> vertexList, final int index, final int size) {
        if (size == index) return index;
        if (vertexList.get(index).equals(vertex)) return index;
        return getVertexIndexUtil(vertex, vertexList, index + 1, size);
    }

    /**
     * Returns an array of nodes(character)
     * from a given indexes and vertex list
     *
     * @param index      the indexes whose vertex is to be found
     * @param vertexList the vertex list
     * @return node(character) array
     */
    @Contract(pure = true)
    public static Character[] getNodesFromIndex(@NotNull final Integer[] index, @NotNull final List<Character> vertexList) {
        return getNodesFromIndexUtil(index, index.length, vertexList, new Character[index.length], 0);
    }


    /**
     * Returns an array of nodes(character)
     * from a given indexes and vertex list
     *
     * @param indexes    the indexes whose vertex is to be found
     * @param size       the size of indexes
     * @param vertexList the vertex list
     * @param charArray  the array which will be filled with value from vertex list
     * @param index      the starting point from list
     * @return node(character) array
     */
    private static Character[] getNodesFromIndexUtil(final Integer[] indexes, final int size, @NotNull final List<Character> vertexList, final Character[] charArray, final int index) {
        if (size == index || indexes[index] == null) return charArray;
        charArray[index] = vertexList.get(indexes[index]);
        return getNodesFromIndexUtil(indexes, size, vertexList, charArray, index + 1);
    }

    /**
     * Displays the given graph
     *
     * @param ar the graph
     */
    public static void print(@NotNull Character[] ar) {
        print(ar, ar.length, 0);
    }

    /**
     * Displays the given graph
     *
     * @param ar    the graph
     * @param size  the size of graph
     * @param index the starting index of display
     */
    private static void print(final Character[] ar, final int size, final int index) {
        if (size == index) return;
        if (ar[index] != null) System.out.print(ar[index] + " ");
        print(ar, size, index + 1);
    }

}
